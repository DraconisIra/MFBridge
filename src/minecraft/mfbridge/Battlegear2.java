package mfbridge;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Battlegear2
{
    private static final String[] weaponTypes = {"wood", "stone", "iron", "diamond", "gold"};
    private static final String[] shieldTypes = {"hide", "iron", "diamond", "gold"};

    public static void init()
    {
        FMLLog.info("[MFbridge] Bridging Battlegear2");
        duplicates();
        shields();
        misc();
        FMLLog.info("[MFbridge] Battlegear2 complete");
    }

    private static void duplicates()
    {
        for (String type: weaponTypes)
        {
            ItemStack Current = ItemController.getItem("bg2", "dagger." + type);
            if(Current != null){RecipeController.remove(Current);}
            Current = ItemController.getItem("bg2", "waraxe." + type);
            if(Current != null){RecipeController.remove(Current);}
            Current = ItemController.getItem("bg2", "spear." + type);
            if(Current != null){RecipeController.remove(Current);}
            Current = ItemController.getItem("bg2", "mace." + type);
            if(Current != null){RecipeController.remove(Current);}
        }
    }

    private static void shields()
    {
        for (String type: shieldTypes)
        {
            ItemStack Current = ItemController.getItem("bg2", "item.battlegear2:shield." + type);
            if(Current != null){RecipeController.remove(Current);}
        }

        ItemStack Current = ItemController.getItem("bg2", "item.battlegear2:shield.hide");
        if(Current != null)
        {
	        minefantasy.api.MineFantasyAPI.addTailorRecipe(Current, 8, 1.0F, 1, new Object[]
	                {
	                    "-PP-",
	                    "PLLP",
	                    "PLLP",
	                    "-PP-",
	                    'P', MFParts.plank,
	                    'L', Item.leather,
	                });
	   }
    }

    private static void misc()
    {
    	//Chain
    	if(BGParts.chain != null)
    	{
    		ItemStack chain = BGParts.chain.splitStack(3);
            RecipeController.remove(chain);

	        //minefantasy.api.MineFantasyAPI.addShapelessAnvilRecipe(new ItemStack(chain.getItem(),3), 100, new Object[]{ItemController.getOreDict("ingotIron"),ItemController.getOreDict("ingotIron")});
	        for (ItemStack Ingot: ItemController.getOreDict("ingotIron"))
	        {
	            minefantasy.api.MineFantasyAPI.addAnvilRecipe(chain, true, MFParts.hammerAny, MFParts.anvilStone, 100, new Object[]
	                    {
	                        "C",
	                        "C",
	                        'C', Ingot
	                    });
	        }
    	}
    	
        //Quiver
        if(BGParts.quiver != null)
        {
        		RecipeController.remove(BGParts.quiver);
                minefantasy.api.MineFantasyAPI.addTailorRecipe(BGParts.quiver, 14, 2.0F , 1, new Object[]
                {
                    "K-K",
                    "K-K",
                    "KKK",
                    'K', Item.leather
                });
        }
    }
   
}
