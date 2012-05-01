package me.Darioda.WarOfEmperium;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
//import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.player.SpoutPlayer;
//import org.getspout.spoutapi.gui.Color;

public class WarOfEmperiumPlayerListener implements Listener
{
	public static WarOfEmperium plugin;
		
	public WarOfEmperiumPlayerListener(WarOfEmperium instance) {
		plugin = instance;
	}
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerBlockInteract(PlayerInteractEvent event)
	{
		Material block_mat = Material.valueOf("Dirt");
		int id = block_mat.getId();
		plugin.getServer().broadcastMessage(String.valueOf(id));
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onEntityDamage(EntityDamageEvent event)
	{
		if (event.getEntity() instanceof Player)
  		{
			Player player = (Player)event.getEntity();
			if(plugin.Region.isInRegion(player))
			{
				int damage = event.getDamage();
				int health = player.getHealth();
				if((health - damage) < 0)
				{
					plugin.getServer().broadcastMessage(player.getName() + " a été tué !");
					event.setCancelled(true);
					player.setHealth(20);
					String[] grp = plugin.Permissions.getGroup(player);
		    		Location spawn = plugin.Spawn.spawn(grp[0]);
		    		if(spawn != null)
		    			player.teleport(spawn);
		    		else
		    		{
		    			spawn = plugin.Spawn.spawnDefault();
		    			player.teleport(spawn);
		    		}
				}
			}
  		}
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerMove(PlayerMoveEvent event)
	{
		/*if(plugin.woe)
		{
			plugin.Load.reloadcastleSelectConfig(plugin.woe_str);
			plugin.EventLoad.reloadcastleSelectConfig(plugin.woe_str, plugin.woe_evt);
		    
			SpoutPlayer splayer = (SpoutPlayer)event.getPlayer();

			GenericLabel label = new GenericLabel("");
		    label.setTextColor(new Color(1.0F, 1.0F, 1.0F, 1.0F)).setX(10).setY(10);
		    label.setText("Possesseur du chateau : " + plugin.ownerCastle);
		    label.setWidth(1);
		    label.setVisible(true);
		    
		    int minute = 0;
		    int heure = Integer.valueOf(plugin.eventHeureFin) - plugin.woe_h;
		    if(heure < 0)
		    {
		    	heure = 24 - plugin.woe_h + Integer.valueOf(plugin.eventHeureFin);
		    }
		    
		    while(heure > 0)
		    {
		    	heure = heure - 1;
		    	minute = minute + 60;
		    }
		    
		    if(Integer.valueOf(plugin.eventMinuteFin) > plugin.woe_m)
		    {
		    	minute = minute + Integer.valueOf(plugin.eventMinuteFin) - plugin.woe_m;
		    }
		    else
		    {
		    	minute = minute + Integer.valueOf(plugin.eventMinuteFin) - plugin.woe_m;
		    }
		    
		    GenericLabel label2 = new GenericLabel("");
		    label2.setTextColor(new Color(1.0F, 1.0F, 1.0F, 1.0F)).setX(10).setY(20);
		    label2.setText("Fin de l'event dans : " + minute);
		    label2.setWidth(1);
		    label2.setVisible(true);
		    
		    splayer.getMainScreen().attachWidget(plugin, label);
		    splayer.getMainScreen().attachWidget(plugin, label2);
		    
		    label.animateStart();
		    label.animateStop(true);
		    label2.animateStart();
		    label2.animateStop(true);
		    
		}*/
		String [] listefichiers;
		File repertoire = new File("plugins/WarOfEmperium/castle/");
		if(repertoire.exists())
		{
			listefichiers = repertoire.list();
			for(int i = 0; i < listefichiers.length; i++)
			{
				plugin.Load.reloadcastleSelectConfig(listefichiers[i].toString());
				String[] grp = plugin.Permissions.getGroup(event.getPlayer());
				boolean rep = plugin.Region.isWithinRegion(event.getPlayer(), plugin.regionCastle);
				if(rep == true)
				{
					addTitre(grp[0], event.getPlayer(), event.getPlayer().getName());
				}
				else
				{
					remTitre(event.getPlayer(), event.getPlayer().getPlayerListName());
				}
				rep = plugin.Region.isWithinRegion(event.getPlayer(), plugin.regionEntreeAll);
				if(rep == true)
				{
					World world_dest = Bukkit.getWorld(plugin.WorldPortailAllSortieStr);					
					Location loc_dest = new Location(world_dest, plugin.cooPortailAllSortieX, plugin.cooPortailAllSortieY, plugin.cooPortailAllSortieZ);
					event.getPlayer().teleport(loc_dest);
				}
				
				rep = plugin.Region.isWithinRegion(event.getPlayer(), plugin.regionEntreeGrp);
				if(rep == true)
				{
					String[] grp2 = plugin.Permissions.getGroup(event.getPlayer());
					if(plugin.ownerCastle.equalsIgnoreCase(grp2[0]))
					{
						World world_dest = Bukkit.getWorld(plugin.WorldPortailGrpSortieStr);					
						Location loc_dest = new Location(world_dest, plugin.cooPortailGrpSortieX, plugin.cooPortailGrpSortieY, plugin.cooPortailGrpSortieZ);
						event.getPlayer().teleport(loc_dest);
					}
				}
				rep = plugin.Region.isWithinRegion(event.getPlayer(), plugin.regionEntreeGrp2);
				if(rep == true)
				{
					String[] grp2 = plugin.Permissions.getGroup(event.getPlayer());
					if(plugin.ownerCastle.equalsIgnoreCase(grp2[0]))
					{
						World world_dest = Bukkit.getWorld(plugin.WorldPortailGrpSortieStr2);					
						Location loc_dest = new Location(world_dest, plugin.cooPortailGrpSortieX2, plugin.cooPortailGrpSortieY2, plugin.cooPortailGrpSortieZ2);
						event.getPlayer().teleport(loc_dest);
					}
				}
			}
		}
		
	}
	
	public void addTitre(String group, Player joueur, String playername)
	{
		SpoutPlayer sm = (SpoutPlayer)joueur;
		if (group.equalsIgnoreCase("Sangdragon"))
		{
			sm.setTitle(playername + "\n" + ChatColor.DARK_PURPLE + "[" + group + "]");
		}
		if (group.equalsIgnoreCase("Shinrin"))	
		{
			sm.setTitle(playername + "\n" + ChatColor.GREEN + "[" + group + "]");
		}
		if (group.equalsIgnoreCase("Heloptes"))		
		{
			sm.setTitle(playername + "\n" + ChatColor.BLUE + "[" + group + "]");
		}
		if (group.equalsIgnoreCase("Eares"))		
		{
			sm.setTitle(playername + "\n" + ChatColor.YELLOW + "[" + group + "]");
		}
	}
    
    public void remTitre(Player joueur, String playername)
	{
    	SpoutPlayer sm = (SpoutPlayer)joueur;
	    sm.setTitle(playername);
	}
	
}