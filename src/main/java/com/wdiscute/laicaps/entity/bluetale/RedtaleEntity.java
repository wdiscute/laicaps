package com.wdiscute.laicaps.entity.bluetale;

import com.wdiscute.laicaps.registry.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RedtaleEntity extends BluetaleEntity
{
    public RedtaleEntity(EntityType<? extends RedtaleEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public ItemStack getBucketItemStack()
    {
        return new ItemStack(ModItems.REDTALE_BUCKET.get());
    }
}
