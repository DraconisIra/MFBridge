package mfbridge;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NTUParts {

	//misc
	public static ItemStack netherrackFurnace = ItemController.getItem("ntu", "netherrackFurnace");
	
	public static Item plantItem = ItemController.getItem("ntu", "plantItem").getItem();
	public static ItemStack leatherImp = new ItemStack(plantItem);
	public static ItemStack stringFlame = new ItemStack(plantItem);
		
	//Planks & Sticks
	public static Item planksItem = ItemController.getItem("ntu", "planks").getItem();
	public static Item stickItem = ItemController.getItem("ntu", "stickItem").getItem();
	
	public static ItemStack planksGhostwood = new ItemStack(planksItem);
	public static ItemStack stickGhostwood = new ItemStack(stickItem);
	
	public static ItemStack planksBloodwood = new ItemStack(planksItem);
	public static ItemStack stickBloodwood = new ItemStack(stickItem);
	
	public static ItemStack planksDarkwood = new ItemStack(planksItem);
	public static ItemStack stickDarkwood = new ItemStack(stickItem);
	
	public static ItemStack planksFusewood = new ItemStack(planksItem);
	public static ItemStack stickFusewood = new ItemStack(stickItem);
	
	
	
	//Tools & Weapons
		//Ghostwood
		public static ItemStack swordGhostwood = ItemController.getItem("ntu", "ghostwoodSword");
		public static ItemStack pickGhostwood = ItemController.getItem("ntu", "ghostwoodPickaxe");
		public static ItemStack shovelGhostwood = ItemController.getItem("ntu", "ghostwoodShovel");
		public static ItemStack axeGhostwood = ItemController.getItem("ntu", "ghostwoodAxe");
		public static ItemStack kamaGhostwood = ItemController.getItem("ntu", "ghostwoodKama");
		public static ItemStack bowGhostwood = ItemController.getItem("ntu", "ghostwoodBow");
		
		//Bloodwood
		public static ItemStack swordBloodwood = ItemController.getItem("ntu", "bloodwoodSword");
		public static ItemStack pickBloodwood = ItemController.getItem("ntu", "bloodwoodPickaxe");
		public static ItemStack shovelBloodwood = ItemController.getItem("ntu", "bloodwoodShovel");
		public static ItemStack axeBloodwood = ItemController.getItem("ntu", "bloodwoodAxe");
		public static ItemStack kamaBloodwood = ItemController.getItem("ntu", "bloodwoodKama");
		public static ItemStack bowbLoodwood = ItemController.getItem("ntu", "bloodwoodBow");
		
		//Fusewood
		public static ItemStack swordFusewood = ItemController.getItem("ntu", "fusewoodSword");
		public static ItemStack pickFusewood = ItemController.getItem("ntu", "fusewoodPickaxe");
		public static ItemStack shovelFusewood = ItemController.getItem("ntu", "fusewoodShovel");
		public static ItemStack axeFusewood = ItemController.getItem("ntu", "fusewoodAxe");
		public static ItemStack kamaFusewood = ItemController.getItem("ntu", "fusewoodKama");
		public static ItemStack bowFusewood = ItemController.getItem("ntu", "fusewoodBow");
		
		//Darkwood
		public static ItemStack swordDarkwood = ItemController.getItem("ntu", "darkwoodSword");
		public static ItemStack pickDarkwood = ItemController.getItem("ntu", "darkwoodPickaxe");
		public static ItemStack shovelDarkwood = ItemController.getItem("ntu", "darkwoodShovel");
		public static ItemStack axeDarkwood = ItemController.getItem("ntu", "darkwoodAxe");
		public static ItemStack kamaDarkwood = ItemController.getItem("ntu", "darkwoodKama");
		public static ItemStack bowDarkwood = ItemController.getItem("ntu", "darkwoodBow");
		
		/*//Ghostwood
		public static ItemStack swordGhostwood = ItemController.getItem("ntu", "ghostwoodSword");
		public static ItemStack pickGhostwood = ItemController.getItem("ntu", "ghostwoodPickaxe");
		public static ItemStack shovelGhostwood = ItemController.getItem("ntu", "ghostwoodShovel");
		public static ItemStack axeGhostwood = ItemController.getItem("ntu", "ghostwoodAxe");
		public static ItemStack kamaGhostwood = ItemController.getItem("ntu", "ghostwoodKama");*/
		
		//Armours
		public static ItemStack helmetImp = ItemController.getItem("ntu", "impHelmet");
		public static ItemStack plateImp = ItemController.getItem("ntu", "impJerkin");
		public static ItemStack pantsImp = ItemController.getItem("ntu", "impLeggings");
		public static ItemStack bootsImp = ItemController.getItem("ntu", "impBoots");
		
		//woodtypes = { "eucalyptus", "sakura", "ghost", "redwood", "blood", "bush", "maple", "silverbell", "purpleheart", "tiger", "willow", "darkwood", "fusewood" };
		//plantTypes = {"barley.plant", "barley.flour", "wheat.flour", "cotton.plant", "powder.sulfur", "fletching.ghostwood", "leather.imp", "string.flame", "dye.blue" }
		
		public static void patchDmgEnch()
		{
			planksGhostwood.setItemDamage(2);
			stickGhostwood.setItemDamage(2);
			
			planksBloodwood.setItemDamage(3);
			stickBloodwood.setItemDamage(3);
			
			planksDarkwood.setItemDamage(10);
			stickDarkwood.setItemDamage(10);
			
			planksFusewood.setItemDamage(11);
			stickFusewood.setItemDamage(11);
			
			leatherImp.setItemDamage(6);
			stringFlame.setItemDamage(7);
			
			helmetImp.addEnchantment(Enchantment.protection, 1);
			helmetImp.addEnchantment(Enchantment.fireProtection, 1);
			
			plateImp.addEnchantment(Enchantment.blastProtection, 1);
			plateImp.addEnchantment(Enchantment.fireProtection, 1);
			
			pantsImp.addEnchantment(Enchantment.projectileProtection, 1);
			pantsImp.addEnchantment(Enchantment.fireProtection, 1);
			
			bootsImp.addEnchantment(Enchantment.featherFalling, 1);
			bootsImp.addEnchantment(Enchantment.fireProtection, 1);
		}
}
