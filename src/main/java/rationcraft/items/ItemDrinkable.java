package rationcraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemDrinkable extends CTB3DItem {
    private Item baseItem;
    private int duration;
    private int[] potionIDs;
    private int[] potionDurations;
    private int[] potionAmps;

    public ItemDrinkable(Item baseItem, int duration) {
        this(baseItem, duration, null, null, null);
    }

    public ItemDrinkable(Item baseItem, int duration, int[] potionID, int[] potionDuration, int[] potionAmplifier) {
        this.duration = duration;
        this.baseItem = baseItem;
        this.potionIDs = potionID;
        this.potionDurations = potionDuration;
        this.potionAmps = potionAmplifier;
    }

    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --stack.stackSize;
            ItemStack itemStack = new ItemStack(this.baseItem);
            if (!player.inventory.addItemStackToInventory(itemStack)) {
                player.dropPlayerItemWithRandomChoice(itemStack, false);
            }
        }
        if (this.potionIDs != null) {
            for (int i = 0; i < this.potionIDs.length; ++i) {
                player.addPotionEffect(new PotionEffect(this.potionIDs[i], this.potionDurations[i], this.potionAmps[i], true));
            }
        }
        return stack;
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        return this.duration;
    }

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.drink;
    }

    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        player.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }
}
