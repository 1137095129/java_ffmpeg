package com.wjf.github.ffmpeg_java.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wjf
 *
 * 调用本地命令工具类
 */
public class CommandUtil {

	private final List<String> command = new ArrayList<>();

	public List<String> getCommand() {
		return Collections.unmodifiableList(command);
	}

	public void addCommand(String commandStr) {
		command.add(commandStr);
	}

	public void addCommand(String... commandStr) {
		Collections.addAll(command, commandStr);
	}

	public void startWithWaitFor() throws IOException {
		//调用本地命令
		ProcessBuilder processBuilder = new ProcessBuilder();
		//开始本地命令并重定向错误信息流
		Process process = processBuilder.command(command).redirectErrorStream(true).start();
		//将两个输出流分开
		new ProcessInput(process.getInputStream()).start();
		new ProcessInput(process.getErrorStream()).start();
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void startWithOutWaitFor() throws IOException {
		//调用本地命令
		ProcessBuilder processBuilder = new ProcessBuilder();
		//开始本地命令并重定向错误信息流
		Process process = processBuilder.command(command).redirectErrorStream(true).start();
		//将两个输出流分开
		new ProcessInput(process.getInputStream()).start();
		new ProcessInput(process.getErrorStream()).start();
	}

	private class ProcessInput extends Thread {

		InputStream inputStream;

		ProcessInput(InputStream inputStream) {
			this.inputStream = inputStream;
		}

		@Override
		public void run() {
			try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
				int i;
				byte[] bytes = new byte[1024];
				while ((i = inputStream.read(bytes)) > 0) {
					baos.write(bytes, 0, i);
				}
				byte[] byteArray = baos.toByteArray();
				String s = new String(byteArray, Charset.forName("GBK"));
				System.out.println(s);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
}
