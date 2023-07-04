public class HW05_7111056246_3 extends littlebit {
    public static void main(String[] args) {
        int[] A = { 1, 3, 6, 8, 9, 5, 3, 6, 8, 5, 4, 2, 2, 3, 7, 7, 9, 8, 6, 6, 6, 4,
                2 };

        HW05_7111056246_3 test = new HW05_7111056246_3();
        System.out.println(test.l_bit(A));
    }

    public int l_bit(int[] A) {
        int[] candy = new int[A.length];

        for (int i = 0; i < candy.length; i++) {
            candy[i] = 1;
        }
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else if (A[i] == A[i - 1]) {
                candy[i] = candy[i - 1];
            }
        }
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            } else if (A[i] == A[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1]);
            }
        }
        int sum = 0;
        for (int o : candy) {
            sum = sum + o;
        }
        return sum;
    }
}
