package com.common.generate.javacreate.service.newcheck;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * @author liaojiejie
 * @date 2021/05/14
 */
public class ParseDataServiceTest {
	
	/**
	 * 二级货主转换
	 * 
	 * @param filePath
	 * @return
	 */
	public static Map<String, Long> getOwnerMap(String filePath){
		Map<String, Long> ownerMap = new HashMap<>();
		try {
			File file = new File(filePath);
			
			LineIterator lineIterator = FileUtils.lineIterator(file);
			if (lineIterator == null) {
				return ownerMap;
			}
			
			String lineStr = null;
			while (lineIterator.hasNext()) {
				lineStr = lineIterator.nextLine();
				
				String[] arrsStr = lineStr.split(",");
				
				// 规格ID
				Long ownerId = null;
				if(arrsStr[0] != null && !"".equals(arrsStr[0])) {
					ownerId = Long.parseLong(arrsStr[0]);
				}
				
				// erp的货主ID
				String erpOwnerId = arrsStr[1];
				
				ownerMap.put(erpOwnerId, ownerId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ownerMap;
	}


	/**
	 * 读取并解析ERP的数据
	 *
	 * @param readType，1 结算出，2 结算入 3 其它出 4 其它入
	 * @param filePath
	 * @param list
	 */
	public static void readAndParseNew(int readType, String filePath, List<CompareSettleOwnerDataBO> list,
									Map<String, CompareSettleOwnerDataBO> existMap, Map<String, Long> ownerMap) {

		try {
			File file = new File(filePath);

			LineIterator lineIterator = FileUtils.lineIterator(file);
			if (lineIterator == null) {
				return;
			}

			CompareSettleOwnerDataBO ownerDataBO = null;

			String lineStr = null;
			while (lineIterator.hasNext()) {
				lineStr = lineIterator.nextLine();

				String[] arrsStr = lineStr.split(",");

				// 仓库ID
				Integer warehouseId = Integer.parseInt(arrsStr[0]);


				// 规格ID
				Long productSpecId = Long.parseLong(arrsStr[1]);

				// 货主ID
				Long productOwnerId = null;
				if(arrsStr[2] != null && !"".equals(arrsStr[2])) {
					productOwnerId = ownerMap.get(arrsStr[2]);
				}

				// 二级货主数量
				BigDecimal minUnitTotalCount = new BigDecimal(arrsStr[3]);

				// 产品名称
				String skuName = arrsStr[4];

				// 唯一标识一个数据
				String key = String.valueOf(productSpecId) + productOwnerId;
				if (existMap.get(key) != null) {
					ownerDataBO = existMap.get(key);
				}else {
					ownerDataBO = new CompareSettleOwnerDataBO();
					existMap.put(key, ownerDataBO);
				}

				ownerDataBO.setType(1);
				ownerDataBO.setWarehouseId(warehouseId);
				ownerDataBO.setProductSpecId(productSpecId);
				ownerDataBO.setProductOwnerId(String.valueOf(productOwnerId));
				ownerDataBO.setSkuName(skuName);

				// 1 结算出
				if(readType == 1) {
					// 出库数量
					ownerDataBO.setDeliverMinUnitTotalCount(ownerDataBO.getDeliverMinUnitTotalCount().add(minUnitTotalCount));

					// 结算出库数量
					ownerDataBO.setSettleDeliverMinUnitTotalCount(ownerDataBO.getSettleDeliverMinUnitTotalCount().add(minUnitTotalCount));
				}

				// 2 结算入
				if (readType == 2) {
					// 入库数量
					ownerDataBO.setStoreMinUnitTotalCount(ownerDataBO.getStoreMinUnitTotalCount().add(minUnitTotalCount));

					// 结算入库数量
					ownerDataBO.setSettleStoreMinUnitTotalCount(ownerDataBO.getSettleStoreMinUnitTotalCount().add(minUnitTotalCount));
				}

				// 3 其它出
				if (readType == 3) {
					// 出库数量
					ownerDataBO.setDeliverMinUnitTotalCount(ownerDataBO.getDeliverMinUnitTotalCount().add(minUnitTotalCount));

					// 其它出库数量
					ownerDataBO.setOrtherDeliverMinUnitTotalCount(ownerDataBO.getOrtherDeliverMinUnitTotalCount().add(minUnitTotalCount));
				}

				// 4 其它入
				if (readType == 4) {
					// 入库数量
					ownerDataBO.setStoreMinUnitTotalCount(ownerDataBO.getStoreMinUnitTotalCount().add(minUnitTotalCount));

					// 其它入库数量
					ownerDataBO.setOrtherStoreMinUnitTotalCount(ownerDataBO.getOrtherStoreMinUnitTotalCount().add(minUnitTotalCount));
				}

				// 库存数量
				ownerDataBO.setWarehouseMinUnitTotalCount(ownerDataBO.getDeliverMinUnitTotalCount().subtract(ownerDataBO.getStoreMinUnitTotalCount()));

				list.add(ownerDataBO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取并解析ERP的数据
	 * 
	 * @param readType，1 结算出，2 结算入 3 其它出 4 其它入
	 * @param filePath
	 * @param list
	 */
	public static void readAndParse(Integer inWarehouseId, int readType, String filePath, List<CompareSettleOwnerDataBO> list,
			Map<String, CompareSettleOwnerDataBO> existMap, Map<String, Long> ownerMap) {
		
		try {
			File file = new File(filePath);
			
			LineIterator lineIterator = FileUtils.lineIterator(file);
			if (lineIterator == null) {
				return;
			}
			
			CompareSettleOwnerDataBO ownerDataBO = null;
			
			String lineStr = null;
			while (lineIterator.hasNext()) {
				lineStr = lineIterator.nextLine();
				
				String[] arrsStr = lineStr.split(",");
				
				// 仓库ID
				Integer warehouseId = Integer.parseInt(arrsStr[0]);
				
				if(inWarehouseId.intValue() != warehouseId) {
					continue;
				}
				
				// 规格ID
				Long productSpecId = Long.parseLong(arrsStr[1]);
				
				// 货主ID
				Long productOwnerId = null;
				if(arrsStr[2] != null && !"".equals(arrsStr[2])) {
					productOwnerId = ownerMap.get(arrsStr[2]);
				}
				
				// 二级货主数量
				BigDecimal minUnitTotalCount = new BigDecimal(arrsStr[3]);
				
				// 产品名称
				String skuName = arrsStr[4];
				
				// 唯一标识一个数据
				String key = String.valueOf(productSpecId) + productOwnerId;
				if (existMap.get(key) != null) {
					ownerDataBO = existMap.get(key);
				}else {
					ownerDataBO = new CompareSettleOwnerDataBO();
					existMap.put(key, ownerDataBO);
				}
				
				ownerDataBO.setType(1);
				ownerDataBO.setWarehouseId(warehouseId);
				ownerDataBO.setProductSpecId(productSpecId);
				ownerDataBO.setProductOwnerId(String.valueOf(productOwnerId));
				ownerDataBO.setSkuName(skuName);
				
				// 1 结算出
				if(readType == 1) {
					// 出库数量
					ownerDataBO.setDeliverMinUnitTotalCount(ownerDataBO.getDeliverMinUnitTotalCount().add(minUnitTotalCount));
					
					// 结算出库数量
					ownerDataBO.setSettleDeliverMinUnitTotalCount(ownerDataBO.getSettleDeliverMinUnitTotalCount().add(minUnitTotalCount));
				}
				
				// 2 结算入
				if (readType == 2) {
					// 入库数量
					ownerDataBO.setStoreMinUnitTotalCount(ownerDataBO.getStoreMinUnitTotalCount().add(minUnitTotalCount));
					
					// 结算入库数量
					ownerDataBO.setSettleStoreMinUnitTotalCount(ownerDataBO.getSettleStoreMinUnitTotalCount().add(minUnitTotalCount));
				}
				
				// 3 其它出
				if (readType == 3) {
					// 出库数量
					ownerDataBO.setDeliverMinUnitTotalCount(ownerDataBO.getDeliverMinUnitTotalCount().add(minUnitTotalCount));
					
					// 其它出库数量
					ownerDataBO.setOrtherDeliverMinUnitTotalCount(ownerDataBO.getOrtherDeliverMinUnitTotalCount().add(minUnitTotalCount));
				}
				
				// 4 其它入
				if (readType == 4) {
					// 入库数量
					ownerDataBO.setStoreMinUnitTotalCount(ownerDataBO.getStoreMinUnitTotalCount().add(minUnitTotalCount));
					
					// 其它入库数量
					ownerDataBO.setOrtherStoreMinUnitTotalCount(ownerDataBO.getOrtherStoreMinUnitTotalCount().add(minUnitTotalCount));
				}
				
				// 库存数量
				ownerDataBO.setWarehouseMinUnitTotalCount(ownerDataBO.getDeliverMinUnitTotalCount().subtract(ownerDataBO.getStoreMinUnitTotalCount()));
				
				list.add(ownerDataBO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
