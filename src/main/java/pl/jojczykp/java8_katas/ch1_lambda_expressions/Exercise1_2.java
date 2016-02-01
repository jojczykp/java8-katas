package pl.jojczykp.java8_katas.ch1_lambda_expressions;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise1_2 {

	public Set<String> getAllSubDirsOnlyIn(File dir) {
		return Stream.of(dir.listFiles(File::isDirectory))
				.map(File::getName)
				.collect(Collectors.toSet());
	}

}
