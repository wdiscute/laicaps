package com.wdiscute.laicaps;

import com.mojang.logging.LogUtils;
import com.wdiscute.laicaps.item.ModDataComponents;
import com.wdiscute.laicaps.notebook.NotebookEntry;
import com.wdiscute.laicaps.registry.io.ModDataAttachments;
import com.wdiscute.laicaps.notebook.EntryUnlockedToast;
import com.wdiscute.laicaps.particle.*;
import com.wdiscute.laicaps.registry.*;
import com.wdiscute.laicaps.worldgen.ModFeatures;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.registries.RegistryBuilder;
import org.slf4j.Logger;

@Mod(Laicaps.MOD_ID)
public class Laicaps
{
    public static final String MOD_ID = "laicaps";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final ResourceKey<Registry<NotebookEntry>> NOTEBOOK_ENTRY =
            ResourceKey.createRegistryKey(Laicaps.rl("notebook_entry"));

    public static ResourceLocation rl(String s)
    {
        return ResourceLocation.fromNamespaceAndPath(Laicaps.MOD_ID, s);
    }


    @OnlyIn(Dist.CLIENT)
    public static void entryUnlockedToast(String menuName, String entryName)
    {
        Minecraft.getInstance().getToasts().addToast(new EntryUnlockedToast(menuName, entryName));
    }

    public Laicaps(IEventBus modEventBus, ModContainer modContainer)
    {
        //NeoForge.EVENT_BUS.addListener(EntriesChecks::itemPickupEvent);

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModDataComponents.register(modEventBus);
        ModSounds.register(modEventBus);
        ModBlockEntity.register(modEventBus);
        ModEntities.register(modEventBus);
        ModParticles.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModFeatures.register(modEventBus);
        ModDataAttachments.register(modEventBus);
        ModDataSerializers.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}



