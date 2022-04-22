package net.overload.minecraft;

import java.io.File;
import java.util.ArrayList;

import net.overload.utils.Utils;

public class MinecraftBukkitOptions {
	private boolean allowEnd = false;

	private boolean warnOnOverload = false;

	private String permissionsFile = "permissions.yml";

	private String updateFolder = "update";

	private int pingPacketLimit = 100;

	private boolean useExactLoginLocation = false;

	private boolean pluginProfiling = false;

	private int connectionThrottle = 4000;

	private boolean queryPlugins = true;

	private String deprecatedVerbose = "default";

	private String shutdownMessage = "Server closed";

	private int monsters = 70;

	private int animals = 15;

	private int waterAnimals = 5;

	private int ambient = 15;

	private int periodInTicks = 600;

	private int loadThreshold = 0;

	private int animalSpawns = 400;

	private int monsterSpawns = 1;

	private int autoSave = 6000;

	private String aliases = "now-in-commands.yml";

	private String username = "bukkit";

	private String isolation = "SERIALIZABLE";

	private String driver = "org.sqlite.JDBC";

	private String password = "walrus";

	private String url = "jdbc:sqlite:{DIR}{NAME}.db";

	public void createFile(File f) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("settings:");
		al.add("  allow-end: " + isAllowEnd());
		al.add("  warn-on-overload: " + isWarnOnOverload());
		al.add("  permissions-file: " + getPermissionsFile());
		al.add("  update-folder: " + getUpdateFolder());
		al.add("  ping-packet-limit: " + getPingPacketLimit());
		al.add("  use-exact-login-location: " + isUseExactLoginLocation());
		al.add("  plugin-profiling: " + isPluginProfiling());
		al.add("  connection-throttle: " + getConnectionThrottle());
		al.add("  query-plugins: " + isQueryPlugins());
		al.add("  deprecated-verbose: " + getDeprecatedVerbose());
		al.add("  shutdown-message: " + getShutdownMessage());
		al.add("spawn-limits:");
		al.add("  monsters: " + getMonsters());
		al.add("  animals: " + getAnimals());
		al.add("  water-animals: " + getWaterAnimals());
		al.add("  ambient: " + getAmbient());
		al.add("chunk-gc:");
		al.add("  period-in-ticks: " + getPeriodInTicks());
		al.add("  load-threshold: " + getLoadThreshold());
		al.add("ticks-per:");
		al.add("  animal-spawns: " + getAnimalSpawns());
		al.add("  monster-spawns: " + getMonsterSpawns());
		al.add("  autosave: " + getAutoSave());
		al.add("aliases: " + getAliases());
		al.add("database:");
		al.add("  username: " + getUsername());
		al.add("  isolation: " + getIsolation());
		al.add("  driver: " + getDriver());
		al.add("  password: " + getPassword());
		al.add("  url: " + getUrl());
		Utils.createTextFile(al, (new File(f + "/bukkit.yml")).toPath());
	}

	public boolean isAllowEnd() {
		return this.allowEnd;
	}

	public void setAllowEnd(boolean allowEnd) {
		this.allowEnd = allowEnd;
	}

	public boolean isWarnOnOverload() {
		return this.warnOnOverload;
	}

	public void setWarnOnOverload(boolean warnOnOverload) {
		this.warnOnOverload = warnOnOverload;
	}

	public String getPermissionsFile() {
		return this.permissionsFile;
	}

	public void setPermissionsFile(String permissionsFile) {
		this.permissionsFile = permissionsFile;
	}

	public String getUpdateFolder() {
		return this.updateFolder;
	}

	public void setUpdateFolder(String updateFolder) {
		this.updateFolder = updateFolder;
	}

	public int getPingPacketLimit() {
		return this.pingPacketLimit;
	}

	public void setPingPacketLimit(int pingPacketLimit) {
		this.pingPacketLimit = pingPacketLimit;
	}

	public boolean isUseExactLoginLocation() {
		return this.useExactLoginLocation;
	}

	public void setUseExactLoginLocation(boolean useExactLoginLocation) {
		this.useExactLoginLocation = useExactLoginLocation;
	}

	public boolean isPluginProfiling() {
		return this.pluginProfiling;
	}

	public void setPluginProfiling(boolean pluginProfiling) {
		this.pluginProfiling = pluginProfiling;
	}

	public int getConnectionThrottle() {
		return this.connectionThrottle;
	}

	public void setConnectionThrottle(int connectionThrottle) {
		this.connectionThrottle = connectionThrottle;
	}

	public boolean isQueryPlugins() {
		return this.queryPlugins;
	}

	public void setQueryPlugins(boolean queryPlugins) {
		this.queryPlugins = queryPlugins;
	}

	public String getDeprecatedVerbose() {
		return this.deprecatedVerbose;
	}

	public void setDeprecatedVerbose(String deprecatedVerbose) {
		this.deprecatedVerbose = deprecatedVerbose;
	}

	public String getShutdownMessage() {
		return this.shutdownMessage;
	}

	public void setShutdownMessage(String shutdownMessage) {
		this.shutdownMessage = shutdownMessage;
	}

	public int getMonsters() {
		return this.monsters;
	}

	public void setMonsters(int monsters) {
		this.monsters = monsters;
	}

	public int getAnimals() {
		return this.animals;
	}

	public void setAnimals(int animals) {
		this.animals = animals;
	}

	public int getWaterAnimals() {
		return this.waterAnimals;
	}

	public void setWaterAnimals(int waterAnimals) {
		this.waterAnimals = waterAnimals;
	}

	public int getAmbient() {
		return this.ambient;
	}

	public void setAmbient(int ambient) {
		this.ambient = ambient;
	}

	public int getPeriodInTicks() {
		return this.periodInTicks;
	}

	public void setPeriodInTicks(int periodInTicks) {
		this.periodInTicks = periodInTicks;
	}

	public int getLoadThreshold() {
		return this.loadThreshold;
	}

	public void setLoadThreshold(int loadThreshold) {
		this.loadThreshold = loadThreshold;
	}

	public int getAnimalSpawns() {
		return this.animalSpawns;
	}

	public void setAnimalSpawns(int animalSpawns) {
		this.animalSpawns = animalSpawns;
	}

	public int getMonsterSpawns() {
		return this.monsterSpawns;
	}

	public void setMonsterSpawns(int monsterSpawns) {
		this.monsterSpawns = monsterSpawns;
	}

	public int getAutoSave() {
		return this.autoSave;
	}

	public void setAutoSave(int autoSave) {
		this.autoSave = autoSave;
	}

	public String getAliases() {
		return this.aliases;
	}

	public void setAliases(String aliases) {
		this.aliases = aliases;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIsolation() {
		return this.isolation;
	}

	public void setIsolation(String isolation) {
		this.isolation = isolation;
	}

	public String getDriver() {
		return this.driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "MinecraftBukkitOptions [allowEnd=" + allowEnd + ", warnOnOverload=" + warnOnOverload
				+ ", permissionsFile=" + permissionsFile + ", updateFolder=" + updateFolder + ", pingPacketLimit="
				+ pingPacketLimit + ", useExactLoginLocation=" + useExactLoginLocation + ", pluginProfiling="
				+ pluginProfiling + ", connectionThrottle=" + connectionThrottle + ", queryPlugins=" + queryPlugins
				+ ", deprecatedVerbose=" + deprecatedVerbose + ", shutdownMessage=" + shutdownMessage + ", monsters="
				+ monsters + ", animals=" + animals + ", waterAnimals=" + waterAnimals + ", ambient=" + ambient
				+ ", periodInTicks=" + periodInTicks + ", loadThreshold=" + loadThreshold + ", animalSpawns="
				+ animalSpawns + ", monsterSpawns=" + monsterSpawns + ", autoSave=" + autoSave + ", aliases=" + aliases
				+ ", username=" + username + ", isolation=" + isolation + ", driver=" + driver + ", password="
				+ password + ", url=" + url + "]";
	}

}
