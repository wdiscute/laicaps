package com.wdiscute.laicaps.entity.bluetale;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.wdiscute.laicaps.Laicaps;
import com.wdiscute.laicaps.ModItems;
import com.wdiscute.laicaps.entity.glimpuff.GlimpuffEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderItemInFrameEvent;
import net.neoforged.neoforge.common.NeoForge;

public class BluetaleRenderer extends MobRenderer<BluetaleEntity, BluetaleModel<BluetaleEntity>>
{

    ItemRenderer itemRenderer;

    public BluetaleRenderer(EntityRendererProvider.Context context)
    {
        super(context, new BluetaleModel<>(context.bakeLayer(BluetaleModel.LAYER_LOCATION)), 0.25f);
        itemRenderer = context.getItemRenderer();
    }

    @Override
    public ResourceLocation getTextureLocation(BluetaleEntity bluetaleEntity)
    {
        return Laicaps.rl("textures/entity/bluetale/bluetale.png");
    }

    @Override
    protected void setupRotations(BluetaleEntity entity, PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale)
    {
        super.setupRotations(entity, poseStack, bob, yBodyRot, partialTick, scale);
        if (!entity.isInWater())
        {
            float f = 1.3F;
            float f1 = 1.7F;
            float f2 = f * 4.3F * Mth.sin(f1 * 0.6F * bob);
            poseStack.mulPose(Axis.YP.rotationDegrees(f2));
            poseStack.translate(0.2F, 0.1F, 0.0F);
            poseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }
    }

    @Override
    public void render(BluetaleEntity bluetaleEntity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
        if(bluetaleEntity.isBaby())
        {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        }else
        {
            poseStack.scale(1f,1f,1f);
        }

        poseStack.pushPose();

        poseStack.mulPose(Axis.XP.rotationDegrees(bluetaleEntity.getXRot()));
        poseStack.mulPose(Axis.YP.rotationDegrees(90 - bluetaleEntity.getYRot()));

        poseStack.mulPose(Axis.ZP.rotationDegrees(45));

        if (!bluetaleEntity.isInWater()) {
            poseStack.mulPose(Axis.XP.rotationDegrees(90));
            poseStack.mulPose(Axis.YP.rotationDegrees(90));
        }

        ItemStack itemstack = new ItemStack(ModItems.AZURE_TUNA.get());

        this.itemRenderer.renderStatic(itemstack, ItemDisplayContext.FIXED, packedLight,
                OverlayTexture.NO_OVERLAY, poseStack, buffer, bluetaleEntity.level(), bluetaleEntity.getId());

        poseStack.popPose();


        super.render(bluetaleEntity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
