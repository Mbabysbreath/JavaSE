package thread3;

/**
 * @author ZhaoMin
 * @date 2019/11/13 19:36
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
               // while(!Thread.currentThread().isInterrupted()){
                    while(!Thread.interrupted()){
                    System.out.println("运行中");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();
      //  Thread.sleep(3000);
        //对wait().join(),sleep()进行阻断并抛出异常
        thread.interrupt();//如果自己创建地线程还没有被创建好，怎么会调用interrupt()
    }
}

