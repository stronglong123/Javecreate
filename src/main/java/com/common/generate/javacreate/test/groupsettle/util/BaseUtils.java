package com.common.generate.javacreate.test.groupsettle.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.test.groupsettle.dto.WarehouseDTO;
import com.common.generate.javacreate.utils.HttpClientUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xialei
 * @date 2021/5/2 11:41
 */
public class BaseUtils {

    private static String baseUrl = "http://wms.pre.yijiupi.com/supplyChain/";
    private static final String token = "18e94c53-3a1e-4ba7-b95a-d1edb1e3c30d";






    public static List<WarehouseDTO> getChayiWarehouse(){
//        List<String> warehouseIds =Arrays.asList("4051","4251","7001","4571","4011","4211","7006","4651","1021","1141",
//                "4291","1181","7041","1211","7516","7131","7211","4021","4221","1031","1591","7051","7691","1191","4061",
//                "1101","4731","4031","4671","1121","1681","7061"
//                ,"4191","7141","7581","1091","7231","4041","7111","4121","4001","1011","1131","1051","1171","7031","1001");

        List<String> warehouseIds = Arrays.asList("4051","7231","4041","7211","4031","7111","4021","4121","4001",
                "4651","4211","1681","1031","1141","1591","4191","7041","1191","4061","4731");
        List<WarehouseDTO> warehouseDTOS =new ArrayList<>();
        for (String warehouseId : warehouseIds) {
            WarehouseDTO warehouseDTO = new WarehouseDTO();
            warehouseDTO.setWarehouseId(Integer.valueOf(warehouseId));
            String orgId = warehouseId.substring(0, 3);
            warehouseDTO.setOrgId(Integer.valueOf(orgId));
            warehouseDTOS.add(warehouseDTO);
        }
        return warehouseDTOS;
    }


    public static List<WarehouseDTO> getJiezhuanWarehouse(){
        List<String> warehouseIds =Arrays.asList();
        List<WarehouseDTO> warehouseDTOS =new ArrayList<>();
        for (String warehouseId : warehouseIds) {
            WarehouseDTO warehouseDTO = new WarehouseDTO();
            warehouseDTO.setWarehouseId(Integer.valueOf(warehouseId));
            String orgId = warehouseId.substring(0, 3);
            warehouseDTO.setOrgId(Integer.valueOf(orgId));
            warehouseDTOS.add(warehouseDTO);
        }
        return warehouseDTOS;
    }


    public static List<WarehouseDTO> getJiesuanWarehouse(){
        List<Integer> warehouseIds =Arrays.asList(1141,1031,1181,1191,1591,1681,4001,4021,4031,4041,4051,4061,4121,4191,4211,4571,4651,4731,
                7001,7041,7111,7131,7211,7231);
        List<WarehouseDTO> warehouseDTOS =new ArrayList<>();
        for (Integer warehouseId : warehouseIds) {
            WarehouseDTO warehouseDTO = new WarehouseDTO();
            warehouseDTO.setWarehouseId(warehouseId);
            String orgId = warehouseId.toString().substring(0, 3);
            warehouseDTO.setOrgId(Integer.valueOf(orgId));
            warehouseDTOS.add(warehouseDTO);
        }
        return warehouseDTOS;
    }


    public static String getRequest(String url, String params) {
        url = baseUrl + url +"/"+params;
        String resultstr = HttpClientUtils.doGetWithToken(token, url);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        return JSON.toJSONString(data);
    }


    public static String pageList(String url, String body) {
        url = baseUrl + url;
        String resultstr = HttpClientUtils.doPostWithToken(token, url, body);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        JSONObject pageList = (JSONObject) data;
        Object dataList = pageList.get("dataList");
        return JSON.toJSONString(dataList);
    }

    public static String list(String url, String body) {
        url = baseUrl + url;
        String resultstr = HttpClientUtils.doPostWithToken(token, url, body);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        return JSON.toJSONString(data);
    }


    /**
     * 获取二级货主字符串
     * @param owerMap
     * @param wmsOwnerId
     * @return
     */
    public static String getErpOwnerString(Map<String, String> owerMap,String wmsOwnerId){
        StringBuilder stringBuilder =new StringBuilder();
        if(StringUtils.isEmpty(wmsOwnerId)){
            return "";
        }
        String[] split = wmsOwnerId.split(",");
        for (String s : split) {
            if(StringUtils.isNotEmpty(s)){
                String s1 = owerMap.get(s);
                stringBuilder.append("(").append(s).append(")").append(s1).append(",");
            }
        }
        return stringBuilder.toString();
    }


