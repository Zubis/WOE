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
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.ContainerBlock;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


@SuppressWarnings("deprecation")
public class WarOfEmperiumChest {

	public static WarOfEmperium plugin;
	public boolean isId = false;
	public boolean isLoc = false;
	public int liLu = 0;
	public String wor;
	public int X;
	public int Y;
	public int Z;
	public String id;
	public int id_objet;
	public int nombre_objet;
	public int chance_objet;
	public int objet_coffre;
	public File chestCreateFile;
	
	public WarOfEmperiumChest(WarOfEmperium instance) {
		plugin = instance;
	}
	
	public void createFile(String castle)
	{
		chestCreateFile = new File(plugin.getDataFolder() + "/castle/" + castle + "/chest/listechest.yml");
		if(!chestCreateFile.exists())
        {
			chestCreateFile.getParentFile().mkdir();
        	try {
        		chestCreateFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	plugin.log.info("Creation de listechest.yml");
        }
        chestCreateFile = new File(plugin.getDataFolder() + "/castle/" + castle + "/chest/config.yml");
        if(!chestCreateFile.exists())
        {
			chestCreateFile.getParentFile().mkdir();
        	try {
        		chestCreateFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	plugin.log.info("Creation de config.yml");
        }
	}
	
	public void viderCoffre(String castle)
	{
		@SuppressWarnings("unused")
		String chaine = "";
		String fichier = ("plugins/WarOfEmperium/castle/" + castle + "/chest/listechest.yml");
		
		try{
			InputStream ips = new FileInputStream(fichier); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null){
				if(ligne.contentEquals("chest"))
				{
					isLoc = true;
					ligne = br.readLine();
					objet_coffre = 0;
				}
				if(isLoc)
				{
					chaine += ligne + "\n";
					liLu = liLu + 1;
					if(liLu == 1)
					{
						X = Integer.valueOf(ligne);
					}
					else if(liLu == 2)
					{
						Y = Integer.valueOf(ligne);
					}
					else if(liLu == 3)
					{
						Z = Integer.valueOf(ligne);
					}
					else if(liLu == 4)
					{
						id = ligne;
					}
					else if(liLu == 5)
					{
						wor = ligne;
						isLoc = false;
						World world = Bukkit.getWorld(wor);
						Block block = world.getBlockAt(X, Y, Z);
						if(block.getState() instanceof ContainerBlock)
						{
							ContainerBlock coffre = (ContainerBlock)block.getState();
							Inventory inv = coffre.getInventory();
							inv.clear();
						}
						liLu = 0;
					}
					
				}
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void creerCoffre(String castle)
	{
		@SuppressWarnings("unused")
		String chaine = "";
		String fichier = ("plugins/WarOfEmperium/castle/" + castle + "/chest/listechest.yml");
		
		try{
			InputStream ips = new FileInputStream(fichier); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null){
				if(ligne.contentEquals("chest"))
				{
					isLoc = true;
					ligne = br.readLine();
					objet_coffre = 0;
				}
				if(isLoc)
				{
					chaine += ligne + "\n";
					liLu = liLu + 1;
					if(liLu == 1)
					{
						X = Integer.valueOf(ligne);
					}
					else if(liLu == 2)
					{
						Y = Integer.valueOf(ligne);
					}
					else if(liLu == 3)
					{
						Z = Integer.valueOf(ligne);
					}
					else if(liLu == 4)
					{
						id = ligne;
					}
					else if(liLu == 5)
					{
						wor = ligne;
						isLoc = false;
						World world = Bukkit.getWorld(wor);
						Block block = world.getBlockAt(X, Y, Z);
						creer_supprCoffre(block, false);
						creer_supprCoffre(block, true);
						remplir(castle, block, id);
						liLu = 0;
					}
					
				}
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void creer_supprCoffre(Block block, boolean set)
	{		
		if(set == true)
			block.setTypeId(54);
		else
		{
			if(block.getState() instanceof ContainerBlock)
			{
				ContainerBlock coffre = (ContainerBlock)block.getState();
				Inventory inv = coffre.getInventory();
				inv.clear();
				block.setTypeId(0);
			}
		}
	}
	
	public void remplir(String castle, Block block, String id)
	{
		@SuppressWarnings("unused")
		String chaine = "";
		String fichier = ("plugins/WarOfEmperium/castle/" + castle + "/chest/config.yml");
		
		try{
			InputStream ips = new FileInputStream(fichier); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			liLu = 0;
			while ((ligne = br.readLine()) != null){
				liLu = liLu + 1;
				if(ligne.contentEquals(id))
				{
					isId = true;
					ligne = br.readLine();
					liLu = 1;
					objet_coffre = objet_coffre + 1;
				}
				if(isId)
				{
					chaine += ligne + "\n";
					if(liLu == 1)
					{
						id_objet = Integer.valueOf(ligne);
					}
					else if(liLu == 2)
					{
						nombre_objet = Integer.valueOf(ligne);
					}
					else if(liLu == 3)
					{
						chance_objet = Integer.valueOf(ligne);
						isId = false;
						if(objet_coffre <= 5)
							remplirCoffre(block, id_objet, chance_objet, nombre_objet);
						liLu = 0;
					}
					
				}
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	
	public void remplirCoffre(Block block, int id, int chance, int nombre)
	{
		if(block.getState() instanceof ContainerBlock)
		{
			ContainerBlock coffre = (ContainerBlock)block.getState();
			Inventory inv = coffre.getInventory();
			int nombreAleatoire = (int) (Math.random()*100);
			if(nombreAleatoire <= chance)
			{
				ItemStack is = new ItemStack(id, nombre);
				inv.addItem(is);
			}
		}
	}
	
	public void addCoffre(String castle, String world, int cooX, int cooY, int cooZ, String id)
	{
		try {
			String fichier = ("plugins/WarOfEmperium/castle/" + castle + "/chest/listechest.yml");
			FileWriter fw = new FileWriter(fichier, true);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw); 
				fichierSortie.println("chest\n" + String.valueOf(cooX) + "\n" + String.valueOf(cooY) + "\n" + String.valueOf(cooZ) + "\n" + id + "\n" + world); 
			fichierSortie.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void addItem(String castle, String name_id, int id_item, int nombre, int chance)
	{
		try {
			String fichier = ("plugins/WarOfEmperium/castle/" + castle + "/chest/config.yml");
			FileWriter fw = new FileWriter(fichier, true);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw); 
				fichierSortie.println(name_id + "\n" + id_item + "\n" + String.valueOf(nombre) + "\n" + String.valueOf(chance)); 
			fichierSortie.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
}
