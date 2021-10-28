package com.common.generate.javacreate.utils.excel;

import com.common.generate.javacreate.authutils.MyBeanUtil;
import com.common.generate.javacreate.model.FileDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xialei
 * @date 2021/7/23 16:21
 */
public class ExcelUtil {


    public static void poiExcel(Map<String, Object> model)
            throws Exception {

        /**表头*/
        Class<?> c = (Class<?>) model.get("FlectClass");
        /**文件名*/
        String fileName = (String) model.get("fileName");
        /**文件名*/
        String sheetName = (String) model.get("sheetName");
        if (StringUtils.isEmpty(sheetName)) {
            sheetName = "页签";
        }

        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet(sheetName);

        if (c != null) {
            Map<Field, ExcelColumn> fieldAnnos = new HashMap<>();
            //设置列标题
            setHeaderTitle(wb, sheet, c, fieldAnnos);
            //设置内容
            setCellValue(wb, sheet, model, fieldAnnos);
        } else {
            //设置列标题
            setHeaderTitle(wb, sheet, model);
            //设置内容
            setCellValue(wb, sheet, model);
        }

        wb.write(new FileOutputStream("G:/excel.xls"));
    }

    private static void setHeaderTitle(Workbook wb, Sheet sheet, Class<?> c, Map<Field, ExcelColumn> fieldAnnos) {
        HSSFCellStyle style = (HSSFCellStyle) wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式

        HSSFCellStyle cellStyle = (HSSFCellStyle) wb.createCellStyle();    //创建一个样式
        cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());    //设置颜色为红色
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        style.setFont(getHSSFFont(wb));

