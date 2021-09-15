/*
 *    MCreator note:
 *
 *    This file is autogenerated to connect all MCreator mod elements together.
 *
 */
package net.mcreator.genuinelytoomanyadditions;

import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.block.Block;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public class SoeModElements {
	public final List<ModElement> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<EntityType<?>>> entities = new ArrayList<>();
	public final List<Supplier<Enchantment>> enchantments = new ArrayList<>();
	public static Map<ResourceLocation, net.minecraft.util.SoundEvent> sounds = new HashMap<>();
	public SoeModElements() {
		sounds.put(new ResourceLocation("soe", "asmodeuschant"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "asmodeuschant")));
		sounds.put(new ResourceLocation("soe", "abaddonchant"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "abaddonchant")));
		sounds.put(new ResourceLocation("soe", "mothman_idle"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "mothman_idle")));
		sounds.put(new ResourceLocation("soe", "mothman_hurts"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "mothman_hurts")));
		sounds.put(new ResourceLocation("soe", "mothman_dies"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "mothman_dies")));
		sounds.put(new ResourceLocation("soe", "wendigo_dies"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "wendigo_dies")));
		sounds.put(new ResourceLocation("soe", "wendigo_hit"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "wendigo_hit")));
		sounds.put(new ResourceLocation("soe", "wendigo_idles"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "wendigo_idles")));
		sounds.put(new ResourceLocation("soe", "wendigo_steps"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "wendigo_steps")));
		sounds.put(new ResourceLocation("soe", "grimmtrouperecord"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "grimmtrouperecord")));
		sounds.put(new ResourceLocation("soe", "nowhere_song_1"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "nowhere_song_1")));
		sounds.put(new ResourceLocation("soe", "nowhere_song_2"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "nowhere_song_2")));
		sounds.put(new ResourceLocation("soe", "abysswind"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "abysswind")));
		sounds.put(new ResourceLocation("soe", "grimm_murmur"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "grimm_murmur")));
		sounds.put(new ResourceLocation("soe", "grimm_hurt"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "grimm_hurt")));
		sounds.put(new ResourceLocation("soe", "grimm_death"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "grimm_death")));
		sounds.put(new ResourceLocation("soe", "wendigo_spawns"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "wendigo_spawns")));
		sounds.put(new ResourceLocation("soe", "lightspell"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "lightspell")));
		sounds.put(new ResourceLocation("soe", "darkspell"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "darkspell")));
		sounds.put(new ResourceLocation("soe", "heavyspell"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "heavyspell")));
		sounds.put(new ResourceLocation("soe", "summoningspell"), new net.minecraft.util.SoundEvent(new ResourceLocation("soe", "summoningspell")));
		try {
			ModFileScanData modFileInfo = ModList.get().getModFileById("soe").getFile().getScanResult();
			Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations();
			for (ModFileScanData.AnnotationData annotationData : annotations) {
				if (annotationData.getAnnotationType().getClassName().equals(ModElement.Tag.class.getName())) {
					Class<?> clazz = Class.forName(annotationData.getClassType().getClassName());
					if (clazz.getSuperclass() == SoeModElements.ModElement.class)
						elements.add((SoeModElements.ModElement) clazz.getConstructor(this.getClass()).newInstance(this));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(elements);
		elements.forEach(SoeModElements.ModElement::initElements);
		MinecraftForge.EVENT_BUS.register(new SoeModVariables(this));
	}

	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
		for (Map.Entry<ResourceLocation, net.minecraft.util.SoundEvent> sound : sounds.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
	private int messageID = 0;
	public <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, PacketBuffer> encoder, Function<PacketBuffer, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		SoeMod.PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	public List<ModElement> getElements() {
		return elements;
	}

	public List<Supplier<Block>> getBlocks() {
		return blocks;
	}

	public List<Supplier<Item>> getItems() {
		return items;
	}

	public List<Supplier<EntityType<?>>> getEntities() {
		return entities;
	}

	public List<Supplier<Enchantment>> getEnchantments() {
		return enchantments;
	}
	public static class ModElement implements Comparable<ModElement> {
		@Retention(RetentionPolicy.RUNTIME)
		public @interface Tag {
		}
		protected final SoeModElements elements;
		protected final int sortid;
		public ModElement(SoeModElements elements, int sortid) {
			this.elements = elements;
			this.sortid = sortid;
		}

		public void initElements() {
		}

		public void init(FMLCommonSetupEvent event) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
		}

		@Override
		public int compareTo(ModElement other) {
			return this.sortid - other.sortid;
		}
	}
}