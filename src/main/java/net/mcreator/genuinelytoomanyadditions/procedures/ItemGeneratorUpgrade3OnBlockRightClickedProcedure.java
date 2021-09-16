package net.mcreator.genuinelytoomanyadditions.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.genuinelytoomanyadditions.item.MachineSpeedUpgradeGoldItem;
import net.mcreator.genuinelytoomanyadditions.SoeMod;

import java.util.Map;

public class ItemGeneratorUpgrade3OnBlockRightClickedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SoeMod.LOGGER.warn("Failed to load dependency entity for procedure ItemGeneratorUpgrade3OnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == MachineSpeedUpgradeGoldItem.block)) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Speed Maxed"), (true));
			}
		}
	}
}
