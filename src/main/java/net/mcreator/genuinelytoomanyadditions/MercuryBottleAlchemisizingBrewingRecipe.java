
package net.mcreator.genuinelytoomanyadditions;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.genuinelytoomanyadditions.item.MercuryBottleItem;
import net.mcreator.genuinelytoomanyadditions.item.AlchemicalMercuryItem;

@SoeModElements.ModElement.Tag
public class MercuryBottleAlchemisizingBrewingRecipe extends SoeModElements.ModElement {
	public MercuryBottleAlchemisizingBrewingRecipe(SoeModElements instance) {
		super(instance, 852);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}
	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == MercuryBottleItem.block;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Items.GOLD_INGOT;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(AlchemicalMercuryItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
