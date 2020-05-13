package com.wjf.github.ffmpeg_java.util;

public enum FFMPEGCoverOption {

	//直接覆盖
	COVER_NOT_ASK("-y"),
	//退出、不覆盖
	NOT_COVER_AND_BREAK("-n");

	private final String name;

	FFMPEGCoverOption(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
