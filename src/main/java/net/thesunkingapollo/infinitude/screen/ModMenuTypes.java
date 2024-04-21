package net.thesunkingapollo.infinitude.screen;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thesunkingapollo.infinitude.Infinitude;
import net.minecraft.world.inventory.MenuType;


public class ModMenuTypes{
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Infinitude.MOD_ID);

    public static final RegistryObject<MenuType<MultiplierMenu>> MULTIPLIER_MENU = registerMenuType(MultiplierMenu::new, "multiplier_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }



    public static void register(IEventBus eventBus){

        MENUS.register(eventBus);

    }
}
