package mfbridge;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ArsMagica {
	public static void init()
	{
		LogController.info("Bridging Ars Magica");
		AMParts.patch();
		armours();
		misc();
		bindingCatalysts();
		LogController.info("Bridging Ars Magica Complete");
		
	}
	
	private static void armours()
	{}
	
	private static void misc()
	{
		if (MineFantasy.hardcoreCraft)
		{
			RecipeController.remove(AMParts.mobFocus );
			GameRegistry.addRecipe(AMParts.mobFocus, new Object[]{
					 	"S",
		                "F",
		                "S",
		                'F', AMParts.standardFocus,
		                'S', MFParts.swordIron
		                });
			
			RecipeController.remove(AMParts.flickerFocusFlatLands );
			GameRegistry.addRecipe(AMParts.flickerFocusFlatLands, new Object[]{
					 	"S-P",
		                "FEI",
		                "-B-",
		                'P', MFParts.pickIron,
		                'S', MFParts.shovelIron,
		                'B', AMParts.runeBlack,
		                'F', AMParts.flickerJarEarth,
		                'E', AMParts.essenceEarth,
		                'I', AMParts.flickerJarIce
		                });
		}
	}
	
	private static void bindingCatalysts()
	{
		if (MineFantasy.hardcoreCraft)
		{
			General.goldWeapons();
			
			RecipeController.remove(AMParts.bindingCatalystSword );
			GameRegistry.addRecipe(AMParts.bindingCatalystSword, new Object[]{
					 	"SVS",
		                "SGS",
		                "SVS",
		                'S', Item.slimeBall,
		                'G', MFParts.swordOrnate,
		                'V', AMParts.dustVinteumPurified,
		                });
		}
	}
	
	private static void Fuels()
	{
		//am2.api
	}
}
