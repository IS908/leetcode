package JavaBasicKnowledge.DaemonThread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by kevin on 16-8-7.
 */
public class TestRunnable implements Runnable {
    @Override
    public void run() {
        try{
            Thread.sleep(1000);//守护线程阻塞1秒后运行
            File f=new File("daemon.txt");
            FileOutputStream os=new FileOutputStream(f,true);
            os.write("daemon".getBytes());
            os.flush();
        } catch(IOException e1){
            e1.printStackTrace();
        } catch(InterruptedException e2){
            e2.printStackTrace();
        }
    }
}
