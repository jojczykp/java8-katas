package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static javafx.scene.paint.Color.color;

public final class Exercise_3_13_LazyCompositionWithHistory {

	private Exercise_3_13_LazyCompositionWithHistory() {
	}

	public static class ComposedImageTransformer {
		private Image image;
		private List<ImageTransformer> operations = new LinkedList<>();

		public ComposedImageTransformer(Image image) {
			this.image = image;
		}

		public static ComposedImageTransformer from(Image image) {
			return new ComposedImageTransformer(image);
		}

		public ComposedImageTransformer transform(ImageTransformer nextOperation) {
			operations.add(nextOperation);
			return this;
		}

		public Image toImage() {
			int width = (int) image.getWidth();
			int height = (int) image.getHeight();

			WritableImage prev = new WritableImage(width, height);
			WritableImage curr = new WritableImage(image.getPixelReader(), width, height);

			for (ImageTransformer operation : operations) {
				WritableImage temp = prev;
				prev = curr;
				curr = temp;
				for (int x = 0; x < width; x++) {
					for (int y = 0; y < height; y++) {
						curr.getPixelWriter().setColor(x, y, operation.apply(prev, x, y));
					}
				}
			}

			return curr;
		}
	}

	@FunctionalInterface
	public interface ImageTransformer {
		Color apply(Image image, int x, int y);
	}

	public static ImageTransformer blurring() {
		return (image, x, y) -> {
			PixelReader reader = image.getPixelReader();
			int width = (int) image.getWidth();
			int height = (int) image.getHeight();

			double red = 0.0;
			double green = 0.0;
			double blue = 0.0;
			double alpha = 0.0;
			int count = 0;

			for (int a = max(x - 1, 0) ; a <= min(x + 1, width - 1) ; a++) {
				for (int b = max(y - 1, 0) ; b <= min(y + 1, height - 1) ; b++) {
					red += reader.getColor(a, b).getRed();
					green += reader.getColor(a, b).getGreen();
					blue += reader.getColor(a, b).getBlue();
					alpha += reader.getColor(a, b).getOpacity();
					count++;
				}
			}
			return color(red / count, green / count, blue / count, alpha / count);
		};
	}

	public static ImageTransformer adapting(ColorTransformer op) {
		return (image, x, y) -> op.apply(x, y, image.getPixelReader().getColor(x, y));
	}

	public static ImageTransformer adapting(UnaryOperator<Color> op) {
		return (image, x, y) -> op.apply(image.getPixelReader().getColor(x, y));
	}

	@FunctionalInterface
	public interface ColorTransformer {
		Color apply(int x, int y, Color in);
	}

	public static ColorTransformer framing(
			int imgWidth, int imgHeight, Color frameColor, int frameThickness) {
		return (x, y, currentColor) ->
				(x < frameThickness || x >= imgWidth - frameThickness ||
						y < frameThickness || y >= imgHeight - frameThickness) ?
						frameColor : currentColor;
	}

}
