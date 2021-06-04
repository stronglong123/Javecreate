package com.common.generate.javacreate.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.generate.javacreate.test.dto.MenuSyncDTO;
import com.common.generate.javacreate.test.dto.ThirdMenuItemDTO;
import com.common.generate.javacreate.test.dto.ThirdMenuSyncDTO;
import com.common.generate.javacreate.test.dto.ThirdRolePermissionDTO;
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
//    private static final String baseUrl = "https://api.yijiupi.com";
    private static final String baseUrl = "http://api.release.yijiupidev.com";
//    private static final String baseUrl = "http://api.pre.yijiupi.com";

//    private static final String baseUrl = "http://localhost:40000";

    public static void main(String[] args) {
        yjx();
//        xls();
//        test();
    }

    /**
     * 菜单同步
     *
     * @param appSecret
     * @param appKey
     */
    public static void test() {
        String appSecret = "803ca158-eae5-4797-8eb7-99231cd71152";
        String appKey ="5b194941-ad61-40ee-9cba-8687f879b4de";
        String url = "http://localhost:8081/pdd/control/decrypt/v1/receiverPhone";
        String json = "{\"accessToken\":\"c58624d39e2d48fbab5d5bb78965c7e9361a8c40\",\"orderStatus\":\"1\",\"pageSize\":20,\"refundStatus\":1,\"isLuckyFlag\":1,\"startUpdatedAt\":\"1609291501\",\"endUpdatedAt\":\"1609291520\",\"order_sn\":\"123456\",\"encryptData\":\"1233455\"}";
        JSONObject jsonObject = JSON.parseObject(json);
        String sign = AuthUtil.getAuth(appSecret, jsonObject);
        url = url + "?sign=" + sign + "&appKey=" + appKey;
        try {
            String post = HttpUtil.post(url, JSON.toJSONString(jsonObject));
            System.out.println("返回结果：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
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
//        exportMenuByAppCode(appSecret,appKey);
        findRoleOrgsByUserId(appSecret,appKey);

    }

    public static void xls() {
        String appSecret = "11be1659237064a7031ed58bef0c24c9";
        String appKey = "29637763d82c499282553d425047ebe6";
        findPermissionsByRoleCode(appSecret, appKey);
//        findPermissionsJsonByRoleCode(appSecret,appKey);
//        exportMenuByAppCode(appSecret,appKey);
//        findRoleOrgsByUserId(appSecret,appKey);
    }

    public static void crm() {
        String appSecret = "333ba1308f704e2c9008253c4fa129af";
        String appKey = "e280a7427be24c9bb6ef2ef61b92c770";
        //        findPermissionsByRoleCode(appSecret, appKey);
//        addPermissionsForRoleCode(appSecret, appKey);
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
    public static void addPermissionsForRoleCode(String appSecret, String appKey) {
        String url = baseUrl + "/role/addPermissionsForRoleCode";
        String json = "{\"appCode\":\"CRM\",\"permissionDTOs\":[{\"code\":\"Home\",\"type\":1},{\"code\":\"Customer\",\"type\":1},{\"code\":\"unRegUser\",\"parentCode\":\"Customer\",\"type\":1},{\"code\":\"unRegUserDetail\",\"parentCode\":\"unRegUser\",\"type\":1},{\"code\":\"broker_unreg_export_btn\",\"parentCode\":\"unRegUser\",\"type\":2},{\"code\":\"BizUserCorrectAddress\",\"parentCode\":\"Customer\",\"type\":1},{\"code\":\"audit_customer_address_detail\",\"parentCode\":\"BizUserCorrectAddress\",\"type\":1},{\"code\":\"areaRange_detail\",\"parentCode\":\"BizUserCorrectAddress\",\"type\":1},{\"code\":\"area_range_audit_btn\",\"parentCode\":\"BizUserCorrectAddress\",\"type\":2},{\"code\":\"WaitBackHandleBizList\",\"parentCode\":\"Customer\",\"type\":1},{\"code\":\"handle_customer_admin_btn\",\"parentCode\":\"WaitBackHandleBizList\",\"type\":2},{\"code\":\"handle_customer_reaudit_btn\",\"parentCode\":\"WaitBackHandleBizList\",\"type\":2},{\"code\":\"handle_customer_audit_btn\",\"parentCode\":\"WaitBackHandleBizList\",\"type\":2},{\"code\":\"handle_customer_appoint_btn\",\"parentCode\":\"WaitBackHandleBizList\",\"type\":2},{\"code\":\"handle_customer_reappoint_btn\",\"parentCode\":\"WaitBackHandleBizList\",\"type\":2},{\"code\":\"WaitBrokerHandleBiz\",\"parentCode\":\"Customer\",\"type\":1},{\"code\":\"broker_handle_customer_reappoint_btn\",\"parentCode\":\"WaitBrokerHandleBiz\",\"type\":2},{\"code\":\"broker_handle_customer_admin_btn\",\"parentCode\":\"WaitBrokerHandleBiz\",\"type\":2},{\"code\":\"AuditRefuseBizList\",\"parentCode\":\"Customer\",\"type\":1},{\"code\":\"audit_refuse_reaudit_btn\",\"parentCode\":\"AuditRefuseBizList\",\"type\":2},{\"code\":\"bizUser_enabled_list\",\"parentCode\":\"Customer\",\"type\":1},{\"code\":\"BizConnectAreaBroker\",\"parentCode\":\"bizUser_enabled_list\",\"type\":1},{\"code\":\"bizUser_detail\",\"parentCode\":\"bizUser_enabled_list\",\"type\":1},{\"code\":\"BonusList\",\"parentCode\":\"bizUser_enabled_list\",\"type\":1},{\"code\":\"CouponList\",\"parentCode\":\"bizUser_enabled_list\",\"type\":1},{\"code\":\"saleUserList\",\"parentCode\":\"bizUser_enabled_list\",\"type\":1},{\"code\":\"bizAreaSetHistory\",\"parentCode\":\"bizUser_enabled_list\",\"type\":1},{\"code\":\"useraddressList\",\"parentCode\":\"bizUser_enabled_list\",\"type\":1},{\"code\":\"bizAreaOrderSum\",\"parentCode\":\"bizUser_enabled_list\",\"type\":1},{\"code\":\"biz_user_batch_btn\",\"parentCode\":\"bizUser_enabled_list\",\"type\":2},{\"code\":\"bizAuditRecord\",\"parentCode\":\"bizUser_enabled_list\",\"type\":1},{\"code\":\"biz_user_broker_btn\",\"parentCode\":\"bizUser_enabled_list\",\"type\":2},{\"code\":\"biz_user_edit_btn\",\"parentCode\":\"bizUser_enabled_list\",\"type\":2},{\"code\":\"biz_user_enable_btn\",\"parentCode\":\"bizUser_enabled_list\",\"type\":2},{\"code\":\"biz_user_export_btn\",\"parentCode\":\"bizUser_enabled_list\",\"type\":2},{\"code\":\"biz_user_frozen_btn\",\"parentCode\":\"bizUser_enabled_list\",\"type\":2},{\"code\":\"bizUser_disabled_list\",\"parentCode\":\"Customer\",\"type\":1},{\"code\":\"bizUserTransferList\",\"parentCode\":\"Customer\",\"type\":1},{\"code\":\"bizUserTransferDetail\",\"parentCode\":\"bizUserTransferList\",\"type\":1},{\"code\":\"BizuserAddressV2\",\"type\":1},{\"code\":\"WaitBackHandleAddrList\",\"parentCode\":\"BizuserAddressV2\",\"type\":1},{\"code\":\"handle_addr_appoint_btn\",\"parentCode\":\"WaitBackHandleAddrList\",\"type\":2},{\"code\":\"handle_addr_audit_btn\",\"parentCode\":\"WaitBackHandleAddrList\",\"type\":2},{\"code\":\"WaitBrokerHandleList\",\"parentCode\":\"BizuserAddressV2\",\"type\":1},{\"code\":\"broker_handle_addr_reappoint_btn\",\"parentCode\":\"WaitBrokerHandleList\",\"type\":2},{\"code\":\"broker_handle_addr_admin_btn\",\"parentCode\":\"WaitBrokerHandleList\",\"type\":2},{\"code\":\"EnableAddrHandleList\",\"parentCode\":\"BizuserAddressV2\",\"type\":1},{\"code\":\"InvalidAddrHandleList\",\"parentCode\":\"BizuserAddressV2\",\"type\":1},{\"code\":\"addrDetail\",\"parentCode\":\"InvalidAddrHandleList\",\"type\":1},{\"code\":\"invalid_addr_audit_btn\",\"parentCode\":\"InvalidAddrHandleList\",\"type\":2},{\"code\":\"WaitCorrectAddrList\",\"parentCode\":\"BizuserAddressV2\",\"type\":1},{\"code\":\"WaitCorrectAddrDetail\",\"parentCode\":\"WaitCorrectAddrList\",\"type\":1},{\"code\":\"correct_addr_edit_btn\",\"parentCode\":\"WaitCorrectAddrList\",\"type\":2},{\"code\":\"CityPersonal\",\"type\":1},{\"code\":\"Citys\",\"parentCode\":\"CityPersonal\",\"type\":1},{\"code\":\"city_edit\",\"parentCode\":\"Citys\",\"type\":1},{\"code\":\"city_admin\",\"parentCode\":\"Citys\",\"type\":1},{\"code\":\"city_saleUser\",\"parentCode\":\"Citys\",\"type\":1},{\"code\":\"city_deliveryUser\",\"parentCode\":\"Citys\",\"type\":1},{\"code\":\"city_cashier\",\"parentCode\":\"Citys\",\"type\":1},{\"code\":\"cityregion_range\",\"parentCode\":\"Citys\",\"type\":1},{\"code\":\"cityregionRange_add\",\"parentCode\":\"Citys\",\"type\":1},{\"code\":\"city_addCityAdmin\",\"parentCode\":\"Citys\",\"type\":2},{\"code\":\"region_addStreet\",\"parentCode\":\"Citys\",\"type\":2},{\"code\":\"city_addCashier\",\"parentCode\":\"Citys\",\"type\":2},{\"code\":\"city_user_mark_edit_btn\",\"parentCode\":\"Citys\",\"type\":2},{\"code\":\"cityBrokerArea\",\"parentCode\":\"CityPersonal\",\"type\":1},{\"code\":\"brokerDetail\",\"parentCode\":\"cityBrokerArea\",\"type\":1},{\"code\":\"transClientRuleSetting\",\"parentCode\":\"cityBrokerArea\",\"type\":1},{\"code\":\"updateClientTransRule\",\"parentCode\":\"transClientRuleSetting\",\"type\":1},{\"code\":\"city_broker_rule_btn\",\"parentCode\":\"cityBrokerArea\",\"type\":2},{\"code\":\"city_broker_batch_btn\",\"parentCode\":\"cityBrokerArea\",\"type\":2},{\"code\":\"city_broker_region_btn\",\"parentCode\":\"cityBrokerArea\",\"type\":2},{\"code\":\"specialAreaBizListBroker\",\"parentCode\":\"CityPersonal\",\"type\":1},{\"code\":\"OrderPerform\",\"type\":1},{\"code\":\"OrderManage\",\"parentCode\":\"OrderPerform\",\"type\":1},{\"code\":\"OrderDetail\",\"parentCode\":\"OrderManage\",\"type\":1},{\"code\":\"ReturnOrderManage\",\"parentCode\":\"OrderPerform\",\"type\":1},{\"code\":\"ReturnOrerDetail\",\"parentCode\":\"ReturnOrderManage\",\"type\":1},{\"code\":\"Task\",\"type\":1},{\"code\":\"ValidCustomerMoney\",\"parentCode\":\"Task\",\"type\":1},{\"code\":\"BatchSetValidMoney_admin\",\"parentCode\":\"ValidCustomerMoney\",\"type\":2},{\"code\":\"ValidBizMoneySetDetail\",\"parentCode\":\"ValidCustomerMoney\",\"type\":1},{\"code\":\"BatchSetValidMoney_admin\",\"parentCode\":\"ValidCustomerMoney\",\"type\":2},{\"code\":\"cityMonth_OPAdminShow\",\"parentCode\":\"ValidCustomerMoney\",\"type\":2},{\"code\":\"taskTemplateList\",\"parentCode\":\"Task\",\"type\":1},{\"code\":\"addTaskTemplate\",\"parentCode\":\"taskTemplateList\",\"type\":1},{\"code\":\"editTaskTemplate\",\"parentCode\":\"taskTemplateList\",\"type\":1},{\"code\":\"addTaskCityTemplate\",\"parentCode\":\"taskTemplateList\",\"type\":1},{\"code\":\"editCityTaskTemplate\",\"parentCode\":\"taskTemplateList\",\"type\":1},{\"code\":\"task_template_copy_btn\",\"parentCode\":\"taskTemplateList\",\"type\":2},{\"code\":\"task_template_city_btn\",\"parentCode\":\"taskTemplateList\",\"type\":2},{\"code\":\"task_template_edit_btn\",\"parentCode\":\"taskTemplateList\",\"type\":2},{\"code\":\"task_template_master_btn\",\"parentCode\":\"taskTemplateList\",\"type\":2},{\"code\":\"task_template_broker_btn\",\"parentCode\":\"taskTemplateList\",\"type\":2},{\"code\":\"visitTaskList\",\"parentCode\":\"Task\",\"type\":1},{\"code\":\"visitTaskDailyDetail\",\"parentCode\":\"visitTaskList\",\"type\":1},{\"code\":\"visitTaskMonthDetail\",\"parentCode\":\"visitTaskDailyDetail\",\"type\":1},{\"code\":\"visit_qdtask_export_btn\",\"parentCode\":\"visitTaskList\",\"type\":2},{\"code\":\"Visit\",\"type\":1},{\"code\":\"userVisit\",\"parentCode\":\"Visit\",\"type\":1},{\"code\":\"userVisit_Detail\",\"parentCode\":\"userVisit\",\"type\":1},{\"code\":\"userVisit_selectCiity\",\"parentCode\":\"userVisit\",\"type\":2},{\"code\":\"userVisit_OPAdminShow\",\"parentCode\":\"userVisit\",\"type\":2},{\"code\":\"broker_attendance_export\",\"parentCode\":\"userVisit\",\"type\":2},{\"code\":\"user_visit_export\",\"parentCode\":\"userVisit\",\"type\":2},{\"code\":\"BrokerContactRecordList\",\"parentCode\":\"Visit\",\"type\":1},{\"code\":\"brokerContact_OPAdminShow\",\"parentCode\":\"BrokerContactRecordList\",\"type\":2},{\"code\":\"InformationManage\",\"type\":1},{\"code\":\"reportMessage\",\"parentCode\":\"InformationManage\",\"type\":1},{\"code\":\"reportMessage_detail\",\"parentCode\":\"reportMessage\",\"type\":1},{\"code\":\"report_message_handle\",\"parentCode\":\"reportMessage\",\"type\":2},{\"code\":\"reportMessage_selectCity\",\"parentCode\":\"reportMessage\",\"type\":2},{\"code\":\"Reportedprice\",\"parentCode\":\"InformationManage\",\"type\":1},{\"code\":\"reply_price_complaint\",\"parentCode\":\"Reportedprice\",\"type\":2},{\"code\":\"priceComplaint_detail_OPAdmin\",\"parentCode\":\"Reportedprice\",\"type\":1},{\"code\":\"Reportedprice_OPAdmin\",\"parentCode\":\"Reportedprice\",\"type\":2},{\"code\":\"handle_priceComplaint_button\",\"parentCode\":\"Reportedprice\",\"type\":2},{\"code\":\"export_price_complaint\",\"parentCode\":\"Reportedprice\",\"type\":2},{\"code\":\"RetailPriceManage\",\"parentCode\":\"InformationManage\",\"type\":1},{\"code\":\"retailPriceDetail\",\"parentCode\":\"RetailPriceManage\",\"type\":1},{\"code\":\"ContractManage\",\"type\":1},{\"code\":\"displayContractTemplate\",\"parentCode\":\"ContractManage\",\"type\":1},{\"code\":\"displayContractTemplateDetail\",\"parentCode\":\"displayContractTemplate\",\"type\":1},{\"code\":\"addDisplayContractTemplate\",\"parentCode\":\"displayContractTemplate\",\"type\":1},{\"code\":\"edit_template\",\"parentCode\":\"displayContractTemplate\",\"type\":2},{\"code\":\"create_template\",\"parentCode\":\"displayContractTemplate\",\"type\":2},{\"code\":\"DisplayContractClient\",\"parentCode\":\"ContractManage\",\"type\":1},{\"code\":\"displayContractDetail\",\"parentCode\":\"DisplayContractClient\",\"type\":1},{\"code\":\"export_contract_Client\",\"parentCode\":\"DisplayContractClient\",\"type\":2},{\"code\":\"city_AdminShow\",\"parentCode\":\"DisplayContractClient\",\"type\":2},{\"code\":\"displayContract_Audit\",\"parentCode\":\"DisplayContractClient\",\"type\":2},{\"code\":\"update_broker\",\"parentCode\":\"DisplayContractClient\",\"type\":2},{\"code\":\"BrokerNotification\",\"type\":1},{\"code\":\"BrokerNotificationDetail\",\"parentCode\":\"BrokerNotification\",\"type\":1},{\"code\":\"BrokerNotificationAdd\",\"parentCode\":\"BrokerNotificationDetail\",\"type\":1},{\"code\":\"BrokerNotificationEdit\",\"parentCode\":\"BrokerNotificationDetail\",\"type\":1},{\"code\":\"notification_OPAdminShow\",\"parentCode\":\"BrokerNotificationDetail\",\"type\":2},{\"code\":\"add_notice\",\"parentCode\":\"BrokerNotificationDetail\",\"type\":2},{\"code\":\"CustomerService\",\"type\":1},{\"code\":\"ReturnVisitAbnormalOrder\",\"parentCode\":\"CustomerService\",\"type\":1},{\"code\":\"ReturnVisitAbnormalOrderDetail\",\"parentCode\":\"ReturnVisitAbnormalOrder\",\"type\":1},{\"code\":\"export_visit_abnormal_order\",\"parentCode\":\"ReturnVisitAbnormalOrder\",\"type\":2},{\"code\":\"export_abnormal_order\",\"parentCode\":\"ReturnVisitAbnormalOrder\",\"type\":2},{\"code\":\"wait_back_visit\",\"parentCode\":\"ReturnVisitAbnormalOrder\",\"type\":2},{\"code\":\"WaitAuditAbnormalOrder\",\"parentCode\":\"CustomerService\",\"type\":1},{\"code\":\"WaitAuditAbnormalOrderDetail\",\"parentCode\":\"WaitAuditAbnormalOrder\",\"type\":1},{\"code\":\"export_audit_abnormal_order\",\"parentCode\":\"WaitAuditAbnormalOrder\",\"type\":2},{\"code\":\"wait_admin_handle\",\"parentCode\":\"WaitAuditAbnormalOrder\",\"type\":2},{\"code\":\"StatisticsAbnormalOrder\",\"parentCode\":\"CustomerService\",\"type\":1},{\"code\":\"export_statistics_abnormal_order\",\"parentCode\":\"StatisticsAbnormalOrder\",\"type\":2},{\"code\":\"CustomerComplaint\",\"parentCode\":\"CustomerService\",\"type\":1},{\"code\":\"CustomerComplaintDetail\",\"parentCode\":\"CustomerComplaint\",\"type\":1},{\"code\":\"AddCustomerComplaint\",\"parentCode\":\"CustomerComplaint\",\"type\":1},{\"code\":\"customer_complaint_add_btn\",\"parentCode\":\"CustomerComplaint\",\"type\":2},{\"code\":\"export_customer_complaint\",\"parentCode\":\"CustomerComplaint\",\"type\":2},{\"code\":\"customer_complaint_edit_btn\",\"parentCode\":\"CustomerComplaint\",\"type\":2},{\"code\":\"CustomerSearchGoods\",\"parentCode\":\"CustomerService\",\"type\":1},{\"code\":\"SearchGoodsDetail\",\"parentCode\":\"CustomerSearchGoods\",\"type\":1},{\"code\":\"customer_search_goods_mark_btn\",\"parentCode\":\"CustomerSearchGoods\",\"type\":2},{\"code\":\"export_customer_search_goods\",\"parentCode\":\"CustomerSearchGoods\",\"type\":2},{\"code\":\"customer_search_goods_edit_btn\",\"parentCode\":\"CustomerSearchGoods\",\"type\":2},{\"code\":\"EmployeeComplaint\",\"parentCode\":\"CustomerService\",\"type\":1},{\"code\":\"EmployeeComplaintDetail\",\"parentCode\":\"EmployeeComplaint\",\"type\":1},{\"code\":\"confirm_employee_complaint\",\"parentCode\":\"EmployeeComplaint\",\"type\":2},{\"code\":\"employee_complaint_choseSyncPerson\",\"parentCode\":\"EmployeeComplaint\",\"type\":2},{\"code\":\"employee_complaint_detail_btn\",\"parentCode\":\"EmployeeComplaint\",\"type\":2},{\"code\":\"taskCenter\",\"type\":1},{\"code\":\"taskcenter_humangroup_setting\",\"parentCode\":\"taskCenter\",\"type\":1},{\"code\":\"taskcenterHumangroupAddByDept\",\"parentCode\":\"taskcenter_humangroup_setting\",\"type\":1},{\"code\":\"taskcenterHumangroupAddFree\",\"parentCode\":\"taskcenter_humangroup_setting\",\"type\":1},{\"code\":\"taskcenterHumangroupEditByDept\",\"parentCode\":\"taskcenter_humangroup_setting\",\"type\":1},{\"code\":\"taskcenterHumangroupEditFree\",\"parentCode\":\"taskcenter_humangroup_setting\",\"type\":1},{\"code\":\"taskcenterHumangroupViewByDept\",\"parentCode\":\"taskcenter_humangroup_setting\",\"type\":1},{\"code\":\"taskcenterHumangroupViewFree\",\"parentCode\":\"taskcenter_humangroup_setting\",\"type\":1},{\"code\":\"preview_person\",\"parentCode\":\"taskcenter_humangroup_setting\",\"type\":2},{\"code\":\"add_by_department\",\"parentCode\":\"taskcenter_humangroup_setting\",\"type\":2},{\"code\":\"add_by_person\",\"parentCode\":\"taskcenter_humangroup_setting\",\"type\":2},{\"code\":\"del_person\",\"parentCode\":\"taskcenter_humangroup_setting\",\"type\":2},{\"code\":\"disable_person\",\"parentCode\":\"taskcenter_humangroup_setting\",\"type\":2},{\"code\":\"edit_person\",\"parentCode\":\"taskcenter_humangroup_setting\",\"type\":2},{\"code\":\"taskcenter_template_type\",\"parentCode\":\"taskCenter\",\"type\":1},{\"code\":\"addTemplateType\",\"parentCode\":\"taskcenter_template_type\",\"type\":1},{\"code\":\"editTemplateType\",\"parentCode\":\"taskcenter_template_type\",\"type\":1},{\"code\":\"change_status_template_type\",\"parentCode\":\"taskcenter_template_type\",\"type\":2},{\"code\":\"del_template_type\",\"parentCode\":\"taskcenter_template_type\",\"type\":2},{\"code\":\"edit_template_type\",\"parentCode\":\"taskcenter_template_type\",\"type\":2},{\"code\":\"add_task_template_type\",\"parentCode\":\"taskcenter_template_type\",\"type\":2},{\"code\":\"taskcenterTaskScheduleSetting\",\"parentCode\":\"taskCenter\",\"type\":1},{\"code\":\"addTaskSchedule\",\"parentCode\":\"taskcenterTaskScheduleSetting\",\"type\":1},{\"code\":\"updateTaskSchedule\",\"parentCode\":\"taskcenterTaskScheduleSetting\",\"type\":1},{\"code\":\"viewTaskScheduleDetail\",\"parentCode\":\"taskcenterTaskScheduleSetting\",\"type\":1},{\"code\":\"add_task_schedule\",\"parentCode\":\"taskcenterTaskScheduleSetting\",\"type\":2},{\"code\":\"del_schedule\",\"parentCode\":\"taskcenterTaskScheduleSetting\",\"type\":2},{\"code\":\"edit_task_schedule\",\"parentCode\":\"taskcenterTaskScheduleSetting\",\"type\":2},{\"code\":\"change_status_schedule\",\"parentCode\":\"taskcenterTaskScheduleSetting\",\"type\":2},{\"code\":\"taskcenterCheckSetting\",\"parentCode\":\"taskCenter\",\"type\":1},{\"code\":\"addTaskCheck\",\"parentCode\":\"taskcenterCheckSetting\",\"type\":1},{\"code\":\"updateTaskCheck\",\"parentCode\":\"taskcenterCheckSetting\",\"type\":1},{\"code\":\"add_task_check\",\"parentCode\":\"taskcenterCheckSetting\",\"type\":2},{\"code\":\"change_status_task_check\",\"parentCode\":\"taskcenterCheckSetting\",\"type\":2},{\"code\":\"edit_task_check\",\"parentCode\":\"taskcenterCheckSetting\",\"type\":2},{\"code\":\"del_task_check\",\"parentCode\":\"taskcenterCheckSetting\",\"type\":2},{\"code\":\"taskcenter_remind_setting\",\"parentCode\":\"taskCenter\",\"type\":1},{\"code\":\"addTaskRemind\",\"parentCode\":\"taskcenter_remind_setting\",\"type\":1},{\"code\":\"updateTaskRemind\",\"parentCode\":\"taskcenter_remind_setting\",\"type\":1},{\"code\":\"viewTaskNoticeDetail\",\"parentCode\":\"taskcenter_remind_setting\",\"type\":1},{\"code\":\"edit_task_remind\",\"parentCode\":\"taskcenter_remind_setting\",\"type\":2},{\"code\":\"change_status_task_remind\",\"parentCode\":\"taskcenter_remind_setting\",\"type\":2},{\"code\":\"del_task_remind\",\"parentCode\":\"taskcenter_remind_setting\",\"type\":2},{\"code\":\"add_task_remind\",\"parentCode\":\"taskcenter_remind_setting\",\"type\":2},{\"code\":\"taskTemplateMgr\",\"parentCode\":\"taskCenter\",\"type\":1},{\"code\":\"viewHugeOrderTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"editHugeOrderTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addHugeOrderTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"chooseTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addUserAddressAuditTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"ViewUserAddressAuditTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"editUserAddressAuditTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addCommonTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewCommonTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"editCommonTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewHumanGroupDetail_taskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewTaskNoticeDetail_taskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewTaskScheduleDetail_taskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addCompetitionTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"editCompetitionTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewCompetitionTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"add_task_template\",\"parentCode\":\"taskTemplateMgr\",\"type\":2},{\"code\":\"editAbnormalOrderTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addCustomerInfoCollectTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"editKeepAliveTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"editHotProductScan\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewDocTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addAbnormalOrderTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"editReturnOrderTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addDocTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"change_status_task_template\",\"parentCode\":\"taskTemplateMgr\",\"type\":2},{\"code\":\"addAddressCorrectTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"editAuditBizTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewDailyOrderBizusersTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"edit_task_template\",\"parentCode\":\"taskTemplateMgr\",\"type\":2},{\"code\":\"editDocTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewCustomerInfoCollectTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"editHotProductCustomer\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"editAbnormalPurchaseOrder\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addDailyOrderBizusersTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewHotProductCustomer\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addAuditBizTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"auditBizTaskTemplateDetail\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewKeepAliveTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewAbnormalOrderTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"editCustomerInfoCollectTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addReturnOrderTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"create_task_template\",\"parentCode\":\"taskTemplateMgr\",\"type\":2},{\"code\":\"editMonthOrderClientTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"editAddressCorrectTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addMonthOrderClientTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addKeepAliveTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addHotProductCustomer\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewAddressCorrectTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addHotProductScan\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"addAbnormalPurchaseOrder\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewReturnOrderTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewHotProductScan\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewAbnormalPurchaseOrder\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"editDailyOrderBizusersTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"viewMonthOrderClientTaskTemplate\",\"parentCode\":\"taskTemplateMgr\",\"type\":1},{\"code\":\"del_task_template\",\"parentCode\":\"taskTemplateMgr\",\"type\":2},{\"code\":\"taskcenter_task\",\"parentCode\":\"taskCenter\",\"type\":1},{\"code\":\"viewHugeOrderTask\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"viewUserAddressAuditTask\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"task_OPAdminShow\",\"parentCode\":\"taskcenter_task\",\"type\":2},{\"code\":\"viewCommonTask\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"viewCompetitionTask\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"viewHotProductCustomerTask\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"viewInformationCollectionTask\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"viewMonthOrderClientTaskDetail\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"viewDailyOrderBizUserTaskDetail\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"viewKeepAliveTask\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"viewHotProductScanTask\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"viewReturnOrderTask\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"viewDocTaskDetail\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"destroy_task\",\"parentCode\":\"taskcenter_task\",\"type\":2},{\"code\":\"viewAbnormalPurchaseOrderTask\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"AuditBizTaskDetail\",\"parentCode\":\"taskcenter_task\",\"type\":1},{\"code\":\"viewAbnormalOrderTask\",\"parentCode\":\"taskCenter\",\"type\":1},{\"code\":\"viewAddressCorrectTask\",\"parentCode\":\"taskCenter\",\"type\":1},{\"code\":\"TaskReport\",\"type\":1},{\"code\":\"cp_first_stage\",\"parentCode\":\"TaskReport\",\"type\":1},{\"code\":\"competeFirstStageExt\",\"parentCode\":\"cp_first_stage\",\"type\":2},{\"code\":\"cp_second_stage\",\"parentCode\":\"TaskReport\",\"type\":1},{\"code\":\"competeSecondStageExt\",\"parentCode\":\"cp_second_stage\",\"type\":2},{\"code\":\"month_order_report\",\"parentCode\":\"TaskReport\",\"type\":1},{\"code\":\"monthOrderReportExt\",\"parentCode\":\"month_order_report\",\"type\":2},{\"code\":\"day_order_bizuser_report\",\"parentCode\":\"month_order_report\",\"type\":1},{\"code\":\"keep_alive_report\",\"parentCode\":\"TaskReport\",\"type\":1},{\"code\":\"keepAliveExt\",\"parentCode\":\"keep_alive_report\",\"type\":2},{\"code\":\"info_collect_report\",\"parentCode\":\"TaskReport\",\"type\":1},{\"code\":\"infoCollectReportExt\",\"parentCode\":\"info_collect_report\",\"type\":2},{\"code\":\"hotProductScanReportList\",\"parentCode\":\"TaskReport\",\"type\":1},{\"code\":\"hotProductScanReportExt\",\"parentCode\":\"hotProductScanReportList\",\"type\":2},{\"code\":\"docTaskReportList\",\"parentCode\":\"TaskReport\",\"type\":1},{\"code\":\"docTaskReportExt\",\"parentCode\":\"docTaskReportList\",\"type\":2},{\"code\":\"abnormal_message_Manage\",\"type\":1},{\"code\":\"viewMessageBoard\",\"parentCode\":\"abnormal_message_Manage\",\"type\":1},{\"code\":\"addViewAbnormalMsg\",\"parentCode\":\"viewMessageBoard\",\"type\":2},{\"code\":\"fullResendAbnormalMsg\",\"parentCode\":\"viewMessageBoard\",\"type\":2},{\"code\":\"resendOutAbnormalMsg\",\"parentCode\":\"viewMessageBoard\",\"type\":2},{\"code\":\"editViewAbnormalMsg\",\"parentCode\":\"viewMessageBoard\",\"type\":2},{\"code\":\"delViewAbnormalMsg\",\"parentCode\":\"viewMessageBoard\",\"type\":2},{\"code\":\"LearningMaterial\",\"type\":1},{\"code\":\"addLearningMaterial\",\"parentCode\":\"LearningMaterial\",\"type\":1},{\"code\":\"delete_learn_material_btn\",\"parentCode\":\"addLearningMaterial\",\"type\":2},{\"code\":\"BaseConfigManage\",\"type\":1},{\"code\":\"broker_channel_list\",\"parentCode\":\"BaseConfigManage\",\"type\":1},{\"code\":\"add_broker_channel\",\"parentCode\":\"broker_channel_list\",\"type\":1},{\"code\":\"edit_broker_channel\",\"parentCode\":\"broker_channel_list\",\"type\":1},{\"code\":\"editBrokerChannel\",\"parentCode\":\"broker_channel_list\",\"type\":2},{\"code\":\"broker_region_list\",\"parentCode\":\"BaseConfigManage\",\"type\":1},{\"code\":\"add_broker_region\",\"parentCode\":\"broker_region_list\",\"type\":1},{\"code\":\"edit_broker_region\",\"parentCode\":\"broker_region_list\",\"type\":1},{\"code\":\"disableBrokerRegion\",\"parentCode\":\"broker_region_list\",\"type\":2},{\"code\":\"enableBrokerRegion\",\"parentCode\":\"broker_region_list\",\"type\":2},{\"code\":\"bizUserAutoReleaseRuleList\",\"parentCode\":\"BaseConfigManage\",\"type\":1},{\"code\":\"addBizUserAutoReleaseRule\",\"parentCode\":\"bizUserAutoReleaseRuleList\",\"type\":1},{\"code\":\"editBizUserAutoReleaseRule\",\"parentCode\":\"bizUserAutoReleaseRuleList\",\"type\":1},{\"code\":\"viewBizUserAutoReleaseRule\",\"parentCode\":\"bizUserAutoReleaseRuleList\",\"type\":1},{\"code\":\"delBizAutoReleaseRule\",\"parentCode\":\"bizUserAutoReleaseRuleList\",\"type\":2},{\"code\":\"Broker_Holiday\",\"parentCode\":\"BaseConfigManage\",\"type\":1},{\"code\":\"broker_holiday_add\",\"parentCode\":\"Broker_Holiday\",\"type\":1},{\"code\":\"delHoliday\",\"parentCode\":\"Broker_Holiday\",\"type\":2},{\"code\":\"AccountSystem\",\"type\":1},{\"code\":\"rewardList\",\"parentCode\":\"AccountSystem\",\"type\":1},{\"code\":\"rewardDetail\",\"parentCode\":\"rewardList\",\"type\":1},{\"code\":\"rewardDetailExt\",\"parentCode\":\"rewardDetail\",\"type\":2},{\"code\":\"rewardExt\",\"parentCode\":\"rewardList\",\"type\":2},{\"code\":\"penaltyList\",\"parentCode\":\"AccountSystem\",\"type\":1},{\"code\":\"penaltyDetail\",\"parentCode\":\"penaltyList\",\"type\":1},{\"code\":\"addPenalty\",\"parentCode\":\"penaltyList\",\"type\":1},{\"code\":\"penaltyExt\",\"parentCode\":\"penaltyList\",\"type\":2},{\"code\":\"role_management\",\"type\":1},{\"code\":\"roleList\",\"parentCode\":\"role_management\",\"type\":1},{\"code\":\"addRole\",\"parentCode\":\"role_management\",\"type\":1},{\"code\":\"editRoleUser\",\"parentCode\":\"role_management\",\"type\":1}],\"roleCode\":\"OPAdmin\",\"serviceId\":1088}";
        ThirdRolePermissionDTO dto = JSON.parseObject(json, ThirdRolePermissionDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, ThirdRolePermissionDTO.class, dto);
        try {
            System.out.println("添加角色权限: " + urlWithAuth);
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
            System.out.println("添加角色权限：" + post);
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
        String json = "{\"appCode\":\"yjp_retail\",\"roleCode\":\"EasyChainDeveloper\",\"serviceId\":\"1085\"}";
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


    /**
     * 通过角色code查询菜单权限
     *
     * @param appSecret
     * @param appKey
     */
    public static void findRoleOrgsByUserId(String appSecret, String appKey) {
        String url = baseUrl + "/role/findRoleOrgsByUserId";
        System.out.println("通过角色查询组织:" + url);
        String json = "{\"refUserId\":\"27418\"}";//dealer_protal dealer_manager     dealer_app
        ThirdRoleQueryDTO dto = JSON.parseObject(json, ThirdRoleQueryDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, ThirdRoleQueryDTO.class, dto);
        try {
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
            System.out.println("通过角色查询组织：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }



}
