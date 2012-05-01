package me.Darioda.WarOfEmperium;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.getspout.spoutapi.block.SpoutBlock;

import zubi.mhm.unlimitedmaterials.manager.BlockManager;

public class WarOfEmperiumBlockListener implements Listener{
	
	public static WarOfEmperium plugin;
	

	
	public WarOfEmperiumBlockListener(WarOfEmperium instance) {
		plugin = instance;
	}
	
	@EventHandler(priority=EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event)
	{
		Player player = event.getPlayer();
		SpoutBlock block = (SpoutBlock) event.getBlock();
		int block_id = block.getTypeId();
		if(block.isCustomBlock() && BlockManager.BlockArray.get(11).getCustomId() == block.getCustomBlockId())
		{
			File repertoire = new File(plugin.getDataFolder() + "/castle/");
			
			if(repertoire.exists())
				lifeEmp(player, block, event);
		}
			
		
	}
	
	@SuppressWarnings("unused")
	public void lifeEmp(Player player, SpoutBlock block, BlockBreakEvent event)
	{
		Location block_loc = block.getLocation();
		
		
		int block_coo_x = block_loc.getBlockX();
		int block_coo_y = block_loc.getBlockY();
		int block_coo_z = block_loc.getBlockZ();
		
		String [] listefichiers;
		File repertoire = new File(plugin.getDataFolder() + "/castle/");

		listefichiers = repertoire.list();

		for(int i = 0; i < listefichiers.length; i++)
		{
			plugin.Load.reloadcastleSelectConfig(listefichiers[i].toString());
			if(plugin.castleEnable.contains("true"))
			{
				String [] listefichiers2;
				File repertoire2 = new File("plugins/WarOfEmperium/castle/" + listefichiers[i].toString()  + "/event/");
				listefichiers2 = repertoire2.list();
				if(repertoire2.exists())
				{
						String[] grp = plugin.Permissions.getGroup(player);
						if(((plugin.cooEmpX == block_coo_x) && (plugin.cooEmpY == block_coo_y) && (plugin.cooEmpZ == block_coo_z)) || ((plugin.cooEmpX + 1 == block_coo_x) && (plugin.cooEmpY == block_coo_y) && (plugin.cooEmpZ == block_coo_z)) || ((plugin.cooEmpX - 1 == block_coo_x) && (plugin.cooEmpY == block_coo_y) && (plugin.cooEmpZ == block_coo_z)) || ((plugin.cooEmpX == block_coo_x) && (plugin.cooEmpY + 1 == block_coo_y) && (plugin.cooEmpZ == block_coo_z)) || ((plugin.cooEmpX == block_coo_x) && (plugin.cooEmpY - 1 == block_coo_y) && (plugin.cooEmpZ == block_coo_z)) || ((plugin.cooEmpX == block_coo_x) && (plugin.cooEmpY == block_coo_y) && (plugin.cooEmpZ + 1 == block_coo_z)) || ((plugin.cooEmpX == block_coo_x) && (plugin.cooEmpY == block_coo_y) && (plugin.cooEmpZ - 1 == block_coo_z)))
						{
							if(plugin.ownerCastle.equalsIgnoreCase(grp[0]))
							{
								event.setCancelled(true);
								player.sendMessage("Vous ne pouvez pas casser votre emperium !");
							}
							else
							{
								if(plugin.lifeEmp != 0)
								{
									plugin.lifeEmp = plugin.lifeEmp - 1;
									plugin.Load.sauvVar(listefichiers[i].toString());
									plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] " + player.getName() + "(" + ChatColor.RED + grp[0] + ChatColor.GOLD + ")" + " vient d'affaiblir l'Emperium de "  + listefichiers[i].toString() + ". " + plugin.lifeEmp + " points de vie restants !");
								}
								if(plugin.lifeEmp == 0)
								{
									plugin.ownerCastle = grp[0];
									plugin.lifeEmp = 7;
									plugin.Load.sauvVar(listefichiers[i].toString());
									plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] " + player.getName() + " vient de détruire l'Emperium de "  + listefichiers[i].toString() + ". " + " La faction " + ChatColor.RED + grp[0] + ChatColor.GOLD + " prend le contrôle du château !");
									plugin.Tp.renvoiIntrus(listefichiers[i].toString());
								    WarOfEmperiumTimeWait timewait = new WarOfEmperiumTimeWait(plugin, listefichiers[i].toString());
								    timewait.start();
								    plugin.Flag.remplaceBloc(listefichiers[i].toString(), grp[0]);
								}
							}
						}
					
				}
			}
		} 	
	}
}
