package com.wdiscute.laicaps.event;

import com.wdiscute.laicaps.Laicaps;
import com.wdiscute.laicaps.entity.bluetale.BluetaleEntity;
import com.wdiscute.laicaps.entity.bubblemouth.BubblemouthEntity;
import com.wdiscute.laicaps.entity.glimpuff.GlimpuffEntity;
import com.wdiscute.laicaps.entity.magmaboss.magma.MagmaEntity;
import com.wdiscute.laicaps.entity.moonray.MoonrayEntity;
import com.wdiscute.laicaps.entity.nimble.NimbleEntity;
import com.wdiscute.laicaps.entity.snuffler.SnufflerEntity;
import com.wdiscute.laicaps.entity.swibble.SwibbleEntity;
import com.wdiscute.laicaps.notebook.NotebookEntry;
import com.wdiscute.laicaps.particle.*;
import com.wdiscute.laicaps.registry.*;
import com.wdiscute.laicaps.registry.io.PayloadReceiver;
import com.wdiscute.laicaps.registry.io.Payloads;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;

@EventBusSubscriber(modid = Laicaps.MOD_ID)
public class ModEvents
{

    @SubscribeEvent
    public static void addDatapackRegistry(DataPackRegistryEvent.NewRegistry event)
    {
        event.dataPackRegistry(
                Laicaps.NOTEBOOK_ENTRY, NotebookEntry.CODEC, NotebookEntry.CODEC,
                builder -> builder.maxId(128));
    }

    @SubscribeEvent
    public static void registerAttributed(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.BLUETALE.get(), BluetaleEntity.createAttributes().build());
        event.put(ModEntities.REDTALE.get(), BluetaleEntity.createAttributes().build());
        event.put(ModEntities.BUBBLEMOUTH.get(), BubblemouthEntity.createAttributes().build());
        event.put(ModEntities.MOONRAY.get(), MoonrayEntity.createAttributes().build());
        event.put(ModEntities.GLIMPUFF.get(), GlimpuffEntity.createAttributes().build());
        event.put(ModEntities.SWIBBLE.get(), SwibbleEntity.createAttributes().build());
        event.put(ModEntities.NIMBLE.get(), NimbleEntity.createAttributes().build());
        event.put(ModEntities.SNUFFLER.get(), SnufflerEntity.createAttributes().build());

        event.put(ModEntities.MAGMA.get(), MagmaEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event)
    {
        event.register(
                ModEntities.BLUETALE.get(), SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                WaterAnimal::checkSurfaceWaterAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(
                ModEntities.REDTALE.get(), SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                WaterAnimal::checkSurfaceWaterAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(
                ModEntities.BUBBLEMOUTH.get(), SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                WaterAnimal::checkSurfaceWaterAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(
                ModEntities.GLIMPUFF.get(), SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                WaterAnimal::checkSurfaceWaterAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(
                ModEntities.SWIBBLE.get(), SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                WaterAnimal::checkSurfaceWaterAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(
                ModEntities.NIMBLE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ModEvents::checkNimbleSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(
                ModEntities.SNUFFLER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ModEvents::checkNimbleSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

    }

    public static boolean checkNimbleSpawnRules(EntityType<? extends Animal> animal, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random)
    {
        boolean flag = level.getRawBrightness(pos, 0) > 8;
        return level.getBlockState(pos.below()).is(ModBlocks.ASHA_GRASS_BLOCK) && flag;
    }

    @SubscribeEvent
    public static void registerPayloads(final RegisterPayloadHandlersEvent event)
    {
        final PayloadRegistrar registrar = event.registrar("1");

        registrar.playToClient(
                Payloads.EntryUnlockedPayload.TYPE,
                Payloads.EntryUnlockedPayload.STREAM_CODEC,
                PayloadReceiver::receiveEntryUnlocked
        );


        registrar.playToServer(
                Payloads.ChangePlanetSelected.TYPE,
                Payloads.ChangePlanetSelected.STREAM_CODEC,
                PayloadReceiver::receiveChangePlanetSelected
        );

        registrar.playToServer(
                Payloads.BluePrintCompletedPayload.TYPE,
                Payloads.BluePrintCompletedPayload.STREAM_CODEC,
                PayloadReceiver::receiveBluePrintCompleted
        );

    }

}