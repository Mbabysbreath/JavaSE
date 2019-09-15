/**
 * 哈希桶
 * @author ZhaoMin
 * @date 2019/9/11 19:57
 */
import java.util.*;
public class HashBucket {
    private static class Node{
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
     * 在哈希桶中插入一个结点（key,value),
     * 如果key存在，就用value取代原来的value，并返回原来的value
     * 否则，返回-1
     * @param key 要插入的key
     * @param value 要插入的value
     * @return oldvalue 或-1
     */
    public  int put(int key,int value){
        int index=hashFun(key,array.length);
        Node head=array[index];
        Node cur=head;
        while(cur!=null) {
            if (cur.key == key) {
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
            cur=cur.next;
        }
            Node newNode=new Node();
            newNode.key=key;
            newNode.value=value;
            newNode.next=head;
            array[index]=newNode;
            size++;
            if((double)size/array.length>0.75){
                resize();
            }
            return -1;
    }

    /**
     * 扩容
     */
    private void resize(){
        Node[] newArray=new Node[array.length*2];
        for(int i=0;i<array.length;i++){
            Node head=array[i];
            Node cur=head;
            while(cur!=null){
                int index=hashFun(cur.key,newArray.length);
                Node node=new Node();
                node.key=cur.key;
                node.value=cur.value;
                node.next=newArray[index];
                newArray[index]=node;
                cur=cur.next;
            }
        }
        array=newArray;
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

    /**
     * 返回所有的key
     * @return 返回所有的key
     */
    public Set<Integer> keySet(){
        Set<Integer> set=new HashSet<>();
      //  Node cur=array[]
        for(int i=0;i<array.length;i++){
            if(array[i]!=null){
                System.out.println(array[i].key);
                Node head=array[i];
                Node cur=head;
               while(cur!=null) {
                    set.add(cur.key);
                    cur = cur.next;
                }
              //  System.out.println(array[i].key);
            }else{
                continue;
            }
        }
       return set;
}
public Set<Integer> getValues(){
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<array.length;i++){
            if(array[i]!=null){
                Node head=array[i];
                Node cur=head;
                while(cur!=null){
                    set.add(cur.value);
                    cur=cur.next;
                }
            }
        }
        return set;
}
    public static void main(String[] args) {
        HashBucket hb=new HashBucket();
        Random random=new Random(20190913);
        for(int i=0;i<8;i++){
            int r=random.nextInt(100);
            System.out.print(r+" ");
            hb.put(r,r+100);
        }
        System.out.println("Succesful");
       Set<Integer> set=hb.keySet();
        System.out.println(set);
        Set<Integer> set1=hb.getValues();
        System.out.println(set1);
    }
}