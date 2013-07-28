package io.github.xcabbage.kindleflask;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ItemInterface {

	public void renameItem(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
	}

	public ItemStack createFlask(int level) {
		String flaskName = "Kindled Flask ", appendix;
		int healAmount;
		ItemStack flask = new ItemStack(Material.POTION, 1);
		PotionMeta meta = (PotionMeta) flask.getItemMeta();

		switch (level) {
		case 1:
			appendix = "I";
			healAmount = 25;
			break;
		case 2:
			appendix = "II";
			healAmount = 40;
			break;
		case 3:
			appendix = "III";
			healAmount = 70;
			break;
		case 4:
			appendix = "IV";
			healAmount = 110;
			break;
		default:
			KindleFlask.plugin
					.log("Invalid flask level specified, creating a level 1 instead.");
			appendix = "I";
			healAmount = 25;
			break;
		}

		flaskName = flaskName.concat(appendix);
		meta.setDisplayName(flaskName);
		meta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 60,
				healAmount, true), true);

		flask.setItemMeta(meta);
		return flask;
	}
}
