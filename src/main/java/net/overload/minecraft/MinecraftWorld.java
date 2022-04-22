package net.overload.minecraft;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import net.overload.logger.Log;
import net.overload.logger.LogLevel;
import net.overload.utils.StaticsVariables;

public class MinecraftWorld {
	private File world = null;

	private File serverDirectory;

	public MinecraftWorld() {
		this.world = null;
	}

	public MinecraftWorld(File world) {
		this.world = world;
	}

	public void copyWorld() {
		if (isWorldNotNull()) {
			if (this.world.exists() && this.world.isDirectory()) {
				try {
					FileUtils.copyDirectory(this.world, new File(this.serverDirectory.getPath() + "/world"));
				} catch (IOException e) {
					new Log(LogLevel.ERROR, "Unable to copy the world.").send();
					if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
					if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
				}
			} else new Log(LogLevel.ERROR, "Unable to copy the world.").send();
		} else if (StaticsVariables.config.getDebug()) new Log(LogLevel.DEBUG, "No world to copy.").send();
	}

	public boolean isWorldNotNull() {
		if (this.world != null)
			return true;
		return false;
	}

	public File getServerDirectory() {
		return this.serverDirectory;
	}

	public void setServerDirectory(File serverDirectory) {
		this.serverDirectory = serverDirectory;
	}

	public File getWorld() {
		return this.world;
	}

	public void setWorld(File world) {
		this.world = world;
	}

	@Override
	public String toString() {
		return "MinecraftWorld [world=" + world + ", serverDirectory=" + serverDirectory + "]";
	}
	
}
