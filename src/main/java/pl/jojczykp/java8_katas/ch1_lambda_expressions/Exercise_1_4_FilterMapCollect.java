package pl.jojczykp.java8_katas.ch1_lambda_expressions;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise_1_4_FilterMapCollect {

	public List<String> sort(File dir) {
		return Stream.of(dir.listFiles())
				.sorted((f1, f2) -> {
					if (f1.isDirectory() == f2.isDirectory()) {
						return f1.getName().compareTo(f2.getName());
					} else {
						return f1.isDirectory() ? -1 : 1;
					}
				})
				.map(File::getName)
				.collect(Collectors.toList());
	}

}
