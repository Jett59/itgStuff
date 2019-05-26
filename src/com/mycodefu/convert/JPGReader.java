package com.mycodefu.convert;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class JPGReader{
public static BufferedImage getImage() throws Exception{
	BufferedImage image = ImageIO.read(new File("image.jpg"));
	return image;
}
}