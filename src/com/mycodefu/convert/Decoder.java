package com.mycodefu.convert;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Decoder {
public static List<String> decode(BufferedImage img) {
	int width = img.getWidth();
	int height = img.getHeight();
	List<String> result = new ArrayList<>();
	result.add("[{" + width + ",type:wid}]");
	for(int x = 0; x < width; x++) {
		for(int y = 0; y < height; y++) {
			String val = "[{" + img.getRGB(x, y) + ",type:pixcol}]";
			result.add(val);
		}
	}
	result.add("[{" + height + ",type:hei}]");
	return	 result;
}
private Decoder() {}
}
