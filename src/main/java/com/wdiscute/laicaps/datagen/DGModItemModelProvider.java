package com.wdiscute.laicaps.datagen;

import com.wdiscute.laicaps.Laicaps;
import com.wdiscute.laicaps.registry.ModBlocks;
import com.wdiscute.laicaps.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class DGModItemModelProvider extends ItemModelProvider
{
    public DGModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, Laicaps.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {

//        spawnEggItem(ModItems.SNUFFLER_SPAWN_EGG.asItem());
//        spawnEggItem(ModItems.SWIBBLE_SPAWN_EGG.asItem());
//        spawnEggItem(ModItems.GLIMPUFF_SPAWN_EGG.asItem());
//        spawnEggItem(ModItems.BUBBLEMOUTH_SPAWN_EGG.asItem());
//        spawnEggItem(ModItems.MOONRAY_SPAWN_EGG.asItem());
//        spawnEggItem(ModItems.REDTALE_SPAWN_EGG.asItem());
//        spawnEggItem(ModItems.BLUETALE_SPAWN_EGG.asItem());
//
//        simpleItem(ModItems.CHISEL);
//        simpleItem(ModItems.SPACESHIP_BLUEPRINT);
//        simpleItem(ModItems.NOTEBOOK);
//
//        simpleItem(ModItems.EMBER_ENTRY);
//        simpleItem(ModItems.ASHA_ENTRY);
//        simpleItem(ModItems.OVERWORLD_ENTRY);
//        simpleItem(ModItems.LUNAMAR_ENTRY);
//
//        simpleItem(ModItems.BASIC_MICROCHIP);
//        simpleItem(ModItems.REFINED_MICROCHIP);
//        simpleItem(ModItems.ADVANCED_MICROCHIP);
//        simpleItem(ModItems.ELITE_MICROCHIP);
//
//        simpleItem(ModItems.TELESCOPE_LENSES);
//        simpleItem(ModItems.TELESCOPE_UPGRADE_KIT);
//
//        simpleItem(ModItems.ENDERBLAZE_FUEL);
//        simpleItem(ModItems.PRISTINE_ENDERPEARL_DUST);
//
//        //asha
//        simpleItem(ModItems.SWEETLILY_SUGAR);
//        simpleItem(ModItems.SNUFFLER_CHOP);
//
//        //bluetale & redtale
//        simpleItem(ModItems.BLUETALE);
//        simpleItem(ModItems.COOKED_BLUETALE);
//        simpleItem(ModItems.BLUETALE_BUCKET);
//        simpleItem(ModItems.REDTALE);
//        simpleItem(ModItems.COOKED_REDTALE);
//        simpleItem(ModItems.REDTALE_BUCKET);
//
//        //bubblemouth
//        simpleItem(ModItems.BUBBLEMOUTH);
//        simpleItem(ModItems.COOKED_BUBBLEMOUTH);
//        simpleItem(ModItems.BUBBLEMOUTH_BUCKET);
//
//        //bubblemouth
//        simpleItem(ModItems.MOONRAY);
//        simpleItem(ModItems.MOONRAY_BUCKET);
//
//        //bubblemouth
//        simpleItem(ModItems.GLIMPUFF);
//        simpleItem(ModItems.COOKED_GLIMPUFF);
//        simpleItem(ModItems.GLIMPUFF_BUCKET);
//
//        //nimble
//        simpleItem(ModItems.NIMBLE_SWEET_TREAT);
//
//
//        //oakheart
//        simpleItem(ModItems.OAKHEART_BERRIES);
//        simpleItem(ModItems.OAKHEART_BERRIES_JAM);
//
//        simpleItem(ModItems.OAKHEART_DOOR);
//        simpleItem(ModItems.OAKHEART_SIGN);
//        simpleItem(ModItems.OAKHEART_HANGING_SIGN);
//        simpleItem(ModItems.OAKHEART_BOAT);
//        simpleItem(ModItems.OAKHEART_CHEST_BOAT);
//
//        //oakroot
//        simpleItem(ModItems.OAKROOT_DOOR);
//        simpleItem(ModItems.OAKROOT_SIGN);
//        simpleItem(ModItems.OAKROOT_HANGING_SIGN);
//        simpleItem(ModItems.OAKROOT_BOAT);
//        simpleItem(ModItems.OAKROOT_CHEST_BOAT);
//
//        //lunamar
//        simpleItem(ModItems.MOONSHADE_FRUIT);
    }

    private ItemModelBuilder simpleItem(DeferredItem<? extends Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated")).texture("layer0",
                modLoc("item/" + item.getId().getPath()));
    }

}
