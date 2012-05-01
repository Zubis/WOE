package me.Darioda.WarOfEmperium;

import org.bukkit.entity.Player;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class WarOfEmperiumPermissions {

	@SuppressWarnings("unused")
	private WarOfEmperium plugin;
    
	public WarOfEmperiumPermissions(WarOfEmperium plugin) {
		this.plugin = plugin;
	}
	
	public PermissionUser getPerms(Player player)
	{
		PermissionUser user = PermissionsEx.getUser(player);
		return user;
	}
	
	public String[] getGroup(Player player)
	{
		PermissionUser user = PermissionsEx.getUser(player);
		String[] groups = user.getGroupsNames();
		return groups;
	}

	
	
}
