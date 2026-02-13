package com.wdiscute.laicaps;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class LaicapsTags
{
    //biome
    public static final ResourceLocation IS_ASHA = Laicaps.rl("is_asha");
    public static final ResourceLocation IS_LUNAMAR = Laicaps.rl("is_lunamar");

    //item tags
    public static final TagKey<Item> JARS = ItemTags.create(Laicaps.rl("jars"));
}
