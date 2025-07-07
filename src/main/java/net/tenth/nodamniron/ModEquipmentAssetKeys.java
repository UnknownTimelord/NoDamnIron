package net.tenth.nodamniron;

import net.minecraft.client.data.EquipmentAssetProvider;
import net.minecraft.data.DataOutput;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModEquipmentAssetKeys extends EquipmentAssetProvider {
    public ModEquipmentAssetKeys(DataOutput output) {
        super(output);
    }

    public static RegistryKey<EquipmentAsset> COPPER = register("copper");

    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(NoDamnIron.MOD_ID, name));
    }
}
