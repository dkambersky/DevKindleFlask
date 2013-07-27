package io.github.xcabbage.kindleflask;

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

	public void createFlask(int level, ItemStack flask) {
		String flaskName = "Kindled Flask ", appendix;
		int healAmount;

		PotionMeta meta = (PotionMeta) flask.getItemMeta();

		switch (level) {
		case 1:
			appendix = "I";
			healAmount = 25;
		case 2:
			appendix = "II";
			healAmount = 40;
		case 3:
			appendix = "III";
			healAmount = 70;
		case 4:
			appendix = "IV";
			healAmount = 110;
		default:
			KindleFlask.plugin
					.log("Invalid flask level specified, creating a level 1 instead.");
			appendix = "I";
			healAmount = 25;
		}

		flaskName = flaskName.concat(appendix);
		meta.setDisplayName(flaskName);
		meta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 60,
				healAmount, true), true);
		flask.setItemMeta(meta);
	}
}
