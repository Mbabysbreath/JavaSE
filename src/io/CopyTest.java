package io;

import org.junit.Test;

import java.io.*;

/**
 * 复制操作
 * 1.使用字节流复制压缩文件
 * @author ZhaoMin
 * @date 2019/12/3 20:00
 */
public class CopyTest {
    @Test
    public void test1() {
        try {
            File f = new File("C:\\Users\\zhao'min\\Pictures\\Saved Pictures\\2018-10-01 03.44.39 1.jpg");
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);
            File dest = new File("大头雪雪.jpg");
            FileOutputStream fos = new FileOutputStream(dest);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            bos.flush();
                if(fis != null)
                    fis.close();
                if(fos != null)
                    fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
