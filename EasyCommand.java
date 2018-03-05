package pl.chmurqafx.plugindonauki.commands;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EasyCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("chmurqacore.easymode")) {
			if(args.length !=1) {
				return false;
			}
			String nazwa = args[0];
			if(Bukkit.getWorld(nazwa) !=null) {
				World w = (Bukkit.getWorld(nazwa));
				w.setPVP(!w.getPVP());
				w.setDifficulty(Difficulty.EASY);
			}
		} else {
			sender.sendMessage("§cNie posiadasz permisji do uzycia tej komendy.");
		}
		return false;
	}
}
