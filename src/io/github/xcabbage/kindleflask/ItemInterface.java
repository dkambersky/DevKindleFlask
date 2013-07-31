package io.github.xcabbage.kindleflask;

import java.util.Arrays;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class ItemInterface {

	public void renameItem(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
	}

	public ItemStack createFlask(int level) {
		String flaskName = "Kindled Flask ", appendix, loreValue = "";
		int healAmount;
		Potion potion = new Potion(PotionType.STRENGTH, 1);
		ItemStack flask = potion.toItemStack(1);
		PotionMeta meta = (PotionMeta) flask.getItemMeta();

		switch (level) {
		case 1:
			appendix = "I";
			healAmount = KindleFlask.levelOnePower;
			loreValue = "Removes a few cuts and bruises.";
			break;
		case 2:
			appendix = "II";
			healAmount = 4;
			loreValue = "Heals moderate damage, maybe a few broken limbs even.";
			break;
		case 3:
			appendix = "III";
			healAmount = 5;
			loreValue = "Has the potential to heal a man on his deathbed.";
			break;
		case 4:
			appendix = "IV";
			healAmount = 7;
			loreValue = "Rumored to be the flask used in battle by <insert epic guy here>";
			break;
		default:
			KindleFlask.plugin
					.log("Invalid flask level specified, creating a level 1 instead.");
			appendix = "I";
			healAmount = KindleFlask.levelOnePower;
			break;
		}

		meta.removeCustomEffect(PotionEffectType.INCREASE_DAMAGE);

		flaskName = flaskName.concat(appendix);
		List<String> lore = Arrays.asList("A level " + appendix
				+ " Kindled Flask.", loreValue);

		meta.setDisplayName(flaskName);
		meta.setLore(lore);
		meta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 1,
				healAmount, true), true);

		flask.setItemMeta(meta);
		return flask;
	}
}
