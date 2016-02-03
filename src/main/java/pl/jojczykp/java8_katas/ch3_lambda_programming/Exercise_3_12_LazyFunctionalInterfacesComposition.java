package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;

public final class Exercise_3_12_LazyFunctionalInterfacesComposition {

	private Exercise_3_12_LazyFunctionalInterfacesComposition() {
	}

	public static class ComposedColorTransformer {
		private Image image;
		private List<ColorTransformer> operations = new LinkedList<>();

		public ComposedColorTransformer(Image image) {
			this.image = image;
		}

		public static ComposedColorTransformer from(Image image) {
			return new ComposedColorTransformer(image);
		}

		public ComposedColorTransformer transform(ColorTransformer nextOperation) {
			operations.add(nextOperation);
			return this;
		}

		public Image toImage() {
			int width = (int) image.getWidth();
			int height = (int) image.getHeight();

			WritableImage out = new WritableImage(width, height);

			for (int x = 0 ; x < width ; x++) {
				for (int y = 0; y < width; y++) {
					Color newColor = image.getPixelReader().getColor(x, y);
					for (ColorTransformer operation : operations) {
						newColor = operation.apply(x, y, newColor);
					}
					out.getPixelWriter().setColor(x, y, newColor);
				}
			}

			return out;
		}
	}

	@FunctionalInterface
	public interface ColorTransformer {
		Color apply(int x, int y, Color in);
	}

	public static ColorTransformer addingFrame(
			int imgWidth, int imgHeight, Color frameColor, int frameThickness) {
		return (x, y, currentColor) ->
				(x < frameThickness || x >= imgWidth - frameThickness ||
						y < frameThickness || y >= imgHeight - frameThickness) ?
						frameColor : currentColor;
	}

	public static ColorTransformer adapting(UnaryOperator<Color> op) {
		return (x, y, color) -> op.apply(color);
	}

}
