
package net.mcreator.genuinelytoomanyadditions.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.genuinelytoomanyadditions.itemgroup.GTMBlocksItemGroup;
import net.mcreator.genuinelytoomanyadditions.SoeModElements;

import java.util.List;
import java.util.Collections;

@SoeModElements.ModElement.Tag
public class FadedOrangeConcreteBlock extends SoeModElements.ModElement {
	@ObjectHolder("soe:faded_orange_concrete")
	public static final Block block = null;
	public FadedOrangeConcreteBlock(SoeModElements instance) {
		super(instance, 805);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(GTMBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.8f, 1.8f).setLightLevel(s -> 0));
			setRegistryName("faded_orange_concrete");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
