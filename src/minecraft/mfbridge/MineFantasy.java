package mfbridge;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;


public class MineFantasy {
	
	public static boolean hardcoreCraft;
	public static boolean hardcoreTanning;
	public static boolean hardcoreFurnaces;
	public static boolean easyBloomerySmelts;
	public static boolean simpleIronSmelting;
	
		
	public static void init()
	{
		
		MFParts.patchNBT();
		primitives();
		misc();
	}
	
	public static void config(File cfgMF, boolean NFLoaded)
	{
		Configuration mfConfig = new Configuration(cfgMF,true);
		mfConfig.load();
		if(!NFLoaded){
			hardcoreCraft = mfConfig.get("minefantasy hardcore options", "Hardcore Crafting", true).getBoolean(true);
			LogController.info("[MFbridge] Detected Hardcore Crafting as: "+ hardcoreCraft);
			hardcoreTanning = mfConfig.get("minefantasy hardcore options", "Hardcore Leather Tanning", true).getBoolean(true);
			LogController.info("[MFbridge] Detected Hardcore Tanning as: "+ hardcoreTanning);
			hardcoreFurnaces = mfConfig.get("minefantasy hardcore options", "Remove Basic Furnace Recipe", true).getBoolean(true);
			LogController.info("[MFbridge] Detected Hardcore Furnaces as: "+ hardcoreFurnaces);
			easyBloomerySmelts = mfConfig.get("minefantasy hardcore options", "Easy Bloomery Smelts", false).getBoolean(false);
			LogController.info("[MFbridge] Detected Easy Bloomery Smelts as: "+ easyBloomerySmelts);
			simpleIronSmelting = mfConfig.get("minefantasy hardcore options", "Simple Iron Smelting", false).getBoolean(false);
			LogController.info("[MFbridge] Detected Simple Iron Smelting as: "+ simpleIronSmelting);
		}else{
			hardcoreCraft = mfConfig.get("hardcoreoptions", "HardmodeEnabled", true).getBoolean(true);
			LogController.info("[MFbridge] Detected Hardcore Crafting as: "+ hardcoreCraft);
			hardcoreTanning = mfConfig.get("hardcoreoptions", "LeatherExpensiveReceipe", true).getBoolean(true);
			LogController.info("[MFbridge] Detected Hardcore Tanning as: "+ hardcoreTanning);
			hardcoreFurnaces = mfConfig.get("hardcoreoptions", "RemoveBasicFurnaceRecipe", true).getBoolean(true);
			LogController.info("[MFbridge] Detected Hardcore Furnaces as: "+ hardcoreFurnaces);
			easyBloomerySmelts = mfConfig.get("hardcoreoptions", "SimpleSmelting", false).getBoolean(false);
			LogController.info("[MFbridge] Detected Easy Bloomery Smelts as: "+ easyBloomerySmelts);
			simpleIronSmelting = mfConfig.get("hardcoreoptions", "SimpleIronSmelting", false).getBoolean(false);
			LogController.info("[MFbridge] Detected Simple Iron Smelting as: "+ simpleIronSmelting);
		}
		
		if(mfConfig.hasChanged())
		{LogController.severe("MineFantasy config change detected, settings may not be interpreted correctly");}
		mfConfig.save();
	}
	
	private static void misc()
	{
		if(!PluginController.isMineFantasyAGLoaded)
		{
			ItemStack ResultIron = MFParts.bloomIron;
			int time;
			/*if(easyBloomerySmelts)
			{
				ResultIron = MFParts.ingotWroughtIron;
			}*/
			if(simpleIronSmelting)
			{
				//ResultIron = new ItemStack(Item.ingotIron);
				time = 500;
			}
			else
			{
				//ResultIron = MFParts.bloomIron;
				time = 800;
			}
			minefantasy.api.MineFantasyAPI.addBloomRecipe(new ItemStack(Block.oreIron), ResultIron, 300);
		}
	}
	
