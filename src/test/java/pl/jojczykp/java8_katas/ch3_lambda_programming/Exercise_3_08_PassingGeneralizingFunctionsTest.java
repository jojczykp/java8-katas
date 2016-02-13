package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_08_PassingGeneralizingFunctions.framing;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_08_PassingGeneralizingFunctions.transform;
import static pl.jojczykp.java8_katas.test_tools.ImageTools.anImageFromResource;
import static pl.jojczykp.java8_katas.test_tools.IsEqualPixelByPixelTo.isEqualPixelByPixelTo;

public class Exercise_3_08_PassingGeneralizingFunctionsTest {

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

		int imgWidth = (int) normal.getWidth();
		int imgHeight = (int) normal.getHeight();

		Image transformed = transform(normal,
				framing(imgWidth, imgHeight, FRAME_COLOR, FRAME_THICKNESS));

		assertThat(transformed, isEqualPixelByPixelTo(expected));
	}

}
