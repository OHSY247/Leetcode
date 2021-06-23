package websocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author straycamel
 * @date 2021/6/23
 */
public class NioSocketServer {
    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
        // 设置为非阻塞，NIO
        serverSocketChannel.configureBlocking(false);
        System.out.println("start");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("connect success");
                socketChannel.configureBlocking(false);
                channelList.add(socketChannel);
            }
            // 遍历链接进行数据读取
            Iterator<SocketChannel> iterator = channelList.iterator();
            while (iterator.hasNext()) {
                SocketChannel sc = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                int len = sc.read(byteBuffer);
                if (len > 0) {
                    System.out.println("accept msg:" + new String(byteBuffer.array()));
                } else if (len == -1) {
                    iterator.remove();
                    System.out.println("disconnect");
                }
            }
        }
    }

    private static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[2014];
        //接受客户端的数据，阻塞方法，没有数据可读就阻塞
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read 完毕");
        if (read != -1) {
            System.out.println("accept msg from client:" + new String(bytes, 0, read));
        }
    }
}
