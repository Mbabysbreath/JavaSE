package socket;

import sun.print.PrinterJobWrapper;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author ZhaoMin
 * @date 2019/12/8 17:17
 */
public class TcpClient {
    private static final String HOST="1ocalhost";
    private static final int PORT=9999;
    public static void main(String[] args) {
        try {
            Socket socket=new Socket();
            OutputStream os=socket.getOutputStream();
            PrintWriter pw=new PrintWriter(os,true);
            pw.println("Hello");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
