package de.aboutcloud.minestorm.world;

import de.aboutcloud.minestorm.world.generator.FlatGenerator;
import de.aboutcloud.minestorm.world.generator.VoidGenerator;
import lombok.AllArgsConstructor;
import net.minestom.server.MinecraftServer;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.generator.Generator;

import java.util.HashMap;

public class WorldProvider {

    @AllArgsConstructor
    public enum Type {
        VOID(new VoidGenerator()),
        FLAT(new FlatGenerator());

        private Generator generator;
    }

    private final HashMap<String, InstanceContainer> instances = new HashMap<>();

    public InstanceContainer createWorld(String name, Type type) {
        InstanceContainer ic = MinecraftServer.getInstanceManager().createInstanceContainer();
        ic.setGenerator(type.generator);
        instances.put(name, ic);
        return ic;
    }

    public InstanceContainer getWorld(String name) {
        return instances.getOrDefault(name, null);
    }
}
