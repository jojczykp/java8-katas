package pl.jojczykp.java8_katas.ch1_lambda_expressions;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static pl.jojczykp.java8_katas.tools.MockingFilesTools.aDir;
import static pl.jojczykp.java8_katas.tools.MockingFilesTools.aFile;

public class Exercise_1_4_FilterMapCollectTest {

	private Exercise_1_4_FilterMapCollect testee = new Exercise_1_4_FilterMapCollect();

	@Test
	public void shouldGetFilesByExtension() {
		File root = aDir("root",
				aDir("subDir2"),
				aFile("file1.txt"),
				aDir("subDir1"),
				aFile("file2.txt"));

		List<String> sorted = testee.sort(root);

		assertThat(sorted, contains("subDir1", "subDir2", "file1.txt", "file2.txt"));
	}

	@Test
	public void shouldGetEmptyResult() {
		File root = aDir("root");

		List<String> subDirs = testee.sort(root);

		assertThat(subDirs, is(empty()));
	}

}
