package com.wdiscute.laicaps.event;

import com.wdiscute.laicaps.Laicaps;
import com.wdiscute.laicaps.block.telescope.TelescopeScreen;
import com.wdiscute.laicaps.entity.bluetale.BluetaleModel;
import com.wdiscute.laicaps.entity.bluetale.BluetaleRenderer;
import com.wdiscute.laicaps.entity.bluetale.RedtaleRenderer;
import com.wdiscute.laicaps.entity.boat.ModBoatRenderer;
import com.wdiscute.laicaps.entity.boat.ModModelLayers;
import com.wdiscute.laicaps.entity.bubblemouth.BubblemouthModel;
import com.wdiscute.laicaps.entity.bubblemouth.BubblemouthRenderer;
import com.wdiscute.laicaps.entity.glimpuff.GlimpuffModel;
import com.wdiscute.laicaps.entity.glimpuff.GlimpuffRenderer;
import com.wdiscute.laicaps.entity.magmaboss.magma.MagmaModel;
import com.wdiscute.laicaps.entity.magmaboss.magma.MagmaRenderer;
import com.wdiscute.laicaps.entity.magmaboss.rock.RockModel;
import com.wdiscute.laicaps.entity.magmaboss.rock.RockRenderer;
import com.wdiscute.laicaps.entity.magmaboss.shield.ShieldModel;
import com.wdiscute.laicaps.entity.magmaboss.shield.ShieldRenderer;
import com.wdiscute.laicaps.entity.moonray.MoonrayModel;
import com.wdiscute.laicaps.entity.moonray.MoonrayRenderer;
import com.wdiscute.laicaps.entity.nimble.NimbleModel;
import com.wdiscute.laicaps.entity.nimble.NimbleRenderer;
import com.wdiscute.laicaps.entity.rocket.RefuelScreen;
import com.wdiscute.laicaps.entity.rocket.RocketModel;
import com.wdiscute.laicaps.entity.rocket.RocketRenderer;
import com.wdiscute.laicaps.entity.snuffler.SnufflerModel;
import com.wdiscute.laicaps.entity.snuffler.SnufflerRenderer;
import com.wdiscute.laicaps.entity.swibble.SwibbleModel;
import com.wdiscute.laicaps.entity.swibble.SwibbleRenderer;
import com.wdiscute.laicaps.particle.*;
import com.wdiscute.laicaps.registry.*;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = Laicaps.MOD_ID)
public class ModClientEvents
{
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        Sheets.addWoodType(ModWoodTypes.OAKROOT);
        Sheets.addWoodType(ModWoodTypes.OAKHEART);

