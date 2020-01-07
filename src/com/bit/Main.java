package com.bit;

/**
 * 打jar包
 * @author ZhaoMin
 * @date 2020/1/7 9:16
 */
public class Main {
    public static void sayHello(String target){
        System.out.println("Hello"+target);
    }
    public static void main(String[] args) {
        /*主方法里不能定义方法*/
        System.out.println("你好，世界");
    }
}
