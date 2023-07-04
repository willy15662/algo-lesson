import java.util.regex.Pattern;

public class HW03_7111056246_1 extends One_0k_rock {
    public static void main(String[] args) {
        String[] str = { "0000000000000000000000000000000011111111111111111111111111111111", "0000000011111111", "01",
                "1100", "1111" };
        HW03_7111056246_3 test = new HW03_7111056246_3();
        boolean[] ans = test.one0k(str);
        for (boolean b : ans) {
            System.out.println(b);
        }
    }

    public boolean[] one0k(String[] str) {
        boolean[] output = new boolean[str.length];
        Pattern pattern = Pattern.compile("^(0+1+)+$");

        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            output[i] = pattern.matcher(s).matches();
        }

        return output;
    }
}