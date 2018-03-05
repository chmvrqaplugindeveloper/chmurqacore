package pl.chmurqafx.plugindonauki.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("chmurqacore.tp")) {
			if(args.length == 1) {
				if (!(sender instanceof Player)) {
					sender.sendMessage("§cNie ma Cie na serwerze.");
					return false;
				}
				if(!(Bukkit.getPlayer(args[0]) !=null)) {
					sender.sendMessage("§cNie ma takiego gracza na serwerze.");
					return false;
				}
				Player dokogotp = Bukkit.getPlayer(args[0]);
				Location lokalizacja = dokogotp.getLocation();
				((Player)sender).teleport(lokalizacja);
				return true;
			}
			if(args.length == 2) {
				if(!(Bukkit.getPlayer(args[0]) !=null)) {
					sender.sendMessage("§cNie ma takiego gracza na serwerze. (args 0)");
					return false;
				}
				if(!(Bukkit.getPlayer(args[0]) !=null)) {
					sender.sendMessage("§cNie ma takiego gracza na serwerze. (args 1)");
					return false;
				}
				Player p = Bukkit.getPlayer(args[0]);
				Player dokogotp = Bukkit.getPlayer(args[1]);
				Location lokalizacja = new Location(dokogotp.getLocation().getWorld(), dokogotp.getLocation().getX(), dokogotp.getLocation().getY(), dokogotp.getLocation().getZ());
				p.teleport(lokalizacja);
				return true;
			} else {
				sender.sendMessage("§cZa malo argumentow!");
				return false;
			}
		} else {
			sender.sendMessage("§cNie posiadasz permisji do tej komendy.");
		}
		return false;
	}
}
