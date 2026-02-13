package com.wdiscute.laicaps.datagen;

import com.wdiscute.laicaps.Laicaps;
import com.wdiscute.laicaps.LaicapsTags;
import com.wdiscute.laicaps.registry.ModBlocks;
import com.wdiscute.laicaps.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DGModItemsTagProvider extends ItemTagsProvider
{

    public DGModItemsTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                 CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTags, Laicaps.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {

        //jars
        tag(LaicapsTags.JARS)
                .add(ModBlocks.STARFLIES_JAR.get().asItem())
                .add(ModItems.OAKHEART_BERRIES_JAM.get())
                .add(ModBlocks.JAR.asItem())
        ;

//        for (DeferredHolder<Item, ? extends Item> item : ModItems.RODS_REGISTRY.getEntries())
//        {
//            tag(Tags.Items.TOOLS_FISHING_ROD).add(item.get());
//            tag(StarcatcherTags.RODS).add(item.get());
//        }
    }


    public static ResourceLocation rl(String ns, String path)
    {
        return ResourceLocation.fromNamespaceAndPath(ns, path);
    }
}
