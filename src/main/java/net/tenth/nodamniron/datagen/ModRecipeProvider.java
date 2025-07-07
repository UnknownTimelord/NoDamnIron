package net.tenth.nodamniron.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.tenth.nodamniron.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                ShapedRecipeJsonBuilder.create(Registries.ITEM, RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE)
                        .input('C', Items.COPPER_INGOT)
                        .input('S', Items.STICK)
                        .pattern("CCC")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(recipeExporter);
                ShapedRecipeJsonBuilder.create(Registries.ITEM, RecipeCategory.TOOLS, ModItems.COPPER_AXE)
                        .input('C', Items.COPPER_INGOT)
                        .input('S', Items.STICK)
                        .pattern("CC")
                        .pattern("CS")
                        .pattern(" S")
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(recipeExporter);
                ShapedRecipeJsonBuilder.create(Registries.ITEM, RecipeCategory.TOOLS, ModItems.COPPER_SWORD)
                        .input('C', Items.COPPER_INGOT)
                        .input('S', Items.STICK)
                        .pattern("C")
                        .pattern("C")
                        .pattern("S")
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(recipeExporter);
                ShapedRecipeJsonBuilder.create(Registries.ITEM, RecipeCategory.TOOLS, ModItems.COPPER_HOE)
                        .input('C', Items.COPPER_INGOT)
                        .input('S', Items.STICK)
                        .pattern("CC")
                        .pattern(" S")
                        .pattern(" S")
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(recipeExporter);
                ShapedRecipeJsonBuilder.create(Registries.ITEM, RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL)
                        .input('C', Items.COPPER_INGOT)
                        .input('S', Items.STICK)
                        .pattern("C")
                        .pattern("S")
                        .pattern("S")
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(recipeExporter);
            }
        };
    }


    @Override
    public String getName() {
        return "No Damn Iron Recipes";
    }
}
