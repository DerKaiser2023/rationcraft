package rationcraft;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import rationcraft.loading.ItemLoader;
import rationcraft.items.CTB3DItem;
import rationcraft.items.food.ItemRation;
import rationcraft.renders.ItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        registerRenderers();
    }

    private void registerRenderers() {
        for (ItemRation ration : ItemRation.rations) {
            MinecraftForgeClient.registerItemRenderer(ration,
                new ItemRenderer(ration.getTextureName()));
        }
        for (CTB3DItem item : CTB3DItem.items) {
            MinecraftForgeClient.registerItemRenderer(item,
                new ItemRenderer(item.getTextureName()));
        }
    }
}
