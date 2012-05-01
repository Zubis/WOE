package me.Darioda.WarOfEmperium;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;

public class WarOfEmperiumCommand {

	private WarOfEmperium plugin;
    
	public WarOfEmperiumCommand(WarOfEmperium plugin) {
		this.plugin = plugin;
	}
	
	public void castleEnable(String castle, CommandSender sender)
	{
		if(plugin.castleEnable.equals("true"))
		{
			plugin.castleEnable = "false";
			sender.sendMessage("Chateau désactivé");
		}
		else
		{
			if((plugin.WorldTPStr.contentEquals("")) || (plugin.WorldStr.contentEquals("")) || (plugin.WorldTPStr.contentEquals("")) || (plugin.regionCastle.contentEquals("")))
			{
				sender.sendMessage("Le chateau n'a pas fini d'être construit !");
			}
			else
			{
				plugin.castleEnable = "true";
				sender.sendMessage("Chateau activé");
			}
		}
		plugin.Load.sauvVar(castle);
	}
	
	public void setCheckpoint(String castle, Location location)
	{
		plugin.Load.reloadcastleSelectConfig(castle);
		
		World world = location.getWorld();
		 
		int x_start = location.getBlockX();
		int y_start = location.getBlockY();
		int z_start = location.getBlockZ();
		
		plugin.cooCheckpointX = x_start;
		plugin.cooCheckpointY = y_start;
		plugin.cooCheckpointZ = z_start;
		plugin.WorldCheckpointStr = world.getName();
		
		plugin.Load.sauvVar(castle);
	}
	
	public void setEmperium(Location location, String castle)
	{
		plugin.Load.reloadcastleSelectConfig(castle);
		
		World world = location.getWorld();
		 
		int x_start = location.getBlockX();
		int y_start = location.getBlockY();
		int z_start = location.getBlockZ();
		
		plugin.cooEmpX = x_start;
		plugin.cooEmpY = y_start;
		plugin.cooEmpZ = z_start;
		plugin.WorldStr = world.getName();
		
		plugin.Load.sauvVar(castle);
	}
	
	public void createCastle(String castle)
	{
		plugin.Create.configDefaultcastleCreateConfig(castle);
		plugin.Flag.createFlag(castle);
	}
	
	
	public void settp(Location location, String castle)
	{
		plugin.Load.reloadcastleSelectConfig(castle);
		
		World world = location.getWorld();
		 
		int x_start = location.getBlockX();
		int y_start = location.getBlockY();
		int z_start = location.getBlockZ();
		
		plugin.cooTPX = x_start;
		plugin.cooTPY = y_start;
		plugin.cooTPZ = z_start;
		plugin.WorldTPStr = world.getName();
		
		plugin.Load.sauvVar(castle);
			
	}
	
	public void setRegion(String castle, String region)
	{
		plugin.Load.reloadcastleSelectConfig(castle);
		plugin.regionCastle = region;
		plugin.Load.sauvVar(castle);
	}
	
	public void createEvent(String name_id, String castle)
	{
		plugin.EventCreate.configDefaultcastleCreateConfig(castle, name_id);
	}
	
	public void saveEvent(String name_id, String castle, String jour_begin, String heure_begin, String minute_begin, String jour_end, String heure_end, String minute_end)
	{
		plugin.EventLoad.reloadcastleSelectConfig(castle, name_id);
		plugin.eventJourDebut = jour_begin;
		plugin.eventHeureDebut = heure_begin;
		plugin.eventMinuteDebut = minute_begin;
		plugin.eventJourFin = jour_end;
		plugin.eventHeureFin = heure_end;
		plugin.eventMinuteFin = minute_end;
		plugin.EventLoad.sauvVar(castle, name_id);
	}
	
}
