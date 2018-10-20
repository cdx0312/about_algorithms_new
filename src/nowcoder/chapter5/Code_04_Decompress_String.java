package nowcoder.chapter5;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-26 14:12
 **/
public class Code_04_Decompress_String {
    public static String decompress(String decompressStr) {
        char[] chars = decompressStr.toCharArray();
        return process(chars, 0).str;
    }

    public static class ReturnData {
        public String str;
        public int end;

        public ReturnData(String str, int nextIndex) {
            this.str = str;
            this.end = nextIndex;
        }
    }

    private static ReturnData process(char[] chars, int index) {
        StringBuilder sb = new StringBuilder();
        int times = 0;
        while (index < chars.length && chars[index] != '}') {
            if (chars[index] == '{') {
                ReturnData returnData = process(chars, index + 1);
                sb.append(getTimesString(times, returnData.str));
                times = 0;
                index = returnData.end + 1;
            } else {
                if (chars[index] >= '0' && chars[index] <= '9')
                    times = times * 10 + chars[index] - '0';
                if (chars[index] >= 'a' && chars[index] <= 'z')
                    sb.append(String.valueOf(chars[index]));
                index++;
            }
        }
        return new ReturnData(sb.toString(), index);
    }

    private static String getTimesString(int times, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++)
            sb.append(str);
        return sb.toString();
    }

    public static void main(String[] args) {
        String test1 = "3{a}2{bc}";
        String test2 = "3{a2{c}}";
        String test3 = "2{abc}3{cd}ef";
        System.out.println(decompress(test1));
        System.out.println(decompress(test2));
        System.out.println(decompress(test3));
    }
}