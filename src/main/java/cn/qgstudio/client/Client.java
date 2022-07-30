package cn.qgstudio.client;

import cn.qgstudio.constant.SystemConstant;

import java.io.*;
import java.net.Socket;

/**
 * @program: ClientDemo
 * @description:
 * @author: stop.yc
 * @create: 2022-07-29 09:19
 **/
public class Client {
    /**
     * 主机地址
     */
    private final String host = SystemConstant.HOST;
    /**
     * 端口
     */
    private final int port = SystemConstant.PORT_WITH_REMOTE;

    /**
     * 客户端向服务端发送消息
     */
    public String sendMessage(String msg) {
        // 响应结果
        StringBuffer result = new StringBuffer();
        BufferedReader br = null;
        InputStream is = null;
        OutputStream os = null;
        PrintWriter pw = null;
        Socket socket = null;
        try {
            // 和服务器创建连接
            socket = new Socket(host,port);
            System.out.println("和服务器已建立连接....");
            // 要发送给服务器的信息
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            // 给服务端发msg
            pw.write(msg);
            pw.flush();

            socket.shutdownOutput();

            // 从服务器接收的信息
            is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "gbk"));
            String info = null;
            while((info = br.readLine())!=null){
                result.append(info);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭流和socket
            try {
                if(br != null) {
                    br.close();
                }
                if(is != null) {
                    is.close();
                }


                if(os != null) {
                    os.close();
                }
                if(pw != null) {
                    pw.close();
                }
                if(socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }
}
