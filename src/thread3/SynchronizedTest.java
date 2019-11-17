package thread3;

/**
 * @author ZhaoMin
 * @date 2019/11/17 21:05
 */
class MyObject{
    //实例方法锁定类的实例对象
    //只锁定对象
    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }
    }
    public  synchronized void method2(){
        System.out.println(Thread.currentThread().getName());
        while (true) {

        }
    }
}
public class SynchronizedTest {
    //当进入到这个带有synchronized标志的方法中时
    // ，就开始进行锁对象的操作，至于锁那个对象，与写法有关
    public synchronized static void method1(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }

    }
    public synchronized static void method2(){
        System.out.println(Thread.currentThread().getName());
        while (true){

        }
    }

    public static void main(String[] args){
        MyObject object1=new MyObject();
        MyObject object2=new MyObject();
        new Thread(new Runnable() {
            @Override
            public void run() {
                object1.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                object2.method1();
            }
        }).start();
    }
}
