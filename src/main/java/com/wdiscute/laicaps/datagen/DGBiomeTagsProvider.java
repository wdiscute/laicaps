package com.wdiscute.laicaps.datagen;

import com.wdiscute.laicaps.Laicaps;
import com.wdiscute.laicaps.LaicapsTags;
import com.wdiscute.laicaps.util.LaicapsKeys;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DGBiomeTagsProvider extends BiomeTagsProvider
{
    public DGBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, Laicaps.MOD_ID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider)
    {

        this.tag(create(LaicapsTags.IS_ASHA))
                .add(LaicapsKeys.ASHA_FLOWER_FOREST)
                .add(LaicapsKeys.ASHA_MOUNTAINS)
                .add(LaicapsKeys.ASHA_FOREST)
                .add(LaicapsKeys.ASHA_JUNGLE)
                .add(LaicapsKeys.ASHA_MESA)
                .add(LaicapsKeys.ASHA_OCEAN)
                .add(LaicapsKeys.ASHA_PLAINS)
                .add(LaicapsKeys.ASHA_RIVER)
        ;

        this.tag(create(LaicapsTags.IS_LUNAMAR))
                .add(LaicapsKeys.LUNAMAR_ASHEN_SHORES)
                .add(LaicapsKeys.LUNAMAR_DEEP)
                .add(LaicapsKeys.LUNAMAR_MAR)
                .add(LaicapsKeys.LUNAMAR_SHALLOW)
                .add(LaicapsKeys.LUNAMAR_SUBTIDAL)
                .add(LaicapsKeys.LUNAMAR_VERDURE)
        ;

    }

    private static TagKey<Biome> create(ResourceLocation rl)
    {
        return TagKey.create(Registries.BIOME, rl);
    }
}
