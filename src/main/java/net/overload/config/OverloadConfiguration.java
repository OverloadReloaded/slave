package net.overload.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.overload.logger.Log;
import net.overload.logger.LogLevel;
import net.overload.utils.StaticsVariables;
import net.overload.utils.Utils;

public class OverloadConfiguration {
	private File file;

	private String redisIp;
	private String redisPassword;
	private Integer redisPort;
	
	private String mongoIp;
	private String mongoPassword;
	private Integer mongoPort;

	private Boolean debug = false;
	private Boolean printStackTrace = false;
	private Boolean showErrorsMessages = false;
	private Boolean showJedisMessaging = false;
	private Boolean configFileLoaded = false;
	private Boolean showJsonMessages = false;

	public OverloadConfiguration(String func_file) {
		setFile(new File(func_file));
	}

	public OverloadConfiguration(File func_file) {
		setFile(func_file);
	}

	public Boolean check() {
		try {
			Properties properties = new Properties();
			InputStream input = null;
			if (getFile().exists()) {
				(new Log(LogLevel.INFO, "Configuration file is loading...")).send();
				input = new FileInputStream(getFile());
				properties.load(input);
				
				setRedisIp(properties.getProperty("redisIp"));
				setRedisPort(Integer.parseInt(properties.getProperty("redisPort")));
				setRedisPassword(properties.getProperty("redisPassword"));
				
				setMongoIp(properties.getProperty("mongoIp"));
				setMongoPort(Integer.parseInt(properties.getProperty("mongoPort")));
				setMongoPassword(properties.getProperty("mongoPassword"));
				
				setDebug(Boolean.parseBoolean(properties.getProperty("consoleDebug")));
				setPrintStackTrace(Boolean.parseBoolean(properties.getProperty("printStackTrace")));
				setShowErrorsMessages(Boolean.parseBoolean(properties.getProperty("showErrorsMessages")));
				setShowJedisMessaging(Boolean.parseBoolean(properties.getProperty("showJedisMessages")));
				setShowJsonMessages(Boolean.parseBoolean(properties.getProperty("showJsonMessages")));
				(new Log(LogLevel.SUCCESS, "Configuration file loaded!")).send();
				
				setConfigFileLoaded(true);
				return true;
			}
			try {
				(new Log(LogLevel.INFO, "Configuration file doesn't exist. Creating it...")).send();
				List<String> strgs = new ArrayList<String>();
				strgs.add("#         ---------");
				strgs.add("#    OverLoad Configurations: Slave");
				strgs.add("#         ---------");
				strgs.add("redisIp=127.0.0.1");
				strgs.add("redisPort=6379");
				strgs.add("redisPassword=SET_PASSWORD_HERE");
				strgs.add(" ");
				strgs.add("mongoIp=127.0.0.1");
				strgs.add("mongoPort=27017");
				strgs.add("mongoPassword=SET_PASSWORD_HERE");
				strgs.add(" ");
				strgs.add("consoleDebug=false");
				strgs.add("printStackTrace=false");
				strgs.add("showErrorsMessages=false");
				strgs.add("showJedisMessages=false");
				strgs.add("showJsonMessages=false");
				Utils.createTextFile(strgs, getFile().toPath());
				(new Log(LogLevel.SUCCESS, "Configuration file created!")).send();
				(new Log(LogLevel.SUCCESS, "Check it out to configure the Redis Connection!")).send();
				System.exit(2);
				return false;
			} catch (Exception e) {
				new Log(LogLevel.ERROR, "Error while creating the configuration file: " + this.file.toString()).send();
				if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
				if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
				return false;
			}
		} catch (Exception e) {
			new Log(LogLevel.ERROR, "Error while checking the configuration file: " + this.file.toString()).send();
			
			if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
			if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
			
			System.exit(2);
			return false;
		}
	}

	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Boolean getDebug() {
		return this.debug;
	}

	public void setDebug(Boolean b) {
		this.debug = b;
	}

	public Boolean getPrintStackTrace() {
		return this.printStackTrace;
	}

	public void setPrintStackTrace(Boolean printStackTrace) {
		this.printStackTrace = printStackTrace;
	}

	public Boolean getShowErrorsMessages() {
		return this.showErrorsMessages;
	}

	public void setShowErrorsMessages(Boolean showErrorsMessages) {
		this.showErrorsMessages = showErrorsMessages;
	}

	public Boolean getConfigFileLoaded() {
		return this.configFileLoaded;
	}

	public void setConfigFileLoaded(Boolean configFileLoaded) {
		this.configFileLoaded = configFileLoaded;
	}

	public Boolean getShowJedisMessaging() {
		return this.showJedisMessaging;
	}

	public void setShowJedisMessaging(Boolean showJedisMessaging) {
		this.showJedisMessaging = showJedisMessaging;
	}

	public Boolean getShowJsonMessages() {
		return this.showJsonMessages;
	}

	public void setShowJsonMessages(Boolean showJsonMessages) {
		this.showJsonMessages = showJsonMessages;
	}

	public String getRedisIp() {
		return redisIp;
	}

	public void setRedisIp(String redisIp) {
		this.redisIp = redisIp;
	}

	public String getRedisPassword() {
		return redisPassword;
	}

	public void setRedisPassword(String redisPassword) {
		this.redisPassword = redisPassword;
	}

	public Integer getRedisPort() {
		return redisPort;
	}

	public void setRedisPort(Integer redisPort) {
		this.redisPort = redisPort;
	}

	public String getMongoIp() {
		return mongoIp;
	}

	public void setMongoIp(String mongoIp) {
		this.mongoIp = mongoIp;
	}

	public String getMongoPassword() {
		return mongoPassword;
	}

	public void setMongoPassword(String mongoPassword) {
		this.mongoPassword = mongoPassword;
	}

	public Integer getMongoPort() {
		return mongoPort;
	}

	public void setMongoPort(Integer mongoPort) {
		this.mongoPort = mongoPort;
	}
}
