package mfbridge;

import net.minecraft.item.ItemStack;

public class TMCParts {
	//Materials
	public static ItemStack itemResource = ItemController.getItem("tmc", "itemResource");
	//public static ItemStack ingotThaumium = itemResource;
	public static ItemStack ingotThaumium = ItemController.getItem("tmc", "itemResource");
	
	//Armour
	public static ItemStack helmetThaumium = ItemController.getItem("tmc", "itemHelmetThaumium");
	public static ItemStack plateThaumium = ItemController.getItem("tmc", "itemChestThaumium");
	public static ItemStack legsThaumium = ItemController.getItem("tmc", "itemLegsThaumium");
	public static ItemStack bootsThaumium = ItemController.getItem("tmc", "itemBootsThaumium");
	
	//Tools & Weapons
	public static ItemStack swordThaumium = ItemController.getItem("tmc", "itemSwordThaumium");
	public static ItemStack pickThaumium = ItemController.getItem("tmc", "itemPickThaumium");
	public static ItemStack shovelThaumium = ItemController.getItem("tmc", "itemShovelThaumium");
	public static ItemStack hoeThaumium = ItemController.getItem("tmc", "itemHoeThaumium");
	public static ItemStack axeThaumium = ItemController.getItem("tmc", "itemAxeThaumium");
	
	//Wands
	public static ItemStack wandCasting = ItemController.getItem("tmc", "itemWandCasting");
	public static ItemStack wandIron =  ItemController.getItem("tmc", "itemWandCasting");
	public static ItemStack wandGold = ItemController.getItem("tmc", "itemWandCasting");
	public static ItemStack wandThaumium = ItemController.getItem("tmc", "itemWandCasting");
	
	public static void patch()
	{
		ingotThaumium.setItemDamage(2);	
		wandGold.setItemDamage(9);
		wandThaumium.setItemDamage(54);
	}
}
