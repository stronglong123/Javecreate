package com.common.generate.javacreate.study;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.bl.UserBL;
import com.common.generate.javacreate.model.user.AdminUser;
import org.apache.tomcat.jni.User;

/**
 * @author xialei
 * @date 2023/5/22 17:56
 */
public class ValueAndRef {

    public static void main(String[] args){
//        AdminUser adminUser = new AdminUser();
//        adminUser.setId(11111);
//        System.out.println(JSON.toJSONString(adminUser));
//
//        update(adminUser);
//        System.out.println(JSON.toJSONString(adminUser));
//
//
//        UserDTO adminUser1 = new UserDTO(3333L);
//        System.out.println(JSON.toJSONString(adminUser1));
//
//        update(adminUser1);
//        System.out.println(JSON.toJSONString(adminUser1));


        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        TreeNode right = treeNode.right;
        System.out.println(right);

        updateTreeNode(right,new TreeNode(3));
        System.out.println(treeNode.right);
    }


    public static void updateTreeNode(TreeNode right, TreeNode rightNode) {
        System.out.println(right);
        right = rightNode;
        System.out.println(right);

    }



    public static void update(AdminUser adminUser){
        adminUser.setId(2222);
    }


    public static void update(UserDTO user){
        user.setId(2222L);
        UserDTO userDTO = new UserDTO(12121L);
        user.setParentUser(userDTO);
    }



}
