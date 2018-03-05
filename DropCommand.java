package pl.chmurqafx.plugindonauki.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class DropCommand implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("chmurqacore.drophelp")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				p.sendMessage("Wkrotce w gui!");
				return true;
			}
		} else {
			sender.sendMessage("§cNie posiadasz permisji do uzycia tej komendy.");
			return true;
		}
	return true;
	}
}
