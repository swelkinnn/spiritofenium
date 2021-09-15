
package net.mcreator.genuinelytoomanyadditions;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.genuinelytoomanyadditions.item.ManaPotionItem;

@SoeModElements.ModElement.Tag
public class ManapotBrewingRecipe extends SoeModElements.ModElement {
	public ManapotBrewingRecipe(SoeModElements instance) {
		super(instance, 981);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}
	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == Items.GLASS_BOTTLE;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Items.EXPERIENCE_BOTTLE;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(ManaPotionItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