	 private static void primitives()
	    {
		 			   	FMLLog.info("[MFbridge] Cleaning MF primitive recipes");
	    	for (ItemStack Current: MFParts.rawHides)
	    	{
	    		OreDictionary.registerOre("hideRaw", Current);
	    	}
	    	OreDictionary.registerOre("bindingString", Item.silk);
	    	OreDictionary.registerOre("bindingString", MFParts.vine);
	    	OreDictionary.registerOre("bindingString", MFParts.tendon);
	    	ItemStack[] sharpRocks = {new ItemStack(Item.flint), MFParts.sharpRock};
	    	/*==========UNIVERSAL RECIPES==========*/
	    	//Armour
	    	RecipeController.remove(MFParts.legsRawhide);
	        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.legsRawhide, true, new Object[]{
	                "BB",
	                "FF",
	                'B',"bindingString",
	                'F',"hideRaw"
	                }));
	        
	    	RecipeController.remove(MFParts.plateRawhide);
	        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.plateRawhide, true, new Object[]{
	                "F-F",
	                "BFB",
	                'B',"bindingString",
	                'F',"hideRaw"
	                }));
	        
	        //Clubs
	        RecipeController.remove(MFParts.clubWood);
	        RecipeController.remove(MFParts.clubWood);
	        RecipeController.remove(MFParts.clubWood);
	        RecipeController.remove(MFParts.clubWood);
	        RecipeController.remove(MFParts.clubWood);
	        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.clubWood, true, new Object[]{
	                "BFB",
	                "-B-",
	                "-S-",
	                'B',"bindingString",
	                'F',"plankWood",
	                'S',"stickWood"
	                }));
	        
	        RecipeController.remove(MFParts.clubStone);
	        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.clubStone, true, new Object[]{
	                "BFB",
	                "-B-",
	                "-S-",
	                'B',"bindingString",
	                'F',"cobblestone",
	                'S',"stickWood"
	                }));
	        	        
	        //Picks
	        RecipeController.remove(MFParts.pickStone);
	        for (ItemStack rock: sharpRocks){
	        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.pickStone, true, new Object[]{
	                "FBB",
	                "-S-",
	                "-S-",
	                'B',"bindingString",
	                'F', rock,
	                'S',"stickWood"
	                }));
	        }
	        
	        RecipeController.remove(MFParts.pickCopperPrim);
	        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.pickCopperPrim, true, new Object[]{
	                "FBB",
	                "-S-",
	                "-S-",
	                'B',"bindingString",
	                'F', MFParts.shardCopper,
	                'S',"stickWood"
	                }));
	        	    	
	        //Spears
	        RecipeController.remove(MFParts.spearStone);
	        for (ItemStack rock: sharpRocks){
	        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.spearStone, true, new Object[]{
	                "-BF",
	                "-SB",
	                "S--",
	                'B',"bindingString",
	                'F', rock,
	                'S',"stickWood"
	                }));
	        }
	        
	        RecipeController.remove(MFParts.spearCopper);
	        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.spearCopper, true, new Object[]{
	                "-BF",
	                "-SB",
	                "S--",
	                'B',"bindingString",
	                'F', MFParts.shardCopper,
	                'S',"stickWood"
	                }));
	        
	        //Javelin
	        RecipeController.remove(MFParts.javelin);
	        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.javelin, true, new Object[]{
	                "F",
	                "B",
	                "S",
	                'B',"bindingString",
	                'F', MFParts.sharpRock,
	                'S',"stickWood"
	                }));
	        
	        //Axe
	        RecipeController.remove(MFParts.axeStone);
	        for (ItemStack rock: sharpRocks){
	        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.axeStone, true, new Object[]{
	                "-B",
	                "BF",
	                "S-",
	                'B',"bindingString",
	                'F', rock,
	                'S',"stickWood"
	                }));
	        }
	               
	        /*==========UNIVERSAL RECIPES END==========*/
	        RecipeController.remove(MFParts.tongsStone);
	        RecipeController.remove(MFParts.tongsStone);
	        RecipeController.remove(MFParts.tongsStone);
	        
	        RecipeController.remove(MFParts.knifeStone);
	        RecipeController.remove(MFParts.knifeStone);
	        
	        if (hardcoreCraft){
	            //Hammer
		        RecipeController.remove(MFParts.hammerStone);
		        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.hammerStone, true, new Object[]{
		                "BFB",
		                "-S-",
		                'B', "bindingString",
		                'F', "cobblestone",
		                'S', MFParts.plank
		                }));
		        
		        //Knife
		        for (ItemStack rock: sharpRocks){
		        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.knifeStone, true, new Object[]{
		                "BF",
		                "SB",
		                'B', "bindingString",
		                'F', rock,
		                'S',"stickWood"
		                }));
		        }
		        
		        
		        //Tongs
		        for (ItemStack rock: sharpRocks){
		        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.tongsStone, true, new Object[]{
		                "FB",
		                "SF",
		                'B', "bindingString",
		                'F', rock,
		                'S',"stickWood"
		                }));
		        }
	        }else{
	            //Hammer
		        RecipeController.remove(MFParts.hammerStone);
		        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.hammerStone, true, new Object[]{
		                "F",
		                "S",
		                'F', "cobblestone",
		                'S', MFParts.plank
		                }));
		        
		        //Knife
		        for (ItemStack rock: sharpRocks){
		        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.knifeStone, true, new Object[]{
		                "-F",
		                "S-",
		                'F', rock,
		                'S',"stickWood"
		                }));
		        }
		        
		        //Tongs
		        for (ItemStack rock: sharpRocks){
		        GameRegistry.addRecipe(new ShapedOreRecipe(MFParts.tongsStone, true, new Object[]{
		                "F-",
		                "SF",
		                'F', rock,
		                'S',"stickWood"
		                }));
		        }
	        }
	    	FMLLog.info("[MFbridge] Cleaning MF primitive recipes complete");
	    }
}
	 
