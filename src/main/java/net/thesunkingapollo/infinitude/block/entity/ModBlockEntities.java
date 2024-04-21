package net.thesunkingapollo.infinitude.block.entity;


import net.thesunkingapollo.infinitude.Infinitude;
import net.thesunkingapollo.infinitude.block.ModBlocks;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Infinitude.MOD_ID);

    public static final RegistryObject<BlockEntityType<MultiplierBlockEntity>>  MULTIPLIER_STATION =
            BLOCK_ENTITIES.register("gem_infusing_station", () ->
                    BlockEntityType.Builder.of(MultiplierBlockEntity::new,
                            ModBlocks.MULTIPLIER_BLOCK.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
