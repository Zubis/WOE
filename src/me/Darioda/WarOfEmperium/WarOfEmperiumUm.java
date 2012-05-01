package me.Darioda.WarOfEmperium;

import org.bukkit.plugin.Plugin;

import zubi.mhm.unlimitedmaterials.UnlimitedMaterials;
import zubi.mhm.unlimitedmaterials.manager.BlockManager;

public class WarOfEmperiumUm {

	public static WarOfEmperium plugin;
	
	public WarOfEmperiumUm(WarOfEmperium instance) {
		plugin = instance;
	}
	
	BlockManager getUm() {
	    Plugin plugin1 = plugin.getServer().getPluginManager().getPlugin("MHM-UnlimitedMaterials");
	 
	    if (plugin1 == null || !(plugin1 instanceof UnlimitedMaterials)) {
	        return null;
	    }
	 
	    return (BlockManager) plugin1;
	}
	
	public void test()
	{
		getUm().BlockArray.get(0);
	}
}
