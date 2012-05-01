package me.Darioda.WarOfEmperium;

import org.bukkit.ChatColor;

public class WarOfEmperiumCarThread extends Thread{

	public static WarOfEmperium plugin;
	public String castle_name;
	public String owner;
	public String event;
	public int et;
	
	public WarOfEmperiumCarThread(WarOfEmperium instance, String castle, String owner_castle, int etat, String event_name) {
		plugin = instance;
		castle_name = castle;
		owner = owner_castle;
		et = etat;
		event = event_name;
	}
	
	@SuppressWarnings("deprecation")
	public void run()
	{
		if(et == 1)
		{
			try
	    	{
				plugin.woe = true;
				plugin.woe_str = castle_name;
				plugin.woe_evt = event;
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 10...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 9...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 8...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 7...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 6...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 5...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 4...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 3...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 2...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 1...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] La War of Emperium du chateau " + castle_name + " est ouverte !");
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] Qui prendra le contrôle du château " + castle_name + " à la place de la faction " + owner + " ? A vous de jouer !");
				plugin.generateEmperium(castle_name, true);
				plugin.castleEtat = "true";
				plugin.EventLoad.sauvVar(castle_name, event);
				this.stop();
			} 
	    	catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		else if(et == 0)
		{
			try
	    	{
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 10...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 9...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 8...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 7...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 6...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 5...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 4...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 3...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 2...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] 1...");
				Thread.sleep(1000);
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] La War of Emperium du chateau " + castle_name + " est fermée !");
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] Félicitations à la faction " + owner +  " qui a le contrôle du château " + castle_name);
				
				plugin.generateEmperium(castle_name, false);
				plugin.castleEtat = "false";
				plugin.EventLoad.sauvVar(castle_name, event);
				plugin.Chest.creerCoffre(castle_name);
				plugin.woe_str = "";
				plugin.woe_evt = "";
				plugin.woe = false;
				this.stop();
			} 
	    	catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
