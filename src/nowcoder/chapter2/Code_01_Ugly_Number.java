package nowcoder.chapter2;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 18:38
 **/
public class Code_01_Ugly_Number {
    public static void main(String[] args) {
        System.out.println(uglyNumber1(18));
        System.out.println(uglyNumber2(18));
    }

    private static int uglyNumber1(int index) {
        int number = 0;
        int count = 0;
        while (count < index) {
            number++;
            if (isUgly(number))
                count++;
        }
        return number;
    }

    private static boolean isUgly(int number) {
        while (number % 2 == 0)
            number = number / 2;
        while (number % 3 == 0)
            number = number / 3;
        while (number % 5 == 0)
            number = number / 5;
        return number == 1;
    }

    private static int uglyNumber2(int n) {
        int[] help = new int[n];
        help[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0, index = 1;
        while (index < n) {
            help[index] = Math.min(2 * help[i2], Math.min(3 * help[i3], 5 * help[i5]));
            if (help[index] == 2 * help[i2])
                i2++;
            if (help[index] == 3 * help[i3])
                i3++;
            if (help[index] == 5 * help[i5])
                i5++;
            index++;
        }
        return help[index - 1];
    }
}
