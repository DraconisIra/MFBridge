package mfbridge;

import java.io.File;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod; // not used in 1.7
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "MFBridge", name = "MineFantasy Recipe Bridge", version = "0.2.7", dependencies="after:MineFantasy;after:battlegear2;before:arsmagica2")
@NetworkMod(clientSideRequired = true) // not used in 1.7
public class MFBridge
{

    // The instance of your mod that Forge uses.
    @Instance(value = "MF Bridge")
    public static MFBridge instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "mfbridge.client.ClientProxy", serverSide = "mfbridge.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler // used in 1.6.2
    public void preInit(FMLPreInitializationEvent event)
    {
    	VersionController.init(); 
    	
        if (PluginController.isMineFantasyLoaded)
        {
        	String configloc;
        	
        	if(PluginController.isMineFantasyAGLoaded){LogController.info("AG MF Detected");}else{LogController.info("AG MF Not Detected");}
        	if(PluginController.isMineFantasyNFLoaded){
        		LogController.info("NF MF Detected");
        		configloc="config/minefantasy/main.cfg";
        		}else{
        			LogController.info("NF MF Not Detected");
        			configloc="config/MineFantasy.cfg";	
        		}
        	
        	
            MinecraftForge.EVENT_BUS.register(new EventController());
            File mfConfig = new File("config/MineFantasy.cfg");
            if (mfConfig.canRead())
            {
            	MineFantasy.config(mfConfig,PluginController.isMineFantasyNFLoaded);}else{LogController.severe("[MFbridge] Failed to read MineFantasy config, settings will not be intergrated");
            }
        }
    }

    @EventHandler // used in 1.6.2
    public void load(FMLInitializationEvent event)
    {
        proxy.registerRenderers();
    }
    @EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event)
    {
        if (PluginController.isMineFantasyLoaded)
        {
        	MineFantasy.init();      	
        	
            if (PluginController.isBattlegearLoaded)
            {
                Battlegear2.init();
            }else{LogController.info("Battlegear 2 not detected, skipping");}

            if (PluginController.isWeaponModLoaded)
            {
                BalkonsWeaponMod.init();
            }else{LogController.info("Balkon's Weapon Mod not detected, skipping");}

            if (PluginController.isTwilightForestLoaded)
            {
                TwilightForest.init();
            }else{LogController.info("Twilight Forest not detected, skipping");}

            if (PluginController.isMoCreaturesLoaded)
            {
            	MoCreatures.init();
            }else{LogController.info("Mo' Creatures not detected, skipping");}
            
            if (PluginController.isNaturaLoaded)
            {
                Natura.init();
            }else{LogController.info("Natura not detected, skipping");}
            
            if (PluginController.isWitcheryLoaded)
            {
            	Witchery.init();
            }else{LogController.info("Witchery not detected, skipping");}
            
            if (PluginController.isThaumcraftLoaded)
            {
            	Thaumcraft.init();
            }else{LogController.info("Thaumcraft not detected, skipping");}
            
            if (PluginController.isBloodMagicLoaded)
            {
            	BloodMagic.init();
            }else{LogController.info("BloodMagic not detected, skipping");}
            
            if (PluginController.isArsMagicaLoaded)
            {
            	ArsMagica.init();
            }else{LogController.info("ArsMagica not detected, skipping");}
                       
            ModWeighting.init();
            General.init();
        }
        else
        {
           LogController.severe("MineFantasy not found, why do you even have this mod installed?");
        }
    }
}