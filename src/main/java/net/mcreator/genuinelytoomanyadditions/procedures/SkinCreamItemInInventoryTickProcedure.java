package net.mcreator.genuinelytoomanyadditions.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.genuinelytoomanyadditions.potion.DecayPotionEffect;
import net.mcreator.genuinelytoomanyadditions.SoeMod;

import java.util.Map;
import java.util.Collection;

public class SkinCreamItemInInventoryTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SoeMod.LOGGER.warn("Failed to load dependency entity for procedure SkinCreamItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == DecayPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(DecayPotionEffect.potion);
			}
		}
	}
}
