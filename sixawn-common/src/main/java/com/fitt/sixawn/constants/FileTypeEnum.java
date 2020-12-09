/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 fitt.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>@description 文件类型枚举类 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-11-04
 */
@Getter
@AllArgsConstructor
public enum FileTypeEnum {
    /**
     * 文本类型-TXT
     **/
    TXT("txt", ".txt", "text/plain", ""),
    /**
     * 文本类型-TXT
     **/
    CSS("css", ".css", "text/plain", ""),
    /**
     * 文本类型-HTML
     **/
    HTML("html", ".html", "text/plain", ""),
    /**
     * 文本类型-XML
     **/
    XML("xml", ".BMP", "text/plain", ""),

    /**
     * OFFICE2003 类型-DOC
     **/
    DOC("doc", ".doc", "application/msword", ""),
    /**
     * OFFICE2003 类型-XLS
     **/
    XLS("xls", ".xls", "application/vnd.ms-excel", ""),
    /**
     * OFFICE2003 类型-PPT
     **/
    PPT("ppt", ".ppt", "application/vnd.ms-powerpoint", ""),
    /**
     * OFFICE2007 类型-DOCX
     **/
    DOCX("docx", ".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", ""),
    /**
     * OFFICE2007 类型-PPTX
     **/
    PPTX("pptx", ".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation", ""),
    /**
     * OFFICE2007 类型-XLSX
     **/
    XLSX("xlsx", ".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", ""),

    /**
     * 压缩类型-RAR
     **/
    RAR("rar", ".rar", "application/x-rar-compressed", ""),
    /**
     * 压缩类型-ZIP
     **/
    ZIP("zip", ".zip", "application/zip", ""),
    /**
     * 压缩类型-PDF
     **/
    PDF("pdf", ".pdf", "application/pdf", ""),

    /**
     * 图片类型-JPG
     **/
    JPG("jpg", ".jpg", "image/*", ""),
    /**
     * 图片类型-PNG
     **/
    PNG("png", ".png", "image/*", ""),
    /**
     * 图片类型-GIF
     **/
    GIF("gif", ".gif", "image/*", ""),
    /**
     * 图片类型-TIF
     **/
    TIF("tif", ".tif", "image/*", ""),
    /**
     * 图片类型-BMP
     **/
    BMP("bmp", ".bmp", "image/*", ""),

    ;


    String code;
    String suffix;
    String mimeType;
    String header;
}
