package me.Darioda.WarOfEmperium;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class WarOfEmperiumEventConfigLoad {
	
	private FileConfiguration eventSelect = null;
	private File eventSelectFile = null;
	
	
	public static WarOfEmperium plugin;
	
	public WarOfEmperiumEventConfigLoad(WarOfEmperium instance) {
		plugin = instance;
	}
	
	public void reloadcastleSelectConfig(String castle, String event_id) {
		eventSelectFile = new File(plugin.getDataFolder() + "/castle/" + castle + "/event/", event_id);
        eventSelect = YamlConfiguration.loadConfiguration(eventSelectFile);
     
        chargementVar(castle, event_id);
    }
    
    public FileConfiguration getcastleSelectConfig(String castle, String event_id) {
        if (eventSelect == null) {
            reloadcastleSelectConfig(castle, event_id);
        }
        return eventSelect;
    }

    public void savecastleSelectConfig(String castle, String event_id) {
        if (eventSelect == null || eventSelectFile == null) {
        return;
        }
        try {
        	eventSelect.save(new File(plugin.getDataFolder() + "/castle/" + castle + "/event/", event_id));
        } catch (IOException ex) {
            Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + eventSelectFile, ex);
        }
    }
    
    public void chargementVar(String castle, String event_id)
    {
    	eventSelect = getcastleSelectConfig(castle, event_id);
    	eventSelect.addDefault("Enable" , "");
    	eventSelect.addDefault("Etat" , "");
    	eventSelect.addDefault("Event.Date.Debut.Jour" , "");
    	eventSelect.addDefault("Event.Date.Debut.Heure" , "");
    	eventSelect.addDefault("Event.Date.Debut.Minute" , "");
    	eventSelect.addDefault("Event.Date.Fin.Jour" , "");
    	eventSelect.addDefault("Event.Date.Fin.Heure" , "");
    	eventSelect.addDefault("Event.Date.Fin.Minute" , "");
    	eventSelect.options().copyDefaults(false);
  	  	
    	plugin.eventEnable = eventSelect.getString("Enable");
    	plugin.castleEtat = eventSelect.getString("Etat");
    	plugin.eventJourDebut = eventSelect.getString("Event.Date.Debut.Jour");
    	plugin.eventHeureDebut = eventSelect.getString("Event.Date.Debut.Heure");
    	plugin.eventMinuteDebut = eventSelect.getString("Event.Date.Debut.Minute");
    	plugin.eventJourFin = eventSelect.getString("Event.Date.Fin.Jour");
    	plugin.eventHeureFin = eventSelect.getString("Event.Date.Fin.Heure");
    	plugin.eventMinuteFin = eventSelect.getString("Event.Date.Fin.Minute");
    }
   
    public void sauvVar(String castle, String event_id)
    {    
    	eventSelect = getcastleSelectConfig(castle, event_id);
    	eventSelect.set("Enable", plugin.eventEnable);
    	eventSelect.set("Etat", plugin.castleEtat);
    	eventSelect.set("Event.Date.Debut.Jour" , plugin.eventJourDebut);
    	eventSelect.set("Event.Date.Debut.Heure" , plugin.eventHeureDebut);
    	eventSelect.set("Event.Date.Debut.Minute" , plugin.eventMinuteDebut);
    	eventSelect.set("Event.Date.Fin.Jour" , plugin.eventJourFin);
    	eventSelect.set("Event.Date.Fin.Heure" , plugin.eventHeureFin);
    	eventSelect.set("Event.Date.Fin.Minute" , plugin.eventMinuteFin);
    	savecastleSelectConfig(castle, event_id);
    }

}