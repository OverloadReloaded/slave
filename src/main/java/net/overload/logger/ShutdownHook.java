package net.overload.logger;

import java.util.Timer;
import java.util.TimerTask;

import net.overload.utils.StaticsVariables;

public class ShutdownHook {

	public void start() {
		new Log(LogLevel.INFO, "Starting the ShutdownHook...").send();
		try {
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					//StaticsVariables.redis.getJedis().publish("toAllServers", "closeServer");
					Timer t = new Timer();
					t.schedule(new TimerTask() {
						public void run() {
							try {
								new Log().line();
								new Log(LogLevel.INFO, "Deleting servers files...").send();
								//FileUtils.deleteDirectory(new File("./Servers"));
								new Log(LogLevel.SUCCESS, "Deleted servers files done!").send();
							} catch (Exception e) {
								new Log(LogLevel.ERROR, "Error while deleting MinecraftServers.").send();
								if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
								if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
							}
						}
					}, 3000L);
				}
			});
			new Log(LogLevel.SUCCESS, "ShutdownHook started!").send();
		} catch (Exception e) {
			new Log(LogLevel.ERROR, "Error while starting the ShutdownHook.").send();
			if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
			if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
			System.exit(2);
		}
	}
}
