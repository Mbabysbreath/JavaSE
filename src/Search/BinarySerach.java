package Search;
import java.util.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author ZhaoMin
 * @date 2019/9/6 21:23
 */
public class BinarySerach {
    private static class Node{
        int val;
        int key;
        Node left;
        Node right;
    }
    private Node root=null;

    /**
     * 用key值查找相应的value。找到了返回value,否则返回-1
     * * @param key key
     * @return value
     */
    public  int get(int key){
        Node cur=root;
        while(cur!=null){
            if(cur.key==key){
                return cur.val;
            }else if(cur.key<key){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
        return -1;
    }

    /**
     * 向二叉搜索树中插入key和对应的value
     * 已经存在key就覆盖它，返回原来的value
     * 如果不存在，插入后返回-1；
     * @param key
     * @param val
     * @return
     */
    public int put(int key,int val){
        if(root==null){
            root=new Node();
            root.key=key;
            root.val=val;
            return -1;
        }
        Node parent=null;
        Node cur=root;

        while(cur!=null){
            if(key==cur.key){
                int oldValue=cur.val;
                cur.val=val;
                return oldValue;
            }else if(key>cur.key){
                parent=cur;
                cur=cur.right;
            }else{
                parent=cur;
                cur=cur.left;
            }
        }
        Node newNode = new Node();
        newNode.key=key;
        newNode.val=val;
        if(key<parent.key){
            parent.left=newNode;
        }else{
            parent.right=newNode;
        }
        return -1;
    }

    /**
     * 如果找到了key,就返回对应的value
     * 没找到，就返回defaultValue
     * @param key key
     * @param defaultValue defaultValue
     * @return
     */
    public int getOrDefault(int key,int defaultValue){
        Node cur=root;
        while(cur!=null){
            if(cur.key==key){
                return cur.val;
            }else if(cur.key<key){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return defaultValue;
    }

    /**
     * 返回所有key的不重复集合
     * @return
     */
    public Set<Integer> keySet(){
        Set<Integer> result=new HashSet<>();
        Queue<Node> queue=new LinkedList<>();
        if(root==null){
            return  result;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            Node front=queue.poll();
            result.add(front.key);
            if(front.left!=null){
                queue.add(front.left);
            }
            if(front.right!=null){
                queue.add(front.right);
            }
        }
        return  result;
    }

    /**
     * 删除指定结点
     * @param key 指定的key结点
     * @return 找到该节点 返回相应的value，否则返回-1
     */
    public  int remove(int key){
        Node cur=root;
        Node parent=null;
        while(cur!=null){
           if(cur.key==key){
               int oldvalue=cur.val;
               deleteNode(parent,cur);
               return oldvalue;
           }else if(cur.key<key){
               parent=cur;
               cur=cur.right;
           }else{
               parent=cur;
               cur=cur.left;
           }
        }
        return -1;
    }
    private void deleteNode(Node parent,Node cur){
        if(cur.left==null){
            if(cur==root){
                root=cur.right;
            }else if(cur==parent.right){
                parent.right=cur.right;
            }else{
                parent.left=cur.right;
            }
        }else if(cur.right==null){
            if(cur==null){
                root=cur.left;
            } if(parent.left==cur){
                parent.left=cur.left;
            }else{
                parent.right=cur.left;
            }
        }
        else{//两边都不为空，就要有一个约定来确定谁取代被删的点
            //一般找：比它大的最小的，或比它小的最大的
            Node goat=cur.left;//比它小的，往左找
            Node goatParent=cur;
            while(goat.right!=null){
                //比它小的最大的。从左子树的右边找
                goatParent=goat;
                goat=goat.right;
            }
            cur.key=goat.key;
            cur.val=goat.val;
            if(goat==goatParent.left){
                    goatParent.left=goat.left;
            }else{
                goatParent.right=goat.left;
            }
        }
    }
    public static class Entry{
        private int key;
        private int value;
        public int getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }
    }
    public Set<Entry> entrySet(){
        Set<Entry> set=new HashSet<>();
       if(root==null){
           return set;
       }
        Queue<Node> queue=new LinkedList<>();
       queue.add(root);
       while(!queue.isEmpty()){
           Node front=queue.poll();
           Entry entry=new Entry();
           entry.key=front.key;
           entry.value=front.val;
           set.add(entry);
           if(front.left!=null){
               queue.add(front.left);
           }
           if(front.right!=null){
               queue.add(front.right);
           }
       }
            return set;
    }

    /**
     * 前序遍历
     * @param root 树的根
     */
    private static void preOrderPrint(Node root){
        if(root!=null) {
            System.out.print(root.key);
            preOrderPrint(root.left);
            preOrderPrint(root.right);
        }
}

    /**
     * 中序遍历二叉树
     * @param root 树的根节点
     */
    private  static  void inOrderPrint(Node root){
        if(root!=null){
            preOrderPrint(root.left);
            System.out.print(root.key);
            preOrderPrint(root.right);

        }
    }

    /*public  Collection<Integer> values(){
        Collection<Integer> result=new HashSet<>();
        Queue<Node> queue=new LinkedList<>();
        if(root==null){
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            Node front=queue.poll();
            result.add(front.val);
            if(front.left!=null){
                queue.add(front.left);
            }if(front.right!=null){
                queue.add(front.right);
            }
        }
        return result;
    }
    */
    public static void main(String[] args) {
        BinarySerach tree=new BinarySerach();
        int[] keys = { 6, 7, 4, 2, 1, 5, 9, 3, 8 };
        for(int key:keys){
            tree.put(key,key+100);
        }
        preOrderPrint(tree.root);
        System.out.println();
        System.out.println("=====================");
        inOrderPrint(tree.root);
        System.out.println();
        System.out.println("=====================");
        System.out.println(tree.get(3));
        System.out.println(tree.get(13));
        System.out.println(tree.getOrDefault(13, 113));
        System.out.println(tree.keySet());
    }
}
