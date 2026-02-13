package com.wdiscute.laicaps;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.Random;

public class U
{
    public static final Random r = new Random();

    @OnlyIn(Dist.CLIENT)
    public static void openScreen(Screen screen)
    {
        Minecraft.getInstance().setScreen(screen);
    }
}