    public static Map<String, String> getErpOwner(){
        Map<String, String> map = new HashMap<>();
        map.put("null", "null");
        map.put("1", "1");
        map.put("1395869718239553509", "00fea80105fc474cab0fbc0a97a860dd");
        map.put("1395869718239554301", "08f0d360-fce9-4fc9-b1af-9b31904107bc");
        map.put("1395869718239554398", "0a048d140b5241d4840631d144ac53e5");
        map.put("1395869718239554704", "0cd5ffcad7d14319adf2fcb67e1ca972");
        map.put("1395869718239555488", "13a95dc0bc984609ab054b857ef5ed80");
        map.put("1395869718239555868", "1764dbc8f15042689805a232ff825700");
        map.put("1395869718239556438", "1d2351c4b4724d738952ff24ec68d93e");
        map.put("1395869718239556789", "2101e1617de347c097400f652c40a329");
        map.put("1395869718239557083", "231367b7-755b-4502-b569-0fc00daf94f1");
        map.put("1395869718239557615", "27d07fdcd62749c884e3dfb3cc7fdd86");
        map.put("1395869718239557959", "2b1b4852580746508cb1c74988a274f3");
        map.put("1395869718239558230", "2dd8dcf530004065a4bbb3713ae230fa");
        map.put("1395869718239558274", "2e4bbb973b83461cb5748aa75bf5355d");
        map.put("1395869718239558528", "30eb598739614d8d8fedf06a965af7bb");
        map.put("1395869718239558729", "32b86993-ce21-4f6b-934d-f845b8ea921a");
        map.put("1395869718239558853", "33e34ea3b29d4458b0891e8dfefe4b79");
        map.put("1395869718239559734", "3c6cdddd57114af090b5bceb84ec34e5");
        map.put("1395869718239560043", "3f73bd08437e4a5da5a9fe40184ed848");
        map.put("1395869718239560371", "42f0d096302c4a71b61a298fb975862b");
        map.put("1395869718239560491", "44465d531e6445c281cf79626602ceee");
        map.put("1395869718239560526", "449664f9-b98c-43a5-93b9-71559c612539");
        map.put("1395869718239560776", "4631018059840549903");
        map.put("1395869718239560816", "4637465940436225111");
        map.put("1395869718239561517", "4752134375025176967");
        map.put("1395869718239562859", "496d871e8cdb4c46a57e220137a5922b");
        map.put("1395869718239563020", "4997721764487744275");
        map.put("1395869718239566116", "5385492797905426051");
        map.put("1395869718239566340", "5415013070959675082");
        map.put("1395869718239566665", "5472904841269984934");
        map.put("1395869718239566685", "5476282036447307444");
        map.put("1395869718239567101", "5538190906147972170");
        map.put("1395869718239567422", "5592751973857270429");
        map.put("1395869718239569085", "5c073d11239040fcbd4509a94f045aa8");
        map.put("1395869718239569353", "5ebe65c868f84e03b14eb2c1a7f371e2");
        map.put("1395869718239569537", "60afd0f22ba74028948e327d66a4512c");
        map.put("1395869718239569899", "644fc7e59ac14f208c8b81deaab80a80");
        map.put("1395869718239570091", "65dad4901c894f429f1004ecbf1a60df");
        map.put("1395869718239570212", "66f86c68a2b44e6f85681b78e1aa4713");
        map.put("1395869718239570550", "6a6d17b5203d4019ba88de305100af85");
        map.put("1395869718239570580", "6aa6a3dc754343d98ebd7b1f98b3e137");
        map.put("1395869718239571015", "6f4a73bb-37a1-4c58-85cb-f0a723788084");
        map.put("1395869718239571945", "7873c79b8e454f29aa2405fcbb65c96c");
        map.put("1395869718239572067", "79ad195d28d242a48cc31ba833426c42");
        map.put("1395869718239574029", "8c340fcb9fe44fc7abd44c132f4bb776");
        map.put("1395869718239575072", "96e72e43-b938-4390-830b-0df7284fb108");
        map.put("1395869718239576245", "a28e8192398747dc8165f728454bc5c9");
        map.put("1395869718239576307", "a355131be38745f49da5192e6a9a9863");
        map.put("1395869718239576507", "a56ba2f7277a46febc36e61b9489c7af");
        map.put("1395869718239576683", "a7467171ba24472b8c0bd03eee63e441");
        map.put("1395869718239576923", "a9c5819a733e4705a59d129d1500ba91");
        map.put("1395869718239577392", "ae7d2167bc68464bbc2c7a10b06c987a");
        map.put("1395869718239577663", "b15396a4adef4aef9bba9863890513b8");
        map.put("1395869718239577897", "b3e4b2e9f8114b2babfff2b6f35a3dc9");
        map.put("1395869718239578271", "b801a6567af84d19a8f44514e6dd76a5");
        map.put("1395869718239578869", "be2061c921dd456995b2f9a0667c411e");
        map.put("1395869718239579826", "c7ef05e9b8164cc284bddb5e88285530");
        map.put("1395869718239580157", "cb1a0a65e97e4ad48a9d241e75d059d6");
        map.put("1395869718239580225", "cbcdb67b3cff4e73a37dd5a56715e923");
        map.put("1395869718239580494", "ce7771a3189d46ceb776b6e75ca21a9c");
        map.put("1395869718239580830", "d1b6fd0d32e8491d83cc244332cfde7b");
        map.put("1395869718239580856", "d1e068c0aabf45149905d982fa7523fa");
        map.put("1395869718239581073", "d3f1d2f30f1d4af99ca15e85cafbcf72");
        map.put("1395869718239581420", "d771a5f1d3934300a10a45f6ead7f4e0");
        map.put("1395869718239581703", "da9c3cf44869476881810d9bb8f0c527");
        map.put("1395869718239582114", "dee89d942e8c43e5b9c4b023f8d4b6a8");
        map.put("1395869718239582625", "e41b661e3e0e41c7a3be9d0bb42b9812");
        map.put("1395869718239583051", "e8581c70f6d649d2ae96a0025af04017");
        map.put("1395869718239583465", "ecab4cb083d4448cbc3126e248861051");
        map.put("1395869718239584388", "f59933529a0e4a73a6929c881ef7cd22");
        map.put("1395869718239584402", "f5c807351b5f4fc0a3141a8091924983");
        map.put("1395869718239584532", "f6e85c8b3761485d90465b0cdeaa5a74");
        map.put("1395869718239584657", "f8317c16fa0941f2a5cc4a44a6b69e9c");
        map.put("1395869718239584714", "f8ae33cc-61f9-47d5-ae17-d829c2e27221");
        map.put("1395869718239584867", "fa21374bd078455980217f4a8b8e3e22");
        map.put("1395869718239584900", "fa5b332c61e342979f1a7813bc3d463d");
        map.put("1395869718239584926", "fa98890b85be4a3c8cd8a7666a478584");
        map.put("1395869718248270351", "542459504db4468d8890dd70119a2c27");
        map.put("1395869718271632734", "0b6e3838953843e8a0af48c98a9e24f3");
        map.put("1395869718272179017", "7c3a5f5f2574442e8134578c870d4c10");
        map.put("1395869718299174727", "b830ef80d37d40cdaadcd62a305e3402");
        map.put("1395869718355813066", "e2e25334d50340b1b5ffe21be0bff9c5");
        map.put("1395869718359154172", "18ca888ab4324b1bbb42d9bac91730b0");
        map.put("1395869718366073167", "bbf3fea0-bd49-4663-8843-17277991a56f");
        map.put("1395869718366934677", "8a4353b3-1134-41fc-92c4-10607df2f559");
        map.put("1395869718368273196", "09003312-b024-4298-99e8-eefcb47a6bac");
        map.put("1395869718392263257", "f4c36f98-756e-4dbc-8761-6670f02a02bb");
        map.put("1395869718239557435","261b0c60a4a544b59dff28b020fc1ff0");
        map.put("1395869718239557178","23dee1e47a5c4d868c3e63ad6a4c253b");


        map.put("1395869718239558216","2dbb6b4ceaca49da8754d09b4097812a");
        map.put("1395869718239558797","33503ccf3db74cbf9faec0813b420acb");
        map.put("1395869718239560788","4633190554292978110");
        map.put("1395869718239575428","9a54c53f146c409f9b2e272530a3a083");
        map.put("1395869718239575624","9c3d4852867b4afc9de06b0e5ca2f6b9");



        return map;
    }


