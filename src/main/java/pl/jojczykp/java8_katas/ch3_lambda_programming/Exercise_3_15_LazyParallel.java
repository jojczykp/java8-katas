package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

public final class Exercise_3_15_LazyParallel {

	private Exercise_3_15_LazyParallel() {
	}

	public static final class LatentImage {
		private Image in;
		private List<UnaryOperator<Color>> pendingOperations = new LinkedList<>();

		private LatentImage(Image in) {
			this.in = in;
		}

		public static LatentImage from(Image in) {
			return new LatentImage(in);
		}

		public LatentImage transform(UnaryOperator<Color> f) {
			pendingOperations.add(f);
			return this;
		}

		public Image toImage() throws InterruptedException {
			return arrayToImage(parallelTransform(imageToArray(in), pendingOperations));
		}

		private Color[][] imageToArray(Image in) {
			int width = (int) in.getWidth();
			int height = (int) in.getHeight();
			PixelReader reader = in.getPixelReader();
			Color[][] out = new Color[width][height];

			for (int x = 0 ; x < width ; x++) {
				for (int y = 0 ; y < height ; y++) {
					out[x][y] = reader.getColor(x, y);
				}
			}

			return out;
		}

		private Image arrayToImage(Color[][] in) {
			int width = in.length;
			int height = in[0].length;
			WritableImage out = new WritableImage(width, height);
			PixelWriter writer = out.getPixelWriter();

			for (int x = 0 ; x < width ; x++) {
				for (int y = 0 ; y < height ; y++) {
					writer.setColor(x, y, in[x][y]);
				}
			}

			return out;
		}
	}

	private static Color[][] parallelTransform(Color[][] in, List<UnaryOperator<Color>> fs)
																	throws InterruptedException {
		int threads = Runtime.getRuntime().availableProcessors();
		int height = in.length;
		int width = in[0].length;
		Color[][] out = new Color[height][width];

		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < threads; i++) {
			int fromY = i * height / threads;
			int toY = (i + 1) * height / threads;
			pool.submit(() -> {
				for (int x = 0; x < width; x++) {
					for (int y = fromY; y < toY; y++) {
						for (UnaryOperator<Color> f : fs) {
							out[y][x] = f.apply(in[y][x]);
						}
					}
				}
			});
		}
		pool.shutdown();
		pool.awaitTermination(1, TimeUnit.HOURS);

		return out;
	}

}
