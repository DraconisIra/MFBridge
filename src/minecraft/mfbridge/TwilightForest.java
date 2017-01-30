package mfbridge;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;

public class TwilightForest
{
    public static void init()
    {
        FMLLog.info("[MFbridge] Bridging Twilight Forest");
        TFParts.PatchEnchant();
        Ingots();
        Armours();
        Tools();
        FMLLog.info("[MFbridge] Twilight Forest Complete");
    }

    private static void Ingots()
    {
        minefantasy.api.MineFantasyAPI.addHeatableItem(TFParts.ingotIronwood, 400, 1000, 1000);
        minefantasy.api.MineFantasyAPI.addHeatableItem(TFParts.ingotKnightMetal, 400, 1000, 1000);
        minefantasy.api.MineFantasyAPI.addHeatableItem(TFParts.steeleaf, 300, 900, 1000);
        minefantasy.api.MineFantasyAPI.addHeatableItem(TFParts.ironwoodRaw, 300, 900, 1000);
        minefantasy.api.MineFantasyAPI.addHeatableItem(TFParts.shardCluster, 300, 900, 1000);
        minefantasy.api.MineFantasyAPI.addAlloy(TFParts.ingotFiery, new Object[]
                                                {
                                                    new ItemStack(Item.ingotIron, 1),
                                                    TFParts.fieryBlood
                                                });
        RecipeController.removeSmelting(TFParts.ironwoodRaw);
        RecipeController.remove(TFParts.ironwoodRaw);
        minefantasy.api.MineFantasyAPI.addShapelessAnvilRecipe(TFParts.ingotIronwood.splitStack(2), true, MFParts.anvilStone, MFParts.hammerAny, 300, new Object[]
                {
                    TFParts.ironwoodRaw
                });
        minefantasy.api.MineFantasyAPI.addShapelessAnvilRecipe(TFParts.ironwoodRaw, true, MFParts.anvilStone, MFParts.hammerAny, 300, new Object[]
                {
                    TFParts.liveRoot,
                    new ItemStack(Item.goldNugget, 1),
                    new ItemStack(Item.ingotIron, 1)
                });
        RecipeController.removeSmelting(TFParts.shardCluster);
        minefantasy.api.MineFantasyAPI.addShapelessAnvilRecipe(TFParts.ingotKnightMetal, true, MFParts.anvilIron, MFParts.hammerAny, 300, new Object[]
                {
                    TFParts.shardCluster
                });
    }
    private static void Armours()
    {
        ItemStack activeK = null;
        ItemStack activeS = null;
        RecipeController.remove(TFParts.helmKnightMetal);
        RecipeController.remove(TFParts.plateKnightMetal);
        RecipeController.remove(TFParts.legsKnightMetal);
        RecipeController.remove(TFParts.bootsKnightMetal);
        activeK = TFParts.ingotKnightMetal;
        activeS = MFParts.smlPlateSteel;
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.plateKnightMetal, true, MFParts.hammerAny, MFParts.anvilIron, 1000, new Object[]
                {
                    "-K-K-",
                    "KS-SK",
                    "KSSSK",
                    "KSSSK",
                    'K', activeK,
                    'S', activeS
                });
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.helmKnightMetal, true, MFParts.hammerAny, MFParts.anvilIron, 600, new Object[]
                {
                    "-KKK-",
                    "KSSSK",
                    "-S-S-",
                    'K', activeK,
                    'S', activeS
                });
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.bootsKnightMetal, true, MFParts.hammerAny, MFParts.anvilIron, 400, new Object[]
                {
                    "-S-S-",
                    "-S-S-",
                    "KK-KK",
                    'K', activeK,
                    'S', activeS
                });
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.legsKnightMetal, true, MFParts.hammerAny, MFParts.anvilIron, 800, new Object[]
                {
                    "-KKK-",
                    "KSSSK",
                    "KS-SK",
                    "-S-S-",
                    'K', activeK,
                    'S', activeS
                });
        RecipeController.remove(TFParts.helmFiery);
        RecipeController.remove(TFParts.plateFiery);
        RecipeController.remove(TFParts.legsFiery);
        RecipeController.remove(TFParts.bootsFiery);
        activeK = TFParts.ingotFiery;
        activeS = MFParts.smlPlateSteel;
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.plateFiery, true, MFParts.hammerOrnate, MFParts.anvilSteel, 1000, new Object[]
                {
                    "-K-K-",
                    "KS-SK",
                    "KSSSK",
                    "KSSSK",
                    'K', activeK,
                    'S', activeS
                });
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.helmFiery, true, MFParts.hammerOrnate, MFParts.anvilSteel, 600, new Object[]
                {
                    "-KKK-",
                    "KSSSK",
                    "-S-S-",
                    'K', activeK,
                    'S', activeS
                });
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.bootsFiery, true, MFParts.hammerOrnate, MFParts.anvilSteel, 400, new Object[]
                {
                    "-S-S-",
                    "-S-S-",
                    "KK-KK",
                    'K', activeK,
                    'S', activeS
                });
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.legsFiery, true, MFParts.hammerOrnate, MFParts.anvilSteel, 800, new Object[]
                {
                    "-KKK-",
                    "KSSSK",
                    "KS-SK",
                    "-S-S-",
                    'K', activeK,
                    'S', activeS
                });
        RecipeController.remove(TFParts.helmSteeleaf);
        RecipeController.remove(TFParts.plateSteeleaf);
        RecipeController.remove(TFParts.legsSteeleaf);
        RecipeController.remove(TFParts.bootsSteeleaf);
        activeK = TFParts.steeleaf;
        activeS = new ItemStack(Item.leather, 1);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.legsSteeleaf, true, MFParts.hammerAny, MFParts.anvilSteel, 400, new Object[]
                {
                    "-KKK-",
                    "KSSSK",
                    "KS-SK",
                    "KS-SK",
                    'K', activeK,
                    'S', activeS
                });
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.bootsSteeleaf, true, MFParts.hammerAny, MFParts.anvilSteel, 300, new Object[]
                {
                    "K---K",
                    "KS-SK",
                    "KS-SK",
                    'K', activeK,
                    'S', activeS
                });
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.helmSteeleaf, true, MFParts.hammerAny, MFParts.anvilSteel, 500, new Object[]
                {
                    "K---K",
                    "KSSSK",
                    "KS-SK",
                    'K', activeK,
                    'S', activeS
                });
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.plateSteeleaf, true, MFParts.hammerAny, MFParts.anvilSteel, 700, new Object[]
                {
                    "KS-SK",
                    "KSSSK",
                    "KSSSK",
                    "KKKKK",
                    'K', activeK,
                    'S', activeS
                });
        RecipeController.remove(TFParts.helmIronwood);
        RecipeController.remove(TFParts.plateIronwood);
        RecipeController.remove(TFParts.legsIronwood);
        RecipeController.remove(TFParts.bootsIronwood);
        activeK = TFParts.ingotIronwood;
        activeS = new ItemStack(Item.leather, 1);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.legsIronwood, true, MFParts.hammerAny, MFParts.anvilSteel, 400, new Object[]
                {
                    "-KKK-",
                    "KSSSK",
                    "KS-SK",
                    "KS-SK",
                    'K', activeK,
                    'S', activeS
                });
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.bootsIronwood, true, MFParts.hammerAny, MFParts.anvilSteel, 300, new Object[]
                {
                    "K---K",
                    "KS-SK",
                    "KS-SK",
                    'K', activeK,
                    'S', activeS
                });
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.helmIronwood, true, MFParts.hammerAny, MFParts.anvilSteel, 500, new Object[]
                {
                    "K---K",
                    "KSSSK",
                    "KS-SK",
                    'K', activeK,
                    'S', activeS
                });
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.plateIronwood, true, MFParts.hammerAny, MFParts.anvilSteel, 700, new Object[]
                {
                    "KS-SK",
                    "KSSSK",
                    "KSSSK",
                    "KKKKK",
                    'K', activeK,
                    'S', activeS
                });
        RecipeController.remove(TFParts.plateNaga);
        RecipeController.remove(TFParts.legsNaga);
        activeK = TFParts.nagaScale;
        activeS = new ItemStack(Item.leather, 1);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.plateNaga, false, MFParts.hammerAny, MFParts.anvilSteel, 700, new Object[]
                {
                    "KS-SK",
                    "KSSSK",
                    "KSSSK",
                    "KKKKK",
                    'K', activeK,
                    'S', activeS
                });
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.legsNaga, false, MFParts.hammerAny, MFParts.anvilSteel, 400, new Object[]
                {
                    "-KKK-",
                    "KSSSK",
                    "KS-SK",
                    "KS-SK",
                    'K', activeK,
                    'S', activeS
                });
    }
    private static void Tools()
    {
//Ironwood
        RecipeController.remove(TFParts.swordIronwood);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.swordIronwood, true, MFParts.hammerAny, MFParts.anvilSteel, 600, new Object[]
                {
                    "-K--",
                    "HKKK",
                    "-K--",
                    'K', TFParts.ingotIronwood,
                    'H', MFParts.haftWeak
                });
        RecipeController.remove(TFParts.pickIronwood);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.pickIronwood, true, MFParts.hammerAny, MFParts.anvilSteel, 400, new Object[]
                {
                    "--K",
                    "HHK",
                    "--K",
                    'K', TFParts.ingotIronwood,
                    'H', MFParts.haftWeak
                });
        RecipeController.remove(TFParts.axeIronwood);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.axeIronwood, true, MFParts.hammerAny, MFParts.anvilSteel, 400, new Object[]
                {
                    "-KK",
                    "HHK",
                    'K', TFParts.ingotIronwood,
                    'H', MFParts.haftWeak
                });
        RecipeController.remove(TFParts.shovelIronwood);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.shovelIronwood, true, MFParts.hammerAny, MFParts.anvilSteel, 300, new Object[]
                {
                    "HHK",
                    'K', TFParts.ingotIronwood,
                    'H', MFParts.haftWeak
                });
        RecipeController.remove(TFParts.hoeIronwood);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.hoeIronwood, true, MFParts.hammerAny, MFParts.anvilSteel, 400, new Object[]
                {
                    "--K",
                    "HHK",
                    'K', TFParts.ingotIronwood,
                    'H', MFParts.haftWeak
                });
