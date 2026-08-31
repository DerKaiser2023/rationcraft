package rationcraft.loading;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import rationcraft.CTB;
import rationcraft.items.CTB3DItem;
import rationcraft.items.ItemDrinkable;
import rationcraft.items.ItemRationBox;
import rationcraft.items.food.CTBMiscItem;
import rationcraft.items.food.ItemRation;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class ItemLoader {
    public static ItemRation biscuit;
    public static ItemRation fruitBar;
    public static ItemRation dRation;
    public static ItemRation cannedVeal;
    public static ItemRation cannedHamAndEggs;
    public static ItemRation cannedLuncheon;
    public static ItemRation cannedLoafSausage;
    public static ItemRation cannedCheese;
    public static ItemRationBox kRationBreakfast;
    public static ItemRationBox kRationDinner;
    public static ItemRationBox kRationSupper;
    public static CTBMiscItem coffeePacket;
    public static CTB3DItem canteenCup;
    public static ItemDrinkable canteenCupCoffee;

    public static void loadItems(FMLPreInitializationEvent event) {
        biscuit = (ItemRation) new ItemRation(1, 0.1f, false, 12).setUnlocalizedName("k4biscuit");
        LanguageRegistry.addName(biscuit, "K4 Biscuit");
        GameRegistry.registerItem(biscuit, "k4biscuit");

        fruitBar = (ItemRation) new ItemRation(4, 0.8f, false, 24).setUnlocalizedName("fruitbar");
        LanguageRegistry.addName(fruitBar, "Fruit Bar");
        GameRegistry.registerItem(fruitBar, "fruitbar");

        dRation = (ItemRation) new ItemRation(4, 0.8f, false, 32).setUnlocalizedName("dration");
        LanguageRegistry.addName(dRation, "D-Ration");
        GameRegistry.registerItem(dRation, "dration");

        cannedVeal = (ItemRation) new ItemRation(9, 0.9f, false, 40).setUnlocalizedName("cannedveal");
        LanguageRegistry.addName(cannedVeal, "Canned Veal");
        GameRegistry.registerItem(cannedVeal, "cannedveal");

        cannedHamAndEggs = (ItemRation) new ItemRation(12, 1.2f, false, 40).setUnlocalizedName("cannedhameggs");
        LanguageRegistry.addName(cannedHamAndEggs, "Canned Ham and Eggs");
        GameRegistry.registerItem(cannedHamAndEggs, "cannedhameggs");

        cannedLuncheon = (ItemRation) new ItemRation(7, 0.7f, false, 40).setUnlocalizedName("cannedluncheon");
        LanguageRegistry.addName(cannedLuncheon, "Canned Pork Luncheon");
        GameRegistry.registerItem(cannedLuncheon, "cannedluncheon");

        cannedLoafSausage = (ItemRation) new ItemRation(11, 1.0f, false, 40).setUnlocalizedName("cannedloafsausage");
        LanguageRegistry.addName(cannedLoafSausage, "Canned Beef Loaf and Sausage");
        GameRegistry.registerItem(cannedLoafSausage, "cannedloafsausage");

        cannedCheese = (ItemRation) new ItemRation(3, 0.4f, false, 34).setUnlocalizedName("cannedcheese");
        LanguageRegistry.addName(cannedCheese, "Canned Cheese");
        GameRegistry.registerItem(cannedCheese, "cannedcheese");

        coffeePacket = (CTBMiscItem) new CTBMiscItem().setUnlocalizedName("coffeepacket");
        LanguageRegistry.addName(coffeePacket, "Coffee Packet");
        GameRegistry.registerItem(coffeePacket, "coffeepacket");

        canteenCup = (CTB3DItem) new CTB3DItem().setUnlocalizedName("canteencup").setMaxStackSize(1);
        LanguageRegistry.addName(canteenCup, "Canteen Cup");
        GameRegistry.registerItem(canteenCup, "canteencup");

        canteenCupCoffee = (ItemDrinkable) new ItemDrinkable(canteenCup, 34, new int[]{Potion.moveSpeed.id, Potion.digSpeed.id}, new int[]{1200, 1200}, new int[]{0, 2}).setUnlocalizedName("canteencupcoffee").setMaxStackSize(1);
        LanguageRegistry.addName(canteenCupCoffee, "Canteen Cup(Coffee)");
        GameRegistry.registerItem(canteenCupCoffee, "canteencupcoffee");

        kRationBreakfast = (ItemRationBox) new ItemRationBox(new ItemStack[]{new ItemStack(cannedHamAndEggs, 1), new ItemStack(biscuit, 8), new ItemStack(fruitBar, 1), new ItemStack(coffeePacket)}).setUnlocalizedName("krationbreakfast");
        LanguageRegistry.addName(kRationBreakfast, "K-Ration Breakfast");
        GameRegistry.registerItem(kRationBreakfast, "krationbreakfast");

        kRationDinner = (ItemRationBox) new ItemRationBox(new ItemStack[]{new ItemStack(cannedLuncheon, 1), new ItemStack(cannedCheese, 1), new ItemStack(biscuit, 8)}).setUnlocalizedName("krationdinner");
        LanguageRegistry.addName(kRationDinner, "K-Ration Dinner");
        GameRegistry.registerItem(kRationDinner, "krationdinner");

        kRationSupper = (ItemRationBox) new ItemRationBox(new ItemStack[]{new ItemStack(cannedLoafSausage, 1), new ItemStack(biscuit, 8), new ItemStack(dRation, 1)}).setUnlocalizedName("krationsupper");
        LanguageRegistry.addName(kRationSupper, "K-Ration Supper");
        GameRegistry.registerItem(kRationSupper, "krationsupper");
    }
}
