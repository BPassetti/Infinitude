package net.thesunkingapollo.infinitude.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thesunkingapollo.infinitude.Infinitude;
import org.jetbrains.annotations.NotNull;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Infinitude.MOD_ID);


    /* Place your blocks between here*/

    public static final RegistryObject<Item> INFINIUM = ITEMS.register("infinium",
            ()-> new Item(new Item.Properties().tab(ModCreativeModTab.INFINITUDE_TAB)));

    public static final RegistryObject<Item> RAW_INFINIUM = ITEMS.register("raw_infinium",
            ()-> new Item(new Item.Properties().tab(ModCreativeModTab.INFINITUDE_TAB)));


    /* and here */



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
