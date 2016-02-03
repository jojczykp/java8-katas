package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_13_LazyCompositionWithHistory.ComposedImageTransformer;

import static org.hamcrest.MatcherAssert.assertThat;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_13_LazyCompositionWithHistory.adapting;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_13_LazyCompositionWithHistory.addingFrame;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_13_LazyCompositionWithHistory.blurring;
import static pl.jojczykp.java8_katas.tools.ImageTools.anImageFromResource;
import static pl.jojczykp.java8_katas.tools.IsEqualPixelByPixelTo.isEqualPixelByPixelTo;

public class Exercise_3_13_LazyCompositionWithHistoryTest {

	private static final Color FRAME_COLOR = Color.BLACK;
	private static final int FRAME_THICKNESS = 3;

	@BeforeClass
	public static void initializeJavaFX() {
		new JFXPanel();
	}

	@Test
	public void shouldPaintDarkWithFrameAnfBlur() {
		Image normal = anImageFromResource("ch3_lambda_programming/image.png");
		Image expected = anImageFromResource("ch3_lambda_programming/imageDarkFramedBlurred.png");

		int width = (int) normal.getWidth();
		int height = (int) normal.getHeight();

		Image transformed = ComposedImageTransformer.from(normal)
				.transform(adapting(Color::darker))
				.transform(adapting(addingFrame(width, height, FRAME_COLOR, FRAME_THICKNESS)))
				.transform(blurring())
				.toImage();

		assertThat(transformed, isEqualPixelByPixelTo(expected));
	}

}
