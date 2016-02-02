package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_8_PassingGeneralizingFunctions.addingFrame;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_8_PassingGeneralizingFunctions.transform;
import static pl.jojczykp.java8_katas.tools.IsEqualPixelByPixelTo.isEqualPixelByPixelTo;

public class Exercise_3_8_PassingGeneralizingFunctionsTest {

	private static final Color FRAME_COLOR = Color.BLACK;
	private static final int FRAME_THICKNESS = 3;

	@BeforeClass
	public static void initializeJavaFX() {
		new JFXPanel();
	}

	@Test
	public void shouldPaintFrame() {
		Image unframed = anImageFromResource("ch3_lambda_programming/imageUnframed.png");
		Image framed = anImageFromResource("ch3_lambda_programming/imageFramed.png");

		int imgWidth = (int) unframed.getWidth();
		int imgHeight = (int) unframed.getHeight();

		Image transformed = transform(unframed,
				addingFrame(imgWidth, imgHeight, FRAME_COLOR, FRAME_THICKNESS));

		assertThat(transformed, isEqualPixelByPixelTo(framed));
	}

	private Image anImageFromResource(String resourceName) {
		return new Image(getClass().getClassLoader().getResourceAsStream(resourceName));
	}

}
