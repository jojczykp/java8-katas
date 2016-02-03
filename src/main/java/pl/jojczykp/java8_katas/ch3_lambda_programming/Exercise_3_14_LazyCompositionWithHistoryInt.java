package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.paint.Color;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static javafx.scene.paint.Color.color;

public final class Exercise_3_14_LazyCompositionWithHistoryInt {

	private Exercise_3_14_LazyCompositionWithHistoryInt() {
	}

	@FunctionalInterface
	public interface ImageTransformer {
		Color apply(PixelReader reader, int width, int height, int x, int y);
	}

	public static ImageTransformer mirroring() {
		return (reader, width, height, x, y) -> reader.getColor(width - x - 1, y);
	}

	public static ImageTransformer adapting(UnaryOperator<Color> op) {
		return (reader, width, height, x, y) -> op.apply(reader.getColor(x, y));
	}

	public static ImageTransformer addingFrame(Color frameColor, int frameThickness) {
		return (reader, width, height, x, y) ->
				(x < frameThickness || x >= width - frameThickness ||
						y < frameThickness || y >= height - frameThickness) ?
						frameColor : reader.getColor(x, y);
	}

	public static ImageTransformer blurring() {
		return (reader, width, height, x, y) -> {
			double red = 0.0;
			double green = 0.0;
			double blue = 0.0;
			double alpha = 0.0;
			int count = 0;

			for (int a = max(x - 1, 0); a <= min(x + 1, width - 1); a++) {
				for (int b = max(y - 1, 0); b <= min(y + 1, height - 1); b++) {
					count++;
					red += reader.getColor(a, b).getRed();
					green += reader.getColor(a, b).getGreen();
					blue += reader.getColor(a, b).getBlue();
					alpha += reader.getColor(a, b).getOpacity();
				}
			}

			return color(red / count, green / count, blue / count, alpha / count);
		};
	}

	public static class ComposedImageTransformer {
		private PixelReader reader;
		private int width;
		private int height;

		private List<ImageTransformer> operations = new LinkedList<>();

		public ComposedImageTransformer(Image image) {
			this.reader = image.getPixelReader();
			this.width = (int) image.getWidth();
			this.height = (int) image.getHeight();
		}

		public static ComposedImageTransformer from(Image image) {
			return new ComposedImageTransformer(image);
		}

		public ComposedImageTransformer transform(ImageTransformer nextOperation) {
			operations.add(nextOperation);
			return this;
		}

		public Image toImage() {
			PixelReader prev = reader;

			for (ImageTransformer operation : operations) {
				PixelReaderCache curr = new PixelReaderCache(prev, width, height);

				for (int x = 0; x < width; x++) {
					for (int y = 0; y < height; y++) {
						Color oldColor = curr.getColor(x, y);
						Color newColor = operation.apply(prev, width, height, x, y);
						if (!oldColor.equals(newColor)) {
							curr.putColor(x, y, newColor);
						}
					}
				}

				prev = curr;
			}

			return toImage(prev);
		}

		private WritableImage toImage(PixelReader prev) {
			WritableImage wim = new WritableImage(width, height);

			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					wim.getPixelWriter().setColor(x, y, prev.getColor(x, y));
				}
			}

			return wim;
		}
	}

	private static class PixelReaderCache implements PixelReader {
		private PixelReader reader;
		private Color[][] cache;

		PixelReaderCache(PixelReader reader, int width, int height) {
			this.reader = reader;
			this.cache = new Color[width][height];
		}

		public void putColor(int x, int y, Color color) {
			cache[x][y] = color;
		}

		@Override
		public Color getColor(int x, int y) {
			return cache[x][y] != null ? cache[x][y] : reader.getColor(x, y);
		}

		@Override
		public PixelFormat getPixelFormat() {
			throw new RuntimeException("getPixelFormat not implemented");
		}

		@Override
		public int getArgb(int x, int y) {
			throw new RuntimeException("getArgb not implemented");
		}

		@Override
		public <T extends Buffer> void getPixels(int x, int y, int w, int h, WritablePixelFormat<T> pixelformat,
													T buffer, int scanlineStride) {
			throw new RuntimeException("getPixels not implemented");
		}

		@Override
		public void getPixels(int x, int y, int w, int h, WritablePixelFormat<ByteBuffer> pixelformat,
								byte[] buffer, int offset, int scanlineStride) {
			throw new RuntimeException("getPixels not implemented");
		}

		@Override
		public void getPixels(int x, int y, int w, int h, WritablePixelFormat<IntBuffer> pixelformat,
								int[] buffer, int offset, int scanlineStride) {
			throw new RuntimeException("getPixels not implemented");
		}
	}

}
