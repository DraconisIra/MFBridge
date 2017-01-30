package mfbridge;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class ModWeighting {
	private static final int _plate_ = 3;
	private static final int _heavy_ = 2;
	private static final int _medium_ = 1;
	private static final int _light_ = 0;
	
	private static ArrayList armourPlate = new ArrayList<ItemStack>();
	private static ArrayList armourHeavy = new ArrayList<ItemStack>();
	private static ArrayList armourMedium = new ArrayList<ItemStack>();
	private static ArrayList armourLight = new ArrayList<ItemStack>();
	private static ArrayList[] armours = {armourPlate,armourHeavy,armourMedium,armourLight};
	
	
	private static String Plate;
	private static String Heavy;
	private static String Medium;
	private static String Light;
	
	public static void init()
	{
			LogController.info("Registering Armour Weight Classes");
			//Thaumcraft
			if(PluginController.isThaumcraftLoaded)
			{
				add(TMCParts.helmetThaumium,_heavy_);
				add(TMCParts.plateThaumium,_heavy_);
				add(TMCParts.legsThaumium,_heavy_);
				add(TMCParts.bootsThaumium,_heavy_);
			}
			
			//Twilight Forest
			if(PluginController.isTwilightForestLoaded)
			{
				add(TFParts.helmKnightMetal, _plate_);
				add(TFParts.plateKnightMetal, _plate_);
				add(TFParts.legsKnightMetal, _plate_);
				add(TFParts.bootsKnightMetal, _plate_);
				
				add(TFParts.helmFiery, _plate_);
				add(TFParts.plateFiery, _plate_);
				add(TFParts.legsFiery, _plate_);
				add(TFParts.bootsFiery, _plate_);
				
				add(TFParts.helmIronwood, _medium_);
				add(TFParts.plateIronwood, _medium_);
				add(TFParts.legsIronwood, _medium_);
				add(TFParts.bootsIronwood, _medium_);
				
				add(TFParts.helmSteeleaf, _light_);
				add(TFParts.plateSteeleaf, _light_);
				add(TFParts.legsSteeleaf, _light_);
				add(TFParts.bootsSteeleaf, _light_);
				
				add(TFParts.plateNaga, _light_);
				add(TFParts.legsNaga, _light_);
			}
			
			//Mo' Creatures
			if(PluginController.isMoCreaturesLoaded)
			{
				add(MoCParts.helmetCroc, _light_);
				add(MoCParts.plateCroc, _light_);
				add(MoCParts.legsCroc, _light_);
				add(MoCParts.bootsCroc, _light_);
				
				add(MoCParts.helmetFur, _light_);
				add(MoCParts.plateFur, _light_);
				add(MoCParts.legsFur, _light_);
				add(MoCParts.bootsFur, _light_);
				
				add(MoCParts.helmetHide, _light_);
				add(MoCParts.plateHide, _light_);
				add(MoCParts.legsHide, _light_);
				add(MoCParts.bootsHide, _light_);
				
				add(MoCParts.helmetScorpCave, _medium_);
				add(MoCParts.plateScorpCave, _medium_);
				add(MoCParts.legsScorpCave, _medium_);
				add(MoCParts.bootsScorpCave, _medium_);
				
				add(MoCParts.helmetScorpDirt, _medium_);
				add(MoCParts.plateScorpDirt, _medium_);
				add(MoCParts.legsScorpDirt, _medium_);
				add(MoCParts.bootsScorpDirt, _medium_);
				
				add(MoCParts.helmetScorpFrost, _medium_);
				add(MoCParts.plateScorpFrost, _medium_);
				add(MoCParts.legsScorpFrost, _medium_);
				add(MoCParts.bootsScorpFrost, _medium_);
				
				add(MoCParts.helmetScorpNether, _medium_);
				add(MoCParts.plateScorpNether, _medium_);
				add(MoCParts.legsScorpNether, _medium_);
				add(MoCParts.bootsScorpNether, _medium_);
			}
			//Ars Magica
			if(PluginController.isArsMagicaLoaded)
			{
				add(AMParts.battlemageHelmet,_medium_);
				add(AMParts.battlemagePlate,_medium_);
				add(AMParts.battlemagePants,_medium_);
				add(AMParts.battlemageBoots,_medium_);
				
				add(AMParts.mageHelmet,_light_);
				add(AMParts.magePlate,_light_);
				add(AMParts.magePants,_light_);
				add(AMParts.mageBoots,_light_);
			}

		LogController.info("Registering Armour Weight Classes Complete");
		if(!PluginController.isMineFantasyAGLoaded)
		{
			compile();
			print();
		}
	}
	private static void add(ItemStack item, int type)
	{
		if (item != null)
		{
			if(PluginController.isMineFantasyAGLoaded)
			{
				minefantasy.api.MineFantasyAPI.registerArmourClass(item,type);
			}
			else
			{
				if(type == _plate_)
				{
						armourPlate.add(item);
						LogController.fine("Registering "+item.getDisplayName()+" as plate armour");
				}
				else if(type == _heavy_)
				{
						armourHeavy.add(item);
						LogController.fine("Registering "+item.getDisplayName()+" as heavy armour");
				}
				else if(type == _medium_)
				{
						armourMedium.add(item);
						LogController.fine("Registering "+item.getDisplayName()+" as medium armour");
				}
				else if(type == _light_)
				{
						armourLight.add(item);
						LogController.fine("Registering "+item.getDisplayName()+" as light armour");
				}
			}
			
		}
	}
	
	private static void compile()
	{
		for (ArrayList Current: armours)
		{
			//for (int tmp: armourPlate.toArray())
		}
		
	}
	
	private static void print()
	{
		
		
	}
	

}
