package pl.jojczykp.java8_katas.ch1_streams;

import org.junit.Test;

import java.io.File;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static pl.jojczykp.java8_katas.tools.MockingFilesTools.aDir;
import static pl.jojczykp.java8_katas.tools.MockingFilesTools.aFile;

public class Exercise3Test {

	private Exercise3 testee = new Exercise3();

	@Test
	public void shouldListFilesByExtension() {
		File root = aDir("root",
				aFile("file1.abc"),
				aFile("file2.xyz"),
				aFile("file3.abc"),
				aFile("file4.xyz"));

		Set<String> files = testee.listFilesByExtensionIn(root, "abc");

		assertThat(files, containsInAnyOrder("file1.abc", "file3.abc"));
	}

	@Test

	public void shouldReturnEmptyResultForNonEmptyDirectory() {
		File root = aDir("root",
				aFile("file1.abc"),
				aFile("file2.abc"));

		Set<String> subDirs = testee.listFilesByExtensionIn(root, "xyz");

		assertThat(subDirs, is(empty()));
	}
	@Test
	public void shouldReturnEmptyResultForEmptyDirectory() {
		File root = aDir("root");

		Set<String> subDirs = testee.listFilesByExtensionIn(root, "any");

		assertThat(subDirs, is(empty()));
	}

}
