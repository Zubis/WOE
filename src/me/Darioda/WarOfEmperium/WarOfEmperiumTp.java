package me.Darioda.WarOfEmperium;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class WarOfEmperiumTp {

	private WarOfEmperium plugin;
    
	public WarOfEmperiumTp(WarOfEmperium plugin) {
		this.plugin = plugin;
	}
	
	public void tp(Player player, String castle)
	{
		plugin.Load.reloadcastleSelectConfig(castle);
		World world_dest = Bukkit.getWorld(plugin.WorldTPStr);
		
		String [] listefichiers2;
		File repertoire2 = new File("plugins/WarOfEmperium/castle/" + castle  + "/event/");
		listefichiers2 = repertoire2.list();
		if(repertoire2.exists())
		{
			for(int j = 0; j < listefichiers2.length; j++)
			{
				plugin.EventLoad.reloadcastleSelectConfig(castle, listefichiers2[j].toString());
				if(plugin.castleEtat.equals("true"))
				{
					String[] grp = plugin.Permissions.getGroup(player);
					if(plugin.ownerCastle.equalsIgnoreCase(grp[0]))
					{
						Location loc_dest = new Location(world_dest, plugin.cooTPX, plugin.cooTPY, plugin.cooTPZ);
						player.teleport(loc_dest);
					}
					else
						player.sendMessage("Ce chateau ne vous appartient pas !");	
				}
			}	
			
		}
	}
	
	public void renvoi(String castle)
	{
		Player[] players = plugin.getServer().getOnlinePlayers();
		plugin.Load.reloadcastleSelectConfig(castle);
	    for (Player player : players)
	    {
	    	boolean rep = plugin.Region.isWithinRegion(player, plugin.regionCastle);
	    	if(rep == true)
	    	{
	    		World world = Bukkit.getWorld(plugin.WorldCheckpointStr);
    			Location loc_dest = new Location(world, plugin.cooCheckpointX, plugin.cooCheckpointY, plugin.cooCheckpointZ);
				player.teleport(loc_dest);
	    	}
	    }
	}
	
	public void renvoiIntrus(String castle)
	{
		Player[] players = plugin.getServer().getOnlinePlayers();
		plugin.Load.reloadcastleSelectConfig(castle);
	    for (Player player : players)
	    {
	    	boolean rep = plugin.Region.isWithinRegion(player, plugin.regionCastle);
	    	if(rep == true)
	    	{
	    		String[] grp = plugin.Permissions.getGroup(player);
	    		
	    		if(!plugin.ownerCastle.equalsIgnoreCase(grp[0]))
    			{
	    			World world = Bukkit.getWorld(plugin.WorldCheckpointStr);
	    			Location loc_dest = new Location(world, plugin.cooCheckpointX, plugin.cooCheckpointY, plugin.cooCheckpointZ);
					player.teleport(loc_dest);
    			}
	    		
	    		if(plugin.autoheal == "on")
	    			player.setHealth(20);
	    	}
	    }
	}
}
