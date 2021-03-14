package Sword2Offer07;
//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//例如，给出前序遍历 preorder=[3,9,20,15,7]中序遍历 inorder=[9,3,15,20,7]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyTest {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = buildTreeByHashMap(preorder, inorder);
        System.out.println(treeNode);
    }
    //buildTee方法是基于数组直接查找的方式做的，虽然节省了空间，但是时间复杂度太高。下面还有基于hashmap的方法
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0){
            return null;
        }
        //1.构建一个根节点，其中，节点的值就是前序遍历的第一个值
        TreeNode root = new TreeNode(preorder[0]);
        //2.递归的去构建root的左子树
        //2.1 root.left = buildTree(左子树的前序遍历，左子树的中序遍历);

        //3.递归的去构建root的右子树
        //2.1 root.right = buildTree(右子树的前序遍历，右子树的中序遍历);
        //4.确定各个子树是什么
        //4.1 左子树的前序遍历：
        int[] preleft = Arrays.copyOfRange(preorder, 1, findIndex(inorder, root.val)+1);
        //4.1 左子树的中序遍历：
        int[] inleft = Arrays.copyOfRange(inorder,0,findIndex(inorder,root.val));
        //4.1 右子树的前序遍历：
        int[] preright = Arrays.copyOfRange(preorder,findIndex(inorder,root.val)+1,preorder.length);
        //4.1 右子树的中序遍历：
        int[] inright = Arrays.copyOfRange(inorder,findIndex(inorder,root.val)+1,preorder.length);
        root.left = buildTree(preleft,inleft);
        root.right = buildTree(preright,inright);
        return root;
    }
    public static int findIndex(int[] arr,int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }




    public static TreeNode buildTreeByHashMap(int[] preorder,int[] inorder){
        if(preorder==null||preorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int rootValue = root.val;
        Map<Integer,Integer> map = buildHashMapByArr(inorder);
        int[] preLeft = Arrays.copyOfRange(preorder,1,map.get(rootValue)+1);
        int[] inLeft = Arrays.copyOfRange(inorder,0,map.get(rootValue));
        int[] preRight = Arrays.copyOfRange(preorder,map.get(rootValue)+1,inorder.length);
        int[] inRight = Arrays.copyOfRange(inorder,map.get(rootValue)+1,inorder.length);
        root.left = buildTreeByHashMap(preLeft,inLeft);
        root.right = buildTreeByHashMap(preRight,inRight);
        return root;
    }

    public static Map<Integer,Integer> buildHashMapByArr(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        return map;
    }

}


class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x){
        val = x;
    }
}
