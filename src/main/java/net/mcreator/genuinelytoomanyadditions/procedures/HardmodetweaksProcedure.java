package net.mcreator.genuinelytoomanyadditions.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.Hand;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.genuinelytoomanyadditions.SoeModVariables;
import net.mcreator.genuinelytoomanyadditions.SoeMod;

import java.util.Map;
import java.util.HashMap;

public class HardmodetweaksProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntitySpawned(EntityJoinWorldEvent event) {
			Entity entity = event.getEntity();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SoeMod.LOGGER.warn("Failed to load dependency entity for procedure Hardmodetweaks!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SoeMod.LOGGER.warn("Failed to load dependency world for procedure Hardmodetweaks!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((SoeModVariables.MapVariables.get(world).HardMode == (true))) {
			if ((entity instanceof ZombieEntity)) {
				if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
						: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Blocks.STONE_BUTTON));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
									new ItemStack(Blocks.STONE_BUTTON));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				}
				if ((Math.random() < 0.3)) {
					if ((Math.random() < 0.3)) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(Items.STONE_SWORD);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
					} else {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(Items.WOODEN_SWORD);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
					}
				} else {
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				}
				if ((Math.random() < 0.3)) {
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Items.LEATHER_HELMET));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
									new ItemStack(Items.LEATHER_HELMET));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				} else {
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Blocks.STONE_BUTTON));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
									new ItemStack(Blocks.STONE_BUTTON));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				}
				if ((Math.random() < 0.3)) {
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 2, new ItemStack(Items.LEATHER_CHESTPLATE));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2),
									new ItemStack(Items.LEATHER_CHESTPLATE));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				} else {
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 2, new ItemStack(Blocks.STONE_BUTTON));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2),
									new ItemStack(Blocks.STONE_BUTTON));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				}
				if ((Math.random() < 0.3)) {
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 1, new ItemStack(Items.LEATHER_LEGGINGS));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1),
									new ItemStack(Items.LEATHER_LEGGINGS));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				} else {
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 1, new ItemStack(Blocks.STONE_BUTTON));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1),
									new ItemStack(Blocks.STONE_BUTTON));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				}
				if ((Math.random() < 0.3)) {
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 0, new ItemStack(Items.LEATHER_BOOTS));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0),
									new ItemStack(Items.LEATHER_BOOTS));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				} else {
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 0, new ItemStack(Blocks.STONE_BUTTON));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0),
									new ItemStack(Blocks.STONE_BUTTON));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				}
			}
		}
	}
}
