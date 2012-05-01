package me.Darioda.WarOfEmperium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class WarOfEmperium extends JavaPlugin {
	
	Logger log = Logger.getLogger("Minecraft");
    
	public boolean woe = false;
	
	public String woe_str;
	public String woe_evt;
	public String castleEnable;
	public String eventEnable;
	public String castleEtat;
	public String eventJourDebut = "debug";
	public String eventHeureDebut;
	public String eventMinuteDebut;
	public String eventJourFin = "debug";
	public String eventHeureFin;
	public String eventMinuteFin;
	public String WorldTPStr;
	public String WorldCheckpointStr;
	public String WorldStr;
	public String ownerCastle;
	public String regionCastle;
	public String regionEntreeAll;
	public String regionEntreeGrp;
	public String regionEntreeGrp2;
	public String WorldPortailGrpSortieStr;
	public String WorldPortailGrpSortieStr2;
	public String WorldPortailAllSortieStr;
	public String flagRegion;
	public String autoheal;
	
	public int woe_h;
	public int woe_m;
	public int h;
	public int m;
	public int lifeEmp;
	public int cooEmpX;
	public int cooEmpY;
	public int cooEmpZ;
	public int cooBackX;
	public int cooBackY;
	public int cooBackZ;
	public int cooTPX;
	public int cooTPY;
	public int cooTPZ;
	public int cooCheckpointX;
	public int cooCheckpointY;
	public int cooCheckpointZ;
	public int cooPortailGrpSortieX;
	public int cooPortailGrpSortieX2;
	public int cooPortailAllSortieX;
	public int minute;
	public int seconde;
	public int cooPortailGrpSortieY;
	public int cooPortailGrpSortieY2;
	public int cooPortailAllSortieY;
	public int cooPortailGrpSortieZ;
	public int cooPortailGrpSortieZ2;
	public int cooPortailAllSortieZ;

	public void onEnable()
    { 
	    Executor = new WarOfEmperiumCommandExecutor(this);
    	getCommand("woe").setExecutor(Executor);
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(PlayerListener, this);
        pm.registerEvents(BlockListener,  this);
        setupPermissions();
        
        time.start();
    }
	 
	@SuppressWarnings("deprecation")
	public void onDisable()
	{ 
		time.stop();
	}
	
	private void setupPermissions() 
	{
        Plugin test = this.getServer().getPluginManager().getPlugin("PermissionsEx");

        if (test == null) {
        	this.setEnabled(false);
            log.info("[WOE]Permission system not detected, WOE disable !");
        }
        
    }

	public void thread(String jour, int heure, int minute)
	{
		String [] listefichiers;
		h = heure;
		m = minute;
		File repertoire = new File("plugins/WarOfEmperium/castle/");
		if(repertoire.exists())
		{
			listefichiers = repertoire.list();
		
			for(int i = 0; i < listefichiers.length; i++)
			{
				String [] listefichiers2;
				File repertoire2 = new File("plugins/WarOfEmperium/castle/" + listefichiers[i].toString()  + "/event/");
				listefichiers2 = repertoire2.list();
				if(repertoire2.exists())
				{
					for(int j = 0; j < listefichiers2.length; j++)
					{
						EventLoad.reloadcastleSelectConfig(listefichiers[i].toString(), listefichiers2[j].toString());
						if(eventEnable.equals("true"))
						{
							if((jour.equals(eventJourDebut)) && (String.valueOf(heure).equals(String.valueOf(eventHeureDebut))) && (String.valueOf(minute).equals(String.valueOf(Integer.valueOf(eventMinuteDebut)))))
							{
								 WarOfEmperiumCarThread car = new WarOfEmperiumCarThread(this, listefichiers[i].toString(), ownerCastle, 1, listefichiers2[j].toString());
								 car.start();
							}
		
							if((jour.equals(eventJourDebut)) && (String.valueOf(heure).equals(String.valueOf(eventHeureDebut))) && (String.valueOf(minute).equals(String.valueOf(Integer.valueOf(eventMinuteDebut) - 10))))
							{
								getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] Début de la War of Emperium du chateau " + listefichiers[i].toString() + " dans 10 minutes !");
							}
		
							if((jour.equals(eventJourDebut)) && (String.valueOf(heure).equals(String.valueOf(eventHeureDebut))) && (String.valueOf(minute).equals(String.valueOf(Integer.valueOf(eventMinuteDebut) - 5))))
							{
								getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] Début de la War of Emperium du chateau " + listefichiers[i].toString() + " dans 5 minutes !");
							}
		
							if((jour.equals(eventJourDebut)) && (String.valueOf(heure).equals(String.valueOf(eventHeureDebut))) && (String.valueOf(minute).equals(String.valueOf(Integer.valueOf(eventMinuteDebut) - 1))))
							{
								getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] Début de la War of Emperium du chateau " + listefichiers[i].toString() + " dans 1 minutes !");
							}
					
							if((jour.equals(eventJourFin)) && (String.valueOf(heure).equals(String.valueOf(eventHeureFin))) && (String.valueOf(minute).equals(String.valueOf(Integer.valueOf(eventMinuteFin)))))
							{
								WarOfEmperiumCarThread car = new WarOfEmperiumCarThread(this, listefichiers[i].toString(), ownerCastle, 0, listefichiers2[j].toString());
								car.start();
							}
						
							if((jour.equals(eventJourFin)) && (String.valueOf(heure).equals(String.valueOf(eventHeureFin))) && (String.valueOf(minute).equals(String.valueOf(Integer.valueOf(eventMinuteFin) - 10))))
							{
								getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] Fin de la War of Emperium du chateau " + listefichiers[i].toString() + " dans 10 minutes !");
							}
		
							if((jour.equals(eventJourFin)) && (String.valueOf(heure).equals(String.valueOf(eventHeureFin))) && (String.valueOf(minute).equals(String.valueOf(Integer.valueOf(eventMinuteFin) - 5))))
							{
								getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] Fin de la War of Emperium du chateau " + listefichiers[i].toString() + " dans 5 minutes !");
							}
						
							if((jour.equals(eventJourFin)) && (String.valueOf(heure).equals(String.valueOf(eventHeureFin))) && (String.valueOf(minute).equals(String.valueOf(Integer.valueOf(eventMinuteFin) - 1))))
							{
								getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "WOE" + ChatColor.GOLD + "] Fin de la War of Emperium du chateau " + listefichiers[i].toString() + " dans 1 minutes !");
							}
						}
					}	
				}
			}
		}
	}
	
	@SuppressWarnings("unused")
	public void reloadDj(String jour, String heure, String minute)
	{
		String [] listefichiers;
		File repertoire = new File("plugins/WarOfEmperium/castle/");
		if(repertoire.exists())
		{
			listefichiers = repertoire.list();
		
			for(int i = 0; i < listefichiers.length; i++)
			{
				File repertoire2 = new File(getDataFolder() + "/castle/" + listefichiers[i].toString() + "/donjonreload.yml");
				if(repertoire2.exists())
				{
					String chaine = "";
					try{
						InputStream ips = new FileInputStream(getDataFolder() + "/castle/" + listefichiers[i].toString() + "/donjonreload.yml"); 
						InputStreamReader ipsr = new InputStreamReader(ips);
						BufferedReader br = new BufferedReader(ipsr);
						String ligne, h, m, j;
						while ((ligne = br.readLine()) != null){
							if(ligne.contains("Reload"))
							{
								ligne = br.readLine();
								chaine += ligne + "\n";
								j = ligne;
								ligne = br.readLine();
								h = ligne;
								ligne = br.readLine();
								m = ligne;
								if((jour.equals(j)) && (heure.equals(h)) && (minute.equals(m)))
								{
									Chest.creerCoffre(listefichiers[i].toString());
								}
							}
						}
						br.close(); 
					}		
					catch (Exception e){
						System.out.println(e.toString());
					}
				}
			}
		}
	}
	
	public void generateEmperium(String castle, boolean set)
	{
		Load.reloadcastleSelectConfig(castle);
		World world = Bukkit.getWorld(WorldStr);
		if(set == true)
		{
			Block blockToChange = world.getBlockAt(cooEmpX,cooEmpY,cooEmpZ);
			blockToChange.setTypeId(89);
			Block blockToChange2 = world.getBlockAt(cooEmpX+1,cooEmpY,cooEmpZ);
			blockToChange2.setTypeId(89);
			Block blockToChange3 = world.getBlockAt(cooEmpX-1,cooEmpY,cooEmpZ);
			blockToChange3.setTypeId(89);
			Block blockToChange4 = world.getBlockAt(cooEmpX,cooEmpY+1,cooEmpZ);
			blockToChange4.setTypeId(89);
			Block blockToChange5 = world.getBlockAt(cooEmpX,cooEmpY-1,cooEmpZ);
			blockToChange5.setTypeId(89);
			Block blockToChange6 = world.getBlockAt(cooEmpX,cooEmpY,cooEmpZ+1);
			blockToChange6.setTypeId(89);
			Block blockToChange7 = world.getBlockAt(cooEmpX,cooEmpY,cooEmpZ-1);
			blockToChange7.setTypeId(89);
		}
		else
		{
			Block blockToChange = world.getBlockAt(cooEmpX,cooEmpY,cooEmpZ);
			blockToChange.setTypeId(0);
			Block blockToChange2 = world.getBlockAt(cooEmpX+1,cooEmpY,cooEmpZ);
			blockToChange2.setTypeId(0);
			Block blockToChange3 = world.getBlockAt(cooEmpX-1,cooEmpY,cooEmpZ);
			blockToChange3.setTypeId(0);
			Block blockToChange4 = world.getBlockAt(cooEmpX,cooEmpY+1,cooEmpZ);
			blockToChange4.setTypeId(0);
			Block blockToChange5 = world.getBlockAt(cooEmpX,cooEmpY-1,cooEmpZ);
			blockToChange5.setTypeId(0);
			Block blockToChange6 = world.getBlockAt(cooEmpX,cooEmpY,cooEmpZ+1);
			blockToChange6.setTypeId(0);
			Block blockToChange7 = world.getBlockAt(cooEmpX,cooEmpY,cooEmpZ-1);
			blockToChange7.setTypeId(0);
		}
	}

	public final WarOfEmperiumPlayerListener PlayerListener = new WarOfEmperiumPlayerListener(this);
	public final WarOfEmperiumBlockListener BlockListener = new WarOfEmperiumBlockListener(this);
	public final WarOfEmperiumCastleConfigCreate Create = new WarOfEmperiumCastleConfigCreate(this);
	public final WarOfEmperiumEventConfigCreate EventCreate = new WarOfEmperiumEventConfigCreate(this);
	public final WarOfEmperiumEventConfigLoad EventLoad = new WarOfEmperiumEventConfigLoad(this);
	public final WarOfEmperiumCastleConfigLoad Load = new WarOfEmperiumCastleConfigLoad(this);
	public final WarOfEmperiumChest Chest = new WarOfEmperiumChest(this);
	public final WarOfEmperiumRegion Region = new WarOfEmperiumRegion(this);
	public final WarOfEmperiumSpawn Spawn = new WarOfEmperiumSpawn(this);
	public final WarOfEmperiumPermissions Permissions = new WarOfEmperiumPermissions(this);
	public final WarOfEmperiumCommand Command = new WarOfEmperiumCommand(this);
	public final WarOfEmperiumTp Tp = new WarOfEmperiumTp(this);
	public final WarOfEmperiumFlag Flag = new WarOfEmperiumFlag(this);
	public final WarOfEmperiumDonjonRecharge DjReload = new WarOfEmperiumDonjonRecharge(this);
	public final WarOfEmperiumUm Um = new WarOfEmperiumUm(this);
	private WarOfEmperiumCommandExecutor Executor;
    WarOfEmperiumTimeThread time = new WarOfEmperiumTimeThread(this);



}
