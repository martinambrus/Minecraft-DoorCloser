package net.tenrem.doorcloser;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandToggle implements CommandExecutor
{
	private final DoorCloserPlugin _plugin;

	public CommandToggle(DoorCloserPlugin plugin)
	{
		_plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] split)
	{
		if (sender instanceof Player) {
			String pName = sender.getName();

			if (this._plugin.ToggledPlayers.get(pName)) {
				this._plugin.ToggledPlayers.put(pName, false);
				sender.sendMessage("Automatic DoorCloser " + ChatColor.RED + "" + ChatColor.BOLD + "disabled");
			} else {
				this._plugin.ToggledPlayers.put(pName, true);
				sender.sendMessage("Automatic DoorCloser " + ChatColor.GREEN + "" + ChatColor.BOLD + "enabled");
			}
		} else {
			sender.sendMessage("This command can only be used by a player.");
		}

		return true;
	}
	
	
	
}
