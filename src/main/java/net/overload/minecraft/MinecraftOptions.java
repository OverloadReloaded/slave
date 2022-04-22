package net.overload.minecraft;

public class MinecraftOptions {
	private int maxAllocatedRam = 512;

	private MinecraftPropertiesOptions serverProperties;

	private MinecraftBukkitOptions bukkit;

	private MinecraftSpigotOption spigot;

	private MinecraftPlugins plugins = null;

	private MinecraftWorld world = null;

	public MinecraftOptions(
			Integer maxRam,
			MinecraftPropertiesOptions mspo,
			MinecraftBukkitOptions mbo,
			MinecraftSpigotOption mso,
			MinecraftWorld mw,
			MinecraftPlugins mp
	){
		
		if (maxRam != null && maxRam.intValue() > 0) setMaxAllocatedRam(maxRam.intValue());
		
		if (mbo != null) setBukkit(mbo);
		else setBukkit(new MinecraftBukkitOptions());
		
		if (mso != null) setSpigot(mso);
		else setSpigot(new MinecraftSpigotOption());
		
		if (mw != null) setWorld(mw);
		else setWorld(new MinecraftWorld());
		
		if (mp != null) setPlugins(mp);
		else setPlugins(new MinecraftPlugins());
		
	}

	public MinecraftOptions() {
		setServerProperties(new MinecraftPropertiesOptions());
		setBukkit(new MinecraftBukkitOptions());
		setSpigot(new MinecraftSpigotOption());
		setWorld(new MinecraftWorld());
		setPlugins(new MinecraftPlugins());
	}

	public int getMaxAllocatedRam() {
		return this.maxAllocatedRam;
	}

	public void setMaxAllocatedRam(int maxAllocatedRam) {
		this.maxAllocatedRam = maxAllocatedRam;
	}

	public MinecraftPropertiesOptions getServerProperties() {
		return this.serverProperties;
	}

	public void setServerProperties(MinecraftPropertiesOptions serverProperties) {
		this.serverProperties = serverProperties;
	}

	public MinecraftBukkitOptions getBukkit() {
		return this.bukkit;
	}

	public void setBukkit(MinecraftBukkitOptions bukkit) {
		this.bukkit = bukkit;
	}

	public MinecraftSpigotOption getSpigot() {
		return this.spigot;
	}

	public void setSpigot(MinecraftSpigotOption spigot) {
		this.spigot = spigot;
	}

	public MinecraftPlugins getPlugins() {
		return this.plugins;
	}

	public void setPlugins(MinecraftPlugins plugins) {
		this.plugins = plugins;
	}

	public MinecraftWorld getWorld() {
		return this.world;
	}

	public void setWorld(MinecraftWorld world) {
		this.world = world;
	}
}
