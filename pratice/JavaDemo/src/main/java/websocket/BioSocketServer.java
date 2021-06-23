package websocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * bio 模型demo
 * @author straycamel
 * @date 2021/6/22
 */
public class BioSocketServer {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(9000);
        // 串行一次只能处理一个链接
        // 串行执行，容易阻塞
        while(true){
            System.out.println("waiting ....");
            // block 阻塞方法
            Socket clientSocket = serverSocket.accept();
              System.out.println("客户端有链接");
            handler(clientSocket);
        }
    }

    private static void handler(Socket clientSocket) throws IOException{
        byte[] bytes = new byte[1024];
        System.out.println("准备read");
        int read =clientSocket.getInputStream().read(bytes);
        System.out.println("read完毕");
        if (read!=-1){
            System.out.println("收到客户端数据："+ new String(bytes ,0 ,read));
        }

    }
}
