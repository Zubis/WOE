package me.Darioda.WarOfEmperium;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

import com.earth2me.essentials.spawn.EssentialsSpawn;

public class WarOfEmperiumSpawn {

	private WarOfEmperium plugin;
    
	public WarOfEmperiumSpawn(WarOfEmperium plugin) {
		this.plugin = plugin;
	}
	
	EssentialsSpawn getEssentialsSpawn() {
	    Plugin plugin1 = plugin.getServer().getPluginManager().getPlugin("EssentialsSpawn");
	 
	    if (plugin1 == null || !(plugin1 instanceof EssentialsSpawn)) {
	        return null;
	    }
	 
	    return (EssentialsSpawn) plugin1;
	}
	
	public Location spawnDefault()
	{
		@SuppressWarnings("unused")
		String wor, chaine = "";
		int X, Y, Z;
		float X_float, Y_float, Z_float;
		String fichier = ("plugins/Essentials/spawn.yml");
		
		try{
			InputStream ips = new FileInputStream(fichier); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null){
				if(ligne.contentEquals("  default: "))
				{
					ligne = br.readLine();
					chaine += ligne + "\n";
					wor = ligne.replace("    world: ", "");
					ligne = br.readLine();
					X_float = Float.valueOf((ligne.replace("    x: ", "")));
					X = Math.round(X_float);
					ligne = br.readLine();
					Y_float = Float.valueOf(ligne.replace("    y: ", ""));
					Y = Math.round(Y_float);
					ligne = br.readLine();
					Z_float = Float.valueOf(ligne.replace("    z: ", ""));
					Z = Math.round(Z_float);
    				World world = Bukkit.getWorld(wor);
    				Location spawn = new Location(world, X, Y, Z);
    				return spawn;
				}	
			}
			
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		return null;
	}
	
	public Location spawn(String grp)
	{
		@SuppressWarnings("unused")
		String wor, chaine = "";
		int X, Y, Z;
		float X_float, Y_float, Z_float;
		String fichier = ("plugins/Essentials/spawn.yml");
		
		try{
			InputStream ips = new FileInputStream(fichier); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null){
				if(ligne.contentEquals("  " + grp + ": "))
				{
					ligne = br.readLine();
					chaine += ligne + "\n";
					wor = ligne.replace("    world: ", "");
					ligne = br.readLine();
					X_float = Float.valueOf((ligne.replace("    x: ", "")));
					X = Math.round(X_float);
					ligne = br.readLine();
					Y_float = Float.valueOf(ligne.replace("    y: ", ""));
					Y = Math.round(Y_float);
					ligne = br.readLine();
					Z_float = Float.valueOf(ligne.replace("    z: ", ""));
					Z = Math.round(Z_float);
    				World world = Bukkit.getWorld(wor);
    				Location spawn = new Location(world, X, Y, Z);
    				return spawn;
				}	
			}
			
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		return null;
	}
	
}
