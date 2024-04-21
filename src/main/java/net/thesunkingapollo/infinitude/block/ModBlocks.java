package net.thesunkingapollo.infinitude.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thesunkingapollo.infinitude.Infinitude;
import net.thesunkingapollo.infinitude.block.custom.MultiplierBlock;
import net.thesunkingapollo.infinitude.item.ModCreativeModTab;
import net.thesunkingapollo.infinitude.item.ModItems;

import java.awt.event.InputEvent;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Infinitude.MOD_ID);

    /* Place your blocks between here*/

    public static final RegistryObject<Block> MULTIPLIER_BLOCK = registerBlock("multiplier_block", () -> new MultiplierBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6F)
            .requiresCorrectToolForDrops()), ModCreativeModTab.INFINITUDE_TAB);

    public static final RegistryObject<Block> INFINIUM_ORE_BLOCK = registerBlock("infinium_ore_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6F)
            .requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)),
            ModCreativeModTab.INFINITUDE_TAB);


    /* and here */

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
     RegistryObject<T> toReturn = BLOCKS.register(name, block);
     registerBlockItem(name, toReturn, tab);

     return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
