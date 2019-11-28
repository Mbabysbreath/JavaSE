package thread5;

/**
 * 实现一个定时器
 * @author ZhaoMin
 * @date 2019/11/28 21:14
 */
public class MyTimer {
    public static void main(String[] args) {
        MyTimer mt=new MyTimer();
        mt.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("叮咚咚！");
            }
        },0,1000);
    }
    public void schedule(Runnable task,long delay,long period){
        try {
            long next=delay+System.currentTimeMillis();
            while(true){
                long current=System.currentTimeMillis();
                if(next>current){
                    Thread.sleep(next-current);
                }
                new Thread(task).start();
                if(period>0){
                    next+=period;
                }else{
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
