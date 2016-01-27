package pl.jojczykp.java8_katas.ch1_streams;

import java.io.File;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise2 {

	public Set<String> listAllSubdirsOnlyIn(File dir) {
		return Arrays.stream(
				dir.listFiles(File::isDirectory))
				.map(File::getName)
				.collect(Collectors.toSet());
	}

}
