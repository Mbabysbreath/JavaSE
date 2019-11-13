package thread2;

/**
 * @author ZhaoMin
 * @date 2019/11/10 11:34
 */
public class StopThread {
    /**
     * 是否被中断
     */
    private static volatile boolean myInterrupted;
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while(!myInterrupted){
                    System.out.println("hello");
                }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        myInterrupted=true;

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                    //boolean tmp=标志位
                    //标志位=false
                    //return tmp;
                    //作用：重置标志位为false,并且返回之前的标志位
                    boolean b = Thread.interrupted();
                    //isInterrupted()获取当前标志位
                  //  boolean b=Thread.currentThread().isInterrupted();
                    System.out.println(b);
                }
            }
        });//线程创建之后标志位=false
        thread2.start();
        //优势在于可以中断
        thread2.interrupt();//修改标志位=true;
    }
}
