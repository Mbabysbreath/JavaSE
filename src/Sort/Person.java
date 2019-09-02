package Sort;

import java.util.Comparator;

/**
 * @author ZhaoMin
 * @date 2019/9/2 20:06
 */
public class Person implements Comparable<Person>,Comparator<Person>{
    public String name;
    public int age;
    public int rank;

    @Override
    public int compareTo(Person o) {
        if(this.age<o.age){
            return -1;
        }else if(this.age==o.age){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public int compare(Person o1, Person o2) {
        return o1.rank-o2.rank;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +"rank="+rank+
                '}';
    }
}







