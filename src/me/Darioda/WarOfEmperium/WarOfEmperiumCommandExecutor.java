package me.Darioda.WarOfEmperium;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.PermissionUser;

public class WarOfEmperiumCommandExecutor implements CommandExecutor {
    
		private WarOfEmperium plugin;
     
    	public WarOfEmperiumCommandExecutor(WarOfEmperium plugin) {
    		this.plugin = plugin;
    	}
    	
		@Override
    	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
		{
		
			Player player = null;
      		@SuppressWarnings("unused")
			String player_name = "";
      		
      		if (sender instanceof Player)
      		{
      			player = (Player) sender;
          		player_name = player.getName();
      		}
      			
      		
      		if ((sender instanceof Player)) 
      		{
      			PermissionUser user = plugin.Permissions.getPerms(player);
      			if (command.getName().equalsIgnoreCase("woe")) 
      			{
      				if (args.length == 0) 
      				{
      					sender.sendMessage(ChatColor.GRAY + "Créé pour MHM");
      				}
      				
      				//
      				
      				else if (args[0].equalsIgnoreCase("portailall"))
      				{
      					Location location = player.getLocation();
      					File castlePath = new File(plugin.getDataFolder() + "/castle/" + args[2].toString() + "/", args[2].toString() + ".yml");
      					
      					World world = location.getWorld();
      					 
      					int x_start = location.getBlockX();
      					int y_start = location.getBlockY();
      					int z_start = location.getBlockZ();
      					if(castlePath.exists())
      					{
      						if(args[1].equalsIgnoreCase("entree"))
      						{
      							if(args.length == 4)
      	      					{
      								plugin.Load.reloadcastleSelectConfig(args[2].toString());
      								plugin.regionEntreeAll = args[3].toString();
      								sender.sendMessage("Fait");
      	      					}
      							else
      	      					{
      	      						sender.sendMessage("Commande pas sous la bonne forme !");
      	      						sender.sendMessage("Rappel : /woe portailall <entree/sortie> <name_castle> [region_name(sortie)]");
      	      					} 
      						}
      						else if (args[1].equalsIgnoreCase("sortie"))
      						{
      							if(args.length == 3)
      	      					{
      								plugin.Load.reloadcastleSelectConfig(args[2].toString());
      								plugin.WorldPortailAllSortieStr = world.getName();
          							plugin.cooPortailAllSortieX = x_start;
          							plugin.cooPortailAllSortieY = y_start;
          							plugin.cooPortailAllSortieZ = z_start;
          							sender.sendMessage("Fait");
      	      					}
      							else
          							sender.sendMessage("Rappel : /woe portailall <entree/sortie> <name_castle> [region_name(sortie)]");
      						}
      						plugin.Load.sauvVar(args[2].toString());
      					}
      					else
      					{
      						sender.sendMessage("Commande pas sous la bonne forme !");
      						sender.sendMessage("Rappel : /woe portailall <entree/sortie> <name_castle> [region_name(sortie)]");
      					}
  					}
      					
      				else if (args[0].equalsIgnoreCase("portailgrp"))
      				{
      					Location location = player.getLocation();
      					File castlePath = new File(plugin.getDataFolder() + "/castle/" + args[3].toString() + "/", args[3].toString() + ".yml");
      					
      					World world = location.getWorld();
      					 
      					int x_start = location.getBlockX();
      					int y_start = location.getBlockY();
      					int z_start = location.getBlockZ();
      					if(castlePath.exists())
      					{
      						if(args[1].equalsIgnoreCase("1"))
      						{
      							if(args[2].equalsIgnoreCase("entree"))
          						{
          							if(args.length == 5)
          	      					{
          								plugin.Load.reloadcastleSelectConfig(args[3].toString());
          								plugin.regionEntreeGrp = args[4].toString();
          								sender.sendMessage("Fait");
          	      					}
          							else
          	      					{
          	      						sender.sendMessage("Commande pas sous la bonne forme !");
          	      						sender.sendMessage("Rappel : /woe portailgrp 1 <entree/sortie> <name_castle> [region_name(sortie)]");
          	      					}
          						}
          						else if (args[2].equalsIgnoreCase("sortie"))
          						{
          							if(args.length == 4)
          	      					{
          								plugin.Load.reloadcastleSelectConfig(args[3].toString());
          								plugin.WorldPortailGrpSortieStr = world.getName();
          								plugin.cooPortailGrpSortieX = x_start;
          								plugin.cooPortailGrpSortieY = y_start;
          								plugin.cooPortailGrpSortieZ = z_start;
      									sender.sendMessage("Fait");
          	      					}
      								else
              							sender.sendMessage("Rappel : /woe portailgrp 1 <entree/sortie> <name_castle> [region_name(sortie)]");
          						}
      							plugin.Load.sauvVar(args[3].toString());
      						}
      						
      						else if(args[1].equalsIgnoreCase("2"))
      						{
      							if(args[2].equalsIgnoreCase("entree"))
          						{
          							if(args.length == 5)
          	      					{
          								plugin.Load.reloadcastleSelectConfig(args[3].toString());
          								plugin.regionEntreeGrp2 = args[4].toString();
          								sender.sendMessage("Fait");
          	      					}
          							else
          	      					{
          	      						sender.sendMessage("Commande pas sous la bonne forme !");
          	      						sender.sendMessage("Rappel : /woe portailgrp 2 <entree/sortie> <name_castle> [region_name(sortie)]");
          	      					}
          						}
          						else if (args[2].equalsIgnoreCase("sortie"))
          						{
          							if(args.length == 4)
          	      					{
          								plugin.Load.reloadcastleSelectConfig(args[3].toString());
          								plugin.WorldPortailGrpSortieStr2 = world.getName();
          								plugin.cooPortailGrpSortieX2 = x_start;
          								plugin.cooPortailGrpSortieY2 = y_start;
          								plugin.cooPortailGrpSortieZ2 = z_start;
      									sender.sendMessage("Fait");
          	      					}
      								else
              							sender.sendMessage("Rappel : /woe portailgrp 2 <entree/sortie> <name_castle> [region_name(sortie)]");
          						}
      							plugin.Load.sauvVar(args[3].toString());
      						}
      					}
      					else
      					{
      						sender.sendMessage("Commande pas sous la bonne forme !");
      						sender.sendMessage("Rappel : /woe portailgrp <entree/sortie> <name_castle>");
      					}
  					}
      						
      				
      				
      				else if (args[0].equalsIgnoreCase("chest")) 
      				{
      					if(user.has("woe.builder") ||user.has("woe.moderateur"))
      					{
      						if (args[1].equalsIgnoreCase("regen"))
      						{
      							if (args.length == 3)
      							{
      								plugin.Chest.creerCoffre(args[2].toString());
      								sender.sendMessage("Les coffres ont été regénéré !");
      							}
      							else
      							{
      								sender.sendMessage("Commande pas sous la bonne forme !");
          							sender.sendMessage("Rappel : /woe chest regen <name_castle>");
      							}
  							}
      						else if (args[1].equalsIgnoreCase("create"))
      						{
      							if (args.length == 3)
      							{
      								plugin.Chest.createFile(args[2].toString());
      								sender.sendMessage("Le dossier chest a été généré !");
      							}
      							else
      							{
      								sender.sendMessage("Commande pas sous la bonne forme !");
          							sender.sendMessage("Rappel : /woe chest create <name_castle>");
      							}
  							}
      						else if (args[1].equalsIgnoreCase("empty"))
      						{
      							if (args.length == 3)
      							{
      								plugin.Chest.viderCoffre(args[2].toString());
      								sender.sendMessage("Les coffres ont été vidé !");
      							}
      							else
      							{
      								sender.sendMessage("Commande pas sous la bonne forme !");
          							sender.sendMessage("Rappel : /woe chest empty <name_castle>");
      							}
  							}
      						else if (args[1].equalsIgnoreCase("addchest"))
      						{
      							if (args.length == 4)
      							{
      								Location loc = player.getLocation();
      								plugin.Chest.addCoffre(args[3].toString(), loc.getWorld().getName(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), args[2].toString());
      								sender.sendMessage("Un coffre a été ajouté à votre position !");
      							}
      							else
      							{
      								sender.sendMessage("Commande pas sous la bonne forme !");
          							sender.sendMessage("Rappel : /woe chest addchest <id> <name_castle>");
      							}
  							}
      						else if (args[1].equalsIgnoreCase("additem"))
      						{
      							if (args.length == 7)
      							{
      								plugin.Chest.addItem(args[2].toString(), args[3].toString(), Integer.valueOf(args[4].toString()), Integer.valueOf(args[5].toString()), Integer.valueOf(args[6].toString()));

      								sender.sendMessage("Un item a été ajouté !");
      							}
      							else
      							{
      								sender.sendMessage("Commande pas sous la bonne forme !");
          							sender.sendMessage("Rappel : /woe chest additem <name_castle> <id_name> <id_item> <nombre> <chance>");
      							}
  							}
      						else
      						{
      							sender.sendMessage("Commande pas sous la bonne forme !");
      							sender.sendMessage("Rappel : action : create, regen, empty, addchest, additem");
      						}
      					}
    				}
      				
      				//Create
      				else if (args[0].equalsIgnoreCase("build")) 
      				{
      					if(user.has("woe.builder") || user.has("woe.moderateur"))
      					{
      						if(args.length == 1)
      						{
      							sender.sendMessage("Commande pas sous la bonne forme !");
      							sender.sendMessage("Rappel : /woe build <action>");
      						}
      						else
      						{
      							if (args[1].equalsIgnoreCase("create"))
      							{
      								if (args.length == 3)
          							{
          								plugin.Command.createCastle(args[2].toString());
          								sender.sendMessage("Vous avez créé un nouveau WOE nommé " + args[2].toString());
          							}
          							else
          							{
          								sender.sendMessage("Commande pas sous la bonne forme !");
              							sender.sendMessage("Rappel : /woe build create <name>");
          							}
      							}
      							else if (args[1].equalsIgnoreCase("setregion"))
      							{
      								if (args.length == 4)
          							{
          								plugin.Command.setRegion(args[2].toString(), args[3].toString());
          								sender.sendMessage("La région" + args[3].toString() + " a été associée au chateau WOE nommé " + args[2].toString());
          							}
          							else
          							{
          								sender.sendMessage("Commande pas sous la bonne forme !");
              							sender.sendMessage("Rappel : /woe build setregion <castle_name> <region_name>");
          							}
      							}
      							else if (args[1].equalsIgnoreCase("setcheckpoint"))
      							{
      								if (args.length == 4)
          							{
          								plugin.Command.setCheckpoint(args[2].toString(), player.getLocation());
          								sender.sendMessage("Le checkpoint a été placé");
          							}
          							else
          							{
          								sender.sendMessage("Commande pas sous la bonne forme !");
              							sender.sendMessage("Rappel : /woe build setcheckpoint <castle_name>");
          							}
      							}
      							else if (args[1].equalsIgnoreCase("settp"))
      							{
      								if (args.length == 3)
          							{
      									
      									Location loc = player.getLocation();
      									File castlePath = new File(plugin.getDataFolder() + "/castle/" + args[2].toString() + "/", args[2].toString() + ".yml");;
      									if(castlePath.exists())
      									{
      										//Set TP de l'équipe en possession
      										plugin.Command.settp(loc, args[2].toString());
      										sender.sendMessage("Zone de TP des possesseurs du chateau ajoutée !");
      									}
      									else
      										sender.sendMessage("Ce chateau n'existe pas !");
          							}
          							else
          							{
          								sender.sendMessage("Commande pas sous la bonne forme !");
              							sender.sendMessage("Rappel : /woe build settp <name_castle>");
          							}
      							}
      							else if (args[1].equalsIgnoreCase("setemperium"))
      							{
      								if (args.length == 3)
          							{
      									
      									Location loc = player.getLocation();
  		          						File castlePath = new File(plugin.getDataFolder() + "/castle/" + args[2].toString() + "/", args[2].toString() + ".yml");;
  		          						if(castlePath.exists())
  		          				        {
  		          							sender.sendMessage("Emperium créé !");
  		              						plugin.Command.setEmperium(loc, args[2].toString());
  		          				        }
  		          						else
  		          							sender.sendMessage("Ce chateau n'existe pas !");
          							}
          							else
          							{
          								sender.sendMessage("Commande pas sous la bonne forme !");
              							sender.sendMessage("Rappel : /woe build setemperium <name_castle>");
          							}
      							}
      							else if (args[1].equalsIgnoreCase("enable"))
      							{
      								if (args.length == 3)
          							{  		          							
  		          						File castlePath = new File(plugin.getDataFolder() + "/castle/" + args[2].toString() + "/", args[2].toString() + ".yml");
  		          						if(castlePath.exists())
  		          				        {
  		          							plugin.Load.reloadcastleSelectConfig(args[2].toString());
  		          							plugin.Command.castleEnable(args[2].toString(), sender);
  		          				        }
  		          						else
  		          							sender.sendMessage("Ce chateau n'existe pas !");
          							}
          							else
          							{
          								sender.sendMessage("Commande pas sous la bonne forme !");
              							sender.sendMessage("Rappel : /woe build enable <name_castle> <true/false>");
          							}
      							}
      							else
      							{
      								sender.sendMessage("Commande pas sous la bonne forme !");
          							sender.sendMessage("Rappel : action : create, settp, setregion, setemperium, enable");
      							}
      						}
      					}
      					else
      						sender.sendMessage("Vous n'avez pas les permissions nécessaires !");
      				}
      				
      				else if (args[0].equalsIgnoreCase("tp")) 
      				{
      					if(args.length == 2)
      					{
      						File castlePath = new File(plugin.getDataFolder() + "/castle/" + args[1].toString() + "/", args[1].toString() + ".yml");;
      						if(castlePath.exists())
      						{
      							//TP
      							plugin.Tp.tp(player, args[1].toString());
      						}
      						else
      							sender.sendMessage("Ce chateau n'existe pas !");
      					}
      					else
      					{
      						sender.sendMessage("Commande pas sous la bonne forme !");
      						sender.sendMessage("Rappel : /woe tp <name_castle>");
      					}		
      				}
      				
      				else if (args[0].equalsIgnoreCase("djreload")) 
      				{
      					if(args.length == 5)
      					{
      						File castlePath = new File(plugin.getDataFolder() + "/castle/" + args[1].toString() + "/", args[1].toString() + ".yml");;
      						if(castlePath.exists())
      						{
      							plugin.DjReload.setReload(args[1].toString(), args[2].toString(), args[3].toString(), args[4].toString());
      						}
      						else
      							sender.sendMessage("Ce chateau n'existe pas !");
      					}
      					else
      					{
      						sender.sendMessage("Commande pas sous la bonne forme !");
      						sender.sendMessage("Rappel : /woe djreload <name_castle> <jour> <heure> <minute>");
      					}		
      				}
      				
      				else if (args[0].equalsIgnoreCase("flag")) 
      				{
      					if(args.length == 2)
      					{
      						File castlePath = new File(plugin.getDataFolder() + "/castle/" + args[1].toString() + "/", args[1].toString() + ".yml");;
      						if(castlePath.exists())
      						{
      							plugin.Flag.setFlag(player.getLocation(), args[1].toString());
      						}
      						else
      							sender.sendMessage("Ce chateau n'existe pas !");
      					}
      					else
      					{
      						sender.sendMessage("Commande pas sous la bonne forme !");
      						sender.sendMessage("Rappel : /woe flag <name_castle>");
      					}		
      				}
      				
      				else if (args[0].equalsIgnoreCase("respawnall")) 
      				{
      					if(user.has("woe.moderateur"))
  						{
      						if(args.length == 2)
          					{
      							plugin.Tp.renvoi(args[1].toString());
      							sender.sendMessage("Tout les joueurs se trouvant dans la zone du chateau ont été renvoyé dans leur spawn !");
      						}
      						else
      						{
      							sender.sendMessage("Commande pas sous la bonne forme !");
      							sender.sendMessage("Rappel : /woe respawnall <castle_name>");
      						}
      					}
      					else
  							sender.sendMessage("Vous n'avez pas les permissions nécessaires !");
      				}
      				
      				//start
      				
      				else if (args[0].equalsIgnoreCase("start")) 
      				{
      					if(user.has("woe.animateur") || user.has("woe.moderateur"))
      					{
      						if(args.length == 3)
      						{	
      							File castlePath = new File(plugin.getDataFolder() + "/castle/" + args[1].toString() + "/event/", args[2].toString());
          						if(castlePath.exists())
          						{
          							plugin.EventLoad.reloadcastleSelectConfig(args[1].toString(), args[2].toString());
          							if(plugin.castleEtat.equals("false"))
          							{
          								
                  						sender.sendMessage("Vous avez lancé le WOE");
                  						
                  						WarOfEmperiumCarThread car = new WarOfEmperiumCarThread(plugin, args[1].toString(), plugin.ownerCastle, 1, args[2].toString());
                  						car.start();
          							}
          							else
              							sender.sendMessage("L'event est déjà en cours");
          						}
          						else
      								sender.sendMessage("Cet event n'existe pas !");
      						}
      						else
      						{
      							sender.sendMessage("Commande pas sous la bonne forme !");
      							sender.sendMessage("Rappel : /woe start <castle_name> <event_name>");
      						}

      					}
      					else
      						sender.sendMessage("Vous n'avez pas les permissions nécessaires !");
      				}
      				
      				//end
      				
      				else if (args[0].equalsIgnoreCase("autoheal")) 
      				{
      					if(user.has("woe.moderateur"))
      					{
      						if(args.length == 3)
      						{
      							File castlePath = new File(plugin.getDataFolder() + "/castle/" + args[1].toString());
          						if(castlePath.exists())
          						{
          							plugin.Load.reloadcastleSelectConfig(args[1].toString());
          							if(plugin.autoheal.equals("on"))
          							{
          								plugin.autoheal = "off";
              							plugin.Load.sauvVar(args[1].toString());
                  						sender.sendMessage("Vous avez désactivé l'autoheal");
          							}
          							else
          							{
          								plugin.autoheal = "on";
              							plugin.Load.sauvVar(args[1].toString());
                  						sender.sendMessage("Vous avez activé l'autoheal");
          							}
          						}
          						else
      								sender.sendMessage("Cet event n'existe pas !");
      						}
      						else
      						{
      							sender.sendMessage("Commande pas sous la bonne forme !");
      							sender.sendMessage("Rappel : /woe autoheal <castle_name>");
      						}
      					}
      					else
      						sender.sendMessage("Vous n'avez pas les permissions nécessaires !");
      					
      				}
      				
      				else if (args[0].equalsIgnoreCase("end")) 
      				{
      					if(user.has("woe.animateur") || user.has("woe.moderateur"))
      					{
      						if(args.length == 3)
      						{
      							File castlePath = new File(plugin.getDataFolder() + "/castle/" + args[1].toString() + "/event/", args[2].toString());
          						if(castlePath.exists())
          						{
          							plugin.EventLoad.reloadcastleSelectConfig(args[1].toString(), args[2].toString());
          							if(plugin.castleEtat.equals("true"))
          							{
          								WarOfEmperiumCarThread car = new WarOfEmperiumCarThread(plugin, args[1].toString(), plugin.ownerCastle, 0, args[2].toString());
        								car.start();
                  						sender.sendMessage("Vous avez arrété le WOE en cours");
          							}
          							else
              							sender.sendMessage("L'event n'est pas en cours");
          						}
          						else
      								sender.sendMessage("Cet event n'existe pas !");
      						}
      						else
      						{
      							sender.sendMessage("Commande pas sous la bonne forme !");
      							sender.sendMessage("Rappel : /woe end <castle_name> <event_name>");
      						}
      					}
      					else
      						sender.sendMessage("Vous n'avez pas les permissions nécessaires !");
      					
      				}
      				
      				//owner
      				
      				else if (args[0].equalsIgnoreCase("owner")) 
      				{
      					if(user.has("woe.moderateur"))
      					{
      						if(args.length == 3)
      						{	
      							if(args[2].toString().contains("g:"))
      							{
      								//Programmez un WOE

      								File repertoire = new File("plugins/WarOfEmperium/castle/" + args[1].toString());
          							if(repertoire.exists())
          							{
          								sender.sendMessage("Vous avez attribué le chateau" + args[1].toString() + " à " + args[2].toString());
                  						plugin.Load.reloadcastleSelectConfig(args[1].toString());
                  						plugin.ownerCastle = args[2].toString().replace("g:", "");
          								args[2].toString().replace("g:", "");
                  						plugin.Load.sauvVar(args[1].toString());
          							}
          							else
          								sender.sendMessage("Ce chateau n'existe pas !");
      							}
      							else
      							{
      								sender.sendMessage("Commande pas sous la bonne forme !");
          							sender.sendMessage("Rappel : /woe owner <castle_name> g:<groupe>");
      							}
      						}
      						else
      						{
      							sender.sendMessage("Commande pas sous la bonne forme !");
      							sender.sendMessage("Rappel : /woe owner <castle_name> g:<groupe>");
      						}

      					}
      					else
      						sender.sendMessage("Vous n'avez pas les permissions nécessaires !");
      				}
      				
      				else if (args[0].equalsIgnoreCase("event")) 
      				{
      					if(user.has("woe.moderateur"))
      					{
      						if(args[1].equalsIgnoreCase("set"))
      						{
      							if(args.length == 10)
      							{	
	      							try
	      							{
	      								plugin.Command.saveEvent(args[3].toString(), args[2].toString(), args[4].toString(), args[5].toString(), args[6].toString(), args[7].toString(), args[8].toString(), args[9].toString());
	      								plugin.Command.saveEvent(args[3].toString(), args[2].toString(), args[4].toString(), args[5].toString(), args[6].toString(), args[7].toString(), args[8].toString(), args[9].toString());
	      								sender.sendMessage("Event réglé");
	      					    	} 
	      							catch (Exception e)
	      							{
	      								e.printStackTrace();
	      							}
      							}
      							else
          						{
          							sender.sendMessage("Commande pas sous la bonne forme !");
          							sender.sendMessage("Rappel : /woe event set <castle_name> <event_id> <day_begin> <hour_begin> <minute_begin> <day_end> <hour_end> <minute_end>");
          						}
      						}
      						else if(args[1].equalsIgnoreCase("create"))
      						{
      							if(args.length == 4)
      							{	
	      							try
	      					    	{
	      								plugin.Command.createEvent(args[3].toString(), args[2].toString());
	      								sender.sendMessage("Event créé");
	      					    	} 
	      							catch (Exception e)
	      							{
	      								e.printStackTrace();
	      							}
      							}
      							else
          						{
          							sender.sendMessage("Commande pas sous la bonne forme !");
          							sender.sendMessage("Rappel : /woe event create <castle_name> <event_id>");
          						}
      						}
      						
      						else if(args[1].equalsIgnoreCase("enable"))
      						{
      							if(args.length == 4)
      							{	
	      							try
	      					    	{
	      								plugin.EventLoad.reloadcastleSelectConfig(args[2].toString(), args[3].toString());
	      								if(plugin.eventEnable.contains("true"))
	      								{
	      									plugin.eventEnable = "false";
	              							sender.sendMessage("Event désactivé");
	      								}
	      								else
	      								{
	      									plugin.Load.reloadcastleSelectConfig(args[2].toString());
	      									if(plugin.castleEnable.contains("true"))
	      									{
	      										plugin.eventEnable = "true";
	      										sender.sendMessage("Event activé");
	      									}
	      									else
	      									{
	      										sender.sendMessage("Le chateau n'est pas encore activé, il faut l'activer avant de pouvoir activer les events");
	      									}
	      								}
	      								plugin.EventLoad.sauvVar(args[2].toString(), args[3].toString());
	      								plugin.EventLoad.sauvVar(args[2].toString(), args[3].toString());
	      					    	} 
	      							catch (Exception e)
	      							{
	      								e.printStackTrace();
	      							}
      							}
      							else
          						{
          							sender.sendMessage("Commande pas sous la bonne forme !");
          							sender.sendMessage("Rappel : /woe event enable <castle_name> <event_id>");
          						}
      						}
      						

      					}
      					else
      						sender.sendMessage("Vous n'avez pas les permissions nécessaires !");
      				}
      				
      				
      				
      				//
      				
      				else if (args[0].equalsIgnoreCase("disowner")) 
      				{
      					if(user.has("woe.moderateur"))
      					{
      						if(args.length == 2)
  							{
      							File repertoire = new File("plugins/WarOfEmperium/castle/" + args[1].toString());
      							if(repertoire.exists())
      							{
      								sender.sendMessage("Vous avez retiré la possession de ce chateau !");
              						plugin.Load.reloadcastleSelectConfig(args[1].toString());
              						plugin.ownerCastle = "";
              						plugin.Load.sauvVar(args[1].toString());
              						plugin.getServer().broadcastMessage("Le WOE n'appartient plus à personne !");
      							}
      							else
      								sender.sendMessage("Ce chateau n'existe pas !");
  							}
      						else
      						{
      							sender.sendMessage("Commande pas sous la bonne forme !");
      							sender.sendMessage("Rappel : /woe disowner <castle_name>");
      						}
      					}
      					else
      						sender.sendMessage("Vous n'avez pas les permissions nécessaires !");
      				}
      				
      				//Portail open/close		
      				
      				else if (args[0].equalsIgnoreCase("portal")) 
      				{
      					if(user.has("woe.moderateur"))
      					{
      						if(args.length == 2)
      						{	
      							String arg = args.toString();
      							if(arg.contains("open"))
      							{
      								//Ouverture du portail
      								sender.sendMessage("Vous avez ouvert le portail");
      							}
      							else if (arg.contains("close"))
      							{
      								//Fermeture du portail
      								sender.sendMessage("Vous avez fermé le portail");
      							}
      							else
      							{
      								sender.sendMessage("Commande pas sous la bonne forme !");
          							sender.sendMessage("Rappel : /woe portal <open/close>");
      							}
      						}
      						else
      						{
      							sender.sendMessage("Commande pas sous la bonne forme !");
      							sender.sendMessage("Rappel : /woe portal <open/close>");
      						}

      					}
      					else
      						sender.sendMessage("Vous n'avez pas les permissions nécessaires !");
      				}
      				
      				//message
      				
      				else if (args[0].equalsIgnoreCase("msg")) 
      				{
      					if(user.has("woe.moderateur"))
      					{
      						//Envoie un message
      						String msg = args[1].toString();
      						woemsg(msg);
      					}
      					else
      						sender.sendMessage("Vous n'avez pas les permissions nécessaires !");
      				}
      				
      				//life
      				
      				else if (args[0].equalsIgnoreCase("life")) 
      				{
      					if(user.has("woe.moderateur"))
      					{
      						if(args.length == 3)
      						{
          						File castlePath = new File(plugin.getDataFolder() + "/castle/" + args[1].toString() + "/", args[1].toString() + ".yml");
          						if(castlePath.exists())
          						{
          							plugin.Load.reloadcastleSelectConfig(args[1].toString());
          							plugin.lifeEmp = Integer.valueOf(args[2].toString());
          							plugin.Load.sauvVar(args[1].toString());
          							sender.sendMessage("L'emperium a " + plugin.lifeEmp + " vies !");
          						}
          						else
      								sender.sendMessage("Ce chateau n'existe pas !");

      						}
      						else
      						{
      							sender.sendMessage("Commande pas sous la bonne forme !");
      							sender.sendMessage("Rappel : /woe life <castle_name> <health>");
      						}
      					}
      					else
      						sender.sendMessage("Vous n'avez pas les permissions nécessaires !");
      				}
      				
      				
      				
      				return true;
      			}
      			return false;
      		}
      		return false;
		}
		
		
		public void woemsg (String msg)
		{
			plugin.getServer().broadcastMessage(ChatColor.GOLD + "[WOE]: " + msg);
		}
}