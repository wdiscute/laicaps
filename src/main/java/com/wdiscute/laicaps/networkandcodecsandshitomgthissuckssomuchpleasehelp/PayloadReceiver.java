package com.wdiscute.laicaps.networkandcodecsandshitomgthissuckssomuchpleasehelp;

import com.wdiscute.laicaps.Laicaps;
import com.wdiscute.laicaps.ModItems;
import com.wdiscute.laicaps.entity.fishing.FishingBobEntity;
import com.wdiscute.laicaps.entity.rocket.RE;
import com.wdiscute.laicaps.fishing.FishingMinigameScreen;
import com.wdiscute.laicaps.item.ModDataComponents;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.ArrayList;
import java.util.List;

public class PayloadReceiver
{

    public static void receiveEntryUnlocked(final Payloads.EntryUnlockedPayload data, final IPayloadContext context)
    {
        Laicaps.entryUnlockedToast(data.menuName(), data.entryName());
    }


    @OnlyIn(Dist.CLIENT)
    public static void client(Payloads.FishingPayload data, IPayloadContext context)
    {
        Minecraft.getInstance().setScreen(new FishingMinigameScreen(
                data.stack(),
                data.bobber(),
                data.bait(),
                data.difficulty()
        ));
    }

    public static void receiveChangePlanetSelected(final Payloads.ChangePlanetSelected data, final IPayloadContext context)
    {

        List<Entity> entites = context.player().level().getEntities(
                null,
                new AABB(-10, -10, -10, 10, 10, 10).move(context.player().position()));

        for (Entity e : entites)
        {
            if (e instanceof RE re && re.getStringUUID().equals(data.entityUUID()) && re.getEntityData().get(RE.STATE) == 0)
            {
                ItemStack is = ItemStack.EMPTY;

                if (data.planet().equals("ember")) is = new ItemStack(ModItems.EMBER.get());
                if (data.planet().equals("asha")) is = new ItemStack(ModItems.ASHA.get());
                if (data.planet().equals("overworld")) is = new ItemStack(ModItems.OVERWORLD.get());
                if (data.planet().equals("lunamar")) is = new ItemStack(ModItems.LUNAMAR.get());

                re.getEntityData().set(RE.PLANET_SELECTED, is);
                break;
            }
        }

    }


    public static void receiveBluePrintCompleted(final Payloads.BluePrintCompletedPayload data, final IPayloadContext context)
    {

        if (context.player().getMainHandItem().is(ModItems.SPACESHIP_BLUEPRINT_SKETCH))
        {
            context.player().getMainHandItem().shrink(1);
            context.player().addItem(new ItemStack(ModItems.SPACESHIP_BLUEPRINT.get()));
            return;
        }

        if (context.player().getOffhandItem().is(ModItems.SPACESHIP_BLUEPRINT_SKETCH))
        {
            context.player().getOffhandItem().shrink(1);
            context.player().addItem(new ItemStack(ModItems.SPACESHIP_BLUEPRINT.get()));
        }

    }
}
