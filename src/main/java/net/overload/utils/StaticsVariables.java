package net.overload.utils;

import java.util.ArrayList;
import java.util.HashMap;

import net.overload.config.OverloadConfiguration;
import net.overload.logger.CommandReader;
import net.overload.minecraft.MinecraftServer;
import net.overload.redis.OverloadRedis;

public class StaticsVariables {
	public static OverloadConfiguration config;

	public static CommandReader commandReader;

	public static OverloadRedis redis;

	public static String version = "b0.0.1";

	public static String overloadMinecraftPlugin = "overload.jar";

	public static ArrayList<MinecraftServer> minecraftServers = new ArrayList<MinecraftServer>();

	public static HashMap<String, MinecraftServer> minecraftLobbies = new HashMap<String, MinecraftServer>();

}
