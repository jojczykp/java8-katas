package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.jojczykp.java8_katas.ch3_lambda_programming
		.Exercise_3_14_LazyCompositionWithHistoryInt.ComposedImageTransformer;

import static org.hamcrest.MatcherAssert.assertThat;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_14_LazyCompositionWithHistoryInt.adapting;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_14_LazyCompositionWithHistoryInt.framing;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_14_LazyCompositionWithHistoryInt.blurring;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_14_LazyCompositionWithHistoryInt.mirroring;
import static pl.jojczykp.java8_katas.test_tools.ImageTools.anImageFromResource;
import static pl.jojczykp.java8_katas.test_tools.IsEqualPixelByPixelTo.isEqualPixelByPixelTo;

public class Exercise_3_14_LazyCompositionWithHistoryIntTest {

	private static final Color FRAME_COLOR = Color.BLACK;
	private static final int FRAME_THICKNESS = 3;

	@BeforeClass
	public static void initializeJavaFX() {
		new JFXPanel();
	}

	@Test
	public void shouldPaintDarkWithFrameBlurrAndMirroring() {
		Image normal = anImageFromResource("ch3_lambda_programming/image.png");
		Image expected = anImageFromResource("ch3_lambda_programming/imageDarkFramedBlurredMirrored.png");

		Image transformed = ComposedImageTransformer.from(normal)
				.transform(adapting(Color::darker))
				.transform(framing(FRAME_COLOR, FRAME_THICKNESS))
				.transform(blurring())
				.transform(mirroring())
				.toImage();

		assertThat(transformed, isEqualPixelByPixelTo(expected));
	}

}
