package rationcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import rationcraft.misc.CTBTab;
import java.util.ArrayList;
import net.minecraft.item.Item;

@Mod(modid = "rationcraft", name = "Ration Craft", version = "1.1")
public class CTB {
    public static CTBTab tabmisc;
    public static ArrayList<Item> itemList = new ArrayList<Item>();

    @SidedProxy(clientSide = "rationcraft.ClientProxy", serverSide = "rationcraft.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }
}
