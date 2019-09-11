/**
 * 哈希桶
 * @author ZhaoMin
 * @date 2019/9/11 19:57
 */
public class HashBucket {
    public int remove(int key){
        int index=hashFun(key,array.length);
       Node cur=array[index];
       Node prev=null;
        Node head = cur;
       while(cur!=null){
           if(head.key==key){
               head=array[index].next;
           }
          if(cur.key==key){
              int oldValue=cur.value;
              return oldValue;
           }else{
              prev=cur;
              cur=cur.next;
          }
       }
       return -1;
    }
}
