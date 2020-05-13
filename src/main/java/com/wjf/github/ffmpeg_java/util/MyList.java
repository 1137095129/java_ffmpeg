package com.wjf.github.ffmpeg_java.util;

import java.util.ArrayList;

public class MyList<T> extends ArrayList<T> {

	public MyList<T> addAndRe(T t){
		add(t);
		return this;
	}

}
