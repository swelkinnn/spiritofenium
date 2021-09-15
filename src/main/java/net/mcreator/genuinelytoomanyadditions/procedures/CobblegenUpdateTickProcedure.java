package net.mcreator.genuinelytoomanyadditions.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.genuinelytoomanyadditions.block.CobblegenBlock;
import net.mcreator.genuinelytoomanyadditions.SoeModVariables;
import net.mcreator.genuinelytoomanyadditions.SoeMod;

import java.util.Map;
import java.util.HashMap;

public class CobblegenUpdateTickProcedure {
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
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SoeMod.LOGGER.warn("Failed to load dependency x for procedure CobblegenUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SoeMod.LOGGER.warn("Failed to load dependency y for procedure CobblegenUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SoeMod.LOGGER.warn("Failed to load dependency z for procedure CobblegenUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SoeMod.LOGGER.warn("Failed to load dependency world for procedure CobblegenUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CobblegenBlock.block)) {
			if ((SoeModVariables.MapVariables.get(world).machinetimer == 0)) {
				SoeModVariables.MapVariables.get(world).machinetimer = (double) 100;
				SoeModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (Math.floor(x)), (Math.floor(y)), (Math.floor(z)),
							new ItemStack(Blocks.COBBLESTONE));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else {
				SoeModVariables.MapVariables.get(world).machinetimer = (double) (SoeModVariables.MapVariables.get(world).machinetimer - 1);
				SoeModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
