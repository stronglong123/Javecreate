package com.common.generate.javacreate.test.dto;

import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleOrderBillDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author xialei
 * @date 2021/5/7 9:28
 */
public class CheckDTO {


    private ErpProductSecDTO  erpProduct;

    private GroupSettleOrderBillDTO  wmsProduct;

    public ErpProductSecDTO getErpProduct() {
        return erpProduct;
    }

    public void setErpProduct(ErpProductSecDTO erpProduct) {
        if(erpProduct==null){
            this.erpProduct = erpProduct;
        }else {
            ErpProductSecDTO erpProductSecDTO = new ErpProductSecDTO();
            erpProductSecDTO.setCalCount(erpProduct.getCalCount());
            erpProductSecDTO.setDesc_ProductName(erpProduct.getDesc_ProductName());
            this.erpProduct = erpProductSecDTO;
        }

    }

    public GroupSettleOrderBillDTO getWmsProduct() {
        return wmsProduct;
    }

    public void setWmsProduct(GroupSettleOrderBillDTO wmsProduct) {
        if(wmsProduct==null){
            this.wmsProduct = wmsProduct;
        }else {
            GroupSettleOrderBillDTO billDTO = new GroupSettleOrderBillDTO();
            billDTO.setCalCount(wmsProduct.getCalCount());
            billDTO.setSkuName(wmsProduct.getSkuName());
            this.wmsProduct = billDTO;
        }

    }
}
