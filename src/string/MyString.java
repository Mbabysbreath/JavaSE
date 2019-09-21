package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author ZhaoMin
 * @date 2019/9/21 9:07
 */
public final class MyString implements Comparable<MyString> {
    private final char[] value;
    //构造方法
    public MyString(char value[]){
        this.value=Arrays.copyOf(value,value.length);
    }
    public MyString(char value[],int offset,int count){
        this.value=Arrays.copyOfRange(value,offset,offset+count);
    }
    //拷贝构造字符串
    public MyString(MyString s){
        this.value=s.value;
    }
    //自动入池
    private static List<MyString> pool=new ArrayList<>();
    public static MyString iteral(MyString s){
        for(MyString ms:pool){
            if(ms.equals(s)){
                return ms;
            }
        }
        MyString rs=new MyString(s);
        pool.add(s);
        return s;
    }
    //手动入池
        public  MyString intern(){
            for(MyString ms:pool){
                if(ms.equals(this)){
                    return ms;
                }
            }
            MyString rs=new MyString(this);
            pool.add(rs);
            return rs;
        }

    //常见方法
    public char charAt(int index){
        return value[index];
    }
    public char[] toCharArray(){
        return Arrays.copyOf(value,value.length);
    }
    public boolean equalsIgnoreCase(MyString s){
        MyString s1=s.toUpper();
        MyString v1=s.toUpper();
       return v1.equals(s1);

    }
    @Override
    public boolean equals(Object s) {
        /*
        1.判断引用是否指向同一个对象
        2.判断s是否为空
        3.判断是否属于MyString类
        4.判断属性值是否相等
         */
        if (this == s) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (!(s instanceof MyString)) {
            return false;
        }
        return Arrays.equals(value, ((MyString) s).value);
    }
    public MyString toUpper(){
        char[] newValue=Arrays.copyOf(value,value.length);
        MyString s=new MyString(newValue);
        for(int i=0;i< newValue.length;i++){
            if(s.value[i]>='a'&&s.value[i]<='z'){
                s.value[i]=(char)(s.value[i]-('a'-'A'));
            }
        }
        return s;
        }
        public MyString toLower() {
            MyString s = new MyString(value);
            for (int i = 0; i < value.length; i++) {
                if (s.value[i]>='A'&&s.value[i]<='Z'){
                    s.value[i]=(char)(s.value[i]+('a'-'A'));
                }
            }
            return s;
        }
    @Override
        public int hashCode(){
        int hash=0;
        for(char c:value){
            hash=(hash^c);
        }
        return hash;
            //return value.hashCode();
    }

        public MyString substring(int begin,int end){
            return new MyString(value,begin,end-begin);
        }
        @Override
            public int compareTo(MyString o) {
            if (o == null) {
                return 1;
            }
            int len = Math.min(value.length, o.value.length);
            if (len == 0) {
                len = value.length;
            }
            for (int i = 0; i < len; i++) {
                char a=o.value[i];
                if (a < value[i]) {
                    return 1;
                }
                if (a > value[i]) {
                    return -1;
                }
                if (a == value[i]) {
                    continue;
                }
            }
            if (value.length > o.value.length) {
                return 1;
            } else if (value.length < o.value.length) {
                return -1;
            } else {
                return 0;
            }
        }
    @Override
    public String toString(){
        return new String(value);
    }

    public static void main(String[] args) {
        char[] value1={'a','b','c'};
        char[] value2={'a','b','c','d'};
        MyString s=new MyString(value1);
        MyString r=new MyString(value1);
        MyString t=new MyString(value2);
        System.out.println(s.compareTo(r));
        System.out.println(s.compareTo(t));
        System.out.println(s.intern());
    }
}
