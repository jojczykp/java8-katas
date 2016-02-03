package pl.jojczykp.java8_katas.ch3_lambda_programming;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_6_PassingParametrizedFunction.transform;
import static pl.jojczykp.java8_katas.tools.ImageTools.anImageFromResource;
import static pl.jojczykp.java8_katas.tools.IsEqualPixelByPixelTo.isEqualPixelByPixelTo;

public class Exercise_3_6_PassingParametrizedFunctionTest {

	private static final double NEW_OPACITY = 0.5;

	@BeforeClass
	public static void initializeJavaFX() {
		new JFXPanel();
	}

	@Test
	public void shouldSetOpacity() {
		Image normal = anImageFromResource("ch3_lambda_programming/image.png");
		Image expected = anImageFromResource("ch3_lambda_programming/imageWithHalfOpacity.png");

		Image transformed = transform(normal,
				(Color oldColor, Double newOpacity) -> new Color(
						oldColor.getRed(),
						oldColor.getGreen(),
						oldColor.getBlue(),
						newOpacity),
				NEW_OPACITY);

		assertThat(transformed, isEqualPixelByPixelTo(expected));
	}

}
