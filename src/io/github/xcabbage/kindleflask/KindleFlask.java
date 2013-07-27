package io.github.xcabbage.kindleflask;

import org.bukkit.plugin.java.JavaPlugin;

public class KindleFlask extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("KindleFlask enabled");
		
	}

	@Override
	public void onDisable() {
		getLogger().info("KindleFlask disabled");
	}
}
