package net.overload.minecraft;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import net.overload.logger.Log;
import net.overload.logger.LogLevel;
import net.overload.utils.StaticsVariables;

public class MinecraftPlugins {
	private ArrayList<File> files = new ArrayList<File>();

	private File plContainer;

	public MinecraftPlugins(File plContainer) {
		this.plContainer = plContainer;
	}

	public MinecraftPlugins() {
	}

	public Boolean copyPlugins() {
		try {
			this.plContainer.mkdirs();
		} catch (Exception e) {
			new Log(LogLevel.ERROR, "Unable to create the plugins folder for the server.").send();
			if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
			if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
			return false;
		}
		if (this.plContainer != null) {
			this.plContainer.mkdirs();
			for (File f : this.files) {
				try {
					File pluginFutur = new File(this.plContainer.getAbsolutePath() + "/" + f.getName());
					if (pluginFutur.exists()) {
						if (pluginFutur.length() != f.length()) {
							pluginFutur.delete();
							Files.copy(f.toPath(), pluginFutur.toPath(), new java.nio.file.CopyOption[0]);
						}
						continue;
					}
					Files.copy(f.toPath(), pluginFutur.toPath(), new java.nio.file.CopyOption[0]);
				} catch (IOException e) {
					(new Log(LogLevel.ERROR, "Unable to copy the plugins.")).send();
					if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
					if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
					return false;
				}
			}
		} else {
			new Log(LogLevel.ERROR, "Unable to copy the plugins: The plugin container is null.").send();
			return false;
		}
		return false;
	}

	public Boolean addPlugin(File pl) {
		try {
			if (StaticsVariables.config.getDebug()) new Log(LogLevel.INFO, "Adding plugin to list: " + pl.getName() + ". (Will be copied later)").send();
			if (pl.exists())this.files.add(pl);
			if (StaticsVariables.config.getDebug()) new Log(LogLevel.SUCCESS, "Plugin added to the list!").send();
			return true;
		} catch (Exception e) {
			new Log(LogLevel.ERROR, "Unable to add the plugin to the list.").send();
			if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
			if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
			return false;
		}
	}

	public Boolean removePlugin(File pl) {
		try {
			if (StaticsVariables.config.getDebug()) new Log(LogLevel.INFO, "removing plugin from list: " + pl.getName() + ". (Will be remove later)").send();
			if (this.files.contains(pl) && !pl.getName().contains(StaticsVariables.overloadMinecraftPlugin)) {
				this.files.remove(pl);
				if (StaticsVariables.config.getDebug()) new Log(LogLevel.SUCCESS, "Plugin removed from the list!").send();
				return true;
			}
		} catch (Exception e) {
			(new Log(LogLevel.ERROR, "Unable to remove the plugin from the list.")).send();
			if (StaticsVariables.config.getShowErrorsMessages())new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
			if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
			return false;
		}
		return false;
	}

	public ArrayList<File> getFiles() {
		return this.files;
	}

	public File getPlContainer() {
		return this.plContainer;
	}

	public void setPlContainer(File pl) {
		this.plContainer = pl;
	}

	@Override
	public String toString() {
		return "MinecraftPlugins [files=" + files + ", plContainer=" + plContainer + "]";
	}
	
}
