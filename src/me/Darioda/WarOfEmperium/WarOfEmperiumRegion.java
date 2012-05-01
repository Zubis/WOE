package me.Darioda.WarOfEmperium;

import static com.sk89q.worldguard.bukkit.BukkitUtil.toVector;

import java.io.File;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class WarOfEmperiumRegion {

	public static WarOfEmperium plugin;
	
	public WarOfEmperiumRegion(WarOfEmperium instance) {
		plugin = instance;
	}
	
	public boolean isWithinRegion(Player player, String region)
    { 
		return isWithinRegion(player.getLocation(), region);
	}
	
	public boolean isWithinRegion(Block block, String region)
    { 
		return isWithinRegion(block.getLocation(), region);
	}
	
	public boolean isWithinRegion(Location loc, String region)
	{
	    WorldGuardPlugin guard = getWorldGuard();
	    Vector v = toVector(loc);
	    RegionManager manager = guard.getRegionManager(loc.getWorld());
	    ApplicableRegionSet set = manager.getApplicableRegions(v);
	    for (ProtectedRegion each : set)
	    {
	        if (each.getId().equalsIgnoreCase(region))
	        {
	            return true;
	        }
	    }
	    return false;
	}
	
	WorldGuardPlugin getWorldGuard() {
	    Plugin plugin1 = plugin.getServer().getPluginManager().getPlugin("WorldGuard");
	 
	    if (plugin1 == null || !(plugin1 instanceof WorldGuardPlugin)) {
	        return null;
	    }
	 
	    return (WorldGuardPlugin) plugin1;
	}
	
	public boolean isInRegion(Player player)
	{
		String[] listefichiers;
		File repertoire = new File("plugins/WarOfEmperium/castle/");
		if(repertoire.exists())
		{
			listefichiers = repertoire.list();
			for(int i = 0; i < listefichiers.length; i++)
			{
				plugin.Load.reloadcastleSelectConfig(listefichiers[i].toString());
				boolean rep = isWithinRegion(player.getLocation(), plugin.regionCastle);
				if(rep == true)
				{
					return true;
				}

			}
		}
		return false;
	}
	
}
