package io;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhaoMin
 * @date 2019/12/5 21:47
 */
public class ObjectSeralizeTest {
    @Test
    public void test1() throws IOException, ClassNotFoundException {
        Person p=new Person(1,"张三","1@qq.com");
        List<Cloth> cloths=new ArrayList<>();
        cloths.add(new Cloth("A","迪奥"));
        cloths.add(new Cloth("B","纪梵希"));
        p.setClothes(cloths);
        //深拷贝：使用对象输入输出流进行对象序列化
        //前提：对象（包含对象中的复杂对象）实现Serializable接口
        //序列化
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(baos);
        oos.writeObject(p);
        //反序列化
        ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois=new ObjectInputStream(bais);
        Person copy=(Person)ois.readObject();
        p.getClothes().get(0).setName("C");
        System.out.println(copy);
    }
}
