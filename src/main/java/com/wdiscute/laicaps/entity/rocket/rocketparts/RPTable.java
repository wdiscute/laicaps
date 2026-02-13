package com.wdiscute.laicaps.entity.rocket.rocketparts;

import com.wdiscute.laicaps.U;
import com.wdiscute.laicaps.entity.rocket.RE;
import com.wdiscute.laicaps.notebook.NotebookScreen;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class RPTable extends RP
{

    public RPTable(AABB hitboxSize, Vec3 offsetFromCenter, boolean canRiderInteract, boolean canCollide, RE parentRocket, RE.interact interaction)
    {
        super(hitboxSize, offsetFromCenter, canRiderInteract, canCollide, parentRocket, interaction);
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vec, InteractionHand hand)
    {
        if(player.level().isClientSide) U.openScreen(new NotebookScreen());

        return InteractionResult.SUCCESS;
    }



}
