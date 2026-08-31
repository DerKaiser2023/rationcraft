package rationcraft.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.renderer.Tessellator;

public class BeardieModelBox {
    public boolean bright = false;
    private PositionTextureVertex[] vertexPositions;
    private BeardieTexturedQuad[] quadList;
    public final float posX1;
    public final float posY1;
    public final float posZ1;
    public final float posX2;
    public final float posY2;
    public float posZ2;
    public String field_78247_g;
    public float p2;
    public float p3;
    public float p4;
    public float p5;
    public float p6;
    public float p7;
    public float p8;
    public float p9;
    public float p10;
    float[][] vp = null;
    public BeardieModelRenderer model;

    public BeardieModelBox getCopy(ModelRenderer mr) {
        return this.vp != null ? new BeardieModelBox(mr, this.p2, this.p3, 0.0f, 0.0f, 0.0f, this.vp, this.p7, this.p8, this.p9, this.p10) : new BeardieModelBox(mr, this.p2, this.p3, this.p4, this.p5, this.p6, this.p7, this.p8, this.p9, this.p10);
    }

    public BeardieModelBox getMudCopy(ModelRenderer mr, float par2, float par3) {
        mr.textureWidth = 64.0f;
        mr.textureHeight = 32.0f;
        return this.vp != null ? new BeardieModelBox(mr, par2, par3, 0.0f, 0.0f, 0.0f, this.vp, this.p7, this.p8, this.p9, this.p10) : new BeardieModelBox(mr, par2, par3, this.p4, this.p5, this.p6, this.p7, this.p8, this.p9, this.p10);
    }

