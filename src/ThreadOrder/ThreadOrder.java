package ThreadOrder;

import java.util.concurrent.Semaphore;

/**
 * Created by bupt on 7/5/17.
 */
public class ThreadOrder {
    public static Semaphore A = new Semaphore(1);
    public static Semaphore B = new Semaphore(1);
    public static Semaphore C = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                for(int i = 0; i < 10; i++){
                    A.acquire();
                    System.out.println("A");
                    B.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                for(int i = 0; i < 10; i++){
                    B.acquire();
                    System.out.println("B");
                    C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread t3 = new Thread(() -> {
            try {
                for(int i = 0; i < 10; i++){
                    C.acquire();
                    System.out.println("C");
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        B.acquire();
        C.acquire();
        t1.start();
        t2.start();
        t3.start();
    }
}
