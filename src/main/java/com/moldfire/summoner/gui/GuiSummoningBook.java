package com.moldfire.summoner.gui;

import com.moldfire.summoner.reference.Reference;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiSummoningBook extends GuiScreen
{
	private ResourceLocation backgroundImage = new ResourceLocation(Reference.MOD_ID+":"+ "textures/guis/guiSummoningBook.png");
	private static final String text1 = "A B C D ";
	int xSize, ySize;
	
	@Override
	public void initGui()
	{
		xSize = 256;
		ySize = 256;
		
		FontRenderer fontrenderer = mc.fontRendererObj;
		this.drawString(fontrenderer, text1, this.width-xSize, this.height-ySize, 1);
		this.buttonList.add(new MFGuiButton(1, fontrenderer.getStringWidth(text1), this.height / 2, "e f g", false));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float renderPartialTicks)
	{
		this.mc.getTextureManager().bindTexture(backgroundImage);
		int x = (this.width - xSize)/2;
		int y = (this.height - ySize)/2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		super.drawScreen(mouseX, mouseY, renderPartialTicks);
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
