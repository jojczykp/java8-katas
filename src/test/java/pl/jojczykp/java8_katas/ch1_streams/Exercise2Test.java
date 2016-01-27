package pl.jojczykp.java8_katas.ch1_streams;

import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class Exercise2Test {

	private Exercise2 testee = new Exercise2();

	@Test
	public void shouldListAllSubdirsOnly() throws URISyntaxException {
		String root = getClass().getResource("/").toURI().getPath();
		File dir = new File(root + Paths.get("ch1_streams", "ex2"));

		Iterable<String> subdirs = testee.listAllSubdirsOnlyIn(dir);

		assertThat(subdirs, containsInAnyOrder("dir1", "dir2"));
	}

}
