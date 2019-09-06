package Leetcode;

import java.util.*;

/**
 * @author ZhaoMin
 * @date 2019/9/6 23:48
 */
public class Nums {
    public static List<String> Num(String[] s){
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<s.length;i++) {
            String[] u = s[i].split(" ");
            int n=Integer.valueOf(u[0]);

            String[] t=u[1].split("\\.");
            for(int j=0;j<t.length;j++){
                String[] newDom= Arrays.copyOfRange(t,j,t.length);
                String doms=String.join(".",newDom);
                int count=map.getOrDefault(doms,0);
                map.put(doms,count+n);
            }
        }
        List<String> result=new ArrayList<>();
        for(Map.Entry<String,Integer> e:map.entrySet()){
            String key=e.getKey();
            int value=e.getValue();
            result.add(value+" "+key);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] s = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
        List<String> r = new Nums().Num(s);
        System.out.println(r);
    }

}
