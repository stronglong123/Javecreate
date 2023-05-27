package com.common.generate.javacreate.study;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author xialei
 * @date 2023/5/22 16:08
 */
public class JavaTest {

    /**
     * 小红的价值二叉树
     * 小红拿到了一棵二叉树，定义每个节点的价值为子树节点乘积的末尾0的数量。现在请你返回一棵二叉树，树的结构和给定的二叉树相同，
     * 将每个节点的权值替换为该节点的价值。
     *
     * 二叉树节点数不超过
     * 10
     * 5
     * 二叉树每个节点的权值都是不超过
     * 10
     * 9
     *  的正整数
     */


    public static void main(String[] args) {
        Integer[] values = new Integer[]{120, 104, 130, 180, 160, 192, 176, 170, 200, null, 120, null, null, null, null, 200, 120, null, null, 170, null, null, null, null, null, null, 128};
        //预期结果 12,10,1,7,3,0,0,4,2,#,2,#,#,#,#,2,1,#,#,1,#,#,#,#,#,#,0

//        TreeNode treeNode = buildTreeNode(values);
        TreeNode treeNode = buildTree(values);
        System.out.println(treeNode);

        System.out.println(maxDepth(treeNode));
        System.out.println(maxDepth(treeNode.left));


        System.out.println(maxDepth2(treeNode));
        System.out.println(maxDepth2(treeNode.left));

        System.out.println(maxDepth3(treeNode));
        System.out.println(maxDepth3(treeNode.left));

        valueOfTree(treeNode);

//        List<TreeNode> traversal = traversal(treeNode);
//        List<TreeNode> traversal2 = traversal2(treeNode);
//        Integer[] nodeSize =  new Integer[values.length];
//        int index = 0;
//        for (int i = 0; i < values.length; i++) {
//            Integer value = values[i];
//            if(value!=null){
//                nodeSize[i] = maxDepth(traversal2.get(index));
//                index++;
//            }else {
//                nodeSize[i] = 0;
//            }
//        }
//        System.out.println(JSON.toJSONString(nodeSize));
    }





    private static TreeNode buildTreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;

    }


    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return max(maxDepth(root.left), maxDepth(root.right))+1;
    }


    public static int max(int a ,int b){
        if(a > b){
            return a;
        }
        return b;
    }


    private static List<TreeNode> traversal(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            res.add(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    private static List<TreeNode> traversal2(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                TreeNode node = queue.poll();
                res.add(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }


    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }



    public static TreeNode valueOfTree (TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                TreeNode node = queue.poll();
                node.val = maxDepth3(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    private static int maxDepth3(TreeNode root) {
        if(root.left==null && root.right==null){
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int depth = 0;
        while (!stack.empty()) {
            int size = stack.size();
            while (size-- > 0) {
                TreeNode node = stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            depth++;
        }
        return depth;
    }


    public static TreeNode buildTree(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        int i = 1;
        while (i < nums.length) {
            TreeNode node = queue.poll();
            if (i < nums.length && nums[i] != null) {
                node.left = new TreeNode(nums[i]);
                queue.offer(node.left);
            }
            i++;
            if (i < nums.length && nums[i] != null) {
                node.right = new TreeNode(nums[i]);
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }




}



