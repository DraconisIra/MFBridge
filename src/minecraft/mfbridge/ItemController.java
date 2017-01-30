package mfbridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemController
{
	private static String _AM2_ = "am2.items.ItemsCommonProxy";
	private static List<String> AMItems = Arrays.asList("ItemOre",  "ItemRune", "ItemFocusLesser", "ItemFocusStandard", "ItemFocusMana", "ItemFocusCharge", "ItemPlayerFocus", "ItemMobFocus", "ItemMobFocus", "ItemItemFocus", "ItemCreatureFocus", "ItemFlickerFocus", "ItemBindingCatalyst", "ItemEssence","ItemFlickerJar");
    
		
	public static ItemStack getItem(String modString, String ItemString)
    {
        ItemStack item = null;

        //Balkon's WeaponMod
        if (modString.toLowerCase().equals("bwm"))
        {
            item = itemGet("weaponmod.BalkonsWeaponMod", ItemString);
        }
        //Battlegear2
        else if (modString.toLowerCase().equals("bg2"))
        {
            item = forgeGet("battlegear2", ItemString);
        }
        //Battlegear2
        else if (modString.toLowerCase().equals("bg2m"))
        {
            item = itemGet("mods.battlegear2.utils.BattlegearConfig", ItemString);
        }
        //MineFantasy Item
        else if (modString.toLowerCase().equals("mf"))
        {
            item = itemGet(VersionController._MFItem_, ItemString);
        }
      //MineFantasy Block
        else if (modString.toLowerCase().equals("mfb"))
        {
            item = itemGet(VersionController._MFBlock_, ItemString);
        }
        //Witchery
       // else if (modString.toLowerCase().equals("wch"))
       // {
        //    item = forgeGet("witchery", ItemString);
       // }
        //Witchery
        else if (modString.toLowerCase().equals("wch"))
        {
            item = itemGet("com.emoniph.witchery.Witchery", ItemString);
        }
        //Twilight Forest
        else if (modString.toLowerCase().equals("tfm"))
        {
            item = itemGet("twilightforest.TFItems", ItemString);
        }
        //Twilight Forest
        else if (modString.toLowerCase().equals("tf"))
        {
            item = forgeGet("TwilightForest", ItemString);
        }
        //Twilight Forest
        else if (modString.toLowerCase().equals("moc"))
        {
            item = itemGet("drzhark.mocreatures.MoCreatures", ItemString);
        }
        //Natura
        else if (modString.toLowerCase().equals("ntu"))
        {
            item = itemGet("mods.natura.common.NContent", ItemString);
        }
        //Thaumcraft
        else if (modString.toLowerCase().equals("tmc"))
        {
            item = itemGet("thaumcraft.common.config.ConfigItems", ItemString);
        }
        //Blood Magic items
        else if (modString.toLowerCase().equals("bm"))
        {
            item = itemGet("WayofTime.alchemicalWizardry.ModItems", ItemString);
        }
        //Blood Magic blocks
        else if (modString.toLowerCase().equals("bmb"))
        {
            item = itemGet("WayofTime.alchemicalWizardry.ModBlocks", ItemString);
        }
        //Ars Magica
        else if (modString.toLowerCase().equals("am2"))
        {
            item = itemGet(_AM2_, ItemString);
        }
        else
        {
            System.out.println("!!_____Invalid Mod Def: " + modString + "_____!!");
        }

        return item;
    }

    private static ItemStack itemGet(String classString, String itemString)
    {
        ItemStack item = null;

        try
        {
            String itemClass = classString;
            Object obj = Class.forName(itemClass).getField(itemString).get(null);

            if (obj instanceof Item)
            {
                item = new ItemStack((Item) obj, 1);
            }
            else if (obj instanceof Block)
            {
                item = new ItemStack((Block) obj, 1);
            }
            else if (obj instanceof ItemStack)
            {
                item = (ItemStack) obj;
            }
            else if(classString == _AM2_)
            {
            	//LogController.severe(obj.getClass().getName().split(".")[2]);
            	if (AMItems.contains(obj.getClass().getName().split(".")[2]))
                {
                    item = new ItemStack((Item) obj, 1);
                }
            }
         /*   if(classString == _AM2_)
            {
            	LogController.severe(obj.getClass().getName().split(".")[2]);
            	//LogController.severe(obj.getClass().getName());
            }*/
        }
        catch (Exception ex)
        {
            FMLLog.warning("[MFbridge] " + itemString + " not found in " + classString);
        }

        return item;
    }

    public static ItemStack forgeGet(String modID, String itemName)
    {
        ItemStack item = null;
        item = GameRegistry.findItemStack(modID, itemName, 1);

        if (item == null)
        {
            FMLLog.warning("[MFbridge] " + itemName + " not found in " + modID);
        }

        return item;
    }
    public static ItemStack forgeBlock(String modID, String blockName)
    {
        Block block = null;
        block = GameRegistry.findBlock(modID, blockName);

        if (block == null)
        {
            FMLLog.warning("[MFbridge] " + blockName + " not found in " + modID);
        }

        return new ItemStack(block, 1);
    }

    public static ArrayList<ItemStack> getOreDict(String name)
    {
        ArrayList<ItemStack> result = OreDictionary.getOres(name);

        if (result.isEmpty())
        {
            FMLLog.severe("[MF Bridge] No results found in OreDictionary for " + name);
        }

        return result;
    }
    public static NBTTagCompound getNBT(ItemStack item)
    {
    	if (!item.hasTagCompound())
    	{
    		item.setTagCompound(new NBTTagCompound());
    	}
    	
    	return item.getTagCompound();
    }
}