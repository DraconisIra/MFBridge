package am2.api.events;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import am2.api.spell.ItemSpellBase;
import am2.api.spell.enums.SpellCastResult;

@Cancelable
public class SpellCastingEvent extends Event{
	/**
	 * The spell being cast
	 */
	public final ItemSpellBase spell;
	/**
	 * The caster of the spell
	 */
	public final EntityLivingBase caster;
	/**
	 * The calculated mana cost of the spell
	 */
	public final float manaCost;
	/**
	 * The calculated burnout of the spell
	 */
	public final float burnout;
	/**
	 * The itemstack representing the spell
	 */
	public final ItemStack stack;
	/**
	 * The result to be returned after casting the spell
	 */
	public SpellCastResult castResult;
	/**
	 * Is the spell channeled (maintained in any way, not the shape, so beam counts too)
	 */
	public final boolean isChanneled;

	public SpellCastingEvent(ItemStack stack, ItemSpellBase spell, EntityLivingBase caster, float manaCost, float burnout, boolean isChanneled){
		this.caster = caster;
		this.spell = spell;
		this.manaCost = manaCost;
		this.burnout = burnout;
		this.stack = stack;
		this.isChanneled = isChanneled;
	}
}
