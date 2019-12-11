package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ZhaoMin
 * @date 2019/12/8 17:08
 */
public class TcpServer {
    private static final int PORT=9999;

    public static void main(String[] args) {
        try {
            ServerSocket server=new ServerSocket(PORT);
            Socket socket=server.accept();
            InputStream inputStream=socket.getInputStream();
            InputStreamReader isr=new InputStreamReader(inputStream);
            BufferedReader reader=new BufferedReader(isr);
            String data=null;
            while((data=reader.readLine())!=null){

                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }

    }
}
