package mfbridge;

import java.util.ArrayList;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BalkonsWeaponMod {
	
	public static boolean useChain=false;
	private final static ItemStack[] types = {new ItemStack(Item.silk),MFParts.vine,MFParts.tendon};
	
public static void init(){
	FMLLog.info("[MFbridge] Bridging Balkon's Weapon Mod");
	Flails();
	Knives();
	Katanas();
	Boomerangs();
	Duplicates();
	FMLLog.info("[MFbridge] Bridging Balkon's Weapon Mod complete");
}


private static void Flails() {
	Item rope;
	if(PluginController.isBattlegearLoaded & BGParts.chain != null){rope = BGParts.chain.getItem();}else{rope = Item.silk; FMLLog.info("[MFbridge] Battlegear2 chain not present, using string for flails");}
	
    	//Wooden Flail
    	ItemStack flailWood = ItemController.getItem("BWM","flailWood");
    	RecipeController.remove(flailWood);
    	for(ItemStack Log: ItemController.getOreDict("logWood"))
    	{
    		for(ItemStack Part: types){
    		//minefantasy.api.MineFantasyAPI.addAnvilRecipe(result, hot, hammerType, anvil, forgeTime, input);
        	minefantasy.api.MineFantasyAPI.addAnvilRecipe(flailWood,false, MFParts.hammerAny,MFParts.anvilStone, 200, new Object[]
                    {
                    "--C---",
                    "-H-C--",
                    "H---C-",
                    "----S-",
                    'H', MFParts.plank,
                    'C', Part,
                    'S', Log
                    });
    		}
    	};
    	
    	//Stone Flail
    	ItemStack flailStone = ItemController.getItem("BWM","flailStone");
    	RecipeController.remove(flailStone);
    	for(ItemStack Cobble: ItemController.getOreDict("cobblestone"))
    	{
        	minefantasy.api.MineFantasyAPI.addAnvilRecipe(flailStone,false, MFParts.hammerAny,MFParts.anvilStone, 300, new Object[]
                    {
                    "--C---",
                    "-H-C--",
                    "H---C-",
                    "----S-",
                    'H', MFParts.haftWeak,
                    'C', rope,
                    'S', Cobble
                    });
    	};

    	//Iron Flail
    	ItemStack flailSteel = ItemController.getItem("BWM","flailSteel");
    	RecipeController.remove(flailSteel);
    	for(ItemStack Iron: ItemController.getOreDict("ingotIron"))
    	{
        	minefantasy.api.MineFantasyAPI.addAnvilRecipe(flailSteel,true, MFParts.hammerAny,MFParts.anvilIron, 350, new Object[]
                    {
                    "--C---",
                    "-H-C--",
                    "H---CS",
                    "----SS",
                    'H', MFParts.haftStrong,
                    'C', rope,
                    'S', Iron
                    });
    	};
    	
    	//Diamond Flail
    	ItemStack flailDiamond = ItemController.getItem("BWM","flailDiamond");
    	RecipeController.remove(flailDiamond);
    	        	minefantasy.api.MineFantasyAPI.addAnvilRecipe(flailDiamond,false, MFParts.hammerAny,MFParts.anvilSteel, 400, new Object[]
                    {
                    "--C---",
                    "-H-C--",
                    "H---CD",
                    "----DD",
                    'H', MFParts.haftStrong,
                    'D', Item.diamond,
                    'C', rope,
                    });
    	
    	//Gold Flail
    	ItemStack flailGold = ItemController.getItem("BWM","flailGold");
    	RecipeController.remove(flailGold);
    	       	minefantasy.api.MineFantasyAPI.addAnvilRecipe(flailGold,true, MFParts.hammerAny,MFParts.anvilSteel, 475, new Object[]
                    {
                    "--C---",
                    "-H-C--",
                    "H---CS",
                    "----SS",
                    'H', MFParts.haftOrnate,
                    'C', rope,
                    'S', Item.ingotGold
                    });
    	}
 
private static void Knives() {
	
	//Wooden knife
	ItemStack Current = ItemController.getItem("BWM","knifeWood");
	RecipeController.remove(Current);

	for(ItemStack Part: types){
    	GameRegistry.addRecipe(Current, new Object[]
                {
                "TB",
                "HT",
                'H', MFParts.haftWeak,
                'T', Part,
                'B', MFParts.plank
                });
	}

    	
    	//Stone knife
    	Current = ItemController.getItem("BWM","knifeStone");
    	RecipeController.remove(Current);
    	for(ItemStack Part: types){
	    //	for(ItemStack Cobble: ItemController.getOreDict("cobblestone"))
	    //	{
	        	GameRegistry.addRecipe(Current, new Object[]
	                    {
	        			"TB",
	                    "HT",
	                    'H', MFParts.haftWeak,
	                    'T', Part,
	                    'B', MFParts.sharpRock
	                    });	
	    	//}
    	}
    	
    	//Iron knife
    	Current = ItemController.getItem("BWM","knifeSteel");
    	RecipeController.remove(Current);
    	for(ItemStack OreDict: ItemController.getOreDict("ingotIron"))
    	{
        	minefantasy.api.MineFantasyAPI.addAnvilRecipe(Current,true, MFParts.hammerAny,MFParts.anvilIron, 200, new Object[]
                    {
        			"B",
                    "H",
                    'H', MFParts.haftWeak,
                    'B', OreDict
                    });
    	}
    	
    	//Diamond knife
    	Current = ItemController.getItem("BWM","knifeDiamond");
    	RecipeController.remove(Current);
    	for(ItemStack Part: types){
	    	minefantasy.api.MineFantasyAPI.addAnvilRecipe(Current,false, MFParts.hammerAny,MFParts.anvilSteel, 225, new Object[]
	                {
	    			"TB",
	                "HT",
	                'H', MFParts.haftWeak,
	                'T', Part,
	                'B', Item.diamond
	                });
    	}
    	
    	//Gold knife
    	Current = ItemController.getItem("BWM","knifeGold");
    	RecipeController.remove(Current);
    	RecipeController.remove(Current);
        	minefantasy.api.MineFantasyAPI.addAnvilRecipe(Current,true, MFParts.hammerAny,MFParts.anvilSteel, 225, new Object[]
                    {
                    "B",
                    "H",
                    'H', MFParts.haftOrnate,
                    'B', Item.ingotGold
                    });
}

private static void Katanas(){
	    //Wooden katana
		ItemStack Current = ItemController.getItem("BWM","katanaWood");
		RecipeController.remove(Current);
		for(ItemStack Part: types){
	    	GameRegistry.addRecipe(Current, new Object[]
	                {
	    			"--B",
	                "TB-",
	                "HT-",
	                'H', MFParts.haftWeak,
	                'T', Part,
	                'B', MFParts.plank
	                });
			}

	    	//Stone katana
			Current = ItemController.getItem("BWM","katanaStone");
			RecipeController.remove(Current);
			for(ItemStack Stone: ItemController.getOreDict("stone"))
	    	{
				for(ItemStack Part: types){
			    	GameRegistry.addRecipe(Current, new Object[]
		                {
						"--R",
		                "TB-",
		                "HT-",
		                'H', MFParts.haftWeak,
		                'T', Part,
		                'B', Stone,
		                'B', MFParts.sharpRock
		                });
				}
	    	}
			
	    	//Iron katana
			Current = ItemController.getItem("BWM","katanaSteel");
			RecipeController.remove(Current);
			for(ItemStack Iron: ItemController.getOreDict("ingotIron"))
	    	{
				minefantasy.api.MineFantasyAPI.addAnvilRecipe(Current,true, MFParts.hammerAny,MFParts.anvilIron, 350, new Object[]
		                {
						"--B",
		                "-B-",
		                "H--",
		                'H', MFParts.haftStrong,
		                'B', Iron
		                });
	    	}
			//Diamond katana
			Current = ItemController.getItem("BWM","katanaDiamond");
			RecipeController.remove(Current);
			for(ItemStack Steel: ItemController.getOreDict("ingotSteel"))
	    	{
						minefantasy.api.MineFantasyAPI.addAnvilRecipe(Current,true, MFParts.hammerAny,MFParts.anvilSteel, 400, new Object[]
		                {
						"--B",
		                "-S-",
		                "H--",
		                'H', MFParts.haftStrong,
		                'B', Item.diamond,
		                'S', Steel
		                });
	    	}
			//Gold katana
			Current = ItemController.getItem("BWM","katanaGold");
			RecipeController.remove(Current);
				minefantasy.api.MineFantasyAPI.addAnvilRecipe(Current,true, MFParts.hammerAny,MFParts.anvilSteel, 350, new Object[]
		                {
						"--B",
		                "-B-",
		                "H--",
		                'H', MFParts.haftOrnate,
		                'B', Item.ingotGold
		                });
	}

private static void Boomerangs(){
	
    //Wooden boomerang
	ItemStack Current = ItemController.getItem("BWM","boomerangWood");
	RecipeController.remove(Current);
	for(ItemStack Part: types){
    	GameRegistry.addRecipe(Current, new Object[]
                {
    			"BBB",
                "-TB",
                "--B",
                'T', Part,
                'B', MFParts.plank
                });	
	}
    	
	//Stone boomerang
	 Current = ItemController.getItem("BWM","boomerangStone");
	RecipeController.remove(Current);
	for(ItemStack Cobble: ItemController.getOreDict("cobblestone"))
	{
		for(ItemStack Part: types){
	    	GameRegistry.addRecipe(Current, new Object[]
	            {
				"BBH",
	            "-TB",
	            "--B",
	            'H', Cobble,
	            'T', Part,
	            'B', MFParts.plank
	            });	
		}
	}
	
	//Iron boomerang
		 Current = ItemController.getItem("BWM","boomerangSteel");
		RecipeController.remove(Current);
		for(ItemStack Ingot: ItemController.getOreDict("ingotIron"))
		{
			minefantasy.api.MineFantasyAPI.addAnvilRecipe(Current,true, MFParts.hammerAny,MFParts.anvilIron, 250, new Object[]
		            {
					"BBH",
		            "--B",
		            "--B",
		            'H', Ingot,
		            'B', MFParts.plank
		            });	
		}
		//Diamond boomerang
		 Current = ItemController.getItem("BWM","boomerangDiamond");
		RecipeController.remove(Current);
		for(ItemStack Part: types){
			minefantasy.api.MineFantasyAPI.addAnvilRecipe(Current,false, MFParts.hammerAny,MFParts.anvilSteel, 300, new Object[]
		            {
					"BBH",
		            "-TB",
		            "--B",
		            'H', Item.diamond,
		            'T', Part,
		            'B', MFParts.plank
		            });	
		}
			
		//Gold boomerang
		 Current = ItemController.getItem("BWM","boomerangGold");
		RecipeController.remove(Current);
			minefantasy.api.MineFantasyAPI.addAnvilRecipe(Current,true, MFParts.hammerAny,MFParts.anvilSteel, 300, new Object[]
		            {
					"BBH",
		            "--B",
		            "--B",
		            'H', Item.ingotGold,
		            'B', MFParts.plank
		            });	
	
	}

private static void Duplicates(){
	String[] types = {"Wood","Stone","Steel","Gold","Diamond"};
	for(String Current: types){
		//Spears
		ItemStack Spear = ItemController.getItem("BWM","spear"+Current);
		RecipeController.remove(Spear);
		
		//Warhammers
		ItemStack Warhammer = ItemController.getItem("BWM","warhammer"+Current);
		RecipeController.remove(Warhammer);
		
		//BattleAxes
		ItemStack Battleaxe = ItemController.getItem("BWM","battleaxe"+Current);
		RecipeController.remove(Battleaxe);
		
		//Halberds
		ItemStack Halberd = ItemController.getItem("BWM","halberd"+Current);
		RecipeController.remove(Halberd);
		}
		//Crossbow
		ItemStack Crossbow = ItemController.getItem("BWM","crossbow");
		RecipeController.remove(Crossbow);
		
		//Crossbow Bolts
		ItemStack CrossbowBolt = ItemController.getItem("BWM","bolt");
		if (CrossbowBolt !=null)
		{
			ItemStack tmp = CrossbowBolt.splitStack(4);
			RecipeController.remove(tmp);
		}
	}
}