/**
 * 哈希桶
 * @author ZhaoMin
 * @date 2019/9/11 19:57
 */
import java.util.*;
public class HashBucket {
    private class Node{
        private int key;
        private int value;
        private Node next;
    }
    private Node[] array;
    private int size;
    public HashBucket(){
        array=new Node[8];
        size=0;
    }

    /**
     * 计算链表的第一个结点在数组中的位置
     * @param key 要找的key
     * @param capacity 数组长度
     * @return 数组下标
     */
    private static int hashFun(int key,int capacity){
        return key%capacity;
    }
    /**
     * 在哈希桶中找指定的key,找到了返回相应的value,否则返回-1
     * @param key 指定的key
     * @return value或-1
     */
    public int get(int key){
        int index=hashFun(key,array.length);//找到链表的第一个位置
        Node head=array[index];
        Node cur=head;
        while(cur!=null){
            if(cur.key==key){
                return  cur.value;
            }else{
                cur=cur.next;
            }
        }
        return -1;
    }

    /**
     * 删除指定key的结点
     * @param key 要删的key
     * @return 找到了，删除并返回该值，否则，返回-1
     */
    public int remove(int key){
        int index=hashFun(key,array.length);
       Node head=array[index];
       Node prev=null;
        Node cur = head;
       while(cur!=null){
          if(cur.key==key){
              int oldValue=cur.value;
              if(cur==head){
                  array[index]=head.next;
              }else{
                  prev.next=cur.next;
              }
              size--;
              return oldValue;
          }
          prev=cur;
          cur=cur.next;
       }
       return -1;
    }
}
