package com.common.generate.javacreate.test.transferNote;

import com.alibaba.fastjson.JSON;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/12/28 16:56
 */
public class TransferUtils {


    public static void main(String[] args){
        TransferUtils transferUtils = new TransferUtils();
        System.out.println("---------------------------------------------------------");
        transferUtils.checkERPItemId();
        System.out.println("---------------------------------------------------------");
        transferUtils.getoldItem();
        System.out.println("---------------------------------------------------------");
    }


    public void checkERPItemId(){
        AllocationNoteFromErp oldErp = getProduct(getOld());
        AllocationNoteFromErp newErp = getProduct(getNew());

        List<AllocationNoteItemFromErp> newItems = newErp.getItems();
        List<AllocationNoteItemFromErp> oldErpItems = oldErp.getItems();
        Map<String, AllocationNoteItemFromErp> newItemMap = newItems.stream().collect(Collectors.toMap(it -> it.getProductSkuId(), it -> it));
        Map<String, AllocationNoteItemFromErp> oldItemMap = oldErpItems.stream().collect(Collectors.toMap(it -> it.getProductSkuId(), it -> it));
        newItems = newItems.stream().sorted(Comparator.comparing(AllocationNoteItemFromErp::getProductName)).collect(Collectors.toList());
        for (AllocationNoteItemFromErp item : newItems) {
            AllocationNoteItemFromErp oldItem = oldItemMap.get(item.getProductSkuId());
            System.out.println(String.format("%s:%s:%s:%s", item.getProductName(), item.getProductSkuId(),
                    oldItem == null ? null : oldItem.getBusinessItemId(), item.getBusinessItemId()));
        }
    }



    public AllocationNoteFromErp getProduct(String json){
        AllocationNoteFromErp allocationNoteFromErp = JSON.parseObject(json, AllocationNoteFromErp.class);
        return allocationNoteFromErp;
    }

