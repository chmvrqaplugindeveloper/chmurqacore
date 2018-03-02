package pl.chmurqafx.plugindonauki.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import pl.chmurqafx.plugindonauki.builder.ItemBuilder;

public class BlockBreakListener implements Listener {
	@EventHandler
	public void onBreak(BlockBreakEvent drop) {
		Player p = drop.getPlayer();
		Block b = drop.getBlock();
		if(drop.isCancelled()) {
			return;
		}
		if(b.getType() == Material.STONE) {
			if(Math.random() * 100 <= 4) {
				ItemStack item1 = new ItemBuilder(Material.DIAMOND).toItemStack();
				b.getWorld().dropItemNaturally(b.getLocation(), item1);
				p.sendMessage("§b§lWydropiles diamenta.");
			}
			if(Math.random() * 100 <= 4) {
				ItemStack item2 = new ItemBuilder(Material.EMERALD).toItemStack();
				b.getWorld().dropItemNaturally(b.getLocation(), item2);
				p.sendMessage("§a§lWydropiles emeralda.");
			}
			if(Math.random() * 100 <= 5) {
				ItemStack item3 = new ItemBuilder(Material.COAL).toItemStack();
				b.getWorld().dropItemNaturally(b.getLocation(), item3);
				p.sendMessage("§0§lWydropiles wegiel.");
			}
			if(Math.random() * 100 <= 3) {
				ItemStack item4 = new ItemBuilder(Material.GOLD_INGOT).toItemStack();
				b.getWorld().dropItemNaturally(b.getLocation(), item4);
				p.sendMessage("§6lWydropiles zloto.");
			}
			if(Math.random() * 100 <= 4) {
				ItemStack item5 = new ItemBuilder(Material.APPLE).toItemStack();
				b.getWorld().dropItemNaturally(b.getLocation(), item5);
				p.sendMessage("§4lWydropiles jablko.");
			}
			if(Math.random() * 100 <= 6) {
				ItemStack item4 = new ItemBuilder(Material.BOOK).toItemStack();
				b.getWorld().dropItemNaturally(b.getLocation(), item4);
				p.sendMessage("§2lWydropiles ksiazke.");
			}
		}
	}
}
