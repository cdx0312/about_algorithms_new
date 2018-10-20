package singleton.adapter;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-13 22:06
 * 适配器模式
 **/
public class AdapterDemo {
    public static void main(String[] args) {
        PS2 p = new Adapter();
        p.idPs2();
    }
}

interface PS2 {
    void idPs2();
}

interface USB {
    void isUSB();
}

class Usber implements USB {
    @Override
    public void isUSB() {
        System.out.println("USB");
    }
}

class Adapter extends Usber implements PS2 {
    @Override
    public void idPs2() {
        isUSB();
    }
}
