package com.InfinityRaider.elemancy.renderer;

import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.utility.Vector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderBeam {
    private static final ResourceLocation textureIn = new ResourceLocation("elemancy", "textures/magic/beamInside.png");
    private static final ResourceLocation textureOut = new ResourceLocation("elemancy", "textures/magic/beamOutside.png");

    public static final RenderBeam instance = new RenderBeam();

    private RenderBeam() {}

    public void doRender(Element element1, Element element2, Vector source, Vector target) {
        GL11.glPushMatrix();

        rotateToLocation(source, target, false);

        GL11.glRotatef(RenderManager.instance.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(RenderManager.instance.playerViewX, 1F, 0F, 0F);

        setColor(element1);
        Minecraft.getMinecraft().renderEngine.bindTexture(textureIn);
        renderBeam(target, source);

        setColor(element2);
        Minecraft.getMinecraft().renderEngine.bindTexture(textureOut);
        renderBeam(target, source);

        GL11.glRotatef(-RenderManager.instance.playerViewX, 1F, 0F, 0F);
        GL11.glRotatef(-RenderManager.instance.playerViewY, 0.0F, 1.0F, 0.0F);

        rotateToLocation(source, target, true);

        GL11.glPopMatrix();
    }

    private void rotateToLocation(Vector v1, Vector v2, boolean inverted) {
        double dx = v2.getX() - v1.getX();
        double dy = v2.getY() - v1.getY();
        double dz = v2.getZ() - v1.getZ();
        double theta = Math.toDegrees(Math.atan2(dz, dx));
        double phi = Math.toDegrees(Math.atan2(dy, dx));

        if(inverted) {
            GL11.glRotated(-phi, 0, 0, 1);
            GL11.glRotated(-theta, 0, 1, 0);
            GL11.glTranslated(-v1.getX(), -v1.getY(), -v1.getZ());
        }else{
            GL11.glTranslated(v1.getX(), v1.getY(), v1.getZ());
            GL11.glRotated(theta, 0, 1, 0);
            GL11.glRotated(phi, 0, 0, 1);
        }
    }

    private void setColor(Element element) {
        float[] colors = element.getColorModifier();
        GL11.glColor3f(colors[0], colors[1], colors[2]);
        GL11.glEnable(GL11.GL_BLEND);
    }

    private void renderBeam(Vector target, Vector source) {
        double d = target.substract(source).norm();
        Tessellator tessellator = Tessellator.instance;

        tessellator.startDrawingQuads();

        tessellator.addVertexWithUV(0, -0.1, 0, 0, 1);
        tessellator.addVertexWithUV(d, -0.1, 0, 1, 1);
        tessellator.addVertexWithUV(d, 0.1, 0, 1, 0);
        tessellator.addVertexWithUV(0, 0.1, 0 , 0, 0);

        tessellator.addVertexWithUV(0, 0.1, 0 , 0, 0);
        tessellator.addVertexWithUV(d, 0.1, 0, 1, 0);
        tessellator.addVertexWithUV(d, -0.1, 0, 1, 1);
        tessellator.addVertexWithUV(0, -0.1, 0, 0, 1);

        tessellator.draw();
    }
}
