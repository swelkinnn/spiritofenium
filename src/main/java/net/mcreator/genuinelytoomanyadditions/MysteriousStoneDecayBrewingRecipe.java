
package net.mcreator.genuinelytoomanyadditions;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.genuinelytoomanyadditions.item.NegradoStoneItem;
import net.mcreator.genuinelytoomanyadditions.block.MysteriousStoneBlock;

@SoeModElements.ModElement.Tag
public class MysteriousStoneDecayBrewingRecipe extends SoeModElements.ModElement {
	public MysteriousStoneDecayBrewingRecipe(SoeModElements instance) {
		super(instance, 853);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}
	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == MysteriousStoneBlock.block.asItem();
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Items.ROTTEN_FLESH;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(NegradoStoneItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
