/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 fitt.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.dto;

import lombok.Builder;
import lombok.Data;

/**
 * <p>@description 图片信息数据对象 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-11-04
 */
@Data
@Builder
public class PictureInfoDTO {
    private int minRow;
    private int maxRow;
    private int minCol;
    private int maxCol;
    private byte[] pictureData;
    private String ext;

    public PictureInfoDTO(int minRow, int maxRow, int minCol, int maxCol, byte[] pictureData, String ext) {
        this.minRow = minRow;
        this.maxRow = maxRow;
        this.minCol = minCol;
        this.maxCol = maxCol;
        this.pictureData = pictureData;
        this.ext = ext;
    }
}
