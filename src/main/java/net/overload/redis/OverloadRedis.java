package net.overload.redis;

import net.overload.config.OverloadConfiguration;
import net.overload.logger.Log;
import net.overload.logger.LogLevel;
import net.overload.utils.StaticsFunctions;
import net.overload.utils.StaticsVariables;
import net.overload.utils.Utils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class OverloadRedis {

	private Jedis database;
	private Jedis jedis;
	private JedisPubSub pubsub;
	
	public OverloadRedis() {
		new Log(LogLevel.INFO, "Connecting to Redis Server...").send();
	}
	
	public Boolean connect() {
		try {
			OverloadConfiguration c = StaticsVariables.config;
			
			if(StaticsVariables.config.getConfigFileLoaded()) {
				database = new Jedis(c.getRedisIp(), c.getRedisPort());
				database.auth(c.getRedisPassword());
				
				jedis = new Jedis(c.getRedisIp(), c.getRedisPort());
				jedis.auth(c.getRedisPassword());
				
				new Log(LogLevel.SUCCESS, "Connected to Redis Server!").send();
				return true;
			}
			
			new Log(LogLevel.CRITICAL, "The configuration file is not loaded.").send();
			new Log(LogLevel.CRITICAL, "Please check it out.").send();
			System.exit(2);
			return false;
		} catch (Exception e) {
			new Log(LogLevel.ERROR, "Error while connection to the Redis Server.").send();
			new Log(LogLevel.ERROR, "Please check out the configuration file.").send();
			if (StaticsVariables.config.getPrintStackTrace()) e.printStackTrace();
			if (StaticsVariables.config.getShowErrorsMessages()) new Log(LogLevel.ERROR_MESSAGE, "Error message: " + e.toString()).send();
			System.exit(2);
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	public void subscribe() {
		pubsub = new JedisPubSub() {
			OverloadConfiguration c = StaticsVariables.config;
			
			public void onMessage(String channel, String message) {
				if(c.getShowJedisMessaging()) new Log(LogLevel.CMD, "Received from " + channel + ": " + message).send();
				
				if(channel.equals("toSlave")) {

					if(message.equals("newlobby")) StaticsFunctions.newLobby();
					if(message.equals("newwe")) StaticsFunctions.newWE();
					if(message.equals("newvoid")) StaticsFunctions.newVoid();
					if(message.startsWith("new ")) Utils.startServerFromFile(message.split(" ")[1]);
					
				}
			}
			
			public void onSubscribe(String channel, Integer subscribedChannels) {
				new Log(LogLevel.CMD, "Subscribed to channel: " + channel + ". (Total Subs: " + subscribedChannels + ")").send();
			}
			public void onUnsubscribe(String channel, Integer subscribedChannels) {
				new Log(LogLevel.CMD, "Unsubscribed to channel: " + channel + ". (Total Subs: " + subscribedChannels + ")").send();
			}
		};
		
		jedis.subscribe(pubsub, new String[] { "toSlave" });
	}
	
	
	
	

	public Jedis getDatabase() {
		return database;
	}

	public void setDatabase(Jedis database) {
		this.database = database;
	}

	public Jedis getJedis() {
		return jedis;
	}

	public void setJedis(Jedis jedis) {
		this.jedis = jedis;
	}

	public JedisPubSub getPubsub() {
		return pubsub;
	}

	public void setPubsub(JedisPubSub pubsub) {
		this.pubsub = pubsub;
	}
	
	
 }
