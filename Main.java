package pl.chmurqafx.plugindonauki;

import java.util.ArrayList;
import java.util.List;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pl.chmurqafx.plugindonauki.commands.DropCommand;
import pl.chmurqafx.plugindonauki.commands.EasyCommand;
import pl.chmurqafx.plugindonauki.commands.FeedCommand;
import pl.chmurqafx.plugindonauki.commands.HealCommand;
import pl.chmurqafx.plugindonauki.commands.MSGCommand;
import pl.chmurqafx.plugindonauki.commands.MobSpawnCommand;
import pl.chmurqafx.plugindonauki.commands.OnlinePlayerCommand;
import pl.chmurqafx.plugindonauki.commands.TimeCommand;
import pl.chmurqafx.plugindonauki.commands.TpCommand;
import pl.chmurqafx.plugindonauki.commands.WeatherCommand;
import pl.chmurqafx.plugindonauki.listener.BlockBreakListener;

public class Main extends JavaPlugin {
	
	
	private List<String> msgs = new ArrayList<String>();{
		double jeden = getConfig().getDouble("autoMessage1");
		double dwa =  getConfig().getDouble("autoMessage2");
		double trzy =  getConfig().getDouble("autoMessage3");
		double cztery =  getConfig().getDouble("autoMessage4");
		double piec =  getConfig().getDouble("autoMessage5");
		msgs.add("§8[Info] " + jeden);
		msgs.add("§8[Info] " + dwa);
		msgs.add("§8[Info] " + trzy);
		msgs.add("§8[Info] " + cztery);
		msgs.add("§8[Info] " + piec);
	}
	private int msgNum;
	@Override
	public void onEnable() {
		System.out.println("Uruchamianie pluginu");
		getCommand("drop").setExecutor(new DropCommand());
		getCommand("onlineplayers").setExecutor(new OnlinePlayerCommand());
		getCommand("uleczenie").setExecutor(new HealCommand());
		getCommand("pogoda").setExecutor(new WeatherCommand());
		getCommand("czas").setExecutor(new TimeCommand());
		getCommand("easymode").setExecutor(new EasyCommand());
		getCommand("teleport").setExecutor(new TpCommand());
		getCommand("nakarm").setExecutor(new FeedCommand());
		getCommand("message").setExecutor(new MSGCommand());
		getCommand("zresp").setExecutor(new MobSpawnCommand());
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new BlockBreakListener(), this);
		autoMSG1(msgs);
		autoMSG2(msgs);
		autoMSG3(msgs);
		autoMSG4(msgs);
		autoMSG5(msgs);
		saveDefaultConfig();
	}
	
	@Override
	public void onDisable() {
		System.out.println("Serwer bedzie wylaczony, dezaktywowanie pluginu.");
	}
	
	private void autoMSG1(final List<String> msg) {
		msgNum = 0;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage(msg.get(0));
				msgNum++;
				if(msgNum == 6) {
					msgNum = 0;
				}
			}
		}, 0, 15*20);
	}
	
	private void autoMSG2(final List<String> msg) {
		msgNum = 0;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage(msg.get(1));
				msgNum++;
				if(msgNum == 6) {
					msgNum = 0;
				}
			}
		}, 0, 25*20);
	}

	private void autoMSG3(final List<String> msg) {
		msgNum = 0;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage(msg.get(2));
				msgNum++;
				if(msgNum == 6) {
					msgNum = 0;
				}
			}
		}, 0, 35*20);
	}
	
	private void autoMSG4(final List<String> msg) {
		msgNum = 0;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage(msg.get(3));
				msgNum++;
				if(msgNum == 6) {
					msgNum = 0;
				}
			}
		}, 0, 45*20);
	}
	
	private void autoMSG5(final List<String> msg) {
		msgNum = 0;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage(msg.get(4));
				msgNum++;
				if(msgNum == 6) {
					msgNum = 0;
				}
			}
		}, 0, 55*20);
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("spawn")) {
			if(args.length != 1) {
				return true;
			}
			if (!(sender instanceof Player)) {
				return true;
			}
			Player p = (Player) sender;
			if(args[0].equalsIgnoreCase("set")) {
				Location l = p.getLocation();
				getConfig().set("spawnLokalizacjaX", l.getX());
				getConfig().set("spawnLokalizacjaY", l.getY());
				getConfig().set("spawnLokalizacjaZ", l.getZ());
				getConfig().set("spawnLokalizacjaWorld", l.getWorld().getName());
				saveConfig();
				return true;
			}
			if(args[0].equalsIgnoreCase("tp")) {
				double x = getConfig().getDouble("spawnLokalizacjaX");
				double y =  getConfig().getDouble("spawnLokalizacjaY");
				double z =  getConfig().getDouble("spawnLokalizacjaZ");
				String worldname =  getConfig().getString("spawnLokalizacjaWorld");
				if(p.hasPermission("chmurqacore.*")) {
					Location l = new Location(Bukkit.getWorld(worldname),x,y,z);
					p.sendMessage("X:" + x);
					p.sendMessage("Y:" + y);
					p.sendMessage("Z:" + z);
					p.sendMessage("World:" + worldname);
					p.teleport(l);
					return true;
				} else {
					Location l = new Location(Bukkit.getWorld(worldname),x,y,z);
					p.teleport(l);
				}
			}
		}
		return false;
	}
}
