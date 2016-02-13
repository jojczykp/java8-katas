package pl.jojczykp.java8_katas.ch6_concurrency;

import java.util.Arrays;
import java.util.stream.Stream;

public class Exercise_6_09_ParallelPrefix {

	private static final Matrix F0 = new Matrix(1, 0, 0, 1);
	private static final Matrix F1 = new Matrix(1, 1, 1, 0);

	public int[] getFirstFibonacciNumbers(int length) {
		Matrix[] result = new Matrix[length];

		Arrays.parallelSetAll(result, i -> F1);
		result[0] = F0;
		Arrays.parallelPrefix(result, Matrix::multipleBy);

		return Stream.of(result).parallel().mapToInt(Matrix::getA).toArray();
	}

	public static class Matrix {

		private int a;
		private int b;
		private int c;
		private int d;

		Matrix() {
		}

		Matrix(int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}

		public Matrix multipleBy(Matrix that) {
			Matrix result = new Matrix();
			result.a = this.a * that.a + this.b * that.c;
			result.b = this.a * that.b + this.b * that.d;
			result.c = this.c * that.a + this.d * that.c;
			result.c = this.c * that.b + this.d * that.d;

			return result;
		}

		public int getA() {
			return a;
		}

	}

}
