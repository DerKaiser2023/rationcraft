package rationcraft.misc;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import rationcraft.items.food.ItemRation;
import rationcraft.loading.ItemLoader;

public class CTBTab extends CreativeTabs {
    private long lastTick;
    private int index;

    public CTBTab(String name) {
        super(name);
    }

    @SideOnly(value=Side.CLIENT)
    public Item getTabIconItem() {
        long time = System.currentTimeMillis();
        if (time - this.lastTick > 2000L) {
            this.lastTick = time;
            this.index = (this.index + 1) % ItemRation.rations.size();
        }
        return this.index >= 0 && this.index < ItemRation.rations.size()
            ? ItemRation.rations.get(this.index)
            : (ItemLoader.kRationDinner != null ? ItemLoader.kRationDinner : Items.iron_ingot);
    }
}