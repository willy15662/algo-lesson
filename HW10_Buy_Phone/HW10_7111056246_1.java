public class HW10_7111056246_1 extends Buy_Phone {
    public static void main(String[] args) {
        int[][] A = { { 2, 10 }, { 5, 4 }, { 1, 1 }, { 2, 4 }, { 4, 8 }, { 5, 5 }, { 8, 4 }, { 10, 2 }, { 10, 1 } };
        HW10_7111056246_1 test = new HW10_7111056246_1();
        test.bestPhone(A);
    }

    public int[][] bestPhone(int[][] inputArr) {
        int n = inputArr.length - 1, cnt = 0, max_y = -1, now_x = inputArr[n][0];
        int[] ans = new int[n];
        for (int i = n; i > 0; i--) {
            if (inputArr[i][1] > max_y) {
                if (now_x == inputArr[i][0]) {
                    max_y = inputArr[i][1];
                    ans[cnt] = i;
                } else {
                    now_x = inputArr[i][0];
                    max_y = inputArr[i][1];
                    cnt++;
                    ans[cnt] = i;
                }
            }
        }

        int[][] output = new int[cnt + 1][2];
        for (int i = cnt, j = 0; i >= 0; i--, j++) {
            output[j] = inputArr[ans[i]];
        }
        return output;
    }
}
