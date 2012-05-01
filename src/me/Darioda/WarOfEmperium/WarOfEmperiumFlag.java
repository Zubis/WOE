package me.Darioda.WarOfEmperium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.Wool;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class WarOfEmperiumFlag {

	private WarOfEmperium plugin;
	public File flagCreateFile;
    
	public WarOfEmperiumFlag(WarOfEmperium plugin) {
		this.plugin = plugin;
	}
	
	public void createFlag(String castle)
	{
		flagCreateFile = new File(plugin.getDataFolder() + "/castle/" + castle + "/flag.yml");
		if(!flagCreateFile.exists())
        {
			flagCreateFile.getParentFile().mkdir();
        	try {
        		flagCreateFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	plugin.log.info("Creation de flag.yml");
        }
	}
	
	public void setFlag(Location loc, String castle)
	{
		try {
			String fichier = ("plugins/WarOfEmperium/castle/" + castle + "/flag.yml");
			FileWriter fw = new FileWriter(fichier, true);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw); 
				fichierSortie.println("Flag\n" + loc.getBlockX() + "\n" + loc.getBlockY() + "\n" + loc.getBlockZ() + "\n" + loc.getWorld().getName()); 
			fichierSortie.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	@SuppressWarnings("unused")
	public void remplaceBloc(String castle, String grp)
	{
		DyeColor color = DyeColor.WHITE;
		if(grp.contentEquals("Eares"))
			color = DyeColor.YELLOW;
		else if(grp.contentEquals("Heloptes"))
			color = DyeColor.LIGHT_BLUE;
		else if(grp.contentEquals("Sangdragon"))
			color = DyeColor.PURPLE;
		else if(grp.contentEquals("Shinrin"))
			color = DyeColor.GREEN;
		
		Block block;
		String chaine = "";
		try{
			InputStream ips = new FileInputStream(plugin.getDataFolder() + "/castle/" + castle + "/flag.yml"); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne, wor;
			int X, Y, Z;
			while ((ligne = br.readLine()) != null){
				if(ligne.contains("Flag"))
				{
					ligne = br.readLine();
					chaine += ligne + "\n";
					X = Integer.valueOf(ligne);
					ligne = br.readLine();
					Y = Integer.valueOf(ligne);
					ligne = br.readLine();
					Z = Integer.valueOf(ligne);
					ligne = br.readLine();
					wor = ligne;
					World world = Bukkit.getWorld(wor);
					block = world.getBlockAt(X, Y, Z);
					block.setTypeId(35);
					BlockState bs = block.getState();
					Wool block_laine = (Wool)bs.getData();
					block_laine.setColor(color);
					bs.update();
				}
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
	}
	
	WorldEditPlugin getWorldEdit() {
	    Plugin plugin1 = plugin.getServer().getPluginManager().getPlugin("WorldEdit");
	 
	    if (plugin1 == null || !(plugin1 instanceof WorldGuardPlugin)) {
	        return null;
	    }
	 
	    return (WorldEditPlugin) plugin1;
	}
}
