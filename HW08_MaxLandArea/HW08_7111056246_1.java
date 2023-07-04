public class HW08_7111056246_1 extends MaxLandArea {
    public static void main(String[] args) {
        int[][] A = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
        HW10_7111056246_1 test = new HW10_7111056246_1();
        System.out.println(test.maxLandArea(A));
    }

    public int maxLandArea(int[][] array) {
        int maxArea = 0;
        int n = array.length, m = array[0].length;
        int A = n * m / 4;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(array, i, j));
                    if (maxArea >= A)
                        return maxArea;
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] array, int i, int j) {
        if (i < 0 || j < 0 || i >= array.length || j >= array[0].length || array[i][j] != 1) {
            return 0;
        }
        array[i][j] = 2;
        return 1 + dfs(array, i + 1, j) + dfs(array, i - 1, j) + dfs(array, i, j + 1) + dfs(array, i, j - 1);
    }
}