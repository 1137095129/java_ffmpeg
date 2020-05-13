package com.wjf.github.ffmpeg_java.util;


import java.io.IOException;

public class FFMPEGUtil {

	private CommandUtil command = new CommandUtil();

	private FFMPEGUtil addCommand(String comm){
		command.addCommand(comm);
		return this;
	}

	public FFMPEGUtil flvToMP4(String flvPath,String mp4Path){
		this.addCommand("ffmpeg")
				.addCommand("-i")
				.addCommand(flvPath)
				.addCommand("-vcodec")
				.addCommand("copy")
				.addCommand("-acodec")
				.addCommand("copy")
				.addCommand(mp4Path);
		return this;
	}

	//开始
	public FFMPEGUtil start(){
		this.addCommand("ffmpeg");
		return this;
	}

	//设置输入文件路径
	public FFMPEGUtil setFileInput(String inputPath){
		this.addCommand("-i")
				.addCommand(inputPath);
		return this;
	}

	//设置视屏编码
	public FFMPEGUtil setVideoCode(FFMPEGVideoCodec codec){
		this.addCommand("-vcodec")
				.addCommand(codec.getCodec());
		return this;
	}

	//设置音频编码
	public FFMPEGUtil setAudioCode(FFMPEGAudioCodec codec){
		this.addCommand("-acodec")
				.addCommand(codec.getCode());
		return this;
	}



	public void startWithWaitFor() throws IOException {
		command.startWithWaitFor();
	}

	public void startWithOutWaitFor() throws IOException {
		command.startWithOutWaitFor();
	}

}
