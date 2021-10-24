package net.mcreator.genuinelytoomanyadditions.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.genuinelytoomanyadditions.potion.ZombificationPotionEffect;
import net.mcreator.genuinelytoomanyadditions.SoeMod;

import java.util.Map;
import java.util.Collection;

public class ZombificationOnPotionActiveTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SoeMod.LOGGER.warn("Failed to load dependency entity for procedure ZombificationOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == ZombificationPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			if (((entity.getPersistentData().getDouble("zombTick")) == 0)) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).attackEntityFrom(new DamageSource("zombification").setDamageBypassesArmor(), (float) 1);
				}
				entity.getPersistentData().putDouble("zombTick", 50);
			} else {
				entity.getPersistentData().putDouble("zombTick", ((entity.getPersistentData().getDouble("zombTick")) - 1));
			}
		}
	}
}
