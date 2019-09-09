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
public class BinarySearch {
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
                cur=cur.left;
            }else{
                cur=cur.right;
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
        Node cur=root;


    }

    public  Collection<Integer> values(){
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
}
