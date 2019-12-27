package socket;

/**
 * @author ZhaoMin
 * @date 2019/12/27 9:23
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Test.class.getClassLoader().getResourceAsStream("../login.html"));
    }
}
