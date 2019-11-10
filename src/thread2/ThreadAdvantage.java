package thread2;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author ZhaoMin
 * @date 2019/11/10 9:28
 */
public class ThreadAdvantage {
    /**
     * 集合：
     * Collection /---list
     *                ArrayList:数组
     *                LinkedList:队列
     *            /---Set:HashSet：HashMap,TreeS
     * Map:HashMap:数组和链表，jdk8之后加了红黑树,TreeMap
     *
     */
    public static List<String> randomList(){
        List<String> list = new LinkedList<>();
        char[] chars={'a','b','c','d','A','B','C','Z'};
        for(int i=0;i<100000;i++) {
            int random=new Random().nextInt(chars.length);
            char c = chars[random];
            list.add(String.valueOf(c));
        }
        return list;
    }
    public static void main(String[] args) throws InterruptedException {
        List<String> list=randomList();
        //创建10个线程，每个线程获取list中的10000个元素
        //时间java.util.Date
        //jdk 1.8->LocalDateTime
        long start=System.currentTimeMillis();
      //  long start=new Date().getTime()
        Thread[] threads=new Thread[10];
        for(int i=0;i<10;i++){
            final int k=i;
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("id="+Thread.currentThread().getId()
                            +",name="+Thread.currentThread().getName());
                    for(int j=0;j<10000;j++){
                        list.get(k*10000+j);
                    }
                }
            },"线程"+k);
            threads[i].start();
            threads[i].join();
        }
        //1.线程让步yield
       /* while(Thread.activeCount()>2){
            Thread.yield();//main线程让步等待
        }*/
       //2.【常用】调用线程加入/等待：join
     /*   for(Thread thread:threads){
            thread.join();
        }*/
        long end=System.currentTimeMillis();
        System.out.println("耗时："+(end-start)+"毫秒");
    }
}
