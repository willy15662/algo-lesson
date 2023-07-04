public class HW07_7111056246_2 extends LLK {
    public static void main(String[] args) {
        int[][] A = { { 1, 2 }, { 1, 3 }, { 1, 4 } };
        int[][] B = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 0, 1 } };
        HW07_7111056246_2 test = new HW07_7111056246_2();
        System.out.println(test.checkLLK(A));
        System.out.println(test.checkLLK(B));
    }

    class Slot {
        final double SLOPE;
        final Slot NEXT;

        public Slot(final double slope, final Slot next) {
            this.SLOPE = slope;
            this.NEXT = next;
        }
    }

    final byte CORE = 5;
    final Slot[][] HashTable = new Slot[1 << CORE][];
    final Thread[] T = new Thread[HashTable.length - 1];
    volatile boolean result;

    public boolean checkLLK(int[][] A) {
        result = false;
        final int AEND = A.length - 1, TLEN = T.length, FREQ = HashTable.length,
                BUCKETNUM = 1 << 32 - Integer.numberOfLeadingZeros(AEND), B = BUCKETNUM - 1;

        for (byte ti = 0; ti < TLEN; ++ti) {
            final byte t = ti;
            T[t] = new Thread(() -> {
                for (int i = AEND - t, j, bucket; i > -1; i -= FREQ) {
                    for (HashTable[t] = new Slot[BUCKETNUM], j = i - 1; j > -1;) {
                        final double SLOPE = (A[i][1] - A[j][1]) / (double) (A[i][0] - A[j--][0]);

                        bucket = Double.hashCode(SLOPE) & B;

                        for (Slot pivot = HashTable[t][bucket]; pivot != null; pivot = pivot.NEXT) {

                            if (pivot.SLOPE == SLOPE)
                                result = true;

                            if (result)
                                return;
                        }

                        HashTable[t][bucket] = new Slot(SLOPE, HashTable[t][bucket]);

                        if (result)
                            return;
                    }
                    if (result)
                        return;
                }

            });
            T[t].setDaemon(true);
            T[t].start();
            if (result)
                return true;
        }

        for (int i = AEND - TLEN, j, bucket; i > -1; i -= FREQ) {
            for (HashTable[TLEN] = new Slot[BUCKETNUM], j = i - 1; j > -1;) {
                final double SLOPE = (A[i][1] - A[j][1]) / (double) (A[i][0] - A[j--][0]);
                bucket = Double.hashCode(SLOPE) & B;
                for (Slot pivot = HashTable[TLEN][bucket]; pivot != null; pivot = pivot.NEXT)
                    if (pivot.SLOPE == SLOPE || result)
                        return true;
                HashTable[TLEN][bucket] = new Slot(SLOPE, HashTable[TLEN][bucket]);
            }
            if (result)
                return true;
        }

        try {
            for (final Thread t : T) {
                if (result)
                    return true;
                t.join();
            }
        } catch (final InterruptedException e) {
        }
        return result;
    }
}
