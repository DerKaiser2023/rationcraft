package rationcraft.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class BeardieModelRenderer extends ModelRenderer {
    public boolean bright = false;
    public float field_78803_o;
    public float field_78813_p;
    public boolean garand = false;
    private boolean compiled;
    private int displayList;
    public boolean field_78809_i;
    public boolean field_78806_j;
    public boolean field_78807_k;
    public List field_78804_l;
    public String field_78802_n;
    ModelBase field_78810_s;
    public float field_82906_o;
    public float field_82908_p;
    public float field_82907_q;
    public float textureSizeY;
    public float textureSizeX;
    public float prevRotationPointX;
    public float prevRotationPointY;
    public float prevRotationPointZ;
    public float prevRotationX;
    public float prevRotationY;
    public float prevRotationZ;
    public boolean forceNoList = false;
    public float height = 0.0f;
    public float[][] vectorPos = new float[][]{{1.0f, 1.0f, 1.0f}, {0.0f, 1.0f, 1.0f}, {1.0f, 0.0f, 1.0f}, {0.0f, 0.0f, 1.0f}, {1.0f, 1.0f, 0.0f}, {0.0f, 1.0f, 0.0f}, {1.0f, 0.0f, 0.0f}, {0.0f, 0.0f, 0.0f}};
    public float[][] uv = new float[][]{{0.0f, 0.0f, 1.0f, 1.0f}, {0.0f, 0.0f, 1.0f, 1.0f}, {0.0f, 0.0f, 1.0f, 1.0f}, {0.0f, 0.0f, 1.0f, 1.0f}, {0.0f, 0.0f, 1.0f, 1.0f}, {0.0f, 0.0f, 1.0f, 1.0f}};
    public boolean complexUV = false;
    public int ammoType = -1;
    public boolean rotateDefault = true;
    public boolean converted = false;
    private int displayListC;
    public boolean cList = true;
    public float scale = 1.0f;
    public boolean isChild = false;
    public int discriminator;
    public int discriminator2;

    public BeardieModelRenderer(ModelBase par1ModelBase, String par2Str) {
        super(par1ModelBase, par2Str);
        this.textureWidth = 64.0f;
        this.textureHeight = 32.0f;
        this.field_78806_j = true;
        this.field_78804_l = new ArrayList();
        this.field_78810_s = par1ModelBase;
        par1ModelBase.boxList.add(this);
        this.field_78802_n = par2Str == null ? "" : par2Str;
        this.setTextureSize(par1ModelBase.textureWidth, par1ModelBase.textureHeight);
        if (this.childModels == null) {
            this.childModels = new ArrayList();
        }
    }

    public BeardieModelRenderer(ModelBase par1ModelBase, BeardieModelRenderer bmr) {
        this(par1ModelBase, bmr.field_78802_n);
        int i;
        for (i = 0; i < bmr.field_78804_l.size(); ++i) {
            BeardieModelBox bmb = (BeardieModelBox)bmr.field_78804_l.get(i);
            this.field_78804_l.add(bmb.getCopy(bmr));
        }
        this.field_78803_o = bmr.field_78803_o;
        this.field_78813_p = bmr.field_78813_p;
        for (i = 0; i < bmr.childModels.size(); ++i) {
            BeardieModelRenderer c_bmr = (BeardieModelRenderer)bmr.childModels.get(i);
            BeardieModelRenderer n_bmr = new BeardieModelRenderer(par1ModelBase, c_bmr);
            n_bmr.func_78793_a(c_bmr.rotationPointX, c_bmr.rotationPointY, c_bmr.rotationPointZ);
            n_bmr.setRotation(c_bmr.rotateAngleX, c_bmr.rotateAngleY, c_bmr.rotateAngleZ);
            n_bmr.ammoType = c_bmr.ammoType;
            this.childModels.add(n_bmr);
        }
    }

    public BeardieModelRenderer(ModelBase par1ModelBase) {
        this(par1ModelBase, (String)null);
    }

    public BeardieModelRenderer(ModelBase par1ModelBase, int par2, int par3) {
        this(par1ModelBase);
        this.setTextureOffset(par2, par3);
    }

    public void func_78792_a(ModelRenderer mr) {
        this.addChild((BeardieModelRenderer)mr);
    }

    public void addChild(BeardieModelRenderer par1ModelRenderer) {
        if (this.childModels == null) {
            this.childModels = new ArrayList();
        }
        this.childModels.add(par1ModelRenderer);
    }

    public BeardieModelRenderer setTextureOffset(int par1, int par2) {
        this.field_78803_o = par1;
        this.field_78813_p = par2;
        return this;
    }

    public BeardieModelRenderer addBox(float p_78789_1_, float p_78789_2_, float p_78789_3_, int p_78789_4_, int p_78789_5_, int p_78789_6_) {
        return this.addBox(p_78789_1_, p_78789_2_, p_78789_3_, (float)p_78789_4_, (float)p_78789_5_, (float)p_78789_6_);
    }

    public void setUV(float[][] uv) {
        this.uv = uv;
        this.complexUV = true;
    }

    public BeardieModelRenderer addShape(float par2, float par3, float par4, float[][] vecs, double width, double height, double length) {
        return this.addShape(par2, par3, par4, vecs, (float)width, (float)height, (float)length);
    }

    public BeardieModelRenderer addShape(float par2, float par3, float par4, float[][] vecs, float width, float height, float length) {
        this.height = height;
        this.field_78804_l.add(new BeardieModelBox(this, this.field_78803_o, this.field_78813_p, par2, par3, par4, vecs, width, height, length, 0.0f));
        return this;
    }

    public BeardieModelRenderer addBox(float par1, float par2, float par3, float par4, float par5, float par6) {
        this.field_78804_l.add(new BeardieModelBox(this, this.field_78803_o, this.field_78813_p, par1, par2, par3, par4, par5, par6, 0.0f));
        return this;
    }

    public void addBox(float par1, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.field_78804_l.add(new BeardieModelBox(this, this.field_78803_o, this.field_78813_p, par1, par2, par3, par4, par5, par6, par7));
    }

    public void resetPos() {
        this.rotationPointX = this.prevRotationPointX;
        this.rotationPointY = this.prevRotationPointY;
        this.rotationPointZ = this.prevRotationPointZ;
    }

    public void resetRot() {
        this.rotateAngleX = this.prevRotationX;
        this.rotateAngleY = this.prevRotationY;
        this.rotateAngleZ = this.prevRotationZ;
    }

    public void func_78793_a(float par1, float par2, float par3) {
        this.rotationPointX = par1;
        this.rotationPointY = par2;
        this.rotationPointZ = par3;
        this.prevRotationPointX = par1;
        this.prevRotationPointY = par2;
        this.prevRotationPointZ = par3;
    }

    public void setRotation(float x, float y, float z) {
        this.rotateAngleX = x;
        this.rotateAngleY = y;
        this.rotateAngleZ = z;
        this.prevRotationX = x;
        this.prevRotationY = y;
        this.prevRotationZ = z;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_78785_a(float par1) {
        this.render(par1, true);
    }

    @SideOnly(value=Side.CLIENT)
    public void render(float par1, boolean list) {
        if (this.field_78802_n.contains("ammoCount") && !this.isChild && !this.garand) {
            return;
        }
        GL11.glPushMatrix();
        if (!this.field_78807_k && this.field_78806_j) {
            if (!this.compiled && list) {
                this.compileDisplayList(par1);
            }
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX == 0.0f && this.rotationPointY == 0.0f && this.rotationPointZ == 0.0f) {
                    GL11.glScalef((float)this.scale, (float)this.scale, (float)this.scale);
                    if (list) {
                        GL11.glCallList((int)this.displayList);
                    } else {
                        BeardieModelBox box;
                        Tessellator tessellator = Tessellator.instance;
                        if (this.textureSizeX != 0.0f || this.textureSizeY != 0.0f) {
                            for (int x = 0; x < this.field_78804_l.size(); ++x) {
                                box = (BeardieModelBox)this.field_78804_l.get(x);
                                box.bright = this.bright;
                                box.renderTex(tessellator, par1, this.field_78803_o, this.field_78813_p, this.textureSizeX, this.textureSizeY);
                            }
                        } else if (this.complexUV && this.uv != null && this.uv.length >= 8) {
                            for (int x = 0; x < this.field_78804_l.size(); ++x) {
                                box = (BeardieModelBox)this.field_78804_l.get(x);
                                box.bright = this.bright;
                                box.renderUV(tessellator, par1, this.field_78803_o, this.field_78813_p, this.uv);
                            }
                        } else {
                            for (int x = 0; x < this.field_78804_l.size(); ++x) {
                                box = (BeardieModelBox)this.field_78804_l.get(x);
                                box.bright = this.bright;
                                box.render(tessellator, par1);
                            }
                        }
                    }
                    if (list && this.cList) {
                        GL11.glCallList((int)this.displayListC);
                    } else if (this.childModels != null) {
                        for (int i = 0; i < this.childModels.size(); ++i) {
                            BeardieModelRenderer bmr = (BeardieModelRenderer)this.childModels.get(i);
                            if (bmr.field_78802_n.contains("ammoCount") && !this.garand) continue;
                            bmr.bright = this.bright;
                            bmr.render(par1, false);
                        }
                    }
                } else {
                    GL11.glTranslatef((float)(this.rotationPointX * par1), (float)(this.rotationPointY * par1), (float)(this.rotationPointZ * par1));
                    GL11.glScalef((float)this.scale, (float)this.scale, (float)this.scale);
                    if (list) {
                        GL11.glCallList((int)this.displayList);
                    } else {
                        BeardieModelBox box;
                        Tessellator tessellator = Tessellator.instance;
                        if (this.textureSizeX != 0.0f || this.textureSizeY != 0.0f) {
                            for (int x = 0; x < this.field_78804_l.size(); ++x) {
                                box = (BeardieModelBox)this.field_78804_l.get(x);
                                box.bright = this.bright;
                                box.renderTex(tessellator, par1, this.field_78803_o, this.field_78813_p, this.textureSizeX, this.textureSizeY);
                            }
                        } else if (this.complexUV && this.uv != null && this.uv.length >= 8) {
                            for (int x = 0; x < this.field_78804_l.size(); ++x) {
                                box = (BeardieModelBox)this.field_78804_l.get(x);
                                box.bright = this.bright;
                                box.renderUV(tessellator, par1, this.field_78803_o, this.field_78813_p, this.uv);
                            }
                        } else {
                            for (int x = 0; x < this.field_78804_l.size(); ++x) {
                                box = (BeardieModelBox)this.field_78804_l.get(x);
                                box.bright = this.bright;
                                box.render(tessellator, par1);
                            }
                        }
                    }
                    if (list && this.cList) {
                        GL11.glCallList((int)this.displayListC);
                    } else if (this.childModels != null) {
                        for (int i = 0; i < this.childModels.size(); ++i) {
                            BeardieModelRenderer bmr = (BeardieModelRenderer)this.childModels.get(i);
                            if (bmr.field_78802_n.contains("ammoCount") && !this.garand) continue;
                            bmr.bright = this.bright;
                            bmr.render(par1, false);
                        }
                    }
                    GL11.glTranslatef((float)(-this.rotationPointX * par1), (float)(-this.rotationPointY * par1), (float)(-this.rotationPointZ * par1));
                }
            } else {
                GL11.glPushMatrix();
                GL11.glTranslatef((float)(this.rotationPointX * par1), (float)(this.rotationPointY * par1), (float)(this.rotationPointZ * par1));
                GL11.glTranslatef((float)(this.field_82906_o * par1), (float)(this.field_82908_p * par1), (float)(this.field_82907_q * par1));
                if (this.rotateDefault) {
                    if (this.rotateAngleZ != 0.0f) {
                        GL11.glRotatef((float)(this.rotateAngleZ * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
                    }
                    if (this.rotateAngleY != 0.0f) {
                        GL11.glRotatef((float)(this.rotateAngleY * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
                    }
                } else {
                    if (this.rotateAngleY != 0.0f) {
                        GL11.glRotatef((float)(this.rotateAngleY * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
                    }
                    if (this.rotateAngleZ != 0.0f) {
                        GL11.glRotatef((float)(this.rotateAngleZ * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
                    }
                }
                if (this.rotateAngleX != 0.0f) {
                    GL11.glRotatef((float)(this.rotateAngleX * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
                }
                GL11.glTranslatef((float)(-this.field_82906_o * par1), (float)(-this.field_82908_p * par1), (float)(-this.field_82907_q * par1));
                GL11.glScalef((float)this.scale, (float)this.scale, (float)this.scale);
                if (list) {
                    GL11.glCallList((int)this.displayList);
                } else {
                    BeardieModelBox box;
                    Tessellator tessellator = Tessellator.instance;
                    if (this.textureSizeX != 0.0f || this.textureSizeY != 0.0f) {
                        for (int x = 0; x < this.field_78804_l.size(); ++x) {
                            box = (BeardieModelBox)this.field_78804_l.get(x);
                            box.bright = this.bright;
                            box.renderTex(tessellator, par1, this.field_78803_o, this.field_78813_p, this.textureSizeX, this.textureSizeY);
                        }
                    } else if (this.complexUV && this.uv != null && this.uv.length >= 8) {
                        for (int x = 0; x < this.field_78804_l.size(); ++x) {
                            box = (BeardieModelBox)this.field_78804_l.get(x);
                            box.bright = this.bright;
                            box.renderUV(tessellator, par1, this.field_78803_o, this.field_78813_p, this.uv);
                        }
                    } else {
                        for (int x = 0; x < this.field_78804_l.size(); ++x) {
                            box = (BeardieModelBox)this.field_78804_l.get(x);
                            box.bright = this.bright;
                            box.render(tessellator, par1);
                        }
                    }
                }
                if (list && this.cList) {
                    GL11.glCallList((int)this.displayListC);
                } else if (this.childModels != null) {
                    for (int i = 0; i < this.childModels.size(); ++i) {
                        BeardieModelRenderer bmr = (BeardieModelRenderer)this.childModels.get(i);
                        if (bmr.field_78802_n.contains("ammoCount") && !this.garand) continue;
                        bmr.bright = this.bright;
                        bmr.render(par1, false);
                    }
                }
                GL11.glPopMatrix();
            }
        }
        GL11.glPopMatrix();
    }

    @SideOnly(value=Side.CLIENT)
    public void func_78791_b(float par1) {
        if (!this.field_78807_k && this.field_78806_j) {
            if (!this.compiled) {
                this.compileDisplayList(par1);
            }
            GL11.glPushMatrix();
            GL11.glTranslatef((float)(this.rotationPointX * par1), (float)(this.rotationPointY * par1), (float)(this.rotationPointZ * par1));
            if (this.rotateAngleY != 0.0f) {
                GL11.glRotatef((float)(this.rotateAngleY * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
            }
            if (this.rotateAngleX != 0.0f) {
                GL11.glRotatef((float)(this.rotateAngleX * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
            }
            if (this.rotateAngleZ != 0.0f) {
                GL11.glRotatef((float)(this.rotateAngleZ * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
            }
            GL11.glCallList((int)this.displayList);
            GL11.glPopMatrix();
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_78794_c(float par1) {
        if (!this.field_78807_k && this.field_78806_j) {
            if (!this.compiled) {
                this.compileDisplayList(par1);
            }
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX != 0.0f || this.rotationPointY != 0.0f || this.rotationPointZ != 0.0f) {
                    GL11.glTranslatef((float)(this.rotationPointX * par1), (float)(this.rotationPointY * par1), (float)(this.rotationPointZ * par1));
                }
            } else {
                GL11.glTranslatef((float)(this.rotationPointX * par1), (float)(this.rotationPointY * par1), (float)(this.rotationPointZ * par1));
                if (this.rotateAngleZ != 0.0f) {
                    GL11.glRotatef((float)(this.rotateAngleZ * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
                }
                if (this.rotateAngleY != 0.0f) {
                    GL11.glRotatef((float)(this.rotateAngleY * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
                }
                if (this.rotateAngleX != 0.0f) {
                    GL11.glRotatef((float)(this.rotateAngleX * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
                }
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    private void compileDisplayList(float par1) {
        BeardieModelBox box;
        int i;
        this.displayList = GLAllocation.generateDisplayLists(1);
        GL11.glNewList((int)this.displayList, (int)4864);
        Tessellator tessellator = Tessellator.instance;
        if (this.textureSizeX != 0.0f || this.textureSizeY != 0.0f) {
            for (i = 0; i < this.field_78804_l.size(); ++i) {
                box = (BeardieModelBox)this.field_78804_l.get(i);
                box.bright = this.bright;
                box.renderTex(tessellator, par1, this.field_78803_o, this.field_78813_p, this.textureSizeX, this.textureSizeY);
            }
        } else if (this.complexUV && this.uv != null && this.uv.length >= 8) {
            for (i = 0; i < this.field_78804_l.size(); ++i) {
                box = (BeardieModelBox)this.field_78804_l.get(i);
                box.bright = this.bright;
                box.renderUV(tessellator, par1, this.field_78803_o, this.field_78813_p, this.uv);
            }
        } else {
            for (i = 0; i < this.field_78804_l.size(); ++i) {
                box = (BeardieModelBox)this.field_78804_l.get(i);
                box.bright = this.bright;
                box.render(tessellator, par1);
            }
        }
        GL11.glEndList();
        this.compiled = true;
        this.displayListC = GLAllocation.generateDisplayLists(1);
        GL11.glNewList((int)this.displayListC, (int)4864);
        if (this.childModels != null) {
            for (i = 0; i < this.childModels.size(); ++i) {
                BeardieModelRenderer childModel = (BeardieModelRenderer)this.childModels.get(i);
                childModel.bright = this.bright;
                childModel.render(par1, false);
            }
        }
        GL11.glEndList();
    }

    public BeardieModelRenderer setTextureSize(int par1, int par2) {
        this.textureWidth = par1;
        this.textureHeight = par2;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public void renderBlock(float par1) {
        Tessellator tessellator = Tessellator.instance;
        if (!this.field_78807_k && this.field_78806_j) {
            GL11.glTranslatef((float)this.field_82906_o, (float)this.field_82908_p, (float)this.field_82907_q);
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX == 0.0f && this.rotationPointY == 0.0f && this.rotationPointZ == 0.0f) {
                    for (int x = 0; x < this.field_78804_l.size(); ++x) {
                        ((BeardieModelBox)this.field_78804_l.get(x)).render(tessellator, par1);
                    }
                    if (this.childModels != null) {
                        for (int i = 0; i < this.childModels.size(); ++i) {
                            ((BeardieModelRenderer)this.childModels.get(i)).renderBlock(par1);
                        }
                    }
                } else {
                    GL11.glTranslatef((float)(this.rotationPointX * par1), (float)(this.rotationPointY * par1), (float)(this.rotationPointZ * par1));
                    for (int x = 0; x < this.field_78804_l.size(); ++x) {
                        ((BeardieModelBox)this.field_78804_l.get(x)).render(tessellator, par1);
                    }
                    if (this.childModels != null) {
                        for (int i = 0; i < this.childModels.size(); ++i) {
                            ((BeardieModelRenderer)this.childModels.get(i)).renderBlock(par1);
                        }
                    }
                    GL11.glTranslatef((float)(-this.rotationPointX * par1), (float)(-this.rotationPointY * par1), (float)(-this.rotationPointZ * par1));
                }
            } else {
                GL11.glPushMatrix();
                GL11.glTranslatef((float)(this.rotationPointX * par1), (float)(this.rotationPointY * par1), (float)(this.rotationPointZ * par1));
                if (this.rotateAngleZ != 0.0f) {
                    GL11.glRotatef((float)(this.rotateAngleZ * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
                }
                if (this.rotateAngleY != 0.0f) {
                    GL11.glRotatef((float)(this.rotateAngleY * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
                }
                if (this.rotateAngleX != 0.0f) {
                    GL11.glRotatef((float)(this.rotateAngleX * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
                }
                for (int x = 0; x < this.field_78804_l.size(); ++x) {
                    ((BeardieModelBox)this.field_78804_l.get(x)).render(tessellator, par1);
                }
                if (this.childModels != null) {
                    for (int i = 0; i < this.childModels.size(); ++i) {
                        ((BeardieModelRenderer)this.childModels.get(i)).renderBlock(par1);
                    }
                }
                GL11.glPopMatrix();
            }
            GL11.glTranslatef((float)(-this.field_82906_o), (float)(-this.field_82908_p), (float)(-this.field_82907_q));
        }
    }
}
