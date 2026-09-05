package rationcraft.renders;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import rationcraft.models.ModelBeardieBase;

public class ItemRenderer implements IItemRenderer {
    private ModelBeardieBase model;
    private ModelArm armModel;
    private String itemName;

    public ItemRenderer(String itemName) {
        this.itemName = itemName;
        this.model = ModelReader.readModel(new ResourceLocation("rationcraft:models/items/" + itemName + ".bmodel"));
        this.armModel = new ModelArm();
    }

    @Override
    public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
        return type != IItemRenderer.ItemRenderType.INVENTORY && type != IItemRenderer.ItemRenderType.ENTITY;
    }

    @Override
    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
        return false;
    }

    private void doDefaultTransform() {
        GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(1.15f, 0.4f, 0.0f);
    }

    private void renderHandArm() {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        if (player == null) return;
        try {
            java.lang.reflect.Method m = player.getClass().getMethod("func_110306_p");
            ResourceLocation skin = (ResourceLocation) m.invoke(player);
            Minecraft.getMinecraft().getTextureManager().bindTexture(skin);
        } catch (Exception e) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/entity/steve.png"));
        }
        this.armModel.render(player, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
    }

    @Override
    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        if (type == IItemRenderer.ItemRenderType.EQUIPPED) {
            GL11.glPushMatrix();
            renderHandArm();
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
            float scale = this.model.scale;
            GL11.glTranslatef(0.7f, 0.16f * scale, 0.05f);
            GL11.glScalef(scale, scale, -scale);
            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rationcraft:textures/models/items/" + this.itemName + ".png"));
            this.model.func_78088_a((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
            GL11.glPopMatrix();
        } else if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glPushMatrix();
            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glEnable(2884);
            GL11.glEnable(2896);
            renderHandArm();
            doDefaultTransform();
            GL11.glTranslatef(this.model.whOffX, this.model.whOffY, this.model.whOffZ);
            GL11.glTranslatef(this.model.mOffX * 0.0625f, this.model.mOffY * 0.0625f, this.model.mOffZ * 0.0625f);
            float scale = this.model.scale;
            GL11.glScalef(1.5f, 1.5f, 1.5f);
            GL11.glScalef(scale, scale, scale);
            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rationcraft:textures/models/items/" + this.itemName + ".png"));
            this.model.func_78088_a((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
            GL11.glPopMatrix();
        }
        GL11.glDisable(3042);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
}