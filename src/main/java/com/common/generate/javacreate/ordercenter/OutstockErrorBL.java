package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.OrderItemBO;
import com.common.generate.javacreate.ordercenter.dto.PartlyMarkOrderDTO;
import com.common.generate.javacreate.ordercenter.dto.PartlyMarkOrderItemDTO;
import com.common.generate.javacreate.ordercenter.dto.WarehouseDataDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2022/10/14 11:11
 */

@Service
public class OutstockErrorBL {


    public static void main(String[] args) throws Exception {
        List<PartlyMarkOrderDTO> wmsList = getError();

//        List<Long> orderIds = errorList.stream().map(it -> it.getOrderId()).collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(orderIds));
        Map<Long, PartlyMarkOrderItemDTO> wmsItemMap = wmsList.stream().flatMap(it -> it.getTrainsOutStockOrderItemList().stream()).collect(Collectors.toMap(it -> it.getOrderItemId(), it -> it));

        List<OrderItemBO> orderItemBOList = getOrderItemBO();
        for (OrderItemBO itemBO : orderItemBOList) {
            PartlyMarkOrderItemDTO partlyMarkOrderItemDTO = wmsItemMap.get(itemBO.getOrderItemId());
            if (partlyMarkOrderItemDTO == null) {

                System.out.println("明细id，没有对应出库数量," + itemBO.getOrderItemId()+","+itemBO.getOrderId());
                continue;
            }
            itemBO.setWmsOutCount(partlyMarkOrderItemDTO.getUnitTotalCount());
        }
        System.out.println(JSON.toJSONString(orderItemBOList));

        List<OrderItemBO> error = orderItemBOList.stream().filter(it->it.getCount().compareTo(it.getWmsOutCount())!=0).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(error));
    }



    private static List<OrderItemBO> getOrderItemBO() throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\出库数据待修复.xlsx";
        List<OrderItemBO> orderItemBOS = ExcelUtils.readExcelToEntity(OrderItemBO.class, filePath, "出库数据待修复.xlsx");
        return orderItemBOS;
    }


    public static List<PartlyMarkOrderDTO> getError(){
        String json ="[\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191082674,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049540,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049541,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049542,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049543,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049544,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049545,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049546,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049547,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049548,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 200.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 200.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049549,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191082675,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049550,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 1.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 1.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049551,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 5.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 5.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191082678,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049557,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 1.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 1.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191082679,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049558,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 2.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 2.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191082680,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049559,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 204.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 204.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049560,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 2220.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 2220.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049561,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 984.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 984.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049562,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 3.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 3.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191082681,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049563,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 96.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 96.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049564,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 2.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 2.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049565,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 96.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 96.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049566,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 2.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 2.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191082682,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049567,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 24.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 24.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049568,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 1.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 1.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049569,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 48.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 48.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049570,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 1.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 1.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049571,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 48.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 48.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049572,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 2.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 2.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191082683,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049573,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 10.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 10.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191082684,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049574,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 3264.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 3264.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049575,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 136.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 136.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049576,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 3.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 3.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191082685,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049577,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 24.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 24.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049578,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 15.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 15.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049579,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 15.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 15.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191049580,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191182686,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191149581,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191149582,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 6.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 6.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191182687,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191149583,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 30.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 30.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191149584,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191149585,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191149586,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 24.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 24.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191149587,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191149588,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 3.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 3.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191282688,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191249589,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 10.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 10.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191249590,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 5.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 5.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191282689,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191249591,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 48.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 48.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191249592,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 2.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 2.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191249593,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 120.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 120.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191282690,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191249594,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191249595,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 3.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 3.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191249596,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 48.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 48.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191249597,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 1.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 1.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191282691,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191249598,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 10.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 10.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191249599,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 5.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 5.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191249600,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 5.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 5.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191249601,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 5.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 5.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191382692,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191349602,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 9.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 9.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191349603,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 27.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 27.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191349604,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 3.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 3.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191349605,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 18.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 18.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191349606,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 2.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 2.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191382698,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191349622,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 60.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 60.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191349623,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 3.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 3.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191482701,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191449642,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 60.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 60.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191449643,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 5.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 5.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191482702,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191449644,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 20.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 20.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191449645,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 48.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 48.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191582704,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549650,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 6.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 6.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549651,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 6.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 6.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191582705,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549652,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 50.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 50.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549653,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 24.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 24.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549654,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 24.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 24.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549655,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 20.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 20.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549656,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 30.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 30.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549657,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 16.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 16.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549658,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 24.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 24.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191582706,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549659,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 1.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 1.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191582708,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549669,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549670,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549671,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191549672,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"orderId\": 7460002208191782714,\n" +
                "        \"orderType\": 1,\n" +
                "        \"trainsOutStockOrderItemList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191749706,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191749707,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191749708,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 24.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 24.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191749709,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 12.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"orderItemId\": 7460012208191749710,\n" +
                "                \"trainsOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 1.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"unitTotalCount\": 1.0\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";
        List<PartlyMarkOrderDTO> partlyMarkOrderDTO = JSON.parseArray(json, PartlyMarkOrderDTO.class);
        return partlyMarkOrderDTO;

    }

}
