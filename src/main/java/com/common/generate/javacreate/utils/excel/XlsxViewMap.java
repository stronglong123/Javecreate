/*
 * Copyright © 2016 北京易酒批电子商务有限公司. All rights reserved.
 */

package com.common.generate.javacreate.utils.excel;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidationConstraint.OperatorType;
import org.apache.poi.ss.usermodel.DataValidationConstraint.ValidationType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDataBarFormatting;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author fengjiaqian
 *
 */
@Component(XlsxViewMap.VIEW_NAME)
public class XlsxViewMap extends AbstractXlsxView {

	public static final String VIEW_NAME = "XlsxExportViewMap";
	
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
    	String fileName = (String) model.get("fileName");
		Sheet sheet = workbook.createSheet(fileName);
        sheet.setDefaultRowHeightInPoints(18);
        //创建列标题
        setHeaderTitle(workbook, sheet, model);
        //填充数据
        setCellValue(workbook, sheet, model);

		response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(), "ISO8859-1"));
    }

	/**
	 * 设置列标题
	 * @param workbook
	 * @param sheet
	 * @param model
	 */
	private void setHeaderTitle(Workbook workbook, Sheet sheet, Map<String, Object> model) {
		CellStyle style =  workbook.createCellStyle(),
				styleText =  workbook.createCellStyle(),
				styleDate = workbook.createCellStyle();  //创建一个样式
		style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.PALE_BLUE.getIndex());    //设置颜色为红色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        style.setFont(getFont(workbook));
        styleText.setDataFormat(workbook.createDataFormat().getFormat("@"));
        styleDate.setDataFormat(workbook.createDataFormat().getFormat("yyyy-MM-dd"));
		// create header row
        Row header = sheet.createRow(0);
        String[] displayNames = ((String) model.get("DisplayNames")).split(",");
        for (int i = 0; i < displayNames.length; i++) {
			XSSFCell cell = (XSSFCell) header.createCell(i);
			String title = displayNames[i];
			CellRangeAddressList regions = new CellRangeAddressList(0, 10000, i, i);
			//判断是否有特殊配置:
			if (title.contains(":")) {
				String[] titles = title.split(":");
				cell.setCellValue(titles[0]);
				// 设置第i列的1-10000行
				String checkRule = titles[1];
				XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper((XSSFSheet)sheet);

				if (checkRule.equalsIgnoreCase("INTEGER")) {
		            //整数
					XSSFDataValidationConstraint constraint = (XSSFDataValidationConstraint) dvHelper
							.createNumericConstraint(ValidationType.INTEGER, OperatorType.GREATER_THAN, "0", null);
		            //绑定
					XSSFDataValidation dataValidation =(XSSFDataValidation) dvHelper.createValidation(constraint,regions);
					dataValidation.createErrorBox("输入值有误", "数值型，请输入不小于0的正整数！");
		            dataValidation.createPromptBox("", null);
		            dataValidation.setShowErrorBox(true);
		            sheet.addValidationData(dataValidation);
				} else if (checkRule.equalsIgnoreCase("DATE")) {
		            //整数
					XSSFDataValidationConstraint constraint = (XSSFDataValidationConstraint) dvHelper
							.createDateConstraint(OperatorType.BETWEEN, "1900-01-01", "2100-12-31", "yyyy-MM-dd");
		            //绑定
					XSSFDataValidation dataValidation =(XSSFDataValidation) dvHelper.createValidation(constraint,regions);
					dataValidation.createErrorBox("输入值有误", "日期型，请输入大于1900-01-01小于2999-12-31的日期！");
		            dataValidation.createPromptBox("", null);
		            dataValidation.setShowErrorBox(true);
		            sheet.addValidationData(dataValidation);
		            sheet.setDefaultColumnStyle(i,styleDate);
				} else {
					// 创建下拉列表数据
					XSSFDataValidationConstraint constraint = (XSSFDataValidationConstraint) dvHelper
							.createExplicitListConstraint(checkRule.split("/"));
					// 绑定
					XSSFDataValidation dataValidation =(XSSFDataValidation) dvHelper.createValidation(constraint,regions);
					dataValidation.setSuppressDropDownArrow(true);
					dataValidation.setShowErrorBox(true);
					sheet.addValidationData(dataValidation);
				}
			} else {
				cell.setCellValue(title);
				//设置普通列为文本格式 避免自动格式化
				sheet.setDefaultColumnStyle(i,styleText);
			}
		    cell.setCellStyle(style);
			if(displayNames.length>6){
				sheet.setColumnWidth(i, 4500);

			}else {
				sheet.setColumnWidth(i, 3500);
			}
		}
	}

	/**
	 * 设置值
	 * @param workbook
	 * @param sheet
	 * @param model
	 */
	@SuppressWarnings({"rawtypes", "unchecked" })
	private void setCellValue(Workbook workbook, Sheet sheet, Map<String, Object> model) {
		List<Map> voList = (List<Map>) model.get("dataList");
        String[] fields = ((String) model.get("Fields")).split(",");
		CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        style.setFont(getFont(workbook));
		//设置内容
		for (int i = 0; i < voList.size(); i++) {
			Row row = sheet.createRow(i + 1);
			row.setRowStyle(style);
			Map map = voList.get(i);
			for (int j = 0; j < fields.length; j++) {
				Object result = map.get(fields[j]);
				if(result == null){
					row.createCell(j+1).setCellValue("");
				} else {
					Cell createCell = row.createCell(j);
					createCell.setCellStyle(style);
					if (result instanceof Date) {
						createCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(result));
					} else if(result instanceof BigDecimal){
						createCell.setCellValue((((BigDecimal)result).setScale(2,BigDecimal.ROUND_HALF_UP)).doubleValue());
					} else {
						createCell.setCellValue(String.valueOf(result));
					}
				}
			}
		}
	}

	/**
	 * 获取字体
	 * @param workbook
	 * @return
	 */
	private Font getFont(Workbook workbook) {
		Font font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 11);//设置字体大小
		return font;
	}
}