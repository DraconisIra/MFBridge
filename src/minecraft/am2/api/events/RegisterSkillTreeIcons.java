package am2.api.events;

import net.minecraftforge.event.Event;
import am2.api.spell.ISpellIconManager;

public class RegisterSkillTreeIcons extends Event{
	public final ISpellIconManager manager;

	public RegisterSkillTreeIcons(ISpellIconManager manager){
		this.manager = manager;
	}
}
