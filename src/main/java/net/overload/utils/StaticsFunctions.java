package net.overload.utils;

import java.io.File;

import net.overload.logger.Log;
import net.overload.logger.LogLevel;
import net.overload.minecraft.MinecraftServer;

public class StaticsFunctions {

	public static void newLobby() {
		try {
			MinecraftServer ms = new MinecraftServer(null, "lobby", null);
			ms.generateRandomName();
			ms.generateRandomPort();
			ms.addDefaults();
			ms.getMinecraftOptions().getPlugins().addPlugin(new File("./Files/plugin-lobby.jar"));
			ms.getMinecraftOptions().getWorld().setWorld(new File("./Files/world-lobby/"));
			if (ms.create()) ms.start(); else new Log(LogLevel.ERROR, ms.getServerName(), "Server not created");
		} catch (Exception e) {
			e.printStackTrace();
			new Log(LogLevel.ERROR, "Server not created");
		}
	}
	
	public static void newVoid( ) {
		MinecraftServer ms = new MinecraftServer(null, "void", null);
		ms.generateRandomName();
		ms.generateRandomPort();
		ms.addDefaults();
		ms.getMinecraftOptions().getPlugins().addPlugin(new File("./Files/worldedit.jar"));
		if (ms.create()) ms.start(); else new Log(LogLevel.ERROR, ms.getServerName(), "Server not created");
	}
	
	public static void newWE( ) {
		MinecraftServer ms = new MinecraftServer(null, "we", null);
		ms.getMinecraftOptions().getServerProperties().setGamemode(1);
		ms.getMinecraftOptions().getServerProperties().setForceGamemode(true);
		ms.generateRandomName();
		ms.generateRandomPort();
		ms.addDefaults();
		ms.getMinecraftOptions().getPlugins().addPlugin(new File("./Files/worldedit.jar"));
		if (ms.create()) ms.start(); else new Log(LogLevel.ERROR, ms.getServerName(), "Server not created");
	}
	
}
