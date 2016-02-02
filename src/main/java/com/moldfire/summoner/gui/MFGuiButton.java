package com.moldfire.summoner.gui;

import com.moldfire.summoner.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MFGuiButton extends GuiButton
{
	protected static final ResourceLocation testButtonTextures = new ResourceLocation(Reference.MOD_ID+":"+ "textures/guis/widgets.png");
	boolean hasBackground;
	
	public MFGuiButton(int buttonId, int x, int y, String buttonText, boolean hasBackground) 
	{
		super(buttonId, x, y, buttonText);
		this.hasBackground = hasBackground;
	}
	
	 /**
     * Draws this button to the screen.
     */
	@Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY)
    {
        if (this.visible)
        {
        	FontRenderer fontrenderer = mc.fontRendererObj;
        	if(hasBackground)
        	{
	            mc.getTextureManager().bindTexture(testButtonTextures);
	            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
	            int k = this.getHoverState(this.hovered);
	            GlStateManager.enableBlend();
	            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
	            GlStateManager.blendFunc(770, 771);
	            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + k * 20, this.width / 2, this.height);
	            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + k * 20, this.width / 2, this.height);
	            this.mouseDragged(mc, mouseX, mouseY);
	            int l = 14737632;
	
	            if (packedFGColour != 0)
	            {
	                l = packedFGColour;
	            }
	            else if (!this.enabled)
	            {
	                l = 10526880;
	            }
	            else if (this.hovered)
	            {
	                l = 16777120;
	            }
	
	            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
        	}
        	else
        	{
 	            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
 	            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + fontrenderer.getStringWidth(this.displayString) && mouseY < this.yPosition + fontrenderer.FONT_HEIGHT;
 	            int k = this.getHoverState(this.hovered);
 	            GlStateManager.enableBlend();
 	            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
 	            GlStateManager.blendFunc(770, 771);
 	            this.mouseDragged(mc, mouseX, mouseY);
 	            int l = 14737632;
 	
 	            if (packedFGColour != 0)
 	            {
 	                l = packedFGColour;
 	            }
 	            else if (!this.enabled)
 	            {
 	                l = 10526880;
 	            }
 	            else if (this.hovered)
 	            {
 	                l = 16777120;
 	            }
 	            
        		this.drawString(fontrenderer, this.displayString, this.xPosition, this.yPosition, l);
        	}
        }
    }

}
