package com.wjf.github.ffmpeg_java.util;

public enum FFMPEGKind {
	VIDEO("v"),
	AUDIO("a");

	private final String name;

	FFMPEGKind(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}
}
