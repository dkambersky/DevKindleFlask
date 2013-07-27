package io.github.xcabbage.kindleflask;

import java.util.logging.Level;

import io.github.xcabbage.kindleflask.listeners.PlayerListener;

import org.bukkit.plugin.java.JavaPlugin;

public class KindleFlask extends JavaPlugin {
	final public boolean debugInfoEnabled = false;
	public static KindleFlask plugin;

	@Override
	public void onEnable() {
		getLogger().info("KindleFlask enabled");
		plugin = this;
		// register listeners
		new PlayerListener(this);
	}

	@Override
	public void onDisable() {
		getLogger().info("KindleFlask disabled");
	}

	public void log(String str) {
		getLogger().log(Level.INFO, str);
	}

}
