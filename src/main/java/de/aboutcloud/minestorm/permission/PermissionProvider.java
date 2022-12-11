package de.aboutcloud.minestorm.permission;

import de.aboutcloud.minestorm.player.MinePlayer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class PermissionProvider {

    private final HashMap<MinePlayer, ArrayList<String>> permissions = new HashMap<>();

    public boolean hasPermission(MinePlayer player, String permission) {
        if(getPermissions(player).contains(permission) || getPermissions(player).contains("*")) return true;
        return false;
    }

    public void addPermission(MinePlayer player, String permission) {
        if(!hasPermission(player, permission)) {
            getPermissions(player).add(permission);
        }
    }

    public void setup(MinePlayer player) {
        this.permissions.put(player, new ArrayList<>());
    }

    public void removePermission(MinePlayer player, String permission) {
        getPermissions(player).remove(permission);
    }

    public ArrayList<String> getPermissions(MinePlayer player) {
        return permissions.get(player);
    }
}
