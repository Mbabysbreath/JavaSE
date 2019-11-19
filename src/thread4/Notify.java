package thread4;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * 生产者消费者模型
 * @author ZhaoMin
 * @date 2019/11/19 19:55
 */
public class Notify {
        private static volatile int COUNT;

        public synchronized  static void produce(){
            COUNT+=3;
        }

        public synchronized static void consume() {
            COUNT--;
        }
        //模拟生产者
        public static  void  main(String[] args){
            for(int i=0;i<3;i++){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                           for(int i=0;i<10;i++){
                                synchronized (Notify.class){
                                    while(COUNT+3>100){
                                        Notify.class.wait();
                                    }
                                    produce();
                                    System.out.println(Thread.currentThread().getName()+"生产，库存" +
                                            "总量位："+COUNT);
                                    Thread.sleep(500);
                                    Notify.class.notifyAll();

                                }
                            }
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            //模拟消费者
            for(int i=0;i<10;i++){
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        try {
                            while(true){
                                synchronized (Notify.class){
                                    while(COUNT==0){
                                        Notify.class.wait();
                                    }
                                    consume();
                                    System.out.println(Thread.currentThread().getName()+
                                    "消费。库存重量为"+COUNT);
                                    Thread.sleep(500);
                                    Notify.class.notifyAll();
                                }
                                Thread.sleep(500);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }
}
