package yangguohao.threadLocal;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mr.Yang
 * @date 2020/03/09
 **/
public class ThreadLocalTest {
    public static Map<String,Object> data = new ConcurrentHashMap<>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static Random random = new Random();
    public static class Task implements Runnable{

        @Override
        public void run() {
            Integer i = random.nextInt(520);
            String name = Thread.currentThread().getName();
            System.out.println("当前线程【"+name+"】=="+i);

//            data.put(name,i);
            threadLocal.set(i);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            Object o = data.get(name);
            Object o = threadLocal.get();

            System.out.println("当前线程【"+name+"】结束时=="+o);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }

}
