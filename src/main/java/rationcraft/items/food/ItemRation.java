package rationcraft.items.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import rationcraft.CTB;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemRation extends ItemFood {
    public static java.util.ArrayList<ItemRation> rations = new java.util.ArrayList<ItemRation>();
    private int eatDuration = 12;

    public ItemRation(int par2, float par3, boolean par4, int eatDuration) {
        super(par2, par3, par4);
        this.setCreativeTab(CTB.tabmisc);
        rations.add(this);
        CTB.itemList.add(this);
        this.eatDuration = eatDuration;
    }

    public int getMaxItemUseDuration(ItemStack p_77626_1_) {
        return this.eatDuration;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("rationcraft:misc/" + this.getUnlocalizedName().substring(5));
    }

    public String getTextureName() {
        return this.getUnlocalizedName().substring(5);
    }
}
