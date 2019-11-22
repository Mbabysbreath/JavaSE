package ExceptionDemo;

/**
 * @author ZhaoMin
 * @date 2019/9/21 15:02
 */
class MyArrayList{
    private int[] array;
    private int size;
    public int get(int index){
        if(index<0||index>size){
            //抛出异常
            throw new ArrayIndexOutOfBoundsException("下标异常");
        }
        return array[index];
    }

}
public class ExceptionDemo {
    public static void main(String[] args) {
        MyArrayList ob = new MyArrayList();
        ob.get(0);
    }
}
