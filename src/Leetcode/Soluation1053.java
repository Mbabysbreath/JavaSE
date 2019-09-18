package Leetcode;

/**给你一个正整数的数组 A（其中的元素不一定完全不同），请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列。

 如果无法这么操作，就请返回原数组。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/previous-permutation-with-one-swap
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author ZhaoMin
 * @date 2019/9/18 18:34
 */
public class Soulation1053 {
    //先从前往后找到非降序的最后一个和从后往前降序的第一个
    //然后交换两数
    public int[] prevPermOpt1(int[] A) {
        int i=0;
        while(i<A.length-2){
            if(A[i]<=A[i+1]){
                int j=A.length-1;
                while(A[j]>A[j-1]){
                    swap(A[i],A[j]);

                }
            }
        }
    }
}
