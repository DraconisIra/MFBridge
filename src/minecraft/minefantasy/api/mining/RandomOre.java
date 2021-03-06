package minefantasy.api.mining;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RandomOre
{
    public static ArrayList<RandomOre> drops = new ArrayList<RandomOre>();

    private final ItemStack loot;
    private final float chanceToDrop;
    private final int blockID;
    private final int blockSub;
    private final int harvestLvl;
    private final int minHeight;
    private final int maxHeight;
    private final boolean doesSilktouchDisable;

    /**
     * Adds an ore to drop
     * @param drop  the item dropped
     * @param chance the chance as a decimal to succeed
     * @param block the block it drops from (ID, Block, or stack)
     */
    public static void addOre(ItemStack drop, float chance, Object block, int harvestLevel, int min, int max, boolean silkDisable)
    {
        drops.add(new RandomOre(drop, chance, block, harvestLevel, min, max, silkDisable));
    }

    public static ArrayList<ItemStack>getDroppedItems(int id, int meta, int harvest, int fortune, boolean silktouch, int y)
    {
        ArrayList<ItemStack>loot = new ArrayList<ItemStack>();

        if (!drops.isEmpty())
        {
            Iterator list = drops.iterator();

            while (list.hasNext())
            {
                RandomOre ore = (RandomOre) list.next();

                if (matchesOre(ore, id, meta, harvest, (float)(fortune / 2F) + 1F, silktouch, y))
                {
                    loot.add(ore.loot);
                }
            }
        }

        return loot;
    }

    private static boolean matchesOre(RandomOre ore, int id, int meta, int harvest, float multiplier, boolean silktouch, int y)
    {
        Random random = new Random();

        if (ore.doesSilktouchDisable && silktouch)
        {
            return false;
        }

        if (!(ore.minHeight == -1 && ore.maxHeight == -1))
        {
            if (y < ore.minHeight || y > ore.maxHeight)
            {
                return false;
            }
        }

        if (ore.blockID != id)
        {
            return false;
        }

        if (ore.blockSub != meta && ore.blockSub != OreDictionary.WILDCARD_VALUE)
        {
            return false;
        }

        if (ore.harvestLvl > harvest)
        {
            return false;
        }

        return random.nextFloat() < (ore.chanceToDrop * multiplier);
    }

    public RandomOre(ItemStack drop, float chance, Object block, int harvestLevel, int min, int max, boolean silkDisable)
    {
        doesSilktouchDisable = silkDisable;
        minHeight = min;
        maxHeight = max;
        loot = drop;
        chanceToDrop = chance;
        harvestLvl = harvestLevel;

        if (block instanceof ItemStack)
        {
            blockID = ((ItemStack)block).itemID;
            blockSub = ((ItemStack)block).getItemDamage();
        }
        else if (block instanceof Block)
        {
            blockID = ((Block)block).blockID;
            blockSub = OreDictionary.WILDCARD_VALUE;
        }
        else if (block instanceof Integer)
        {
            blockID = (Integer)block;
            blockSub = OreDictionary.WILDCARD_VALUE;
        }
        else
        {
            blockID = Block.stone.blockID;
            blockSub = OreDictionary.WILDCARD_VALUE;
        }
    }
}
