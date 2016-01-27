package pl.jojczykp.java8_katas.ch1_streams;

import java.io.File;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise3 {

	public Set<String> listFilesByExtensionIn(File dir, String ext) {
		return Arrays.stream(dir.list())
				.filter(s -> s.endsWith("." + ext))
				.collect(Collectors.toSet());
	}

}
