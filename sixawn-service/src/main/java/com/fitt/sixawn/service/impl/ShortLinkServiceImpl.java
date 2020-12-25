/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 FITT.Ltd. All rights reserved.                        *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fitt.sixawn.constants.SixawnConsts;
import com.fitt.sixawn.entity.ShortLink;
import com.fitt.sixawn.mapper.ShortLinkMapper;
import com.fitt.sixawn.service.ShortLinkService;
import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>@description 短链服务接口实现类 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-12-25
 */
@Service
public class ShortLinkServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLink> implements ShortLinkService {
    private static final Logger logger = LoggerFactory.getLogger(ShortLinkServiceImpl.class);

    @Override
    public ShortLink getByOriginLink(ShortLink shortLink) {
        // 1. 哈希函数
        shortLink.setStatus(SixawnConsts.STATUS_ONE);
        shortLink.setCreator(SixawnConsts.STATUS_MINUS_ONE.toString());
        shortLink.setCreated(DateUtil.date().getTime());
        shortLink.setModified(DateUtil.date().getTime());
        shortLink.setModifier(SixawnConsts.STATUS_MINUS_ONE.toString());

        this.genBriefLinkByHashCode(shortLink);

        return shortLink;
    }

    private void genBriefLinkByHashCode(ShortLink superLink) {
        int ret = 0;
        AtomicInteger counter = new AtomicInteger(0);
        // 如果失败，则自选三次进行 rehash，三次 rehash 后还错误则直接返回错误
        do {
            superLink.setBriefLink(String.valueOf(superLink.getOriginLink().hashCode() & Integer.MAX_VALUE));
            try {
                ret = baseMapper.insert(superLink);
            } catch (Exception e) {
                logger.error("[ShortLinkServiceImpl.getByOriginLink] save brief link to database occurred error.", e);
            }
            if (ret < 1) {
                superLink.setOriginLink(superLink.getOriginLink() + SixawnConsts.URL_DUPLICATE_STRING);
                superLink.setBriefLink(String.valueOf(superLink.getOriginLink().hashCode() & Integer.MAX_VALUE));
                counter.incrementAndGet();
            }
        } while (ret < 1 && counter.get() < 3);
    }

    private void genBriefLinkByMurMurHash(ShortLink superLink) {
        int ret = 0;
        AtomicInteger counter = new AtomicInteger(0);

        HashFunction hashFunction = Hashing.murmur3_32();

        // 如果失败，则自选三次进行 rehash，三次 rehash 后还错误则直接返回错误
        do {
            superLink.setBriefLink(hashFunction.hashString(superLink.getOriginLink(), Charsets.UTF_8).toString());

            try {
                ret = baseMapper.insert(superLink);
            } catch (Exception e) {
                logger.error("[ShortLinkServiceImpl.getByOriginLink] save brief link to database occurred error.", e);
            }
            if (ret < 1) {
                superLink.setOriginLink(superLink.getOriginLink() + SixawnConsts.URL_DUPLICATE_STRING);
                superLink.setBriefLink(hashFunction.hashString(superLink.getOriginLink(), Charsets.UTF_8).toString());
                counter.incrementAndGet();
            }
        } while (ret < 1 && counter.get() < 3);
    }
}
