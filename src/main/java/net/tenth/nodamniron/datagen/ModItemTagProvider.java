package net.tenth.nodamniron.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.tenth.nodamniron.NoDamnIron;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public static final TagKey<Item> COPPER_MATERIAL = TagKey.of(RegistryKeys.ITEM, Identifier.of(NoDamnIron.MOD_ID, "copper_tool_material"));
    public static final TagKey<Item> REPAIRS_COPPER_ARMOR = TagKey.of(RegistryKeys.ITEM, Identifier.of(NoDamnIron.MOD_ID, "repairs_copper_armor"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getTagBuilder(COPPER_MATERIAL);
        getTagBuilder(REPAIRS_COPPER_ARMOR)
                .add(Identifier.ofVanilla("copper_ingot"));
        getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("pickaxes")))
                .add(Identifier.of(NoDamnIron.MOD_ID, "copper_pickaxe"));
        getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("axes")))
                .add(Identifier.of(NoDamnIron.MOD_ID, "copper_axe"));
        getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("shovels")))
                .add(Identifier.of(NoDamnIron.MOD_ID, "copper_shovel"));
        getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("hoes")))
                .add(Identifier.of(NoDamnIron.MOD_ID, "copper_hoe"));
        getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("swords")))
                .add(Identifier.of(NoDamnIron.MOD_ID, "copper_sword"));
        getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("head_armor")))
                .add(Identifier.of(NoDamnIron.MOD_ID, "copper_helmet"));
        getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("chest_armor")))
                .add(Identifier.of(NoDamnIron.MOD_ID, "copper_chestplate"));
        getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("leg_armor")))
                .add(Identifier.of(NoDamnIron.MOD_ID, "copper_leggings"));
        getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("foot_armor")))
                .add(Identifier.of(NoDamnIron.MOD_ID, "copper_boots"));
    }
}
