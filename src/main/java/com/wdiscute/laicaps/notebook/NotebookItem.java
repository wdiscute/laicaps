package com.wdiscute.laicaps.notebook;

import com.wdiscute.laicaps.U;
import com.wdiscute.laicaps.item.EntryUnlockableItem;
import com.wdiscute.laicaps.util.AdvHelper;
import com.wdiscute.laicaps.registry.io.Payloads;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

public class NotebookItem extends EntryUnlockableItem
{
    public NotebookItem(Properties properties, String adv, String criteria)
    {
        super(properties, adv, criteria);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand)
    {
        if(level.isClientSide) U.openScreen(new NotebookScreen());
        return super.use(level, player, usedHand);
    }
}
