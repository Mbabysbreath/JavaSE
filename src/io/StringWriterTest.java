package io;

import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author ZhaoMin
 * @date 2019/12/6 18:56
 */
public class StringWriterTest {
    @Test
    public void test1(){
        try {
            throw new RuntimeException("出错了");
        }catch(Exception e){
            System.out.println(e.getMessage());
            StringWriter sw=new StringWriter();
            PrintWriter pw=new PrintWriter(sw);
            e.printStackTrace(pw);
            System.out.println(sw);
        }
    }
}
