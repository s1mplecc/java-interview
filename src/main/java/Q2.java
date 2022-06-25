public class Q2 {
    public static void main(String[] args) {
        // 饿汉式 Singleton1/Singleton2，类初始化时创建实例，所以不存在线程安全问题
        Singleton1 singleton1 = Singleton1.INSTANCE;
        System.out.println(singleton1);
        Singleton2 singleton2 = Singleton2.INSTANCE;
        System.out.println(singleton2);
        // 懒汉式 Singleton3，线程不安全
        Singleton3 singleton3 = Singleton3.getInstance();
        System.out.println(singleton3);
        // 懒汉式 Singleton4，线程安全
        Singleton4 singleton4 = Singleton4.getInstance();
        System.out.println(singleton4);
        // 懒汉式 Singleton5，线程安全，双重校验锁
        Singleton5 singleton5 = Singleton5.getInstance();
        System.out.println(singleton5);
        // 懒汉式 Singleton6，线程安全，内部类持有实例
        Singleton6 singleton6 = Singleton6.getInstance();
        System.out.println(singleton6);
    }

    static class Singleton1 {
        public static final Singleton1 INSTANCE = new Singleton1();

        private Singleton1() {
        }
    }

    enum Singleton2 {
        INSTANCE
    }

    static class Singleton3 {
        private static Singleton3 instance;

        private Singleton3() {

        }

        public static Singleton3 getInstance() {
            if (instance == null) {
                instance = new Singleton3();
            }
            return instance;
        }
    }

    static class Singleton4 {
        private static Singleton4 instance;

        private Singleton4() {

        }

        public static Singleton4 getInstance() {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
                return instance;
            }
        }
    }

    static class Singleton5 {
        private static Singleton5 instance;

        private Singleton5() {

        }

        public static Singleton5 getInstance() {
            // 双重校验锁法
            if (instance == null) {
                synchronized (Singleton5.class) {
                    if (instance == null) {
                        instance = new Singleton5();
                    }
                }
            }
            return instance;
        }
    }

    static class Singleton6 {
        private Singleton6() {
        }

        private static class Inner {
            private static final Singleton6 INSTANCE = new Singleton6();
        }

        public static Singleton6 getInstance() {
            return Inner.INSTANCE;
        }
    }
}
