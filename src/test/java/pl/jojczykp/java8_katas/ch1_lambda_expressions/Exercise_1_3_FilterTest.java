package pl.jojczykp.java8_katas.ch1_lambda_expressions;

import org.junit.Test;

import java.io.File;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static pl.jojczykp.java8_katas.test_tools.MockingFilesTools.aDir;
import static pl.jojczykp.java8_katas.test_tools.MockingFilesTools.aFile;

public class Exercise_1_3_FilterTest {

	private Exercise_1_3_Filter testee = new Exercise_1_3_Filter();

	@Test
	public void shouldGetFilesByExtension() {
		File root = aDir("root",
				aFile("file1.abc"),
				aFile("file2.xyz"),
				aFile("file3.abc"),
				aFile("file4.xyz"));

		Set<String> files = testee.getFilesByExtensionIn(root, "abc");

		assertThat(files, containsInAnyOrder("file1.abc", "file3.abc"));
	}

	@Test

	public void shouldGetEmptyResultForNonEmptyDirectory() {
		File root = aDir("root",
				aFile("file1.abc"),
				aFile("file2.abc"));

		Set<String> subDirs = testee.getFilesByExtensionIn(root, "xyz");

		assertThat(subDirs, is(empty()));
	}
	@Test
	public void shouldGetEmptyResultForEmptyDirectory() {
		File root = aDir("root");

		Set<String> subDirs = testee.getFilesByExtensionIn(root, "any");

		assertThat(subDirs, is(empty()));
	}

}
