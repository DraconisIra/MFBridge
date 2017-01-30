package mfbridge;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

public class RecipeController
{
	/*public static void masterPurge()
	{
		ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

        for (int scan = 0; scan < recipes.size(); scan++)
        {
            Object[] tmpRecipe = (Object[]) recipes.get(scan);
           // if (tmpRecipe
        }
	}*/
	
    public static void remove(ItemStack resultItem)
    {
        if (resultItem != null)
        {
            ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

            for (int scan = 0; scan < recipes.size(); scan++)
            {
                IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
                ItemStack recipeResult = tmpRecipe.getRecipeOutput();

                if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
                {
                    if (tmpRecipe.getRecipeSize() > 1)
                    {
                        LogController.fine("Removing Recipe: " + recipes.get(scan) + " -> " + recipeResult);
                        recipes.remove(scan);
                    }
                    else
                    {
                        LogController.fine("Skipping Single Item Recipe: " + recipes.get(scan) + " -> " + recipeResult);
                    }
                }
            }
        }
        else
        {
            LogController.warning("Skipping null recipe");
        }
    }

    public static void removeSmelting(ItemStack inputItem)
    {
        if (inputItem != null)
        {
            LogController.fine("Removing Smelt: " + inputItem);
            FurnaceRecipes.smelting().getSmeltingList().remove(inputItem.itemID);
        }
        else
        {
            LogController.warning("Skipping null smelt");
        }
    }
}
