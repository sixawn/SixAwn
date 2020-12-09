/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 fitt.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.dto;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>@description Excel 扩展类: 主要用于获取 Excel 图片数据及位置等信息 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-11-04
 */
public class ExcelExtDTO {
    public static List<PictureInfoDTO> getAllPictureInfos(Sheet sheet, boolean onlyInternal) throws Exception {
        return getAllPictureInfos(sheet, null, null, null, null, onlyInternal);
    }

    public static List<PictureInfoDTO> getAllPictureInfos(Sheet sheet, Integer minRow, Integer maxRow, Integer minCol,
                                                          Integer maxCol, boolean onlyInternal) throws Exception {
        if (sheet instanceof HSSFSheet) {
            return getXLSAllPictureInfos((HSSFSheet) sheet, minRow, maxRow, minCol, maxCol, onlyInternal);
        } else if (sheet instanceof XSSFSheet) {
            return getXLSXAllPictureInfos((XSSFSheet) sheet, minRow, maxRow, minCol, maxCol, onlyInternal);
        } else {
            throw new Exception("未处理类型，没有为该类型添加：GetAllPictureInfoDTOs()扩展方法！");
        }
    }

    private static List<PictureInfoDTO> getXLSAllPictureInfos(HSSFSheet sheet, Integer minRow, Integer maxRow,
                                                              Integer minCol, Integer maxCol, Boolean onlyInternal) {
        List<PictureInfoDTO> PictureInfoDTOList = new ArrayList<>();

        HSSFShapeContainer shapeContainer = sheet.getDrawingPatriarch();
        if (null != shapeContainer) {
            List<HSSFShape> shapeList = shapeContainer.getChildren();
            for (HSSFShape shape : shapeList) {
                if (shape instanceof HSSFPicture && shape.getAnchor() instanceof HSSFClientAnchor) {
                    HSSFPicture picture = (HSSFPicture) shape;
                    HSSFClientAnchor anchor = (HSSFClientAnchor) shape.getAnchor();

                    if (isInternalOrIntersect(minRow, maxRow, minCol, maxCol, anchor.getRow1(), anchor.getRow2(),
                            anchor.getCol1(), anchor.getCol2(), onlyInternal)) {
                        PictureInfoDTOList.add(
                                new PictureInfoDTO(anchor.getRow1(), anchor.getRow2(), anchor.getCol1(), anchor.getCol2(),
                                        picture.getPictureData().getData(), picture.getPictureData().getMimeType()));
                    }
                }
            }
        }

        return PictureInfoDTOList;
    }

    private static List<PictureInfoDTO> getXLSXAllPictureInfos(XSSFSheet sheet, Integer minRow, Integer maxRow,
                                                               Integer minCol, Integer maxCol, Boolean onlyInternal) {
        List<PictureInfoDTO> PictureInfoDTOList = new ArrayList<>();

        List<POIXMLDocumentPart> documentPartList = sheet.getRelations();
        for (POIXMLDocumentPart documentPart : documentPartList) {
            if (documentPart instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) documentPart;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    if (shape instanceof XSSFPicture) {
                        XSSFPicture picture = (XSSFPicture) shape;
                        XSSFClientAnchor anchor = picture.getPreferredSize();

                        if (isInternalOrIntersect(minRow, maxRow, minCol, maxCol, anchor.getRow1(), anchor.getRow2(),
                                anchor.getCol1(), anchor.getCol2(), onlyInternal)) {
                            PictureInfoDTOList.add(new PictureInfoDTO(anchor.getRow1(), anchor.getRow2(), anchor.getCol1(),
                                    anchor.getCol2(), picture.getPictureData().getData(),
                                    picture.getPictureData().getMimeType()));
                        }
                    }
                }
            }
        }

        return PictureInfoDTOList;
    }

    private static boolean isInternalOrIntersect(Integer rangeMinRow, Integer rangeMaxRow, Integer rangeMinCol,
                                                 Integer rangeMaxCol, int pictureMinRow, int pictureMaxRow, int pictureMinCol, int pictureMaxCol,
                                                 Boolean onlyInternal) {
        int _rangeMinRow = rangeMinRow == null ? pictureMinRow : rangeMinRow;
        int _rangeMaxRow = rangeMaxRow == null ? pictureMaxRow : rangeMaxRow;
        int _rangeMinCol = rangeMinCol == null ? pictureMinCol : rangeMinCol;
        int _rangeMaxCol = rangeMaxCol == null ? pictureMaxCol : rangeMaxCol;

        if (onlyInternal) {
            return (_rangeMinRow <= pictureMinRow && _rangeMaxRow >= pictureMaxRow && _rangeMinCol <= pictureMinCol
                    && _rangeMaxCol >= pictureMaxCol);
        } else {
            return ((Math.abs(_rangeMaxRow - _rangeMinRow) + Math.abs(pictureMaxRow - pictureMinRow) >= Math
                    .abs(_rangeMaxRow + _rangeMinRow - pictureMaxRow - pictureMinRow))
                    && (Math.abs(_rangeMaxCol - _rangeMinCol) + Math.abs(pictureMaxCol - pictureMinCol) >= Math
                    .abs(_rangeMaxCol + _rangeMinCol - pictureMaxCol - pictureMinCol)));
        }
    }
}
