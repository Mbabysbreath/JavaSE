package HEAPS;

import java.util.Arrays;

/**
 * @author ZhaoMin
 * @date 2019/8/27 10:07
 */
public class Heaps {
    /**
     * 交换数组中两个数的值
     * @param array 数组
     * @param index  第一个数
     * @param max  第二个数
     */
    private static void swap(int[] array,int index,int max){
        int temp;
        temp=array[index];
        array[index]=array[max];
        array[max]=temp;
    }

    /**
     * 大顶堆向下调整，时间复杂度O(log(n))
     * 调整堆的前提是堆中存的是一颗完全二叉树
     * 所以，如果没有左孩子，一定没有右孩子
     * 先比较取出调整位置的左右孩子中较大的一个，
     * 再将孩子与调整位置（双亲）比较，看是否需要交换
     * @param array 被看作是堆的数组
     * @param size  数组中被看作是堆的值的个数
     * @param index  调整的位置的下标
     */
    public static void heapify(int[] array,int size,int index){
        while(true) {
            int left = 2 * index + 1; //调整位置的左孩子
            if (left >= size) { //如果没有左孩子就不用调整直接返回
                return;
            }
            int max = left;//假设开始左孩子是较大的
            if (left + 1 < size && array[left + 1] > array[left]) {
                //如果右孩子存在，且大于左孩子
                max = left + 1;//则最大值Max为右孩子
            }
            if (array[index] >= array[max]) {//调整位置的值大于Max,不用调整，直接返回
                return;
            }
            swap(array, index, max);//如果调整位置的值小于Max,则交换
            index = max;//接着进行向下调整
        }
    }

    /**
     * 任意数组建大顶堆,时间复杂度：O(n)
     * @param array  数组
     * @param size   长度
     * 数组都可以被建成一颗完全二叉树，所以最后一个非叶子节点的
     * 左右孩子都是可以确定的
     */
    public static void createHeap(int[] array,int size){
        int parent=(size-2)/2;//先取最后一个非叶子结点
        for(int i=parent;i>=0;i--){
            heapify(array,size,i);
        }
    }
    /**
     *堆的向上调整，时间复杂度：O(log(n))
     * @param array
     * @param index
     */
    public static void adjustUp(int[] array,int index){
        while(true){
        int parent=(index-1)/2;
            if(array[index]<=array[parent])
                return ;
            swap(array,index,parent);
            index=parent;
        }
    }

    /**
     * 任意数组创建小顶堆
     * @param array
     * @param size
     */
    public static void creatMin(int[] array,int size){
        int parent=(size-2)/2;
        for(int i=parent;i>=0;i--){
            heapifyMin(array,size,i);
        }
    }
    public static void heapifyMin(int[] array,int size,int index){
        while (true) {
            int left = index * 2 + 1;
            if (left + 1 >= size) {
                return;
            }
            int min = left;
            if (left + 1 < size && array[left + 1] < array[left]) {
                min = left+1;
            }
            if (array[min] >= array[index]) {return;}
                swap(array, index, min);
            index = min;
        }
    }
    public static void main(String[] args) {
        int[] array1={1,8,2,9,2,4,1,5,2,2,4};
      //  heapify(array1, array1.length,0);
        System.out.println(Arrays.toString(array1));
        createHeap(array1,array1.length);
        System.out.println(Arrays.toString(array1));
       // int[] array2={-1,15,19,18,28,34,65,49,25,37};
       // heapifyMin(array2,array2.length,0);
       // System.out.println(Arrays.toString(array2));
    }
}
