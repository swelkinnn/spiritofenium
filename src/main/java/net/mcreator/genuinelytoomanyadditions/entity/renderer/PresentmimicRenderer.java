package net.mcreator.genuinelytoomanyadditions.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.genuinelytoomanyadditions.entity.PresentmimicEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PresentmimicRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(PresentmimicEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelpresent(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("soe:textures/present_mimic.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelpresent extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer bone2;
		private final ModelRenderer bb_main;
		public Modelpresent() {
			textureWidth = 64;
			textureHeight = 64;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone.setTextureOffset(4, 44).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 8.0F, 12.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 16.0F, 5.0F);
			setRotationAngle(bone2, -0.3927F, 0.0F, 0.0F);
			bone2.setTextureOffset(24, 34).addBox(-5.0F, -11.0F, -5.0F, 5.0F, 6.0F, 0.0F, 0.0F, false);
			bone2.setTextureOffset(14, 34).addBox(0.0F, -11.0F, -5.0F, 5.0F, 6.0F, 0.0F, 0.0F, false);
			bone2.setTextureOffset(8, 15).addBox(-7.0F, -5.0F, -12.0F, 14.0F, 5.0F, 14.0F, 0.0F, true);
			bone2.setTextureOffset(6, 43).addBox(-5.0F, -4.0F, -10.0F, 10.0F, 1.0F, 0.0F, 0.0F, false);
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(35, 34).addBox(-4.0F, -10.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(43, 34).addBox(2.0F, -11.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(51, 21).addBox(3.0F, -9.0F, -7.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(50, 25).addBox(3.0F, -8.0F, -7.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 43).addBox(-5.0F, -9.0F, -5.0F, 8.0F, 1.0F, 0.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 43).addBox(-5.0F, -12.0F, -5.0F, 10.0F, 1.0F, 0.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			bone2.render(matrixStack, buffer, packedLight, packedOverlay);
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.bone2.rotateAngleY = f4 / (180F / (float) Math.PI);
		}
	}
}
