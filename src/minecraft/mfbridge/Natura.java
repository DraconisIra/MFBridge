package mfbridge;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class Natura {

	public static void init()
	{
		FMLLog.info("[MFbridge] Bridging Natura");
		
		NTUParts.patchDmgEnch();
		
		if (MineFantasy.hardcoreFurnaces)
		{
			RecipeController.remove(NTUParts.netherrackFurnace);
		}
		
		toolsWeapons();

		FMLLog.info("[MFbridge] Bridging Natura complete");
	}
	
	private static void toolsWeapons()
	{
		RecipeController.remove(NTUParts.swordBloodwood);
		minefantasy.api.MineFantasyAPI.addAnvilRecipe(NTUParts.swordBloodwood, false, MFParts.hammerAny, MFParts.anvilStone, 800, new Object[]
	            {
				"FS--",
	            "HBBB",
	            "FS--",
	            'H', MFParts.haftStrong,
	            'S', NTUParts.stickBloodwood,
	            'B', NTUParts.planksBloodwood,
	            'F', NTUParts.stringFlame
	            });	
	
		RecipeController.remove(NTUParts.axeBloodwood);
		minefantasy.api.MineFantasyAPI.addAnvilRecipe(NTUParts.axeBloodwood,false, MFParts.hammerAny,MFParts.anvilStone, 300, new Object[]
	            {
				"-BB",
	            "HSB",
	            "-FF",
	            'H', MFParts.haftStrong,
	            'S', NTUParts.stickBloodwood,
	            'B', NTUParts.planksBloodwood,
	            'F', NTUParts.stringFlame
	            });	
		RecipeController.remove(NTUParts.pickBloodwood);
		RecipeController.remove(NTUParts.shovelBloodwood);
		RecipeController.remove(NTUParts.kamaBloodwood);
	}
	
}
