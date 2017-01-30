package minefantasy.api.armour;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

public class ArmourWeightClass {
	public static HashMap<Integer, Integer>configArmours = new HashMap<Integer, Integer>();
	public static EnumArmourClass getClassFor(ItemStack item, EnumArmourClass Default)
	{
		int id = item.itemID;
		
		if(!configArmours.isEmpty() && configArmours.containsKey(id))
		{
			if(hasId(0, id))return EnumArmourClass.LIGHT;
			if(hasId(1, id))return EnumArmourClass.MEDIUM;
			if(hasId(2, id))return EnumArmourClass.HEAVY;
			if(hasId(3, id))return EnumArmourClass.PLATE;
		}
		
		return Default;
	}

	private static boolean hasId(int tier, int id)
	{
		return configArmours.get(id) != null && configArmours.get(id) == tier;
	}
}
