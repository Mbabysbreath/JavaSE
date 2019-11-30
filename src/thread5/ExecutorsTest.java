package thread5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用线程池打印ABC
 * @author ZhaoMin
 * @date 2019/11/28 19:59
 */
public class ExecutorsTest {
    private static final ExecutorService EXE=
            Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            final int j=i;
            EXE.submit(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        System.out.println(j);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
