package rationcraft.misc;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CTBTab extends CreativeTabs {
    public Item item = null;

    public CTBTab(String name) {
        super(name);
    }

    @SideOnly(value=Side.CLIENT)
    public Item getTabIconItem() {
        return this.item != null ? this.item : Items.iron_ingot;
    }
}
