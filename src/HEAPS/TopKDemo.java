package HEAPS;

/**
 * @author ZhaoMin
 * @date 2019/8/27 11:42
 * 武林Top5
 */
import java.util.*;
public class TopKDemo {
    public static void main(String[] args) {
        Random random=new Random();
        int[] wulin=new int[100];
        for(int i=0;i<100;i++) {
            wulin[i]=random.nextInt(1000);//给100个人，随机分配小于1000的武力值
        }
        int[] topK=findTopk(wulin,5);//存放Top5的数组
        System.out.println(Arrays.toString(topK));//将Top5打印出来
        Arrays.sort(wulin);//用来验证Top5是否正确
        System.out.println(Arrays.toString(
                Arrays.copyOfRange(wulin, wulin.length - 10, wulin.length)));
    }
        public static int[] findTopk(int[] wulin,int k){
            int[] heapMin=new int[k];
            for(int i=0;i<k;i++){
                heapMin[i]=wulin[i];//先假设wulin数组中前5人是Top5
            }
            Heaps.creatMin(heapMin,k);//创建一个暂时的top5小顶堆
                for(int i=k;i<wulin.length;i++){
                        if(heapMin[0]<wulin[i]){
                            heapMin[0]=wulin[i];
                            Heaps.heapifyMin(heapMin,k,0);//每次有新人进入后，再刷新一次名次
                        }
                }
                return heapMin;
        }
}
