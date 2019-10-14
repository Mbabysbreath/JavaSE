import java.util.HashSet;

/**验证在没有写泛型时，给HashSet中添加元素时，
 * 可能会导致传什么类型，它就会加什么类型
 * 问题代码出现在重写equals()方法时的interface会返回false
 * 而返回fasle会被误认为是要加入到HashaSet中
 * @author ZhaoMin
 * @date 2019/10/14 20:21
 */
class Student{
    private String id;
    private String name;

    /**
     * 构造方法
     * @param id
     * @param name
     */
    public Student(String id,String name){
        this.id=id;
        this.name=name;
    }
    //重写toString()方法
    @Override
    public String toString(){
        return id+":"+name;
    }
    //重写hashCode
    @Override
    public int hashCode(){
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
      if(this==obj){//判断是否为同一对象
          return true;
      }
      if(!(obj instanceof Student)){//判断对象是否为Student类型
          return false;
      }
      Student stu=(Student)obj;
      return this.id.equals(stu.id);//判断id值是否相同
    }
}
class Teacher{
    private String id;
    private String name;
    public Teacher(String id,String name){
        this.id=id;
        this.name=name;
    }
}
public class HashSetTest {
    public static void main(String[] args) {
        HashSet hs=new HashSet();
        Student stu1=new Student("1","Jack");
        Student stu2=new Student("2","Rose");
        Student stu3=new Student("2","Jack");
        Teacher t1=new Teacher("3","TTT");//这里虽然类型不是Student的
        hs.add(stu1);
        hs.add(stu2);
        hs.add(stu3);
        hs.add(t1);
        System.out.println(hs);
    }
}
