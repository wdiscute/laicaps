package com.wdiscute.laicaps.datagen;

import com.mojang.datafixers.util.Pair;
import com.wdiscute.laicaps.Laicaps;
import com.wdiscute.laicaps.notebook.NotebookEntry;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class DGNotebookEntries
{
    public static void register()
    {
        defaults();
    }


    private static final List<Pair<ResourceKey<NotebookEntry>, NotebookEntry>> PROPERTIES = new ArrayList<>();
    private static final List<ResourceKey<NotebookEntry>> COMPAT_KEYS = new ArrayList<>();

    public static void registerConditions(BiConsumer<ResourceKey<?>, ICondition> consumer)
    {
        for (ResourceKey<NotebookEntry> compatKey : COMPAT_KEYS)
        {
            consumer.accept(compatKey, new ModLoadedCondition(compatKey.location().getNamespace()));
        }
    }

    private static ResourceKey<NotebookEntry> createKey(NotebookEntry ne)
    {
        return ResourceKey.create(Laicaps.NOTEBOOK_ENTRY, Laicaps.rl(ne.title()));
    }

    protected static void registerNotebookEntry(NotebookEntry ne)
    {
        ResourceKey<NotebookEntry> key = createKey(ne);
        PROPERTIES.add(Pair.of(key, ne));
        String namespace = key.location().getNamespace();
        if (!namespace.equals("minecraft") && !namespace.equals("starcatcher"))
            COMPAT_KEYS.add(key);
    }

    @SuppressWarnings("deprecation")
    public static void bootstrap(BootstrapContext<NotebookEntry> context)
    {
        PROPERTIES.forEach(p -> context.register(p.getFirst(), p.getSecond()));
    }

    public static void defaults()
    {
        //intro
        registerNotebookEntry(new NotebookEntry(Laicaps.rl("daw"), "", "", NotebookEntry.Image.DEFAULT, NotebookEntry.Image.DEFAULT, NotebookEntry.Image.DEFAULT,
                true, true, true)
        );

    }
}
