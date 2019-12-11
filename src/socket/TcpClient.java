package socket;

import sun.print.PrinterJobWrapper;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author ZhaoMin
 * @date 2019/12/8 17:17
 */
public class TcpClient {
    private static final String HOST="127.0.0.1";
    private static final int PORT=9999;
    public static void main(String[] args) {

        Socket socket= null;
        OutputStream os= null;
        PrintWriter pw= null;
        try {
            socket = new Socket(HOST,PORT);
            os = socket.getOutputStream();
            pw = new PrintWriter(os,true);
            pw.println("Hello");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (pw != null) {
                    pw.close();
                }
            }
        }
    }
}
