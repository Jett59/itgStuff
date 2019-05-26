package com.mycodefu.read;

import java.awt.image.BufferedImage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mycodefu.convert.Decoder;
import com.mycodefu.itgTools.ITGException;
import com.mycodefu.itgTools.ITGImage;

public class ImageReader {
	public static ITGImage read() throws ITGException{
		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(Paths.get("image.itg"));
			}catch(Exception e){
				throw new ITGException(e);
			}
		return read(lines);
			}
	public static ITGImage read(BufferedImage img) throws ITGException {
		return ITGImage.fromBufferedImage(img);
	}
	public static ITGImage read(List<String> ITGLines) throws ITGException{
		String total = "";
		for(String s : ITGLines) {
			total += s;
		}
		List<String> nums = new ArrayList<>();
		Pattern pattern = Pattern.compile("\\[\\{(.*?),type:(.*?)\\}\\]");
		Matcher matcher = pattern.matcher(total);
		String col = "pixcol";
		String wid = "wid";
		String hei = "hei";
		while(matcher.find()) {
			String name = matcher.group(1);
			String type = matcher.group(2);
			if(type.equals	(col)) {
				nums.add(name);
			}
			if(type.equals(wid)) {
				wid = name;
			}
			if(type.equals(hei)) {
				hei = name;
			}
		}
		if(nums.size() < 1) {
			throw new ITGException("no matches were found for type: pixcol");
		}
		if(wid.equals("wid")) {
			throw new ITGException("no matches were found for type: wid");
		}
		if(hei.equals("hei")) {
			throw new ITGException("no matches were found for type: hei");
		}
		List<Integer> ints = new ArrayList<>();
		for(String s : nums) {
			ints.add(Integer.parseInt(s));
		}
		int w = Integer.parseInt(wid);
		int h = Integer.parseInt(hei);
		if(ints.size() < w*h) {
			throw new ITGException("not enough pixels were found, pixels: "+ints.size()+", width: "+w+", height: "+h);
		}
		return new ITGImage(w, h, ints);
	}
private ImageReader() {}
}
