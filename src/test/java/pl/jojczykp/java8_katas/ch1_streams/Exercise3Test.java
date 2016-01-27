package pl.jojczykp.java8_katas.ch1_streams;

import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static pl.jojczykp.java8_katas.ch1_streams.MockingFilesTools.aDir;
import static pl.jojczykp.java8_katas.ch1_streams.MockingFilesTools.aFile;

public class Exercise3Test {

	private Exercise3 testee = new Exercise3();

	@Test
	public void shouldListFilesByExtension() throws URISyntaxException {
		File root = aDir("root",
				aFile("file1.abc"),
				aFile("file2.xyz"),
				aFile("file3.abc"),
				aFile("file4.xyz"));

		Iterable<String> files = testee.listFilesByExtensionIn(root, "abc");

		assertThat(files, containsInAnyOrder("file1.abc", "file3.abc"));
	}

}
