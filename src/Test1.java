import java.util.Arrays;
import java.util.List;
import  java.util.*;
/**
 * @author ZhaoMin
 * @date 2019/9/7 15:39
 */

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> list=new ArrayList<>();

        Map<Integer,Integer> map=new HashMap<>();
        for(char ch:A[0].toCharArray()){
            int count=map.getOrDefault(ch-'a',0);
            map.put(ch-'a',count+1);
        }
        for(int i=1;i<A.length;i++){
            Map<Integer,Integer> map1=new HashMap<>();
            for(char ch:A[i].toCharArray()){
                int count=map1.getOrDefault(ch-'a',0);
                map1.put(ch-'a',count+1);
            }
            for(char ch:A[0].toCharArray()) {
                if (map1.containsKey(ch-'a')) {
                    map.put(ch-'a', Math.min(map.get(ch-'a'), map1.get(ch-'a')));
                }else{
                    map.put(ch-'a',0);
                }
            }
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()) {
            int key = e.getKey();
            int value = e.getValue();
            if (value > 0) {
                for (int i = 0; i < value; i++) {
                    list.add(((char)( key+'a')+""));
                }
            }
        }
        return list;
    }
    /*
    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
    使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
       // List<Integer> list1=new ArrayList<>();
        int i=0;
        while(i<nums.length-2){
           int j=i+1;
           int k=nums.length-1;
           while (j<k) {
               while (j < k && nums[i] + nums[j] + nums[k] < 0) {
                   j++;
               }
               if (j >= k) {
                   break;
               }
               if(nums[i] + nums[j] + nums[k]==0){
                   List<Integer> list1 = new ArrayList<>();
                   list1.add(nums[i]);
                   list1.add(nums[j]);
                   list1.add(nums[k]);
                   list.add(list1);
                   while (j < k && nums[j] == nums[j + 1]) {
                       j++;
                   }
                   j++;
               }
               while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                   k--;
               }
               if (j >= k) {
                   break;
               }
               if(nums[i] + nums[j] + nums[k]==0){
                   List<Integer> list1=new ArrayList<>();
                   list1.add(nums[i]);
                   list1.add(nums[j]);
                   list1.add(nums[k]);
                   list.add(list1);
                   while (j < k && nums[k] == nums[k - 1]) {
                       k--;
                   }
                   k--;
               }
           }
            while(i<nums.length-2&&nums[i]==nums[i+1]){
               i++;
            }
            i++;
        }
        return list;
    }
}

public class Test1 {
    public static void main(String[] args) {
       /* char[] ch=new char[]{'r','o','l','l','e','r'};
        int[] res=new int[26];
        for(char c:ch){
            res[c-'a']++;
        }
        System.out.println(Arrays.toString(res));*/
        Solution ob=new Solution();
       // String[] A={"bewwaa","waabew","arowwer"};
     //   List<String> list= ob. commonChars(A);
     //   System.out.println(list);
        int[] nums=new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> list1=ob.threeSum(nums);
        System.out.println(list1);
    }
}
