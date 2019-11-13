package thread2;

import java.util.IdentityHashMap;

/**
 * @author ZhaoMin
 * @date 2019/11/10 11:50
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    System.out.println(Thread.currentThread().isInterrupted());
                }
                try {
                    //调用sleep()/wait()/join()方式时，线程
                    //进入阻塞状态，此时也是可以中断，中断后
                    //抛出InterruptedException
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
       /* Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.interrupt();
*/
       //为什么没有被中断
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){}
            }
        });
        thread1.start();
        thread1.interrupt();
    }

}
