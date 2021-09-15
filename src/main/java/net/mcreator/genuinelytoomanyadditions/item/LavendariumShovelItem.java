
package net.mcreator.genuinelytoomanyadditions.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.genuinelytoomanyadditions.itemgroup.GMTToolsAndWeaponsItemGroup;
import net.mcreator.genuinelytoomanyadditions.SoeModElements;

@SoeModElements.ModElement.Tag
public class LavendariumShovelItem extends SoeModElements.ModElement {
	@ObjectHolder("soe:lavendarium_shovel")
	public static final Item block = null;
	public LavendariumShovelItem(SoeModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 275;
			}

			public float getEfficiency() {
				return 7.5f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LavendariumNuggetItem.block), new ItemStack(LavendariumMeshItem.block),
						new ItemStack(LavendariumIngotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(GMTToolsAndWeaponsItemGroup.tab)) {
		}.setRegistryName("lavendarium_shovel"));
	}
}
