package com.wjf.github.ffmpeg_java.util;

public interface Code {

	default Code get(){
		return this;
	}

	String getCode();

}
