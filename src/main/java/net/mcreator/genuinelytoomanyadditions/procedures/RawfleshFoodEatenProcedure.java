package net.mcreator.genuinelytoomanyadditions.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.genuinelytoomanyadditions.potion.WendigoCursePotionEffect;
import net.mcreator.genuinelytoomanyadditions.SoeMod;

import java.util.Map;

public class RawfleshFoodEatenProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SoeMod.LOGGER.warn("Failed to load dependency entity for procedure RawfleshFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(WendigoCursePotionEffect.potion, (int) 1200, (int) 1));
	}
}
