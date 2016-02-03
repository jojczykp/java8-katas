package pl.jojczykp.java8_katas.tools;

import javafx.scene.image.Image;

public final class ImageTools {

	private ImageTools() {
	}

	public static Image anImageFromResource(String resourceName) {
		return new Image(ImageTools.class.getClassLoader().getResourceAsStream(resourceName));
	}

}
