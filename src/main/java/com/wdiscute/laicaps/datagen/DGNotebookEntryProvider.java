package com.wdiscute.laicaps.datagen;

import com.wdiscute.laicaps.Laicaps;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class DGNotebookEntryProvider extends DatapackBuiltinEntriesProvider
{
    static
    {
        DGNotebookEntries.register(); //register all entries before anything else
    }

    public static final RegistrySetBuilder REGISTRY = new RegistrySetBuilder().add(Laicaps.NOTEBOOK_ENTRY, DGNotebookEntries::bootstrap);

    public DGNotebookEntryProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries, REGISTRY, DGNotebookEntryProvider::addConditions, Set.of(
                Laicaps.MOD_ID,
                "minecraft"
        ));
    }

    private static void addConditions(final BiConsumer<ResourceKey<?>, ICondition> consumer)
    {
        DGNotebookEntries.registerConditions(consumer);
    }

    @Override
    public String getName()
    {
        return "NotebookEntry";
    }
}
