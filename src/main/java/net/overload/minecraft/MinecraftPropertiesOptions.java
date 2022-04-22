package net.overload.minecraft;

import java.io.File;
import java.util.ArrayList;

import net.overload.utils.Utils;

public class MinecraftPropertiesOptions {
	private int queryPort = 0;

	private int rconPort = 0;

	private boolean enableQuery = false;

	private boolean enableRcon = false;

	private String rconPassword = "";

	private String serverName = "";

	private String generatorSettings = "";

	private boolean useNativeTransport = false;

	private int opPermissionLevel = 4;

	private boolean allowNether = false;

	private String levelName = "world";

	private boolean allowFlight = true;

	private boolean announcePlayerAchievements = false;

	private int serverPort = 25565;

	private int maxWorldsize = 29999984;

	private String levelType = "DEFAULT";

	private String levelSeed = "";

	private boolean forceGamemode = false;

	private String serverIp = "";

	private int networkCompressionThreshold = 256;

	private int maxBuildHeight = 256;

	private boolean spawnNpcs = true;

	private boolean whitelist = false;

	private boolean spawnAnimals = true;

	private boolean hardcore = false;

	private boolean snooperEnabled = false;

	private String resourcePackSha1 = "";

	private boolean onlineMode = false;

	private String resourcePack = "";

	private boolean pvp = true;

	private int difficulty = 1;

	private boolean commandBlock = false;

	private int gamemode = 0;

	private int playerIdleTimeout = 0;

	private int maxPlayers = 20;

	private boolean spawnMonsters = true;

	private boolean generateStructures = false;

	private int viewDistance = 6;

	private String motd = "Minecraft Server";

