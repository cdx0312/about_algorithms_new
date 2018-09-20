package singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-12 20:38
 **/
public class ContainerSingleton {
    private static Map<String, Object> objectMap = new HashMap<>();

    private ContainerSingleton() {
    }

    public static void registerService(String key, Object instance) {
        if (!objectMap.containsKey(key))
            objectMap.put(key, instance);
    }

    public static Object getService(String key) {
        return objectMap.get(key);
    }
}
