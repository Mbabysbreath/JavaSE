package exer;

/**
 * @author ZhaoMin
 * @date 2019/11/19 23:09
 */
class MyThread extends  Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for(int i=0;i<50;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

}
public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread t=new MyThread("线程1");
        MyThread t1=new MyThread("线程2");
        t.start();
       // t1.start();
        for(int i=0;i<50;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            if(i==20){
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(t.isAlive());
        }
    }
}
