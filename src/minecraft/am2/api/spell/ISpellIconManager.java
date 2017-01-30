package am2.api.spell;

import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public interface ISpellIconManager {
	/**
	 * Returns the icon registered to the specified spell name.  Returns the missing icon if one doesn't exist.
	 */
	public Icon getIcon(String spellName);
	
	/**
	 * Registers an icon to be associated with a spell component
	 * @param spellName  The unlocalized name of the spell used when it was registered
	 * @param icon The icon of the spell
	 */
	public void registerIcon(String spellName, Icon icon);
}
