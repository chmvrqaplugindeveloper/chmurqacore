package pl.chmurqafx.plugindonauki.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MSGCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("chmurqacore.msg")) {
			if(args.length >= 1) {
				if (!(sender instanceof Player)) {
					sender.sendMessage("§cNie ma Cie na serwerze.");
					return false;
				}
				if(!(Bukkit.getPlayer(args[0]) !=null)) {
					sender.sendMessage("§cNie ma takiego gracza na serwerze.");
					return false;
				}
				String wiadomosc = args[1];
				Player dokogowiadomosc = Bukkit.getPlayer(args[0]);
				dokogowiadomosc.sendMessage("§8[§b"+ sender.getName() + " -> Ja§8]§b " + wiadomosc);
				sender.sendMessage("§8[§bJa -> " + dokogowiadomosc.getName() + "§8]§b " + wiadomosc);
			}
			
			if(args.length <= 0) {
				sender.sendMessage("§cNie prawidlowa dlugosc argumentow");
				return false;
			}
			
			if(args[1].length() <= 0) {
				return false;
			}
			
			if(args[0] == null) {
				return false;
			}
		}
		return false;
	}
}
