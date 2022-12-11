package de.aboutcloud.minestorm;

import de.aboutcloud.minestorm.player.MinePlayer;
import de.aboutcloud.minestorm.world.WorldProvider;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.PlayerLoginEvent;
import net.minestom.server.extras.MojangAuth;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.permission.Permission;

public class MineServer {

    public static void main(String[] args) {

        MinecraftServer server = MinecraftServer.init();

        InstanceContainer world = MineService.getWorldProvider().createWorld("test", WorldProvider.Type.FLAT);

        MinecraftServer.getConnectionManager().setPlayerProvider(MinePlayer::new);

        GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();
        globalEventHandler.addListener(PlayerLoginEvent.class, event -> {
            final MinePlayer player = (MinePlayer) event.getPlayer();
            event.setSpawningInstance(world);
            player.setRespawnPoint(new Pos(0, 42, 0));
        });


        MojangAuth.init();
        server.start("0.0.0.0", 25565);
    }


}
