package net.overload.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.google.gson.GsonBuilder;

import net.overload.minecraft.MinecraftServer;
import net.overload.utils.Utils;

public class ServerJsonConfiguration {

	private File file;

	public ServerJsonConfiguration(File file) {
		this.file = file;
	}

	@SuppressWarnings("deprecation")
	public MinecraftServer load() {
		try {
			String s = FileUtils.readFileToString(this.file);
			s = s.replaceAll("%SERVER_NAME%", Utils.generateRandomName());
			s = s.replaceAll("%SERVER_PORT%", Utils.generateRandomPort().toString());
						
			MinecraftServer server = new GsonBuilder().create().fromJson(s, MinecraftServer.class);
			return server;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
