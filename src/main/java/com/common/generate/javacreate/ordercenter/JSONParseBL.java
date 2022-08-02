package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @author xialei
 * @date 2022/7/12 10:04
 */
public class JSONParseBL {


    public static void main(String[] args) {
        String paramas = getParamas();
        String items = getItems();
        String main = getmain();
        Map<String, Map> map = JSON.parseObject(paramas, Map.class);

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Map> entry : map.entrySet()) {
            String value = entry.getKey();
            Map entryValue = entry.getValue();
            String type = (String) entryValue.get("type");
            String description = (String) entryValue.get("description");
            if (StringUtils.isNotEmpty(description)) {
                stringBuilder.append("/**\n" +
                        "     * " + description + "\n" +
                        "     */");
            }
            stringBuilder.append("private ").append(parseType(type)).append(" ").append(value).append(";");

        }
        System.out.println(stringBuilder.toString());
    }


    private static String parseType(String type) {

        switch (type) {
            case "string":
                return "String";
            case "number":
                return "Long";
            case "array":
                return "List<Object>";
        }
        return "String";
    }


    public static String getmain() {
        return "{\n" +
                "    \"applicantId\": {\n" +
                "        \"description\": \"兑奖人id\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"companyCode\": {\n" +
                "        \"description\": \"公司code\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"hopeDeliveryTime\": {\n" +
                "        \"description\": \"期望配送日期\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@timestamp\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"itemList\": {\n" +
                "        \"description\": \"订单明细 ,SynchronizeOrderItemDTO\",\n" +
                "        \"items\": {\n" +
                "            \"description\": \"订单明细 ,SynchronizeOrderItemDTO\",\n" +
                "            \"properties\": {\n" +
                "                \"orderAmount\": {\n" +
                "                    \"description\": \"产品总价\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@float\"\n" +
                "                    },\n" +
                "                    \"type\": \"number\"\n" +
                "                },\n" +
                "                \"orderId\": {\n" +
                "                    \"description\": \"订单id\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@integer\"\n" +
                "                    },\n" +
                "                    \"type\": \"number\"\n" +
                "                },\n" +
                "                \"orderItemId\": {\n" +
                "                    \"description\": \"订单明细id\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@integer\"\n" +
                "                    },\n" +
                "                    \"type\": \"number\"\n" +
                "                },\n" +
                "                \"packageName\": {\n" +
                "                    \"description\": \"大单位\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@string\"\n" +
                "                    },\n" +
                "                    \"type\": \"string\"\n" +
                "                },\n" +
                "                \"payableAmount\": {\n" +
                "                    \"description\": \"应付金额\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@float\"\n" +
                "                    },\n" +
                "                    \"type\": \"number\"\n" +
                "                },\n" +
                "                \"priceUnit\": {\n" +
                "                    \"description\": \"价格单位\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@string\"\n" +
                "                    },\n" +
                "                    \"type\": \"string\"\n" +
                "                },\n" +
                "                \"productName\": {\n" +
                "                    \"description\": \"产品名称\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@string\"\n" +
                "                    },\n" +
                "                    \"type\": \"string\"\n" +
                "                },\n" +
                "                \"productSaleSpec\": {\n" +
                "                    \"description\": \"销售规格名称\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@string\"\n" +
                "                    },\n" +
                "                    \"type\": \"string\"\n" +
                "                },\n" +
                "                \"productSkuId\": {\n" +
                "                    \"description\": \"产品skuId(wms)\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@integer\"\n" +
                "                    },\n" +
                "                    \"type\": \"number\"\n" +
                "                },\n" +
                "                \"productSpec\": {\n" +
                "                    \"description\": \"包装规格名称\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@string\"\n" +
                "                    },\n" +
                "                    \"type\": \"string\"\n" +
                "                },\n" +
                "                \"requestMinCount\": {\n" +
                "                    \"description\": \"小数量\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@float\"\n" +
                "                    },\n" +
                "                    \"type\": \"number\"\n" +
                "                },\n" +
                "                \"salePrice\": {\n" +
                "                    \"description\": \"销售价格\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@float\"\n" +
                "                    },\n" +
                "                    \"type\": \"number\"\n" +
                "                },\n" +
                "                \"saleSpecQuantity\": {\n" +
                "                    \"description\": \"销售规格系数\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@float\"\n" +
                "                    },\n" +
                "                    \"type\": \"number\"\n" +
                "                },\n" +
                "                \"saleUnit\": {\n" +
                "                    \"description\": \"销售单位\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@string\"\n" +
                "                    },\n" +
                "                    \"type\": \"string\"\n" +
                "                },\n" +
                "                \"specQuantity\": {\n" +
                "                    \"description\": \"包装规格系数\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@float\"\n" +
                "                    },\n" +
                "                    \"type\": \"number\"\n" +
                "                },\n" +
                "                \"totalDiscountAmount\": {\n" +
                "                    \"description\": \"优惠合计金额\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@float\"\n" +
                "                    },\n" +
                "                    \"type\": \"number\"\n" +
                "                },\n" +
                "                \"unitName\": {\n" +
                "                    \"description\": \"小单位\",\n" +
                "                    \"mock\": {\n" +
                "                        \"mock\": \"@string\"\n" +
                "                    },\n" +
                "                    \"type\": \"string\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"required\": [],\n" +
                "            \"type\": \"object\"\n" +
                "        },\n" +
                "        \"type\": \"array\"\n" +
                "    },\n" +
                "    \"orderAmount\": {\n" +
                "        \"description\": \"订单金额\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@float\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"orderContactDTO\": {\n" +
                "        \"description\": \"收货人信息 ,OrderContactDTO\",\n" +
                "        \"properties\": {\n" +
                "            \"addressId\": {\n" +
                "                \"description\": \"配送地址id\",\n" +
                "                \"mock\": {\n" +
                "                    \"mock\": \"@integer\"\n" +
                "                },\n" +
                "                \"type\": \"number\"\n" +
                "            },\n" +
                "            \"city\": {\n" +
                "                \"description\": \"市\",\n" +
                "                \"mock\": {\n" +
                "                    \"mock\": \"@string\"\n" +
                "                },\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"contact\": {\n" +
                "                \"description\": \"收货人名称\",\n" +
                "                \"mock\": {\n" +
                "                    \"mock\": \"@string\"\n" +
                "                },\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"contactCompanyName\": {\n" +
                "                \"description\": \"收货人公司\",\n" +
                "                \"mock\": {\n" +
                "                    \"mock\": \"@string\"\n" +
                "                },\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"contactPhone\": {\n" +
                "                \"description\": \"收货人电话\",\n" +
                "                \"mock\": {\n" +
                "                    \"mock\": \"@string\"\n" +
                "                },\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"county\": {\n" +
                "                \"description\": \"县（区）\",\n" +
                "                \"mock\": {\n" +
                "                    \"mock\": \"@string\"\n" +
                "                },\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"detailAddress\": {\n" +
                "                \"description\": \"详细地址\",\n" +
                "                \"mock\": {\n" +
                "                    \"mock\": \"@string\"\n" +
                "                },\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"latitude\": {\n" +
                "                \"description\": \"纬度\",\n" +
                "                \"mock\": {\n" +
                "                    \"mock\": \"@float\"\n" +
                "                },\n" +
                "                \"type\": \"number\"\n" +
                "            },\n" +
                "            \"longitude\": {\n" +
                "                \"description\": \"经度\",\n" +
                "                \"mock\": {\n" +
                "                    \"mock\": \"@float\"\n" +
                "                },\n" +
                "                \"type\": \"number\"\n" +
                "            },\n" +
                "            \"province\": {\n" +
                "                \"description\": \"省\",\n" +
                "                \"mock\": {\n" +
                "                    \"mock\": \"@string\"\n" +
                "                },\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"signboard\": {\n" +
                "                \"description\": \"店铺名称\",\n" +
                "                \"mock\": {\n" +
                "                    \"mock\": \"@string\"\n" +
                "                },\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"street\": {\n" +
                "                \"description\": \"街道\",\n" +
                "                \"mock\": {\n" +
                "                    \"mock\": \"@string\"\n" +
                "                },\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"userId\": {\n" +
                "                \"description\": \"会员id\",\n" +
                "                \"mock\": {\n" +
                "                    \"mock\": \"@string\"\n" +
                "                },\n" +
                "                \"type\": \"string\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"required\": [],\n" +
                "        \"type\": \"object\"\n" +
                "    },\n" +
                "    \"orderCreateTime\": {\n" +
                "        \"description\": \"下单时间\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@timestamp\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"orderId\": {\n" +
                "        \"description\": \"订单id\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@integer\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"orderNo\": {\n" +
                "        \"description\": \"订单号\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"orderSource\": {\n" +
                "        \"description\": \"订单来源 0：安卓商城,1：苹果商城,2：微信商城,3：PC商城,4：微信小程序,5：易经销,6：供应链司机,7：百度小程序,8：CRM\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@integer\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"payableAmount\": {\n" +
                "        \"description\": \"应付金额\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@float\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"totalDiscountAmount\": {\n" +
                "        \"description\": \"优惠合计金额\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@float\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"warehouseId\": {\n" +
                "        \"description\": \"收货仓库id\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@integer\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    }\n" +
                "}";
    }


    public static String getItems() {
        return "{\n" +
                "    \"orderAmount\": {\n" +
                "        \"description\": \"产品总价\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@float\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"orderId\": {\n" +
                "        \"description\": \"订单id\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@integer\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"orderItemId\": {\n" +
                "        \"description\": \"订单明细id\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@integer\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"packageName\": {\n" +
                "        \"description\": \"大单位\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"payableAmount\": {\n" +
                "        \"description\": \"应付金额\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@float\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"priceUnit\": {\n" +
                "        \"description\": \"价格单位\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"productName\": {\n" +
                "        \"description\": \"产品名称\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"productSaleSpec\": {\n" +
                "        \"description\": \"销售规格名称\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"productSkuId\": {\n" +
                "        \"description\": \"产品skuId(wms)\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@integer\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"productSpec\": {\n" +
                "        \"description\": \"包装规格名称\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"requestMinCount\": {\n" +
                "        \"description\": \"小数量\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@float\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"salePrice\": {\n" +
                "        \"description\": \"销售价格\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@float\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"saleSpecQuantity\": {\n" +
                "        \"description\": \"销售规格系数\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@float\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"saleUnit\": {\n" +
                "        \"description\": \"销售单位\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"specQuantity\": {\n" +
                "        \"description\": \"包装规格系数\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@float\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"totalDiscountAmount\": {\n" +
                "        \"description\": \"优惠合计金额\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@float\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"unitName\": {\n" +
                "        \"description\": \"小单位\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    }\n" +
                "}";
    }

    public static String getParamas() {
        return "{\n" +
                "    \"addressId\": {\n" +
                "        \"description\": \"配送地址id\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@integer\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"city\": {\n" +
                "        \"description\": \"市\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"contact\": {\n" +
                "        \"description\": \"收货人名称\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"contactCompanyName\": {\n" +
                "        \"description\": \"收货人公司\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"contactPhone\": {\n" +
                "        \"description\": \"收货人电话\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"county\": {\n" +
                "        \"description\": \"县（区）\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"detailAddress\": {\n" +
                "        \"description\": \"详细地址\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"latitude\": {\n" +
                "        \"description\": \"纬度\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@float\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"longitude\": {\n" +
                "        \"description\": \"经度\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@float\"\n" +
                "        },\n" +
                "        \"type\": \"number\"\n" +
                "    },\n" +
                "    \"province\": {\n" +
                "        \"description\": \"省\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"signboard\": {\n" +
                "        \"description\": \"店铺名称\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"street\": {\n" +
                "        \"description\": \"街道\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"userId\": {\n" +
                "        \"description\": \"会员id\",\n" +
                "        \"mock\": {\n" +
                "            \"mock\": \"@string\"\n" +
                "        },\n" +
                "        \"type\": \"string\"\n" +
                "    }\n" +
                "}";
    }
}
