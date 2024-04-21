package net.thesunkingapollo.infinitude.block;

import net.thesunkingapollo.infinitude.Infinitude;
import net.thesunkingapollo.infinitude.block.custom.MultiplierBlock;
import net.thesunkingapollo.infinitude.item.ModCreativeModTab;
import net.thesunkingapollo.infinitude.item.ModItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Infinitude.MOD_ID);

    /* Place your blocks between here*/

    public static final RegistryObject<Block> MULTIPLIER_BLOCK = registerBlock("multiplier_block", () -> new MultiplierBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6F)
            .requiresCorrectToolForDrops()
            .noOcclusion()));

    public static final RegistryObject<Block> INFINIUM_ORE_BLOCK = registerBlock("infinium_ore_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6F)
            .requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));


    /* and here */

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
