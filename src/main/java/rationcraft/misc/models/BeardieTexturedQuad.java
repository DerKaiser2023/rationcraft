package rationcraft.models;

import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Vec3;

public class BeardieTexturedQuad extends TexturedQuad {
    public PositionTextureVertex[] field_78239_a;
    public int field_78237_b;
    private boolean invertNormal;
    public boolean bright = false;
    public BeardieModelRenderer model;

    public BeardieTexturedQuad(PositionTextureVertex[] par1ArrayOfPositionTextureVertex) {
        super(par1ArrayOfPositionTextureVertex);
        this.field_78239_a = par1ArrayOfPositionTextureVertex;
        this.field_78237_b = par1ArrayOfPositionTextureVertex.length;
    }

    public BeardieTexturedQuad(PositionTextureVertex[] par1ArrayOfPositionTextureVertex, float par2, float par3, float par4, float par5, float par6, float par7) {
        this(par1ArrayOfPositionTextureVertex);
        float f2 = 0.0f / par6;
        float f3 = 0.0f / par7;
        par1ArrayOfPositionTextureVertex[0] = par1ArrayOfPositionTextureVertex[0].setTexturePosition(par4 / par6 - f2, par3 / par7 + f3);
        par1ArrayOfPositionTextureVertex[1] = par1ArrayOfPositionTextureVertex[1].setTexturePosition(par2 / par6 + f2, par3 / par7 + f3);
        par1ArrayOfPositionTextureVertex[2] = par1ArrayOfPositionTextureVertex[2].setTexturePosition(par2 / par6 + f2, par5 / par7 - f3);
        par1ArrayOfPositionTextureVertex[3] = par1ArrayOfPositionTextureVertex[3].setTexturePosition(par4 / par6 - f2, par5 / par7 - f3);
    }

    public void func_78235_a() {
        PositionTextureVertex[] apositiontexturevertex = new PositionTextureVertex[this.field_78239_a.length];
        for (int i = 0; i < this.field_78239_a.length; ++i) {
            apositiontexturevertex[i] = this.field_78239_a[this.field_78239_a.length - i - 1];
        }
        this.field_78239_a = apositiontexturevertex;
    }

    public void func_78236_a(Tessellator par1Tessellator, float par2) {
        Vec3 vec3 = this.field_78239_a[1].vector3D.subtract(this.field_78239_a[0].vector3D);
        Vec3 vec31 = this.field_78239_a[1].vector3D.subtract(this.field_78239_a[2].vector3D);
        Vec3 vec32 = vec31.crossProduct(vec3).normalize();
        par1Tessellator.startDrawingQuads();
        if (this.bright) {
            RenderHelper.disableStandardItemLighting();
            par1Tessellator.setBrightness(224);
        }
        if (this.invertNormal) {
            par1Tessellator.setNormal(-((float)vec32.xCoord), -((float)vec32.yCoord), -((float)vec32.zCoord));
        } else {
            par1Tessellator.setNormal((float)vec32.xCoord, (float)vec32.yCoord, (float)vec32.zCoord);
        }
        for (int i = 0; i < 4; ++i) {
            PositionTextureVertex positiontexturevertex = this.field_78239_a[i];
            par1Tessellator.addVertexWithUV((double)((float)positiontexturevertex.vector3D.xCoord * par2), (double)((float)positiontexturevertex.vector3D.yCoord * par2), (double)((float)positiontexturevertex.vector3D.zCoord * par2), (double)positiontexturevertex.texturePositionX, (double)positiontexturevertex.texturePositionY);
        }
        par1Tessellator.draw();
    }

    public void drawTexture(Tessellator par1Tessellator, float par2, float tx, float ty, float width, float height) {
        Vec3 vec3 = this.field_78239_a[1].vector3D.subtract(this.field_78239_a[0].vector3D);
        Vec3 vec31 = this.field_78239_a[1].vector3D.subtract(this.field_78239_a[2].vector3D);
        Vec3 vec32 = vec31.crossProduct(vec3).normalize();
        par1Tessellator.startDrawingQuads();
        if (this.bright) {
            RenderHelper.disableStandardItemLighting();
            par1Tessellator.setBrightness(224);
        }
        if (this.invertNormal) {
            par1Tessellator.setNormal(-((float)vec32.xCoord), -((float)vec32.yCoord), -((float)vec32.zCoord));
        } else {
            par1Tessellator.setNormal((float)vec32.xCoord, (float)vec32.yCoord, (float)vec32.zCoord);
        }
        PositionTextureVertex positiontexturevertex = this.field_78239_a[1];
        par1Tessellator.addVertexWithUV((double)((float)positiontexturevertex.vector3D.xCoord * par2), (double)((float)positiontexturevertex.vector3D.yCoord * par2), (double)((float)positiontexturevertex.vector3D.zCoord * par2), (double)tx, (double)ty);
        PositionTextureVertex positiontexturevertex2 = this.field_78239_a[2];
        par1Tessellator.addVertexWithUV((double)((float)positiontexturevertex2.vector3D.xCoord * par2), (double)((float)positiontexturevertex2.vector3D.yCoord * par2), (double)((float)positiontexturevertex2.vector3D.zCoord * par2), (double)tx, (double)height);
        PositionTextureVertex positiontexturevertex3 = this.field_78239_a[3];
        par1Tessellator.addVertexWithUV((double)((float)positiontexturevertex3.vector3D.xCoord * par2), (double)((float)positiontexturevertex3.vector3D.yCoord * par2), (double)((float)positiontexturevertex3.vector3D.zCoord * par2), (double)width, (double)height);
        PositionTextureVertex positiontexturevertex4 = this.field_78239_a[0];
        par1Tessellator.addVertexWithUV((double)((float)positiontexturevertex4.vector3D.xCoord * par2), (double)((float)positiontexturevertex4.vector3D.yCoord * par2), (double)((float)positiontexturevertex4.vector3D.zCoord * par2), (double)width, (double)ty);
        par1Tessellator.draw();
    }

