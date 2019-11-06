package thread;

/**
 * @author ZhaoMin
 * @date 2019/11/6 19:34
 */
public class CreatThread  {
    public static void main(String[] args) {
        //继承Thread类
        MyThread t=new MyThread();
        t.start();
        //实现Runnable接口
        MyRunner runner=new MyRunner();
        Thread t1=new Thread(runner);
        t1.start();
        //javaMain(C语言写的系统的main)是java层面的主线程，
        // 和main(自己写的)方法中自行创建的线程是同级的
        while(true){

        }
    }

}

/**
 * 创建线程类的两种方法
 * 1.继承自Thread类
 * 2.实现Runnable接口
 */
//1.继承自Thread类
class MyThread extends  Thread{
    @Override
    public void run() {
        System.out.println("in Thread");
        while(true){

        }
    }
}
//2.实现Runnable接口
class MyRunner implements Runnable{

    @Override
    public void run() {
        System.out.println("in Runnable");
        while(true){

        }
    }

}
