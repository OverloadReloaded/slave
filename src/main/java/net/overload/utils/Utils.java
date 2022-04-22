package net.overload.utils;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import net.overload.config.ServerJsonConfiguration;
import net.overload.logger.Log;
import net.overload.logger.LogLevel;
import net.overload.minecraft.MinecraftServer;

public class Utils {
	public static String getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(cal.getTime()).toString();
	}

	public static void createTextFile(List<String> lines, Path file) {
		try {
			Files.write(file, lines, Charset.forName("UTF-8"), new java.nio.file.OpenOption[0]);
		} catch (Exception e) {
			(new Log(LogLevel.ERROR, "Error while creating file :" + file.toString())).send();
			if (StaticsVariables.config.getPrintStackTrace().booleanValue())
				e.printStackTrace();
			if (StaticsVariables.config.getShowErrorsMessages().booleanValue())
				(new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString())).send();
		}
	}
	
	public static String generateRandomName() {
		String[] id = UUID.randomUUID().toString().split("-");
		return id[2] + "-" + id[1];
	}
	
	@SuppressWarnings("null")
	public static Integer generateRandomPort() {
		Random rand = new Random();
		int randomNum = rand.nextInt(29501) + 500;
		class b { int u; };
		
		int finalport = 0;
		
		b t = null;
		for (Integer i = 500; i <= 50000; i++) {
			new b().u = i;
			i = i + randomNum;
			if (new PortsChecker(i).check()) {
				finalport = i;
				break;
			}
			i = t.u;
		}
		
		return finalport;
	}
	
	public static void startServerFromFile(String fileName) {
		ServerJsonConfiguration j = new ServerJsonConfiguration(new File(fileName + ".json"));
		MinecraftServer s = j.load();
		s.generateRandomName();
		s.generateRandomPort();
		s.addDefaults();
		s.create();
		s.start();
	}
}
