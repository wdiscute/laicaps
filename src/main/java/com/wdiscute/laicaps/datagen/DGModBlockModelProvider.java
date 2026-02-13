package com.wdiscute.laicaps.datagen;

import com.wdiscute.laicaps.Laicaps;
import com.wdiscute.laicaps.registry.ModBlocks;
import com.wdiscute.laicaps.registry.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class DGModBlockModelProvider extends BlockStateProvider
{
    public DGModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, Laicaps.MOD_ID, existingFileHelper);
    }


    @Override
    protected void registerStatesAndModels()
    {
        //blockWithItem(ModBlocks.ASHA_TELEPORTER);
        //blockWithItem(ModBlocks.ASHA_DIRT);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock)
    {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(Laicaps.MOD_ID + ":block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix)
    {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(Laicaps.MOD_ID + ":block/" + deferredBlock.getId().getPath() + appendix));
    }

}
