package singleton;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-12 20:08
 **/
public class Singleton1 {
    private Singleton1() {
    }

    private static Singleton1 singleton;

    public static synchronized Singleton1 getInstance() {
        if (singleton == null)
            singleton = new Singleton1();
        return singleton;
    }
}
