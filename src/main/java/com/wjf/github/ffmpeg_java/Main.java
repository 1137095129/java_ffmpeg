package com.wjf.github.ffmpeg_java;

import com.wjf.github.ffmpeg_java.util.FFMPEGUtil;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

		FFMPEGUtil ffmpegUtil = new FFMPEGUtil();
		ffmpegUtil.flvToMP4("C:\\Users\\pc\\Desktop\\red5-server\\webapps\\oflaDemo\\streams\\BladeRunner2049.flv","D:\\test\\test.mp4")
				.startWithWaitFor();

	}
}
