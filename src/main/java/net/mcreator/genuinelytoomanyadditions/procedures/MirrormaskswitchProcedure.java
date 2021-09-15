package net.mcreator.genuinelytoomanyadditions.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.genuinelytoomanyadditions.item.MirrorMaskSadItem;
import net.mcreator.genuinelytoomanyadditions.item.MirrorMaskItem;
import net.mcreator.genuinelytoomanyadditions.item.MirrorMaskDrunkItem;
import net.mcreator.genuinelytoomanyadditions.item.MirrorMaskDiabladaItem;
import net.mcreator.genuinelytoomanyadditions.item.MirrorMaskDemonItem;
import net.mcreator.genuinelytoomanyadditions.SoeMod;

import java.util.Map;
import java.util.HashMap;

public class MirrormaskswitchProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
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
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SoeMod.LOGGER.warn("Failed to load dependency entity for procedure Mirrormaskswitch!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SoeMod.LOGGER.warn("Failed to load dependency world for procedure Mirrormaskswitch!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
				: ItemStack.EMPTY).getItem() == MirrorMaskItem.helmet)) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;
				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if ((((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
							: ItemStack.EMPTY).getItem() == MirrorMaskItem.helmet)) {
						if (entity instanceof LivingEntity) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(MirrorMaskSadItem.helmet));
							else
								((LivingEntity) entity).setItemStackToSlot(
										EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
										new ItemStack(MirrorMaskSadItem.helmet));
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;
							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
								if ((((entity instanceof LivingEntity)
										? ((LivingEntity) entity)
												.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
										: ItemStack.EMPTY).getItem() == MirrorMaskSadItem.helmet)) {
									if (entity instanceof LivingEntity) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(MirrorMaskDemonItem.helmet));
										else
											((LivingEntity) entity).setItemStackToSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
													new ItemStack(MirrorMaskDemonItem.helmet));
										if (entity instanceof ServerPlayerEntity)
											((ServerPlayerEntity) entity).inventory.markDirty();
									}
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private IWorld world;
										public void start(IWorld world, int waitTicks) {
											this.waitTicks = waitTicks;
											MinecraftForge.EVENT_BUS.register(this);
											this.world = world;
										}

										@SubscribeEvent
										public void tick(TickEvent.ServerTickEvent event) {
											if (event.phase == TickEvent.Phase.END) {
												this.ticks += 1;
												if (this.ticks >= this.waitTicks)
													run();
											}
										}

										private void run() {
											if ((((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getItemStackFromSlot(
															EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
													: ItemStack.EMPTY).getItem() == MirrorMaskDemonItem.helmet)) {
												if (entity instanceof LivingEntity) {
													if (entity instanceof PlayerEntity)
														((PlayerEntity) entity).inventory.armorInventory.set((int) 3,
																new ItemStack(MirrorMaskDrunkItem.helmet));
													else
														((LivingEntity) entity).setItemStackToSlot(
																EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
																new ItemStack(MirrorMaskDrunkItem.helmet));
													if (entity instanceof ServerPlayerEntity)
														((ServerPlayerEntity) entity).inventory.markDirty();
												}
												new Object() {
													private int ticks = 0;
													private float waitTicks;
													private IWorld world;
													public void start(IWorld world, int waitTicks) {
														this.waitTicks = waitTicks;
														MinecraftForge.EVENT_BUS.register(this);
														this.world = world;
													}

													@SubscribeEvent
													public void tick(TickEvent.ServerTickEvent event) {
														if (event.phase == TickEvent.Phase.END) {
															this.ticks += 1;
															if (this.ticks >= this.waitTicks)
																run();
														}
													}

													private void run() {
														if ((((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType
																		.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
																: ItemStack.EMPTY).getItem() == MirrorMaskDrunkItem.helmet)) {
															if (entity instanceof LivingEntity) {
																if (entity instanceof PlayerEntity)
																	((PlayerEntity) entity).inventory.armorInventory.set((int) 3,
																			new ItemStack(MirrorMaskDiabladaItem.helmet));
																else
																	((LivingEntity) entity)
																			.setItemStackToSlot(
																					EquipmentSlotType.fromSlotTypeAndIndex(
																							EquipmentSlotType.Group.ARMOR, (int) 3),
																					new ItemStack(MirrorMaskDiabladaItem.helmet));
																if (entity instanceof ServerPlayerEntity)
																	((ServerPlayerEntity) entity).inventory.markDirty();
															}
															new Object() {
																private int ticks = 0;
																private float waitTicks;
																private IWorld world;
																public void start(IWorld world, int waitTicks) {
																	this.waitTicks = waitTicks;
																	MinecraftForge.EVENT_BUS.register(this);
																	this.world = world;
																}

																@SubscribeEvent
																public void tick(TickEvent.ServerTickEvent event) {
																	if (event.phase == TickEvent.Phase.END) {
																		this.ticks += 1;
																		if (this.ticks >= this.waitTicks)
																			run();
																	}
																}

																private void run() {
																	if ((((entity instanceof LivingEntity)
																			? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType
																					.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
																			: ItemStack.EMPTY).getItem() == MirrorMaskDiabladaItem.helmet)) {
																		if (entity instanceof LivingEntity) {
																			if (entity instanceof PlayerEntity)
																				((PlayerEntity) entity).inventory.armorInventory.set((int) 3,
																						new ItemStack(MirrorMaskItem.helmet));
																			else
																				((LivingEntity) entity).setItemStackToSlot(
																						EquipmentSlotType.fromSlotTypeAndIndex(
																								EquipmentSlotType.Group.ARMOR, (int) 3),
																						new ItemStack(MirrorMaskItem.helmet));
																			if (entity instanceof ServerPlayerEntity)
																				((ServerPlayerEntity) entity).inventory.markDirty();
																		}
																	}
																	MinecraftForge.EVENT_BUS.unregister(this);
																}
															}.start(world, (int) 1200);
														}
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 1200);
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 1200);
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 1200);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 1200);
		}
	}
}
