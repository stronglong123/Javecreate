package com.common.generate.javacreate.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.test.dto.InventoryDetailDTO;
import com.common.generate.javacreate.test.dto.Inventorycheck;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleOrderDetailDTO;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleOrderPageParamDTO;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleOrderQueryDTO;
import com.common.generate.javacreate.test.groupsettle.util.BaseUtils;
import com.common.generate.javacreate.utils.HttpClientUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/5/11 15:12
 */
public class ErpInventoryCheck {

    private static final String cookie = "YJPINFO=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiNzhhNzgwNS1kMWRmLTRiNzUtOTVlNy00NjFmYTFhMzlhNzciLCJzdWIiOiJ5anAiLCJpc3MiOiJ5anAiLCJpYXQiOjE2MjEyMTM4MjQsImJhc2UtbW9iaWxlTm8iOiIxNzc2MjM4ODQ3MSIsImJhc2UtdXNlcklkIjoiNTgzODQiLCJiYXNlLXRpbWVPdXQiOiIxMDgwMCIsImV4cCI6MTYyMTIyNDYyNH0.WgFgFuM4WmgXYKckGskzwabcKlKOYEPK7AcYLbrxCpU; acw_tc=2760820316212138320032407e94d948890bc20429563ce9a417ba589dc78e; YJPID=d7b56b89771c4f2a86fb473cd556941c; JSESSIONID=50BAA960C6478B48DEB2D27A6C2E9844";
    private static final String baseUrl = "http://scop.pre.yijiupi.com/";

    public static void main(String[] args) {
        findCanOffset();
//        getInventoryDetail();
    }


