package net.overload.minecraft;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.overload.logger.Log;
import net.overload.logger.LogLevel;
import net.overload.utils.PortsChecker;
import net.overload.utils.StaticsVariables;
import net.overload.utils.Utils;

public class MinecraftServer {
	private String serverName;

	private String serverType;

	private File serverDirectory;

	private MinecraftOptions minecraftOptions;

	private Boolean undelatable = false;

	private Timer keepAliveTimer;

	private Boolean alive = true;

	public MinecraftServer(String name, String type, MinecraftOptions mo) {
		if (mo != null) setMinecraftOptions(mo);
		else setMinecraftOptions(new MinecraftOptions());
		
		if (type != null) setServerType(type); else setServerType("lobby");
	}

	public Boolean create() {
		try {
			(new Log(LogLevel.INFO, getServerName(), "Creating the server files...")).send();
			getMinecraftOptions().getWorld().copyWorld();
			getMinecraftOptions().getPlugins().copyPlugins();
			getMinecraftOptions().getBukkit().createFile(getServerDirectory());
			getMinecraftOptions().getSpigot().createFile(getServerDirectory());
			getMinecraftOptions().getServerProperties().createFile(getServerDirectory());
			try {
				FileUtils.copyFile(new File("./Files/spigot-188.jar"), new File(getServerDirectory() + "/spigot-188.jar"));
			} catch (IOException e) {
				new Log(LogLevel.ERROR, "Unable to copy the server executable.").send();
				if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
				if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
			}
			
			try {
				Utils.createTextFile(Arrays.asList(new String[] { "eula=true" }), new File(getServerDirectory() + "/eula.txt").toPath());
			} catch (Exception e) {
				(new Log(LogLevel.ERROR, "Unable to create eula.txt.")).send();
				if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
				if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
			}
			
			new Log(LogLevel.SUCCESS, getServerName(), "Server created!").send();
			return true;
		} catch (Exception e) {
			new Log(LogLevel.ERROR, "Unable to create the server.").send();
			if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
			if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
			return false;
		}
	}
	
	public String generateRandomName() {
		String[] id = UUID.randomUUID().toString().split("-");
		if (this.serverName != null) setServerName(this.serverName); else setServerName(id[2] + "-" + id[1]);
		return this.serverName;
	}
	
	
	@SuppressWarnings("null")
	public Integer generateRandomPort() {
		if (StaticsVariables.config.getDebug()) new Log(LogLevel.DEBUG, getServerName(), "Checking port for the server...").send();
		Random rand = new Random();
		int randomNum = rand.nextInt(29501) + 500;
		class b { int u; };
		
		int finalport = 0;
		
		b t = null;
		for (Integer i = 500; i <= 50000; i++) {
			new b().u = i;
			i = i + randomNum;
			if (new PortsChecker(i).check()) {
				getMinecraftOptions().getServerProperties().setServerPort(i);
				if (StaticsVariables.config.getDebug()) new Log(LogLevel.DEBUG, getServerName(), "New server port: " + i + ".").send();
				finalport = i;
				break;
			}
			if (StaticsVariables.config.getDebug()) new Log(LogLevel.DEBUG, getServerName(), "Port already taken, checking for an other one...").send();
			i = t.u;
		}
		
		return finalport;
	}
	
	public void addDefaults() {
		setServerDirectory(new File("./Servers/" + getServerName() + "/"));
		getServerDirectory().mkdirs();
		getMinecraftOptions().getServerProperties().setMotd(getServerType());
		getMinecraftOptions().getServerProperties().setServerName(getServerName());
		getMinecraftOptions().getWorld().setServerDirectory(new File("./Servers/" + getServerName() + "/"));
		getMinecraftOptions().getPlugins().setPlContainer(new File(getServerDirectory().getPath() + "/plugins/"));
		getMinecraftOptions().getServerProperties().setGeneratorSettings("3;minecraft:air");
		getMinecraftOptions().getServerProperties().setLevelType("FLAT");
	}

	public Boolean start() {
		try {
			String cmd = "";
			cmd = "screen -dmS " + getServerName() + " java -jar -Xms128M -Xmx" + getMinecraftOptions().getMaxAllocatedRam() + "M spigot-188.jar";
			final String myCmd = cmd;
			if (StaticsVariables.config.getDebug()) new Log(LogLevel.DEBUG, getServerName(), "Starting server on screen: " + getServerName() + ".") .send();
			new Thread(new Runnable() {
				public void run() {
					try {
						Process p = Runtime.getRuntime().exec(myCmd, (String[]) null, new File(MinecraftServer.this.getServerDirectory() + "/"));
						p.waitFor();
						new Log(LogLevel.SUCCESS, MinecraftServer.this.getServerName(), "Server started!").send();
					} catch (Exception e) {
						new Log(LogLevel.ERROR, "Unable to create the process for the server.").send();
						if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
						if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
					}
				}
			}).start();
			
			try {
				//DateFormat day = new SimpleDateFormat("yyyy-MM-dd HH-mm:ss");
				//Date dday = new Date();
				//StaticsVariables.redis.getDatabase().hset("MinecraftServer:serverHistory", day.format(dday), getServerName());
				StaticsVariables.redis.getDatabase().set("MinecraftServerInfo:" + getServerName() + ":class", new GsonBuilder().create().toJson(this));
			} catch (Exception e) {
				new Log(LogLevel.ERROR, "Unable to save the MinecraftServer to RedisServer.").send();
				if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
				if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
			}
			if (StaticsVariables.config.getShowJsonMessages())
				try {
					GsonBuilder builder = new GsonBuilder();
					Gson gson = builder.create();
					new Log(LogLevel.CMD, "bite: " + gson.toJson(getMinecraftOptions()).toString()).send();
				} catch (Exception e) {
					new Log("Error with gson").send();
					e.printStackTrace();
				}
		} catch (Exception e) {
			(new Log(LogLevel.ERROR, "Unable to start the server.")).send();
			if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
			if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
		}
		return false;
	}

	public Boolean isAlive() {
		if (StaticsVariables.redis.getJedis().exists("MinecraftServer:" + getServerName() + ":keepAlive"))
			return true;
		return false;
	}

	public String getServerName() {
		return this.serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public MinecraftOptions getMinecraftOptions() {
		return this.minecraftOptions;
	}

	public void setMinecraftOptions(MinecraftOptions minecraftOpsions) {
		this.minecraftOptions = minecraftOpsions;
	}

	public Boolean getUndelatable() {
		return this.undelatable;
	}

	public void setUndelatable(Boolean undelatable) {
		this.undelatable = undelatable;
	}

	public File getServerDirectory() {
		return this.serverDirectory;
	}

	public void setServerDirectory(File serverDirectory) {
		this.serverDirectory = serverDirectory;
	}

	public Timer getKeepAliveTimer() {
		return this.keepAliveTimer;
	}

	public void setKeepAliveTimer(Timer keepAliveTimer) {
		this.keepAliveTimer = keepAliveTimer;
	}

	public Boolean getAlive() {
		return this.alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	public String getServerType() {
		return this.serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	@Override
	public String toString() {
		return "MinecraftServer [serverName=" + serverName + ", serverType=" + serverType + ", serverDirectory="
				+ serverDirectory + ", minecraftOptions=" + minecraftOptions + ", undelatable=" + undelatable
				+ ", keepAliveTimer=" + keepAliveTimer + ", alive=" + alive + "]";
	}
}
