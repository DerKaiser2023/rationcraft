package rationcraft;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import rationcraft.loading.ItemLoader;
import rationcraft.loading.RecipeLoader;
import rationcraft.misc.CTBTab;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        CTB.tabmisc = new CTBTab("Rations");
        ItemLoader.loadItems(event);
        RecipeLoader.registerRecipes();
    }
}
