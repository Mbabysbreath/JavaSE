package Sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ZhaoMin
 * @date 2019/8/28 9:49
 */
public class Sorts1 {
    /**
     * 插入排序
     *
     * @param array 要进行排序的数组
     *              假设数组中第一个数已经是有序的，（从第一个开始进行排序
     *              从第二个数开始，将大于等于arr[0]的放在arr[0]之后，小于arr[0]的放在前边
     *              则：有序区间[0,i],无序区间[i+1,arr.length)
     *              在排序时，做两件事；
     *              1.从无序区间的第1个数开始(将该数记录下来),循环遍历依次检查前边有序区间中有无大于等于它的数，
     *              有的话，用j将该数的下标记录下来，跳出循环，表示可以向有序区间内插入一个数了
     *              2.为了向有序区间中插入一个数，我们需要将插入的位置空出来，所以要将插入位置之后的数从后往前依次退后一个。
     *              从当前有序区间最后一个数开始进行后移
     *              当位置空好后，将key值插到此处
     */
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {//循环次数，第1个数已经有序，只要循环size-1次就好
            //确定有序区间[0,i]
            //无序区间[i+1,arr,length-1]
            int key = array[i + 1];
            int j;
            for (j = i; j >= 0; j--) {//向前遍历查找，如果找到比现在大或相等的值，就停下
                if (key >= array[j]) {
                    break;
                }
            }
            for (int k = i; k > j; k--) {//上边找到了，就开始进行后移
                array[k + 1] = array[k];
            }
            array[j + 1] = key;//最后将key值插入，上边没找到就不用插入，还是原来的值
        }
    }

    public static void insertSort2(int[] array) {//插入排序代码简化
        for (int i = 0; i < array.length - 1; i++) {
            int key = array[i + 1];
            int j;
            for (j = i; j >= 0 && key < array[j]; j--) {//一边找一边交换
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }

    /**
     * 希尔排序
     * 将数据按一定长度进行分组，然后在每一组组内先进行插入排序
     * 在重新分组，增大每一组的元素个数，减少组数，再进行组内排序
     * 最终会只剩一个组，再进行排序
     * 每次组内插入排序，并不是把组内所有元素排一遍，而是只执行一次，跳出后，就会进入下一个组的排序
     * 分组的规律：gap=gap/3+1;
     *
     * @param array
     */
    public static void shellSort(int[] array) {
        int gap = array.length;//分组的个数
        while (true) {
            gap = gap / 3 + 1;
            insertSortWithGap(array, gap);//分组的插入排序
            if (gap == 1) {
                return;
            }
        }
    }

    private static void insertSortWithGap(int[] array, int gap) {
        for (int i = 0; i < array.length - gap; i++) {//假设前gap组已经有序，所以只循环arr.length-gap次
            int key = array[i + gap];//组内排序
            int j;
            for (j = i; j >= 0 && key < array[j]; j -= gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }

    /**
     * 选择排序：直接选择排序
     * 将待排数组分为有序区间和无序区间
     * 无序区间：[0,arr.length-1]
     * 无序区间在前边，从无序区间里边选出一个最大的数，将它放在无序的最后一个，有序数组的前一个
     *
     * @param array 待排序的数组
     */
    public static void selectSort(int[] array) {//
        //无序区间在前边
        //每次选最大数
        for (int i = 0; i < array.length - 1; i++) {
            int max = 0;
            int j;
            for (j = 1; j < array.length - i; j++) {
                if (array[max] < array[j]) {
                    max = j;
                }
            }
            swap(array, max, j - 1);
        }
    }

    /**
     * 从一堆元素中选择最大的放在无序区间后边，同时选择最小的放无序区间前边
     *
     * @param array
     */
    public static void selectSort2(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {//无序区间长度【[low,high]
            //让最大值max和最小值min都从无序区间的第一个位置开始选
            int max = low;
            int min = low;
            //遍历无序区间进行比较
            for (int i = low; i <= high; i++) {
                if (array[i] > array[max]) {
                    max = i;
                }
                if (array[i] < array[min]) {
                    min = i;
                }
            }
            swap(array, min, low);
            if (max == low) {
                max = min;
            }
            swap(array, max, high);
            high--;
            low++;
        }
    }

    private static void swap(int array[], int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 堆排序：把无序区间建成大顶堆，每次取出堆顶，放到有序区间的前一个位置
     *
     * @param array
     */
    public static void heapSort(int[] array) {
        //堆排序
        creatHeap(array, array.length);
        for (int i = 0; i < array.length - 1; i++) {
            swap(array, 0, array.length - i - 1);
            heapfify(array, array.length - i - 1, 0);
        }
    }

    private static void creatHeap(int[] array, int size) {
        int parent = (size - 2) / 2;
        for (int i = parent; i >= 0; i--) {
            heapfify(array, size, i);
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

    private static int[] buildSortedArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * 冒泡排序:从数组的第一个元素开始两两比较，将最大的放后边
     *
     * @param
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean sorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted)
                break;
        }
    }

    /**
     * 快速排序（递归）
     * 找基准值（每次会变）
     * 比基准值大的放左边，比基准值小的放右边
     * 在分别对基准值右边的区间进行快排
     */
    public static void quickSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
      //  quickSortInternal(array, left, right);
        quickSortInternal2(array, left, right);
    }

    /**
     * 递归
     */
    public static void quickSortInternal(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partion1(array, left, right);//找基准值的函数
        //  int[] indice=partion4(array,left,right);
        //  quickSortInternal(array,left,indice[0]-1);
        // quickSortInternal(array,indice[1]+1,right);
        quickSortInternal(array, left, pivotIndex - 1);
        quickSortInternal(array, pivotIndex + 1, right);

    }

    /**
     * 非递归（让小区间的右左端点依次入栈，每次处理当前栈顶的元两个素
     */
    public static void quickSortInternal2(int[] array,int left,int right){
        Stack<Integer> stack=new Stack<>();
        stack.push(array.length-1);
        stack.push(0);
        while (!stack.isEmpty()) {
            left=stack.pop();
            right=stack.pop();
            if(left>=right){
                continue;
            }
            int pivotIndex=partion1(array,left,right);
            stack.push(pivotIndex-1);
            stack.push(left);
            stack.push(right);
            stack.push(pivotIndex+1);
        }
    }

    //挖坑法获取基准值的位置,对当前区间进行排序，使小于基准值的在基准值左侧，大于的在右侧，
    //并最终返回基准值的最终位置
    private static int partion1(int[] array, int left, int right) {
        int pivot = array[right];//基准值
        int less = left;
        int great = right;
        while (less < great) {
            while (less < great && array[less] <= pivot) {
                less++;
            }
            array[great] = array[less];
            while (less < great && array[great] >= pivot) {
                great--;
            }
            array[less] = array[great];
        }
        array[less] = pivot;
        return less;
    }

    /**
     * 找基准位置：从两边同时找
     * 左边找到比基准值大的，先停下来，
     * 再从右边开始往前找，找到比基准值小的，停下来
     * 交换两个值。如果满足循环条件左小于右，则重复以上动作
     * 最终返回新的基准值
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partion2(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;
        int great = right;
        while (less < great) {
            while (less < great && array[less] <= pivot) {
                less++;
            }
            while (less < great && array[great] >= pivot) {
                great--;
            }
            swap(array, less, great);
        }
        swap(array, less, right);
        return less;
    }

    private static int partion3(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;//蓝色箭头
        //[left,less)<privot, [less,i)>=privot;[i,right)未知
        int i = left;//红色箭头
        for (i = left; i < right; i++) {
            if (array[i] < pivot) {
                swap(array, i, less);
                less++;
            }
        }
        swap(array, right, less);
        return less;
    }

    /**
     * //把和基准相同的单独处理，适用于数组中相同元素较多时使用
     *
     * @param array
     * @param left
     * @param right
     * @return返回一个相同基准元素所在的集合范围
     */
    private static int[] partion4(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;
        int flag = left;
        int great = right;
        while (less < great) {
            if (array[less] == pivot) {
                less++;
            } else if (array[less] < pivot) {
                swap(array, less, flag);
                flag++;
                less++;
            } else {
                while (less < great && array[great] > pivot) {
                    great--;
                }
                swap(array, less, great);
            }
        }
        return new int[]{less, great - 1};
    }
    public static void mergeSorts(int[] array){
     //   mergeSortInternal(array,0,array.length);
        mergeSortsInternalNoR(array);
    }
    /**
     * 归并排序：递归内部排序
     */
    public static void mergeSortInternal(int[] array,int low,int high){
        if(low+1>=high){//[low,high)
            return ;
        }
        int mid=(low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid,high);
        merge(array,low,mid,high);
    }
    /**
     * 归并排序:非递归内部排序
     */
    public static  void mergeSortsInternalNoR(int[] array){
        for(int i=1;i<array.length;i=i*2){//i代表每一次排序中，一小段中的元素个数
            for(int j=0;j<array.length;j=j+2*i){
                int low=j;
                int mid=j+i;
                int high=mid+i;
                if(mid>=array.length){
                    continue;
                }
                if(high>array.length){
                    high=array.length;
                }
                merge(array,low,mid,high);
            }
        }
    }
    private static void merge(int[] array, int low, int mid, int high) {
        int length = high - low;
        int[] extral = new int[length];
        //[low,mid]
        //[mid,high]
        int less = low;
        int great = mid;
        int i = 0;
        while (less < mid && great < high) {
            if (array[less] <= array[great]) {
                extral[i] = array[less];
                less++;
                i++;
            } else {
                extral[i] = array[great];
                great++;
                i++;
            }
        }
        while (less < mid) {
            extral[i++] = array[less++];
        }
        while (great < high) {
            extral[i++] = array[great++];
        }
        for (int j = 0; j < length; j++) {
            array[low + j] = extral[j];
        }
    }

    public static void main(String[] args) {
     /*   int[] array=new int[]{1,8,2,9,2,4,1,5,2,2,4};
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
        System.out.println("堆排序:"+(end3-begin3));*/
        int[] array1 = {1, 8, 2, 9, 2, 4, 1, 5, 2, 2, 4};
        int[] array2 = new int[]{7, 6, 5, 4, 3, 2, 1};
        int[] array3 = new int[]{1, 8, 2, 9, 2, 4, 1, 5, 2, 2, 4};
        //   bubbleSort(array1);
        quickSort(array2);
        System.out.println(Arrays.toString(array2));
        selectSort2(array1);
        System.out.println(Arrays.toString(array1));
        mergeSorts(array3);
        System.out.println(Arrays.toString(array3));
    }
}
