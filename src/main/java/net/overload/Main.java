package net.overload;

import net.overload.config.OverloadConfiguration;
import net.overload.logger.CommandReader;
import net.overload.logger.Log;
import net.overload.logger.LogLevel;
import net.overload.logger.ShutdownHook;
import net.overload.redis.OverloadRedis;
import net.overload.utils.StaticsVariables;

public class Main {

	public static String version = "b0.0.1";
	
	public static void main(String[] args) {
		new Log(LogLevel.INFO, "Starting the Overload System!").send();
		new Log(LogLevel.INFO, "Current version: " + version).send();
		new Log().line();
		
		startConfig();
		new Log().line();
		
		startRedis();
		new Log().line();
		
		new ShutdownHook().start();
		
		StaticsVariables.commandReader = new CommandReader();
		StaticsVariables.commandReader.start();
	}
	
	private static void startConfig() {
		try {
			StaticsVariables.config = new OverloadConfiguration("redis.properties");
			StaticsVariables.config.check();
		} catch (Exception e) {
			new Log(LogLevel.CRITICAL, "Config", "Could not start the configuration check. Please contact administrators or developers.").send();
			new Log(LogLevel.STACK_TRACE, "Config", e.getStackTrace().toString()).send();
		}
	}
	
	private static void startRedis() {
		try {
			StaticsVariables.redis = new OverloadRedis();
			StaticsVariables.redis.connect();
			
			new Thread(new Runnable() {
				public void run() {
					StaticsVariables.redis.subscribe();
				}
			}).start();
		} catch (Exception e) {
			new Log(LogLevel.CRITICAL, "Redis", "Error with Redis Please contact administrators or developers.").send();
			new Log(LogLevel.STACK_TRACE, "Redis", e.getStackTrace().toString()).send();
		}
	}

}