    public static Map<Long, Long> getSkuSpecMap(){
        Map<Long, Long> map = new HashMap<>();
        map.put(10300001188290L, 1188L);
        map.put(10300001198659L, 1198L);
        map.put(10300001541851L, 1541L);
        map.put(10300001817353L, 1817L);
        map.put(10300002039168L, 2039L);
        map.put(10300002057249L, 2057L);
        map.put(10300002257379L, 2257L);
        map.put(10300034772186L, 34772L);
        map.put(10300036093825L, 36093L);
        map.put(10300039764286L, 39764L);
        map.put(10300058592849L, 58592L);
        map.put(11400151112789L, 151112L);
        map.put(11800001627349L, 1627L);
        map.put(11900001544369L, 1544L);
        map.put(11900002257872L, 2257L);
        map.put(11900003173415L, 3173L);
        map.put(11900107485366L, 107485L);
        map.put(15900000947637L, 947L);
        map.put(15900001542822L, 1542L);
        map.put(15900001543515L, 1543L);
        map.put(15900001545525L, 1545L);
        map.put(15900001555063L, 1555L);
        map.put(15900001570200L, 1570L);
        map.put(15900001571045L, 1571L);
        map.put(15900001698710L, 1698L);
        map.put(15900002112802L, 2112L);
        map.put(15900002257896L, 2257L);
        map.put(15900002387732L, 2387L);
        map.put(15900002494978L, 2494L);
        map.put(15900003107231L, 3107L);
        map.put(15900004100919L, 4100L);
        map.put(15900004804715L, 4804L);
        map.put(15900020284900L, 20284L);
        map.put(15900039764356L, 39764L);
        map.put(15900042053339L, 42053L);
        map.put(15900137139844L, 137139L);
        map.put(15900139449334L, 139449L);
        map.put(16800001198513L, 1198L);
        map.put(16800001550060L, 1550L);
        map.put(16800001556914L, 1556L);
        map.put(16800002494787L, 2494L);
        map.put(16800005831135L, 5831L);
        map.put(16800009707763L, 9707L);
        map.put(16800054414485L, 54414L);
        map.put(16800149552175L, 149552L);
        map.put(40000000274708L, 274L);
        map.put(40000000311338L, 311L);
        map.put(40000000314758L, 314L);
        map.put(40000000327603L, 327L);
        map.put(40000000345936L, 345L);
        map.put(40000001188672L, 1188L);
        map.put(40000001542800L, 1542L);
        map.put(40000001548114L, 1548L);
        map.put(40000002057402L, 2057L);
        map.put(40000002112159L, 2112L);
        map.put(40000002257189L, 2257L);
        map.put(40000003839768L, 3839L);
        map.put(40000004919492L, 4919L);
        map.put(40000007147440L, 7147L);
        map.put(40000008122805L, 8122L);
        map.put(40000011177290L, 11177L);
        map.put(40000011879564L, 11879L);
        map.put(40000014126194L, 14126L);
        map.put(40000025226449L, 25226L);
        map.put(40000031358303L, 31358L);
        map.put(40000035095723L, 35095L);
        map.put(40000125367050L, 125367L);
        map.put(40200000720852L, 720L);
        map.put(40200001185134L, 1185L);
        map.put(40200001186081L, 1186L);
        map.put(40200001196309L, 1196L);
        map.put(40200002039377L, 2039L);
        map.put(40200006699081L, 6699L);
        map.put(40200017931599L, 17931L);
        map.put(40200068373569L, 68373L);
        map.put(40200151112433L, 151112L);
        map.put(40200191003138L, 191003L);
        map.put(40300001789506L, 1789L);
        map.put(40300002175530L, 2175L);
        map.put(40300031652437L, 31652L);
        map.put(40400001083802L, 1083L);
        map.put(40400003532053L, 3532L);
        map.put(40400003801709L, 3801L);
        map.put(40400004804436L, 4804L);
        map.put(40400081238512L, 81238L);
        map.put(40400118324793L, 118324L);
        map.put(40500001542870L, 1542L);
        map.put(40500001543931L, 1543L);
        map.put(40500001732374L, 1732L);
        map.put(40500004903862L, 4903L);
        map.put(40500007324285L, 7324L);
        map.put(40500045918380L, 45918L);
        map.put(40500047275913L, 47275L);
        map.put(40600007145129L, 7145L);
        map.put(40600007322579L, 7322L);
        map.put(40600060789141L, 60789L);
        map.put(41200001188935L, 1188L);
        map.put(41200001547655L, 1547L);
        map.put(41200001548573L, 1548L);
        map.put(41200003107709L, 3107L);
        map.put(41200003839759L, 3839L);
        map.put(41200005460591L, 5460L);
        map.put(41200011226417L, 11226L);
        map.put(41900001570554L, 1570L);
        map.put(42100001548502L, 1548L);
        map.put(42100001740974L, 1740L);
        map.put(42100003896749L, 3896L);
        map.put(42100125367541L, 125367L);
        map.put(45700001732122L, 1732L);
        map.put(45700002112726L, 2112L);
        map.put(45700004041800L, 4041L);
        map.put(45700006670766L, 6670L);
        map.put(45700007322813L, 7322L);
        map.put(45700151112247L, 151112L);
        map.put(45700157424090L, 157424L);
        map.put(45700163299992L, 163299L);
        map.put(45700212349819L, 212349L);
        map.put(46500004120239L, 4120L);
        map.put(47300000314832L, 314L);
        map.put(47300004857769L, 4857L);
        map.put(47300005371601L, 5371L);
        map.put(70400003872819L, 3872L);
        map.put(70400004179551L, 4179L);
        map.put(70400058662050L, 58662L);
        map.put(71100001542278L, 1542L);
        map.put(71100001698972L, 1698L);
        map.put(71100001840110L, 1840L);
        map.put(71100006808431L, 6808L);
        map.put(71100008402891L, 8402L);
        map.put(71100009754035L, 9754L);
        map.put(71100014942681L, 14942L);
        map.put(71100038136458L, 38136L);
        map.put(71100045702871L, 45702L);
        map.put(71100083356891L, 83356L);
        map.put(71100138217725L, 138217L);
        map.put(71300001542537L, 1542L);
        map.put(71300002112740L, 2112L);
        map.put(71300005114385L, 5114L);
        map.put(71300006822427L, 6822L);
        map.put(71300007147815L, 7147L);
        map.put(71300015054397L, 15054L);
        map.put(71300016910015L, 16910L);
        map.put(71300018633970L, 18633L);
        map.put(71300020838857L, 20838L);
        map.put(71300033306951L, 33306L);
        map.put(71300065961108L, 65961L);
        map.put(71300107485940L, 107485L);
        map.put(71300124860465L, 124860L);
        map.put(71300125507884L, 125507L);
        map.put(72100000561291L, 561L);
        map.put(72100001474154L, 1474L);
        map.put(72100001543776L, 1543L);
        map.put(72100001544098L, 1544L);
        map.put(72100002257860L, 2257L);
        map.put(72100064063802L, 64063L);
        map.put(72100092246781L, 92246L);
        map.put(72100095772710L, 95772L);
        map.put(72300000734167L, 734L);
        map.put(72300064063536L, 64063L);
        map.put(4762809650397956061L, 151112L);
        map.put(4772133343308590227L, 29222L);
        map.put(4776428017752634507L, 1196L);
        map.put(4777195708915083281L, 278888L);
        map.put(4777582275521374212L, 278888L);
        map.put(4782934981700893586L, 295901L);
        map.put(4792681681467797833L, 308897L);
        map.put(4798125746493601992L, 48025L);
        map.put(4810048808338993613L, 334557L);
        map.put(4811593850524995407L, 328354L);
        map.put(4831457167568415948L, 358440L);
        map.put(4837683092788004680L, 270849L);
        map.put(4841638631619101918L, 247343L);
        map.put(4843976231850838792L, 1184L);
        map.put(4843976557031033624L, 112022L);
        map.put(4846769685230200662L, 352504L);
        map.put(4850031898749511489L, 325534L);
        map.put(4851462338656020312L, 377300L);
        map.put(4856114310375047578L, 381758L);
        map.put(4856422847213753558L, 382026L);
        map.put(4858349024854966668L, 333218L);
        map.put(4863407525556840346L, 19914L);
        map.put(4864434714945576796L, 381180L);
        map.put(4865617929370338499L, 365384L);
        map.put(4867681516293513043L, 370265L);
        map.put(4868120068898424027L, 393405L);
        map.put(4868120080000746717L, 393405L);
        map.put(4868120080311125195L, 393405L);
        map.put(4868120092218754255L, 393405L);
        map.put(4868120093263135965L, 393405L);
        map.put(4870215270593201360L, 12305L);
        map.put(4874307702317552080L, 398457L);
        map.put(4878295444626545290L, 400795L);
        map.put(4882236137363548800L, 95772L);
        map.put(4883722298632890510L, 404942L);
        map.put(4898229268965576593L, 413057L);
        map.put(4898913301915586445L, 324568L);
        map.put(4899573888009806981L, 1612L);
        map.put(4902119644662319944L, 417014L);
        map.put(4903302845124561758L, 6021L);
        map.put(4904313684237470530L, 406889L);
        map.put(4906403955730592475L, 238L);
        map.put(4911289297360599187L, 74902L);
        map.put(4911289754947203800L, 277444L);
        map.put(4913792322898277086L, 430646L);
        map.put(4914220663409259211L, 412059L);
        map.put(4914829746021642965L, 432168L);
        map.put(4914829890263136385L, 432169L);
        map.put(4914905203882014871L, 427887L);
        map.put(4916246574359063435L, 433349L);
        map.put(4916350124036664198L, 433739L);
        map.put(4916350515008711581L, 433670L);
        map.put(4818371453431371409L, 212396L);
        return map;
    }
}
