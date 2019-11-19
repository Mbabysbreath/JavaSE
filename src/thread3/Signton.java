package thread3;

/**
 * @author ZhaoMin
 * @date 2019/11/17 21:57
 */
//单例类:饿汉
public class Signton {
    private static final Signton SINGTON=new Signton();
    public static Signton getInstance(){
        return SINGTON;
    }
    //懒汉
    private static Signton SINGTON2;
    public static Signton getInstance2(){
        if(SINGTON2==null){
            SINGTON2=new Signton();
        }
        return SINGTON2;
    }
    private Signton(){

    }

    public static Signton getInstance4(){
        if(SINGTON2==null){
            synchronized (Signton.class){
                if(SINGTON2==null){
                    SINGTON2=new Signton();
                }
            }
        }
        return SINGTON2;
    }
    public static void main(String[] args) {

    }
}
