package Sort;

import java.util.Arrays;

/**
 * @author ZhaoMin
 * @date 2019/8/28 9:49
 */
public class Sorts1 {
    /**
     * 插入排序
     * @param array 要进行排序的数组
     * 假设数组中第一个数已经是有序的，（从第一个开始进行排序
     * 从第二个数开始，将大于等于arr[0]的放在arr[0]之后，小于arr[0]的放在前边
     * 则：有序区间[0,i],无序区间[i+1,arr.length)
     * 在排序时，做两件事；
     * 1.从无序区间的第1个数开始(将该数记录下来),循环遍历依次检查前边有序区间中有无大于等于它的数，
     * 有的话，用j将该数的下标记录下来，跳出循环，表示可以向有序区间内插入一个数了
     * 2.为了向有序区间中插入一个数，我们需要将插入的位置空出来，所以要将插入位置之后的数从后往前依次退后一个。
     * 从当前有序区间最后一个数开始进行后移
     * 当位置空好后，将key值插到此处
     */
    public static  void insertSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {//循环次数，第1个数已经有序，只要循环size-1次就好
            //确定有序区间[0,i]
            //无序区间[i+1,arr,length-1]
            int key=array[i+1];
            int j;
            for( j=i;j>=0;j--){//向前遍历查找，如果找到比现在大或相等的值，就停下
                if(key>=array[j]){
                    break;
                }
            }
            for(int k=i;k>j;k--){//上边找到了，就开始进行后移
                    array[k+1]=array[k];
            }
            array[j+1]=key;//最后将key值插入，上边没找到就不用插入，还是原来的值
        }
    }
    public static  void insertSort2(int[] array){//插入排序代码简化
        for (int i = 0; i < array.length-1; i++) {
            int key=array[i+1];
            int j;
            for(j=i;j>=0&&key<array[j];j--){//一边找一边交换
                array[j+1]=array[j];
            }
            array[j+1]=key;
        }
    }

    /**
     * 希尔排序
     * 将数据按一定长度进行分组，然后在每一组组内先进行插入排序
     * 在重新分组，增大每一组的元素个数，减少组数，再进行组内排序
     * 最终会只剩一个组，再进行排序
     * 每次组内插入排序，并不是把组内所有元素排一遍，而是只执行一次，跳出后，就会进入下一个组的排序
     * 分组的规律：gap=gap/3+1;
     * @param array
     */
    public static void shellSort(int[] array){
        int gap=array.length;//分组的个数
        while(true){
            gap=gap/3+1;
            insertSortWithGap(array,gap);//分组的插入排序
            if(gap==1){
                return ;
            }
        }
    }
    private static void insertSortWithGap(int[] array,int gap){
        for(int i=0;i<array.length-gap;i++){//假设前gap组已经有序，所以只循环arr.length-gap次
            int key=array[i+gap];//组内排序
            int j;
            for(j=i;j>=0&&key<array[j];j-=gap){
                array[j+gap]=array[j];
            }
            array[j+gap]=key;
        }
    }

    /**
     * 选择排序：直接选择排序
     * 将待排数组分为有序区间和无序区间
     * 无序区间：[0,arr.length-1]
     * 无序区间在前边，从无序区间里边选出一个最大的数，将它放在无序的最后一个，有序数组的前一个
     * @param array 待排序的数组
     */
    public static void selectSort(int[] array){//
        //无序区间在前边
        //每次选最大数
        for(int i=0;i<array.length-1;i++){
            int max=0;
            int j;
            for(j=1;j<array.length-i;j++){
                if(array[max]<array[j]){
                    max=j;
                }
            }
            swap(array,max,j-1);
        }
    }
    private static void swap(int array[],int i,int j){
        int temp;
        temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    /**
     * 堆排序：把无序区间建成大顶堆，每次取出堆顶，放到有序区间的前一个位置
     * @param array
     */
    public static void heapSort(int[] array){
        //堆排序
        creatHeap(array,array.length);
        for(int i=0;i<array.length-1;i++){
            swap(array,0,array.length-i-1);
            heapfify(array,array.length-i-1,0);
        }
    }

    private static void creatHeap(int[] array, int size) {
        int parent=(size-2)/2;
        for(int i=parent;i>=0;i--){
            heapfify(array,size,i);
        }
    }

    private static void heapfify(int[] array, int size, int index) {
        while (true) {
            int left = index * 2 + 1;
            if (left > size - 1) {
                return;
            }
            int max = left;
            if (left + 1 <= size - 1 && array[left + 1] > array[left]) {
                max = left + 1;
            }
            if (array[max] > array[index]) {
                swap(array, max, index);
            }
            index = max;
        }
    }
    private  static int[] buildSortedArray(int n){
        int[] array =new int[n];
        for(int i=0;i<n;i++) {
            array[i] = i;
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array=new int[]{1,8,2,9,2,4,1,5,2,2,4};
       // array = buildSortedArray(10);
        System.out.println(Arrays.toString(array));
        long begin = System.nanoTime();//单位是纳秒
        insertSort(array);//插入排序
        System.out.println(Arrays.toString(array));
        long end=System.nanoTime();
      //  array = buildSortedArray(10);
        System.out.println("插入排序:"+(end-begin));
        long begin1 = System.nanoTime();//单位是纳秒
        shellSort(array);//希尔排序
        long end1=System.nanoTime();
        System.out.println("希尔排序:"+(end1-begin1));
        long begin2 = System.nanoTime();//单位是纳秒
        selectSort(array);//选择排序
        long end2=System.nanoTime();
        System.out.println("选择排序:"+(end2-begin2));
        long begin3 = System.nanoTime();//单位是纳秒
        heapSort(array);
        long end3=System.nanoTime();
        System.out.println("希尔排序:"+(end3-begin3));
    }
}
