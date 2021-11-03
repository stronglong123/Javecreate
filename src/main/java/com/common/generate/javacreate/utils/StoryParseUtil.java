package com.common.generate.javacreate.utils;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.GroupSettleDTO;
import com.common.generate.javacreate.model.StoryDTO;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author xialei
 * @date 2021/9/27 9:02
 */
public class StoryParseUtil {


    public static void main(String[] args) throws Exception {
        test();
    }


    public static void test(){
        String json ="";
        GroupSettleDTO groupSettleDTO = JSON.parseObject(json, GroupSettleDTO.class);

        BigDecimal saleAmount = groupSettleDTO.getSaleSettleSkuList().stream().map(it -> it.getTotalAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal returnAmount = groupSettleDTO.getReturnSettleSkuList().stream().map(it -> it.getTotalAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("销售金额："+saleAmount);
        System.out.println("退货金额："+returnAmount);
        System.out.println("计算金额："+saleAmount.subtract(returnAmount));

    }



    public static void getContent() throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\测试.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<StoryDTO> list = ExcelUtils.readExcelToEntity(StoryDTO.class, file, "测试.xlsx");
        list.forEach(it->{
            if(StringUtils.isNotEmpty(it.getTitle())){
                String title = it.getTitle().replace("qw-wp", "");
                it.setTitle(title.trim());
            }
        });
        writeDataHubData(list,"测试");
    }



    /**
     * 写入txt文件
     * @param result
     * @param fileName
     * @return
     */
    public static boolean writeDataHubData(List<StoryDTO> result, String fileName) {
        long start = System.currentTimeMillis();
        String filePath = "C:\\Users\\Administrator\\Desktop\\txt";
        boolean flag = false;
        BufferedWriter out = null;
        try {
            if (result != null && !result.isEmpty() && StringUtils.isNotEmpty(fileName)) {
                fileName += "_" + System.currentTimeMillis() + ".txt";
                File pathFile = new File(filePath);
                /**文件夹不存在则重新创建*/
                if (!pathFile.exists()) {
                    pathFile.mkdirs();
                }
                String relFilePath = filePath + File.separator + fileName;
                File file = new File(relFilePath);
                /**文件不存在则重新创建*/
                if (!file.exists()) {
                    file.createNewFile();
                }
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
                for (StoryDTO storyDTO : result) {
                    out.write(storyDTO.getTitle());
                    out.newLine();
                    out.write(storyDTO.getContext());
                    out.newLine();
                }
                flag = true;
                //                logger.info("写入文件耗时：*********************************" + (System.currentTimeMillis() - start) + "毫秒");
                System.out.println("写入文件耗时：*********************************" + (System.currentTimeMillis() - start) + "毫秒");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return flag;
        }
    }
}

