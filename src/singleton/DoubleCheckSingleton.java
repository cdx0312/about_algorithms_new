package singleton;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-12 20:29
 **/
public class DoubleCheckSingleton {
    private DoubleCheckSingleton(){
    }

    private static volatile DoubleCheckSingleton doubleCheckSingleton;

    public static DoubleCheckSingleton getInstance() {
        if (doubleCheckSingleton == null){
            synchronized (DoubleCheckSingleton.class) {
                if (doubleCheckSingleton == null)
                    doubleCheckSingleton = new DoubleCheckSingleton();
            }
        }
        return doubleCheckSingleton;
    }
}

