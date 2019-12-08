package io;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhaoMin
 * @date 2019/12/3 20:59
 */
public class CloneTest {
    public static void main(String[] args) {
        Person person=new Person(1,"张三","123");
        List<Cloth> cloths=new ArrayList<>();
        cloths.add(new Cloth("A","耐克"));
        cloths.add(new Cloth("B","乔丹"));
        person.setClothes(cloths);
        try {
            //浅拷贝：
            //1.实现Cloneable接口
            //2.重写Object.clone()方法
            Person p2=(Person) person.clone();
            person.setName("里斯");//浅拷贝 对简单类型的属性是真正的拷贝
            person.getClothes().get(0).setName("C");
            //对复杂对象是修改引用
            System.out.println(p2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Cloneable,Serializable{
    private Integer id;
    private String name;
    private String email;
    private List<Cloth> clothes=new ArrayList<>();
    public Person(Integer id,String name,String email){
        this.id=id;
        this.name=name;
        this.email=email;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", clothes=" + clothes +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Cloth> getClothes() {
        return clothes;
    }

    public void setClothes(List<Cloth> clothes) {
        this.clothes = clothes;
    }
}


class Cloth implements Serializable{
    private String name;
    private String brand;

    public Cloth(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Cloth{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
