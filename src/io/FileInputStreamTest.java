package io;

import org.junit.Test;

import java.io.*;
import java.sql.BatchUpdateException;

/**
 * @author ZhaoMin
 * @date 2019/12/3 19:06
 */
public class FileInputStreamTest {
    @Test
    public void test1(){
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("src/test1.txt");
            System.out.println(f.exists());
            //二进制字节流读取操作
            FileInputStream fis=new FileInputStream(f);
            byte[] bytes=new byte[1024];
            int len=0;
           while((len=fis.read(bytes))!=-1){
                String s = new String(bytes, 0, len);
                System.out.println(s);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void test2(){
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("src/test1.txt");
            System.out.println(f.exists());
            //字符流
            FileInputStream fis=new FileInputStream(f);
            BufferedInputStream bis=new BufferedInputStream(fis);
            byte[] bytes1=new byte[1024];
            int len=0;
            while ((len=bis.read(bytes1))!=-1){
                String s = new String(bytes1, 0, len);
                System.out.println(s);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("src/test1.txt");
            System.out.println(f.exists());
            //字符流
            FileReader fr = new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            String s;
            while ((s=br.readLine())!=null){
                System.out.println(s);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("src/test1.txt");
            System.out.println(f.exists());
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
                bw.write("1=123\n");
            bw.write("唐山");
            bw.newLine();
            bw.write("宋词");
            bw.flush();
            }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void test5(){
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("src/test2.txt");
            System.out.println(f.exists());
            FileInputStream fis = new FileInputStream(f);
            //保存文件时是GBK编码，读取时也需要使用相应编码
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            char[] chars=new char[1024];
            int len=0;
            while((len=isr.read(chars))!=-1){
                System.out.println(new String(chars,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
