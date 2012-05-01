package me.Darioda.WarOfEmperium;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class WarOfEmperiumCastleConfigCreate {

	File castleCreateFile;
    FileConfiguration castleCreateConfig;
    
    public static WarOfEmperium plugin;
	
	public WarOfEmperiumCastleConfigCreate(WarOfEmperium instance) {
		plugin = instance;
	}
	
	
	public void configDefaultcastleCreateConfig(String castle)
    {
    	castleCreateFile = new File(plugin.getDataFolder() + "/castle/" + castle + "/", castle + ".yml");
        if(!castleCreateFile.exists())
        {
        	castleCreateFile.getParentFile().mkdirs();
        }
        castleCreateConfig = new YamlConfiguration();
        loadConfigDefaultcastleCreateConfig();
    }  
    
    public void reloadCustomConfig() {
    	castleCreateConfig = YamlConfiguration.loadConfiguration(castleCreateFile);
    }

    
    public FileConfiguration getCustomConfig() {
        if (castleCreateConfig == null) {
            reloadCustomConfig();
        }
        return castleCreateConfig;
    }
    
    public void saveCustomConfig() {
        if (castleCreateConfig == null || castleCreateFile == null) {
        return;
        }
        try {
        	castleCreateConfig.save(castleCreateFile);
        } catch (IOException ex) {
            Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + castleCreateFile, ex);
        }
    }

    private void loadConfigDefaultcastleCreateConfig()
    {
    	castleCreateConfig = getCustomConfig();
    	castleCreateConfig.addDefault("Enable" , "");
    	
    	castleCreateConfig.addDefault("Castle.Owner" , "admin");
    	castleCreateConfig.addDefault("Castle.Region" , "");
    	castleCreateConfig.addDefault("Castle.Autoheal" , "off");
    	
    	castleCreateConfig.addDefault("Castle.TP.Coo.World" , "");
    	castleCreateConfig.addDefault("Castle.TP.Coo.X" , "");
    	castleCreateConfig.addDefault("Castle.TP.Coo.Y" , "");
    	castleCreateConfig.addDefault("Castle.TP.Coo.Z" , "");
    	
    	castleCreateConfig.addDefault("Castle.Checkpoint.Coo.World" , "");
    	castleCreateConfig.addDefault("Castle.Checkpoint.Coo.X" , "");
    	castleCreateConfig.addDefault("Castle.Checkpoint.Coo.Y" , "");
    	castleCreateConfig.addDefault("Castle.Checkpoint.Coo.Z" , "");
    	
    	castleCreateConfig.addDefault("Castle.Portail.Portail_All.Coo.Region" , "");
    	
    	castleCreateConfig.addDefault("Castle.Portail.Portail_All.Coo.Sortie.World" , "");
    	castleCreateConfig.addDefault("Castle.Portail.Portail_All.Coo.Sortie.X" , "");
    	castleCreateConfig.addDefault("Castle.Portail.Portail_All.Coo.Sortie.Y" , "");
    	castleCreateConfig.addDefault("Castle.Portail.Portail_All.Coo.Sortie.Z" , "");
    	
    	castleCreateConfig.addDefault("Castle.Portail.Portail_Grp.Coo.Region" , "");
    	
    	castleCreateConfig.addDefault("Castle.Portail.Portail_Grp.Coo.Sortie.World" , "");
    	castleCreateConfig.addDefault("Castle.Portail.Portail_Grp.Coo.Sortie.X" , "");
    	castleCreateConfig.addDefault("Castle.Portail.Portail_Grp.Coo.Sortie.Y" , "");
    	castleCreateConfig.addDefault("Castle.Portail.Portail_Grp.Coo.Sortie.Z" , "");
    	
    	castleCreateConfig.addDefault("Castle.Portail.Portail_Grp2.Coo.Region" , "");
    	
    	castleCreateConfig.addDefault("Castle.Portail.Portail_Grp2.Coo.Sortie.World" , "");
    	castleCreateConfig.addDefault("Castle.Portail.Portail_Grp2.Coo.Sortie.X" , "");
    	castleCreateConfig.addDefault("Castle.Portail.Portail_Grp2.Coo.Sortie.Y" , "");
    	castleCreateConfig.addDefault("Castle.Portail.Portail_Grp2.Coo.Sortie.Z" , "");
    	
    	castleCreateConfig.addDefault("Emperium.Life" , 7);
    	
    	castleCreateConfig.addDefault("Emperium.Coo.World" , "");
    	castleCreateConfig.addDefault("Emperium.Coo.X" , "");
    	castleCreateConfig.addDefault("Emperium.Coo.Y" , "");
    	castleCreateConfig.addDefault("Emperium.Coo.Z" , "");
    	castleCreateConfig.options().copyDefaults(true);
  	  
    	saveCustomConfig();
    	
    	plugin.castleEnable = castleCreateConfig.getString("Enable");
    	
    	plugin.ownerCastle = castleCreateConfig.getString("Castle.Owner");
    	plugin.regionCastle = castleCreateConfig.getString("Castle.Region");
    	plugin.autoheal = castleCreateConfig.getString("Castle.Autoheal");
    	
    	plugin.WorldTPStr = castleCreateConfig.getString("Castle.TP.Coo.World");
    	plugin.cooTPX = castleCreateConfig.getInt("Castle.TP.Coo.X");
    	plugin.cooTPY = castleCreateConfig.getInt("Castle.TP.Coo.Y");
    	plugin.cooTPZ = castleCreateConfig.getInt("Castle.TP.Coo.Z");
    	
    	plugin.WorldCheckpointStr = castleCreateConfig.getString("Castle.Checkpoint.Coo.World");
    	plugin.cooCheckpointX = castleCreateConfig.getInt("Castle.Checkpoint.Coo.X");
    	plugin.cooCheckpointY = castleCreateConfig.getInt("Castle.Checkpoint.Coo.Y");
    	plugin.cooCheckpointZ = castleCreateConfig.getInt("Castle.Checkpoint.Coo.Z");
    	
    	plugin.regionEntreeAll = castleCreateConfig.getString("Castle.Portail.Portail_All.Coo.Region");
    	
    	plugin.WorldPortailAllSortieStr = castleCreateConfig.getString("Castle.Portail.Portail_All.Coo.Sortie.World");
    	plugin.cooPortailAllSortieX = castleCreateConfig.getInt("Castle.Portail.Portail_All.Coo.Sortie.X");
    	plugin.cooPortailAllSortieY = castleCreateConfig.getInt("Castle.Portail.Portail_All.Coo.Sortie.Y");
    	plugin.cooPortailAllSortieZ = castleCreateConfig.getInt("Castle.Portail.Portail_All.Coo.Sortie.Z");
    	
    	plugin.regionEntreeGrp = castleCreateConfig.getString("Castle.Portail.Portail_Grp.Coo.Region");
    	
    	plugin.WorldPortailGrpSortieStr = castleCreateConfig.getString("Castle.Portail.Portail_Grp.Coo.Sortie.World");
    	plugin.cooPortailGrpSortieX = castleCreateConfig.getInt("Castle.Portail.Portail_Grp.Coo.Sortie.X");
    	plugin.cooPortailGrpSortieY = castleCreateConfig.getInt("Castle.Portail.Portail_Grp.Coo.Sortie.Y");
    	plugin.cooPortailGrpSortieZ = castleCreateConfig.getInt("Castle.Portail.Portail_Grp.Coo.Sortie.Z");
    	
    	plugin.regionEntreeGrp2 = castleCreateConfig.getString("Castle.Portail.Portail_Grp2.Coo.Region");
    	
    	plugin.WorldPortailGrpSortieStr2 = castleCreateConfig.getString("Castle.Portail.Portail_Grp2.Coo.Sortie.World");
    	plugin.cooPortailGrpSortieX2 = castleCreateConfig.getInt("Castle.Portail.Portail_Grp2.Coo.Sortie.X");
    	plugin.cooPortailGrpSortieY2 = castleCreateConfig.getInt("Castle.Portail.Portail_Grp2.Coo.Sortie.Y");
    	plugin.cooPortailGrpSortieZ2 = castleCreateConfig.getInt("Castle.Portail.Portail_Grp2.Coo.Sortie.Z");
    	
    	plugin.lifeEmp = castleCreateConfig.getInt("Emperium.Life");
    	
    	plugin.WorldStr = castleCreateConfig.getString("Emperium.Coo.World");
    	plugin.cooEmpX = castleCreateConfig.getInt("Emperium.Coo.X");
    	plugin.cooEmpY = castleCreateConfig.getInt("Emperium.Coo.Y");
    	plugin.cooEmpZ = castleCreateConfig.getInt("Emperium.Coo.Z");
    }
    
}
