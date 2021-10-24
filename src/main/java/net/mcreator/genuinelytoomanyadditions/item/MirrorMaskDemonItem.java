
package net.mcreator.genuinelytoomanyadditions.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.genuinelytoomanyadditions.procedures.MirrorMaskDemonHelmetTickEventProcedure;
import net.mcreator.genuinelytoomanyadditions.itemgroup.GTMArmorsItemGroup;
import net.mcreator.genuinelytoomanyadditions.SoeModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@SoeModElements.ModElement.Tag
public class MirrorMaskDemonItem extends SoeModElements.ModElement {
	@ObjectHolder("soe:mirror_mask_demon_helmet")
	public static final Item helmet = null;
	@ObjectHolder("soe:mirror_mask_demon_chestplate")
	public static final Item body = null;
	@ObjectHolder("soe:mirror_mask_demon_leggings")
	public static final Item legs = null;
	@ObjectHolder("soe:mirror_mask_demon_boots")
	public static final Item boots = null;
	public MirrorMaskDemonItem(SoeModElements instance) {
		super(instance, 874);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 250;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item_frame.place"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "mirror_mask_demon";
			}

			@Override
			public float getToughness() {
				return 1f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(GTMArmorsItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedHead = new Modelmirrormask2().helmet;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A77What are YOU even saying?"));
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "soe:textures/mirror_mask_demon.png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onArmorTick(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					MirrorMaskDemonHelmetTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("mirror_mask_demon_helmet"));
	}
	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelmirrormask2 extends EntityModel<Entity> {
		private final ModelRenderer helmet;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		public Modelmirrormask2() {
			textureWidth = 32;
			textureHeight = 32;
			helmet = new ModelRenderer(this);
			helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
			helmet.setTextureOffset(0, 9).addBox(-4.0F, -8.0F, -4.2F, 8.0F, 8.0F, 0.0F, 0.0F, false);
			helmet.setTextureOffset(0, 23).addBox(-4.0F, -4.0F, -4.1F, 8.0F, 1.0F, 8.0F, 0.0F, false);
			helmet.setTextureOffset(0, 24).addBox(-2.0F, -9.0F, -5.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
			helmet.setTextureOffset(28, 19).addBox(4.0F, -8.0F, -5.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			helmet.setTextureOffset(0, 24).addBox(-4.0F, -9.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			helmet.setTextureOffset(4, 19).addBox(-1.0F, -7.0F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			helmet.setTextureOffset(0, 24).addBox(-4.0F, 0.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			helmet.setTextureOffset(28, 20).addBox(-5.0F, -8.0F, -5.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(3.5F, -7.0F, -5.5F);
			helmet.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.6109F, -0.4363F, 0.0F);
			cube_r1.setTextureOffset(0, 20).addBox(-0.5F, -2.0F, 0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-3.5F, -7.0F, -5.5F);
			helmet.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.6109F, 0.4363F, 0.0F);
			cube_r2.setTextureOffset(0, 20).addBox(-0.5F, -2.0F, 0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(5.2336F, -9.6698F, -4.5F);
			helmet.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.0F, 0.0873F);
			cube_r3.setTextureOffset(0, 24).addBox(-1.7336F, -1.8302F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(5.2336F, -9.6698F, -4.5F);
			helmet.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, 0.9599F);
			cube_r4.setTextureOffset(0, 24).addBox(-0.7336F, -0.8302F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-3.0F, -7.5F, -4.5F);
			helmet.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, 0.6109F);
			cube_r5.setTextureOffset(0, 24).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(4.5F, -3.5F, -4.5F);
			helmet.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.0F, 0.1309F);
			cube_r6.setTextureOffset(28, 19).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			helmet.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
