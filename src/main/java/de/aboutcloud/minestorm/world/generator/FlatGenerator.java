package de.aboutcloud.minestorm.world.generator;

import lombok.NoArgsConstructor;
import net.minestom.server.instance.block.Block;
import net.minestom.server.instance.generator.GenerationUnit;
import net.minestom.server.instance.generator.Generator;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public class FlatGenerator implements Generator {

    @Override
    public void generate(@NotNull GenerationUnit unit) {
        unit.modifier().fillHeight(0, 40, Block.STONE);
    }
}
