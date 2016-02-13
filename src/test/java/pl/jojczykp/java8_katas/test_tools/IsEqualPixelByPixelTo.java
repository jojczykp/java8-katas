package pl.jojczykp.java8_katas.test_tools;

import javafx.scene.image.Image;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import static java.util.stream.IntStream.range;

public class IsEqualPixelByPixelTo extends BaseMatcher<Image> {

	@Factory
	public static Matcher<? super Image> isEqualPixelByPixelTo(Image expected) {
		return new IsEqualPixelByPixelTo(expected);
	}

	private Image expected;
	private int width;
	private int height;

	public IsEqualPixelByPixelTo(Image expected) {
		this.expected = expected;
		this.width = (int) expected.getWidth();
		this.height = (int) expected.getHeight();
	}

	@Override
	public boolean matches(Object o) {
		if (!(o instanceof Image)) {
			return false;
		}

		Image current = (Image) o;

		return sizesMatchWith(current) && pixelsMatchWith(current);
	}

	@Override
	public void describeTo(Description description) {
		description.appendText(
				"all pixels in both images should have the same color respectively");
	}

	private boolean sizesMatchWith(Image current) {
		return current.getWidth() == width &&
		current.getHeight() == height;
	}

	private boolean pixelsMatchWith(Image current) {
		return range(0, width).allMatch(x -> range(0, height).allMatch(y ->
		current.getPixelReader().getArgb(x, y) ==
		expected.getPixelReader().getArgb(x, y)));
	}

}