//Steeleaf
        RecipeController.remove(TFParts.swordSteeleaf);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.swordSteeleaf, true, MFParts.hammerAny, MFParts.anvilSteel, 600, new Object[]
                {
                    "-K--",
                    "HKKK",
                    "-K--",
                    'K', TFParts.steeleaf,
                    'H', MFParts.haftStrong
                });
        RecipeController.remove(TFParts.pickSteeleaf);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.pickSteeleaf, true, MFParts.hammerAny, MFParts.anvilSteel, 400, new Object[]
                {
                    "--K",
                    "HHK",
                    "--K",
                    'K', TFParts.steeleaf,
                    'H', MFParts.haftStrong
                });
        RecipeController.remove(TFParts.axeSteeleaf);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.axeSteeleaf, true, MFParts.hammerAny, MFParts.anvilSteel, 400, new Object[]
                {
                    "-KK",
                    "HHK",
                    'K', TFParts.steeleaf,
                    'H', MFParts.haftStrong
                });
        RecipeController.remove(TFParts.shovelSteeleaf);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.shovelSteeleaf, true, MFParts.hammerAny, MFParts.anvilSteel, 200, new Object[]
                {
                    "HHK",
                    'K', TFParts.steeleaf,
                    'H', MFParts.haftStrong
                });
        RecipeController.remove(TFParts.hoeSteeleaf);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.hoeSteeleaf, true, MFParts.hammerAny, MFParts.anvilSteel, 300, new Object[]
                {
                    "--K",
                    "HHK",
                    'K', TFParts.steeleaf,
                    'H', MFParts.haftStrong
                });