    public BeardieModelBox(ModelRenderer par1ModelRenderer, float par2, float par3, float par4, float par5, float par6, float par7, float par8, float par9, float par10) {
        this.model = (BeardieModelRenderer)par1ModelRenderer;
        this.p2 = par2;
        this.p3 = par3;
        this.p4 = par4;
        this.p5 = par5;
        this.p6 = par6;
        this.p7 = par7;
        this.p8 = par8;
        this.p9 = par9;
        this.p10 = par10;
        this.posX1 = par4;
        this.posY1 = par5;
        this.posZ1 = par6;
        this.posX2 = par4 + par7;
        this.posY2 = par5 + par8;
        this.posZ2 = par6 + par9;
        this.vertexPositions = new PositionTextureVertex[8];
        this.quadList = new BeardieTexturedQuad[6];
        float f4 = par4 + par7;
        float f5 = par5 + par8;
        float f6 = par6 + par9;
        par4 -= par10;
        par5 -= par10;
        par6 -= par10;
        f4 += par10;
        f5 += par10;
        f6 += par10;
        if (par1ModelRenderer.mirror) {
            float f7 = f4;
            f4 = par4;
            par4 = f7;
        }
        PositionTextureVertex positiontexturevertex = new PositionTextureVertex(par4, par5, par6, 0.0f, 0.0f);
        PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(f4, par5, par6, 0.0f, 8.0f);
        PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(f4, f5, par6, 8.0f, 8.0f);
        PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(par4, f5, par6, 8.0f, 0.0f);
        PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(par4, par5, f6, 0.0f, 0.0f);
        PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(f4, par5, f6, 0.0f, 8.0f);
        PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(f4, f5, f6, 8.0f, 8.0f);
        PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(par4, f5, f6, 8.0f, 0.0f);
        this.vertexPositions[0] = positiontexturevertex;
        this.vertexPositions[1] = positiontexturevertex1;
        this.vertexPositions[2] = positiontexturevertex2;
        this.vertexPositions[3] = positiontexturevertex3;
        this.vertexPositions[4] = positiontexturevertex4;
        this.vertexPositions[5] = positiontexturevertex5;
        this.vertexPositions[6] = positiontexturevertex6;
        this.vertexPositions[7] = positiontexturevertex7;
        this.quadList[0] = new BeardieTexturedQuad(new PositionTextureVertex[]{positiontexturevertex5, positiontexturevertex1, positiontexturevertex2, positiontexturevertex6}, this.p2 + par9 + par7, this.p3 + par9, this.p2 + par9 + par7 + par9, this.p3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[1] = new BeardieTexturedQuad(new PositionTextureVertex[]{positiontexturevertex, positiontexturevertex4, positiontexturevertex7, positiontexturevertex3}, this.p2, this.p3 + par9, this.p2 + par9, this.p3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[2] = new BeardieTexturedQuad(new PositionTextureVertex[]{positiontexturevertex5, positiontexturevertex4, positiontexturevertex, positiontexturevertex1}, this.p2 + par9, this.p3, this.p2 + par9 + par7, this.p3 + par9, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[3] = new BeardieTexturedQuad(new PositionTextureVertex[]{positiontexturevertex2, positiontexturevertex3, positiontexturevertex7, positiontexturevertex6}, this.p2 + par9 + par7, this.p3 + par9, this.p2 + par9 + par7 + par7, this.p3, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[4] = new BeardieTexturedQuad(new PositionTextureVertex[]{positiontexturevertex1, positiontexturevertex, positiontexturevertex3, positiontexturevertex2}, this.p2 + par9, this.p3 + par9, this.p2 + par9 + par7, this.p3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[5] = new BeardieTexturedQuad(new PositionTextureVertex[]{positiontexturevertex4, positiontexturevertex5, positiontexturevertex6, positiontexturevertex7}, this.p2 + par9 + par7 + par9, this.p3 + par9, this.p2 + par9 + par7 + par9 + par7, this.p3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        if (par1ModelRenderer.mirror) {
            for (int j1 = 0; j1 < this.quadList.length; ++j1) {
                this.quadList[j1].func_78235_a();
            }
        }
    }

    public BeardieModelBox(ModelRenderer par1ModelRenderer, float par2, float par3, float par4, float par5, float par6, float[][] vectorPos, float width, float height, float length, float par10) {
        this.model = (BeardieModelRenderer)par1ModelRenderer;
        this.p2 = par2;
        this.p3 = par3;
        this.p4 = par4;
        this.p5 = par5;
        this.p6 = par6;
        this.vp = vectorPos;
        this.p7 = width;
        this.p8 = height;
        this.p9 = length;
        this.p10 = par10;
        this.posX1 = par4 + vectorPos[7][0];
        this.posY1 = par5 + vectorPos[7][1];
        this.posZ1 = par6 + vectorPos[7][2];
        this.posX2 = par4 + vectorPos[0][0];
        this.posY2 = par5 + vectorPos[0][1];
        this.posZ2 = par6 + vectorPos[0][2];
        this.vertexPositions = new PositionTextureVertex[8];
        this.quadList = new BeardieTexturedQuad[6];
        par4 -= par10;
        par5 -= par10;
        par6 -= par10;
        if (par1ModelRenderer.mirror) {
        }
        float par7 = width;
        float par8 = height;
        float par9 = length;
        for (int i = 0; i < vectorPos.length; ++i) {
            float[] fArray = vectorPos[i];
            fArray[0] = fArray[0] + par4;
            float[] fArray2 = vectorPos[i];
            fArray2[1] = fArray2[1] + par5;
            float[] fArray3 = vectorPos[i];
            fArray3[2] = fArray3[2] + par6;
        }
        PositionTextureVertex positiontexturevertex = new PositionTextureVertex(vectorPos[7][0], vectorPos[7][1], vectorPos[7][2], 0.0f, 0.0f);
        PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(width + vectorPos[6][0], vectorPos[6][1], vectorPos[6][2], 0.0f, 8.0f);
        PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(width + vectorPos[4][0], height + vectorPos[4][1], vectorPos[4][2], 8.0f, 8.0f);
        PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(vectorPos[5][0], height + vectorPos[5][1], vectorPos[5][2], 8.0f, 0.0f);
        PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(vectorPos[3][0], vectorPos[3][1], length + vectorPos[3][2], 0.0f, 0.0f);
        PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(width + vectorPos[2][0], vectorPos[2][1], length + vectorPos[2][2], 0.0f, 8.0f);
        PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(width + vectorPos[0][0], height + vectorPos[0][1], length + vectorPos[0][2], 8.0f, 8.0f);
        PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(vectorPos[1][0], height + vectorPos[1][1], length + vectorPos[1][2], 8.0f, 0.0f);
        this.vertexPositions[0] = positiontexturevertex;
        this.vertexPositions[1] = positiontexturevertex1;
        this.vertexPositions[2] = positiontexturevertex2;
        this.vertexPositions[3] = positiontexturevertex3;
        this.vertexPositions[4] = positiontexturevertex4;
        this.vertexPositions[5] = positiontexturevertex5;
        this.vertexPositions[6] = positiontexturevertex6;
        this.vertexPositions[7] = positiontexturevertex7;
        this.quadList[0] = new BeardieTexturedQuad(new PositionTextureVertex[]{positiontexturevertex5, positiontexturevertex1, positiontexturevertex2, positiontexturevertex6}, this.p2 + par9 + par7, this.p3 + par9, this.p2 + par9 + par7 + par9, this.p3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[1] = new BeardieTexturedQuad(new PositionTextureVertex[]{positiontexturevertex, positiontexturevertex4, positiontexturevertex7, positiontexturevertex3}, this.p2, this.p3 + par9, this.p2 + par9, this.p3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[2] = new BeardieTexturedQuad(new PositionTextureVertex[]{positiontexturevertex5, positiontexturevertex4, positiontexturevertex, positiontexturevertex1}, this.p2 + par9, this.p3, this.p2 + par9 + par7, this.p3 + par9, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[3] = new BeardieTexturedQuad(new PositionTextureVertex[]{positiontexturevertex2, positiontexturevertex3, positiontexturevertex7, positiontexturevertex6}, this.p2 + par9 + par7, this.p3 + par9, this.p2 + par9 + par7 + par7, this.p3, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[4] = new BeardieTexturedQuad(new PositionTextureVertex[]{positiontexturevertex1, positiontexturevertex, positiontexturevertex3, positiontexturevertex2}, this.p2 + par9, this.p3 + par9, this.p2 + par9 + par7, this.p3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[5] = new BeardieTexturedQuad(new PositionTextureVertex[]{positiontexturevertex4, positiontexturevertex5, positiontexturevertex6, positiontexturevertex7}, this.p2 + par9 + par7 + par9, this.p3 + par9, this.p2 + par9 + par7 + par9 + par7, this.p3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        if (par1ModelRenderer.mirror) {
            for (int j1 = 0; j1 < this.quadList.length; ++j1) {
                this.quadList[j1].func_78235_a();
            }
        }
    }

    public void render(Tessellator par1Tessellator, float par2) {
        for (int i = 0; i < this.quadList.length; ++i) {
            this.quadList[i].bright = this.bright;
            this.quadList[i].model = this.model;
            this.quadList[i].func_78236_a(par1Tessellator, par2);
        }
    }

    public void renderTex(Tessellator par1Tessellator, float par2, float tx, float ty, float textureSizeX, float textureSizeY) {
        for (int i = 0; i < this.quadList.length; ++i) {
            this.quadList[i].bright = this.bright;
            this.quadList[i].model = this.model;
            this.quadList[i].drawTexture(par1Tessellator, par2, tx, ty, textureSizeX, textureSizeY);
        }
    }

    public void renderUV(Tessellator par1Tessellator, float par2, float tx, float ty, float[][] uv) {
        for (int i = 0; i < this.quadList.length; ++i) {
            this.quadList[i].bright = this.bright;
            this.quadList[i].model = this.model;
            this.quadList[i].drawTexture(par1Tessellator, par2, tx, ty, i, uv);
        }
    }

    public void renderBlock(Tessellator par1Tessellator, float par2) {
        for (int i = 0; i < this.quadList.length; ++i) {
            this.quadList[i].bright = this.bright;
            this.quadList[i].model = this.model;
            this.quadList[i].drawBlock(par1Tessellator, par2);
        }
    }

    public BeardieModelBox func_78244_a(String par1Str) {
        this.field_78247_g = par1Str;
        return this;
    }
}
