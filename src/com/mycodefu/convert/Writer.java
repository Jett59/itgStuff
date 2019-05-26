package com.mycodefu.convert;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Writer {
	public static void write() throws Exception {
		BufferedImage image = JPGReader.getImage();
		write(image);
	}
	public static void write(BufferedImage image) throws Exception{
		Path path = Paths.get("details.itg");
		BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
		writer.write("itgdata:");
		writer.write("[{"+image.getWidth()+",type:wid}]");
		int count=0;
		for(int x = 0; x < image.getWidth(); x++) {
			for(int y = 0; y < image.getHeight(); y++) {
				String s = "[{"+image.getRGB(x, y)+",type:pixcol}]";
				writer.write(s);
				count++;
			}
		}
		writer.write("[{"+image.getHeight()+",type:hei}]");
		System.out.println("added all of the values, there are "+count);
		System.out.println("all finished!");
		writer.close();
	}
	private Writer() {}
}
