package pl.chmurqafx.plugindonauki.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("chmurqacore.heal")) {
			if(args.length == 0) {
				if(!(sender instanceof Player)) {
					sender.sendMessage("§cNie jestes graczem.");
					return false;
				}
				Player p = (Player) sender;
				p.setHealth(20);
				p.setFoodLevel(20);
				p.setFireTicks(0);
			}
			
			if(args.length >= 1) {
				String nazwaGracza = args[0];
				if(Bukkit.getPlayer(nazwaGracza) !=null) {
					Player p = Bukkit.getPlayer(nazwaGracza);
					p.setHealth(20);
					p.setFoodLevel(20);
					p.setFireTicks(0);
				} else {
					sender.sendMessage("§c§lNie ma takiego gracza na serwerze.");
				}
			}
		} else {
			sender.sendMessage("§cNie posiadasz permisji do uzycia tej komendy.");
		}
		return true;
		
	}
}
