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

	//设置覆盖选项（这是一个全局设置）
	public FFMPEGUtil setCoverOption(){
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

	//设置指定流的编码方式
	public FFMPEGUtil setCode(FFMPEGCode code){
		this.addCommand("-codec:"+code.getKind().getName()+":"+code.getIndex())
				.addCommand(code.getCode().get().getCode());
		return this;
	}

	//设置输入、输出文件帧率
	//输入时：仅为了建议raw格式数据，这里的输入文件必须是raw格式的输入文件
	public FFMPEGUtil setFrameRate(Integer frameRate){
		this.addCommand("-r")
				.addCommand(frameRate+"");
		return this;
	}

	//设置输出文件的码率
	public FFMPEGUtil setBitRate(String bitRate){
		this.addCommand("-b:v")
				.addCommand(bitRate)
				.addCommand("-bufsize")
				.addCommand(bitRate);
		return this;
	}

	public void startWithWaitFor() throws IOException {
		command.startWithWaitFor();
	}

	public void startWithOutWaitFor() throws IOException {
		command.startWithOutWaitFor();
	}

}
