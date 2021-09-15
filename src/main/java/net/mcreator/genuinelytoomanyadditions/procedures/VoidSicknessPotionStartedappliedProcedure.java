package net.mcreator.genuinelytoomanyadditions.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.genuinelytoomanyadditions.potion.VoidSicknessPotionEffect;
import net.mcreator.genuinelytoomanyadditions.SoeMod;

import java.util.Map;
import java.util.HashMap;

public class VoidSicknessPotionStartedappliedProcedure {
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
				SoeMod.LOGGER.warn("Failed to load dependency entity for procedure VoidSicknessPotionStartedapplied!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SoeMod.LOGGER.warn("Failed to load dependency y for procedure VoidSicknessPotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		if ((((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("soe:nowhere"))))
				|| ((entity.world.getDimensionKey()) == (World.THE_END)))) {
			if ((y < 20)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(VoidSicknessPotionEffect.potion, (int) 60, (int) 0, (true), (false)));
			}
		}
	}
}
