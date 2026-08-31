package rationcraft.loading;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeLoader {
    public static void registerRecipes() {
        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.biscuit, 8),
            new Object[]{new ItemStack(Items.wheat, 2)});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.fruitBar),
            new Object[]{new ItemStack(Items.apple, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.dRation),
            new Object[]{new ItemStack(Items.dye, 2, 15)});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.cannedVeal),
            new Object[]{new ItemStack(Items.cooked_beef, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.cannedHamAndEggs),
            new Object[]{new ItemStack(Items.cooked_porkchop, 1), new ItemStack(Items.egg, 2)});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.cannedLuncheon),
            new Object[]{new ItemStack(Items.cooked_porkchop, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.cannedLoafSausage),
            new Object[]{new ItemStack(Items.cooked_beef, 1), new ItemStack(Items.cooked_porkchop)});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.cannedCheese),
            new Object[]{new ItemStack(Items.milk_bucket)});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.coffeePacket, 3),
            new Object[]{new ItemStack(Items.sugar, 3), new ItemStack(Items.dye, 2, 15), new ItemStack(Items.glowstone_dust)});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.canteenCup, 1),
            new Object[]{new ItemStack(Items.iron_ingot, 3)});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.canteenCupCoffee, 1),
            new Object[]{new ItemStack(ItemLoader.canteenCup, 1), new ItemStack(ItemLoader.coffeePacket)});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.kRationBreakfast),
            new Object[]{new ItemStack(ItemLoader.cannedHamAndEggs), new ItemStack(ItemLoader.biscuit, 8), new ItemStack(ItemLoader.fruitBar), new ItemStack(ItemLoader.coffeePacket)});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.kRationDinner),
            new Object[]{new ItemStack(ItemLoader.cannedLuncheon), new ItemStack(ItemLoader.cannedCheese), new ItemStack(ItemLoader.biscuit, 8)});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.kRationSupper),
            new Object[]{new ItemStack(ItemLoader.cannedLoafSausage), new ItemStack(ItemLoader.biscuit, 8), new ItemStack(ItemLoader.dRation)});
    }
}
