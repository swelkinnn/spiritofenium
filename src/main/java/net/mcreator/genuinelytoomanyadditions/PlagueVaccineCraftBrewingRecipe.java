
package net.mcreator.genuinelytoomanyadditions;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.genuinelytoomanyadditions.item.PlagueFleshItem;
import net.mcreator.genuinelytoomanyadditions.item.PlagueCureItem;

@SoeModElements.ModElement.Tag
public class PlagueVaccineCraftBrewingRecipe extends SoeModElements.ModElement {
	public PlagueVaccineCraftBrewingRecipe(SoeModElements instance) {
		super(instance, 824);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}
	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == Items.EXPERIENCE_BOTTLE;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == PlagueFleshItem.block;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(PlagueCureItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