    public void drawTexture(Tessellator par1Tessellator, float par2, float tx, float ty, int face, float[][] uv) {
        Vec3 vec3 = this.field_78239_a[1].vector3D.subtract(this.field_78239_a[0].vector3D);
        Vec3 vec31 = this.field_78239_a[1].vector3D.subtract(this.field_78239_a[2].vector3D);
        Vec3 vec32 = vec31.crossProduct(vec3).normalize();
        par1Tessellator.startDrawingQuads();
        if (this.bright) {
            RenderHelper.disableStandardItemLighting();
            par1Tessellator.setBrightness(224);
        }
        if (this.invertNormal) {
            par1Tessellator.setNormal(-((float)vec32.xCoord), -((float)vec32.yCoord), -((float)vec32.zCoord));
        } else {
            par1Tessellator.setNormal((float)vec32.xCoord, (float)vec32.yCoord, (float)vec32.zCoord);
        }
        PositionTextureVertex positiontexturevertex = this.field_78239_a[1];
        par1Tessellator.addVertexWithUV((double)((float)positiontexturevertex.vector3D.xCoord * par2), (double)((float)positiontexturevertex.vector3D.yCoord * par2), (double)((float)positiontexturevertex.vector3D.zCoord * par2), (double)uv[this.getVertForFace(face, 1)][0], (double)uv[this.getVertForFace(face, 1)][1]);
        PositionTextureVertex positiontexturevertex2 = this.field_78239_a[2];
        par1Tessellator.addVertexWithUV((double)((float)positiontexturevertex2.vector3D.xCoord * par2), (double)((float)positiontexturevertex2.vector3D.yCoord * par2), (double)((float)positiontexturevertex2.vector3D.zCoord * par2), (double)uv[this.getVertForFace(face, 2)][0], (double)uv[this.getVertForFace(face, 2)][1]);
        PositionTextureVertex positiontexturevertex3 = this.field_78239_a[3];
        par1Tessellator.addVertexWithUV((double)((float)positiontexturevertex3.vector3D.xCoord * par2), (double)((float)positiontexturevertex3.vector3D.yCoord * par2), (double)((float)positiontexturevertex3.vector3D.zCoord * par2), (double)uv[this.getVertForFace(face, 3)][0], (double)uv[this.getVertForFace(face, 3)][1]);
        PositionTextureVertex positiontexturevertex4 = this.field_78239_a[0];
        par1Tessellator.addVertexWithUV((double)((float)positiontexturevertex4.vector3D.xCoord * par2), (double)((float)positiontexturevertex4.vector3D.yCoord * par2), (double)((float)positiontexturevertex4.vector3D.zCoord * par2), (double)uv[this.getVertForFace(face, 0)][0], (double)uv[this.getVertForFace(face, 0)][1]);
        par1Tessellator.draw();
    }

    public int getVertForFace(int face, int vert) {
        return face == 4 ? (vert == 0 ? 6 : (vert == 1 ? 7 : (vert == 2 ? 5 : 4))) : 0;
    }

    public void drawBlock(Tessellator par1Tessellator, float par2) {
        par1Tessellator.startDrawingQuads();
        Vec3 vec3 = this.field_78239_a[1].vector3D.subtract(this.field_78239_a[0].vector3D);
        Vec3 vec31 = this.field_78239_a[1].vector3D.subtract(this.field_78239_a[2].vector3D);
        Vec3 vec32 = vec31.crossProduct(vec3).normalize();
        if (this.invertNormal) {
            par1Tessellator.setNormal(-((float)vec32.xCoord), -((float)vec32.yCoord), -((float)vec32.zCoord));
        } else {
            par1Tessellator.setNormal((float)vec32.xCoord, (float)vec32.yCoord, (float)vec32.zCoord);
        }
        for (int i = 0; i < 4; ++i) {
            PositionTextureVertex positiontexturevertex = this.field_78239_a[i];
            par1Tessellator.addVertexWithUV((double)((float)positiontexturevertex.vector3D.xCoord * par2), (double)((float)positiontexturevertex.vector3D.yCoord * par2), (double)((float)positiontexturevertex.vector3D.zCoord * par2), (double)positiontexturevertex.texturePositionX, (double)positiontexturevertex.texturePositionY);
        }
        par1Tessellator.draw();
    }
}
