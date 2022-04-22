package net.overload.minecraft;

import java.io.File;
import java.util.ArrayList;

import net.overload.utils.Utils;

public class MinecraftSpigotOption {
	private int configVersion = 8;

	private boolean debug = false;

	private boolean saveUserCacheOnStopOnly = false;

	private int userCacheSize = 8;

	private int intCacheLimit = 1024;

	private boolean lateBind = false;

	private int sampleCount = 12;

	private boolean bungeecord = true;

	private int playerShuffle = 0;

	private double maxHealth = 2048.0D;

	private double movementSpeed = 2048.0D;

	private double attackDamage = 2048.0D;

	private int nettyThreads = 4;

	private int timeoutTime = 60;

	private boolean restartOnCrash = false;

	private String restartScript = "./start.sh";

	private double movedTooQuicklyThreshold = 100.0D;

	private double movedWronglyThreshold = 0.0625D;

	private boolean filterCreativeItems = true;

	private int tabComplete = 0;

	private boolean log = true;

	private boolean silentCommandBlockConsole = false;

	private String whitelist = "You are not whitelisted on this server!";

	private String unknownCommand = "Unknown command. Type \"/help\" for help.";

	private String serverFull = "The server is full!";

	private String outdatedClient = "Outdated client! Please use {0}";

	private String outdatedServer = "Outdated server! I'm still on {0}";

	private String restart = "Server is restarting";

	private boolean disableSaving = false;
	
	private Boolean worldSettingsVerbose = false;

