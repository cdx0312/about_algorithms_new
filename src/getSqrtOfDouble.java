/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-19 12:50
 **/
public class getSqrtOfDouble {
    public static void main(String[] args) {
        System.out.println(sqrt(2.4, 0.01));
    }

    private static double sqrt(double d, Double precise) {
        double low = 0, high = d, middle, squre;
        double prec = precise != null ? precise : 1e-7;
        if (d < 0) {
            return -1;
        }

        while (high - low > prec) {
            middle = (low + high) / 2;
            squre = middle * middle;
            if (squre > d) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return (low + high) / 2;
    }

    private static double sqrt_ (double t, Double prec) {
        double x0 = t;

        while (true) {
            double x1 = (x0 * x0 + t) / (2 * x0);
            if (Math.abs(x1 * x1 -t) <= prec)
                return x1;
            x0 = x1;
        }
    }
}
