package net.tenrem.doorcloser;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class DoorCloserPlugin extends JavaPlugin 
{
	public final Map<String, Boolean> ToggledPlayers = new HashMap<String, Boolean>();

	@Override
	public void onEnable() 
	{	
		Settings.ThisPlugin = this;
		
		Settings.ReadConfigValues();
	
		// set up commands
		RegisterCommands();
		
		// register event listener
		RegisterEvents();
	}

	
	private void RegisterEvents()
	{
		getServer().getPluginManager().registerEvents(new InteractListener(this), this);
		
	}
	
	private void RegisterCommands()
	{
		getCommand("dcreload").setExecutor(new CommandReload( this ));
		getCommand("dctoggle").setExecutor(new CommandToggle( this ));
	}
	
	
	
	
	@Override
	public void onDisable() 
	{
		// removal of commands and events is done automatically by Bukkit/Spigot
		
		//getLogger().info("onDisable has been invoked!");
	}


}
