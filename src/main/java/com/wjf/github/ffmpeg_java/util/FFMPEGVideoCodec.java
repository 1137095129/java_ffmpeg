package com.wjf.github.ffmpeg_java.util;

public enum FFMPEGVideoCodec implements Code {

	COPY("copy"),
	H264("h264"),
	MPEG4("mpeg4"),
	LIBX265("libx265"),
	LIBX264("libx264");

	private final String codec;

	FFMPEGVideoCodec(String codec) {
		this.codec = codec;
	}

	public String getCodec() {
		return codec;
	}
}