    public void getoldItem(){
        String json ="[\n" +
                "    {\n" +
                "        \"applyPackageCount\": 40.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 240.000000,\n" +
                "        \"brandName\": \"汾酒\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"ec1bc979e6fd4a528b5c97201c68f299\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317205\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 40.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"45586\",\n" +
                "        \"productName\": \"汾酒汾牌珍藏V9/42度475ml（1*6）\",\n" +
                "        \"productSkuId\": \"70300046107799\",\n" +
                "        \"productSpecificationId\": \"46107\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 40.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 240.000000,\n" +
                "        \"brandName\": \"汾酒\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"8d05a2aff8754daba015a4f0e579240b\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317206\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 40.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"45587\",\n" +
                "        \"productName\": \"汾酒汾牌原浆V6/53度475ml（1*6）\",\n" +
                "        \"productSkuId\": \"70300046108426\",\n" +
                "        \"productSpecificationId\": \"46108\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 5.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 30.000000,\n" +
                "        \"brandName\": \"泸州老窖\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"e1f05772c20940dd83578f52fa17881a\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317207\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 5.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"54131\",\n" +
                "        \"productName\": \"泸州老窖鉴赏级酒品珍藏5V/52度480ml（1*6）\",\n" +
                "        \"productSkuId\": \"70300054816239\",\n" +
                "        \"productSpecificationId\": \"54816\",\n" +
                "        \"secOwnerId\": \"1395869718239575060\",\n" +
                "        \"secOwnerName\": \"昆明批发\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 30.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 180.000000,\n" +
                "        \"brandName\": \"西凤\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"0db1bc38a43241d9b472fd0796c75160\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317208\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 30.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"226654\",\n" +
                "        \"productName\": \"西凤百年凤牌醇品52度500ml（1*6）\",\n" +
                "        \"productSkuId\": \"70300233461995\",\n" +
                "        \"productSpecificationId\": \"233461\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 10.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 60.000000,\n" +
                "        \"brandName\": \"法蘭慕桐庄园\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"70b97f018aae478cb2b2b22efbf74625\",\n" +
                "        \"category\": \"葡萄酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317209\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 10.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"242767\",\n" +
                "        \"productName\": \"法国法蘭慕桐庄园珍藏干红葡萄酒13度750ml（1*6）\",\n" +
                "        \"productSkuId\": \"70300249785454\",\n" +
                "        \"productSpecificationId\": \"249785\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 2.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 12.000000,\n" +
                "        \"brandName\": \"奔富\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"9353eca804804a988b933e100222de97\",\n" +
                "        \"category\": \"葡萄酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317210\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 2.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"289873\",\n" +
                "        \"productName\": \"Penfolds澳大利亚奔富俱乐部Club汤尼利口葡萄酒17.5度750ml 【可带票】（1*6）\",\n" +
                "        \"productSkuId\": \"4826098755274353684\",\n" +
                "        \"productSpecificationId\": \"298360\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 26.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 156.000000,\n" +
                "        \"brandName\": \"种子\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"6aad998035a04ca08aaff5ee5f86c821\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317211\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 26.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"476211\",\n" +
                "        \"productName\": \"种子酒90年代复兴版42度500ml（1*6）\",\n" +
                "        \"productSkuId\": \"4981932347334553094\",\n" +
                "        \"productSpecificationId\": \"493293\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 1.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 6.000000,\n" +
                "        \"brandName\": \"酱中王子\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"92d89adc429b405095ee2d74caa7afed\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317212\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 1.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"486770\",\n" +
                "        \"productName\": \"贵州酱中王子酒金碧辉煌（红）酱香型53度500ml（1*6）\",\n" +
                "        \"productSkuId\": \"4994986420432983133\",\n" +
                "        \"productSpecificationId\": \"504092\",\n" +
                "        \"secOwnerId\": \"1395869718239580256\",\n" +
                "        \"secOwnerName\": \"四川百加迪酒业有限公司\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 17.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 68.000000,\n" +
                "        \"brandName\": \"金六福\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"1e5b611bac1344b2b669d4aaa0156f0c\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317213\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 17.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"488845\",\n" +
                "        \"productName\": \"金六福（金酿伍号）50度500ml*2瓶（1*2）\",\n" +
                "        \"productSkuId\": \"4997792924628437259\",\n" +
                "        \"productSpecificationId\": \"506202\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 4.000000,\n" +
                "        \"specificationText\": \"4瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 10.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 60.000000,\n" +
                "        \"brandName\": \"金六福\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"0caac653a11d4d42a407931644c6b01e\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317214\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 10.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"489084\",\n" +
                "        \"productName\": \"金六福年年有余50度500ml(1*6)\",\n" +
                "        \"productSkuId\": \"4997859377861809228\",\n" +
                "        \"productSpecificationId\": \"506443\",\n" +
                "        \"secOwnerId\": \"2405152967303993829\",\n" +
                "        \"secOwnerName\": \"成都峰泽元年网络科技有限公司\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 5.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 30.000000,\n" +
                "        \"brandName\": \"金六福\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"0442325dcdcb4eeebc825e0fe6050386\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317215\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 5.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"489086\",\n" +
                "        \"productName\": \"金六福酒福满佳禧T10（红）50度500ml(1*6)\",\n" +
                "        \"productSkuId\": \"4997862519334783244\",\n" +
                "        \"productSpecificationId\": \"506445\",\n" +
                "        \"secOwnerId\": \"2405152967303993829\",\n" +
                "        \"secOwnerName\": \"成都峰泽元年网络科技有限公司\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    }\n" +
                "]";
        json ="[\n" +
                "    {\n" +
                "        \"applyPackageCount\": 40.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 240.000000,\n" +
                "        \"brandName\": \"汾酒\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"4912f2e0c0924131853a5701f0564937\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317205\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 40.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"45586\",\n" +
                "        \"productName\": \"汾酒汾牌珍藏V9/42度475ml（1*6）\",\n" +
                "        \"productSkuId\": \"70300046107799\",\n" +
                "        \"productSpecificationId\": \"46107\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 40.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 240.000000,\n" +
                "        \"brandName\": \"汾酒\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"c1ee169d01d1415d80978240f597e0f4\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317206\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 40.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"45587\",\n" +
                "        \"productName\": \"汾酒汾牌原浆V6/53度475ml（1*6）\",\n" +
                "        \"productSkuId\": \"70300046108426\",\n" +
                "        \"productSpecificationId\": \"46108\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 5.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 30.000000,\n" +
                "        \"brandName\": \"泸州老窖\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"c7f26363da8c44a8b4847380657cea1b\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317207\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 5.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"54131\",\n" +
                "        \"productName\": \"泸州老窖鉴赏级酒品珍藏5V/52度480ml（1*6）\",\n" +
                "        \"productSkuId\": \"70300054816239\",\n" +
                "        \"productSpecificationId\": \"54816\",\n" +
                "        \"secOwnerId\": \"1395869718239575060\",\n" +
                "        \"secOwnerName\": \"昆明批发\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 30.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 180.000000,\n" +
                "        \"brandName\": \"西凤\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"51f95cf213f74909bb0326251f4bfa74\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317208\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 30.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"226654\",\n" +
                "        \"productName\": \"西凤百年凤牌醇品52度500ml（1*6）\",\n" +
                "        \"productSkuId\": \"70300233461995\",\n" +
                "        \"productSpecificationId\": \"233461\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 10.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 60.000000,\n" +
                "        \"brandName\": \"法蘭慕桐庄园\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"88c7030cbd4d4bca923a2eae6ef58784\",\n" +
                "        \"category\": \"葡萄酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317209\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 10.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"242767\",\n" +
                "        \"productName\": \"法国法蘭慕桐庄园珍藏干红葡萄酒13度750ml（1*6）\",\n" +
                "        \"productSkuId\": \"70300249785454\",\n" +
                "        \"productSpecificationId\": \"249785\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 2.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 12.000000,\n" +
                "        \"brandName\": \"奔富\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"f40d85586fc846fbb47f482345bbb55b\",\n" +
                "        \"category\": \"葡萄酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317210\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 2.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"289873\",\n" +
                "        \"productName\": \"Penfolds澳大利亚奔富俱乐部Club汤尼利口葡萄酒17.5度750ml 【可带票】（1*6）\",\n" +
                "        \"productSkuId\": \"4826098755274353684\",\n" +
                "        \"productSpecificationId\": \"298360\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 26.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 156.000000,\n" +
                "        \"brandName\": \"种子\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"0edfe386eec74886860e47e3ec5bd95e\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317211\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 26.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"476211\",\n" +
                "        \"productName\": \"种子酒90年代复兴版42度500ml（1*6）\",\n" +
                "        \"productSkuId\": \"4981932347334553094\",\n" +
                "        \"productSpecificationId\": \"493293\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 1.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 6.000000,\n" +
                "        \"brandName\": \"酱中王子\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"1f0017ea49a84dfc91c318277b5d7bd3\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317212\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 1.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"486770\",\n" +
                "        \"productName\": \"贵州酱中王子酒金碧辉煌（红）酱香型53度500ml（1*6）\",\n" +
                "        \"productSkuId\": \"4994986420432983133\",\n" +
                "        \"productSpecificationId\": \"504092\",\n" +
                "        \"secOwnerId\": \"1395869718239580256\",\n" +
                "        \"secOwnerName\": \"四川百加迪酒业有限公司\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 17.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 68.000000,\n" +
                "        \"brandName\": \"金六福\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"cf98b64422c6410faf924708d811d58b\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317213\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 17.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"488845\",\n" +
                "        \"productName\": \"金六福（金酿伍号）50度500ml*2瓶（1*2）\",\n" +
                "        \"productSkuId\": \"4997792924628437259\",\n" +
                "        \"productSpecificationId\": \"506202\",\n" +
                "        \"secOwnerId\": \"1\",\n" +
                "        \"secOwnerName\": \"易久批自营\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 4.000000,\n" +
                "        \"specificationText\": \"4瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 10.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 60.000000,\n" +
                "        \"brandName\": \"金六福\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"f2cfd827ea3a4a10a3a8059541526dd3\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317214\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 10.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"489084\",\n" +
                "        \"productName\": \"金六福年年有余50度500ml(1*6)\",\n" +
                "        \"productSkuId\": \"4997859377861809228\",\n" +
                "        \"productSpecificationId\": \"506443\",\n" +
                "        \"secOwnerId\": \"2405152967303993829\",\n" +
                "        \"secOwnerName\": \"成都峰泽元年网络科技有限公司\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"applyPackageCount\": 5.000000,\n" +
                "        \"applyUnitCount\": 0.000000,\n" +
                "        \"applyUnitTotalCount\": 30.000000,\n" +
                "        \"brandName\": \"金六福\",\n" +
                "        \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "        \"businessItemId\": \"e1e9bc359ff34faf9c48935ce80a1d90\",\n" +
                "        \"category\": \"白酒\",\n" +
                "        \"channel\": 0,\n" +
                "        \"cityId\": 703,\n" +
                "        \"createTime\": 1640655635000,\n" +
                "        \"dayOfShelfLife\": 0,\n" +
                "        \"id\": \"5007559677649317215\",\n" +
                "        \"inStockApplyId\": \"5007559677627043028\",\n" +
                "        \"inStockPackageCount\": 0.000000,\n" +
                "        \"inStockUnitCount\": 0.000000,\n" +
                "        \"inStockUnitTotalCount\": 0.000000,\n" +
                "        \"isDelete\": 0,\n" +
                "        \"isGift\": 0,\n" +
                "        \"lastUpdateTime\": 1640655635000,\n" +
                "        \"notInStockPackageCount\": 5.000000,\n" +
                "        \"notInStockUnitCount\": 0.000000,\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"price\": 0.000000,\n" +
                "        \"priceUnit\": \"件\",\n" +
                "        \"productInfoId\": \"489086\",\n" +
                "        \"productName\": \"金六福酒福满佳禧T10（红）50度500ml(1*6)\",\n" +
                "        \"productSkuId\": \"4997862519334783244\",\n" +
                "        \"productSpecificationId\": \"506445\",\n" +
                "        \"secOwnerId\": \"2405152967303993829\",\n" +
                "        \"secOwnerName\": \"成都峰泽元年网络科技有限公司\",\n" +
                "        \"source\": 0,\n" +
                "        \"specQuantity\": 6.000000,\n" +
                "        \"specificationText\": \"6瓶/件\",\n" +
                "        \"totalAmount\": 0.000000,\n" +
                "        \"unitName\": \"瓶\"\n" +
                "    }\n" +
                "]";
        List<Map> list = JSON.parseArray(json, Map.class);
        list = list.stream().sorted(Comparator.comparing(TransferUtils::getName)).collect(Collectors.toList());

        for (Map map : list) {
//            System.out.println(String.format("%s:%s:%s:%s",map.get("id"),map.get("productName"),map.get("businessItemId"),null));
            System.out.println(String.format("%s:%s:%s",map.get("productName"),map.get("businessItemId"),map.get("applyUnitTotalCount")));
        }

    }

