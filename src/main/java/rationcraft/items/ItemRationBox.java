package rationcraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRationBox extends CTB3DItem {
    private ItemStack[] rations;

    public ItemRationBox(ItemStack[] rations) {
        this.rations = rations;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            for (ItemStack ration : this.rations) {
                if (!player.inventory.addItemStackToInventory(ration.copy())) {
                    player.dropPlayerItemWithRandomChoice(ration.copy(), false);
                }
            }
            --itemStackIn.stackSize;
        }
        return itemStackIn;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 0;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.none;
    }
}
