import java.io.IOException;
import java.util.concurrent.Callable;

public class VolatileTest {
    int a = 1;
    int b = 2;

    public void change() {
        a = 3;
        b = a;
    }

    public void print() {
        String x = "b=" + b + ";a=" + a;
        if (x.equals("b=3;a=1"))
            System.out.println(x);
    }

    public static void main(String[] args) {
        while (true) {
            final VolatileTest test = new VolatileTest();
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.change();
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();
        }
    }

    static class A implements Callable {

        @Override
        public Object call() throws IOException {
            return null;
        }
    }

    static class B extends A {
        @Override
        public Object call() throws IndexOutOfBoundsException, IOException {
            return super.call();
        }
    }
}