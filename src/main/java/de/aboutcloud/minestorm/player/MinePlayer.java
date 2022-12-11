package de.aboutcloud.minestorm.player;

import de.aboutcloud.minestorm.MineService;
import de.aboutcloud.minestorm.permission.PermissionProvider;
import net.minestom.server.entity.Player;
import net.minestom.server.network.player.PlayerConnection;
import net.minestom.server.permission.Permission;
import net.minestom.server.permission.PermissionVerifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.UUID;

public class MinePlayer extends Player {

    public MinePlayer(@NotNull UUID uuid, @NotNull String username, @NotNull PlayerConnection playerConnection) {
        super(uuid, username, playerConnection);
        MineService.getPermissionProvider().setup(this);
    }

    @Override
    public boolean hasPermission(@NotNull String permissionName) {
        return MineService.getPermissionProvider().hasPermission(this, permissionName);
    }

    @Override
    public boolean hasPermission(@NotNull Permission permission) {
        return MineService.getPermissionProvider().hasPermission(this, permission.getPermissionName());
    }

    @Override
    public void addPermission(@NotNull Permission permission) {
        MineService.getPermissionProvider().addPermission(this, permission.getPermissionName());
    }

    @Override
    public @Nullable Permission getPermission(@NotNull String permissionName) {
        return new Permission(permissionName);
    }

    @Override
    public void removePermission(@NotNull Permission permission) {
        MineService.getPermissionProvider().removePermission(this, permission.getPermissionName());
    }

    @Override
    public void removePermission(@NotNull String permissionName) {
        MineService.getPermissionProvider().removePermission(this, permissionName);
    }


}
