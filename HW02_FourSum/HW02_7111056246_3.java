
public class HW02_7111056246_3 extends FourSum {
    public static void main(String[] args) {
        int[] A = { -1, 1, 1, 2, -4, 4, 8, -3 };
        HW02_7111056246_3 test = new HW02_7111056246_3();
        System.out.println(test.F_sum(A));
    }

    public void sort(int[] A, int left, int right) {
        if (left < right) {
            int temp;
            int i = left;
            int j = right + 1;
            while (true) {
                while (i + 1 < A.length && A[++i] < A[left])
                    ;
                while (j - 1 >= 0 && A[--j] > A[left])
                    ;
                if (i >= j)
                    break;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            temp = A[left];
            A[left] = A[j];
            A[j] = temp;
            sort(A, left, j - 1);
            sort(A, j + 1, right);
        }
    }

    public int F_sum(int[] A) {
        sort(A, 0, A.length - 1);
        return findsum(A, 0, A.length - 1, 0, 4);
    }

    public int findsum(int[] A, int left, int right, int target, int N) {
        if (right - left < 2 || N < 2 || target < A[left] * N || target > A[right] * N) {
            return 0;
        }
        int cnt = 0;
        if (N == 2) {
            while (right > left) {
                int total = A[right] + A[left];
                if (total == target) {
                    cnt++;
                    left++;
                    while (right > left && A[left] == A[left - 1]) {
                        cnt++;
                        left++;
                    }

                } else if (total < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            for (int i = left; i < right + 1; i++) {
                if (i == left || i > left && A[i - 1] != A[i]) {
                    cnt += findsum(A, i + 1, right, target - A[i], N - 1);
                }
            }
        }
        return cnt;
    }
}