    private static String getName(Map map){
        return (String) map.get("productName");

    }


    public String getOld(){
        return "{\n" +
                "    \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "    \"businessNo\": \"202112260040\",\n" +
                "    \"contact\": \"傅建军\",\n" +
                "    \"contactPhone\": \"15320177131\",\n" +
                "    \"detailAddress\": \"天津市天津市东丽区天津市天津市东丽区金钟公路南跃进路西侧金兴道1号天津永达不锈钢制品公司\",\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"businessItemId\": \"9353eca804804a988b933e100222de97\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 12.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"奔富\",\n" +
                "            \"productName\": \"Penfolds澳大利亚奔富俱乐部Club汤尼利口葡萄酒17.5度750ml 【可带票】（1*6）\",\n" +
                "            \"productSkuId\": \"4826111703198226525\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"298360\",\n" +
                "            \"statisticsCategoryName\": \"葡萄酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"70b97f018aae478cb2b2b22efbf74625\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 60.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"法蘭慕桐庄园\",\n" +
                "            \"productName\": \"法国法蘭慕桐庄园珍藏干红葡萄酒13度750ml（1*6）\",\n" +
                "            \"productSkuId\": \"89800249785105\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"249785\",\n" +
                "            \"statisticsCategoryName\": \"葡萄酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"92d89adc429b405095ee2d74caa7afed\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 6.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"酱中王子\",\n" +
                "            \"productName\": \"贵州酱中王子酒金碧辉煌（红）酱香型53度500ml（1*6）\",\n" +
                "            \"productSkuId\": \"4994988509097904389\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"504092\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"0442325dcdcb4eeebc825e0fe6050386\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 30.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"金六福\",\n" +
                "            \"productName\": \"金六福酒福满佳禧T10（红）50度500ml(1*6)\",\n" +
                "            \"productSkuId\": \"4997863002134729801\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"506445\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"0caac653a11d4d42a407931644c6b01e\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 60.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"金六福\",\n" +
                "            \"productName\": \"金六福年年有余50度500ml(1*6)\",\n" +
                "            \"productSkuId\": \"4997859743334680848\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"506443\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"e1f05772c20940dd83578f52fa17881a\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 30.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"泸州老窖\",\n" +
                "            \"productName\": \"泸州老窖鉴赏级酒品珍藏5V/52度480ml（1*6）\",\n" +
                "            \"productSkuId\": \"89800054816563\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"54816\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"0db1bc38a43241d9b472fd0796c75160\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 180.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"西凤\",\n" +
                "            \"productName\": \"西凤百年凤牌醇品52度500ml（1*6）\",\n" +
                "            \"productSkuId\": \"89800233461317\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"233461\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"6aad998035a04ca08aaff5ee5f86c821\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 156.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"种子酒\",\n" +
                "            \"productName\": \"种子酒90年代复兴版42度500ml（1*6）\",\n" +
                "            \"productSkuId\": \"4981932429173812749\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"493293\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"1e5b611bac1344b2b669d4aaa0156f0c\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 68.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"金六福\",\n" +
                "            \"productName\": \"金六福（金酿伍号）50度500ml*2瓶（1*2）\",\n" +
                "            \"productSkuId\": \"4997794626146325589\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 4,\n" +
                "            \"specificationId\": \"506202\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"8d05a2aff8754daba015a4f0e579240b\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 240.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"汾酒\",\n" +
                "            \"productName\": \"汾酒汾牌原浆V6/53度475ml（1*6）\",\n" +
                "            \"productSkuId\": \"89800046108545\",\n" +
                "            \"saleMode\": 1,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"46108\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"ec1bc979e6fd4a528b5c97201c68f299\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 240.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"汾酒\",\n" +
                "            \"productName\": \"汾酒汾牌珍藏V9/42度475ml（1*6）\",\n" +
                "            \"productSkuId\": \"89800046107287\",\n" +
                "            \"saleMode\": 1,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"46107\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"orderAmount\": 0.0,\n" +
                "    \"orderCreateTime\": 1640503824427,\n" +
                "    \"orgId\": \"898\",\n" +
                "    \"payableAmount\": 0.0,\n" +
                "    \"refType\": 111,\n" +
                "    \"refTypeName\": \"统采调拨\",\n" +
                "    \"state\": 1,\n" +
                "    \"toOrgId\": \"703\",\n" +
                "    \"toWarehouseId\": \"7031\",\n" +
                "    \"warehouseId\": \"8986\"\n" +
                "}";
    }


