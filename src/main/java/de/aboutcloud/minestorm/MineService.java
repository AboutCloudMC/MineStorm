package de.aboutcloud.minestorm;

import de.aboutcloud.minestorm.permission.PermissionProvider;
import de.aboutcloud.minestorm.world.WorldProvider;
import lombok.Getter;


public class MineService {

    private static final WorldProvider worldProvider = new WorldProvider();
    private static final PermissionProvider permProvider = new PermissionProvider();

    public static WorldProvider getWorldProvider() {
        return worldProvider;
    }
    public static PermissionProvider getPermissionProvider() {
        return permProvider;
    }
}
