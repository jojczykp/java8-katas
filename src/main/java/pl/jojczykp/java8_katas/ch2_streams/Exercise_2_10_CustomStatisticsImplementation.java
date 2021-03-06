package pl.jojczykp.java8_katas.ch2_streams;

import java.util.Optional;
import java.util.stream.Stream;

public class Exercise_2_10_CustomStatisticsImplementation {

	public Optional<Double> averageUsingReduceOf(Stream<Double> stream) {
		Summary summary = stream
				.parallel().unordered()
				.reduce(
						new Summary(0, 0.0),
						(s, val) -> new Summary(
								s.cnt + 1,
								(s.sum() + val) / (s.cnt + 1)),
						(s1, s2) -> new Summary(
								s1.cnt + s2.cnt,
								(s1.sum() + s2.sum()) / (s1.cnt + s2.cnt)));

		return summary.cnt > 0 ?
				Optional.of(summary.avg) :
				Optional.empty();
	}

	@SuppressWarnings("checkstyle:visibilitymodifier")
	private static class Summary {
		int cnt;
		double avg;

		Summary(int cnt, double avg) {
			this.cnt = cnt;
			this.avg = avg;
		}

		double sum() {
			return cnt * avg;
		}
	}

}
