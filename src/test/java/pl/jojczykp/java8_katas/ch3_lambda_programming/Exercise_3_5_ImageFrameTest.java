package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_5_ImageFrame.transform;
import static pl.jojczykp.java8_katas.tools.IsEqualPixelByPixelTo.isEqualPixelByPixelTo;

public class Exercise_3_5_ImageFrameTest {

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

		int width = (int) unframed.getWidth();
		int height = (int) unframed.getHeight();

		Image transformed = transform(unframed,
				color -> FRAME_COLOR,
				(x, y) ->
						x < FRAME_THICKNESS || x >= width - FRAME_THICKNESS ||
						y < FRAME_THICKNESS || y >= height - FRAME_THICKNESS);

		assertThat(transformed, isEqualPixelByPixelTo(framed));
	}

	private Image anImageFromResource(String resourceName) {
		return new Image(getClass().getClassLoader().getResourceAsStream(resourceName));
	}

}