//Fiery
        RecipeController.remove(TFParts.swordFiery);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.swordFiery, true, MFParts.hammerOrnate, MFParts.anvilSteel, 800, new Object[]
                {
                    "-K--",
                    "HKKK",
                    "-K--",
                    'K', TFParts.ingotFiery,
                    'H', MFParts.haftEbony
                });
        RecipeController.remove(TFParts.pickFiery);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.pickFiery, true, MFParts.hammerOrnate, MFParts.anvilSteel, 600, new Object[]
                {
                    "--K",
                    "HHK",
                    "--K",
                    'K', TFParts.ingotFiery,
                    'H', MFParts.haftEbony
                });
//Knightly
        RecipeController.remove(TFParts.swordKnightly);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.swordKnightly, true, MFParts.hammerAny, MFParts.anvilSteel, 800, new Object[]
                {
                    "-K--",
                    "HKKK",
                    "-K--",
                    'K', TFParts.ingotKnightMetal,
                    'H', MFParts.haftStrong
                });
        RecipeController.remove(TFParts.pickKnightly);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.pickKnightly, true, MFParts.hammerAny, MFParts.anvilSteel, 600, new Object[]
                {
                    "--K",
                    "HHK",
                    "--K",
                    'K', TFParts.ingotKnightMetal,
                    'H', MFParts.haftStrong
                });
        RecipeController.remove(TFParts.axeKnightly);
        minefantasy.api.MineFantasyAPI.addAnvilRecipe(TFParts.axeKnightly, true, MFParts.hammerAny, MFParts.anvilSteel, 600, new Object[]
                {
                    "-KK",
                    "HHK",
                    'K', TFParts.ingotKnightMetal,
                    'H', MFParts.haftStrong
                });
    }
}
