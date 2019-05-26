package com.mycodefu.itgTools;

import java.util.Iterator;
import java.util.List;

public class ITGImageIterator implements Iterator<ITGPixel>{
	List<Integer> data;
	int width;
	int height;
	int x = 0;
	int y = 0;
	int index = 0;
	@Override
	public boolean hasNext() {
		return index < data.size();
	}
	@Override
	public ITGPixel next() {
		Integer value = data.get(index);
		index++;
		ITGPixel pix = new ITGPixel(x, y, value);
		if(y >= height) {
			y = 0;
			x++;
		}else {
			y++;
		}
		return pix;
	}
public ITGImageIterator(ITGImage img) {
	data = img.getData();
	width = img.getWidth();
	height = img.getHeight();
}
}
