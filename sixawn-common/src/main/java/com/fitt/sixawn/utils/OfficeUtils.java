/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 fitt.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.utils;

import com.fitt.sixawn.constants.FileTypeEnum;
import com.fitt.sixawn.dto.ExcelExtDTO;
import com.fitt.sixawn.dto.PictureInfoDTO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.List;

/**
 * <p>@description Office 操作工具类 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-11-04
 */
@Slf4j
public class OfficeUtils {

    public static byte[] excelToPdf(String excelPath, String pdfPath) throws Exception {
        InputStream in = new FileInputStream(excelPath);

        Workbook workbook = excelPath.endsWith(FileTypeEnum.XLSX.getSuffix()) ? new XSSFWorkbook(in) : new HSSFWorkbook(in);

        Sheet sheet = workbook.getSheetAt(0);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        // 此处根据excel大小设置pdf纸张大小
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, stream);
        // 设置也边距
        document.setMargins(0, 0, 15, 15);
        document.open();
        float[] widths = getColWidth(sheet);

        PdfPTable table = new PdfPTable(widths);
        table.setWidthPercentage(90);
        int colCount = widths.length;
        // 设置基本字体
        BaseFont baseFont = BaseFont.createFont("/Volumes/MacData/Tools/simsun.ttc,0", BaseFont.IDENTITY_H,
                BaseFont.EMBEDDED);

        for (int r = sheet.getFirstRowNum(); r < sheet.getPhysicalNumberOfRows(); r++) {
            Row row = sheet.getRow(r);
            if (row != null) {
                for (int c = row.getFirstCellNum(); (c < row.getLastCellNum() || c < colCount) && c > -1; c++) {
                    if (c >= row.getPhysicalNumberOfCells()) {
                        PdfPCell pCell = new PdfPCell(new Phrase(""));
                        pCell.setBorder(0);
                        table.addCell(pCell);
                        continue;
                    }
                    Cell excelCell = row.getCell(c);
                    String value = "";

                    if (excelCell != null) {
                        value = excelCell.toString().trim();
                        if (value.length() != 0) {
                            // 获取excel单元格数据显示样式
                            String dataFormat = excelCell.getCellStyle().getDataFormatString();
                            if (!"General".equalsIgnoreCase(dataFormat) && !"@".equalsIgnoreCase(dataFormat)) {
                                try {
                                    String numStyle = getNumStyle(dataFormat);
                                    value = numFormat(numStyle, excelCell.getNumericCellValue());
                                } catch (Exception e) {
                                    log.error("error: {}", e);
                                }
                            }
                        }
                    }
                    org.apache.poi.ss.usermodel.Font excelFont = getExcelFont(workbook, excelCell, excelPath);

                    // 设置单元格字体
                    // HSSFFont excelFont = excelCell.getCellStyle().getFont(workbook);
                    Font pdFont = new Font(baseFont, excelFont.getFontHeightInPoints(),
                            excelFont.getCharSet() == 700 ? Font.BOLD : Font.NORMAL, BaseColor.BLACK);

                    PdfPCell pCell = new PdfPCell(new Phrase(value, pdFont));
                    List<PictureInfoDTO> infos = ExcelExtDTO.getAllPictureInfos(sheet, r, r, c, c, false);
                    if (!infos.isEmpty()) {
                        pCell = new PdfPCell(Image.getInstance(infos.get(0).getPictureData()));
                        PictureInfoDTO info = infos.get(0);
                        System.out.println("最大行：" + info.getMaxRow() + "最小行：" + info.getMinRow() + "最大列:" + info.getMaxCol() + "最小列：" + info.getMinCol());
                        ;
                    }

                    boolean hasBorder = hasBorder(excelCell);
                    if (!hasBorder) {
                        pCell.setBorder(0);
                    }
                    pCell.setHorizontalAlignment(getHorAlign(excelCell.getCellStyle().getAlignment().getCode()));
                    pCell.setVerticalAlignment(getVerAlign(excelCell.getCellStyle().getVerticalAlignment().getCode()));

                    pCell.setMinimumHeight(row.getHeightInPoints());
                    if (isMergedRegion(sheet, r, c)) {
                        int[] span = getMergedSpan(sheet, r, c);
                        //忽略合并过的单元格
                        if (span[0] == 1 && span[1] == 1) {
                            continue;
                        }
                        pCell.setRowspan(span[0]);
                        pCell.setColspan(span[1]);
                        //合并过的列直接跳过
                        c = c + span[1] - 1;
                    }

                    table.addCell(pCell);

                }
            } else {
                PdfPCell pCell = new PdfPCell(new Phrase(""));
                pCell.setBorder(0);
                pCell.setMinimumHeight(13);
                table.addCell(pCell);
            }
        }
        document.add(table);
        document.close();

        byte[] pdfByte = stream.toByteArray();
        stream.flush();
        stream.reset();
        stream.close();

