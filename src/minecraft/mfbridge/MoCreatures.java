package mfbridge;

import net.minecraft.item.Item;
import cpw.mods.fml.common.FMLLog;

public class MoCreatures
{
    public static void init()
    {
        FMLLog.info("[MFbridge] Bridging Mo' Creatures");
        Armours();
        FMLLog.info("[MFbridge] Bridging Mo' Creatures Complete");
    }

    public static void Armours()
    {
        //Fur
        RecipeController.remove(MoCParts.plateFur);
        minefantasy.api.MineFantasyAPI.addTailorRecipe(MoCParts.plateFur, 30, 2.0F , 1, new Object[]
                {
                    "K-K",
                    "KKK",
                    "KKK",
                    'K', MoCParts.fur
                });
        RecipeController.remove(MoCParts.helmetFur);
        minefantasy.api.MineFantasyAPI.addTailorRecipe(MoCParts.helmetFur, 14, 2.0F , 1, new Object[]
                {
                    "KKK",
                    "K-K",
                    'K', MoCParts.fur
                });
        RecipeController.remove(MoCParts.legsFur);
        minefantasy.api.MineFantasyAPI.addTailorRecipe(MoCParts.legsFur, 18, 2.0F , 1, new Object[]
                {
                    "KKK",
                    "K-K",
                    "K-K",
                    'K', MoCParts.fur
                });
        RecipeController.remove(MoCParts.bootsFur);
        minefantasy.api.MineFantasyAPI.addTailorRecipe(MoCParts.bootsFur, 10, 2.0F , 1, new Object[]
                {
                    "K-K",
                    "K-K",
                    'K', MoCParts.fur
                });
        //Reptile
        RecipeController.remove(MoCParts.plateCroc);
        minefantasy.api.MineFantasyAPI.addTailorRecipe(MoCParts.plateCroc, 30, 3.0F , 1, new Object[]
                {
                    "K-K",
                    "KKK",
                    "KKK",
                    'K', MoCParts.crochide
                });
        RecipeController.remove(MoCParts.helmetCroc);
        minefantasy.api.MineFantasyAPI.addTailorRecipe(MoCParts.helmetCroc, 14, 3.0F , 1, new Object[]
                {
                    "KKK",
                    "K-K",
                    'K', MoCParts.crochide
                });
        RecipeController.remove(MoCParts.legsCroc);
        minefantasy.api.MineFantasyAPI.addTailorRecipe(MoCParts.legsCroc, 18, 3.0F , 1, new Object[]
                {
                    "KKK",
                    "K-K",
                    "K-K",
                    'K', MoCParts.crochide
                });
        RecipeController.remove(MoCParts.bootsCroc);
        minefantasy.api.MineFantasyAPI.addTailorRecipe(MoCParts.bootsCroc, 10, 3.0F , 1, new Object[]
                {
                    "K-K",
                    "K-K",
                    'K', MoCParts.crochide
                });
    }
}
