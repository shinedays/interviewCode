package ThreadOrder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bupt on 7/5/17.
 */
public class ThreadOrder2 {
    private static Lock lock = new ReentrantLock();
    private static int count = 0;
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();


    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            lock.lock();
            try {
                for(int i = 0; i< 10;i ++){
                    while (count %3 != 0)
                        A.await();
                    System.out.println("A");
                    count ++;
                    B.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(()->{
            lock.lock();
            try {
                for(int i = 0; i< 10;i ++){
                    while (count %3 != 1)
                        B.await();
                    System.out.println("B");
                    count ++;
                    C.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t3 = new Thread(()->{
            lock.lock();
            try {
                for(int i = 0; i< 10;i ++){
                    while (count %3 != 2)
                        C.await();
                    System.out.println("C");
                    count ++;
                    A.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
