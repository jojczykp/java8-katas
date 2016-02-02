package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.function.BiFunction;

public final class Exercise_3_6_ReturningFunctions {

	private Exercise_3_6_ReturningFunctions() {
	}

	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();

		WritableImage out = new WritableImage(width, height);

		for (int x = 0 ; x < width ; x++) {
			for (int y = 0; y < width; y++) {
				out.getPixelWriter().setColor(x, y,
						f.apply(in.getPixelReader().getColor(x, y), arg));
			}
		}

		return out;
	}

}
