package rationcraft.renders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResource;
import net.minecraft.util.ResourceLocation;
import rationcraft.models.BeardieModelRenderer;
import rationcraft.models.ModelBeardieBase;

public class ModelReader {
    public static ModelBeardieBase readModel(ResourceLocation rl) {
        ModelBeardieBase model = new ModelBeardieBase();
        IResource res = null;
        model.path = rl.getResourcePath();
        try {
            res = Minecraft.getMinecraft().getResourceManager().getResource(rl);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        InputStream stream = null;
        try {
            stream = res.getInputStream();
        }
        catch (Exception e) {
            System.out.println("FATAL ERROR: Model Loading Failed!!! File Path: " + rl.getResourcePath());
            return model;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line = "";
        BeardieModelRenderer e = null;
        try {
            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase("F 2")) {
                    return ModelReaderF2.readModel(model, reader);
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return model;
    }
}
