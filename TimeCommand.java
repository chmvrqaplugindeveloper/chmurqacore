package pl.chmurqafx.plugindonauki.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TimeCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("chmurqacore.czas")) {
			if(args.length == 2) {
				String nazwa = args[1];
				if(Bukkit.getWorld(nazwa) !=null) {
					World w = Bukkit.getWorld(nazwa);
					Long l = Long.parseLong(args[0]);
					w.setTime(l);
				} else {
					sender.sendMessage("§cSwiat o nazwie " + nazwa +" nie istnieje!");
				}
			}
		} else {
			sender.sendMessage("§cNie posiadasz permisji do uzycia tej komendy.");
		}
		return false;
	}
}
