package com.moldfire.summoner.gui;

import java.awt.Color;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import com.moldfire.summoner.container.ContainerAlter;
import com.moldfire.summoner.reference.Reference;
import com.moldfire.summoner.tileentity.TileEntityCoreStabiliser;

public class GuiAlter extends GuiContainer
{
	private int x, y, z;
	private EntityPlayer player;
	private World world;
	private int xSize, ySize;
	private ResourceLocation backgroundImage = new ResourceLocation(Reference.MOD_ID+":"+ "textures/guis/guiAlter.png");
	private TileEntityCoreStabiliser tileEntityAlter;
 
	public GuiAlter(InventoryPlayer invPlayer, TileEntityCoreStabiliser tile)
	{
		super(new ContainerAlter(invPlayer, tile));
		tileEntityAlter = tile;
		/*this.x = x;
		this.y = y;
		this.z = z;
		
		this.player = playerIn;
		this.world = worldIn;*/
		
		xSize = 176;
		ySize = 132;
	}
	
/*	@Override
	public void drawScreen(int mouseX, int mouseY, float renderPartialTicks)
	{
		this.mc.getTextureManager().bindTexture(backgroundImage);
		int x = (this.width - xSize)/2;
		int y = (this.height - ySize)/2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}*/

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		this.mc.getTextureManager().bindTexture(backgroundImage);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		final int LABEL_XPOS = 5;
		final int LABEL_YPOS = 5;
		//fontRendererObj.drawString(tileEntityAlter.getDisplayName().getUnformattedText(), LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());
	}
}
