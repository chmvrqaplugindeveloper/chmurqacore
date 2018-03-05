package pl.chmurqafx.plugindonauki.commands;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OnlinePlayerCommand implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("chmurqacore.onlineplayers")) {
			Collection<? extends Player> list = (Bukkit.getOnlinePlayers());
			for (Player p : list) {
			  sender.sendMessage(p.getName());	 
			}
		} else {
			sender.sendMessage("§cNie posiadasz permisji do uzycia tej komendy.");
		}
		return true;
	}
}
