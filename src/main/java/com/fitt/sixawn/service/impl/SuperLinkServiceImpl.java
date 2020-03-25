/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fitt.sixawn.consts.SixawnConsts;
import com.fitt.sixawn.entity.SuperLink;
import com.fitt.sixawn.mapper.SuperLinkMapper;
import com.fitt.sixawn.service.SuperLinkService;
import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>@description : 服务实现类 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
@Service
public class SuperLinkServiceImpl extends ServiceImpl<SuperLinkMapper, SuperLink> implements SuperLinkService {
    private static final Logger logger = LoggerFactory.getLogger(SuperLinkServiceImpl.class);

    @Override
    public SuperLink getByOriginLink(SuperLink superLink) {
        // 1. 哈希函数
        superLink.setStatus(SixawnConsts.STATUS_ONE);
        superLink.setCreator(SixawnConsts.STATUS_MINUS_ONE.toString());
        superLink.setCreated(DateUtil.date().getTime());
        superLink.setModified(DateUtil.date().getTime());
        superLink.setModifier(SixawnConsts.STATUS_MINUS_ONE.toString());

        genBriefLinkByHashCode(superLink);

        return superLink;
    }

    private void genBriefLinkByHashCode(SuperLink superLink) {
        int ret = 0;
        AtomicInteger counter = new AtomicInteger(0);
        // 如果失败，则自选三次进行 rehash，三次 rehash 后还错误则直接返回错误
        do {
            superLink.setBriefLink(String.valueOf(superLink.getOriginLink().hashCode() & Integer.MAX_VALUE));
            try {
                ret = baseMapper.insert(superLink);
            } catch (Exception e) {
                logger.error("[SuperLinkServiceImpl.getByOriginLink] save brief link to database occurred error.", e);
            }
            if (ret < 1) {
                superLink.setOriginLink(superLink.getOriginLink() + SixawnConsts.URL_DUPLICATE_STRING);
                superLink.setBriefLink(String.valueOf(superLink.getOriginLink().hashCode() & Integer.MAX_VALUE));
                counter.incrementAndGet();
            }
        } while (ret < 1 && counter.get() < 3);
    }

    private void genBriefLinkByMurMurHash(SuperLink superLink) {
        int ret = 0;
        AtomicInteger counter = new AtomicInteger(0);

        HashFunction hashFunction = Hashing.murmur3_32();

        // 如果失败，则自选三次进行 rehash，三次 rehash 后还错误则直接返回错误
        do {
            superLink.setBriefLink(hashFunction.hashString(superLink.getOriginLink(), Charsets.UTF_8).toString());

            try {
                ret = baseMapper.insert(superLink);
            } catch (Exception e) {
                logger.error("[SuperLinkServiceImpl.getByOriginLink] save brief link to database occurred error.", e);
            }
            if (ret < 1) {
                superLink.setOriginLink(superLink.getOriginLink() + SixawnConsts.URL_DUPLICATE_STRING);
                superLink.setBriefLink(hashFunction.hashString(superLink.getOriginLink(), Charsets.UTF_8).toString());
                counter.incrementAndGet();
            }
        } while (ret < 1 && counter.get() < 3);
    }
}
