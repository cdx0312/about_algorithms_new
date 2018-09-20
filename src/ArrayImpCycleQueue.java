/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-12 10:45
 **/
public class ArrayImpCycleQueue {
    Object[] a;
    int head;
    int tail;
    public ArrayImpCycleQueue(int size) {
        a = new Object[size];
        head = 0;
        tail = 0;
    }
    public ArrayImpCycleQueue() {
        this(10);
    }
    public boolean enqueue(Object object) {
        if ((tail+1)%a.length == head)
            return false;
        a[tail] = object;
        tail = (tail+1)%a.length;
        return true;
    }
    public Object dequeue() {
        if (tail == head)
            return null;
        Object object = a[head];
        head = (head+1) % a.length;
        return object;
    }
}
