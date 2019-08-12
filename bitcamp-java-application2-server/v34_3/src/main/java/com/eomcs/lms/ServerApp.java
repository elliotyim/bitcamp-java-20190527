// v34_3: Runnable 인터페이스를 사용하여 간접적으로 스레드를 실행하기
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.eomcs.lms.context.ServletContextListener;
import com.eomcs.lms.servlet.Servlet;

public class ServerApp {

  public static boolean isStopping = false;
  
  ArrayList<ServletContextListener> listeners = new ArrayList<>();
  int port;

  HashMap<String,Object> servletContext = new HashMap<>();

  public ServerApp(int port) {
    this.port = port;
  }
  public void execute() {
    System.out.println("[수업관리시스템 서버 애플리케이션]");

    try (ServerSocket serverSocket = new ServerSocket(this.port)) {
      System.out.println("서버 시작!");

      for (ServletContextListener listener : listeners) {
        listener.contextInitialized(servletContext);
      }

      while (true) {
        System.out.println("클라이언트 요청을 기다리는 중...");

        Socket socket = serverSocket.accept();
        new Thread(new RequestHandler(socket)).start();

        if (isStopping)
          break;
      }

      for (ServletContextListener listener : listeners) {
        listener.contextDestroyed(servletContext);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("서버 종료!");
  }

  public void addServletContextListener(ServletContextListener listener) {
    listeners.add(listener);
  }
  
  private Servlet findServlet(String command) {
    Set<String> keys = servletContext.keySet();

    for (String key : keys) {
      if(command.startsWith(key)) {
        return (Servlet)servletContext.get(key);
      }
    }
    return null;
  }

  // Thread를 상속 받아 직접 스레드 역할을 하는 대신에
  // Thread를 통해 실행할 코드를 정의한다.
  private class RequestHandler implements Runnable {
    
    protected Socket socket;

    public RequestHandler(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try (Socket clientSocket = this.socket;
          ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
          ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

        System.out.println("클라이언트와 연결되었음.");

        String command = in.readUTF();
        System.out.println(command + " 요청 처리중...");

        Servlet servlet = null;

        if (command.equals("serverstop")) {
          isStopping = true;
          return;

        } else if ((servlet = ServerApp.this.findServlet(command)) != null) {
          servlet.service(command, in, out);

        } else {
          out.writeUTF("fail");
          out.writeUTF("지원하지 않는 명령입니다.");
        }

        out.flush();
        System.out.println("클라이언트에게 응답 완료!");
        InetSocketAddress addr = (InetSocketAddress) socket.getRemoteSocketAddress();
        System.out.println("접속한 클라이언트의 IP: " + addr.getAddress());

      } catch (Exception e) {
        System.out.println("클라이언트와의 통신 오류! - " + e.getMessage());
      }

      System.out.println("클라이언트와 연결을 끊었음.");
    }

  }

  public static void main(String[] args) {
    ServerApp server = new ServerApp(8888);

    server.addServletContextListener(new AppInitListener());

    server.execute();
  }



}






