package Leetcode;

import java.util.Arrays;

/**给你一个正整数的数组 A（其中的元素不一定完全不同），请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列。

 如果无法这么操作，就请返回原数组。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/previous-permutation-with-one-swap
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author ZhaoMin
 * @date 2019/9/18 18:34
 */
public class Soluation1053 {
    //先从后往前找非降序的第一个数，再从后往前找比该数小的数中的最大值
    //最后交换两值
    //然后交换两数
    //2354 6 62233
    //2354 6 32263
    public static int[] prevPermOpt1(int[] A) {
        int i=A.length-1;
        while(i-1>=0) {
            if (A[i - 1] <= A[i]) {
                i--;
            } else {
                i--;
                break;
            }
        }
        int j=A.length-1;
        while(j>=i){
            if(A[j]>=A[i]){
                j--;
            }else {
                    if (A[j] == A[j - 1]) {
                        j--;
                    } else {
                        swap(A, i, j);
                        break;
                    }
            }
        }
        return A;
    }
    private static void swap(int[] A,int i,int j){
        int temp=0;
        temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }

    public static void main(String[] args) {
        int[] A={2,3,5,4,6,6,2,2,3,3};
        int[] B={1,1,1};
        int[] C={1,9,5,6,7};
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(prevPermOpt1(B)));
    }
}
