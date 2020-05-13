package com.wjf.github.ffmpeg_java.util;

public enum FFMPEGAudioCodec {
	COPY("copy"),
	ACC("acc");

	private final String code;

	FFMPEGAudioCodec(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