    public String getNew(){
        return "{\n" +
                "    \"businessId\": \"752d205d6491499f8da4f69b0d6db6ce\",\n" +
                "    \"businessNo\": \"202112260040\",\n" +
                "    \"contact\": \"傅建军\",\n" +
                "    \"contactPhone\": \"15320177131\",\n" +
                "    \"detailAddress\": \"天津市天津市东丽区天津市天津市东丽区金钟公路南跃进路西侧金兴道1号天津永达不锈钢制品公司\",\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"businessItemId\": \"cf98b64422c6410faf924708d811d58b\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 52.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"金六福\",\n" +
                "            \"productName\": \"金六福（金酿伍号）50度500ml*2瓶（1*2）\",\n" +
                "            \"productSkuId\": \"4997794626146325589\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 4,\n" +
                "            \"specificationId\": \"506202\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"fa5d49106c7e47dfa95d8acd86c042ef\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 120.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"酒鬼\",\n" +
                "            \"productName\": \"酒鬼酒（黑金版）52度500ml（1*6）\",\n" +
                "            \"productSkuId\": \"89800022326963\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"22326\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"c1ee169d01d1415d80978240f597e0f4\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 240.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"汾酒\",\n" +
                "            \"productName\": \"汾酒汾牌原浆V6/53度475ml（1*6）\",\n" +
                "            \"productSkuId\": \"89800046108545\",\n" +
                "            \"saleMode\": 1,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"46108\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"4912f2e0c0924131853a5701f0564937\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 240.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"汾酒\",\n" +
                "            \"productName\": \"汾酒汾牌珍藏V9/42度475ml（1*6）\",\n" +
                "            \"productSkuId\": \"89800046107287\",\n" +
                "            \"saleMode\": 1,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"46107\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"88c7030cbd4d4bca923a2eae6ef58784\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 60.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"法蘭慕桐庄园\",\n" +
                "            \"productName\": \"法国法蘭慕桐庄园珍藏干红葡萄酒13度750ml（1*6）\",\n" +
                "            \"productSkuId\": \"89800249785105\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"249785\",\n" +
                "            \"statisticsCategoryName\": \"葡萄酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"e1e9bc359ff34faf9c48935ce80a1d90\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 30.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"金六福\",\n" +
                "            \"productName\": \"金六福酒福满佳禧T10（红）50度500ml(1*6)\",\n" +
                "            \"productSkuId\": \"4997863002134729801\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"506445\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"f40d85586fc846fbb47f482345bbb55b\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 12.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"奔富\",\n" +
                "            \"productName\": \"Penfolds澳大利亚奔富俱乐部Club汤尼利口葡萄酒17.5度750ml 【可带票】（1*6）\",\n" +
                "            \"productSkuId\": \"4826111703198226525\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"298360\",\n" +
                "            \"statisticsCategoryName\": \"葡萄酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"51f95cf213f74909bb0326251f4bfa74\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 180.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"西凤\",\n" +
                "            \"productName\": \"西凤百年凤牌醇品52度500ml（1*6）\",\n" +
                "            \"productSkuId\": \"89800233461317\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"233461\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"c7f26363da8c44a8b4847380657cea1b\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 30.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"泸州老窖\",\n" +
                "            \"productName\": \"泸州老窖鉴赏级酒品珍藏5V/52度480ml（1*6）\",\n" +
                "            \"productSkuId\": \"89800054816563\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"54816\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"1f0017ea49a84dfc91c318277b5d7bd3\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 6.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"酱中王子\",\n" +
                "            \"productName\": \"贵州酱中王子酒金碧辉煌（红）酱香型53度500ml（1*6）\",\n" +
                "            \"productSkuId\": \"4994988509097904389\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"504092\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"f2cfd827ea3a4a10a3a8059541526dd3\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 60.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"金六福\",\n" +
                "            \"productName\": \"金六福年年有余50度500ml(1*6)\",\n" +
                "            \"productSkuId\": \"4997859743334680848\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"506443\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"0edfe386eec74886860e47e3ec5bd95e\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 156.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"种子酒\",\n" +
                "            \"productName\": \"种子酒90年代复兴版42度500ml（1*6）\",\n" +
                "            \"productSkuId\": \"4981932429173812749\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"493293\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"dc118520e52542cba5861055ec89db98\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 60.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"汾砚\",\n" +
                "            \"productName\": \"汾砚原浆酒53度2.5L（1*6）\",\n" +
                "            \"productSkuId\": \"89800137111930\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"137111\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"49b6b848db014395a6d7eabbb65f3985\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 30.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"茅台镇\",\n" +
                "            \"productName\": \"茅台镇封藏原浆酒V60/52度500ml（1*6）\",\n" +
                "            \"productSkuId\": \"89800018008042\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 6,\n" +
                "            \"specificationId\": \"18008\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"businessItemId\": \"79125924d1de4611b13ec5d772fd45e1\",\n" +
                "            \"minUnitInStockCount\": 0.0,\n" +
                "            \"minUnitOutStockCount\": 0.0,\n" +
                "            \"minUnitTotalCount\": 40.0,\n" +
                "            \"packageName\": \"件\",\n" +
                "            \"payAmount\": 0.0,\n" +
                "            \"productBrand\": \"古井贡酒\",\n" +
                "            \"productName\": \"古井醇香酒45度500ml（1*4）\",\n" +
                "            \"productSkuId\": \"4785116283104647386\",\n" +
                "            \"saleMode\": 6,\n" +
                "            \"sellPrice\": 0.0,\n" +
                "            \"sellPriceUnit\": \"瓶\",\n" +
                "            \"specQuantity\": 4,\n" +
                "            \"specificationId\": \"114448\",\n" +
                "            \"statisticsCategoryName\": \"白酒\",\n" +
                "            \"totalAmount\": 0.0,\n" +
                "            \"unitName\": \"瓶\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"orderAmount\": 0.0,\n" +
                "    \"orderCreateTime\": 1640503823817,\n" +
                "    \"orgId\": \"898\",\n" +
                "    \"payableAmount\": 0.0,\n" +
                "    \"refType\": 111,\n" +
                "    \"refTypeName\": \"统采调拨\",\n" +
                "    \"state\": 1,\n" +
                "    \"toOrgId\": \"703\",\n" +
                "    \"toWarehouseId\": \"7031\",\n" +
                "    \"warehouseId\": \"8986\"\n" +
                "}";
    }

}
