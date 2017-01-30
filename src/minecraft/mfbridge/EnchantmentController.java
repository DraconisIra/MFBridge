package mfbridge;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;

public class EnchantmentController
{
    public static Enchantment getEnchant(String modString, String EnchantString)
    {
        Enchantment enchant = null;

        //Twilight Forest
        if (modString.toLowerCase().equals("tf"))
        {
            enchant = enchantGet("twilightforest.TFEnchantment", EnchantString);
        }
        else
        {
            System.out.println("!!_____Invalid Mod Def: " + modString + "_____!!");
        }

        return enchant;
    }

    private static Enchantment enchantGet(String classString, String enchantString)
    {
        Enchantment enchantment = null;

        try
        {
            String enchantClass = classString;
            Object obj = Class.forName(enchantClass).getField(enchantString).get(null);

            if (obj instanceof Enchantment)
            {
                enchantment = (Enchantment) obj;
            }
        }
        catch (Exception ex)
        {
            FMLLog.warning("[MFbridge] " + enchantString + " not found in " + classString);
        }

        return enchantment;
    }
}