    public static void findCanOffset() {
        List<Inventorycheck> dtos = pageList();
        Set<Integer> warehouseIds = dtos.stream().map(it -> it.getWarehouseId()).collect(Collectors.toSet());
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> noWarehouse = new ArrayList<>();
        List<Integer> needWarehouse = new ArrayList<>();
        Set<Long> skuIdSet = new HashSet<>();
        System.out.println(JSON.toJSONString(warehouseIds));
        for (Integer warehouseId : warehouseIds) {
            List<GroupSettleOrderQueryDTO> grouplist = grouplist(warehouseId);
            if (CollectionUtils.isNotEmpty(grouplist)) {
                needWarehouse.add(warehouseId);
            } else {
                noWarehouse.add(warehouseId);
            }
        }

        System.out.println("需要处理仓库Id：" + JSON.toJSONString(needWarehouse));
        System.out.println("不需要处理仓库ID：" + JSON.toJSONString(noWarehouse));
        System.out.println("未过滤数据:" + JSON.toJSONString(dtos));
        List<Inventorycheck> collect = dtos.stream().filter(it -> noWarehouse.contains(it.getWarehouseId())).collect(Collectors.toList());
        Set<String> collect1 = collect.stream().map(it -> it.getWarehouseName()).collect(Collectors.toSet());
        System.out.println("过滤仓库:" + JSON.toJSONString(collect1));
        System.out.println("过滤仓库的数据:" + JSON.toJSONString(collect));


        dtos = dtos.stream().filter(it -> needWarehouse.contains(it.getWarehouseId())).collect(Collectors.toList());
        Set<String> warehouseSet = dtos.stream().map(it -> it.getWarehouseName()).collect(Collectors.toSet());
        System.out.println("处理仓库:" + JSON.toJSONString(warehouseSet));
        System.out.println("过滤仓库后数据:" + JSON.toJSONString(dtos));


        /**过滤skuId*/
        List<Long> skuList = getSkuList();

        List<Inventorycheck> notExistskuDTOs = dtos.stream().filter(it -> !skuList.contains(it.getProductSkuId())).collect(Collectors.toList());
        System.out.println("需要过滤的产品:"+JSON.toJSONString(notExistskuDTOs));

        List<Inventorycheck> existskuDTOs = dtos.stream().filter(it -> skuList.contains(it.getProductSkuId())).collect(Collectors.toList());
        System.out.println("过滤产品后:"+JSON.toJSONString(existskuDTOs));


        Map<String, List<Inventorycheck>> collect2 = dtos.stream().collect(Collectors.groupingBy(it -> String.valueOf(it.getWarehouseId())));
        System.out.println("分仓库：" + JSON.toJSONString(collect2));

        List<Inventorycheck> result = new ArrayList<>();
        Map<Long, List<Inventorycheck>> skuSecMap = dtos.stream().collect(Collectors.groupingBy(it -> it.getProductSkuId()));
        for (List<Inventorycheck> inventorychecks : skuSecMap.values()) {
            BigDecimal addCount = inventorychecks.stream().map(it -> it.getDiffTotalCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            if (addCount != null && addCount.compareTo(BigDecimal.ZERO) == 0) {
                result.addAll(inventorychecks);
            }
        }
        Map<String, List<Inventorycheck>> listMap = result.stream().collect(Collectors.groupingBy(it -> String.valueOf(it.getWarehouseId())));
        System.out.println(JSON.toJSONString(listMap));
    }


    public static void getInventoryDetail() {
        List<InventoryDetailDTO> inventoryDetail = getInventoryDetailPageList();
        List<InventoryDetailDTO> collect = inventoryDetail.stream().filter(it -> Arrays.asList(119, 74, 75, 76, 77, 78).contains(it.getOrderType())).collect(Collectors.toList());
        System.out.println("查询结果:" + JSON.toJSONString(inventoryDetail));
        System.out.println("团购单据:" + JSON.toJSONString(collect));

        BigDecimal reduce = collect.stream().map(it -> it.getAddStoreCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("总数量：" + reduce);
    }


    public static List<Inventorycheck> pageList() {
        String body = "{\"state\":1,\"startTime\":\"2021-05-17 00:00:00\",\"endTime\":\"2021-05-17 23:59:59\",\"orgId\":null,\"pageNum\":1,\"pageSize\":500}";
        String url = baseUrl + "/listInventoryCheckRecord";
        String resultstr = HttpClientUtils.doPostWithCookie(cookie, url, body);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        JSONObject pageList = (JSONObject) data;
        Object dataList = pageList.get("dataList");
        List<Inventorycheck> dtos = JSON.parseArray(JSON.toJSONString(dataList), Inventorycheck.class);
        System.out.println("接口返回数据：" + JSON.toJSONString(dtos));

        return dtos;
    }

    public static List<InventoryDetailDTO> getInventoryDetailPageList() {
        String body = "{\"state\":0,\"productSkuId\":\"10300036093825\",\"productStoreRecordSO\":{\"storeId\":\"6751f96fab4a4f15b6ec288970e54920\"},\"currentPage\":1,\"pageSize\":500}";
        String url = baseUrl + "/getInventoryDetail";
        String resultstr = HttpClientUtils.doPostWithCookie(cookie, url, body);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        JSONObject pageList = (JSONObject) data;
        Object dataList = pageList.get("dataList");
        List<InventoryDetailDTO> dtos = JSON.parseArray(JSON.toJSONString(dataList), InventoryDetailDTO.class);
        for (InventoryDetailDTO dto : dtos) {
            dto.setAddStoreCount(dto.getAddStoreCountDTO().get(0).getTotalCountMinUnit());
            dto.setNewStoreCount(dto.getNewStoreCountDTO().get(0).getTotalCountMinUnit());
            dto.setSourceStoreCount(dto.getSourceStoreCountDTO().get(0).getTotalCountMinUnit());
            dto.setAddStoreCountDTO(null);
            dto.setNewStoreCountDTO(null);
            dto.setSourceStoreCountDTO(null);
        }
        return dtos;
    }


    /**
     * 查询账单列表
     *
     * @param warehosueId
     * @return
     */
    public static List<GroupSettleOrderQueryDTO> grouplist(Integer warehosueId) {
        String url = "groupsettle/list";
        String body = "{\"warehouseId\":1591,\"settleState\":\"2\",\"pageNum\":1,\"pageSize\":100}";
        GroupSettleOrderPageParamDTO query = JSON.parseObject(body, GroupSettleOrderPageParamDTO.class);
        query.setWarehouseId(warehosueId);
        String dataList = BaseUtils.pageList(url, JSON.toJSONString(query));
        List<GroupSettleOrderQueryDTO> result = JSON.parseArray(dataList, GroupSettleOrderQueryDTO.class);
        return result;
    }


    /**
     * 查询账单明细
     *
     * @param id
     * @param orgId
     * @return
     */
    public static GroupSettleOrderDetailDTO detail(Long id, Integer orgId) {
        String url = "/groupsettle/detail";
        String body = "{\"id\":\"" + id + "\",\"orgId\":" + orgId + "}";
        String dataList = BaseUtils.postRequest(url, body);
        GroupSettleOrderDetailDTO result = JSON.parseObject(dataList, GroupSettleOrderDetailDTO.class);
        return result;
    }


    public static List<Long> getSkuList() {
        String json = "[10300034772186,10300001541851,10300001198659,4868120063903326040,10300058592849,10300001188290,10300039764286,10300002039168,10300001817353,16800001550060,16800001198513,16800001556914,4856422847213753558,16800005831135,4856114310375047578,16800002494787,4865617929370338499,16800149552175,4837683092788004680,16800009707763,15900039764356,4776428017752634507,15900001555063,15900001542822,15900001543515,15900002257896,15900004100919,15900003107231,15900020284900,15900000947637,15900001571045,4899573888009806981,15900001545525,15900002112802,15900002494978,15900001570200,15900002387732,15900001698710,15900004804715,4777582275521374212,11900002257872,11900001544369,11400151112789,15900139449334,11800001627349,10300002257379,10300002057249,15900042053339,15900137139844,4874307702317552080,4782934981700893586,11900003173415,11900107485366,16800054414485,4914220663409259211,4851462338656020312,10300000806628,10300001698774,10500001550578,10300011390332,10300024035200,4830010229609609425,10300001631835,4828648007766314381,15900001199688,4915538441600969606,15900001558415,15900002855769,15900096999325,4915538815550878724,11800002373505,4915539548343577494,4840550029370375748,4840550023645150798,10300032242993,10300007091822,4916954516003666062,10300013470005,10300000767772,10300000603421,4784349768017238225,10300001539221,10300001544384,10300029255314,10300006249906,15900001544189,15900002057998,4918521705039509965,10300001738539,4818371453431371409,15900001598166,4762808136317126601,4918811970881133015,4762809646526613465,15900007921311,4843977609109277455,4918812164504795588,15900011414123,16800107485056,15900001198232,10300040463503,40500045918380,40500004903862,40500007324285,40200001186081,40200001185134,40200191003138,40200151112433,40200002039377,40200000720852,4777195708915083281,40200001196309,4772133343308590227,40200068373569,40600007145129,40600007322579,40000001548114,40000002257189,40000002112159,40000001188672,40000007147440,40000008122805,40000002057402,40000125367050,40000000311338,40000014126194,4810048808338993613,40000035095723,40000000274708,4867681516293513043,40000004919492,40000031358303,46500004120239,41900001570554,4811593850524995407,47300004857769,47300005371601,47300000314832,4906403955730592475,4882236137363548800,4843976231850838792,42100001548502,42100003896749,42100001740974,4868120080311125195,4868120075144060753,40300031652437,4841638631619101918,4792681681467797833,40400003801709,40400003532053,40400001083802,40400081238512,40400118324793,40400004804436,4863407525556840346,4843976557031033624,40400000929540,40400025296238,40400002002831,40400002068227,40400001427967,4864434714945576796,40000001542800,40000011879564,40000003839768,40000025226449,40500047275913,40500001732374,40500001543931,40500001542870,40300002175530,40200017931599,4868120080000746717,40200006699081,40300001789506,4883722298632890510,45700002112726,4898229268965576593,45700004041800,45700007322813,45700151112247,45700212349819,45700001732122,40600060789141,40000000327603,40000000314758,4913824116469183198,47300019078504,40200001966917,4868120074816905051,40200002008745,45700006670766,45700157424090,4914905203882014871,45700163299992,4852495604158768973,45700154818520,4883722293336912022,42100125367541,40000011177290,40000000345936,40200107485257,4839885575663431176,40200010344660,4805790846589663702,4806183958200123102,40200006584526,4898229335453140054,45700001538697,41200003107709,41200001548573,41200001188935,41200011226417,41200005460591,41200003839759,41200001547655,4898913301915586445,4916350124036664198,4916350515008711581,4916246574359063435,40200009282764,40200013440757,4917063267437981459,40200032242553,40200005820548,4868120083825951965,4917073746453540618,4913792322898277086,4914474963946911887,40200002091175,40200007091250,40000001543981,40000001728709,4853961132699320718,40000024449226,40000001198979,40000001700443,40200001738274,40000023612916,4868120078717607765,40000053880558,4876383192217752645,40000205549629,42100001698022,4918865705011452365,4919247781099411906,42100004120664,42200001740632,4842424896706774238,4886895033932507286,4886895099478323342,4886895034370142364,4886892810884278411,42200001786669,42200001188278,42200025341318,4842424897222673611,4886897863277195419,4857529822652957063,4837685784688117583,42200018295307,4886894880253208708,42200007345215,42200001184477,42200003142517,4881180841792941125,4886894775563380875,4867019886400429917,4881180841284472989,42200001547915,42200001789404,42200001942800,4782907262911535635,42200001951095,42200001544233,42200001539825,42200001946499,42200001538285,42200001548310,72300064063536,72300000734167,71100001840110,4903302845124561758,71100038136458,71100138217725,71100083356891,4911289297360599187,71100001542278,71100009754035,71100045702871,4798125746493601992,71100014942681,70400058662050,70400003872819,70400004179551,4868120088104460106,4878295444626545290,71300005114385,71300125507884,71300016910015,71300001542537,71300018633970,71300002112740,71300015054397,71300124860465,71300065961108,4870215270593201360,71300007147815,71300006822427,71300020838857,71300107485940,4868120087060078413,4831457167568415948,71300033306951,4762809650397956061,4911289754947203800,4914829890263136385,4914829746021642965,4846769685230200662,72100001474154,4850031898749511489,72100095772710,72100001543776,4904313684237470530,72100001544098,72100000561291,4838803828364324358,4848561593682175825,4868120096660522176,72100002257860,72100092246781,72100064063802,71300014555974,4899686626614748292,71100001698972,71100006808431,71300013064726,71300011123336,4865909013648826176,4842071646737475410,70000003997500,4868080931504185158,4874551004962672662,4868080062016577366,4870947087826814160,4871406621964164952,4868043693907042130,4874552746374778884,4870292772846362447,4868042839539900230,4868082199761051456,4868040502377242451,4872879733728268301,4870261144627184845,4762809650167269330,4868120093514794184,70500002257905,70500061926486,70500000866450,4818112386641221276,4868120088377089884,70500001550988,4762808139823564743,4868120091619286854,72100003107482,72100001550612,71300001629182,4855383977274933636,70500001544859,4914049324954202825,70500000274925,4826453454930390036,4914136355822057616,4910822936935086237,4911187536171972763,71100008402891,71100001963062,4901051202577015936,71300052175451,70500003805568,70500003596766,4858349024854966668,4864101728907429059,72300002257688,4834051738386133523,4913473019518335118,72300151112005,72300002008258,4834074924121816020,72300001544974,72300061977471,71100025775936,71100016625753,4917041199350755086,71300011495444,4800288483103799771,71300013036684,70400003873278,70400003874554,4868120092218754255,4902119644662319944,4868120093263135965,4909104290470770831,70500000458508,70500000735764,4856545731224830355,70400000734145,70400000274814,70400223569221,70400075894126,70400000561123,4901129003966685850,4871774843329237022,4881229043816639561,70500199537436,4916711874550952975,70500003778179,4916711285903010715,70500079755292,70500119508499,70400115128069,4900731231291597453,4913571146116674243,4863070007510694409,4863070008034982426,4906566038166221518,70500025226304,4859048460132319624,72300001909023,4901876068776837957,4857194405374230935,72300007091337,72300008050469,4901122570588587091,72300011597837,4802652529178245579,4901872572377844568,4896054445971689374,72300002175500,72300126503494,4800288484106238425,72300003838941,72300001194493,4859371726133548241,72300011007495,72300000735098,4807710028041490262,72300002112939,4818830102728526662,72300020284517,72300006808810,4843980890195856148,4843984450853767939,72300001708490,4906463524741755609,72300001550426,72300020996550,72300000574724,4797817258464063064,4762811780701734866,4883715837932529819,72300006543979,4906463524472699011,4906475799615681220,72300008964881,72300119508442,72300000458563,72300002168344,72300015545895,4834728309226503706,70400001198573,70400246577610,70400035310888,4900666372567770268,4878249982938717824,70400036434349,70400002192815,70400119508960,70400020507124,70400004771458,70400001805161,70400107485774,4867775094944171223,70400045729366,4808579259717062493,70400001712088,4902109199868087134,70400007511548,70400000866295,70400012808917,70400015545097,70400055296219,4764773244960492378,70400001909142,4883715833935358105,70400055574169,70400152658472,4838025282723928450,4856064445599220100,70400002112386,4762809650133714895,4899929219156059285,4911899597349368516,4854433480133083522,70400137277122,70400126503449,70400065675182,4896760769680330628,4902591415888806737,70400001867611,70400147806561,70400042370760,70400134355089,70400001869226,70400004238313,4848810096002017111,4882346446964030220,4918775309778491867,4918775309522639299,4918775309243627971,70400137280702,70400137279046,4762842167339227603,4868120098103362753,72300001187941,72300001789482,4903667074948123469,70400047275562,70400006543454,70400161053907,70400015092172,70400147142269,70500241074592,70400018214677,70400147146765,70400075893526,70500001192110,4898229684818235287,4904980342309696222,4902584337789078352,70400001550198,70400259291478,4911899698733463695,70400014531341,4800288481950366171,70400001199510,70400000311984,72300007423164,4921298735416154580,70400001708531,70400000735411,4797796471748276498,71300011497641,4823452413621428445,71300018982931,71300013057202,4801442823674199745,71300011703678,4869915748583343307,4783221732033557568,71300045702952,71300001963842,4797459273308025105,4914137360543036101,4801442961708744409,4868120095301567694,4868120090226777946,71300014395671,71300127049672,71300025293315,71300021930906,4915161568935539739,71300023597087,4922394221610998226,4922392874176068035,72300220555560]";
        List<Long> skuIds = JSON.parseArray(json, Long.class);
        return skuIds;
    }


}
