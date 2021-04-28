package com.common.generate.javacreate.controller;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.authutils.MyBeanUtil;
import com.common.generate.javacreate.model.CategoryDTO;
import com.common.generate.javacreate.model.TableDTO;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import com.common.generate.javacreate.model.text.TextDTO;
import com.common.generate.javacreate.service.ITableCreateService;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.StringUtil;
import com.common.generate.javacreate.utils.excel.XlsViewMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author xialei
 * @date 2020/5/15 14:57
 */
@IgnoreAuthInterceptor
@RestController
public class ImportManagerController {
    private static final Logger logger = LoggerFactory.getLogger(ImportManagerController.class);

    @Autowired
    private ITableCreateService iTableCreateService;

    @PostMapping("/import/importTable")
    public Result<List<String>> uploadProductInfo(@RequestParam("file") MultipartFile file) throws Exception {
        if (null == file) {
            return RetResponse.makeErrRsp(new ArrayList<>(), "上传失败，无法找到文件！");
        }
        List<TableDTO> tableDTOS = ExcelUtils.readExcelToEntity(TableDTO.class, file.getInputStream(), file.getOriginalFilename());
        logger.info("解析数据：{}",JSON.toJSONString(tableDTOS));
        return RetResponse.makeOKRsp(iTableCreateService.createTableInfo(tableDTOS));
    }


    @IgnoreAuthInterceptor
    @PostMapping("/import/importCategory")
    public Result importCategory(@RequestParam("file") MultipartFile file) throws Exception {
        if (null == file) {
            return RetResponse.makeErrRsp(new ArrayList<>(), "上传失败，无法找到文件！");
        }
        List<CategoryDTO> dtos = ExcelUtils.readExcelToEntity(CategoryDTO.class, file.getInputStream(), file.getOriginalFilename());
        logger.info("解析数据：{}",JSON.toJSONString(dtos));

        return RetResponse.makeOKRsp(dtos);
    }

    @PostMapping("/import/test")
    public String test(@RequestParam("file") String file) {
        return "true";
    }

    /**
     * 下载货主批量导入模板
     */
    @GetMapping(value = "/templates/download")
    public String downloadCargoOwner(Model model){
        model.addAttribute("dataList", Collections.emptyList());
        model.addAttribute("Fields", "");
        model.addAttribute("DisplayNames", "货主名称,货主编码,类型:经销商/供应商,联系人,电话");
        model.addAttribute("fileName", "货主批量导入.xls");
        return  XlsViewMap.VIEW_NAME;
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    private List<Map> convert2Map(List dtos) {
        List<Map> result = new ArrayList<>();
        dtos.forEach(dto -> result.add(MyBeanUtil.transBean2Map(dto)));
        return result;
    }


    @PostMapping("/import/uploadText")
    public void uploadText(@RequestParam("file") MultipartFile file,HttpServletResponse response) throws Exception {
        List<TextDTO> tableDTOS = ExcelUtils.readExcelToEntity(TextDTO.class, file.getInputStream(), file.getOriginalFilename());
        logger.info("解析数据：{}",JSON.toJSONString(tableDTOS));
        StringBuilder result =new StringBuilder();
        tableDTOS.forEach(it->{
            result.append(("\r\n")).append(it.getTitle()).append(("\r\n")).append(it.getComment());
        });

        exportTxt(response,result.toString());
    }


    /* 导出txt文件
     * @author
     * @param	response
     * @param	text 导出的字符串
     * @return
     */
    public void exportTxt(HttpServletResponse response, String text){
        response.setCharacterEncoding("utf-8");
        //设置响应的内容类型
        response.setContentType("text/plain");
        //设置文件的名称和格式
        response.addHeader("Content-Disposition","attachment;filename="
                + genAttachmentFileName( "文件名称", "JSON_FOR_UCC_")//设置名称格式，没有这个中文名称无法显示
                + ".txt");
        BufferedOutputStream buff = null;
        ServletOutputStream outStr = null;
        try {
            outStr = response.getOutputStream();
            buff = new BufferedOutputStream(outStr);
            buff.write(text.getBytes("UTF-8"));
            buff.flush();
            buff.close();
        } catch (Exception e) {
            //LOGGER.error("导出文件文件出错:{}",e);
        } finally {try {
            buff.close();
            outStr.close();
        } catch (Exception e) {
            //LOGGER.error("关闭流对象出错 e:{}",e);
        }
        }
    }

    public  String genAttachmentFileName(String cnName, String defaultName) {
        try {
            cnName = new String(cnName.getBytes("gb2312"), "ISO8859-1");
        } catch (Exception e) {
            cnName = defaultName;
        }
        return cnName;
    }

    @PostMapping("/import/parse")
    public void parse(@RequestParam("file") MultipartFile file,HttpServletResponse response) throws Exception {
        List<TextDTO> tableDTOS = ExcelUtils.readExcelToEntity(TextDTO.class, file.getInputStream(), file.getOriginalFilename());
        StringBuilder stringBuilder =new StringBuilder();
        int count =0;
        for (TextDTO it : tableDTOS) {
            if(StringUtils.isNotEmpty(it.getComment())){
                stringBuilder.append("UPDATE oms_order_3.jiupiorderitem set SkuRef_Id =")
                        .append(it.getComment())
                        .append(" where Id = ").append(it.getTitle()).append(";");
                count++;
            }
        }
        System.out.println(stringBuilder.toString());
        System.out.println(count);
    }


    @PostMapping("/import/parse2")
    public void parse2(@RequestParam("file") MultipartFile file,HttpServletResponse response) throws Exception {
        List<TextDTO> tableDTOS = ExcelUtils.readExcelToEntity(TextDTO.class, file.getInputStream(), file.getOriginalFilename());
        StringBuilder stringBuilder =new StringBuilder();
        int count =0;

        stringBuilder.append("SELECT * FROM oms_order_3.jiupiorderitem  t where t.Id in (");
        for (TextDTO it : tableDTOS) {
            if(StringUtils.isNotEmpty(it.getComment())){
                stringBuilder.append(it.getTitle()).append(",");
                count++;
            }
        }
        stringBuilder.append(")");
        System.out.println(stringBuilder.toString());
        System.out.println(count);
    }


}
