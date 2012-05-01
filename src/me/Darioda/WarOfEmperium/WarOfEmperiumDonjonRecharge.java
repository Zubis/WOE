package me.Darioda.WarOfEmperium;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WarOfEmperiumDonjonRecharge {

	private WarOfEmperium plugin;
	public File djCreateFile;
	
	public WarOfEmperiumDonjonRecharge(WarOfEmperium instance) {
		plugin = instance;
	}
	
	public void createDonjonRecharge(String castle)
	{
		djCreateFile = new File(plugin.getDataFolder() + "/castle/" + castle + "/donjonreload.yml");
		if(!djCreateFile.exists())
        {
			djCreateFile.getParentFile().mkdir();
        	try {
        		djCreateFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	plugin.log.info("Creation de donjonreload.yml");
        }
	}
	
	public void setReload(String castle, String jour, String heure, String minute)
	{
		try {
			String fichier = ("plugins/WarOfEmperium/castle/" + castle + "/donjonreload.yml");
			FileWriter fw = new FileWriter(fichier, true);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw); 
				fichierSortie.println("Reload\n" + jour + "\n" + heure + "\n" + minute); 
			fichierSortie.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
}
