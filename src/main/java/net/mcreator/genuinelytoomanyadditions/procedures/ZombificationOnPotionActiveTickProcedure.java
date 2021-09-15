package net.mcreator.genuinelytoomanyadditions.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.genuinelytoomanyadditions.SoeMod;

import java.util.Map;

public class ZombificationOnPotionActiveTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SoeMod.LOGGER.warn("Failed to load dependency entity for procedure ZombificationOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(entity instanceof PlayerEntity))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		} else {
			if ((Math.random() < 0.1)) {
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0) >= 5)) {
					if ((Math.random() < 0.1)) {
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).attackEntityFrom(new DamageSource("zombification").setDamageBypassesArmor(), (float) 1);
						}
					}
				} else {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).attackEntityFrom(new DamageSource("zombification").setDamageBypassesArmor(), (float) 1);
					}
				}
			}
		}
	}
}
