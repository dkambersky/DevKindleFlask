package io.github.xcabbage.kindleflask;

import java.util.logging.Level;

import io.github.xcabbage.kindleflask.listeners.PlayerListener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class KindleFlask extends JavaPlugin {
	final public boolean debugInfoEnabled = false;
	final public boolean debugPowerCommandEnabled = false;
	public static int levelOnePower = 3;
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

	public void logError(String str) {
		getLogger().log(Level.WARNING, str);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("flask")) {

			if (debugPowerCommandEnabled) {
				try {
					levelOnePower = Integer.parseInt(args[0]);
					log("New level 1 heal value set to " + levelOnePower
							+ " by player " + sender.getName() + ".");
				} catch (Exception e) {
					logError("New heal value couldn't be parsed - returning default value.");
				}
			}
			return true;
		}
		return false;
	}

}
