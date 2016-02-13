package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.jojczykp.java8_katas.ch3_lambda_programming
		.Exercise_3_12_LazyFunctionalInterfacesComposition.ComposedColorTransformer;

import static org.hamcrest.MatcherAssert.assertThat;
import static pl.jojczykp.java8_katas.ch3_lambda_programming
		.Exercise_3_12_LazyFunctionalInterfacesComposition.adapting;
import static pl.jojczykp.java8_katas.ch3_lambda_programming
		.Exercise_3_12_LazyFunctionalInterfacesComposition.framing;
import static pl.jojczykp.java8_katas.test_tools.ImageTools.anImageFromResource;
import static pl.jojczykp.java8_katas.test_tools.IsEqualPixelByPixelToMatcher.isEqualPixelByPixelTo;

public class Exercise_3_12_LazyFunctionalInterfacesCompositionTest {

	private static final Color FRAME_COLOR = Color.BLACK;
	private static final int FRAME_THICKNESS = 3;

	@BeforeClass
	public static void initializeJavaFX() {
		new JFXPanel();
	}

	@Test
	public void shouldPaintDarkWithFrame() {
		Image normal = anImageFromResource("ch3_lambda_programming/image.png");
		Image expected = anImageFromResource("ch3_lambda_programming/imageDarkWithFrame.png");

		Image transformed = ComposedColorTransformer.from(normal)
				.transform(adapting(Color::darker))
				.transform(framing(
						(int) normal.getWidth(), (int) normal.getHeight(),
						FRAME_COLOR, FRAME_THICKNESS))
				.toImage();

		assertThat(transformed, isEqualPixelByPixelTo(expected));
	}

}
