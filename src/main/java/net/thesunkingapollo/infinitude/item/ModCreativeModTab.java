package net.thesunkingapollo.infinitude.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab INFINITUDE_TAB = new CreativeModeTab("infinituetab") {

        public ItemStack makeIcon(){
            return new ItemStack(ModItems.INFINIUM.get());
        }
    };
}
