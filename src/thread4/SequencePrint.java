package thread4;

import thread.Sequence;

/**
 * 三个线程A\B、C，分别打印字符串A、B\C
 * 要求：循环打印10次
 * ABC
 * ABC
 * 。。。
 * @author ZhaoMin
 * @date 2019/11/19 21:44
 */
public class SequencePrint {
    public static void main(String[] args) {
      //  Object ob=new Object();
        new Thread(new Runnable() {
            String a="A";
            @Override
            public void run() {
                try {
                    synchronized (Sequence.class){
                        for(int i=0;i<10;i++){
                            if(a.equals("A")){
                                System.out.println(a);
                                Sequence.class.wait();
                            }
                            a="B";
                            Sequence.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            String b="B";
            @Override
            public void run() {
                try {
                    synchronized (Sequence.class){
                        for(int i=0;i<10;i++){
                            if(b.equals("B")){
                                System.out.println(b);
                                Sequence.class.wait();
                            }
                            b="C";
                            Sequence.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            String c="C";
            @Override
            public void run() {
                try {
                    synchronized (Sequence.class){
                        for(int i=0;i<10;i++){
                            if(c.equals("C")){
                                System.out.println(c);
                                Sequence.class.wait();
                            }
                            c="A";
                            Sequence.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

