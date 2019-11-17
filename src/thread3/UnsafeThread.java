package thread3;

import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhaoMin
 * @date 2019/11/13 19:58
 */
//String s1="abc";1个对象，在常量池
    //String s2=new String("a");//2个对象，堆 上
    //String s3=new String("abc");//一个对象，另一个引用常量池
    //能共享的存在堆、常量池、方法区。常量池包含在方法区中
public class UnsafeThread {
    public static int COUNT;

    public static void main(String[] args) {
        //开启20个线程，每个线程对COUNT进行++操作10000次
        //预期结果：200000
        Object object=new Object();
        for(int i=0;i<20;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<10000;j++){
//                        COUNT++;
                        //第一种:静态类对象锁定
                      //  increment();
                        //第二种：对实例对象锁定
                        synchronized (object){
                            COUNT++;
                            COUNT--;
                        }
                    }
                }
            }).start();
        }
        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(COUNT);
    }
    //同步互斥：
    //静态同步方法
    public synchronized static void increment(){
        COUNT++;
    }
    public synchronized static void decrement(){
        COUNT--;
    }

    //将静态同步方法修改为同步代码块
   /* public static void increment(){
        synchronized (UnsafeThread.class){
            COUNT++;
        }
    }*/
   //同步实例方法
   public synchronized void increment2(){

   }
   //等同于上边的方法，只是锁的对象不同
 /*  public void increment2(){
       synchronized (this){

       }
   }*/
}
