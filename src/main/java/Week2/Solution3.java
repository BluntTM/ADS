package Week2;

class Solution3 {
    public static double[][] clone(double[][] a) {
        double[][] b = new double[a.length][];
        for (int i = 0; i < a.length; i++) {
            double[] dArr = a[i];
            if (dArr == null) {
                b[i] = null;
                continue;
            }

            double[] dClone = new double[dArr.length];
            for (int i2 = 0; i2 < dArr.length; i2++) {
                dClone[i2] = dArr[i2];
            }
            b[i] = dClone;
        }
        return b;
    }
}
