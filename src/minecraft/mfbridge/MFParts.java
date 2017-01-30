package mfbridge;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MFParts
{

    //Anvils
    public static final int anvilStone = -1;
    public static final int anvilBronze = 0;
    public static final int anvilIron = 1;
    public static final int anvilSteel = 2;
    public static final int anvilMithril = 3;
    public static final ItemStack anvil = ItemController.getItem("mfb", "anvil");

    //Hammers
    public static final int hammerAny = 0;
    public static final int hammerOrnate = 1;
    
    //Ingots
    public static final ItemStack ingotWroughtIron = minefantasy.api.Components.getItem("misc", 60);
    
    //Machines
    public static final ItemStack bloomery = ItemController.getItem("mfb", VersionController._bloomery_);
    public static final ItemStack forge = ItemController.getItem("mfb", "forge");
    public static final ItemStack furnaceHeater = ItemController.getItem("mfb", "furnace");
    public static final ItemStack benchTop = ItemController.getItem("mfb", "foodPrep");
    public static final ItemStack tailorBench = ItemController.getItem("mfb", "tailor");
    public static final ItemStack weaponRack = ItemController.getItem("mfb", "weaponRack");
    public static final ItemStack oven = ItemController.getItem("mfb", "oven");
    
    //Hafts
    public static final ItemStack haftWeak = minefantasy.api.Components.getItem("misc", 59);
    public static final ItemStack haftStrong = minefantasy.api.Components.getItem("misc", 65);
    public static final ItemStack haftIronbark = minefantasy.api.Components.getItem("misc", 77);
    public static final ItemStack haftEbony = minefantasy.api.Components.getItem("misc", 83);
    public static final ItemStack haftOrnate = minefantasy.api.Components.getItem("misc", 81);

    //Strings
    public static final ItemStack vine = minefantasy.api.Components.getItem("misc", 110);
    public static final ItemStack tendon = minefantasy.api.Components.getItem("misc", 109);

    //plank
    public static final ItemStack plank = minefantasy.api.Components.getItem("plank", 0);

    //chain sheet
    public static final ItemStack chainSheet = minefantasy.api.Components.getItem("misc", 41);

    //Armour parts
    public static final ItemStack smlPlateSteel = minefantasy.api.Components.getItem("misc", 28);
    public static final ItemStack smlPlateIron = minefantasy.api.Components.getItem("misc", 63);

    //Raw hides
    public static final ItemStack hidePig = minefantasy.api.Components.getItem("misc", 3);
    public static final ItemStack hideCow = minefantasy.api.Components.getItem("misc", 17);
    public static final ItemStack hideSheep = minefantasy.api.Components.getItem("misc", 6);
    public static final ItemStack hideHound = minefantasy.api.Components.getItem("misc", 33);
    public static final ItemStack hideMinotaur = minefantasy.api.Components.getItem("misc", 98);
    public static final ItemStack hideDrake = minefantasy.api.Components.getItem("misc", 101);
    public static final ItemStack hideHorse = minefantasy.api.Components.getItem("misc", 154);
    public static final ItemStack hideBasiliskBlue = minefantasy.api.Components.getItem("misc", 157);
    public static final ItemStack hideBasiliskBrown = minefantasy.api.Components.getItem("misc", 160);
    public static final ItemStack hideBasiliskBlack = minefantasy.api.Components.getItem("misc", 163);
    public static final ItemStack leatherRaw = minefantasy.api.Components.getItem("misc", 4);
    public static final ItemStack[] rawHides = {hidePig, hideCow, hideSheep, hideHound, hideMinotaur, hideDrake, hideHorse, hideBasiliskBlue, hideBasiliskBrown, hideBasiliskBlack, leatherRaw};

    //Armours
    public static final ItemStack plateRawhide = minefantasy.api.Components.getItem("armourRawhide", 0);
    public static final ItemStack legsRawhide = minefantasy.api.Components.getItem("legsRawhide", 0);
    public static final ItemStack plateIronSplint = minefantasy.api.Components.getItem("plateIronSplint", 0);
    public static final ItemStack helmetIronSplint = minefantasy.api.Components.getItem("helmetIronSplint", 0);
    public static final ItemStack legsIronSplint = minefantasy.api.Components.getItem("legsIronSplint", 0);
    public static final ItemStack bootsIronSplint = minefantasy.api.Components.getItem("bootsIronSplint", 0);
    
    public static final ItemStack plateEncrusted = minefantasy.api.Components.getItem("plateEncrustedPlate", 0);
    public static final ItemStack helmetEncrusted = minefantasy.api.Components.getItem("helmetEncrustedPlate", 0);
    public static final ItemStack legsEncrusted = minefantasy.api.Components.getItem("legsEncrustedPlate", 0);
    public static final ItemStack bootsEncrusted = minefantasy.api.Components.getItem("bootsEncrustedPlate", 0);
    
    public static final ItemStack bloom = minefantasy.api.Components.getItem("bloom", 0);
    public static final ItemStack bloomIron = new ItemStack(bloom.getItem());
    
    //Misc Components
    public static final ItemStack sharpRock = minefantasy.api.Components.getItem("misc", 108);
    public static final ItemStack shardCopper = minefantasy.api.Components.getItem("misc", 113);
    
    //Weapons
    //Primitive
    public static final ItemStack clubWood = minefantasy.api.Components.getItem("clubWood", 0);
    public static final ItemStack clubStone = minefantasy.api.Components.getItem("clubStone", 0);
    public static final ItemStack spearStone = minefantasy.api.Components.getItem("spearStone", 0);
    public static final ItemStack spearCopper = minefantasy.api.Components.getItem("spearCopper", 0);
    public static final ItemStack javelin = minefantasy.api.Components.getItem("javelin", 0);
    public static final ItemStack sling = minefantasy.api.Components.getItem("sling", 0);
    //Copper
    public static final ItemStack swordCopper = minefantasy.api.Components.getItem("swordCopper", 0);
    //Iron
    public static final ItemStack swordIron = minefantasy.api.Components.getItem("swordIronForged", 0);
    //Ornate
    public static final ItemStack swordOrnate = minefantasy.api.Components.getItem("swordOrnate", 0);
    //Encrusted
    public static final ItemStack swordEncrusted = minefantasy.api.Components.getItem("swordEncrusted", 0);
    
    //Tools
    //Primitive
    public static final ItemStack axeStone = minefantasy.api.Components.getItem("axePrim", 0);
    public static final ItemStack hammerStone = minefantasy.api.Components.getItem("hammerStone", 0);
    public static final ItemStack knifeStone = minefantasy.api.Components.getItem("knifeStone", 0);
    public static final ItemStack lighterPrimitive = minefantasy.api.Components.getItem("rocks", 0);
    public static final ItemStack pickStone = minefantasy.api.Components.getItem("pickStonePrim", 0);
    public static final ItemStack pickCopperPrim = minefantasy.api.Components.getItem("pickCopperPrim", 0);
    public static final ItemStack tongsStone = minefantasy.api.Components.getItem("tongsStone", 0);
    //Copper
    public static final ItemStack pickCopper = minefantasy.api.Components.getItem("pickCopperForged", 0);
    public static final ItemStack axeCopper = minefantasy.api.Components.getItem("axeCopper", 0);
    public static final ItemStack shovelCopper = minefantasy.api.Components.getItem("spadeCopperForged", 0);
    public static final ItemStack hoeCopper = minefantasy.api.Components.getItem("hoeCopperForged", 0);
    //Tin
    public static final ItemStack shovelTin = minefantasy.api.Components.getItem(VersionController._spadeTin_, 0);
    public static final ItemStack axeTin = minefantasy.api.Components.getItem("axeTin", 0);
    public static final ItemStack hoeTin = minefantasy.api.Components.getItem("hoeTin", 0);
    //Bronze
    public static final ItemStack pickBronze = minefantasy.api.Components.getItem("pickBronze", 0);
    public static final ItemStack shovelBronze = minefantasy.api.Components.getItem(VersionController._spadeBronze_, 0);
    public static final ItemStack axeBronze = minefantasy.api.Components.getItem("axeBronze", 0);
    //Iron
    public static final ItemStack pickIron = minefantasy.api.Components.getItem("pickIronForged", 0);
    public static final ItemStack axeIron = minefantasy.api.Components.getItem("axeIronForged", 0);
    public static final ItemStack shovelIron = minefantasy.api.Components.getItem("spadeIronForged", 0);
    public static final ItemStack hoeIron = minefantasy.api.Components.getItem("hoeIronForged", 0);
    public static final ItemStack shearsIron = minefantasy.api.Components.getItem("shearsIron", 0);
    
    
    
    public static void patchNBT()
    {
    	NBTTagCompound nbt = ItemController.getNBT(bloomIron);
    	nbt.setInteger("ingotID", ingotWroughtIron.itemID);
    	nbt.setInteger("ingotMeta", 60);
    }
    

}
