package pl.jojczykp.java8_katas.ch2_streams;

import java.util.stream.Stream;

public final class Exercise2_10 {

	private Exercise2_10() {
	}

	public static double averageOf(Stream<Double> stream) {
		return stream
				.parallel().unordered()
				.reduce(
						new Summary(0, 0.0),
						(summary, val) -> new Summary(
								summary.cnt + 1,
								(summary.sum() + val) / (summary.cnt + 1)),
						(s1, s2) -> new Summary(
								s1.cnt + s2.cnt,
								(s1.sum() + s2.sum()) / (s1.cnt + s2.cnt))
		).avg;
	}

	private static class Summary {
		//CHECKSTYLE.OFF: VisibilityModifier
		int cnt;
		double avg;
		//CHECKSTYLE.ON: VisibilityModifier

		Summary(int cnt, double avg) {
			this.cnt = cnt;
			this.avg = avg;
		}

		double sum() {
			return cnt * avg;
		}
	}

}
