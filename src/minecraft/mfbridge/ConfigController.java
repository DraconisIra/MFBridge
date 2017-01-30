package mfbridge;

import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class ConfigController
{
    private final Configuration config;

    public boolean enableBalkon;
    public boolean removeBalkonDuplicates;

    public boolean enableBattleGear;

    public ConfigController(Configuration configuration)
    {
        this.config = configuration;
    }

    public void loadConfig()
    {
        try
        {
            this.config.load();
            enableBalkon = config.get("Main", "Enable Balkon's WeaponMod recipe overrides", true).getBoolean(true);
            removeBalkonDuplicates = config.get("Balkon's Weapon Mod", "Remove duplicate item recipes", true).getBoolean(true);
            enableBalkon = config.get("Main", "Enable BattleGear recipe overrides", true).getBoolean(true);
        }
        catch (Exception ex)
        {
            FMLLog.log(Level.SEVERE, "[MF Bridge] Problem loading config");
        }
        finally
        {
            this.config.save();
        }
    }
}
