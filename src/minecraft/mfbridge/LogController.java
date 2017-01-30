package mfbridge;

import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class LogController {
	public static Logger log = FMLLog.getLogger().getLogger("MFBridge");

	public static void info(String string)
	{
		log.info(string);
	}
	public static void warning(String string)
	{
		log.warning(string);
	}
	public static void severe(String string)
	{
		log.severe(string);
	}
	public static void fine(String string)
	{
		log.info(string);
	}
}
