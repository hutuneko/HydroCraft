package com.hutuneko.hydrocraft;

import com.hutuneko.hydrocraft.water.QualityWater;
import com.hutuneko.hydrocraft.water.QualityWaterEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.hutuneko.hydrocraft.HydroCraft.MODID;

public class ModRegister {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCKENTITIYS = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,MODID);



    public static final RegistryObject<BlockEntityType<QualityWaterEntity>> QUALITYWATERENTITY = BLOCKENTITIYS.register(
            "qualitywaterentity", () -> BlockEntityType.Builder.of(QualityWaterEntity::new, PsiEXRegistry.MULTIPAGEPROGRAMMER.get())
                    .build(null));)

}
