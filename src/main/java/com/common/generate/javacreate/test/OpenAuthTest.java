package com.common.generate.javacreate.test;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.dto.MenuSyncDTO;
import com.common.generate.javacreate.test.dto.ThirdMenuItemDTO;
import com.common.generate.javacreate.test.dto.ThirdMenuSyncDTO;
import com.common.generate.javacreate.test.dto.ThirdRoleQueryDTO;
import com.common.generate.javacreate.authutils.AuthUtil;
import com.common.generate.javacreate.utils.HttpUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xialei
 * @date 2020/10/22 17:47
 */
public class OpenAuthTest {

//    private static final String baseUrl = "http://api.test.yijiupi.com";
//    private static final String baseUrl = "http://api.yijiupi.com";
    private static final String baseUrl = "http://api.release.yijiupidev.com";

//    private static final String baseUrl = "http://localhost:40000";

    public static void main(String[] args) {
//        yjx();
        xls();
    }

    public static void jy() {
        String appSecret = "5c41d2fdd2490b70468d1b95e6b2c140";
        String appKey = "a76ef0c5-ae7d-4647-ac3a-e46ef0c5ae7d4647ac3a333864d21adb";
        findPermissionsByRoleCode(appSecret, appKey);
//        findPermissionsJsonByRoleCode(appSecret,appKey);
//        exportMenuByAppCode(appSecret,appKey);
    }

    public static void yjx() {
        String appSecret = "619e0c67f2d86c66733847fe323ea8c2";
        String appKey = "390a540add6e4a28be57b1cdeacbd0a2";
//        findPermissionsByRoleCode(appSecret, appKey);
//        findPermissionsJsonByRoleCode(appSecret,appKey);
        exportMenuByAppCode(appSecret,appKey);
    }

    public static void xls() {
        String appSecret = "11be1659237064a7031ed58bef0c24c9";
        String appKey = "29637763d82c499282553d425047ebe6";
        findPermissionsByRoleCode(appSecret, appKey);
//        findPermissionsJsonByRoleCode(appSecret,appKey);
//        exportMenuByAppCode(appSecret,appKey);
    }



