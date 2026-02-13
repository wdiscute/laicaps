package com.wdiscute.laicaps.notebook;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.wdiscute.laicaps.Laicaps;
import com.wdiscute.laicaps.registry.io.ExtraComposites;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public record NotebookEntry
        (
                ResourceLocation group,
                String title,
                String text,
                Image background,
                Image overlay,
                Image icon,
                boolean obfuscatedUntilUnlocked,
                boolean hideUntilUnlocked,
                boolean canBeBookmarked
        )
{
    public static final Codec<NotebookEntry> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    ResourceLocation.CODEC.fieldOf("group").forGetter(NotebookEntry::group),
                    Codec.STRING.fieldOf("title").forGetter(NotebookEntry::title),
                    Codec.STRING.fieldOf("text").forGetter(NotebookEntry::text),
                    Image.CODEC.fieldOf("background").forGetter(NotebookEntry::background),
                    Image.CODEC.fieldOf("overlay").forGetter(NotebookEntry::overlay),
                    Image.CODEC.fieldOf("icon").forGetter(NotebookEntry::icon),
                    Codec.BOOL.fieldOf("obfuscated_until_unlocked").forGetter(NotebookEntry::obfuscatedUntilUnlocked),
                    Codec.BOOL.fieldOf("hide_until_unlocked").forGetter(NotebookEntry::hideUntilUnlocked),
                    Codec.BOOL.fieldOf("can_be_bookmarked").forGetter(NotebookEntry::canBeBookmarked)

            ).apply(instance, NotebookEntry::new)
    );


    public static final StreamCodec<RegistryFriendlyByteBuf, NotebookEntry> STREAM_CODEC = ExtraComposites.composite(
            ResourceLocation.STREAM_CODEC, NotebookEntry::group,
            ByteBufCodecs.STRING_UTF8, NotebookEntry::title,
            ByteBufCodecs.STRING_UTF8, NotebookEntry::text,
            Image.STREAM_CODEC, NotebookEntry::background,
            Image.STREAM_CODEC, NotebookEntry::overlay,
            Image.STREAM_CODEC, NotebookEntry::icon,
            ByteBufCodecs.BOOL, NotebookEntry::obfuscatedUntilUnlocked,
            ByteBufCodecs.BOOL, NotebookEntry::hideUntilUnlocked,
            ByteBufCodecs.BOOL, NotebookEntry::canBeBookmarked,
            NotebookEntry::new
    );


    //omg image magdalena bay reference
    public record Image
            (
                    ResourceLocation path,
                    int width,
                    int height,
                    int offsetX,
                    int offsetY
            )
    {
        public static final Image DEFAULT = new Image(Laicaps.rl("missingno"), 0, 0, 0, 0);

        public static final Codec<Image> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        ResourceLocation.CODEC.fieldOf("path").forGetter(Image::path),
                        Codec.INT.fieldOf("width").forGetter(Image::width),
                        Codec.INT.fieldOf("height").forGetter(Image::height),
                        Codec.INT.fieldOf("offset_x").forGetter(Image::offsetX),
                        Codec.INT.fieldOf("offset_y").forGetter(Image::offsetY)

                ).apply(instance, Image::new)
        );

        public static final StreamCodec<RegistryFriendlyByteBuf, Image> STREAM_CODEC = StreamCodec.composite(
                ResourceLocation.STREAM_CODEC, Image::path,
                ByteBufCodecs.INT, Image::width,
                ByteBufCodecs.INT, Image::height,
                ByteBufCodecs.INT, Image::offsetX,
                ByteBufCodecs.INT, Image::offsetY,
                Image::new
        );
    }

}
