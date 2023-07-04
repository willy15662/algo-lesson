public class HW04_7111056246_2 extends doge_coin {
    public static void main(String[] args) {
        int[] price = { 1, 2, 3, 4, 5 };
        HW04_7111056246_2 test = new HW04_7111056246_2();
        System.out.println(test.doge(price));
    }

    public int doge(int[] price) {
        int min = Integer.MAX_VALUE, temp = 0;
        for (int i : price) {
            if (i < min) {
                min = i;
            } else if (i - min > temp)
                temp = i - min;
        }
        return temp;
    }
}// 0.001978204499