	public void createFile(File f) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("enable-query=" + getEnableQuery());
		if (getEnableQuery())
			al.add("query.port=" + getQueryPort());
		al.add("enable-rcon=" + getEnableRcon());
		if (getEnableRcon()) {
			al.add("rcon.password=" + getRconPassword());
			al.add("rcon.port=" + getRconPort());
		}
		al.add("server-name=" + getServerName());
		al.add("generator-settings=" + getGeneratorSettings());
		al.add("use-native-transport=" + getUseNativeTransport());
		al.add("op-permission-level=" + getOpPermissionLevel());
		al.add("allow-nether=" + getAllowNether());
		al.add("level-name=" + getLevelName());
		al.add("allow-flight=" + getAllowFlight());
		al.add("announce-player-achievements=" + getAnnouncePlayerAchievements());
		al.add("server-port=" + getServerPort());
		al.add("max-world-size=" + getMaxWorldsize());
		al.add("level-type=" + getLevelType());
		al.add("level-seed=" + getLevelSeed());
		al.add("force-gamemode=" + getForceGamemode());
		al.add("server-ip=" + getServerIp());
		al.add("network-compression-threshold=" + getNetworkCompressionThreshold());
		al.add("max-build-height=" + getMaxBuildHeight());
		al.add("spawn-npcs=" + getSpawnNpcs());
		al.add("white-list=" + getWhitelist());
		al.add("spawn-animals=" + getSpawnAnimals());
		al.add("hardcore=" + getHardcore());
		al.add("snooper-enabled=" + getSnooperEnabled());
		al.add("resource-pack-sha1=" + getResourcePackSha1());
		al.add("online-mode=" + getOnlineMode());
		al.add("resource-pack=" + getResourcePack());
		al.add("pvp=" + getPvp());
		al.add("difficulty=" + getDifficulty());
		al.add("enable-command-block=" + getCommandBlock());
		al.add("gamemode=" + getGamemode());
		al.add("player-idle-timeout=" + getPlayerIdleTimeout());
		al.add("max-players=" + getMaxPlayers());
		al.add("spawn-monsters=" + getSpawnMonsters());
		al.add("generate-structures=" + getGenerateStructures());
		al.add("view-distance=" + getViewDistance());
		al.add("motd=" + getMotd());
		Utils.createTextFile(al, (new File(f + "/server.properties")).toPath());
	}

	public String getServerName() {
		return this.serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public int getQueryPort() {
		return this.queryPort;
	}

	public int getRconPort() {
		return this.rconPort;
	}

	public String getRconPassword() {
		return this.rconPassword;
	}

	public String getGeneratorSettings() {
		return this.generatorSettings;
	}

	public void setGeneratorSettings(String generatorSettings) {
		this.generatorSettings = generatorSettings;
	}

	public boolean getUseNativeTransport() {
		return this.useNativeTransport;
	}

	public void setUseNativeTransport(boolean useNativeTransport) {
		this.useNativeTransport = useNativeTransport;
	}

	public int getOpPermissionLevel() {
		return this.opPermissionLevel;
	}

	public void setOpPermissionLevel(int opPermissionLevel) {
		this.opPermissionLevel = opPermissionLevel;
	}

	public boolean getAllowNether() {
		return this.allowNether;
	}

	public void setAllowNether(boolean allowNether) {
		this.allowNether = allowNether;
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public boolean getEnableQuery() {
		return this.enableQuery;
	}

	public void setEnableQuery(boolean enableQuery) {
		this.enableQuery = enableQuery;
	}

	public boolean getAllowFlight() {
		return this.allowFlight;
	}

	public void setAllowFlight(boolean allowFlight) {
		this.allowFlight = allowFlight;
	}

	public boolean getAnnouncePlayerAchievements() {
		return this.announcePlayerAchievements;
	}

	public void setAnnouncePlayerAchievements(boolean announcePlayerAchievements) {
		this.announcePlayerAchievements = announcePlayerAchievements;
	}

	public int getServerPort() {
		return this.serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public int getMaxWorldsize() {
		return this.maxWorldsize;
	}

	public void setMaxWorldsize(int maxWorldsize) {
		this.maxWorldsize = maxWorldsize;
	}

	public String getLevelType() {
		return this.levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	public boolean getEnableRcon() {
		return this.enableRcon;
	}

	public void setEnableRcon(boolean enableRcon) {
		this.enableRcon = enableRcon;
	}

	public String getLevelSeed() {
		return this.levelSeed;
	}

	public void setLevelSeed(String levelSeed) {
		this.levelSeed = levelSeed;
	}

	public boolean getForceGamemode() {
		return this.forceGamemode;
	}

	public void setForceGamemode(boolean forceGamemode) {
		this.forceGamemode = forceGamemode;
	}

	public String getServerIp() {
		return this.serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public int getNetworkCompressionThreshold() {
		return this.networkCompressionThreshold;
	}

	public void setNetworkCompressionThreshold(int networkCompressionThreshold) {
		this.networkCompressionThreshold = networkCompressionThreshold;
	}

	public int getMaxBuildHeight() {
		return this.maxBuildHeight;
	}

	public void setMaxBuildHeight(int maxBuildHeight) {
		this.maxBuildHeight = maxBuildHeight;
	}

	public boolean getSpawnNpcs() {
		return this.spawnNpcs;
	}

	public void setSpawnNpcs(boolean spawnNpcs) {
		this.spawnNpcs = spawnNpcs;
	}

	public boolean getWhitelist() {
		return this.whitelist;
	}

	public void setWhitelist(boolean whitelist) {
		this.whitelist = whitelist;
	}

	public boolean getSpawnAnimals() {
		return this.spawnAnimals;
	}

	public void setSpawnAnimals(boolean spawnAnimals) {
		this.spawnAnimals = spawnAnimals;
	}

	public boolean getHardcore() {
		return this.hardcore;
	}

	public void setHardcore(boolean hardcore) {
		this.hardcore = hardcore;
	}

	public boolean getSnooperEnabled() {
		return this.snooperEnabled;
	}

	public void setSnooperEnabled(boolean snooperEnabled) {
		this.snooperEnabled = snooperEnabled;
	}

	public String getResourcePackSha1() {
		return this.resourcePackSha1;
	}

	public void setResourcePackSha1(String resourcePackSha1) {
		this.resourcePackSha1 = resourcePackSha1;
	}

	public boolean getOnlineMode() {
		return this.onlineMode;
	}

	public void setOnlineMode(boolean onlineMode) {
		this.onlineMode = onlineMode;
	}

	public String getResourcePack() {
		return this.resourcePack;
	}

	public void setResourcePack(String resourcePack) {
		this.resourcePack = resourcePack;
	}

	public boolean getPvp() {
		return this.pvp;
	}

	public void setPvp(boolean pvp) {
		this.pvp = pvp;
	}

	public int getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public boolean getCommandBlock() {
		return this.commandBlock;
	}

	public void setCommandBlock(boolean commandBlock) {
		this.commandBlock = commandBlock;
	}

	public int getGamemode() {
		return this.gamemode;
	}

	public void setGamemode(int gamemode) {
		this.gamemode = gamemode;
	}

	public int getPlayerIdleTimeout() {
		return this.playerIdleTimeout;
	}

	public void setPlayerIdleTimeout(int playerIdleTimeout) {
		this.playerIdleTimeout = playerIdleTimeout;
	}

	public int getMaxPlayers() {
		return this.maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public boolean getSpawnMonsters() {
		return this.spawnMonsters;
	}

	public void setSpawnMonsters(boolean spawnMonsters) {
		this.spawnMonsters = spawnMonsters;
	}

	public boolean getGenerateStructures() {
		return this.generateStructures;
	}

	public void setGenerateStructures(boolean generateStructures) {
		this.generateStructures = generateStructures;
	}

	public int getViewDistance() {
		return this.viewDistance;
	}

	public void setViewDistance(int viewDistance) {
		this.viewDistance = viewDistance;
	}

	public String getMotd() {
		return this.motd;
	}

	public void setMotd(String motd) {
		this.motd = motd;
	}

	@Override
	public String toString() {
		return "MinecraftPropertiesOptions [queryPort=" + queryPort + ", rconPort=" + rconPort + ", enableQuery="
				+ enableQuery + ", enableRcon=" + enableRcon + ", rconPassword=" + rconPassword + ", serverName="
				+ serverName + ", generatorSettings=" + generatorSettings + ", useNativeTransport=" + useNativeTransport
				+ ", opPermissionLevel=" + opPermissionLevel + ", allowNether=" + allowNether + ", levelName="
				+ levelName + ", allowFlight=" + allowFlight + ", announcePlayerAchievements="
				+ announcePlayerAchievements + ", serverPort=" + serverPort + ", maxWorldsize=" + maxWorldsize
				+ ", levelType=" + levelType + ", levelSeed=" + levelSeed + ", forceGamemode=" + forceGamemode
				+ ", serverIp=" + serverIp + ", networkCompressionThreshold=" + networkCompressionThreshold
				+ ", maxBuildHeight=" + maxBuildHeight + ", spawnNpcs=" + spawnNpcs + ", whitelist=" + whitelist
				+ ", spawnAnimals=" + spawnAnimals + ", hardcore=" + hardcore + ", snooperEnabled=" + snooperEnabled
				+ ", resourcePackSha1=" + resourcePackSha1 + ", onlineMode=" + onlineMode + ", resourcePack="
				+ resourcePack + ", pvp=" + pvp + ", difficulty=" + difficulty + ", commandBlock=" + commandBlock
				+ ", gamemode=" + gamemode + ", playerIdleTimeout=" + playerIdleTimeout + ", maxPlayers=" + maxPlayers
				+ ", spawnMonsters=" + spawnMonsters + ", generateStructures=" + generateStructures + ", viewDistance="
				+ viewDistance + ", motd=" + motd + "]";
	}
	
}
