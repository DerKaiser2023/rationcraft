package rationcraft.renders;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelArm extends ModelBiped {
    public ModelArm() {
        this(0.0f, false);
    }

    public ModelArm(float p_i46304_1_, boolean p_i46304_2_) {
        super(p_i46304_1_, 0.0f, 64, 32);
    }

    @Override
    public void render(Entity entity, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale) {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, scale, entity);
        this.bipedRightArm.render(scale);
    }
}