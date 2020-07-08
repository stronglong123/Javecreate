package com.common.generate.javacreate.utils;

import com.common.generate.javacreate.domain.excel.ExcelHead;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xialei
 * @date 2020/5/15 14:37
 */
public class ExcelUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ExcelUtils.class);

    public static String importExcel(String filePath) throws Exception {

        if (StringUtils.isEmpty(filePath)) {
            throw new Exception("导入文件为空");
        }

        File file = new File(filePath);
        //判断格式
        checkFile(file.getName());
        //创建输入流对象
        InputStream is = new FileInputStream(file);
        Workbook workbook = getWorkBoot(is, file.getName()); // 兼容新老版本

        Map<String, Object> objectMap = new HashMap<>();
        //循环表格（sheet）
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            //判断sheet是否有数据
            if (sheet.getPhysicalNumberOfRows() <= 0) {
                continue;
            }
            //存放集合
            List<Map<String, Object>> list = new ArrayList<>();
            //存放表头名字（第一行的数据）
            List<String> header = new ArrayList<>();
            for (int x = 0; x < sheet.getRow(0).getLastCellNum(); x++) {
                Cell cell = sheet.getRow(0).getCell(x);
                String value = cell.getStringCellValue();
                header.add(value);
            }

            //获取行并进行循环
            for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                Row row = sheet.getRow(j);
                //判断row是否有数据
                if (row.getPhysicalNumberOfCells() <= 0) {
                    continue;
                }
                //存放数据
                Map<String, Object> map = new HashMap<>();
                //获取单元格并进行循环
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    Cell cell = row.getCell(k);
                    if (cell == null || cell.toString().trim().equals("")) {
                        continue;
                    }
                    CellType cellType = cell.getCellTypeEnum();
                    //存放值
                    String cellValue = "";
                    //字符串
                    if (cellType == CellType.STRING) {
                        cellValue = cell.getStringCellValue().trim();
                        cellValue = StringUtils.isEmpty(cellValue) ? "" : cellValue;
                    }
                    //数据格式
                    if (cellType == CellType.NUMERIC) {
                        //判断日期类型
                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String date1 = dff.format(cell.getDateCellValue());
                            cellValue = date1;
                        } else {
                            //设置数据格式（"#.######"是几位小数）
                            cellValue = new DecimalFormat("#.######").format(cell.getNumericCellValue());
                        }
                    }
                    if (cellType == CellType.BOOLEAN) {
                        cellValue = String.valueOf(cell.getBooleanCellValue());
                    }
                    //添加数据到map
                    map.put(header.get(k), cellValue);
                }
                //把map数据添加到list
                list.add(map);
            }
            objectMap.put(sheet.getSheetName(), list);
        }
        return objectMap.toString();
    }


    /**
     * 校验是否是Excel文件
     *
     * @param fileName
     * @throws Exception
     */
    public static void checkFile(String fileName) throws Exception {
        if (!StringUtils.isEmpty(fileName) && !(fileName.endsWith(".xlsx") || fileName.endsWith(".xls"))) {
            throw new Exception("不是Excel文件！");
        }
    }

    /**
     * Excel表头对应Entity属性 解析封装javabean
     *
     * @param classzz    类
     * @param in         excel流
     * @param fileName   文件名
     * @param excelHeads excel表头与entity属性对应关系
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> readExcelToEntity(Class<T> classzz, InputStream in, String fileName, List<ExcelHead>
            excelHeads) throws Exception {
        checkFile(fileName); // 是否EXCEL文件
        Workbook workbook = getWorkBoot(in, fileName); // 兼容新老版本
        List<T> excelForBeans = readExcel(classzz, workbook, excelHeads); // 解析Excel
        return excelForBeans;
    }

    /**
     * 兼容新老版Excel
     *
     * @param in
     * @param fileName
     * @return
     * @throws IOException
     */
    public static Workbook getWorkBoot(InputStream in, String fileName) throws IOException {
        if (fileName.endsWith(".xlsx")) {
            return new XSSFWorkbook(in);
        } else {
            return new HSSFWorkbook(in);
        }
    }

    /**
     * 解析Excel转换为Entity
     *
     * @param classzz  类
     * @param in       excel流
     * @param fileName 文件名
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> readExcelToEntity(Class<T> classzz, InputStream in, String fileName) throws Exception {
        return readExcelToEntity(classzz, in, fileName, null);
    }

    /**
     * 获取properties的set和get方法
     */
    static class MethodUtils {
        private static final String SET_PREFIX = "set";
        private static final String GET_PREFIX = "get";

        private static String capitalize(String name) {
            if (name == null || name.length() == 0) {
                return name;
            }
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }

        public static String setMethodName(String propertyName) {
            return SET_PREFIX + capitalize(propertyName);
        }

        public static String getMethodName(String propertyName) {
            return GET_PREFIX + capitalize(propertyName);
        }
    }

    /**
     * 是否日期字段
     *
     * @param field
     * @return
     */
    private static boolean isDateFied(Field field) {
        return (Date.class == field.getType());
    }

    /**
     * 空值校验
     *
     * @param excelHead
     * @throws Exception
     */
    private static void volidateValueRequired(ExcelHead excelHead, String sheetName, int rowIndex) throws Exception {
        if (excelHead != null && excelHead.isRequired()) {
            throw new Exception("《" + sheetName + "》第" + (rowIndex + 1) + "行:\"" + excelHead.getExcelName() +
                    "\"不能为空！");
        }
    }

    /**
     * 类型转换
     *
     * @param classzz
     * @param value
     * @return
     */
    private static Object convertType(Class<?> classzz, String value) {
        if (Integer.class == classzz || int.class == classzz) {
            return Integer.valueOf(value);
        }
        if (Short.class == classzz || short.class == classzz) {
            return Short.valueOf(value);
        }
        if (Byte.class == classzz || byte.class == classzz) {
            return Byte.valueOf(value);
        }
        if (Character.class == classzz || char.class == classzz) {
            return value.charAt(0);
        }
        if (Long.class == classzz || long.class == classzz) {
            return Long.valueOf(value);
        }
        if (Float.class == classzz || float.class == classzz) {
            return Float.valueOf(value);
        }
        if (Double.class == classzz || double.class == classzz) {
            return Double.valueOf(value);
        }
        if (Boolean.class == classzz || boolean.class == classzz) {
            return Boolean.valueOf(value.toLowerCase());
        }
        if (BigDecimal.class == classzz) {
            return new BigDecimal(value);
        }
        /*
         * if (Date.class == classzz) { SimpleDateFormat formatter = new
         * SimpleDateFormat(FULL_DATA_FORMAT); ParsePosition pos = new ParsePosition(0);
         * Date date = formatter.parse(value, pos); return date; }
         */
        return value;
    }

    /**
     * 解析Excel
     *
     * @param classzz    类
     * @param workbook   工作簿对象
     * @param excelHeads excel与entity对应关系实体
     * @param <T>
     * @return
     * @throws Exception
     */
    private static <T> List<T> readExcel(Class<T> classzz, Workbook workbook, List<ExcelHead> excelHeads) throws
            Exception {
        List<T> beans = new ArrayList<T>();
        int sheetNum = workbook.getNumberOfSheets();
        for (int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            String sheetName = sheet.getSheetName();
            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();
            Row head = sheet.getRow(firstRowNum);
            if (head == null) {
                continue;
            }
            short firstCellNum = head.getFirstCellNum();
            short lastCellNum = head.getLastCellNum();
            Field[] fields = classzz.getDeclaredFields();
            for (int rowIndex = firstRowNum + 1; rowIndex <= lastRowNum; rowIndex++) {
                Row dataRow = sheet.getRow(rowIndex);
                if (dataRow == null) {
                    continue;
                }
                T instance = classzz.newInstance();
                if (CollectionUtils.isEmpty(excelHeads)) { // 非头部映射方式，默认不校验是否为空，提高效率
                    firstCellNum = dataRow.getFirstCellNum();
                    lastCellNum = dataRow.getLastCellNum();
                }
                for (int cellIndex = firstCellNum; cellIndex < lastCellNum; cellIndex++) {
                    Cell headCell = head.getCell(cellIndex);
                    if (headCell == null) {
                        continue;
                    }
                    Cell cell = dataRow.getCell(cellIndex);
                    // String value11 = cell.getStringCellValue();
                    headCell.setCellType(CellType.STRING);
                    String headName = headCell.getStringCellValue().trim();
                    if (StringUtils.isEmpty(headName)) {
                        continue;
                    }
                    ExcelHead eHead = null;
                    if (!CollectionUtils.isEmpty(excelHeads)) {
                        for (ExcelHead excelHead : excelHeads) {
                            if (headName.equals(excelHead.getExcelName())) {
                                eHead = excelHead;
                                headName = eHead.getEntityName();
                                break;
                            }
                        }
                    }
                    for (Field field : fields) {
                        if (headName.equalsIgnoreCase(field.getName())) {
                            String methodName = MethodUtils.setMethodName(field.getName());
                            Method method = classzz.getMethod(methodName, field.getType());
                            if (isDateFied(field)) {
                                Date date = null;
                                if (cell != null) {
                                    date = cell.getDateCellValue();
                                }
                                if (date == null) {
                                    volidateValueRequired(eHead, sheetName, rowIndex);
                                    break;
                                }
                                method.invoke(instance, cell.getDateCellValue());
                            } else {
                                String value = null;
                                if (cell != null) {
                                    cell.setCellType(CellType.STRING);
                                    value = cell.getStringCellValue();
                                }
                                if (StringUtils.isEmpty(value)) {
                                    volidateValueRequired(eHead, sheetName, rowIndex);
                                    break;
                                }
                                method.invoke(instance, convertType(field.getType(), value.trim()));
                            }
                            break;
                        }
                    }
                }
                beans.add(instance);
            }
        }
        return beans;
    }
}
