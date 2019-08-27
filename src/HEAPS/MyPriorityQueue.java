package HEAPS;

/**
 * @author ZhaoMin
 * @date 2019/8/27 11:08
 * 自己实现一个优先队列
 */
public class MyPriorityQueue {
    private int[] array=new int[100];
    private int size=0;
    //时间复杂度O(log(n))
    public void add(int element){
        array[size++]=element;
        Heaps.adjustUp(array,size-1);
    }
    //时间复杂度O(log(n))
    public int poll(){//时间复杂度log(n)
        int e=array[0];
        array[0]=array[--size];
        Heaps.heapify(array,size,0);
        return e;
    }
    //时间复杂度O（1）
    public int peek(){
        return array[0];
    }
}
