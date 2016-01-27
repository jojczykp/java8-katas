package pl.jojczykp.java8_katas.tools;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.stream.Stream;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public abstract class MockingFilesTools {

	public static File aFile(String name) {
		File file = mock(File.class);
		when(file.getName()).thenReturn(name);
		when(file.isDirectory()).thenReturn(false);

		return file;
	}

	public static File aDir(String dirName, File... files) {
		String[] names = Stream.of(files).map(File::getName).toArray(String[]::new);

		File dir = mock(File.class);
		when(dir.getName()).thenReturn(dirName);
		when(dir.isDirectory()).thenReturn(true);

		mockList(dir, names);
		mockListFiles(dir, files);

		return dir;
	}

	private static void mockList(File dir, String[] names) {
		when(dir.list()).thenReturn(names);
		when(dir.list(any(FilenameFilter.class))).thenAnswer(invocationOnMock ->
				Stream.of(names)
						.filter(n -> invocationOnMock.getArgumentAt(0, FilenameFilter.class).accept(dir, n))
						.toArray(String[]::new));
	}

	private static void mockListFiles(File dir, File[] files) {
		when(dir.listFiles()).thenReturn(files);
		when(dir.listFiles(any(FilenameFilter.class))).thenAnswer(invocationOnMock ->
				Stream.of(files)
						.filter(f -> invocationOnMock.getArgumentAt(0, FilenameFilter.class).accept(dir, f.getName()))
						.toArray(File[]::new));
		when(dir.listFiles(any(FileFilter.class))).thenAnswer(invocationOnMock ->
				Stream.of(files)
						.filter(invocationOnMock.getArgumentAt(0, FileFilter.class)::accept)
						.toArray(File[]::new));
	}
}
