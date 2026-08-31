package rationcraft.renders;

import java.io.BufferedReader;
import java.io.IOException;
import net.minecraft.client.model.ModelBase;
import rationcraft.models.BeardieModelRenderer;
import rationcraft.models.ModelBeardieBase;

public class ModelReaderF2 {
    public static ModelBeardieBase readModel(ModelBeardieBase model, BufferedReader reader) {
        int i;
        String line = "";
        BeardieModelRenderer element = null;
        float oX = 0.0f;
        float oY = 0.0f;
        float oZ = 0.0f;
        float sX = 0.0f;
        float sY = 0.0f;
        float sZ = 0.0f;
        float[][] vertices = new float[8][3];
        try {
            while ((line = reader.readLine()) != null) {
                String h;
                String w;
                String Rot;
                double z;
                double y;
                String pY;
                String rp;
                String z2;
                String y2;
                String x;
                int indOff;
                String pos;
                if ((line = line.trim()).startsWith("RE")) {
                    pos = ModelReaderF2.substring(line, line.indexOf("RE") + 2);
                    pos = pos.trim();
                    model.remove.add(ModelReaderF2.substring(pos, 0));
                }
                if (line.startsWith("TO")) {
                    pos = ModelReaderF2.substring(line, line.indexOf("TO") + 2);
                    pos = pos.trim();
                    indOff = 0;
                    x = ModelReaderF2.substring(pos, indOff, pos.indexOf(",", indOff + 1));
                    x = x.trim();
                    model.tpOffX = (float)Double.parseDouble(x);
                    indOff = pos.indexOf(",", indOff + 1);
                    y2 = ModelReaderF2.substring(pos, indOff + 1, pos.indexOf(",", indOff + 1));
                    y2 = y2.trim();
                    model.tpOffY = (float)Double.parseDouble(y2);
                    indOff = pos.indexOf(",", indOff + 1);
                    z2 = ModelReaderF2.substring(pos, indOff + 1);
                    z2 = z2.trim();
                    model.tpOffZ = (float)Double.parseDouble(z2);
                }
                if (line.startsWith("CO")) {
                    pos = ModelReaderF2.substring(line, line.indexOf("CO") + 2);
                    pos = pos.trim();
                    indOff = 0;
                    x = ModelReaderF2.substring(pos, indOff, pos.indexOf(",", indOff + 1));
                    x = x.trim();
                    model.scbX = (float)Double.parseDouble(x);
                    indOff = pos.indexOf(",", indOff + 1);
                    y2 = ModelReaderF2.substring(pos, indOff + 1, pos.indexOf(",", indOff + 1));
                    y2 = y2.trim();
                    model.scbY = (float)Double.parseDouble(y2);
                    indOff = pos.indexOf(",", indOff + 1);
                    z2 = ModelReaderF2.substring(pos, indOff + 1);
                    z2 = z2.trim();
                    model.scbZ = (float)Double.parseDouble(z2);
                }
                if (line.startsWith("MO")) {
                    pos = ModelReaderF2.substring(line, line.indexOf("MO") + 2);
                    pos = pos.trim();
                    indOff = 0;
                    x = ModelReaderF2.substring(pos, indOff, pos.indexOf(",", indOff + 1));
                    x = x.trim();
                    model.mOffX = (float)Double.parseDouble(x);
                    indOff = pos.indexOf(",", indOff + 1);
                    y2 = ModelReaderF2.substring(pos, indOff + 1, pos.indexOf(",", indOff + 1));
                    y2 = y2.trim();
                    model.mOffY = (float)Double.parseDouble(y2);
                    indOff = pos.indexOf(",", indOff + 1);
                    z2 = ModelReaderF2.substring(pos, indOff + 1);
                    z2 = z2.trim();
                    model.mOffZ = (float)Double.parseDouble(z2);
                }
                if (line.startsWith("WO")) {
                    pos = ModelReaderF2.substring(line, line.indexOf("WO") + 2);
                    pos = pos.trim();
                    indOff = 0;
                    x = ModelReaderF2.substring(pos, indOff, pos.indexOf(",", indOff + 1));
                    x = x.trim();
                    model.whOffX = (float)Double.parseDouble(x) * 0.0625f;
                    indOff = pos.indexOf(",", indOff + 1);
                    y2 = ModelReaderF2.substring(pos, indOff + 1, pos.indexOf(",", indOff + 1));
                    y2 = y2.trim();
                    model.whOffY = (float)Double.parseDouble(y2) * 0.0625f;
                    indOff = pos.indexOf(",", indOff + 1);
                    z2 = ModelReaderF2.substring(pos, indOff + 1);
                    z2 = z2.trim();
                    model.whOffZ = (float)Double.parseDouble(z2) * 0.0625f;
                }
                if (line.startsWith("MGO")) {
                    pos = ModelReaderF2.substring(line, line.indexOf("MGO") + 3);
                    pos = pos.trim();
                    indOff = 0;
                    x = ModelReaderF2.substring(pos, indOff, pos.indexOf(",", indOff + 1));
                    x = x.trim();
                    model.mgOffX = (float)Double.parseDouble(x);
                    indOff = pos.indexOf(",", indOff + 1);
                    y2 = ModelReaderF2.substring(pos, indOff + 1, pos.indexOf(",", indOff + 1));
                    y2 = y2.trim();
                    model.mgOffY = (float)Double.parseDouble(y2);
                    indOff = pos.indexOf(",", indOff + 1);
                    z2 = ModelReaderF2.substring(pos, indOff + 1);
                    z2 = z2.trim();
                    model.mgOffZ = (float)Double.parseDouble(z2);
                }
                if (line.startsWith("SP")) {
                    pos = ModelReaderF2.substring(line, line.indexOf("SP") + 2);
                    pos = pos.trim();
                    indOff = 0;
                    x = ModelReaderF2.substring(pos, indOff, pos.indexOf(",", indOff + 1));
                    x = x.trim();
                    model.sPosX = (float)Double.parseDouble(x);
                    indOff = pos.indexOf(",", indOff + 1);
                    y2 = ModelReaderF2.substring(pos, indOff + 1, pos.indexOf(",", indOff + 1));
                    y2 = y2.trim();
                    model.sPosY = (float)Double.parseDouble(y2);
                    indOff = pos.indexOf(",", indOff + 1);
                    z2 = ModelReaderF2.substring(pos, indOff + 1);
                    z2 = z2.trim();
                    model.sPosZ = (float)Double.parseDouble(z2);
                }
                if (line.startsWith("FP")) {
                    pos = ModelReaderF2.substring(line, line.indexOf("FP") + 2);
                    pos = pos.trim();
                    indOff = 0;
                    x = ModelReaderF2.substring(pos, indOff, pos.indexOf(",", indOff + 1));
                    x = x.trim();
                    model.flamePosX = (float)Double.parseDouble(x);
                    indOff = pos.indexOf(",", indOff + 1);
                    y2 = ModelReaderF2.substring(pos, indOff + 1, pos.indexOf(",", indOff + 1));
                    y2 = y2.trim();
                    model.flamePosY = (float)Double.parseDouble(y2);
                    indOff = pos.indexOf(",", indOff + 1);
                    z2 = ModelReaderF2.substring(pos, indOff + 1);
                    z2 = z2.trim();
                    model.flamePosZ = (float)Double.parseDouble(z2);
                }
                if (line.startsWith("LP")) {
                    rp = ModelReaderF2.substring(line, line.indexOf("LP") + 2);
                    String pX = ModelReaderF2.substring(rp, 0, rp.indexOf(","));
                    double x2 = Double.parseDouble(pX);
                    rp = ModelReaderF2.substring(rp, rp.indexOf(",") + 1);
                    pY = ModelReaderF2.substring(rp, 0, rp.indexOf(","));
                    y = Double.parseDouble(pY);
                    rp = ModelReaderF2.substring(rp, rp.indexOf(",") + 1);
                    z = Double.parseDouble(rp);
                    model.lhPosX = (float)x2;
                    model.lhPosY = (float)y;
                    model.lhPosZ = (float)z;
                }
                if (line.startsWith("LR")) {
                    Rot = ModelReaderF2.substring(line, line.indexOf("LR") + 2);
                    Rot = Rot.trim();
                    int indOff2 = 0;
                    String x3 = ModelReaderF2.substring(Rot, indOff2, Rot.indexOf(",", indOff2 + 1));
                    x3 = x3.trim();
                    model.lhRotX = (float)Double.parseDouble(x3);
                    indOff2 = Rot.indexOf(",", indOff2 + 1);
                    y2 = ModelReaderF2.substring(Rot, indOff2 + 1, Rot.indexOf(",", indOff2 + 1));
                    y2 = y2.trim();
                    model.lhRotY = (float)Double.parseDouble(y2);
                    indOff2 = Rot.indexOf(",", indOff2 + 1);
                    z2 = ModelReaderF2.substring(Rot, indOff2 + 1);
                    z2 = z2.trim();
                    model.lhRotZ = (float)Double.parseDouble(z2);
                }
                if (line.startsWith("RP")) {
                    rp = ModelReaderF2.substring(line, line.indexOf("RP") + 2);
                    String pX = ModelReaderF2.substring(rp, 0, rp.indexOf(","));
                    double x4 = Double.parseDouble(pX);
                    rp = ModelReaderF2.substring(rp, rp.indexOf(",") + 1);
                    pY = ModelReaderF2.substring(rp, 0, rp.indexOf(","));
                    y = Double.parseDouble(pY);
                    rp = ModelReaderF2.substring(rp, rp.indexOf(",") + 1);
                    z = Double.parseDouble(rp);
                    model.rhPosX = (float)x4;
                    model.rhPosY = (float)y;
                    model.rhPosZ = (float)z;
                }
                if (line.startsWith("RR")) {
                    Rot = ModelReaderF2.substring(line, line.indexOf("RR") + 2);
                    Rot = Rot.trim();
                    int indOff3 = 0;
                    String x5 = ModelReaderF2.substring(Rot, indOff3, Rot.indexOf(",", indOff3 + 1));
                    x5 = x5.trim();
                    model.rhRotX = (float)Double.parseDouble(x5);
                    indOff3 = Rot.indexOf(",", indOff3 + 1);
                    y2 = ModelReaderF2.substring(Rot, indOff3 + 1, Rot.indexOf(",", indOff3 + 1));
                    y2 = y2.trim();
                    model.rhRotY = (float)Double.parseDouble(y2);
                    indOff3 = Rot.indexOf(",", indOff3 + 1);
                    z2 = ModelReaderF2.substring(Rot, indOff3 + 1);
                    z2 = z2.trim();
                    model.rhRotZ = (float)Double.parseDouble(z2);
                }
                if (line.startsWith("SC")) {
                    String scale = ModelReaderF2.substring(line, line.indexOf("SC") + 2);
                    scale = scale.trim();
                    model.scale = (float)Double.parseDouble(scale);
                }
                if (line.startsWith("TS")) {
                    String tpscale = ModelReaderF2.substring(line, line.indexOf("TS") + 2);
                    tpscale = tpscale.trim();
                    model.tpscale = (float)Double.parseDouble(tpscale);
                }
                if (line.startsWith("EP")) {
                    pos = ModelReaderF2.substring(line, line.indexOf("EP") + 2);
                    pos = pos.trim();
                    int indOff4 = 0;
                    String x6 = ModelReaderF2.substring(pos, indOff4, pos.indexOf(",", indOff4 + 1));
                    x6 = x6.trim();
                    model.ePosX = (float)Double.parseDouble(x6);
                    indOff4 = pos.indexOf(",", indOff4 + 1);
                    y2 = ModelReaderF2.substring(pos, indOff4 + 1, pos.indexOf(",", indOff4 + 1));
                    y2 = y2.trim();
                    model.ePosY = (float)Double.parseDouble(y2);
                    indOff4 = pos.indexOf(",", indOff4 + 1);
                    z2 = ModelReaderF2.substring(pos, indOff4 + 1);
                    z2 = z2.trim();
                    model.ePosZ = (float)Double.parseDouble(z2);
                }
                if (line.startsWith("TW")) {
                    w = ModelReaderF2.substring(line, line.indexOf("TW") + 2);
                    w = w.trim();
                    model.textureWidth = Integer.parseInt(w);
                }
                if (line.startsWith("TH")) {
                    h = ModelReaderF2.substring(line, line.indexOf("TH") + 2);
                    h = h.trim();
                    model.textureHeight = Integer.parseInt(h);
                }
                if (line.startsWith("B ")) {
                    if (element != null) {
                        element.addShape(oX, oY, oZ, vertices, sX, sY, sZ);
                        model.pieces.add(element);
                        oX = 0.0f;
                        oY = 0.0f;
                        oZ = 0.0f;
                        sX = 0.0f;
                        sY = 0.0f;
                        sZ = 0.0f;
                        vertices = new float[8][3];
                    }
                    String name = ModelReaderF2.substring(line, line.indexOf("B ") + 2);
                    name = name.trim();
                    element = new BeardieModelRenderer((ModelBase)model, name);
                }
                if (element == null) continue;
                if (line.startsWith("TX")) {
                    h = ModelReaderF2.substring(line, line.indexOf("TX") + 2);
                    h = h.trim();
                    element.textureSizeX = (int)Double.parseDouble(h);
                }
                if (line.startsWith("TY")) {
                    w = ModelReaderF2.substring(line, line.indexOf("TY") + 2);
                    w = w.trim();
                    element.textureSizeY = (int)Double.parseDouble(w);
                }
                if (line.startsWith("AT")) {
                    w = ModelReaderF2.substring(line, line.indexOf("AT") + 2);
                    w = w.trim();
                    element.ammoType = (int)Double.parseDouble(w);
                }
                if (line.startsWith("T ")) {
                    rp = ModelReaderF2.substring(line, line.indexOf("T ") + 2);
                    String pX = ModelReaderF2.substring(rp, 0, rp.indexOf(","));
                    double x7 = Double.parseDouble(pX);
                    rp = ModelReaderF2.substring(rp, rp.indexOf(",") + 1);
                    double z3 = Double.parseDouble(rp);
                    element.field_78803_o = (float)x7;
                    element.field_78813_p = (float)z3;
                }
                if (line.startsWith("S ")) {
                    rp = ModelReaderF2.substring(line, line.indexOf("S ") + 2);
                    String pX = ModelReaderF2.substring(rp, 0, rp.indexOf(","));
                    double x8 = Double.parseDouble(pX);
                    rp = ModelReaderF2.substring(rp, rp.indexOf(",") + 1);
                    String pY2 = ModelReaderF2.substring(rp, 0, rp.indexOf(","));
                    y = Double.parseDouble(pY2);
                    rp = ModelReaderF2.substring(rp, rp.indexOf(",") + 1);
                    z = Double.parseDouble(rp);
                    sX = (float)x8;
                    sY = (float)y;
                    sZ = (float)z;
                }
                if (line.startsWith("V ")) {
                    String verts = ModelReaderF2.substring(line, line.indexOf("V ") + 2).trim();
                    for (int i2 = 0; i2 < vertices.length; ++i2) {
                        for (int i22 = 0; i22 < vertices[i2].length; ++i22) {
                            if (verts.contains(",")) {
                                vertices[i2][i22] = (float)Double.parseDouble(ModelReaderF2.substring(verts, 0, verts.indexOf(",")));
                                verts = ModelReaderF2.substring(verts, verts.indexOf(",") + 1);
                                continue;
                            }
                            vertices[i2][i22] = (float)Double.parseDouble(verts);
                        }
                    }
                }
                if (line.startsWith("O ")) {
                    rp = ModelReaderF2.substring(line, line.indexOf("O ") + 2);
                    String pX = ModelReaderF2.substring(rp, 0, rp.indexOf(","));
                    double x9 = Double.parseDouble(pX);
                    rp = ModelReaderF2.substring(rp, rp.indexOf(",") + 1);
                    String pY3 = ModelReaderF2.substring(rp, 0, rp.indexOf(","));
                    y = Double.parseDouble(pY3);
                    rp = ModelReaderF2.substring(rp, rp.indexOf(",") + 1);
                    z = Double.parseDouble(rp);
                    oX = (float)x9;
                    oY = (float)y;
                    oZ = (float)z;
                }
                if (line.startsWith("P ")) {
                    rp = ModelReaderF2.substring(line, line.indexOf("P ") + 2);
                    String pX = ModelReaderF2.substring(rp, 0, rp.indexOf(","));
                    double x10 = Double.parseDouble(pX);
                    rp = ModelReaderF2.substring(rp, rp.indexOf(",") + 1);
                    String pY4 = ModelReaderF2.substring(rp, 0, rp.indexOf(","));
                    y = Double.parseDouble(pY4);
                    rp = ModelReaderF2.substring(rp, rp.indexOf(",") + 1);
                    z = Double.parseDouble(rp);
                    element.func_78793_a((float)x10, (float)y, (float)z);
                }
                if (line.startsWith("R ")) {
                    rp = ModelReaderF2.substring(line, line.indexOf("R ") + 2);
                    String pX = ModelReaderF2.substring(rp, 0, rp.indexOf(","));
                    double x11 = Double.parseDouble(pX);
                    rp = ModelReaderF2.substring(rp, rp.indexOf(",") + 1);
                    String pY5 = ModelReaderF2.substring(rp, 0, rp.indexOf(","));
                    y = Double.parseDouble(pY5);
                    rp = ModelReaderF2.substring(rp, rp.indexOf(",") + 1);
                    z = Double.parseDouble(rp);
                    element.setRotation((float)x11, (float)y, (float)z);
                }
                if (!line.startsWith("AC")) continue;
                String c = ModelReaderF2.substring(line, line.indexOf("AC") + 2).trim();
                BeardieModelRenderer cEl = null;
                c = c.trim();
                for (int i3 = 0; i3 < model.pieces.size(); ++i3) {
                    BeardieModelRenderer el = model.pieces.get(i3);
                    if (!el.field_78802_n.equalsIgnoreCase(c)) continue;
                    el.isChild = true;
                    cEl = el;
                    model.pieces.set(i3, el);
                }
                if (cEl == null) continue;
                element.addChild(cEl);
                cEl.isChild = true;
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        if (element != null && !model.pieces.contains((Object)element) && !element.isChild) {
            element.addShape(oX, oY, oZ, vertices, sX, sY, sZ);
            model.pieces.add(element);
        }
        BeardieModelRenderer parentElement = new BeardieModelRenderer((ModelBase)model, "mainElements");
        model.pieces.add(parentElement);
        for (i = 0; i < model.pieces.size(); ++i) {
            BeardieModelRenderer el = model.pieces.get(i);
            if (el.isChild) {
                model.pieces.remove(i);
                --i;
                continue;
            }
            if (el.field_78802_n.contains("BeltPoint") || el.field_78802_n.contains("ammoCount") || el.field_78802_n.contains("sclip") || el.field_78802_n.contains("pants") || el.field_78802_n.contains("scopeOverlay") || el.field_78802_n.contains("scopeGlass") || el.field_78802_n.contains("cylandir") || el.field_78802_n.contains("Mag") || el.field_78802_n.contains("remove") || el.ammoType >= 0) {
                if (!el.field_78802_n.contains("remove")) continue;
                el.field_78802_n = el.field_78802_n.replace("remove", "");
                model.pieces.set(i, el);
                continue;
            }
            if (el.childModels != null && el.childModels.size() != 0) continue;
            parentElement.addChild(el);
            el.isChild = true;
            model.pieces.set(i, el);
        }
        for (i = 0; i < model.pieces.size(); ++i) {
            BeardieModelRenderer el = model.pieces.get(i);
            if (!el.isChild) continue;
            model.pieces.remove(i);
            --i;
        }
        return model;
    }

    public static String substring(String s, int startPos, int endPos) {
        return s.substring(startPos, endPos);
    }

    public static String substring(String s, int startPos) {
        return s.substring(startPos);
    }
}
