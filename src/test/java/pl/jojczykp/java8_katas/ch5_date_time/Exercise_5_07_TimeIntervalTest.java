package pl.jojczykp.java8_katas.ch5_date_time;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static pl.jojczykp.java8_katas.ch5_date_time.Exercise_5_07_TimeInterval.anIntervalOf;

public class Exercise_5_07_TimeIntervalTest {

	//CHECKSTYLE.OFF: MagicNumber

	@Test
	public void shouldOverlapIfOnlyBeginningInside() {
		assertTrue(
				anIntervalOf(10, 0, 11, 0).overlaps(anIntervalOf(10, 30, 11, 30))
		);
	}

	@Test
	public void shouldOverlapIfOnlyEndInside() {
		assertTrue(
				anIntervalOf(10, 0, 11, 0).overlaps(anIntervalOf(9, 30, 10, 30))
		);
	}

	@Test
	public void shouldOverlapIfBeginningAndEndInside() {
		assertTrue(
				anIntervalOf(10, 0, 11, 0).overlaps(anIntervalOf(10, 15, 10, 45))
		);
	}

	@Test
	public void shouldOverlapIfBeginningAndEndOutside() {
		assertTrue(
				anIntervalOf(10, 0, 11, 0).overlaps(anIntervalOf(9, 0, 12, 0))
		);
	}

	@Test
	public void shouldOverlapIfBeginningTouchesEnd() {
		assertTrue(
				anIntervalOf(10, 0, 11, 0).overlaps(anIntervalOf(9, 0, 10, 0))
		);
	}

	@Test
	public void shouldOverlapIfEndTouchesBeginning() {
		assertTrue(
				anIntervalOf(10, 0, 11, 0).overlaps(anIntervalOf(11, 0, 12, 0))
		);
	}

	@Test
	public void shouldNotOverlapIfBeginningAndEndBefore() {
		assertFalse(
				anIntervalOf(10, 0, 11, 0).overlaps(anIntervalOf(8, 0, 9, 0))
		);
	}

	@Test
	public void shouldNotOverlapIfBeginningAndEndAfter() {
		assertFalse(
				anIntervalOf(10, 0, 11, 0).overlaps(anIntervalOf(12, 0, 13, 0))
		);
	}

	//CHECKSTYLE.ON: MagicNumber

}
