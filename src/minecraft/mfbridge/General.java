package mfbridge;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class General
{
	public static void init()
	{
		chain();
		metals();
		misc();
		goldWeapons();
	}
	
    public static void chain()
    {
        LogController.info("Cleaning vanilla chain armour");
        RecipeController.remove(new ItemStack(Item.helmetChain));
        RecipeController.remove(new ItemStack(Item.plateChain));
        RecipeController.remove(new ItemStack(Item.legsChain));
        RecipeController.remove(new ItemStack(Item.bootsChain));
        LogController.info("Cleaning vanilla chain armour complete");
    }

    public static void metals()
    {
        LogController.info("Adjusting vanilla metals");
        minefantasy.api.MineFantasyAPI.addHeatableItem(new ItemStack(Item.goldNugget, 1), 300, 500, 610);
        LogController.info("Adjusting vanilla metals complete");
    }
       
    public static void misc()
    {
    	//ChestGenHooks.
        LogController.info("Making Miscellaneous Patches");
        if (MineFantasy.hardcoreCraft)
        {
	        RecipeController.remove(new ItemStack(Item.pickaxeWood,1));
	        RecipeController.remove(new ItemStack(Item.axeWood,1));
	        RecipeController.remove(new ItemStack(Item.shovelWood,1));
	        RecipeController.remove(new ItemStack(Item.swordWood,1));
	        RecipeController.remove(new ItemStack(Item.hoeWood,1));
    	}	
        RecipeController.remove(new ItemStack(Block.fenceIron));
        	for(ItemStack Part: new ItemStack[] {new ItemStack(Item.ingotIron), MFParts.ingotWroughtIron}){
			minefantasy.api.MineFantasyAPI.addAnvilRecipe(new ItemStack(Block.fenceIron,16),false, MFParts.hammerAny,MFParts.anvilStone, 400, new Object[]
		            {
					"TTT",
		            "TTT",
		            'T', Part,
		            });	
		}
        if (MineFantasy.hardcoreFurnaces)
        {
        	RecipeController.remove(new ItemStack(Item.minecartPowered));
        	GameRegistry.addRecipe(new ItemStack(Item.minecartPowered), new Object[]{
        		"F",
        		"M",
        		'F', MFParts.bloomery,
        		'M', Item.minecartEmpty
        	});
        }
        	
        LogController.info("Miscellaneous Patches complete");
        

    }
    
    public static void goldWeapons()
    {
    	LogController.info("Adding Recipes to Gold Tools");
    	minefantasy.api.MineFantasyAPI.addAnvilRecipe(new ItemStack(Item.pickaxeGold),false, MFParts.hammerAny,MFParts.anvilIron, 200, new Object[]
                {
                "--I",
                "HHI",
                "--I",
                'H', MFParts.haftStrong,
                'I', Item.ingotGold
                });
    	
    	minefantasy.api.MineFantasyAPI.addAnvilRecipe(new ItemStack(Item.axeGold),false, MFParts.hammerAny,MFParts.anvilIron, 200, new Object[]
                {
                "-II",
                "HHI",
                'H', MFParts.haftWeak,
                'I', Item.ingotGold
                });
    	
    	minefantasy.api.MineFantasyAPI.addAnvilRecipe(new ItemStack(Item.shovelGold),false, MFParts.hammerAny,MFParts.anvilIron, 200, new Object[]
                {
                "HHI",
                'H', MFParts.haftWeak,
                'I', Item.ingotGold
                });
    	
    	minefantasy.api.MineFantasyAPI.addAnvilRecipe(new ItemStack(Item.hoeGold),false, MFParts.hammerAny,MFParts.anvilIron, 200, new Object[]
                {
                "--I",
                "HHI",
                'H', MFParts.plank,
                'I', Item.ingotGold
                });
    	
    	LogController.info("Adding Recipes to Gold Tools complete");
    }
}
