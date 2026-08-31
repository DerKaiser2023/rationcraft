package rationcraft.items.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import rationcraft.CTB;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class CTBMiscItem extends Item {
    public CTBMiscItem() {
        this.setCreativeTab(CTB.tabmisc);
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
