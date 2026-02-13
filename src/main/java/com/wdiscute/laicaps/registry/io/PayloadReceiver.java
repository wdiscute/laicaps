package com.wdiscute.laicaps.registry.io;

import com.wdiscute.laicaps.Laicaps;
import com.wdiscute.laicaps.registry.ModItems;
import com.wdiscute.laicaps.entity.rocket.RE;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.List;

public class PayloadReceiver
{

    public static void receiveEntryUnlocked(final Payloads.EntryUnlockedPayload data, final IPayloadContext context)
    {
        Laicaps.entryUnlockedToast(data.menuName(), data.entryName());
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

                if (data.planet().equals("ember")) is = new ItemStack(ModItems.EMBER_ENTRY.get());
                if (data.planet().equals("asha")) is = new ItemStack(ModItems.ASHA_ENTRY.get());
                if (data.planet().equals("overworld")) is = new ItemStack(ModItems.OVERWORLD_ENTRY.get());
                if (data.planet().equals("lunamar")) is = new ItemStack(ModItems.LUNAMAR_ENTRY.get());

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
