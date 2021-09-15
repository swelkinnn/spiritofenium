package net.mcreator.genuinelytoomanyadditions.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.block.Blocks;

import net.mcreator.genuinelytoomanyadditions.SoeModVariables;
import net.mcreator.genuinelytoomanyadditions.SoeMod;

import java.util.Map;

public class ItemGeneratorBlockDestroyedByPlayerProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SoeMod.LOGGER.warn("Failed to load dependency world for procedure ItemGeneratorBlockDestroyedByPlayer!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		SoeModVariables.MapVariables.get(world).Amount_Of_Items = Blocks.AIR.getDefaultState();
		SoeModVariables.MapVariables.get(world).syncData(world);
	}
}
