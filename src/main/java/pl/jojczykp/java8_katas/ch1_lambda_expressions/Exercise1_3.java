package pl.jojczykp.java8_katas.ch1_lambda_expressions;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise1_3 {

	public Set<String> getFilesByExtensionIn(File dir, String ext) {
		return Stream.of(dir.list())
				.filter(s -> s.endsWith("." + ext))
				.collect(Collectors.toSet());
	}

}
