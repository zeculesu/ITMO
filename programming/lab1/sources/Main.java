public class Main {
    /**
     * Variant: 2119
     */
    public static void main(String[] args) {
        long[] c = new long[13];
        float[] x = new float[15];
        for (int i = 0; i < c.length; i++) {
            c[i] = 17 - i;
        }
        for (int i = 0; i < x.length; i++) {
            x[i] = ((float) Math.random() * 22 - 12);
        }
        float[][] matrix = new float[13][15];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 15; j++) {
                if (c[i] == 8) {
                    matrix[i][j] = (float) Math.sin(Math.pow(x[j], (1 / 3 / (Math.PI - x[j]))));
                } else if (c[i] == 7 || c[i] == 9 || c[i] == 11 || c[i] == 13 || c[i] == 15 || c[i] == 16) {
                    matrix[i][j] = (float) Math.log(Math.exp(x[j]) + 1);
                } else {
                    matrix[i][j] = (float) Math.tan(Math.exp(Math.cos(0.25 / (x[j] - 2))));
                }
            }
        }
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 15; j++) {
			if (Math.abs(matrix[i][j] - 0.0000) < 0.0000999){
				System.out.printf("%10s", "NULL");
			}
			else {
				System.out.printf("%10.4f", matrix[i][j]);
			}
            }
		 System.out.println();
        }
    }
}
