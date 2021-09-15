
package net.mcreator.genuinelytoomanyadditions;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

@SoeModElements.ModElement.Tag
public class Xpbottlecraft2BrewingRecipe extends SoeModElements.ModElement {
	public Xpbottlecraft2BrewingRecipe(SoeModElements instance) {
		super(instance, 663);
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
			return ingredient.getItem() == Items.LAPIS_LAZULI;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(Items.EXPERIENCE_BOTTLE);
			}
			return ItemStack.EMPTY;
		}
	}
}
