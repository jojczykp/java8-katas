package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.jojczykp.java8_katas.ch3_lambda_programming.
		Exercise_3_12_LazyFunctionalInterfacesComposition.ComposedColorTransformer;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static pl.jojczykp.java8_katas.tools.IsEqualPixelByPixelTo.isEqualPixelByPixelTo;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.
		Exercise_3_12_LazyFunctionalInterfacesComposition.adapting;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.
		Exercise_3_12_LazyFunctionalInterfacesComposition.addingFrame;

public class Exercise_3_12_LazyFunctionalInterfacesCompositionTest {

	private static final Color FRAME_COLOR = Color.BLACK;
	private static final int FRAME_THICKNESS = 3;

	@BeforeClass
	public static void initializeJavaFX() {
		new JFXPanel();
	}

	@Test
	public void shouldPaintDarkWithFrame() throws IOException {
		Image unframed = anImageFromResource("ch3_lambda_programming/imageUnframed.png");
		Image darkWithFrame = anImageFromResource("ch3_lambda_programming/imageDarkWithFrame.png");

		Image transformed = ComposedColorTransformer.from(unframed)
				.transform(adapting(Color::darker))
				.transform(addingFrame(
						(int) unframed.getWidth(), (int) unframed.getHeight(),
						FRAME_COLOR, FRAME_THICKNESS))
				.toImage();

		assertThat(transformed, isEqualPixelByPixelTo(darkWithFrame));
	}

	private Image anImageFromResource(String resourceName) {
		return new Image(getClass().getClassLoader().getResourceAsStream(resourceName));
	}

}
