package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.Test;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_15_LazyParallel.LatentImage;

import static org.hamcrest.MatcherAssert.assertThat;
import static pl.jojczykp.java8_katas.test_tools.ImageTools.anImageFromResource;
import static pl.jojczykp.java8_katas.test_tools.IsEqualPixelByPixelToMatcher.isEqualPixelByPixelTo;

public class Exercise_3_15_LazyParallelTest {

	@Test
	public void shouldTransformImageInParallel() throws InterruptedException {
		Image normal = anImageFromResource("ch3_lambda_programming/image.png");
		Image expected = anImageFromResource("ch3_lambda_programming/imageBrighterInverted.png");

		Image transformed = LatentImage.from(normal)
				.transform(Color::brighter)
				.transform(Color::invert)
				.toImage();

		assertThat(transformed, isEqualPixelByPixelTo(expected));
	}

}
