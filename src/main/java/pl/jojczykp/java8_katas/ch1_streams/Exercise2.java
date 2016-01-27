package pl.jojczykp.java8_katas.ch1_streams;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise2 {

	public Set<String> listAllSubDirsOnlyIn(File dir) {
		return Stream.of(dir.listFiles(File::isDirectory))
				.map(File::getName)
				.collect(Collectors.toSet());
	}

}
