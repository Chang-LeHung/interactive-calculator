import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class TestSystemCommand {

  @Test
  public void test() throws IOException, InterruptedException {
    Process p = Runtime.getRuntime().exec("ls");
    java.io.InputStream is = p.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8"))); //设置读取的时候的编码为GBK
    p.waitFor();
    if(p.exitValue()!=0){

    }else{
      String s = null;
      while((s=reader.readLine())!=null){
        System.out.println(s);
      }
    }
  }
}