	public void createFile(File f) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("config-version: " + getConfigVersion());
		al.add("settings:");
		al.add("  debug: " + isDebug());
		al.add("  save-user-cache-on-stop-only: " + this.saveUserCacheOnStopOnly);
		al.add("  user-cache-size: " + getUserCacheSize());
		al.add("  int-cache-limit: " + getIntCacheLimit());
		al.add("  late-bind: " + isLateBind());
		al.add("  sample-count: " + getSampleCount());
		al.add("  bungeecord: " + isBungeecord());
		al.add("  player-shuffle: " + getPlayerShuffle());
		al.add("  attribute: ");
		al.add("    maxHealth: ");
		al.add("      max: " + getMaxHealth());
		al.add("    movementSpeed: ");
		al.add("      max: " + getMovementSpeed());
		al.add("    attackDamage: ");
		al.add("      max: " + getAttackDamage());
		al.add("  netty-threads: " + getNettyThreads());
		al.add("  timeout-time: " + getTimeoutTime());
		al.add("  restart-on-crash: " + getRestartScript());
		al.add("  restart-script: " + getRestartScript());
		al.add("  moved-too-quickly-threshold: " + getMovedTooQuicklyThreshold());
		al.add("  moved-wrongly-threshold: " + getMovedWronglyThreshold());
		al.add("  filter-creative-items: " + isFilterCreativeItems());
		al.add("commands:");
		al.add("  tab-complete: " + getTabComplete());
		al.add("  log: " + isLog());
		al.add("  silent-commandblock-console: " + isSilentCommandBlockConsole());
		al.add("messages:");
		al.add("  whitelist: " + getWhitelist());
		al.add("  unknown-command: " + getUnknownCommand());
		al.add("  server-full: " + getServerFull());
		al.add("  outdated-client: " + getOutdatedClient());
		al.add("  outdated-server: " + getOutdatedServer());
		al.add("  restart: " + getRestart());
		al.add("stats:");
		al.add("  disable-saving: " + isDisableSaving());
		al.add("world-settings:");
		al.add("  default:");
		al.add("    verbose: " + getWorldSettingsVerbose());
		Utils.createTextFile(al, (new File(f + "/spigot.yml")).toPath());
	}

	public int getConfigVersion() {
		return this.configVersion;
	}

	public void setConfigVersion(int configVersion) {
		this.configVersion = configVersion;
	}

	public boolean isDebug() {
		return this.debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public boolean isSaveUserCacheOnStopOnly() {
		return this.saveUserCacheOnStopOnly;
	}

	public void setSaveUserCacheOnStopOnly(boolean saveUserCacheOnStopOnly) {
		this.saveUserCacheOnStopOnly = saveUserCacheOnStopOnly;
	}

	public int getUserCacheSize() {
		return this.userCacheSize;
	}

	public void setUserCacheSize(int userCacheSize) {
		this.userCacheSize = userCacheSize;
	}

	public int getIntCacheLimit() {
		return this.intCacheLimit;
	}

	public void setIntCacheLimit(int intCacheLimit) {
		this.intCacheLimit = intCacheLimit;
	}

	public boolean isLateBind() {
		return this.lateBind;
	}

	public void setLateBind(boolean lateBind) {
		this.lateBind = lateBind;
	}

	public int getSampleCount() {
		return this.sampleCount;
	}

	public void setSampleCount(int sampleCount) {
		this.sampleCount = sampleCount;
	}

	public boolean isBungeecord() {
		return this.bungeecord;
	}

	public void setBungeecord(boolean bungeecord) {
		this.bungeecord = bungeecord;
	}

	public int getPlayerShuffle() {
		return this.playerShuffle;
	}

	public void setPlayerShuffle(int playerShuffle) {
		this.playerShuffle = playerShuffle;
	}

	public double getMaxHealth() {
		return this.maxHealth;
	}

	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
	}

	public double getMovementSpeed() {
		return this.movementSpeed;
	}

	public void setMovementSpeed(double movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public double getAttackDamage() {
		return this.attackDamage;
	}

	public void setAttackDamage(double attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getNettyThreads() {
		return this.nettyThreads;
	}

	public void setNettyThreads(int nettyThreads) {
		this.nettyThreads = nettyThreads;
	}

	public int getTimeoutTime() {
		return this.timeoutTime;
	}

	public void setTimeoutTime(int timeoutTime) {
		this.timeoutTime = timeoutTime;
	}

	public boolean isRestartOnCrash() {
		return this.restartOnCrash;
	}

	public void setRestartOnCrash(boolean restartOnCrash) {
		this.restartOnCrash = restartOnCrash;
	}

	public String getRestartScript() {
		return this.restartScript;
	}

	public void setRestartScript(String restartScript) {
		this.restartScript = restartScript;
	}

	public double getMovedTooQuicklyThreshold() {
		return this.movedTooQuicklyThreshold;
	}

	public void setMovedTooQuicklyThreshold(double movedTooQuicklyThreshold) {
		this.movedTooQuicklyThreshold = movedTooQuicklyThreshold;
	}

	public double getMovedWronglyThreshold() {
		return this.movedWronglyThreshold;
	}

	public void setMovedWronglyThreshold(double movedWronglyThreshold) {
		this.movedWronglyThreshold = movedWronglyThreshold;
	}

	public boolean isFilterCreativeItems() {
		return this.filterCreativeItems;
	}

	public void setFilterCreativeItems(boolean filterCreativeItems) {
		this.filterCreativeItems = filterCreativeItems;
	}

	public int getTabComplete() {
		return this.tabComplete;
	}

	public void setTabComplete(int tabComplete) {
		this.tabComplete = tabComplete;
	}

	public boolean isLog() {
		return this.log;
	}

	public void setLog(boolean log) {
		this.log = log;
	}

	public boolean isSilentCommandBlockConsole() {
		return this.silentCommandBlockConsole;
	}

	public void setSilentCommandBlockConsole(boolean silentCommandBlockConsole) {
		this.silentCommandBlockConsole = silentCommandBlockConsole;
	}

	public String getWhitelist() {
		return this.whitelist;
	}

	public void setWhitelist(String whitelist) {
		this.whitelist = whitelist;
	}

	public String getUnknownCommand() {
		return this.unknownCommand;
	}

	public void setUnknownCommand(String unknownCommand) {
		this.unknownCommand = unknownCommand;
	}

	public String getServerFull() {
		return this.serverFull;
	}

	public void setServerFull(String serverFull) {
		this.serverFull = serverFull;
	}

	public String getOutdatedClient() {
		return this.outdatedClient;
	}

	public void setOutdatedClient(String outdatedClient) {
		this.outdatedClient = outdatedClient;
	}

	public String getOutdatedServer() {
		return this.outdatedServer;
	}

	public void setOutdatedServer(String outdatedServer) {
		this.outdatedServer = outdatedServer;
	}

	public String getRestart() {
		return this.restart;
	}

	public void setRestart(String restart) {
		this.restart = restart;
	}

	public boolean isDisableSaving() {
		return this.disableSaving;
	}

	public void setDisableSaving(boolean disableSaving) {
		this.disableSaving = disableSaving;
	}

	public Boolean getWorldSettingsVerbose() {
		return worldSettingsVerbose;
	}

	public void setWorldSettingsVerbose(Boolean worldSettingsVerbose) {
		this.worldSettingsVerbose = worldSettingsVerbose;
	}

	@Override
	public String toString() {
		return "MinecraftSpigotOption [configVersion=" + configVersion + ", debug=" + debug
				+ ", saveUserCacheOnStopOnly=" + saveUserCacheOnStopOnly + ", userCacheSize=" + userCacheSize
				+ ", intCacheLimit=" + intCacheLimit + ", lateBind=" + lateBind + ", sampleCount=" + sampleCount
				+ ", bungeecord=" + bungeecord + ", playerShuffle=" + playerShuffle + ", maxHealth=" + maxHealth
				+ ", movementSpeed=" + movementSpeed + ", attackDamage=" + attackDamage + ", nettyThreads="
				+ nettyThreads + ", timeoutTime=" + timeoutTime + ", restartOnCrash=" + restartOnCrash
				+ ", restartScript=" + restartScript + ", movedTooQuicklyThreshold=" + movedTooQuicklyThreshold
				+ ", movedWronglyThreshold=" + movedWronglyThreshold + ", filterCreativeItems=" + filterCreativeItems
				+ ", tabComplete=" + tabComplete + ", log=" + log + ", silentCommandBlockConsole="
				+ silentCommandBlockConsole + ", whitelist=" + whitelist + ", unknownCommand=" + unknownCommand
				+ ", serverFull=" + serverFull + ", outdatedClient=" + outdatedClient + ", outdatedServer="
				+ outdatedServer + ", restart=" + restart + ", disableSaving=" + disableSaving
				+ ", worldSettingsVerbose=" + worldSettingsVerbose + "]";
	}
}
