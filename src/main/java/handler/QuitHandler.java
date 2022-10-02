package handler;

import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.io.IOException;

public class QuitHandler implements SignalHandler {
  @Override
  public void handle(Signal sig) {
    byte[] info = new byte[1024];
    try {
      while (true) {
        System.out.println("Do you want to quit? [y/n]");
        int off = System.in.read(info);
        String s = new String(info);
        if (s.equalsIgnoreCase("y")) {
          System.exit(-1);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    Signal.handle(new Signal("TERM"), new QuitHandler());
    Signal.handle(new Signal("INT"), new QuitHandler());
    byte[] b = new byte[1024];
  }
}