        // create header row
        Row header = sheet.createRow(0);
        //循环设置表头
        Field[] fields = c.getDeclaredFields();
        int index = 0;
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            ExcelColumn excelColumns = field.getAnnotation(ExcelColumn.class);
            if (excelColumns != null) {
                HSSFCell cell = (HSSFCell) header.createCell(excelColumns.sort());
                sheet.setColumnWidth(index++, excelColumns.columnWidth());
                cell.setCellValue(excelColumns.name());
                cell.setCellStyle(cellStyle);
                fieldAnnos.put(field, excelColumns);
            }
        }
    }


    private static void setCellValue(Workbook workbook, Sheet sheet, Map<String, Object> model,
                                     Map<Field, ExcelColumn> fieldAnnos) throws Exception {
        /**内容*/
        List<?> voList = (List<?>) model.get("dataList");
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        style.setFont(getHSSFFont(workbook));

        for (int i = 0; i < voList.size(); i++) {
            Row row = sheet.createRow(i + 1);
            row.setRowStyle(style);
            Object vo = voList.get(i);
            Set<Map.Entry<Field, ExcelColumn>> fieldEntry = fieldAnnos.entrySet();
            for (Map.Entry<Field, ExcelColumn> entry : fieldEntry) {
                Object result = PropertyUtils.getProperty(vo, entry.getKey().getName());
                ExcelColumn col = entry.getValue();
                if (result == null) {
                    row.createCell(col.sort()).setCellValue("");
                } else {
                    Cell createCell = row.createCell(entry.getValue().sort());
                    createCell.setCellStyle(style);
                    if (result instanceof Date) {
                        createCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(result));
                    } else if (result instanceof BigDecimal) {
                        createCell.setCellValue((((BigDecimal) result).setScale(2, BigDecimal.ROUND_HALF_UP)).doubleValue());
                    } else {
                        createCell.setCellValue(String.valueOf(result));
                    }
                }
            }
        }
    }


    /**
     * 设置列标题
     *
     * @param displayNames  列名数组
     * @param sheet
     * @param cellStyle
     * @param cellStyleText
     * @param header
     */
    private static void setHeaderTitle(Workbook workbook, Sheet sheet, Map<String, Object> model) {
        CellStyle style = workbook.createCellStyle(),
                styleText = workbook.createCellStyle(),
                styleDate = workbook.createCellStyle();  //创建一个样式
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.PALE_BLUE.getIndex());    //设置颜色为红色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        style.setFont(getHSSFFont(workbook));
        styleText.setDataFormat(workbook.createDataFormat().getFormat("@"));
        styleDate.setDataFormat(workbook.createDataFormat().getFormat("yyyy-MM-dd"));
        // create header row
        Row header = sheet.createRow(0);
        String[] displayNames = ((String) model.get("DisplayNames")).split(",");
        for (int i = 0; i < displayNames.length; i++) {
            HSSFCell cell = (HSSFCell) header.createCell(i);
            String title = displayNames[i];
            CellRangeAddressList regions = new CellRangeAddressList(0, 10000, i, i);
            //判断是否有特殊配置:
            if (title.contains(":")) {
                String[] titles = title.split(":");
                cell.setCellValue(titles[0]);
                // 设置第i列的1-10000行
                String checkRule = titles[1];
                if (checkRule.equalsIgnoreCase("INTEGER")) {
                    //整数
                    DVConstraint constraint = DVConstraint.createNumericConstraint(DataValidationConstraint.ValidationType.INTEGER, DataValidationConstraint.OperatorType.GREATER_THAN, "0", null);
                    //绑定
                    HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
                    dataValidation.createErrorBox("输入值有误", "数值型，请输入不小于0的正整数！");
                    dataValidation.createPromptBox("", null);
                    dataValidation.setShowErrorBox(true);
                    sheet.addValidationData(dataValidation);
                } else if (checkRule.equalsIgnoreCase("DATE")) {
                    //整数
                    DVConstraint constraint = DVConstraint.createDateConstraint(DataValidationConstraint.OperatorType.BETWEEN, "1900-01-01", "2100-12-31", "yyyy-MM-dd");
                    //绑定
                    HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
                    dataValidation.createErrorBox("输入值有误", "日期型，请输入大于1900-01-01小于2999-12-31的日期！");
                    dataValidation.createPromptBox("", null);
                    dataValidation.setShowErrorBox(true);
                    sheet.addValidationData(dataValidation);
                    sheet.setDefaultColumnStyle(i, styleDate);
                } else {
                    // 创建下拉列表数据
                    DVConstraint constraint = DVConstraint.createExplicitListConstraint(checkRule.split("/"));
                    // 绑定
                    HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
                    sheet.addValidationData(dataValidation);
                }
            } else {
                cell.setCellValue(title);
                //设置普通列为文本格式 避免自动格式化
                sheet.setDefaultColumnStyle(i, styleText);
            }
            cell.setCellStyle(style);
            if (displayNames.length > 6) {
                sheet.setColumnWidth(i, 4500);

            } else {
                sheet.setColumnWidth(i, 3500);
            }
        }
    }

    /**
     * 设置值
     *
     * @param workbook
     * @param voList
     * @param fields
     * @param sheet
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void setCellValue(Workbook workbook, Sheet sheet, Map<String, Object> model) {
        List<Object> dataList = (List<Object>) model.get("dataList");
        List<Map> voList = new ArrayList<>();
        for (Object o : dataList) {
            Map<String, Object> m = MyBeanUtil.transBean2Map(o);
            voList.add(m);
        }

        String[] fields = ((String) model.get("Fields")).split(",");
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        style.setFont(getHSSFFont(workbook));
        //设置内容
        for (int i = 0; i < voList.size(); i++) {
            Row row = sheet.createRow(i + 1);
            row.setRowStyle(style);
            Map map = voList.get(i);
            for (int j = 0; j < fields.length; j++) {
                Object result = map.get(fields[j]);
                if (result == null) {
                    row.createCell(j + 1).setCellValue("");
                } else {
                    Cell createCell = row.createCell(j);
                    createCell.setCellStyle(style);
                    if (result instanceof Date) {
                        createCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(result));
                    } else if (result instanceof BigDecimal) {
                        createCell.setCellValue((((BigDecimal) result).setScale(2, BigDecimal.ROUND_HALF_UP)).doubleValue());
                    } else {
                        createCell.setCellValue(String.valueOf(result));
                    }
                }
            }
        }
    }

    /**
     * 获取字体
     *
     * @param workbook
     * @return
     */
    private static HSSFFont getHSSFFont(Workbook workbook) {
        HSSFFont font = (HSSFFont) workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 11);//设置字体大小
        return font;
    }

    public static void main(String[] args) throws Exception {
        List<FileDTO> list = new ArrayList<FileDTO>();
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSourceFileName("源数据");
        fileDTO.setTargetFileName("目标数据");
        list.add(fileDTO);
        Map<String, Object> model = new HashMap<>();
        model.put("dataList", list);
        model.put("Fields", "sourceFileName,targetFileName");
        model.put("DisplayNames", "源名称, 目标名称");
//        model.put("FlectClass", FileDTO.class);
        poiExcel(model);

    }

}
