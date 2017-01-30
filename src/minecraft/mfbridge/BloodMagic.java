package mfbridge;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class BloodMagic {
	public static void init()
	{
		LogController.info("Bridging Blood Magic");
		general();
		altar();
		LogController.info("Bridging Blood Magic Complete");
	}
	private static void altar()
	{
		if (MineFantasy.hardcoreCraft)
		{
			WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry.registerAltarRecipe(BMParts.daggerOfSacrifice, MFParts.swordCopper, 2, 3000, 5, 5, false);	
		}
			
	}
	
	private static void general()
	{
		if (MineFantasy.hardcoreFurnaces)
		{
			RecipeController.remove(BMParts.bloodAltar);
			GameRegistry.addRecipe(BMParts.bloodAltar, new Object[]{
					"S-S",
					"SFS",
					"GDG",
					'S', Block.stone,
					'F', MFParts.forge,
					'G', Item.ingotGold,
					'D', Item.diamond
			});
		}
	}
}
