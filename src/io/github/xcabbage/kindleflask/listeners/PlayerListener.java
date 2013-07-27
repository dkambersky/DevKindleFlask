package io.github.xcabbage.kindleflask.listeners;

import java.util.logging.Level;

import io.github.xcabbage.kindleflask.ItemInterface;
import io.github.xcabbage.kindleflask.KindleFlask;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {
	KindleFlask instance;
	ItemInterface workshop= new ItemInterface();

	public PlayerListener(KindleFlask instance) {
		this.instance = instance;
		instance.getServer().getPluginManager().registerEvents(this, instance);
	}

	// HANDLING RIGHTCLICKED PLAYERS
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {

		// debug info
		if (instance.debugInfoEnabled) {
			instance.getLogger().log(
					Level.INFO,
					"Player rightclicked entity "
							+ event.getRightClicked().getType());
		}
	}

	// HANDLING RIGHTCLICKED BLOCKS
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerInteractBlock(PlayerInteractEvent event) {
		if (event.getClickedBlock() != null)
			if (isBlockTopOnFire(event.getClickedBlock())
					&& event.getClickedBlock().getType() == Material.NETHERRACK
					&& event.getMaterial() == Material.GLASS_BOTTLE) {
				instance.log("sup.");
				workshop.createFlask(1, event.getItem());
			}
		
		
		
		
		

		// debug info
		if (instance.debugInfoEnabled) {
			try {
				instance.getLogger().log(
						Level.INFO,
						"Player rightclicked block "
								+ event.getClickedBlock().getType()
								+ " with material " + event.getMaterial());

				if (isBlockOnFire(event.getClickedBlock())) {
					instance.getLogger().log(Level.INFO, "Block is on fire.");
				} else {
					instance.getLogger().log(Level.INFO,
							"Block is NOT on fire.");
				}

			} catch (NullPointerException e) {
				instance.getLogger().log(
						Level.INFO,
						"Player rightclicked air with material "
								+ event.getMaterial());
			}

		}
	}

	boolean isBlockOnFire(Block block) {
		for (BlockFace face : BlockFace.values()) {
			Block rel = block.getRelative(face);
			if (rel.getType() == Material.FIRE) {
				return true;
			}
		}
		return false;
	}

	boolean isBlockTopOnFire(Block block) {

		Block rel = block.getRelative(BlockFace.UP);
		if (rel.getType() == Material.FIRE) {
			return true;
		}
		return false;
	}
}