public class HW06_7111056246_1 extends MedianOfArrays {
    public static void main(String[] args) {
        // int[][] A = { { 1, 3, 10 }, { -1, 5, 7 }, { -2, 5, 12 } };
        // int[][] A = { { 1, 2 }, { 3, 4 } };
        int[][] A = { { 1 }, { -1, 5 }, { -2, 5, 12 } };
        HW06_7111056246_1 test = new HW06_7111056246_1();
        System.out.println(test.find_median(A));
    }

    public static int smallMidCount(int[] row, int mid) {
        int l = 0, h = row.length - 1;
        while (l <= h) {
            int md = (l + h) >> 1;
            if (row[md] <= mid) {
                l = ++md;
            } else {
                h = --md;
            }
        }
        return l;
    }

    public double find_median(int[][] arrays) {
        int len = 0;

        for (int[] arr : arrays) {
            len += arr.length;
        }

        int low = -10000000;
        int high = 10000000;
        int n = arrays.length;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int cnt1 = 0;
            for (int i = 0; i < n; i++) {
                cnt1 += smallMidCount(arrays[i], mid);
            }
            if (cnt1 <= (len >> 1)) {
                low = ++mid;
            } else
                high = --mid;
        }
        double ans = low;
        if (len % 2 == 0) {
            low = -10000000;
            high = 10000000;
            while (low <= high) {
                int mid = (low + high) >> 1;
                int cnt1 = 0;
                for (int i = 0; i < n; i++) {
                    cnt1 += smallMidCount(arrays[i], mid);
                }
                if (cnt1 <= (len >> 1) - 1) {
                    low = ++mid;
                } else
                    high = --mid;
            }
            ans = (ans + low) / 2.0;
        }
        return ans;
    }
}