package com.flashoverride.ambientcreatures.core;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

import com.flashoverride.ambientcreatures.client.renderer.entity.RenderButterfly;
import com.flashoverride.ambientcreatures.client.renderer.entity.RenderMoth;
import com.flashoverride.ambientcreatures.entity.passive.EntityButterfly;
import com.flashoverride.ambientcreatures.entity.passive.EntityMoth;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModClientProxy extends ModCommonProxy
{
	@Override
	public String getCurrentLanguage()
	{
		return Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode();
	}

	@Override
	public World getCurrentWorld()
	{
		return Minecraft.getMinecraft().theWorld;
	}

	@Override
	public boolean getGraphicsLevel()
	{
		Minecraft.getMinecraft();
		return Minecraft.isFancyGraphicsEnabled();
	}

	@Override
	public File getMinecraftDirectory()
	{
		return Minecraft.getMinecraft().mcDataDir;
	}
	
	@Override
	public void hideNEIItems()
	{
		if (Loader.isModLoaded(ModDetails.MODID_NEI))
		{
		}
	}

	@Override
	public boolean isRemote()
	{
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void loadOptions()
	{
		//Load our settings from the server
		ModOptions.loadSettings();
	}

	@Override
	public void registerGuiHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(com.flashoverride.ambientcreatures.AmbientCreatures.instance, new com.flashoverride.ambientcreatures.handlers.client.GuiHandler());
	}

	@Override
	public void registerHandlers()
	{
	}

	@Override
	public void registerKeys()
	{
		uploadKeyBindingsToGame();
	}

	@Override
	public void registerKeyBindingHandler()
	{
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerRenderInformation()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityButterfly.class, new RenderButterfly());
		RenderingRegistry.registerEntityRenderingHandler(EntityMoth.class, new RenderMoth());
	}
	
	@Override
	public void registerTileEntities(boolean flag)
	{
		super.registerTileEntities(false);
		
		// TESR registers
	}

	@Override
	public void uploadKeyBindingsToGame()
	{
	}
}
