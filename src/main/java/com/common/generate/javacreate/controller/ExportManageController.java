package com.common.generate.javacreate.controller;

import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.utils.excel.XlsViewMap;
import com.common.generate.javacreate.utils.excel.XlsxViewMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;

/**
 * @author xialei
 * @date 2021/6/3 17:08
 */

@IgnoreAuthInterceptor
@Controller
public class ExportManageController {

    /**
     * 下载货主批量导入模板
     */
    @GetMapping(value = "/templates/download")
    public String downloadCargoOwner(Model model) {
        model.addAttribute("dataList", Collections.emptyList());
        model.addAttribute("Fields", "");
        model.addAttribute("DisplayNames", "货主名称,货主编码,类型:经销商/供应商,联系人,电话");
        model.addAttribute("sheet","货主");
        model.addAttribute("fileName", "货主批量导入.xlsx");
        return XlsxViewMap.VIEW_NAME;
    }

}
