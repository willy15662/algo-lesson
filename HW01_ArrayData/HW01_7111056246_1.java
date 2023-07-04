public class HW01_7111056246_1 extends ArrayData {

    public HW01_7111056246_1(int[] A) {
        this.A = A;
    }

    public static void main(String[] args) {
        int[] A = { -100, 5, 2222, 45, 666, 90, 87, -55, 123, -88888 };
        HW01_7111056246_1 test = new HW01_7111056246_1(A);
        System.out.println(test.max());
        System.out.println(test.min());
    }

    public int max() {
        int maxnum = Integer.MIN_VALUE;
        for (int i : A) {
            if (maxnum < i)
                maxnum = i;
        }
        return maxnum;
    }

    public int min() {
        int minnum = Integer.MAX_VALUE;
        for (int i : A) {
            if (minnum > i)
                minnum = i;
        }
        return minnum;
    }
}
