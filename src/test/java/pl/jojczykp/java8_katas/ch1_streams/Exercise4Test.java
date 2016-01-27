package pl.jojczykp.java8_katas.ch1_streams;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static pl.jojczykp.java8_katas.ch1_streams.MockingFilesTools.aDir;
import static pl.jojczykp.java8_katas.ch1_streams.MockingFilesTools.aFile;

public class Exercise4Test {

	private Exercise4 testee = new Exercise4();

	@Test
	public void shouldListFilesByExtension() {
		File root = aDir("root",
				aDir("subDir2"),
				aFile("file1.txt"),
				aDir("subDir1"),
				aFile("file2.txt"));

		List<String> sorted = testee.sort(root);

		assertThat(sorted, contains("subDir1", "subDir2", "file1.txt", "file2.txt"));
	}

}
