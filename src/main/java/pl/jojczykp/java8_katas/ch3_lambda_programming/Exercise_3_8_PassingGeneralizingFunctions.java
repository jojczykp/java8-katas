package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public final class Exercise_3_8_PassingGeneralizingFunctions {

	private Exercise_3_8_PassingGeneralizingFunctions() {
	}

	public static Image transform(Image in, ColorTransformer f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();

		WritableImage out = new WritableImage(width, height);

		for (int x = 0 ; x < width ; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y,
						f.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}

		return out;
	}

	public static ColorTransformer addingFrame(
			int imgWidth, int imgHeight, Color frameColor, int frameThickness) {
		return (x, y, currentColor) ->
				(x < frameThickness || x >= imgWidth - frameThickness ||
					y < frameThickness || y >= imgHeight - frameThickness) ?
						frameColor : currentColor;

	}

	@FunctionalInterface
	public interface ColorTransformer {
		Color apply(int x, int y, Color in);
	}

}
