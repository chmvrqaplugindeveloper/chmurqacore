package pl.chmurqafx.plugindonauki.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherCommand implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("chmurqacore.weather")) {
			if(args.length == 1) {
				if(sender instanceof Player) {
					World w = ((Player)sender).getWorld();
					if(args[0].equals("ladna")) {
						w.setStorm(false);
						w.setThundering(false);
						return true;
					}
					if(args[0].equals("brzydka")) {
						w.setStorm(true);
						w.setThundering(false);
						return true;
					}
					if(args[0].equals("burza")) {
						w.setStorm(true);
						w.setThundering(true);
						return true;
					}
					if(args[0].equalsIgnoreCase("pioruny")) {
						w.setStorm(false);
						w.setThundering(true);
						return true;
					} else {
						sender.sendMessage("§cMozliwe argumenty: ladna, brzydka, burza, pioruny");
					}
				}
				if(args.length == 2) {
					String nazwa = args[1];
					if(Bukkit.getWorld(nazwa) !=null) {
						World w = Bukkit.getWorld(nazwa);
						if(args[0].equalsIgnoreCase("ladna")) {
							w.setStorm(false);
							w.setThundering(false);
							return true;
						}
						if(args[0].equalsIgnoreCase("brzydka")) {
							w.setStorm(true);
							w.setThundering(false);
							return true;
						}
						if(args[0].equalsIgnoreCase("burza")) {
							w.setStorm(true);
							w.setThundering(true);
							return true;
						}
						if(args[0].equalsIgnoreCase("pioruny")) {
							w.setStorm(false);
							w.setThundering(true);
							return true;
						} else {
							sender.sendMessage("§cMozliwe argumenty: ladna, brzydka, burza, pioruny");
						}
					} else {
						sender.sendMessage("§cSwiat o nazwie " + nazwa +" nie istnieje!");
					}
				} else {
					sender.sendMessage("§cZla liczba argumentow!");
				}
			} else {
				sender.sendMessage("§cNie posiadasz permisji do uzycia tej komendy.");
			}
			
		}
		return false;
		}
}
