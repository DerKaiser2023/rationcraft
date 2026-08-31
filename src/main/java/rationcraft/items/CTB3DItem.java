package rationcraft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import rationcraft.CTB;
import java.util.ArrayList;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class CTB3DItem extends Item {
    public static ArrayList<CTB3DItem> items = new ArrayList<CTB3DItem>();

    public CTB3DItem() {
        this.setCreativeTab(CTB.tabmisc);
        items.add(this);
        CTB.itemList.add(this);
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("rationcraft:misc/" + this.getUnlocalizedName().substring(5));
    }

    public String getTextureName() {
        return this.getUnlocalizedName().substring(5);
    }
}
