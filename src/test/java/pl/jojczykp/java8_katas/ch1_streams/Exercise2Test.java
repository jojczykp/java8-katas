package pl.jojczykp.java8_katas.ch1_streams;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static pl.jojczykp.java8_katas.ch1_streams.MockingFilesTools.aDir;
import static pl.jojczykp.java8_katas.ch1_streams.MockingFilesTools.aFile;

public class Exercise2Test {

	private Exercise2 testee = new Exercise2();

	@Test
	public void shouldListAllSubDirsOnly() {
		File root =
				aDir("root",
						aDir("subDir1"),
						aDir("subDir2"),
						aFile("file1.txt"),
						aFile("file2.txt"));

		Iterable<String> subDirs = testee.listAllSubDirsOnlyIn(root);

		assertThat(subDirs, containsInAnyOrder("subDir1", "subDir2"));
	}

}
