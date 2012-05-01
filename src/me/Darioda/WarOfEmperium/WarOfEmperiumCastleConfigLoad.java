package me.Darioda.WarOfEmperium;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class WarOfEmperiumCastleConfigLoad {
	
	private FileConfiguration castleSelect = null;
	private File castleSelectFile = null;
	
	
	public static WarOfEmperium plugin;
	
	public WarOfEmperiumCastleConfigLoad(WarOfEmperium instance) {
		plugin = instance;
	}
	
	public void reloadcastleSelectConfig(String castle) {
        castleSelectFile = new File(plugin.getDataFolder() + "/castle/" + castle + "/", castle + ".yml");
        castleSelect = YamlConfiguration.loadConfiguration(castleSelectFile);
     
        chargementVar(castle);
    }
    
    public FileConfiguration getcastleSelectConfig(String castle) {
        if (castleSelect == null) {
            reloadcastleSelectConfig(castle);
        }
        return castleSelect;
    }

    public void savecastleSelectConfig(String castle) {
        if (castleSelect == null || castleSelectFile == null) {
        return;
        }
        try {
        	castleSelect.save(new File(plugin.getDataFolder() + "/castle/" + castle + "/", castle + ".yml"));
        } catch (IOException ex) {
            Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + castleSelectFile, ex);
        }
    }
    
    public void chargementVar(String castle)
    {
    	castleSelect = getcastleSelectConfig(castle);
    	castleSelect.addDefault("Enable" , "");
    	castleSelect.addDefault("Castle.Owner" , "");
    	castleSelect.addDefault("Castle.Region" , "");
    	castleSelect.addDefault("Castle.Autoheal" , "");
    	
    	castleSelect.addDefault("Castle.TP.Coo.World" , "");
    	castleSelect.addDefault("Castle.TP.Coo.X" , "");
    	castleSelect.addDefault("Castle.TP.Coo.Y" , "");
    	castleSelect.addDefault("Castle.TP.Coo.Z" , "");
    	
    	castleSelect.addDefault("Castle.Portail.Portail_All.Coo.Region" , "");
    	
    	castleSelect.addDefault("Castle.Portail.Portail_All.Coo.Sortie.World" , "");
       	castleSelect.addDefault("Castle.Portail.Portail_All.Coo.Sortie.X" , "");
    	castleSelect.addDefault("Castle.Portail.Portail_All.Coo.Sortie.Y" , "");
    	castleSelect.addDefault("Castle.Portail.Portail_All.Coo.Sortie.Z" , "");
    	
    	castleSelect.addDefault("Castle.Portail.Portail_Grp.Coo.Region" , "");
    	
    	castleSelect.addDefault("Castle.Portail.Portail_Grp.Coo.Sortie.World" , "");
       	castleSelect.addDefault("Castle.Portail.Portail_Grp.Coo.Sortie.X" , "");
    	castleSelect.addDefault("Castle.Portail.Portail_Grp.Coo.Sortie.Y" , "");
    	castleSelect.addDefault("Castle.Portail.Portail_Grp.Coo.Sortie.Z" , "");
    	
    	castleSelect.addDefault("Emperium.Life" , "");
    	castleSelect.addDefault("Emperium.Coo.World" , "");
    	castleSelect.addDefault("Emperium.Coo.X" , "");
    	castleSelect.addDefault("Emperium.Coo.Y" , "");
    	castleSelect.addDefault("Emperium.Coo.Z" , "");
    	castleSelect.options().copyDefaults(false);
  	  	
    	plugin.castleEnable = castleSelect.getString("Enable");
    	
    	plugin.ownerCastle = castleSelect.getString("Castle.Owner");
    	plugin.regionCastle = castleSelect.getString("Castle.Region");
    	plugin.autoheal = castleSelect.getString("Castle.Autoheal");
    	
    	plugin.WorldTPStr = castleSelect.getString("Castle.TP.Coo.World");
    	plugin.cooTPX = castleSelect.getInt("Castle.TP.Coo.X");
    	plugin.cooTPY = castleSelect.getInt("Castle.TP.Coo.Y");
    	plugin.cooTPZ = castleSelect.getInt("Castle.TP.Coo.Z");
    	
    	plugin.WorldCheckpointStr = castleSelect.getString("Castle.Checkpoint.Coo.World");
    	plugin.cooCheckpointX = castleSelect.getInt("Castle.Checkpoint.Coo.X");
    	plugin.cooCheckpointY = castleSelect.getInt("Castle.Checkpoint.Coo.Y");
    	plugin.cooCheckpointZ = castleSelect.getInt("Castle.Checkpoint.Coo.Z");
    	
    	plugin.regionEntreeAll = castleSelect.getString("Castle.Portail.Portail_All.Coo.Region");
    	
    	plugin.WorldPortailAllSortieStr = castleSelect.getString("Castle.Portail.Portail_All.Coo.Sortie.World");
    	plugin.cooPortailAllSortieX = castleSelect.getInt("Castle.Portail.Portail_All.Coo.Sortie.X");
    	plugin.cooPortailAllSortieY = castleSelect.getInt("Castle.Portail.Portail_All.Coo.Sortie.Y");
    	plugin.cooPortailAllSortieZ = castleSelect.getInt("Castle.Portail.Portail_All.Coo.Sortie.Z");
    	
    	plugin.regionEntreeGrp = castleSelect.getString("Castle.Portail.Portail_Grp.Coo.Region");
    	
    	plugin.WorldPortailGrpSortieStr = castleSelect.getString("Castle.Portail.Portail_Grp.Coo.Sortie.World");
    	plugin.cooPortailGrpSortieX = castleSelect.getInt("Castle.Portail.Portail_Grp.Coo.Sortie.X");
    	plugin.cooPortailGrpSortieY = castleSelect.getInt("Castle.Portail.Portail_Grp.Coo.Sortie.Y");
    	plugin.cooPortailGrpSortieZ = castleSelect.getInt("Castle.Portail.Portail_Grp.Coo.Sortie.Z");
    	
    	plugin.regionEntreeGrp2 = castleSelect.getString("Castle.Portail.Portail_Grp2.Coo.Region");
    	
    	plugin.WorldPortailGrpSortieStr2 = castleSelect.getString("Castle.Portail.Portail_Grp2.Coo.Sortie.World");
    	plugin.cooPortailGrpSortieX2 = castleSelect.getInt("Castle.Portail.Portail_Grp2.Coo.Sortie.X");
    	plugin.cooPortailGrpSortieY2 = castleSelect.getInt("Castle.Portail.Portail_Grp2.Coo.Sortie.Y");
    	plugin.cooPortailGrpSortieZ2 = castleSelect.getInt("Castle.Portail.Portail_Grp2.Coo.Sortie.Z");
    	
    	plugin.lifeEmp = castleSelect.getInt("Emperium.Life");
    	
    	plugin.WorldStr = castleSelect.getString("Emperium.Coo.World");
    	plugin.cooEmpX = castleSelect.getInt("Emperium.Coo.X");
    	plugin.cooEmpY = castleSelect.getInt("Emperium.Coo.Y");
    	plugin.cooEmpZ = castleSelect.getInt("Emperium.Coo.Z");
    }
   
    public void sauvVar(String castle)
    {    
    	castleSelect = getcastleSelectConfig(castle);
    	castleSelect.set("Enable", plugin.castleEnable);
    	
    	castleSelect.set("Castle.Owner" , plugin.ownerCastle);
    	castleSelect.set("Castle.Region" , plugin.regionCastle);
    	castleSelect.set("Castle.Autoheal" , plugin.autoheal);
    	
    	castleSelect.set("Castle.TP.Coo.World" , plugin.WorldTPStr);
    	castleSelect.set("Castle.TP.Coo.X" , plugin.cooTPX);
    	castleSelect.set("Castle.TP.Coo.Y" , plugin.cooTPY);
    	castleSelect.set("Castle.TP.Coo.Z" , plugin.cooTPZ);
    	
    	castleSelect.set("Castle.Checkpoint.Coo.World" , plugin.WorldCheckpointStr);
    	castleSelect.set("Castle.Checkpoint.Coo.X" , plugin.cooCheckpointX);
    	castleSelect.set("Castle.Checkpoint.Coo.Y" , plugin.cooCheckpointY);
    	castleSelect.set("Castle.Checkpoint.Coo.Z" , plugin.cooCheckpointZ);
    	
    	castleSelect.set("Castle.Portail.Portail_All.Coo.Region" , plugin.regionEntreeAll);
    	
    	castleSelect.set("Castle.Portail.Portail_All.Coo.Sortie.World" , plugin.WorldPortailAllSortieStr);
    	castleSelect.set("Castle.Portail.Portail_All.Coo.Sortie.X" , plugin.cooPortailAllSortieX);
    	castleSelect.set("Castle.Portail.Portail_All.Coo.Sortie.Y" , plugin.cooPortailAllSortieY);
    	castleSelect.set("Castle.Portail.Portail_All.Coo.Sortie.Z" , plugin.cooPortailAllSortieZ);
    	
    	castleSelect.set("Castle.Portail.Portail_Grp.Coo.Region" , plugin.regionEntreeGrp);
    	
    	castleSelect.set("Castle.Portail.Portail_Grp.Coo.Sortie.World" , plugin.WorldPortailGrpSortieStr);
    	castleSelect.set("Castle.Portail.Portail_Grp.Coo.Sortie.X" , plugin.cooPortailGrpSortieX);
    	castleSelect.set("Castle.Portail.Portail_Grp.Coo.Sortie.Y" , plugin.cooPortailGrpSortieY);
    	castleSelect.set("Castle.Portail.Portail_Grp.Coo.Sortie.Z" , plugin.cooPortailGrpSortieZ);
    	
    	castleSelect.set("Castle.Portail.Portail_Grp2.Coo.Region" , plugin.regionEntreeGrp2);
    	
    	castleSelect.set("Castle.Portail.Portail_Grp2.Coo.Sortie.World" , plugin.WorldPortailGrpSortieStr2);
    	castleSelect.set("Castle.Portail.Portail_Grp2.Coo.Sortie.X" , plugin.cooPortailGrpSortieX2);
    	castleSelect.set("Castle.Portail.Portail_Grp2.Coo.Sortie.Y" , plugin.cooPortailGrpSortieY2);
    	castleSelect.set("Castle.Portail.Portail_Grp2.Coo.Sortie.Z" , plugin.cooPortailGrpSortieZ2);
    	
    	castleSelect.set("Emperium.Life" , plugin.lifeEmp);
    	
    	castleSelect.set("Emperium.Coo.World" , plugin.WorldStr);
    	castleSelect.set("Emperium.Coo.X" , plugin.cooEmpX);
    	castleSelect.set("Emperium.Coo.Y" , plugin.cooEmpY);
    	castleSelect.set("Emperium.Coo.Z" , plugin.cooEmpZ);
    	savecastleSelectConfig(castle);
    }

}
