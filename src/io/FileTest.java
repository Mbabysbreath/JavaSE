package io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhaoMin
 * @date 2019/12/1 16:25
 */
public class FileTest {
    @Test
    public void test1() throws IOException {
        File file=new File("D:\\20190823二叉树\\a.txt");
        System.out.println(file.exists());
        File f2=new File("a.txt");
        System.out.println("f2="+f2.exists());
        File f3=new File("b.txt");
        f3.createNewFile();
        File f4=new File("c.txt");
        System.out.println(f4.exists());
         File d=new File("d:/");
         for(File f:d.listFiles()){
             System.out.println(f.getPath());
         }
    }
    @Test
    public void test2(){
        //实现一个方法，把某个目录所有子文件夹
        //和子文件获取并打印
        File dir=new File("D:\\20190823二叉树\\src");
        List<File> files=listFiles(dir);
        files.stream().forEach((f)->{
            System.out.println(f.getPath());
        });
    }
    public List<File> listFiles(File file){
        List<File> list=new ArrayList<>();
        list.add(file);
      //  System.out.println(file.getPath());
        if(file.isDirectory()){
            for(File f:file.listFiles()){
                if(f.isDirectory()){
                    list.addAll(listFiles(f));
                }else {
                    System.out.println(f.getPath());
                }
            }
        }
        return list;
    }



}
