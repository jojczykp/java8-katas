package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.function.BiPredicate;

public final class Exercise_3_5_ImageFrame {

	private Exercise_3_5_ImageFrame() {
	}

	public static Image transform(Image in, ColorTransformer f,
								  BiPredicate<Integer, Integer> condition) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();

		WritableImage out = new WritableImage(width, height);

		for (int x = 0 ; x < width ; x++) {
			for (int y = 0; y < width; y++) {
				out.getPixelWriter().setColor(x, y,
						condition.test(x, y) ?
								f.apply(in.getPixelReader().getColor(x, y)) :
								in.getPixelReader().getColor(x, y));
			}
		}

		return out;
	}

	@FunctionalInterface
	public interface ColorTransformer {
		Color apply(Color in);
	}

}
