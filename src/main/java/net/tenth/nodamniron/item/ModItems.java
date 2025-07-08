package net.tenth.nodamniron.item;

import com.google.common.collect.Maps;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.tenth.nodamniron.NoDamnIron;
import net.tenth.nodamniron.datagen.ModBlockTagProvider;
import net.tenth.nodamniron.datagen.ModItemTagProvider;

import java.util.Map;
import java.util.function.Function;

public class ModItems {

    public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NoDamnIron.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void register() {
        NoDamnIron.LOGGER.info("Registering ModItems for {}", NoDamnIron.MOD_ID);
    }

    public static final ToolMaterial COPPER_TOOL = new ToolMaterial(ModBlockTagProvider.COPPER_INCORRECT, 191, 5.0F, 1.0F, 15, ModItemTagProvider.COPPER_MATERIAL);

    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", Item::new, new Item.Settings()
            .pickaxe(COPPER_TOOL, 1.0F, -2.8F).enchantable(15));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel", settings ->
            new ShovelItem(COPPER_TOOL, 1.5F, -3.0F, settings), new Item.Settings());
    public static final Item COPPER_SWORD = registerItem("copper_sword", Item::new, new Item.Settings()
            .sword(COPPER_TOOL, 3.0F, -2.4F));
    public static final Item COPPER_AXE = registerItem("copper_axe", settings ->
            new AxeItem(COPPER_TOOL, 6.0F, -3.1F, settings), new Item.Settings());
    public static final Item COPPER_HOE = registerItem("copper_hoe", settings ->
            new HoeItem(COPPER_TOOL, -2.0F, -1.0F, settings), new Item.Settings());

    private static Map<EquipmentType, Integer> createDefenseMap(int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense) {
        return Maps.newEnumMap(
                Map.of(
                        EquipmentType.BOOTS,
                        bootsDefense,
                        EquipmentType.LEGGINGS,
                        leggingsDefense,
                        EquipmentType.CHESTPLATE,
                        chestplateDefense,
                        EquipmentType.HELMET,
                        helmetDefense,
                        EquipmentType.BODY,
                        bodyDefense
                )
        );
    }

    public static final ArmorMaterial COPPER_ARMOR = new ArmorMaterial(15, createDefenseMap(1, 3, 4, 2, 2), 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ModItemTagProvider.REPAIRS_COPPER_ARMOR, ModEquipmentAssetKeys.COPPER);

    public static final Item COPPER_HELM = registerItem("copper_helmet", Item::new, new Item.Settings()
            .armor(COPPER_ARMOR, EquipmentType.HELMET));
    public static final Item COPPER_CHEST = registerItem("copper_chestplate", Item::new, new Item.Settings()
            .armor(COPPER_ARMOR, EquipmentType.CHESTPLATE));
    public static final Item COPPER_LEGS = registerItem("copper_leggings", Item::new, new Item.Settings()
            .armor(COPPER_ARMOR, EquipmentType.LEGGINGS));
    public static final Item COPPER_BOOTS = registerItem("copper_boots", Item::new, new Item.Settings()
            .armor(COPPER_ARMOR, EquipmentType.BOOTS));
}
