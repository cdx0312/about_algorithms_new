package singleton;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-12 20:34
 **/
public class InnerStaticClassSingleton {
    private InnerStaticClassSingleton(){
    }

    public static InnerStaticClassSingleton getInstance() {
        return SingletonHolder.instance;
    }


    private static class SingletonHolder {
        private static final InnerStaticClassSingleton instance = new InnerStaticClassSingleton();
    }
}