    /**
     * 菜单同步
     *
     * @param appSecret
     * @param appKey
     */
    public static void menuSync(String appSecret, String appKey) {
        String url = baseUrl + "/menu/sync";
        System.out.println("菜单同步" + url);
        String json = "{\"states\":[3],\"saveParams\":false,\"pageSize\":20,\"lastUpdateTimeStart\":\"2020-09-21 23:59:59\",\"lastUpdateTimeEnd\":\"2020-10-21 23:59:59\",\"currentPage\":1,\"queryPayTime\":1}";
        ThirdMenuSyncDTO dto = JSON.parseObject(json, ThirdMenuSyncDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, ThirdMenuSyncDTO.class, dto);
        try {
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
            System.out.println("菜单同步：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }

    /**
     * 通过角色code查询菜单权限
     *
     * @param appSecret
     * @param appKey
     */
    public static void findPermissionsByRoleCode(String appSecret, String appKey) {
        String url = baseUrl + "/role/findPermissionsByRoleCode";
        String json = "{\"appCode\":\"yjpop3\",\"roleCode\":\"TrdDeveloper\",\"serviceId\":\"1081\"}";
        ThirdRoleQueryDTO dto = JSON.parseObject(json, ThirdRoleQueryDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, ThirdRoleQueryDTO.class, dto);
        try {
            System.out.println("通过角色code查询菜单权限:" + urlWithAuth);
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
            System.out.println("通过角色code查询菜单权限：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }

    /**
     * 通过角色code查询菜单权限
     *
     * @param appSecret
     * @param appKey
     */
    public static void exportMenuByAppCode(String appSecret, String appKey) {
        String url = baseUrl + "/role/exportMenuByAppCode";
        System.out.println("通过角色code查询菜单权限:" + url);
        String json = "{\"appCode\":\"dealer_protal\"}";//dealer_protal dealer_manager     dealer_app
        ThirdRoleQueryDTO dto = JSON.parseObject(json, ThirdRoleQueryDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, ThirdRoleQueryDTO.class, dto);
        try {
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
            System.out.println("通过角色code查询菜单权限：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }

    /**
     * 通过角色code查询菜单权限
     *
     * @param appSecret
     * @param appKey
     */
    public static void findPermissionsJsonByRoleCode(String appSecret, String appKey) {
        String url = baseUrl + "/role/findPermissionsByRoleCode";
        System.out.println("通过角色code查询菜单权限:" + url);
//        String json = "{\"appCode\":\"yjpop3\",\"roleCode\":\"TrdDeveloper\",\"serviceId\":\"1123\"}";
        String json = "{\"appCode\":\"yjpop3\",\"roleCode\":\"TrdDeveloper\",\"serviceId\":\"1081\"}";

        ThirdRoleQueryDTO dto = JSON.parseObject(json, ThirdRoleQueryDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, ThirdRoleQueryDTO.class, dto);
        String result ="";
        try {
            result = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
            System.out.println("通过角色code查询菜单权限：" + result);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }

        String data = JSON.parseObject(result).getString("data");
        List<ThirdMenuItemDTO> thirdMenuItemDTOS = JSON.parseArray(data, ThirdMenuItemDTO.class);
        System.out.println("初始:"+JSON.toJSONString(thirdMenuItemDTOS));

        ThirdMenuSyncDTO thirdMenuSyncDTO = convertTree2List(thirdMenuItemDTOS, dto.getAppCode());
        System.out.println("转换:"+JSON.toJSONString(thirdMenuSyncDTO));

    }


    private static ThirdMenuSyncDTO convertTree2List(List<ThirdMenuItemDTO> thirdMenuItemDTOS, String appCode) {
        ThirdMenuSyncDTO result = new ThirdMenuSyncDTO();
        result.setAppCode(appCode);
        if (CollectionUtils.isEmpty(thirdMenuItemDTOS)) {
            return result;
        }
        List<MenuSyncDTO> menus = new ArrayList<>();
        loopMenu(thirdMenuItemDTOS, menus, null);
        result.setMenus(menus);
        return result;
    }

    private static  void loopMenu(List<ThirdMenuItemDTO> menuItemDTOS,List<MenuSyncDTO> menus,String parentCode) {
        if (org.springframework.util.CollectionUtils.isEmpty(menuItemDTOS)) {
            return;
        }
        for (ThirdMenuItemDTO menuItemDTO : menuItemDTOS) {
            menus.add(convertThirdMenuItem2MenuSync(menuItemDTO,parentCode));
            if (CollectionUtils.isNotEmpty(menuItemDTO.getNavList())) {
                loopMenu(menuItemDTO.getNavList(), menus,menuItemDTO.getId());
            }
        }
    }


    public static MenuSyncDTO convertThirdMenuItem2MenuSync(ThirdMenuItemDTO thirdMenuItemDTO,String parentCode){
        MenuSyncDTO menuSyncDTO = new MenuSyncDTO();
        menuSyncDTO.setArgument(thirdMenuItemDTO.getArgument());
        menuSyncDTO.setCode(thirdMenuItemDTO.getId());
        menuSyncDTO.setName(thirdMenuItemDTO.getName());
        menuSyncDTO.setNamespace(thirdMenuItemDTO.getNamespace());
        menuSyncDTO.setImgIcon(thirdMenuItemDTO.getImgIcon());
        menuSyncDTO.setSort(Integer.parseInt(thirdMenuItemDTO.getSort()));
        menuSyncDTO.setType(thirdMenuItemDTO.getType());
        if(!StringUtils.isEmpty(parentCode)){
            menuSyncDTO.setParentCode(parentCode);
        }
        return menuSyncDTO;
    }



}
