package mfbridge;

import net.minecraft.item.ItemStack;

public class Thaumcraft {
	public static void init()
	{
		LogController.info("Bridging Thaumcraft");
		TMCParts.patch();
		metals();
		armours();
		tools();
		weapons();
		LogController.info("Bridging Thaumcraft Complete");
	}
	
	private static void metals()
	{
		minefantasy.api.MineFantasyAPI.addHeatableItem(TMCParts.ingotThaumium, 500, 700, 750);
	}
	
	private static void armours()
	{
		ItemStack activeK = TMCParts.ingotThaumium;
		ItemStack activeS = MFParts.smlPlateIron;
		
		RecipeController.remove(TMCParts.helmetThaumium);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TMCParts.helmetThaumium, true, MFParts.hammerAny, MFParts.anvilIron, 600, new Object[]
                {
                    "-KKK-",
                    "KSSSK",
                    "-S-S-",
                    'K', activeK,
                    'S', activeS
                });
        
		RecipeController.remove(TMCParts.plateThaumium);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TMCParts.plateThaumium, true, MFParts.hammerAny, MFParts.anvilIron, 1000, new Object[]
                {
                    "-K-K-",
                    "KS-SK",
                    "KSSSK",
                    "KSSSK",
                    'K', activeK,
                    'S', activeS
                });
		
		RecipeController.remove(TMCParts.legsThaumium);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TMCParts.legsThaumium, true, MFParts.hammerAny, MFParts.anvilIron, 800, new Object[]
                {
                    "-KKK-",
                    "KSSSK",
                    "KS-SK",
                    "-S-S-",
                    'K', activeK,
                    'S', activeS
                });
        
		RecipeController.remove(TMCParts.bootsThaumium);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TMCParts.bootsThaumium, true, MFParts.hammerAny, MFParts.anvilIron, 400, new Object[]
                {
                    "-S-S-",
                    "-S-S-",
                    "KK-KK",
                    'K', activeK,
                    'S', activeS
                });
		
	}
	private static void tools()
	{
	
		RecipeController.remove(TMCParts.pickThaumium);
		minefantasy.api.MineFantasyAPI.addAnvilRecipe(TMCParts.pickThaumium, true, 0, MFParts.anvilBronze, 800, new Object[]
				{
				"--K",
				"HHK",
				"--K",
				'H',MFParts.haftStrong,
				'K',TMCParts.ingotThaumium
				});
		
		RecipeController.remove(TMCParts.shovelThaumium);
		minefantasy.api.MineFantasyAPI.addAnvilRecipe(TMCParts.shovelThaumium, true, 0, MFParts.anvilBronze, 700, new Object[]
				{
				"HHK",
				'H',MFParts.haftWeak,
				'K',TMCParts.ingotThaumium
				});
		
		RecipeController.remove(TMCParts.axeThaumium);
		minefantasy.api.MineFantasyAPI.addAnvilRecipe(TMCParts.axeThaumium, true, 0, MFParts.anvilBronze, 800, new Object[]
				{
				"-KK",
				"HHK",
				'H',MFParts.haftStrong,
				'K',TMCParts.ingotThaumium
				});
		
		RecipeController.remove(TMCParts.hoeThaumium);
		minefantasy.api.MineFantasyAPI.addAnvilRecipe(TMCParts.hoeThaumium, true, 0, MFParts.anvilBronze, 800, new Object[]
				{
				"--K",
				"HHK",
				'H',MFParts.haftStrong,
				'K',TMCParts.ingotThaumium
				});
	}
	private static void weapons()
	{
		RecipeController.remove(TMCParts.swordThaumium);
		minefantasy.api.MineFantasyAPI.addAnvilRecipe(TMCParts.swordThaumium, true, 0, MFParts.anvilBronze, 1000, new Object[]
				{
				"-K--",
				"HKKK",
				"-K--",
				'H',MFParts.haftStrong,
				'K',TMCParts.ingotThaumium
				});		
	}
}
