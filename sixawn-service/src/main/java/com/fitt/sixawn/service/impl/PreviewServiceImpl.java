/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 fitt.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.service.impl;

import cn.hutool.core.io.FileUtil;
import com.fitt.sixawn.constants.ResultCodeEnum;
import com.fitt.sixawn.dto.ResultDTO;
import com.fitt.sixawn.service.PreviewService;
import lombok.extern.slf4j.Slf4j;
import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.document.DefaultDocumentFormatRegistry;
import org.jodconverter.core.office.OfficeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;

/**
 * <p>@description 文件预览服务实现类 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-10-13
 */
@Slf4j
@Service
public class PreviewServiceImpl implements PreviewService {
    @Value("${jodconverter.store.path}")
    private String storePath;

    @Resource
    private DocumentConverter documentConverter;

    @Override
    public ResultDTO convertPDF(File sourceFile, String fileExtension) {
        try {
            String fileName = FileUtil.getName(sourceFile);
            String targetFileExtension = "html".equalsIgnoreCase(fileExtension) ? fileExtension : "pdf";
            File targetFile = new File(storePath + File.separator + fileName + "." + targetFileExtension);
            documentConverter.convert(sourceFile)
                    .as(DefaultDocumentFormatRegistry.getFormatByExtension(fileExtension.toLowerCase()))
                    .to(targetFile)
                    .as(DefaultDocumentFormatRegistry.getFormatByExtension(targetFileExtension))
                    .execute();
            return ResultDTO.builder()
                    .code(ResultCodeEnum.SUCCESS.getCode())
                    .msg(ResultCodeEnum.SUCCESS.getMsg())
                    .data(targetFile.getName())
                    .build();
        } catch (OfficeException e) {
            return ResultDTO.builder()
                    .code(ResultCodeEnum.ERROR.getCode())
                    .msg(ResultCodeEnum.ERROR.getMsg())
                    .data(e.getMessage())
                    .build();
        }
    }

    @Override
    public ResultDTO convertPDF(InputStream in, String fileName, String fileExtension) {
        try {
            String targetFileExtension = StringUtils.isEmpty(fileExtension) ? "pdf" : fileExtension;
            File targetFile = new File(storePath + File.separator + fileName + "." + targetFileExtension);
            documentConverter.convert(in)
                    .as(DefaultDocumentFormatRegistry.getFormatByExtension(FileUtil.extName(fileName)))
                    .to(targetFile)
                    .as(DefaultDocumentFormatRegistry.getFormatByExtension(targetFileExtension))
                    .execute();
            return ResultDTO.builder()
                    .code(ResultCodeEnum.SUCCESS.getCode())
                    .msg(ResultCodeEnum.SUCCESS.getMsg())
                    .data(targetFile.getName())
                    .build();
        } catch (OfficeException e) {
            return ResultDTO.builder()
                    .code(ResultCodeEnum.ERROR.getCode())
                    .msg(ResultCodeEnum.ERROR.getMsg())
                    .data(e.getMessage())
                    .build();
        }
    }

    @PostConstruct
    private void init() {
        File storePath = new File(this.storePath);
        if (!storePath.exists()) {
            storePath.mkdirs();
        }
    }
}
