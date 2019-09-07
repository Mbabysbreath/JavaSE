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
                    list.add(((char)( key+'a') + ""));
                }
            }
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
        String[] A={"bewwaa","waabew","arowwer"};
        List<String> list= ob. commonChars(A);
        System.out.println(list);

    }
}
