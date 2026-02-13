package com.wdiscute.laicaps.registry.io;

import com.wdiscute.laicaps.Laicaps;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;
import java.util.function.Supplier;

public class ModDataAttachments
{
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(
            NeoForgeRegistries.ATTACHMENT_TYPES, Laicaps.MOD_ID);

    public static final Supplier<AttachmentType<List<ResourceLocation>>> BOOKMARKS = ATTACHMENT_TYPES.register(
            "bookmarks", () -> AttachmentType.builder(() -> List.of(Laicaps.rl("missingno")))
                    .serialize(ResourceLocation.CODEC.listOf())
                    .sync(ResourceLocation.STREAM_CODEC.apply(ByteBufCodecs.list()))
                    .copyOnDeath()
                    .build()
    );

    public static final Supplier<AttachmentType<List<ResourceLocation>>> ENTRIES_UNLOCKED = ATTACHMENT_TYPES.register(
            "entries_unlocked", () -> AttachmentType.builder(() -> List.of(Laicaps.rl("missingno")))
                    .serialize(ResourceLocation.CODEC.listOf())
                    .sync(ResourceLocation.STREAM_CODEC.apply(ByteBufCodecs.list()))
                    .copyOnDeath()
                    .build()
    );





    // sets the value to default
    public static <T> void remove(Entity holder, Supplier<AttachmentType<T>> attachmentType)
    {
        if(holder == null) return;
        holder.removeData(attachmentType);
    }

    // sets the value to default
    public static <T> void remove(Entity holder, AttachmentType<T> attachmentType)
    {
        if(holder == null) return;
        holder.removeData(attachmentType);
    }

    public static <T> void set(Entity holder, Supplier<AttachmentType<T>> attachmentType, T data)
    {
        if(holder == null) return;
        holder.setData(attachmentType, data);
    }

    public static <T> void set(Entity holder, AttachmentType<T> attachmentType, T data)
    {
        if(holder == null) return;
        holder.setData(attachmentType, data);
    }

    public static <T> T get(Entity holder, Supplier<AttachmentType<T>> attachmentType)
    {
        if(holder == null) throw new RuntimeException("Called Starcatcher DataAttachments Get() with a null entity");
        return holder.getData(attachmentType);
    }

    public static <T> T get(Entity holder, AttachmentType<T> attachmentType)
    {
        if(holder == null) throw new RuntimeException("Called Starcatcher DataAttachments Get() with a null entity");
        return holder.getData(attachmentType);
    }

    public static void register(IEventBus eventBus)
    {
        ATTACHMENT_TYPES.register(eventBus);
    }

}
