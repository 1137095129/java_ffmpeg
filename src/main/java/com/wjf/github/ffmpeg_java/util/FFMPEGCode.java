package com.wjf.github.ffmpeg_java.util;

public class FFMPEGCode {

	private final Code code;

	private final Integer index;

	private final FFMPEGKind kind;

	public FFMPEGCode(Code code, Integer index, FFMPEGKind kind) {
		this.code = code;
		this.index = index;
		this.kind = kind;
	}

	public Code getCode() {
		return code;
	}

	public FFMPEGKind getKind() {
		return kind;
	}

	public Integer getIndex() {
		return index;
	}
}
