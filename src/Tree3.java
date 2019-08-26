/**
 * @autor ZhaoMin
 * @date 2019/8/26 11:42
 * 非递归写前、中、后序遍历
 */
import sun.reflect.generics.tree.Tree;

import java.util.*;
public class Tree3 {
    //非递归前序:根左右
    public  static void preOrderNonT(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.add(cur);
                System.out.print(cur.val);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }
    //非递归中序：左 根 右
    public static void inOrderNonT(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack =new Stack<>();
        TreeNode cur=root;
        while(!stack.empty()||cur!=null) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val);
            cur = top.right;
        }
    }
    //非递归后序遍历：左 右 根
    public static void postOrderNonT(TreeNode root){
        if(root==null){
            return ;
        }
        Stack<TreeNode> stack =new Stack<>();
        TreeNode cur=root;
        TreeNode last=null;//记录被弹出的右孩子
        while(!stack.empty()||cur!=null){
            while(cur!=null){
                stack.add(cur);
                cur=cur.left;
            }
            TreeNode top=stack.peek();
            if(top.right==null||top.right==last){
                top=stack.pop();
                last=top;
                System.out.print(top.val);
            }else{
                cur=top.right;
            }
        }
    }
    public static void main(String[] args) {
        TreeNode n1=new TreeNode('A'); TreeNode n2=new TreeNode('B');
        TreeNode n3=new TreeNode('C'); TreeNode n4=new TreeNode('D');
        TreeNode n5=new TreeNode('E'); TreeNode n6=new TreeNode('F');
        n1.left=n2;n1.right=n3;
        n2.left=n4;n2.right=n5;
        n3.left=n6;
        System.out.println("非递归前序:");
        preOrderNonT(n1);
        System.out.println();
        System.out.println("非递归中序:");
        inOrderNonT(n1);
        System.out.println();
        System.out.println("非递归后序:");
       postOrderNonT(n1);
    }
}
