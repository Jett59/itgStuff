package com.mycodefu.convert;

import java.awt.image.BufferedImage;

import com.mycodefu.itgTools.ITGException;
import com.mycodefu.itgTools.ITGImage;
import com.mycodefu.read.ImageReader;

public class Converter {
public static ITGImage convert(BufferedImage img) throws ITGException{
	return ImageReader.read(img);
}

private Converter() {}
}
