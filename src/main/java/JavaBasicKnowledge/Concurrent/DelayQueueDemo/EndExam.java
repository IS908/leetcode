package JavaBasicKnowledge.Concurrent.DelayQueueDemo;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;

/**
 * Created by kevin on 2016/3/28.
 */
public class EndExam extends Student {
    private DelayQueue<Student> students;
    private CountDownLatch countDownLatch;
    private Thread teacherThread;

    public EndExam(DelayQueue<Student> students, long workTime, CountDownLatch countDownLatch, Thread teacherThread) {
        super("强制收卷", workTime, countDownLatch);
        this.students = students;
        this.countDownLatch = countDownLatch;
        this.teacherThread = teacherThread;
    }


    @Override
    public void run() {
        teacherThread.interrupt();
        Student tmpStudent;
        for (Iterator<Student> iterator = students.iterator(); iterator.hasNext(); ) {
            tmpStudent = iterator.next();
            tmpStudent.setForce(true);
            tmpStudent.run();
        }
        countDownLatch.countDown();
    }
}
