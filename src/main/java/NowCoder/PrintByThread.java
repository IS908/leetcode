package NowCoder;

import sun.awt.SunHints;

import java.io.*;
import java.util.Random;

/**
 * 一个文件中有10000个数，用Java实现一个多线程程序将这个10000个数输出到5个不用文件中（不要求输出到每个文件中的数量相同）。
 * 要求启动10个线程，两两一组，分为5组。
 * 每组两个线程分别将文件中的奇数和偶数输出到该组对应的一个文件中，需要偶数线程每打印10个偶数以后，就将奇数线程打印10个奇数，如此交替进行。
 * 同时需要记录输出进度，每完成1000个数就在控制台中打印当前完成数量，并在所有线程结束后，在控制台打印”Done”.
 * <p>
 * 分析：可以将10000个数分成五份，每一份对应一组两个线程，分别输出这一份的奇数和偶数，
 * 同时声明一个共享变量用于统计当前所有线程输出的记录的个数，反映记录的输出进度。
 * <p>
 * Created by kevin on 16-8-2.
 */
@Deprecated // 存在问题
public class PrintByThread {
    public static void main(String[] args) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(new File("input.txt")), true);
            Random random = new Random();
            for (int i = 0; i < 10000; i++) {
                pw.print(Math.abs(random.nextInt()) % 100 + " ");
            }
            pw.flush();
            pw.close();

            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String str = reader.readLine();
            reader.close();

            String[] strs = str.split(" ");
            int j = 0;
            for (int i = 0; i < 5; i++) {
                int records[] = new int[2000];
                for (int k = 0; k < 2000; k++) {
                    records[k] = Integer.parseInt(strs[j]);
                    j++;
                }
                PrintWriter writer = new PrintWriter(new FileWriter(new File("output" + i + ".txt")), true);
                ThreadGroup group = new ThreadGroup(records, writer);
                new Thread(group).start();
                new Thread(group).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadGroup implements Runnable {
    private static int count = 0;
    private static Object lock = new Object();
    public static final int EVEN = 0;
    public static final int ODD = 1;
    private int type;
    private int records[];
    private PrintWriter writer;
    private int oddPoint = 0;
    private int evenPoint = 0;

    public ThreadGroup(int[] records, PrintWriter writer) {
        this.type = EVEN;
        this.records = records;
        this.writer = writer;
    }

    @Override
    public void run() {
        while (print()) ;
    }

    private synchronized boolean print() {
        for (int i = 0; i < 10; ) {
            if (oddPoint >= records.length && evenPoint >= records.length) {
                notifyAll();
                return false;
            }
            //如果该线程该打印奇数，但奇数已经打印晚了，就直接停止本次10个数的打印，
            //同理偶数，等下次切换打印类型后，再开始打印另外一种类型
            if ((oddPoint >= records.length && type == ODD)
                    || (evenPoint >= records.length && type == EVEN)) {
                break;
            }
            if (type == EVEN) {
                if (records[evenPoint] % 2 == 0) {
                    i++;
                    writer.print(records[evenPoint] + " ");
                    writer.flush();
                    synchronized (lock) {
                        count++;
                        if (count % 1000 == 0) {
                            System.out.println("当前完成数量：" + count);
                            if (count == 10000) {
                                System.out.println("Done!");
                            }
                        }
                    }
                }
                evenPoint++;
            } else {
                if (records[oddPoint] % 2 == 1) {
                    i++;
                    writer.print(records[oddPoint] + " ");
                    writer.flush();
                    synchronized (lock) {
                        count++;
                        if (count % 1000 == 0) {
                            System.out.println("当前完成数量：" + count);
                            if (count == 10000) {
                                System.out.println("Done!");
                            }
                        }
                    }
                }
                oddPoint++;
            }
        }
        type = ~type;
        notifyAll();
        ;
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
