package me.Darioda.WarOfEmperium;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class WarOfEmperiumEventConfigCreate {

	
	File eventCreateFile;
    FileConfiguration eventCreateConfig;
    
    public static WarOfEmperium plugin;
	
	public WarOfEmperiumEventConfigCreate(WarOfEmperium instance) {
		plugin = instance;
	}
	
	
	public void configDefaultcastleCreateConfig(String castle, String event_id)
    {
		eventCreateFile = new File(plugin.getDataFolder() + "/castle/" + castle + "/event/", event_id);
        if(!eventCreateFile.exists())
        {
        	eventCreateFile.getParentFile().mkdirs();
        }
        eventCreateConfig = new YamlConfiguration();
        loadConfigDefaultcastleCreateConfig();
    }  
    
    public void reloadCustomConfig() {
    	eventCreateConfig = YamlConfiguration.loadConfiguration(eventCreateFile);
    }

    
    public FileConfiguration getCustomConfig() {
        if (eventCreateConfig == null) {
            reloadCustomConfig();
        }
        return eventCreateConfig;
    }
    
    public void saveCustomConfig() {
        if (eventCreateConfig == null || eventCreateFile == null) {
        return;
        }
        try {
        	eventCreateConfig.save(eventCreateFile);
        } catch (IOException ex) {
            Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + eventCreateFile, ex);
        }
    }

    private void loadConfigDefaultcastleCreateConfig()
    {
    	eventCreateConfig = getCustomConfig();
    	eventCreateConfig.addDefault("Enable" , "false");
    	eventCreateConfig.addDefault("Etat" , "off");
    	eventCreateConfig.addDefault("Event.Date.Debut.Jour" , "debug");
    	eventCreateConfig.addDefault("Event.Date.Debut.Heure" , "50");
    	eventCreateConfig.addDefault("Event.Date.Debut.Minute" , "50");
    	eventCreateConfig.addDefault("Event.Date.Fin.Jour" , "debug");
    	eventCreateConfig.addDefault("Event.Date.Fin.Heure" , "50");
    	eventCreateConfig.addDefault("Event.Date.Fin.Minute" , "50");
    	eventCreateConfig.options().copyDefaults(true);
  	  
    	saveCustomConfig();
    	
    	plugin.eventEnable = eventCreateConfig.getString("Enable");
    	plugin.castleEtat = eventCreateConfig.getString("Etat");
    	plugin.eventJourDebut = eventCreateConfig.getString("Event.Date.Debut.Jour");
    	plugin.eventHeureDebut = eventCreateConfig.getString("Event.Date.Debut.Heure");
    	plugin.eventMinuteDebut = eventCreateConfig.getString("Event.Date.Debut.Minute");
    	plugin.eventMinuteFin = eventCreateConfig.getString("Event.Date.Fin.Jour");
    	plugin.eventMinuteFin = eventCreateConfig.getString("Event.Date.Fin.Heure");
    	plugin.eventMinuteFin = eventCreateConfig.getString("Event.Date.Fin.Minute");
    }
}
