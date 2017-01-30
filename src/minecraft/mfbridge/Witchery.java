package mfbridge;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;

public class Witchery {

	public static void init()
	{
		FMLLog.info("[MFbridge] Bridging Witchery");
		main();
		FMLLog.info("[MFbridge] Bridging Witchery complete");
	}
	
	private static void main()
	{
		RecipeController.remove(WCHParts.witchesOven);
    	for(ItemStack Part: ItemController.getOreDict("ingotIron"))
    	{
			minefantasy.api.MineFantasyAPI.addAnvilRecipe(WCHParts.witchesOven,false, MFParts.hammerAny,MFParts.anvilStone, 400, new Object[]
		            {
					"-B-",
		            "TTT",
		            "TFT",
		            'B', Item.bucketEmpty,
		            'T', Part,
		            'F', Block.fenceIron,
		            });	
    	}
	}
}
