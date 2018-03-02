package pl.chmurqafx.plugindonauki;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import pl.chmurqafx.plugindonauki.builder.ItemBuilder;

public class Main extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		System.out.println("Uruchamianie pluginu");
		Bukkit.getPluginManager().registerEvents(new Main(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Serwer bedzie wylaczony, dezaktywowanie pluginu.");
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent drop) {
		Player p = drop.getPlayer();
		Block b = drop.getBlock();
		if(drop.isCancelled()) {
			return;
		}
		if(b.getType() == Material.STONE) {
			if(Math.random() * 100 <= 5) {
				ItemStack item1 = new ItemBuilder(Material.DIAMOND).toItemStack();
				b.getWorld().dropItemNaturally(b.getLocation(), item1);
				p.sendMessage("§b§lWydropiles diamenta.");
			}
			if(Math.random() * 100 <= 6) {
				ItemStack item1 = new ItemBuilder(Material.EMERALD).toItemStack();
				b.getWorld().dropItemNaturally(b.getLocation(), item1);
				p.sendMessage("§a§lWydropiles emeralda.");
			}
			if(Math.random() * 100 <= 10) {
				ItemStack item1 = new ItemBuilder(Material.COAL).toItemStack();
				b.getWorld().dropItemNaturally(b.getLocation(), item1);
				p.sendMessage("§0§lWydropiles wegiel.");
			}
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("drop")) {
			if(sender.hasPermission("chmurqacore.drophelp")) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					System.out.println("Someone executed /drop command.");
					p.sendMessage("§7§lDrop:");
					p.sendMessage("§b§lDiamenty: 5%");
					p.sendMessage("§a§lEmeraldy: 6%");
					p.sendMessage("§0§lWegiel: 10%");
				}
			} else {
				sender.sendMessage("§cNie posiadasz permisji do uzycia tej komendy.");
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("onlineplayers")) {
			if(sender.hasPermission("chmurqacore.onlineplayers")) {
				Collection<? extends Player> list = (Bukkit.getOnlinePlayers());
				for (Player p : list) {
				  sender.sendMessage(p.getName());	 
				}
			} else {
				sender.sendMessage("§cNie posiadasz permisji do uzycia tej komendy.");
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("uleczenie")) {
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
			
		}
		
		if(cmd.getName().equalsIgnoreCase("pogoda")) {
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
		if(cmd.getName().equalsIgnoreCase("czas")) {
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
		}
		if(cmd.getName().equalsIgnoreCase("easymode")) {
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
		}
		if(cmd.getName().equalsIgnoreCase("tp")) {
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
		}

		if(cmd.getName().equalsIgnoreCase("podpal")) {
			if(sender.hasPermission("chmurqacore.heal")) {
				if(args.length == 0) {
					if(!(sender instanceof Player)) {
						sender.sendMessage("§cNie jestes graczem.");
						return false;
					}
					Player p = (Player) sender;
					p.setFireTicks(1);
				}
				
				if(args.length >= 1) {
					String nazwaGracza = args[0];
					if(Bukkit.getPlayer(nazwaGracza) !=null) {
						Player p = Bukkit.getPlayer(nazwaGracza);
						p.setFireTicks(1);
					} else {
						sender.sendMessage("§c§lNie ma takiego gracza na serwerze.");
					}
				}
			} else {
				sender.sendMessage("§cNie posiadasz permisji do uzycia tej komendy.");
			}
			
		}

		if(cmd.getName().equalsIgnoreCase("nakarm")) {
			if(sender.hasPermission("chmurqacore.heal")) {
				if(args.length == 0) {
					if(!(sender instanceof Player)) {
						sender.sendMessage("§cNie jestes graczem.");
						return false;
					}
					Player p = (Player) sender;
					p.setFoodLevel(20);
				}
				
				if(args.length >= 1) {
					String nazwaGracza = args[0];
					if(Bukkit.getPlayer(nazwaGracza) !=null) {
						Player p = Bukkit.getPlayer(nazwaGracza);
						p.setFoodLevel(20);
					} else {
						sender.sendMessage("§c§lNie ma takiego gracza na serwerze.");
					}
				}
			} else {
				sender.sendMessage("§cNie posiadasz permisji do uzycia tej komendy.");
			}
			
		}
		if(cmd.getName().equalsIgnoreCase("zgas")) {
			if(sender.hasPermission("chmurqacore.heal")) {
				if(args.length == 0) {
					if(!(sender instanceof Player)) {
						sender.sendMessage("§cNie jestes graczem.");
						return false;
					}
					Player p = (Player) sender;
					p.setFireTicks(0);
				}
				
				if(args.length >= 1) {
					String nazwaGracza = args[0];
					if(Bukkit.getPlayer(nazwaGracza) !=null) {
						Player p = Bukkit.getPlayer(nazwaGracza);
						p.setFireTicks(0);
					} else {
						sender.sendMessage("§c§lNie ma takiego gracza na serwerze.");
					}
				}
			} else {
				sender.sendMessage("§cNie posiadasz permisji do uzycia tej komendy.");
			}
			
		}
		return false;
	}
}
