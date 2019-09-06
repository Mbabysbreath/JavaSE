/**
 * @author ZhaoMin
 * @date 2019/9/4 19:19
 */
import java.util.*;
public class MapSet {
   // public static Map<Integer,Integer> count(int[] nums){
        public static int count(int[] nums){//返回一个数组中，只出现一次的数
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums) {
            //n没有出现过，c=0
            //n出现过，c+1
            int c=map.getOrDefault(n,0);
            map.put(n,c+1);
        }
       for(Map.Entry<Integer,Integer> e:map.entrySet() ){
            int key=e.getKey();
            int  value=e.getValue();
            if(value==1){
                return key;
            }
       }
        return -1;
    }
    public int numJewelsInstones(String J,String S) {//宝石
        Set<Character> set = new HashSet<>();
       //char[] a=J.toCharArray();
        for(char ch:J.toCharArray()){
            set.add(ch);
        }
        int count=0;
        for(char ch:S.toCharArray()){
            if(set.contains(ch)){
                count++;
            }
        }
        return count;
    }
        public int count(String[] words){
            Map<String,Integer> map=new HashMap<>();
            //记录每个单词出现的次数
            for(String word:words){
                int c=map.getOrDefault(word,0);
                map.put(word,c+1);
            }
            //每个次数对应的单词
            for(Map.Entry<String,Integer> e: map.entrySet()){
                String key=e.getKey();
                int value=e.getValue();
            }
return 0;
        }
    public static void main(String[] args) {
       // Map<Integer,Integer>  map=new HashMap<>();
        int[] nums={1,8,2,9,2,4,1,5,2,2,4};
        System.out.println(count(nums));

    }
}
