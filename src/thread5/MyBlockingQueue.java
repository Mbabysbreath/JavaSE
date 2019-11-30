package thread5;

/**
 * 阻塞式队列
 * @author ZhaoMin
 * @date 2019/11/28 19:26
 */
public class MyBlockingQueue<E> {
    private Object[] elements=new Object[1];
    private int addIndex;//插入元素下标
    private int takeIndex;//取出元素下标
    private int size;//实际的元素个数
    public MyBlockingQueue(int capacity){

    }
    //入队
   /* public synchronized E offer(E element){
        while(size==elements.length) {

        }
        elements[takeIndex]=element;
        size++;
        takeIndex=(takeIndex+1)%elements.length;
    }*/
}
