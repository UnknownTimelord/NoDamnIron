package net.tenth.nodamniron;

import net.fabricmc.api.ClientModInitializer;
import net.tenth.nodamniron.item.ModItems;

public class NoDamnIronClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModItems.register();

    }
}