        FileOutputStream outputStream = new FileOutputStream(pdfPath);
        outputStream.write(pdfByte);
        outputStream.flush();
        outputStream.close();

        return pdfByte;
    }

    //获取字体
    private static org.apache.poi.ss.usermodel.Font getExcelFont(Workbook workbook, Cell cell, String excelName) {
        if (excelName.endsWith(FileTypeEnum.XLS.getSuffix())) {
            return ((HSSFCell) cell).getCellStyle().getFont(workbook);
        }
        return ((XSSFCell) cell).getCellStyle().getFont();
    }

    /**
     * 判断excel单元格是否有边框
     *
     * @param excelCell
     * @return
     */
    private static boolean hasBorder(Cell excelCell) {
        short top = excelCell.getCellStyle().getBorderTop().getCode();
        short bottom = excelCell.getCellStyle().getBorderBottom().getCode();
        short left = excelCell.getCellStyle().getBorderLeft().getCode();
        short right = excelCell.getCellStyle().getBorderRight().getCode();
        return top + bottom + left + right > 2;
    }

    /**
     * 获取excel单元格数据显示格式
     *
     * @param dataFormat 单元格内容
     * @return 处理后内容
     * @throws Exception
     */
    private static String getNumStyle(String dataFormat) throws Exception {
        if (StringUtils.isEmpty(dataFormat)) {
            throw new Exception("");
        }
        if (dataFormat.contains("%")) {
            return dataFormat;
        } else {
            return dataFormat.substring(0, dataFormat.length() - 2);
        }

    }

    /**
     * 判断单元格是否是合并单元格
     *
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    private static boolean isMergedRegion(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 计算合并单元格合并的跨行跨列数
     *
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    private static int[] getMergedSpan(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        int[] span = {1, 1};
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if (firstColumn == column && firstRow == row) {
                span[0] = lastRow - firstRow + 1;
                span[1] = lastColumn - firstColumn + 1;
                break;
            }
        }
        return span;
    }

    /**
     * 获取excel中每列宽度的占比
     *
     * @param sheet
     * @return
     */
    private static float[] getColWidth(Sheet sheet) {
        int rowNum = getMaxColRowNum(sheet);
        Row row = sheet.getRow(rowNum);
        int cellCount = row.getPhysicalNumberOfCells();
        int[] colWidths = new int[cellCount];
        int sum = 0;

        for (int i = row.getFirstCellNum(); i < cellCount; i++) {
            Cell cell = row.getCell(i);
            if (cell != null) {
                colWidths[i] = sheet.getColumnWidth(i);
                sum += sheet.getColumnWidth(i);
            }
        }

        float[] colWidthPer = new float[cellCount];
        for (int i = row.getFirstCellNum(); i < cellCount; i++) {
            colWidthPer[i] = (float) colWidths[i] / sum * 100;
        }
        return colWidthPer;
    }

    /**
     * 获取excel中列数最多的行号
     *
     * @param sheet
     * @return
     */
    private static int getMaxColRowNum(Sheet sheet) {
        int rowNum = 0;
        int maxCol = 0;
        for (int r = sheet.getFirstRowNum(); r < sheet.getPhysicalNumberOfRows(); r++) {
            Row row = sheet.getRow(r);
            if (row != null && maxCol < row.getPhysicalNumberOfCells()) {
                maxCol = row.getPhysicalNumberOfCells();
                rowNum = r;
            }
        }
        return rowNum;
    }

    /**
     * excel垂直对齐方式映射到pdf对齐方式
     *
     * @param align
     * @return
     */
    private static int getVerAlign(int align) {
        switch (align) {
            case 2:
                return com.itextpdf.text.Element.ALIGN_BOTTOM;
            case 3:
                return com.itextpdf.text.Element.ALIGN_TOP;
            default:
                return com.itextpdf.text.Element.ALIGN_MIDDLE;
        }
    }

    /**
     * excel水平对齐方式映射到pdf水平对齐方式
     *
     * @param align
     * @return int
     */
    private static int getHorAlign(int align) {
        switch (align) {
            case 1:
                return com.itextpdf.text.Element.ALIGN_LEFT;
            case 3:
                return com.itextpdf.text.Element.ALIGN_RIGHT;
            default:
                return com.itextpdf.text.Element.ALIGN_CENTER;
        }
    }

    /**
     * 格式化数字
     *
     * @param pattern
     * @param num
     * @return
     */
    private static String numFormat(String pattern, double num) {
        DecimalFormat format = new DecimalFormat(pattern);
        return format.format(num);
    }

    public static void main(String[] args) throws Exception {
        excelToPdf("/Volumes/MacData/Data/800x/file/CRC工作台需求清单.xls", "/Volumes/MacData/Data/800x/file/CRC工作台需求清单1.pdf");
    }
}
