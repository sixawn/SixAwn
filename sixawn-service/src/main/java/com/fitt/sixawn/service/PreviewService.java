/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 fitt.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.service;

import com.fitt.sixawn.dto.ResultDTO;

import java.io.File;
import java.io.InputStream;

/**
 * <p>@description 文件预览服务接口 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-10-13
 */
public interface PreviewService {
    /**
     * <p>@title convertPDF </p>
     * <p>@description 将文件转成 PDF </p>
     *
     * @param sourceFile    源文件
     * @param fileExtension 转换后扩展名
     * @return com.fitt.sixawn.dto.ResultDTO
     * @since x.y.z by Sixawn.ZHENG
     */
    ResultDTO convertPDF(File sourceFile, String fileExtension);

    /**
     * <p>@title convertPDF </p>
     * <p>@description 将文件流转成 PDF </p>
     *
     * @param in            文件流
     * @param fileName      文件名
     * @param fileExtension 转换后扩展名
     * @return com.fitt.sixawn.dto.ResultDTO
     * @since x.y.z by Sixawn.ZHENG
     */
    ResultDTO convertPDF(InputStream in, String fileName, String fileExtension);
}
