package com.wdiscute.laicaps.networkandcodecsandshitomgthissuckssomuchpleasehelp;

import com.wdiscute.laicaps.Laicaps;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.ItemStack;


public class Payloads
{

    public record EntryUnlockedPayload(String menuName, String entryName) implements CustomPacketPayload
    {

        public static final CustomPacketPayload.Type<EntryUnlockedPayload> TYPE = new CustomPacketPayload.Type<>(Laicaps.rl("entry_unlocked"));

        public static final StreamCodec<ByteBuf, EntryUnlockedPayload> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.STRING_UTF8,
                EntryUnlockedPayload::menuName,
                ByteBufCodecs.STRING_UTF8,
                EntryUnlockedPayload::entryName,
                EntryUnlockedPayload::new
        );

        @Override
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }
    }

    public record ChangePlanetSelected(String entityUUID, String planet) implements CustomPacketPayload
    {

        public static final CustomPacketPayload.Type<ChangePlanetSelected> TYPE = new CustomPacketPayload.Type<>(Laicaps.rl("change_planet_selected"));

        public static final StreamCodec<ByteBuf, ChangePlanetSelected> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.STRING_UTF8,
                ChangePlanetSelected::entityUUID,
                ByteBufCodecs.STRING_UTF8,
                ChangePlanetSelected::planet,
                ChangePlanetSelected::new
        );

        @Override
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }
    }

    public record BluePrintCompletedPayload(String da) implements CustomPacketPayload
    {

        public static final CustomPacketPayload.Type<BluePrintCompletedPayload> TYPE = new CustomPacketPayload.Type<>(Laicaps.rl("blueprint_completed"));

        public static final StreamCodec<ByteBuf, BluePrintCompletedPayload> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.STRING_UTF8,
                BluePrintCompletedPayload::da,
                BluePrintCompletedPayload::new
        );

        @Override
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }
    }
}
