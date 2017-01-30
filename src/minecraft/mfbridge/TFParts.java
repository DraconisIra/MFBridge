package mfbridge;

import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.*;

public class TFParts
{
    //Armour
    public static final ItemStack helmKnightMetal = ItemController.getItem("tf", "item.knightlyHelm");
    public static final ItemStack plateKnightMetal = ItemController.getItem("tf", "item.knightlyPlate");
    public static final ItemStack legsKnightMetal = ItemController.getItem("tf", "item.knightlyLegs");
    public static final ItemStack bootsKnightMetal = ItemController.getItem("tf", "item.knightlyBoots");

    public static final ItemStack helmSteeleaf = ItemController.getItem("tf", "item.steeleafHelm");
    public static final ItemStack plateSteeleaf = ItemController.getItem("tf", "item.steeleafPlate");
    public static final ItemStack legsSteeleaf = ItemController.getItem("tf", "item.steeleafLegs");
    public static final ItemStack bootsSteeleaf = ItemController.getItem("tf", "item.steeleafBoots");

    public static final ItemStack helmIronwood = ItemController.getItem("tf", "item.ironwoodHelm");
    public static final ItemStack plateIronwood = ItemController.getItem("tf", "item.ironwoodPlate");
    public static final ItemStack legsIronwood = ItemController.getItem("tf", "item.ironwoodLegs");
    public static final ItemStack bootsIronwood = ItemController.getItem("tf", "item.ironwoodBoots");

    public static final ItemStack helmFiery = ItemController.getItem("tf", "item.fieryHelm");
    public static final ItemStack plateFiery = ItemController.getItem("tf", "item.fieryPlate");
    public static final ItemStack legsFiery = ItemController.getItem("tf", "item.fieryLegs");
    public static final ItemStack bootsFiery = ItemController.getItem("tf", "item.fieryBoots");

    public static final ItemStack plateNaga = ItemController.getItem("tf", "item.plateNaga");
    public static final ItemStack legsNaga = ItemController.getItem("tf", "item.legsNaga");

    //Tools
    public static final ItemStack swordSteeleaf = ItemController.getItem("tf", "item.steeleafSword");
    public static final ItemStack pickSteeleaf = ItemController.getItem("tf", "item.steeleafPick");
    public static final ItemStack axeSteeleaf = ItemController.getItem("tf", "item.steeleafAxe");
    public static final ItemStack hoeSteeleaf = ItemController.getItem("tf", "item.steeleafHoe");
    public static final ItemStack shovelSteeleaf = ItemController.getItem("tf", "item.steeleafShovel");

    public static final ItemStack swordFiery = ItemController.getItem("tf", "item.fierySword");
    public static final ItemStack pickFiery = ItemController.getItem("tf", "item.fieryPick");

    public static final ItemStack swordIronwood = ItemController.getItem("tf", "item.ironwoodSword");
    public static final ItemStack pickIronwood = ItemController.getItem("tf", "item.ironwoodPick");
    public static final ItemStack axeIronwood = ItemController.getItem("tf", "item.ironwoodAxe");
    public static final ItemStack hoeIronwood = ItemController.getItem("tf", "item.ironwoodHoe");
    public static final ItemStack shovelIronwood = ItemController.getItem("tf", "item.ironwoodShovel");

    public static final ItemStack swordKnightly = ItemController.getItem("tf", "item.knightlySword");
    public static final ItemStack pickKnightly = ItemController.getItem("tf", "item.knightlyPick");
    public static final ItemStack axeKnightly = ItemController.getItem("tf", "item.knightlyAxe");

    //Misc
    public static final ItemStack ingotKnightMetal = ItemController.getItem("tf", "item.knightMetal");
    public static final ItemStack ingotIronwood = ItemController.getItem("tf", "item.ironwoodIngot");
    public static final ItemStack ingotFiery = ItemController.getItem("tf", "item.fieryIngot");
    public static final ItemStack fieryBlood = ItemController.getItem("tf", "item.fieryBlood");
    public static final ItemStack nagaScale = ItemController.getItem("tf", "item.nagaScale");
    public static final ItemStack steeleaf = ItemController.getItem("tf", "item.steeleafIngot");
    public static final ItemStack liveRoot = ItemController.getItem("tf", "item.liveRoot");
    public static final ItemStack ironwoodRaw = ItemController.getItem("tf", "item.ironwoodRaw");
    public static final ItemStack shardCluster = ItemController.getItem("tf", "item.shardCluster");

    public static void PatchEnchant()
    {
        //Armours
        //Ironwood
        helmIronwood.addEnchantment(Enchantment.aquaAffinity, 1);
        plateIronwood.addEnchantment(Enchantment.protection, 1);
        legsIronwood.addEnchantment(Enchantment.protection, 1);
        bootsIronwood.addEnchantment(Enchantment.featherFalling, 1);
        //Steeleaf
        helmSteeleaf.addEnchantment(Enchantment.projectileProtection, 2);
        plateSteeleaf.addEnchantment(Enchantment.blastProtection, 2);
        legsSteeleaf.addEnchantment(Enchantment.fireProtection, 2);
        bootsSteeleaf.addEnchantment(Enchantment.featherFalling, 2);
        //Fiery
        helmFiery.addEnchantment(EnchantmentController.getEnchant("tf", "reactFire"), 2);
        plateFiery.addEnchantment(EnchantmentController.getEnchant("tf", "reactFire"), 2);
        legsFiery.addEnchantment(EnchantmentController.getEnchant("tf", "reactFire"), 2);
        bootsFiery.addEnchantment(EnchantmentController.getEnchant("tf", "reactFire"), 2);
        //Naga
        plateNaga.addEnchantment(Enchantment.fireProtection, 3);
        legsNaga.addEnchantment(Enchantment.protection, 3);
        //Tools
        //Ironwood
        swordIronwood.addEnchantment(Enchantment.knockback, 1);
        shovelIronwood.addEnchantment(Enchantment.unbreaking, 1);
        pickIronwood.addEnchantment(Enchantment.efficiency, 1);
        axeIronwood.addEnchantment(Enchantment.fortune, 1);
        //Steeleaf
        swordSteeleaf.addEnchantment(Enchantment.looting, 2);
        shovelSteeleaf.addEnchantment(Enchantment.efficiency, 2);
        pickSteeleaf.addEnchantment(Enchantment.fortune, 2);
        axeSteeleaf.addEnchantment(Enchantment.efficiency, 2);
        //Fiery
        swordFiery.addEnchantment(Enchantment.fireAspect, 2);
    }
}
