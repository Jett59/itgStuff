package com.mycodefu.itgTools;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ITGImage implements Iterable<ITGPixel>{
private int width;
private int height;
private List<Integer> pixcols = new ArrayList<>();
public ITGImage(int width, int height, List<Integer> pixcols) {
	this.width = width;
	this.height = height;
	this.pixcols = pixcols;
}
public List<Integer> getData(){
	return pixcols;
}
public int getWidth() {
	return width;
}
public int getHeight() {
	return height;
}
public BufferedImage toBufferedImage() {
	BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	int i = 0;
	for(int x = 0; x < width; x++) {
		for(int y = 0; y < height; y++) {
			img.setRGB(x, y, pixcols.get(i));
			i += 1;
		}
	}
	return img;
}
public static ITGImage fromBufferedImage(BufferedImage img) {
	List<Integer> vals = new ArrayList<>();
	int w = img.getWidth();
	int h = img.getHeight();
	for(int x = 0; x < w; x++) {
		for(int y = 0; y < h; y++) {
vals.add(img.getRGB(x, y));
		}
	}
	return new ITGImage(w, h, vals);
}
@Override
public Iterator<ITGPixel> iterator() {
	return new ITGImageIterator(this);
}
}