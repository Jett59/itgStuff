package com.mycodefu.itgTools;

public class ITGException extends Exception{
public ITGException() {
	super();
}
public ITGException(String message) {
	super(message);
}
public ITGException(Exception e) {
	super(e.getMessage());
}
}
