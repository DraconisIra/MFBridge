package mfbridge;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;

public class PluginController
{
   // public static boolean isMineFantasyLoaded = minefantasy.api.MineFantasyAPI.isModLoaded();
	public static boolean isMineFantasyLoaded = detectMF();
    public static boolean isMineFantasyNFLoaded = detectNFMF();
    public static boolean isMineFantasyAGLoaded = detectAGMF();
    public static boolean isBattlegearLoaded = Loader.isModLoaded("battlegear2");
    public static boolean isWeaponModLoaded = Loader.isModLoaded("weaponmod");
    public static boolean isTwilightForestLoaded = Loader.isModLoaded("TwilightForest");
    public static boolean isWitcheryLoaded = Loader.isModLoaded("witchery");
    public static boolean isMoCreaturesLoaded = Loader.isModLoaded("MoCreatures");
    public static boolean isGrimoireGaiaLoaded = Loader.isModLoaded("GrimoireGaia2");
    public static boolean isNaturaLoaded = Loader.isModLoaded("Natura");
    public static boolean isThaumcraftLoaded = Loader.isModLoaded("Thaumcraft");
    public static boolean isBloodMagicLoaded = Loader.isModLoaded("AWWayofTime");
    public static boolean isArsMagicaLoaded = Loader.isModLoaded("arsmagica2");
    
    private static boolean detectMF()
    {
    	if(Loader.isModLoaded("MF") || Loader.isModLoaded("MineFantasy"))
    	{
    		return true;
    	}
    	return false;
    }
    
    private static boolean detectNFMF()
    {
        try
        {
          Class.forName("minefantasy.item.ItemListMF");
        }
        catch (ClassNotFoundException e)
        {
          return true;
        }
        return false;
    }
    
    private static boolean detectAGMF()
    {
    	if(isMineFantasyNFLoaded)
    	{
    		return true;
    	}
    	
    	
        try
        {
          Class.forName("minefantasy.MineFantasyVersion");
        }
        catch (ClassNotFoundException e)
        {
          return false;
        }
        return true;
    }
}
