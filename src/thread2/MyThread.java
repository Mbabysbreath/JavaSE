package thread2;

/**
 * @author ZhaoMin
 * @date 2019/11/10 9:10
 */
public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        /**=========主线程先于子线程执行======================*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("语句1");
            }
        }).start();
        //先执行语句2，因为语句1创建并启动线程耗时间
        //在语句1创建启动线程时，语句2已经处于运行状态了
            System.out.print("语句2");

/**=============让子线程先执行=======================*/
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("语句1");
            }
        });
        thread1.start();
        //不调用join时，创建线程会耗时较长
        thread1.join();//将新创建的子线程加入到主线程main中，直到子线程执行完毕
        System.out.println("语句2");

    }
}
