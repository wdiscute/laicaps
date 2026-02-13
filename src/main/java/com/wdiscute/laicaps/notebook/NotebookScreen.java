package com.wdiscute.laicaps.notebook;

import com.mojang.blaze3d.systems.RenderSystem;
import com.wdiscute.laicaps.Laicaps;
import com.wdiscute.laicaps.registry.io.ModDataAttachments;
import com.wdiscute.laicaps.util.AdvHelper;
import com.wdiscute.libtooltips.Tooltips;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NotebookScreen extends net.minecraft.client.gui.screens.Screen
{

    private static final NotebookEntry.Image BOOKMARK_BACKGROUND = new NotebookEntry.Image(Laicaps.rl("textures/gui/notebook/bookmark_background.png"), 32, 32, 0, 0);
    private static final ResourceLocation BOOKMARK = Laicaps.rl("textures/gui/notebook/bookmark.png");
    private static final ResourceLocation ARROW_PREVIOUS = Laicaps.rl("textures/gui/notebook/arrow_previous.png");
    private static final ResourceLocation ARROW_NEXT = Laicaps.rl("textures/gui/notebook/arrow_next.png");

    private static final ResourceLocation MENU_SELECTED = Laicaps.rl("textures/gui/notebook/menu_selected.png");
    private static final ResourceLocation EMBER_SELECTED = Laicaps.rl("textures/gui/notebook/ember_selected.png");
    private static final ResourceLocation ASHA_SELECTED = Laicaps.rl("textures/gui/notebook/asha_selected.png");
    private static final ResourceLocation OVERWORLD_SELECTED = Laicaps.rl("textures/gui/notebook/overworld_selected.png");
    private static final ResourceLocation LUNAMAR_SELECTED = Laicaps.rl("textures/gui/notebook/lunamar_selected.png");

    private static final NotebookEntry.Image MENU_HIGHLIGHT = new NotebookEntry.Image(Laicaps.rl("textures/gui/notebook/planet_group_highlight.png"), 16, 16, -30, 0);
    private static final NotebookEntry.Image EMBER_HIGHLIGHT = new NotebookEntry.Image(Laicaps.rl("textures/gui/notebook/planet_group_highlight.png"), 16, 16, -30, 0);
    private static final NotebookEntry.Image ASHA_HIGHLIGHT = new NotebookEntry.Image(Laicaps.rl("textures/gui/notebook/planet_group_highlight.png"), 16, 16, -30, 0);
    private static final NotebookEntry.Image OVERWORLD_HIGHLIGHT = new NotebookEntry.Image(Laicaps.rl("textures/gui/notebook/planet_group_highlight.png"), 16, 16, -30, 0);
    private static final NotebookEntry.Image LUNAMAR_HIGHLIGHT = new NotebookEntry.Image(Laicaps.rl("textures/gui/notebook/planet_group_highlight.png"), 16, 16, -30, 0);


    List<ResourceLocation> bookmarks = new ArrayList<>();

    Random r = new Random();

    int uiX;
    int uiY;

    List<NotebookEntry> entries = new ArrayList<>();
    int currentEntry = 0;

    List<String> obfuscatedLeft = new ArrayList<>();
    List<String> obfuscatedRight = new ArrayList<>();

    private void reObfuscate()
    {
        //generate list of strings with random amounts of characters for the obfuscated entries
        minecraft.player.playSound(SoundEvents.BOOK_PAGE_TURN);
        obfuscatedLeft.clear();
        obfuscatedRight.clear();
        //left
        for (int i = 0; i < 19; i++)
        {
            if (r.nextFloat(1f) < 0.8)
            {
                String s = "";
                for (int j = 0; j < r.nextInt(30, 55); j++)
                    s = r.nextFloat() < 0.85 ? s.concat("|") : s.concat(" ");

                obfuscatedLeft.add(s);
            } else
            {
                obfuscatedLeft.add("");
            }
        }
        //right
        for (int i = 0; i < 19; i++)
        {
            if (r.nextFloat(1f) < 0.8)
            {
                String s = "";
                for (int j = 0; j < r.nextInt(30, 55); j++)
                    s = r.nextFloat() < 0.85 ? s.concat("|") : s.concat(" ");

                obfuscatedRight.add(s);
            } else
            {
                obfuscatedRight.add("");
            }
        }


    }

    @Override
    protected void init()
    {
        super.init();
        reObfuscate();
        bookmarks = ModDataAttachments.get(Minecraft.getInstance().player, ModDataAttachments.BOOKMARKS);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        double x = mouseX - uiX;
        double y = mouseY - uiY;

        //previous arrow
        if (x > 68 && x < 105 && y > 230 && y < 240)
        {
            //todo previous arrow
        }

        //next arrow
        if (x > 420 && x < 440 && y > 230 && y < 240)
        {
            //todo next arrow
        }

        //menu lil planet
        if (x >= 297 && x <= 312 && y >= 226 && y <= 241)
        {
            //todo group jumping
            reObfuscate();
        }

        //ember lil planet
        if (x >= 324 && x <= 339 && y >= 226 && y <= 241)
        {
            reObfuscate();
        }
        //asha lil planet
        if (x >= 351 && x <= 366 && y >= 226 && y <= 241)
        {
            reObfuscate();
        }
        //overworld lil planet
        if (x >= 378 && x <= 393 && y >= 226 && y <= 241)
        {
            reObfuscate();
        }
        //lunamar lil planet
        if (x >= 405 && x <= 420 && y >= 226 && y <= 241)
        {
            reObfuscate();
        }


        //save bookmark
        if (x > 277 && x < 298 && y > 3 && y < 29)
        {
            //todo packet for bookmarks handling with data attachment
        }

        for (int i = 0; i < 10; i++)
        {
            if (bookmarks.size() < i) break;

            if (x > 31 && x < 59 && y > 7 + (i * 26) && y < 31 + (i * 26))
            {
                //todo bookmark jumping
                entries.forEach(e ->
                {
                    //if(e.equals()
                    //currentEntry = whatever;
                });
            }
        }


        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick)
    {
        super.render(guiGraphics, mouseX, mouseY, partialTick);


        //initial setup every frame
        double x = mouseX - uiX;
        double y = mouseY - uiY;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);

        NotebookEntry ne = entries.get(currentEntry);

        //todo this vvvvvv
        //boolean entryUnlocked = ModDataAttachments.get(Minecraft.getInstance().player, ModDataAttachments.ENTRIES_UNLOCKED).contains())
        boolean entryUnlocked = true;

        //render background
        renderImage(guiGraphics, ne.background());

        //render background
        renderImage(guiGraphics, ne.background());

        if (x >= 297 && x <= 312 && y >= 226 && y <= 241) renderImage(guiGraphics, MENU_HIGHLIGHT);
        if (x >= 324 && x <= 339 && y >= 226 && y <= 241) renderImage(guiGraphics, EMBER_HIGHLIGHT);
        if (x >= 351 && x <= 366 && y >= 226 && y <= 241) renderImage(guiGraphics, ASHA_HIGHLIGHT);
        if (x >= 378 && x <= 393 && y >= 226 && y <= 241) renderImage(guiGraphics, OVERWORLD_HIGHLIGHT);
        if (x >= 405 && x <= 420 && y >= 226 && y <= 241) renderImage(guiGraphics, LUNAMAR_HIGHLIGHT);


        //render arrows above everything else
        //todo only show arros when theres no previous/next page
        guiGraphics.blit(ARROW_PREVIOUS, uiX + 65, uiY + 227, 0, 0, 23, 13, 23, 13);
        guiGraphics.blit(ARROW_NEXT, uiX + 420, uiY + 227, 0, 0, 23, 13, 23, 13);


        //render page index at the bottom
        {
            if (entryUnlocked || !ne.hideUntilUnlocked())
            {
                guiGraphics.drawString(this.font, Tooltips.decodeTranslationKey(ne.title()), uiX + 90, uiY + 230, 0, false);
            } else
            {
                String s = "gui.notebook.missing";
                guiGraphics.drawString(this.font, Tooltips.decodeTranslationKey(s), uiX + 100, uiY + 230, 0, false);
            }


        }


        //render page number on bottom left
        {
            //todo figure out a way to check the number of entries per group to display here
            int entriesMax = 0;
            guiGraphics.drawString(
                    this.font, Component.literal("[" + currentEntry + "/" + entriesMax + "]"),
                    uiX + 213, uiY + 230, 0, false);
        }

        //if entry not unlocked, displays obfuscated text on both pages
        if (!entryUnlocked && ne.hideUntilUnlocked())
        {
            //left title obfuscated
            guiGraphics.drawString(this.font, Component.literal("            §c§k§l!!!!!!!!!!!!!!!!!!!!!!!!"), uiX + 65, uiY + 20, 0, true);

            //left obfuscated text
            for (int i = 0; i < 16; i++)
                guiGraphics.drawString(this.font, Component.literal("§c§k§l" + obfuscatedLeft.get(i)), uiX + 65, uiY + 60 + (i * 10), 0, true);

            //right obfuscated text
            for (int i = 0; i < 19; i++)
                guiGraphics.drawString(this.font, Component.literal("§c§k§l" + obfuscatedRight.get(i)), uiX + 268, uiY + 30 + (i * 10), 0, true);

        } else
        {
            //render text left
            for (int i = 0; i < 21; i++)
            {
                String key = ne.text() + ".left." + i;
                if (I18n.exists(key))
                    guiGraphics.drawString(this.font, Tooltips.decodeTranslationKey(key), uiX + 65, uiY + 10 + (i * 10), 0, false);
            }

            //render text right
            for (int i = 0; i < 21; i++)
            {
                String key = ne.text() + ".right." + i;
                if (I18n.exists(key))
                    guiGraphics.drawString(this.font, Tooltips.decodeTranslationKey(key), uiX + 272, uiY + 10 + (i * 10), 0, false);
            }
        }


        //render bookmark
        //todo render differently if the current entry is bookmarked
        renderImage(guiGraphics, BOOKMARK_BACKGROUND);
//        if(moddataattachemnts.contains(entry))


    }

    public NotebookScreen()
    {
        super(Component.empty());
    }


    private void renderImage(GuiGraphics guiGraphics, NotebookEntry.Image image)
    {
        uiX = (width - image.width()) / 2;
        uiY = (height - image.height()) / 2;

        guiGraphics.blit(image.path(),
                uiX,
                uiY,
                image.offsetX(),
                image.offsetY(),
                image.width(),
                image.height(),
                image.width(),
                image.height());
    }
}