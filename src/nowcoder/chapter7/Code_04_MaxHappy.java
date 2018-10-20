package nowcoder.chapter7;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-27 20:00
 **/
public class Code_04_MaxHappy {
    public static class Staff{
        public int value;
        public List<Staff> nexts;
    }

    public static class ReturnType {
        int comeMax;
        int notComeMax;

        public ReturnType(int comeValue, int notComeValue) {
            this.comeMax = comeValue;
            this.notComeMax = notComeValue;
        }
    }

    public static ReturnType getMaxHappy(Staff head) {
        if (head.nexts.isEmpty())
            return new ReturnType(head.value, 0);

        List<ReturnType> nextResults = new ArrayList<>();

        for (Staff next : head.nexts) {
            nextResults.add(getMaxHappy(next));
        }
        int notComeMax = 0;
        int comeMax = head.value;

        for (ReturnType r : nextResults) {
            comeMax += r.notComeMax;
        }

        for (ReturnType r : nextResults) {
            notComeMax += Math.max(r.notComeMax, r.comeMax);
        }

        return new ReturnType(comeMax, notComeMax);
    }
}
