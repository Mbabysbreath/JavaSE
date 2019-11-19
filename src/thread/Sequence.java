package thread;

/**
 * @author ZhaoMin
 * @date 2019/11/6 20:11
 */
public class Sequence {
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            final int j=i;
            Runnable r=new Runnable() {

                @Override
                public void run() {
                   // System.out.println(j);
                    try {
                        Thread.sleep(1000*j);
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(j);
                }
            };
            Thread t=new Thread(r);
            t.start();
           // t.run();
        }
    }
}
