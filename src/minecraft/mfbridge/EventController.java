package mfbridge;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.event.world.ChunkEvent;

public class EventController
{
	private static final Result ALLOW = Event.Result.ALLOW;
	private static final Result DENY = Event.Result.DENY;
	private static final Result DEFAULT = Event.Result.DEFAULT;
	private static final Action RCLICK_BLOCK = Action.RIGHT_CLICK_BLOCK;
	public static String[] devilItems = {"item.null", "item.grc","item.arsmagica2","item.WandCasting","tile.grc.ropeBlock"};
	//public static java.util.List<Integer> cursedBlocks = Arrays.asList(MFParts.benchTop.itemID, MFParts.anvil.itemID, MFParts.tailorBench.itemID);

    @ForgeSubscribe
    @SideOnly(Side.CLIENT)
    public void playerRclick(PlayerInteractEvent event)
    {
    	if (event.action == RCLICK_BLOCK && Minecraft.getMinecraft().theWorld.isRemote)
    	{	
    		
	    	try
	    	{
	    		EntityPlayer Player = event.entityPlayer;
	    		/*if(Minecraft.getMinecraft().theWorld.getBlockId(event.x,event.y,event.z) == Block.furnaceIdle.blockID||Minecraft.getMinecraft().theWorld.getBlockId(event.x,event.y,event.z) == Block.furnaceBurning.blockID)
				{
	    			Minecraft.getMinecraft().theWorld.destroyBlock(event.x, event.y, event.z, true);
	    			//event.setResult(DENY);
	    			event.setCanceled(true);
	    			//Minecraft.getMinecraft().theWorld.setBlockToAir(event.x, event.y, event.z);
	    			Minecraft.getMinecraft().theWorld.setBlock(event.x, event.y, event.z, 2);
	    			System.out.println ("DONE");
	    			//
				}*/
	    		//if(cursedBlocks.contains(Minecraft.getMinecraft().theWorld.getBlockId(event.x,event.y,event.z)))
	    		int block = Minecraft.getMinecraft().theWorld.getBlockId(event.x,event.y,event.z);
	    		if(block ==MFParts.benchTop.itemID ||block == MFParts.anvil.itemID || block == MFParts.tailorBench.itemID)
				{
	    			if (Player.getHeldItem() != null)
	    			{
	    				ItemStack heldItem = Player.getHeldItem();
	        			String nameUnlocalised = heldItem.getUnlocalizedName();
	        			//heldItem.getClass().
	        			System.out.println(nameUnlocalised);
	    				for (String current:devilItems)
	    				{
	    					if (nameUnlocalised!=null && nameUnlocalised.startsWith(current))
	    					{
	    						LogController.info("Shielded against world destruction. Do not place "+nameUnlocalised +" on Minefantasy blocks");
	    						event.setCanceled(true);
	    					}
	    				}
	    			}
	    		}
	    	}
	    	catch(Exception e)
	    	{
	    		LogController.severe("Workbench Protection errored, this should not happen, report this to the developer");
	    		LogController.severe("=========================Error Stacktrace=========================");
	    		System.out.println(e.getStackTrace());
	    		LogController.severe("==========================End Stacktrace==========================");
	    	}
    	}
    	
    }

	
    @ForgeSubscribe
    public void entityDrop(LivingDropsEvent event)
    {
        /* if ((event.entityLiving instanceof EntityZombie))
         {
         	EntityZombie droppingCow = (EntityZombie)event.entityLiving;
           droppingCow.dropItem( Item.appleGold.itemID ,10);
           event.setCanceled(true);
         }*/
        Class enClass = event.entityLiving.getClass();
        String name = "";

        if ((enClass != null) && (EntityList.classToStringMapping.get(enClass) != null) && !enClass.getName().contains("Farlanders"))
        {
            name = (String) EntityList.classToStringMapping.get(enClass);
            //LogController.severe(enClass.getName()+" Died: "+name);
                ItemStack stack;
                Iterator drop = event.drops.iterator();

                while (drop.hasNext())
                {
                    stack = ((EntityItem)drop.next()).getEntityItem();

                    if (stack != null && MineFantasy.hardcoreCraft && (stack.getItem() == Item.pickaxeWood || stack.getItem() == Item.swordWood || stack.getItem() == Item.shovelWood|| stack.getItem() == Item.hoeWood))
                    {
                        drop.remove();
                        event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, MFParts.plank.splitStack(2)));
                    }
                    if (stack != null && MineFantasy.hardcoreCraft)
                    {
                    	if (stack.getItem().itemID==Item.pickaxeStone.itemID){drop.remove(); event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, MFParts.pickStone));}
                    	if (stack.getItem().itemID==Item.swordStone.itemID){drop.remove(); event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, MFParts.clubStone));}
                    	if (stack.getItem().itemID==Item.axeStone.itemID){drop.remove(); event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, MFParts.axeStone));}
                    	if (stack.getItem().itemID==Item.hoeStone.itemID || stack.getItem().itemID==Item.shovelStone.itemID){drop.remove();}
                    	if (stack.getItem().itemID==Item.pickaxeIron.itemID){drop.remove(); event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, MFParts.pickCopper));}
                    	if (stack.getItem().itemID==Item.swordIron.itemID){drop.remove(); event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, MFParts.swordCopper));}
                    	if (stack.getItem().itemID==Item.axeIron.itemID){drop.remove(); event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, MFParts.axeCopper));}
                    	if (stack.getItem().itemID==Item.shovelIron.itemID){drop.remove(); event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, MFParts.shovelCopper));}
                    	if (stack.getItem().itemID==Item.hoeIron.itemID){drop.remove(); event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, MFParts.hoeCopper));}
                    }
                    if (stack != null && stack.getItem().itemID == Item.leather.itemID && !PluginController.isMineFantasyAGLoaded)
                    {
                        drop.remove();
                        LogController.severe(enClass.getName()+" is attempting to drop vanilla leather, report this to the developer!");
                    }
                }
            
         /*   if (enClass.getName().endsWith("GaiaCentaur") || enClass.getName().endsWith("GaiaHunter"))
            {

                while (drop.hasNext())
                {
                    stack = ((EntityItem)drop.next()).getEntityItem();


                }*/
                if (!PluginController.isMineFantasyAGLoaded){
	                if (enClass.getName().endsWith("GaiaCentaur"))
	                {
	                    event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, MFParts.hideHorse));
	                }
	                else if(enClass.getName().endsWith("GaiaHunter"))
	                {
	                    event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, MFParts.leatherRaw.splitStack(2)));
	                }
	                else if (enClass.getName().endsWith("GaiaMinotaur") || enClass.getName().endsWith("GaiaMinotaurus"))
	                {
	                	event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, MFParts.hideMinotaur));
	                }
                }
            }
           
        //}
    }
    
    
    
    @ForgeSubscribe
    public void blockBreakDrops(HarvestDropsEvent event)
    {
    	Block block = event.block;
    	if (block != null)
    	{
    		if ((block == Block.furnaceIdle) || (block == Block.furnaceBurning))
    		{
                ItemStack stack;
                Iterator drop = event.drops.iterator();
                
                while (drop.hasNext())
                {
                    stack = (ItemStack) drop.next();

                    if (stack.getItem().itemID == 61)
                    {
                        drop.remove();
                    }
                }
    		}
    	}    	
    }
    @ForgeSubscribe
    public void entityItemPickup(EntityItemPickupEvent event)
    {
       	Item item = event.item.getEntityItem().getItem();
    	if (item != null)
    	{
    		if ((item.itemID == Block.furnaceIdle.blockID) || (item.itemID == Block.furnaceBurning.blockID))
    		{
    			event.setResult(ALLOW);
    		}
    	}
    }
    
    @ForgeSubscribe
    public void am2RecipeItems(am2.api.events.SpellRecipeItemsEvent event)
    {
    	for (int i = 0; i< event.recipeItems.length;i++)
    	{
	    	if (MineFantasy.hardcoreCraft & false)
	    	{	    
	    		//Tools and Weapons
		    		if (event.recipeItems[i] == Item.shears)
		    		{
		    			LogController.fine("Replacing Iron pickaxe with Bronze pickaxe in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.shearsIron;
		    		}
		    		//Iron
		    		if (event.recipeItems[i] == Item.pickaxeIron)
		    		{
		    			LogController.fine("Replacing Iron pickaxe with Bronze pickaxe in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.pickBronze;
		    		}
		    		else if (event.recipeItems[i] == Item.shovelIron)
		    		{
		    			LogController.fine("Replacing Iron shovel with Bronze shovel in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.shovelBronze;
		    		}
		    		else if (event.recipeItems[i] == Item.swordIron)
		    		{
		    			LogController.fine("Replacing Iron sword with Stone spear in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.spearStone;
		    		}
		    		else if (event.recipeItems[i] == Item.hoeIron)
		    		{
		    			LogController.fine("Replacing Iron hoe with Tin hoe in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.hoeTin;
		    		}
		    		else if (event.recipeItems[i] == Item.axeIron)
		    		{
		    			LogController.fine("Replacing Iron axe with Bronze axe in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.axeBronze;
		    		}
		    		//Stone
		    		if (event.recipeItems[i] == Item.pickaxeStone)
		    		{
		    			LogController.fine("Replacing Stone pickaxe with Primitive copper handpick in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.pickCopperPrim;
		    		}
		    		else if (event.recipeItems[i] == Item.shovelStone)
		    		{
		    			LogController.fine("Replacing Stone shovel with Tin shovel in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.shovelTin;
		    		}
		    		else if (event.recipeItems[i] == Item.swordStone)
		    		{
		    			LogController.fine("Replacing Stone sword with Stone club in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.clubStone;
		    		}
		    		else if (event.recipeItems[i] == Item.hoeStone)
		    		{
		    			LogController.fine("Replacing Stone hoe with Tin hoe in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.hoeTin;
		    		}
		    		else if (event.recipeItems[i] == Item.axeStone)
		    		{
		    			LogController.fine("Replacing Stone axe with Primitive stone axe in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.axeStone;
		    		}
		    	//Armours
		    		//Iron
		    		if (event.recipeItems[i] == Item.plateIron)
		    		{
		    			LogController.fine("Replacing Iron chestplate with Iron splintmail chestplate in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.plateIronSplint;
		    		}
		    		else if (event.recipeItems[i] == Item.legsIron)
		    		{
		    			LogController.fine("Replacing Iron legs with Iron splintmail chestplate in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.legsIronSplint;
		    		}
		    		else if (event.recipeItems[i] == Item.helmetIron)
		    		{
		    			LogController.fine("Replacing Iron helmet with Iron splintmail helmet in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.helmetIronSplint;
		    		}
		    		else if (event.recipeItems[i] == Item.bootsIron)
		    		{
		    			LogController.fine("Replacing Iron boots with Iron splintmail boots in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.bootsIronSplint;
		    		}
		    		//Diamond
		    		if (event.recipeItems[i] == Item.plateDiamond)
		    		{
		    			LogController.fine("Replacing Diamond chestplate with Encrusted chestplate in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.plateEncrusted;
		    		}
		    		else if (event.recipeItems[i] == Item.legsDiamond)
		    		{
		    			LogController.fine("Replacing Diamond legs with Encrusted splintmail chestplate in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.legsEncrusted;
		    		}
		    		else if (event.recipeItems[i] == Item.helmetDiamond)
		    		{
		    			LogController.fine("Replacing Diamond helmet with Encrusted splintmail helmet in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.helmetEncrusted;
		    		}
		    		else if (event.recipeItems[i] == Item.bootsDiamond)
		    		{
		    			LogController.fine("Replacing Diamond boots with Encrusted splintmail boots in spell component: "+event.registeredName);
		    			event.recipeItems[i]=MFParts.bootsEncrusted;
		    		}
	    	}
	    	if (MineFantasy.hardcoreFurnaces & false)
	    	{
	    		if (event.recipeItems[i] == Block.furnaceIdle)
	    		{
	    			LogController.fine("Replacing Furnace with Bloomery in spell component: "+event.registeredName);
	    			event.recipeItems[i]=MFParts.bloomery;
	    		}
	    	}
    	}
    }
    
}
