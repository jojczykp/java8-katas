package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_05_PassingFunctions.transform;
import static pl.jojczykp.java8_katas.test_tools.ImageTools.anImageFromResource;
import static pl.jojczykp.java8_katas.test_tools.IsEqualPixelByPixelToMatcher.isEqualPixelByPixelTo;

public class Exercise_3_05_PassingFunctionsTest {

	private static final Color FRAME_COLOR = Color.BLACK;
	private static final int FRAME_THICKNESS = 3;

	@BeforeClass
	public static void initializeJavaFX() {
		new JFXPanel();
	}

	@Test
	public void shouldPaintFrame() {
		Image normal = anImageFromResource("ch3_lambda_programming/image.png");
		Image expected = anImageFromResource("ch3_lambda_programming/imageFramed.png");

		int width = (int) normal.getWidth();
		int height = (int) normal.getHeight();

		Image transformed = transform(normal,
				color -> FRAME_COLOR,
				(x, y) ->
						x < FRAME_THICKNESS || x >= width - FRAME_THICKNESS ||
						y < FRAME_THICKNESS || y >= height - FRAME_THICKNESS);

		assertThat(transformed, isEqualPixelByPixelTo(expected));
	}

}
