package com.common.generate.javacreate.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.generate.javacreate.authutils.AuthUtil;
import com.common.generate.javacreate.authutils.MD5Utils;
import com.common.generate.javacreate.test.dto.ThirdSSCancelOrderDTO;
import com.common.generate.javacreate.utils.DateUtils;
import com.common.generate.javacreate.utils.HttpUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2020/8/12 13:55
 */
public class Test {


    private static String matchKey(String name,String key){
        Pattern bugNumber = Pattern.compile("\\s*([0-9]+)(?i)" + key);
        // find the bug#
        Matcher matcher = bugNumber.matcher(name);
        if(matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

    private static String getText(){
        String text ="王老吉（听装）310ml（1*24）\t10300002057249\t1030002104201794182\t4916025175355605455\tDDMC103120210418\t1031\t74\t\n" +
                "红牛维生素风味饮料（听）250ml（1*24）\t4830010229609609425\t1030002104191492592\t4916025175355605455\tDDMC103120210418\t1031\t74\t\n" +
                "王老吉（听装）310ml（1*24）\t10300002057249\t1618654645259100157\t4916025175355605455\tDDMC103120210418\t1031\t119\t\n" +
                "娃哈哈AD钙奶【新装】220g（1*24）\t10300011390332\t1030002104211194874\t4916025175355605455\tDDMC103120210418\t1031\t74\t\n" +
                "王老吉（听装）310ml（1*24）\t10300002057249\t1030002104191492592\t4916025175355605455\tDDMC103120210418\t1031\t74\t\n" +
                "百岁山饮用天然矿泉水570ml（1*24）\t10300001698774\t1030002104200993494\t4916025175355605455\tDDMC103120210418\t1031\t74\t\n" +
                "百岁山饮用天然矿泉水570ml（1*24）\t10300001698774\t1030002104221596710\t4916623377233644807\tDDMC103120210419\t1031\t74\t\n" +
                "恒大天然矿泉水570ml（1*24）\t4868120063903326040\t1030002104191492592\t4916623377233644807\tDDMC103120210419\t1031\t74\t\n" +
                "红牛维生素风味饮料（听）250ml（1*24）\t4830010229609609425\t1030002104191492592\t4916623377233644807\tDDMC103120210419\t1031\t74\t\n" +
                "黄鹤楼升级版15年42度500ml（1*6）\t10300034772186\t1030002104191492592\t4916623377233644807\tDDMC103120210419\t1031\t74\t\n" +
                "娃哈哈AD钙奶【新装】220g（1*24）\t10300011390332\t1030002104211194874\t4916623377233644807\tDDMC103120210419\t1031\t74\t\n" +
                "黄鹤楼升级版15年42度500ml（1*6）\t10300034772186\t1030002104200993494\t4916982062819721430\tDDMC103120210420\t1031\t74\t\n" +
                "银鹭花生牛奶复合蛋白饮品450ml（1*15）\t10300058592849\t1030002104221596710\t4916982062819721430\tDDMC103120210420\t1031\t74\t\n" +
                "东鹏特饮能量型营养素饮料500ml（1*24）\t10300039764286\t1030002104221596710\t4916982062819721430\tDDMC103120210420\t1031\t74\t\n" +
                "王老吉（听装）310ml（1*24）\t10300002057249\t1030002104201794182\t4916982062819721430\tDDMC103120210420\t1031\t74\t\n" +
                "恒大天然矿泉水570ml（1*24）\t4868120063903326040\t1030002104201794182\t4916982062819721430\tDDMC103120210420\t1031\t74\t\n" +
                "百岁山饮用天然矿泉水570ml（1*24）\t10300001698774\t1030002104221596710\t4916982062819721430\tDDMC103120210420\t1031\t74\t\n" +
                "恒大天然矿泉水570ml（1*24）\t4868120063903326040\t1030002104200993494\t4916982062819721430\tDDMC103120210420\t1031\t74\t\n" +
                "王老吉（听装）310ml（1*24）\t10300002057249\t1030002104221596710\t4916982062819721430\tDDMC103120210420\t1031\t74\t\n" +
                "百岁山饮用天然矿泉水570ml（1*24）\t10300001698774\t1030002104200993494\t4916982062819721430\tDDMC103120210420\t1031\t74\t\n" +
                "黄鹤楼升级版15年42度500ml（1*6）\t10300034772186\t1030002104231597963\t4916982062819721430\tDDMC103120210420\t1031\t74\t\n" +
                "云南山泉饮用天然泉水330ml（1*24）\t11900005732231\t1190002104201663437\t4916336952124861974\tDDMC119120210418\t1191\t74\t\n" +
                "蒙牛真果粒草莓果粒250ml（ 1*12）\t11900002824258\t1190002104221765629\t4916606708587203866\tDDMC119120210419\t1191\t74\t\n" +
                "云南山泉饮用天然泉水330ml（1*24）\t11900005732231\t1190002104201663437\t4916606708587203866\tDDMC119120210419\t1191\t74\t\n" +
                "乐虎380ml（1*15）\t11900003173415\t1190002104221765629\t4916606708587203866\tDDMC119120210419\t1191\t74\t\n" +
                "统一阿萨姆奶茶500ml（1*15）\t11900001544369\t1190002104201663437\t4916606708587203866\tDDMC119120210419\t1191\t74\t\n" +
                "水润坊能量100牛磺酸强化型维生素饮料600ml（1*15）\t11900107485366\t1190002104221765629\t4916606708587203866\tDDMC119120210419\t1191\t74\t\n" +
                "伊利优酸乳蓝莓味250ml（1*24）\t11900003874867\t1190002104221765629\t4916606708587203866\tDDMC119120210419\t1191\t74\t\n" +
                "统一阿萨姆奶茶500ml（1*15）\t11900001544369\t1190002104221765629\t4916606708587203866\tDDMC119120210419\t1191\t74\t\n" +
                "蒙牛真果粒蓝莓味250g（1*12）\t11900022410820\t1190002104221765629\t4916606708587203866\tDDMC119120210419\t1191\t74\t\n" +
                "淡定人生包装饮用水520ml（1*24）\t4782934981700893586\t1190002104221765629\t4916606708587203866\tDDMC119120210419\t1191\t74\t\n" +
                "蒙牛真果粒草莓果粒250ml（ 1*12）\t11900002824258\t1190002104221765629\t4916968697258981788\tDDMC119120210420\t1191\t74\t\n" +
                "云南山泉饮用天然泉水330ml（1*24）\t11900005732231\t1190002104201663437\t4916968697258981788\tDDMC119120210420\t1191\t74\t\n" +
                "伊利优酸乳蓝莓味250ml（1*24）\t11900003874867\t1190002104221765629\t4916968697258981788\tDDMC119120210420\t1191\t74\t\n" +
                "蒙牛真果粒蓝莓味250g（1*12）\t11900022410820\t1190002104221765629\t4916968697258981788\tDDMC119120210420\t1191\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104191730928\t4916334706540637721\tDDMC159120210418\t1591\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104201631047\t4916334706540637721\tDDMC159120210418\t1591\t74\t\n" +
                "王老吉（听装）310ml（1*24）\t15900002057998\t1590002104201631047\t4916334706540637721\tDDMC159120210418\t1591\t74\t\n" +
                "襄汉苦荞酒壶装42度1.6L（1*6）\t4874307702317552080\t1590002104211731226\t4916334706540637721\tDDMC159120210418\t1591\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104191430897\t4916334706540637721\tDDMC159120210418\t1591\t74\t\n" +
                "兴神龙蜂蜜米露430ml（1*15）\t15900137139844\t1590002104211731226\t4916334706540637721\tDDMC159120210418\t1591\t74\t\n" +
                "统一阿萨姆奶茶500ml（1*15）\t15900001544189\t1590002104201631047\t4916334706540637721\tDDMC159120210418\t1591\t74\t\n" +
                "王老吉（听装）310ml（1*24）\t15900002057998\t1590002104191430897\t4916334706540637721\tDDMC159120210418\t1591\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104211731226\t4916334706540637721\tDDMC159120210418\t1591\t74\t\n" +
                "王老吉凉茶植物饮料（听装）310ml（1*20）\t15900001199688\t1590002104211331184\t4916334706540637721\tDDMC159120210418\t1591\t74\t\n" +
                "统一阿萨姆奶茶500ml（1*15）\t15900001544189\t1590002104191430897\t4916334706540637721\tDDMC159120210418\t1591\t74\t\n" +
                "王老吉凉茶植物饮料（听装）310ml（1*20）\t15900001199688\t1618629620469100043\t4916334706540637721\tDDMC159120210418\t1591\t119\t\n" +
                "王老吉（听装）310ml（1*24）\t15900002057998\t1590002104201631047\t4916605509620052874\tDDMC159120210419\t1591\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104221531334\t4916605509620052874\tDDMC159120210419\t1591\t74\t\n" +
                "襄汉苦荞酒壶装42度1.6L（1*6）\t4874307702317552080\t1590002104211731226\t4916605509620052874\tDDMC159120210419\t1591\t74\t\n" +
                "兴神龙蜂蜜米露430ml（1*15）\t15900137139844\t1590002104211731226\t4916605509620052874\tDDMC159120210419\t1591\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104191730928\t4916605509620052874\tDDMC159120210419\t1591\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104211731226\t4916605509620052874\tDDMC159120210419\t1591\t74\t\n" +
                "百事可乐（塑包）1L（1*12）\t15900020284900\t1590002104191430895\t4916605509620052874\tDDMC159120210419\t1591\t74\t\n" +
                "王老吉凉茶植物饮料（听装）310ml（1*20）\t15900001199688\t1590002104211331184\t4916605509620052874\tDDMC159120210419\t1591\t74\t\n" +
                "百事可乐（塑包）1L（1*12）\t15900020284900\t1618729514264100160\t4916605509620052874\tDDMC159120210419\t1591\t75\t\n" +
                "统一阿萨姆奶茶500ml（1*15）\t15900001544189\t1590002104201631047\t4916605509620052874\tDDMC159120210419\t1591\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104201631047\t4916605509620052874\tDDMC159120210419\t1591\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104191430897\t4916966557550779152\tDDMC159120210420\t1591\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104191730928\t4916966557550779152\tDDMC159120210420\t1591\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104211731226\t4916966557550779152\tDDMC159120210420\t1591\t74\t\n" +
                "王老吉（听装）310ml（1*24）\t15900002057998\t1590002104191430897\t4916966557550779152\tDDMC159120210420\t1591\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104221531334\t4916966557550779152\tDDMC159120210420\t1591\t74\t\n" +
                "统一阿萨姆奶茶500ml（1*15）\t15900001544189\t1590002104191430897\t4916966557550779152\tDDMC159120210420\t1591\t74\t\n" +
                "统一阿萨姆奶茶500ml（1*15）\t15900001544189\t1590002104201631047\t4916966557550779152\tDDMC159120210420\t1591\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104201631047\t4916966557550779152\tDDMC159120210420\t1591\t74\t\n" +
                "怡宝矿泉水塑膜装555ml（1*24）\t4828648007766314381\t1590002104231631479\t4916966557550779152\tDDMC159120210420\t1591\t74\t\n" +
                "王老吉（听装）310ml（1*24）\t15900002057998\t1590002104201631047\t4916966557550779152\tDDMC159120210420\t1591\t74\t\n" +
                "王老吉凉茶植物饮料（听装）310ml（1*20）\t15900001199688\t1590002104211331184\t4916966557550779152\tDDMC159120210420\t1591\t74\t\n" +
                "怡宝饮用纯净水555ml（1*12）\t4843977609109277455\t1680002104211328835\t4916306244595733014\tDDMC168120210418\t1681\t74\t\n" +
                "怡宝饮用纯净水555ml（1*12）\t4843977609109277455\t1680002104211328833\t4916306244595733014\tDDMC168120210418\t1681\t74\t\n" +
                "水润坊能量100牛磺酸强化型维生素饮料600ml（1*15）\t16800107485056\t1618725542609100329\t4916306244595733014\tDDMC168120210418\t1681\t119\t\n" +
                "怡宝饮用纯净水555ml（1*12）\t4843977609109277455\t1680002104211328835\t4916627593079403398\tDDMC168120210419\t1681\t74\t\n" +
                "怡宝饮用纯净水555ml（1*12）\t4843977609109277455\t1680002104211328833\t4916627593079403398\tDDMC168120210419\t1681\t74\t\n" +
                "脉动维生素饮料青柠口味400ml（1*24）\t4914220663409259211\t1680002104251229301\t4916970255862348184\tDDMC168120210420\t1681\t74\t\n" +
                "冰冰豆奶饮料330ml （1*24）\t4851462338656020312\t1680002104251229301\t4916970255862348184\tDDMC168120210420\t1681\t74\t\n" +
                "怡宝饮用纯净水555ml（1*12）\t4843977609109277455\t1680002104211328833\t4916970255862348184\tDDMC168120210420\t1681\t74\t\n" +
                "怡宝饮用纯净水555ml（1*12）\t4843977609109277455\t1680002104211328833\t4917388557169180817\tDDMC168120210421\t1681\t74\t\n" +
                "怡宝饮用纯净水555ml（1*12）\t4843977609109277455\t1680002104211328835\t4917388557169180817\tDDMC168120210421\t1681\t74\t\n" +
                "夏宝牛牛冬瓜植物饮料250ml （1*24）\t4856114310375047578\t1680002104211328835\t4917443621417368795\tDDMC168120210422\t1681\t74\t\n" +
                "夏宝牛牛冬瓜植物饮料250ml （1*24）\t4856114310375047578\t1680002104211328833\t4917443621417368795\tDDMC168120210422\t1681\t74\t\n" +
                "怡宝饮用纯净水555ml（1*12）\t4843977609109277455\t1680002104211328835\t4917443621417368795\tDDMC168120210422\t1681\t74\t\n" +
                "怡宝饮用纯净水555ml（1*12）\t4843977609109277455\t1680002104211328833\t4917443621417368795\tDDMC168120210422\t1681\t74\t\n" +
                "夏宝牛牛冬瓜植物饮料250ml （1*24）\t4856114310375047578\t1680002104221929010\t4917443621417368795\tDDMC168120210422\t1681\t74\t\n" +
                "旺仔牛奶8罐*245ml+旺旺O泡果奶原味4罐*245ml\t4864434714945576796\t1618668318801100204\t4916319929171038746\tDDMC400120210418\t4001\t119\t\n" +
                "牛栏山二锅头56度100ml（白瓶）\t40000000345936\t1618668318801100204\t4916319929171038746\tDDMC400120210418\t4001\t119\t\n" +
                "牛栏山二锅头56度100ml（白瓶）\t40000000345936\t1619172931434100157\t4916319929171038746\tDDMC400120210418\t4001\t76\t\n" +
                "今麦郎软化纯净水550ml（1*24）\t40000025226449\t1618668318801100204\t4916319929171038746\tDDMC400120210418\t4001\t119\t\n" +
                "旺仔牛奶8罐*245ml+旺旺O泡果奶原味4罐*245ml\t4864434714945576796\t1619172931434100157\t4916319929171038746\tDDMC400120210418\t4001\t76\t\n" +
                "银鹭桂圆八宝粥礼盒装360g（1*8）\t4914474963946911887\t1619062866381100139\t4916319929171038746\tDDMC400120210418\t4001\t119\t\n" +
                "银鹭桂圆八宝粥礼盒装360g（1*8）\t4914474963946911887\t1619172931434100157\t4916319929171038746\tDDMC400120210418\t4001\t76\t\n" +
                "康师傅香辣牛肉面桶装108g（1*12）\t40000011177290\t1618668318801100204\t4916319929171038746\tDDMC400120210418\t4001\t119\t\n" +
                "康师傅香辣牛肉面桶装108g（1*12）\t40000011177290\t1619172931434100157\t4916319929171038746\tDDMC400120210418\t4001\t76\t\n" +
                "今麦郎软化纯净水550ml（1*24）\t40000025226449\t1619172931434100157\t4916319929171038746\tDDMC400120210418\t4001\t76\t\n" +
                "康师傅包装饮用水[瓶]550ml（1*28）\t4867681516293513043\t1619172931434100158\t4916612053313293585\tDDMC400120210419\t4001\t75\t\n" +
                "银鹭桂圆八宝粥礼盒装360g（1*8）\t4914474963946911887\t1619172931434100158\t4916612053313293585\tDDMC400120210419\t4001\t75\t\n" +
                "银鹭桂圆八宝粥礼盒装360g（1*8）\t4914474963946911887\t1619241476029100295\t4916612053313293585\tDDMC400120210419\t4001\t76\t\n" +
                "康师傅香辣牛肉面桶装108g（1*12）\t40000011177290\t1619172931434100158\t4916612053313293585\tDDMC400120210419\t4001\t75\t\n" +
                "康师傅香辣牛肉面桶装108g（1*12）\t40000011177290\t1619241476029100295\t4916612053313293585\tDDMC400120210419\t4001\t76\t\n" +
                "五星古井特曲50度500ml（1*12）\t40000035095723\t1619172931434100158\t4916612053313293585\tDDMC400120210419\t4001\t75\t\n" +
                "\n" +
                "康师傅包装饮用水[瓶]550ml（1*28）\t4867681516293513043\t1619241476029100295\t4916612053313293585\tDDMC400120210419\t4001\t76\t\n" +
                "牛栏山二锅头56度100ml（白瓶）\t40000000345936\t1619172931434100158\t4916612053313293585\tDDMC400120210419\t4001\t75\t\n" +
                "口子窖美酒[银盒]41度500ml（1*4）\t40000014126194\t1619172931434100158\t4916612053313293585\tDDMC400120210419\t4001\t75\t\n" +
                "维他柠檬茶低糖（瓶）500ml（1*15）\t4805790846589663702\t1618651592817100138\t4916312034201005579\tDDMC402120210418\t4021\t119\t\n" +
                "加多宝红装[听]310ml（1*24）\t40200002008745\t4020002104182121402\t4916312034201005579\tDDMC402120210418\t4021\t74\t\n" +
                "黑卡6小时450ml（1*15）\t40300002175530\t4030002104251472732\t4917448183343725787\tDDMC403120210422\t4031\t74\t\n" +
                "[下架]旺仔听装245ml礼盒装（1*48）\t40400002002831\t1619593677261100418\t4916336261383967255\tDDMC404120210418\t4041\t76\t\n" +
                "迎驾银星（新包装）42度450ml（1*4）\t40400002068227\t1619593677261100418\t4916336261383967255\tDDMC404120210418\t4041\t76\t\n" +
                "江小白重庆高粱酒40度100ml （1*24）\t40400025296238\t1619593677261100418\t4916336261383967255\tDDMC404120210418\t4041\t76\t\n" +
                "古越龙山三年陈10度500ml\t40400000929540\t1619593677261100418\t4916336261383967255\tDDMC404120210418\t4041\t76\t\n" +
                "乌毡帽浦江之缘清爽型11度480ml\t40400001427967\t1619593677261100418\t4916336261383967255\tDDMC404120210418\t4041\t76\t\n" +
                "迎驾银星（新包装）42度450ml（1*4）\t40400002068227\t1619519445435100010\t4916336261383967255\tDDMC404120210418\t4041\t119\t\n" +
                "江小白重庆高粱酒40度100ml （1*24）\t40400025296238\t1619519445435100010\t4916336261383967255\tDDMC404120210418\t4041\t119\t\n" +
                "古越龙山三年陈10度500ml\t40400000929540\t1619519445435100010\t4916336261383967255\tDDMC404120210418\t4041\t119\t\n" +
                "乌毡帽浦江之缘清爽型11度480ml\t40400001427967\t1619519445435100010\t4916336261383967255\tDDMC404120210418\t4041\t119\t\n" +
                "旺仔听装245ml礼盒装（1*48）\t40400002002831\t1619519445435100010\t4916336261383967255\tDDMC404120210418\t4041\t119\t\n" +
                "恒大天然矿泉水570ml（1*24）\t4868120078717607765\t4210002104211057365\t4916332025950622235\tDDMC421120210418\t4211\t74\t\n" +
                "恒大天然矿泉水570ml（1*24）\t4868120083825951965\t1618638127287100083\t4916332025950622235\tDDMC421120210418\t4211\t119\t\n" +
                "恒大天然矿泉水570ml（1*24）\t4868120078717607765\t4210002104211057365\t4916622550179623836\tDDMC421120210419\t4211\t74\t\n" +
                "乐虎牛磺酸肌醇饮料500ml（1*15）\t4917073746453540618\t4210002104251658434\t4917448036043963592\tDDMC421120210422\t4211\t74\t\n" +
                "乐虎牛磺酸肌醇饮料500ml（1*15）\t4917073746453540618\t4210002104251658434\t4918087543434349847\tDDMC421120210423\t4211\t74\t\n" +
                "百事可乐[瓶]500ml（1*24）\t45700001550904\t4570002104211912778\t4917323289134087379\tDDMC457120210418\t4571\t74\t\n" +
                "贝奇野菜450ml（1*15）\t45700001709894\t4570002104211912778\t4917323289134087379\tDDMC457120210418\t4571\t74\t\n" +
                "伊利金典纯牛奶250ml（1*12）\t45700006670766\t4570002104211912778\t4917323289134087379\tDDMC457120210418\t4571\t74\t\n" +
                "达利园豆本豆唯甄豆奶250ml（1*24）\t45700163299992\t4570002104211912778\t4917323289134087379\tDDMC457120210418\t4571\t74\t\n" +
                "红牛维生素风味饮料（听）250ml（1*24）\t4852495604158768973\t4570002104211912778\t4917323289134087379\tDDMC457120210418\t4571\t74\t\n" +
                "统一冰红茶500ml（1*16）\t4898229335453140054\t1619094876155100017\t4917323289134087379\tDDMC457120210418\t4571\t119\t\n" +
                "统一冰红茶500ml（1*15）\t45700001538697\t1619094876155100017\t4917323289134087379\tDDMC457120210418\t4571\t119\t\n" +
                "伊利高钙奶250ml（1*24）\t45700006673309\t4570002104211912778\t4917323289134087379\tDDMC457120210418\t4571\t74\t\n" +
                "墨西哥科罗娜特级啤酒【罐】4.5度310ml（1*24）\t45700154818520\t4570002104211912778\t4917323289134087379\tDDMC457120210418\t4571\t74\t\n" +
                "墨西哥科罗娜特级啤酒【罐】4.5度310ml（1*24）\t45700154818520\t1619094876155100017\t4917323289134087379\tDDMC457120210418\t4571\t119\t\n" +
                "旺仔牛奶125ml（1*24）\t4906170832643635329\t4570002104211912778\t4917323289134087379\tDDMC457120210418\t4571\t74\t\n" +
                "阿沙姆低脂豆奶饮品（瓶）330ml（1*24）\t4912317184175978639\t4570002104211912778\t4917323289134087379\tDDMC457120210418\t4571\t74\t\n" +
                "椰树椰汁1L（1*12）\t45700001732122\t4570002104211912778\t4918083573592722707\tDDMC457120210419\t4571\t74\t\n" +
                "伊利高钙奶250ml（1*24）\t45700006673309\t4570002104211912778\t4918083573592722707\tDDMC457120210419\t4571\t74\t\n" +
                "墨西哥科罗娜特级啤酒【罐】4.5度310ml（1*24）\t45700154818520\t4570002104211912778\t4918083573592722707\tDDMC457120210419\t4571\t74\t\n" +
                "旺仔牛奶125ml（1*24）\t4906170832643635329\t4570002104211912778\t4918083573592722707\tDDMC457120210419\t4571\t74\t\n" +
                "阿沙姆低脂豆奶饮品（瓶）330ml（1*24）\t4912317184175978639\t4570002104211912778\t4918083573592722707\tDDMC457120210419\t4571\t74\t\n" +
                "百事可乐[瓶]500ml（1*24）\t45700001550904\t4570002104211912778\t4918083573592722707\tDDMC457120210419\t4571\t74\t\n" +
                "贝奇野菜450ml（1*15）\t45700001709894\t4570002104211912778\t4918083573592722707\tDDMC457120210419\t4571\t74\t\n" +
                "椰树椰汁1L（1*12）\t45700001732122\t1619322981990100166\t4918083573592722707\tDDMC457120210419\t4571\t75\t\n" +
                "红牛维生素风味饮料（听）250ml（1*24）\t4852495604158768973\t4570002104211912778\t4918083573592722707\tDDMC457120210419\t4571\t74\t\n" +
                "[下架]椰岛海王酒（18版）32度150ml（1*30）\t4883722298632890510\t1619322981990100166\t4918083573592722707\tDDMC457120210419\t4571\t75\t\n" +
                "蒙牛纯牛奶尊享装200ml（1*24）\t4894970858680640154\t4650002104201033199\t4916322616929119746\tDDMC465120210418\t4651\t74\t\n" +
                "蒙牛纯牛奶尊享装200ml（1*24）\t4894970858680640154\t4650002104231033480\t4916965725342939529\tDDMC465120210420\t4651\t74\t\n" +
                "伊利优酸乳草莓味250ml（1*24）\t70400003873278\t1618795931688100301\t4916328158160605707\tDDMC704120210418\t7041\t76\t\n" +
                "伊利优酸乳蓝莓味250ml（1*24）\t70400003874554\t1618795931688100301\t4916328158160605707\tDDMC704120210418\t7041\t76\t\n" +
                "汾酒玻璃瓶42度475ml （1*12）【美团专供】\t4902119644662319944\t7040002104231624500\t4916328158160605707\tDDMC704120210418\t7041\t74\t\n" +
                "伊利优酸乳草莓味250ml（1*24）\t70400003873278\t1618624517886100020\t4916328158160605707\tDDMC704120210418\t7041\t119\t\n" +
                "伊利优酸乳蓝莓味250ml（1*24）\t70400003874554\t1618624517886100020\t4916328158160605707\tDDMC704120210418\t7041\t119\t\n" +
                "伊利优酸乳草莓味250ml（1*24）\t70400003873278\t1618714650374100224\t4918407371795874000\tDDMC704120210419\t7041\t119\t\n" +
                "伊利优酸乳蓝莓味250ml（1*24）\t70400003874554\t1618714650374100224\t4918407371795874000\tDDMC704120210419\t7041\t119\t\n" +
                "伊利优酸乳草莓味250ml（1*24）\t70400003873278\t1618795931688100302\t4918407371795874000\tDDMC704120210419\t7041\t75\t\n" +
                "伊利优酸乳蓝莓味250ml（1*24）\t70400003874554\t1618795931688100302\t4918407371795874000\tDDMC704120210419\t7041\t75\t\n" +
                "娃哈哈纯净水596ml（1*24）\t71100001963062\t7110002104201772453\t4916310848582570516\tDDMC711120210418\t7111\t74\t\n" +
                "乌苏（红）啤酒【瓶】纸箱装11度620ml（1*12）\t4762809650397956061\t7110002104201772453\t4916310848582570516\tDDMC711120210418\t7111\t74\t\n" +
                "金沙河手擀面（宽）500g（1*20）\t4901051202577015936\t7110002104191671855\t4916310848582570516\tDDMC711120210418\t7111\t74\t\n" +
                "娃哈哈饮用天然矿泉水596ml（1*24）\t4911289297360599187\t7110002104191671855\t4916623265119898896\tDDMC711120210419\t7111\t74\t\n" +
                "娃哈哈饮用天然矿泉水596ml（1*24）\t4911289297360599187\t7110002104211473103\t4916623265119898896\tDDMC711120210419\t7111\t74\t\n" +
                "百岁山饮用天然矿泉水570ml（1*24）\t71100001698972\t7110002104221073641\t4916623265119898896\tDDMC711120210419\t7111\t74\t\n" +
                "怡宝饮用纯净水555ml（1*12）\t71100008402891\t7110002104221673970\t4916623265119898896\tDDMC711120210419\t7111\t74\t\n" +
                "金沙河原味爽滑挂面900g（1*15）\t71100014942681\t7110002104201772453\t4916623265119898896\tDDMC711120210419\t7111\t74\t\n" +
                "金沙河原味爽滑挂面900g（1*15）\t71100014942681\t7110002104221673970\t4916623265119898896\tDDMC711120210419\t7111\t74\t\n" +
                "立白新金桔洗洁精1kg+120g（1*10）\t71100045702871\t7110002104201772453\t4916623265119898896\tDDMC711120210419\t7111\t74\t\n" +
                "金沙河刀削原味面片200g（1*25）\t4798125746493601992\t7110002104201772453\t4916623265119898896\tDDMC711120210419\t7111\t74\t\n" +
                "娃哈哈纯净水596ml（1*24）\t71100001963062\t7110002104201772453\t4916623265119898896\tDDMC711120210419\t7111\t74\t\n" +
                "欢乐家生榨椰子汁（植物蛋白饮料）1.25L\t71100006808431\t7110002104221673970\t4916623265119898896\tDDMC711120210419\t7111\t74\t\n" +
                "金沙河手擀面（宽）500g（1*20）\t4901051202577015936\t7110002104191671855\t4916623265119898896\tDDMC711120210419\t7111\t74\t\n" +
                "金沙河手擀面（宽）500g（1*20）\t4901051202577015936\t7110002104191671855\t4916964865425939210\tDDMC711120210420\t7111\t74\t\n" +
                "娃哈哈纯净水596ml（1*24）\t71100001963062\t7110002104201772453\t4916964865425939210\tDDMC711120210420\t7111\t74\t\n" +
                "心相印柔韧4层有芯卷纸10卷装1400g BT910\t4846769685230200662\t7110002104221073641\t4916964865425939210\tDDMC711120210420\t7111\t74\t\n" +
                "娃哈哈饮用天然矿泉水596ml（1*24）\t4911289297360599187\t7110002104191671855\t4916964865425939210\tDDMC711120210420\t7111\t74\t\n" +
                "娃哈哈饮用天然矿泉水596ml（1*24）\t4911289297360599187\t7110002104211473103\t4916964865425939210\tDDMC711120210420\t7111\t74\t\n" +
                "百岁山饮用天然矿泉水570ml（1*24）\t71100001698972\t7110002104221073641\t4916964865425939210\tDDMC711120210420\t7111\t74\t\n" +
                "金沙河原味爽滑挂面900g（1*15）\t71100014942681\t7110002104201772453\t4916964865425939210\tDDMC711120210420\t7111\t74\t\n" +
                "立白新金桔洗洁精1kg+120g（1*10）\t71100045702871\t7110002104201772453\t4916964865425939210\tDDMC711120210420\t7111\t74\t\n" +
                "金沙河刀削原味面片200g（1*25）\t4798125746493601992\t7110002104201772453\t4916964865425939210\tDDMC711120210420\t7111\t74\t\n" +
                "娃哈哈饮用天然矿泉水596ml（1*24）\t4911289297360599187\t7110002104211473103\t4917384080005513358\tDDMC711120210421\t7111\t74\t\n" +
                "娃哈哈饮用天然矿泉水596ml（1*24）\t4911289297360599187\t7110002104241775215\t4917384080005513358\tDDMC711120210421\t7111\t74\t\n" +
                "心相印优选三层无芯长卷纸750g10卷 LR910\t71100046687950\t7110002104241775215\t4917384080005513358\tDDMC711120210421\t7111\t74\t\n" +
                "怡宝饮用纯净水555ml（1*12）\t71100008402891\t7110002104221673970\t4917384080005513358\tDDMC711120210421\t7111\t74\t\n" +
                "金沙河原味爽滑挂面900g（1*15）\t71100014942681\t7110002104221673970\t4917384080005513358\tDDMC711120210421\t7111\t74\t\n" +
                "统一小当家干脆面巴西烤肉味26g（1*44）\t71100024359765\t7110002104241775215\t4917384080005513358\tDDMC711120210421\t7111\t74\t\n" +
                "心相印柔韧4层有芯卷纸10卷装1400g BT910\t4846769685230200662\t7110002104221073641\t4917384080005513358\tDDMC711120210421\t7111\t74\t\n" +
                "娃哈哈饮用天然矿泉水596ml（1*24）\t4911289297360599187\t7110002104251775853\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "脉动青柠口味600ml（1*15）\t71100001542278\t7110002104221073641\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "怡宝饮用纯净水555ml（1*12）\t71100008402891\t7110002104221673970\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "金沙河原味爽滑挂面900g（1*15）\t71100014942681\t7110002104221673970\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "统一小当家干脆面巴西烤肉味26g（1*44）\t71100024359765\t7110002104241775215\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "娃哈哈饮用天然矿泉水596ml（1*24）\t4911289297360599187\t7110002104211473103\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "娃哈哈饮用天然矿泉水596ml（1*24）\t4911289297360599187\t7110002104241775215\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "雪花原汁麦瓶10.3度330ml（1*24）\t4917041199350755086\t7110002104251775853\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "脉动青柠口味600ml（1*15）\t71100001542278\t7110002104211473103\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "脉动青柠口味600ml（1*15）\t71100001542278\t7110002104241775215\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "怡宝饮用纯净水555ml（1*12）\t71100008402891\t7110002104251775853\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "汇源果肉多桃复合果肉饮料2.5L（1*6）\t71100025775936\t7110002104231574603\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "心相印优选三层无芯长卷纸750g10卷 LR910\t71100046687950\t7110002104241775215\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "水润坊特惠装无汽无糖苏打水400ml（1*12）\t4797023033106477342\t7110002104251775853\t4917436234997153927\tDDMC711120210422\t7111\t74\t\n" +
                "娃哈哈桂圆莲子营养八宝粥【罐】360g（1*12）\t71300014555974\t7130002104201511081\t4916341642000370956\tDDMC713120210418\t7131\t74\t\n" +
                "南街村北京清真麻辣芝麻面60g（1*40）\t4831457167568415948\t7130002104191310118\t4916341642000370956\tDDMC713120210418\t7131\t74\t\n" +
                "\n" +
                "康师傅清真经典红烧牛肉面五连包*103g（1*6）\t4899686626614748292\t7130002104201511081\t4916341642000370956\tDDMC713120210418\t7131\t74\t\n" +
                "清扬男士去屑洗发露（多效水润养护型）175ml\t4865909013648826176\t7130002104211712147\t4916607879129369863\tDDMC713120210419\t7131\t74\t\n" +
                "康师傅清真经典红烧牛肉面五连包*103g（1*6）\t4899686626614748292\t7130002104201511081\t4916607879129369863\tDDMC713120210419\t7131\t74\t\n" +
                "娃哈哈桂圆莲子营养八宝粥【罐】360g（1*12）\t71300014555974\t7130002104201511081\t4916607879129369863\tDDMC713120210419\t7131\t74\t\n" +
                "海飞丝去屑洗发露清爽去油型200ml\t4842071646737475410\t7130002104211712147\t4916607879129369863\tDDMC713120210419\t7131\t74\t\n" +
                "康师傅清真经典红烧牛肉面五连包*103g（1*6）\t4899686626614748292\t7130002104211712147\t4916607879129369863\tDDMC713120210419\t7131\t74\t\n" +
                "红牛250ml（1*24）\t72100002257860\t1619593673312100546\t4916626844941398926\tDDMC721120210419\t7211\t75\t\n" +
                "雅鲁河高粱原浆42度500ml（1*6）\t72100064063802\t1619593673312100546\t4916626844941398926\tDDMC721120210419\t7211\t75\t\n" +
                "河套老窖典藏38度500ml（1*6）\t72100092246781\t1619593673312100546\t4916626844941398926\tDDMC721120210419\t7211\t75\t\n" +
                "康师傅冰红茶1L（1*13）\t4848561593682175825\t1619593673312100546\t4916626844941398926\tDDMC721120210419\t7211\t75\t\n" +
                "恒大天然矿泉水570ml（1*24）\t4868120096660522176\t1619594271342100446\t4916626844941398926\tDDMC721120210419\t7211\t76\t\n" +
                "红牛250ml（1*24）\t72100002257860\t1619594271342100446\t4916626844941398926\tDDMC721120210419\t7211\t76\t\n" +
                "雅鲁河高粱原浆42度500ml（1*6）\t72100064063802\t1619594271342100446\t4916626844941398926\tDDMC721120210419\t7211\t76\t\n" +
                "河套老窖典藏38度500ml（1*6）\t72100092246781\t1619594271342100446\t4916626844941398926\tDDMC721120210419\t7211\t76\t\n" +
                "康师傅冰红茶1L（1*13）\t4848561593682175825\t1619594271342100446\t4916626844941398926\tDDMC721120210419\t7211\t76\t\n" +
                "恒大天然矿泉水570ml（1*24）\t4868120096660522176\t1619593673312100546\t4916626844941398926\tDDMC721120210419\t7211\t75";
        return text;
    }


    private static void splitText(){
        String text =getText();
        String[] titles =new String[]{"skuName","skuId","businessNo","settleOrderId","settleNo","warehouseId","orderType"};
        Map<String,String> orderTypeMap = new HashMap() {
            {
                put("119", "团购销售单");
                put("74", "团购退货单");
                put("75", "团购结转出");
                put("76", "团购结转入");
            }
        };
        List<JSONObject> listMap =new ArrayList<>();
        String[] splitTexts = text.split("\n");
        for (String splitText : splitTexts) {
            JSONObject jsonObj = new JSONObject();
            String[] split = splitText.split("\t");
            for (int i = 0; i < split.length; i++) {
                if(titles[i].equals("orderType")){
                    jsonObj.put(titles[i],orderTypeMap.get(split[i]));
                }else {
                    jsonObj.put(titles[i],split[i]);
                }
            }
            listMap.add(jsonObj);
        }
        System.out.println(JSON.toJSONString(listMap));

        Set<Object> settleNo = listMap.stream().map(it -> it.get("settleNo")).collect(Collectors.toSet());
        Set<Object> warehouseId = listMap.stream().map(it -> it.get("warehouseId")).collect(Collectors.toSet());

        System.out.println(JSON.toJSONString(settleNo));
        System.out.println(JSON.toJSONString(warehouseId));

    }


    public static void main(String[] args){
        splitText();

//        Integer integer = Integer.valueOf("111111111111111111");
//
//        Map<String, String> map = new HashMap<>();
//        System.out.println(map.get("1"));
//
//        Map<String, String> map2 = new HashMap<>();
//        map2.putAll(map);
//        System.out.println(JSON.toJSONString(map2));


//        Map<Long, String> map = new TreeMap<>((p1, p2) -> {
//            if (p1 == null) {
//                return 1;
//            }
//            if (p2 == null) {
//                return -1;
//            }
//            return p1.compareTo(p2);
//        });
//        map.put(null,"2");
//        map.put(1L,"1");
//
//
//        for (Map.Entry entry : map.entrySet()) {
//            if(entry.getKey()==null){
//                System.out.println(entry.getValue());
//            }
//        }



//        System.out.println(JSON.toJSONString(list));
//        LinkedHashMap<String,String> linkedHashMapmap =new LinkedHashMap<>();
//        linkedHashMapmap.put("c","e");
//        linkedHashMapmap.put("a","b");
//        linkedHashMapmap.put("b","d");
//        linkedHashMapmap.put("a","c");
//        linkedHashMapmap.put("a","d");
//
//        System.out.println(JSON.toJSONString(linkedHashMapmap));
//        System.out.println(linkedHashMapmap.get("d"));
//        for (Map.Entry<String, String> entry : linkedHashMapmap.entrySet()) {
//            System.out.println(entry);
//        }
//        System.out.println("___________________________________________________________________________");
//        HashMap<String,String> map =new HashMap<>();
//        map.put("c","e");
//        map.put("a","b");
//        map.put("b","d");
//        map.put("a","c");
//        map.put("a","d");
//        System.out.println(JSON.toJSONString(map));
//        System.out.println(map.get("d"));



//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry);
//        }//        String json ="{\"omsOrderId\":998000210207145746,\"omsOrderItems\":[{\"deliveryCount\":\"查\",\"omsOrderItemId\":998001210207144764,\"orderCount\":2.000000,\"productSkuId\":4762841767152294336}]}";
//        Map<String, Long> map = JSON.parseObject(json, Map.class);
//        Long omsOrderId = map.get("omsOrderId");
//        System.out.println("得到消息，快递直发订单发货，{}"+json);
//        System.out.println(omsOrderId);


//        List<Byte> orderStates = Arrays.asList((byte)1);
//        orderStates.add((byte)2);
//        Long value  =null;
//
//        System.out.println(String.valueOf(value));
//        System.out.println(value.toString());
//
//        System.out.println(DateUtils.getTimeByDate("2021-01-10 15:10:00"));
//        System.out.println(DateUtils.getTimeByDate("2021-01-10 15:40:00"));

//        System.out.println(String.valueOf(null));
//        BigDecimal skuPrice =BigDecimal.ONE;
//        Long price = skuPrice == null ? 0L : (skuPrice.multiply(BigDecimal.valueOf(100)).longValue());
//        System.out.println(price);


//        List<String> list =new ArrayList<>();
//        System.out.println(list.get(0));
//        String subject ="茅台天朝上品贵人53度500ml（1*6）";
//        String key = matchKey(subject, "度");
//        System.out.println(key);
//
////        String subject = "1234Bug- description";
//        Pattern bugNumber = Pattern.compile("\\s*([0-9]+)(?i)度");
//        // find the bug#
//        Matcher matcher = bugNumber.matcher(subject);
//        while (matcher.find()) {
//            System.out.println(matcher.group(1));
//        }


//
//
//        Pattern p = Pattern.compile("[^0-9]+度");
//        System.out.println(p.toString());
//        Matcher m = p.matcher(name);
////        System.out.println(m.group());
//        String s1 = m.replaceAll("");
//        System.out.println(s1);
//
//
////        String kgs2 = k.replaceAll("").trim();
//////        System.out.println(kgs2);
////        Pattern pattern = Pattern.compile("\\d+度");
////        Matcher matcher = pattern.matcher(name);
////        System.out.println(name.replaceAll("\\d+度",""));
////        String all = matcher.replaceAll("");// 不属于任何匹配的字符被直接添加到结果字符串
////        System.out.println("phone:" + all);
////        String phoneString = "哈哈,1388888额9999";
////        String s = Pattern.compile("[^0-9]").matcher(name).replaceAll("");
////        System.out.println(s);
//
//
////        String str = "hello8023.1314world"; //要截取的字符串
////        Match m = Regex.Match(str, "\\d+(\\.\\d+){0,1}");
////        double.TryParse(m.Groups[0].ToString(), out d);
////        Console.WriteLine(d);
////        Console.ReadKey();
//
//        String s = "A876X";
//// 把要匹配的字符串写成正则表达式，然后要提取的字符使用括号括起来
//// 在这里，我们要提取最后一个数字，正则规则就是“一个数字加上大于等于0个非数字再加上结束符”
//        Pattern pattern = Pattern.compile("(\\d)[^\\d]*$");
//        Matcher matcher = pattern.matcher(name);
//        if(matcher.find())
//            System.out.println(matcher.group(1));
////        REGEXP_REPLACE(REGEXP_SUBSTR('12月最低消费20元','[0-9]+元'),'[^0-9]')
    }

    /**
     * 获取订单
     *
     * @param appSecret
     * @param appKey
     */
    public void test() {
        String url = "https://cashew.3songshu.com/api/yijiupi/refund/apply";
        String json = "{\"businessNo\":\"998002201102150613\"}";
//        ThirdSSCancelOrderDTO cancelOrderDTO =  JSON.parseObject(json, ThirdSSCancelOrderDTO.class);
        ThirdSSCancelOrderDTO cancelOrderDTO =new ThirdSSCancelOrderDTO();
        cancelOrderDTO.setOrderNo("10101011111");
        cancelOrderDTO.setBuyerNick("测试");
        cancelOrderDTO.setApplyTime(DateUtils.getCurrentTime());
        cancelOrderDTO.setNum(1);
        cancelOrderDTO.setRefundMoney("1");
        cancelOrderDTO.setRefundId("10101011111");
        cancelOrderDTO.setSourceName("易久批");
        cancelOrderDTO.setSign(getSign(cancelOrderDTO).toUpperCase());
        System.out.println(JSON.toJSONString(cancelOrderDTO));
        try {
            String post = HttpUtil.post(url, JSON.toJSONString(cancelOrderDTO));
            System.out.println("订单详情获取：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }

    private String getSign(ThirdSSCancelOrderDTO cancelOrderDTO) {
        StringBuilder buffer = new StringBuilder();
        AuthUtil.parseFieldInBuffer(buffer, cancelOrderDTO, "");
        String signInit = cancelOrderDTO.getOrderNo() + buffer.toString() + cancelOrderDTO.getOrderNo();
        System.out.println("签名初始拼接信息:" + signInit);
        String sign = MD5Utils.getMD5(signInit);
        System.out.println("签名最终信息:" + sign);
        return sign;
    }

    public static void testFlatMap() {

        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);
        playersInWorldCup2016.add(teamWestIndies);
        playersInWorldCup2016.add(teamSriLanka);
        playersInWorldCup2016.add(teamPakistan);

        // Let's print all players before Java 8
        List<String> listOfAllPlayers = new ArrayList<>();

        for (List<String> team : playersInWorldCup2016) {
            for (String name : team) {
                listOfAllPlayers.add(name);
            }
        }

        System.out.println("Players playing in world cup 2016");
        System.out.println(listOfAllPlayers);

        // Now let's do this in Java 8 using FlatMap
        List<String> flatMapList = playersInWorldCup2016.stream()
                .flatMap(pList -> pList.stream())
                .collect(Collectors.toList());

        System.out.println("List of all Players using Java 8 flatMap");
        System.out.println(flatMapList);
    }
}