        event.enqueueWork(() ->
        {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.VIOLET_SWEETLILY.getId(), ModBlocks.POTTED_VIOLET_SWEETLILY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PEACH_SWEETLILY.getId(), ModBlocks.POTTED_PEACH_SWEETLILY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CHERRY_SWEETLILY.getId(), ModBlocks.POTTED_CHERRY_SWEETLILY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.MAGENTA_SWEETLILY.getId(), ModBlocks.POTTED_MAGENTA_SWEETLILY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.NAVY_SWEETLILY.getId(), ModBlocks.POTTED_NAVY_SWEETLILY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LUNARVEIL.getId(), ModBlocks.POTTED_LUNARVEIL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.OAKHEART_SAPLING.getId(), ModBlocks.POTTED_OAKHEART_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.OAKROOT_SAPLING.getId(), ModBlocks.POTTED_OAKROOT_SAPLING);
        });

        EntityRenderers.register(ModEntities.MOD_BOAT.get(), context -> new ModBoatRenderer(context, false));
        EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), context -> new ModBoatRenderer(context, true));

        EntityRenderers.register(ModEntities.ROCKET.get(), RocketRenderer::new);

        EntityRenderers.register(ModEntities.MAGMA.get(), MagmaRenderer::new);
        EntityRenderers.register(ModEntities.SHIELD.get(), ShieldRenderer::new);
        EntityRenderers.register(ModEntities.ROCK.get(), RockRenderer::new);

        EntityRenderers.register(ModEntities.BLUETALE.get(), BluetaleRenderer::new);
        EntityRenderers.register(ModEntities.REDTALE.get(), RedtaleRenderer::new);
        EntityRenderers.register(ModEntities.BUBBLEMOUTH.get(), BubblemouthRenderer::new);
        EntityRenderers.register(ModEntities.MOONRAY.get(), MoonrayRenderer::new);
        EntityRenderers.register(ModEntities.GLIMPUFF.get(), GlimpuffRenderer::new);
        EntityRenderers.register(ModEntities.SWIBBLE.get(), SwibbleRenderer::new);
        EntityRenderers.register(ModEntities.NIMBLE.get(), NimbleRenderer::new);
        EntityRenderers.register(ModEntities.SNUFFLER.get(), SnufflerRenderer::new);

    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event)
    {
        event.registerSpriteSet(ModParticles.CHASE_PUZZLE_PARTICLES.get(), ChasePuzzleParticles.Provider::new);
        event.registerSpriteSet(ModParticles.WATER_FLOWER_PARTICLES.get(), WaterFlowerParticles.Provider::new);
        event.registerSpriteSet(ModParticles.LUNARVEIL_PARTICLES.get(), LunarveilParticles.Provider::new);
        event.registerSpriteSet(ModParticles.ROCKET_FIRE_PARTICLES.get(), RocketFireParticles.Provider::new);
        event.registerSpriteSet(ModParticles.ROCKET_FIRE_SIMPLE_PARTICLES.get(), RocketFireSimpleParticles.Provider::new);
        event.registerSpriteSet(ModParticles.ROCK_FALLING.get(), RockParticles.Provider::new);
        event.registerSpriteSet(ModParticles.ROCK_EXPLOSION.get(), RockExplosionParticles.Provider::new);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event)
    {
        event.register(ModMenuTypes.TELESCOPE_MENU.get(), TelescopeScreen::new);
        event.register(ModMenuTypes.REFUEL_MENU.get(), RefuelScreen::new);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerBlockEntityRenderer(ModBlockEntity.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntity.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(ModModelLayers.OAKHEART_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.OAKROOT_BOAT_LAYER, BoatModel::createBodyModel);

        event.registerLayerDefinition(ModModelLayers.OAKHEART_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.OAKROOT_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);


        event.registerLayerDefinition(BluetaleModel.LAYER_LOCATION, BluetaleModel::createBodyLayer);
        //no need for redtale as it uses the same model
        event.registerLayerDefinition(BubblemouthModel.LAYER_LOCATION, BubblemouthModel::createBodyLayer);
        event.registerLayerDefinition(MoonrayModel.LAYER_LOCATION, MoonrayModel::createBodyLayer);
        event.registerLayerDefinition(GlimpuffModel.LAYER_LOCATION, GlimpuffModel::createBodyLayer);


        event.registerLayerDefinition(SwibbleModel.LAYER_LOCATION, SwibbleModel::createBodyLayer);

        event.registerLayerDefinition(NimbleModel.LAYER_LOCATION, NimbleModel::createBodyLayer);
        event.registerLayerDefinition(SnufflerModel.LAYER_LOCATION, SnufflerModel::createBodyLayer);

        event.registerLayerDefinition(RocketModel.LAYER_LOCATION, RocketModel::createBodyLayer);

        event.registerLayerDefinition(MagmaModel.LAYER_LOCATION, MagmaModel::createBodyLayer);
        event.registerLayerDefinition(ShieldModel.LAYER_LOCATION, ShieldModel::createBodyLayer);
        event.registerLayerDefinition(RockModel.LAYER_LOCATION, RockModel::createBodyLayer);
    }
}
