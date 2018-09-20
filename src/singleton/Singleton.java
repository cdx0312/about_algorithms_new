package singleton;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-12 20:06
 **/
public class Singleton {
    private Singleton(){
    }

    private static Singleton singleton = new Singleton();

    public static Singleton getInstancce(){
        return singleton;
    }
}
