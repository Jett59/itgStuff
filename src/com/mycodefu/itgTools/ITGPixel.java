package com.mycodefu.itgTools;

public class ITGPixel {
private int x;
private int y;
private Integer value;
public Integer getValue() {
	return value;
}
public void setValue(Integer value) {
	this.value = value;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public ITGPixel(int x, int y, Integer value) {
	this.x = x;
	this.y = y;
	this.value = value;
}
@Override
public String toString() {
	return "x:" + x + ",y:" + y + ",val:" + value;
}
}
