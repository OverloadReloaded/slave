package net.overload.logger;

import net.overload.utils.Utils;

public class Log {
	private String msg = "";

	public Log() {
	}

	public Log(String message) {
		setMessage("[" + Utils.getCurrentTime() + "] " + message);
	}

	public Log(LogLevel level, String message) {
		setMessage("[" + Utils.getCurrentTime() + "] " + level.getLevel() + message);
	}

	public Log(LogLevel level, String inBracket, String message) {
		setMessage("[" + Utils.getCurrentTime() + "] \033[33;1m[" + inBracket + "] \033[0m" + level.getLevel() + message);
	}

	public void send() {
		System.out.println(getMessage());
	}

	public void line() {
		System.out.println(" ");
	}

	public String getMessage() {
		return this.msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}
}
