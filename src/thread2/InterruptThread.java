package thread2;

/**
 * @author ZhaoMin
 * @date 2019/11/10 11:50
 */
public class InterruptThread {
    public static void main(String[] args) {
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
