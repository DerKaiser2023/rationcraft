package rationcraft.models;

import java.util.ArrayList;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelBeardieBase extends ModelBase {
    public ArrayList<BeardieModelRenderer> pieces = new ArrayList<BeardieModelRenderer>();
    public ArrayList<String> remove = new ArrayList<String>();
    public float sPosX;
    public float sPosY;
    public float sPosZ;
    public float ePosX;
    public float ePosY;
    public float ePosZ;
    public float scbX;
    public float scbY;
    public float scbZ;
    public float lhPosX = 6.5f;
    public float lhPosY = 7.2f;
    public float lhPosZ = 3.5f;
    public float rhPosX = -9.0f;
    public float rhPosY = 0.72f;
    public float rhPosZ = -2.0f;
    public float rhRotX = 0.0f;
    public float rhRotY = 0.0f;
    public float rhRotZ = 0.0f;
    public float lhRotX = 0.0f;
    public float lhRotY = 0.0f;
    public float lhRotZ = 0.0f;
    public float flamePosX = 20.0f;
    public float flamePosY = -4.0f;
    public float flamePosZ = 0.0f;
    public float mOffX = 0.0f;
    public float mOffY = 0.0f;
    public float mOffZ = 0.0f;
    public float whOffX = 0.0f;
    public float whOffY = 0.0f;
    public float whOffZ = 0.0f;
    public float tpOffX = 0.0f;
    public float tpOffY = 0.0f;
    public float tpOffZ = 0.0f;
    public float mgOffX = 0.0f;
    public float mgOffY = 0.0f;
    public float mgOffZ = 0.0f;
    public boolean integralRenderList = true;
    public float scale = 1.0f;
    public float tpscale = 0.0f;
    public String path;

    public ModelBeardieBase() {
    }

    public void func_78088_a(Entity p, float p_78088_2_, float p_78088_3_, float par4, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        for (int i = 0; i < this.pieces.size(); ++i) {
            BeardieModelRenderer piece = this.pieces.get(i);
            if (piece.field_78802_n.contains("ammoCount") || piece.field_78802_n.contains("scopeGlass") && par4 == 0.0f || piece.field_78802_n.contains("scopeOverlay") || piece.field_78802_n.contains("crateInside") || piece.field_78802_n.contains("BeltPoint") || piece.field_78802_n.contains("decal") || piece.field_78802_n.contains("jeepsymbol")) continue;
            piece.render(p_78088_7_, true);
        }
    }
}
