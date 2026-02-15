package com.hutuneko.hydrocraft;

import com.hutuneko.hydrocraft.water.QualityWater;
import com.hutuneko.hydrocraft.water.QualityWaterEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.*;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.hutuneko.hydrocraft.HydroCraft.MODID;

public class ModRegister {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCKENTITIYS = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,MODID);
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, MODID);
    public static final DeferredRegister<FluidType> FLUIDTYPES =
            DeferredRegister.create(ForgeRegistries.FLUID_TYPES.get(), MODID);


    // 流体プロパティ
    public static final ForgeFlowingFluid.Properties ACID_PROPERTIES =
            new ForgeFlowingFluid.Properties(
                    Fluids.WATER,
                    () -> Fluids.EMPTY,
                    () -> Fluids.WATER
            );
    // 静止した液体
    public static final RegistryObject<FlowingFluid> ACID = FLUIDS.register("acid",
            () -> new ForgeFlowingFluid.Source(ACID_PROPERTIES)
    );

    // 流れる液体
    public static final RegistryObject<FlowingFluid> ACID_FLOWING = FLUIDS.register("acid_flowing",
            () -> new ForgeFlowingFluid.Flowing(ACID_PROPERTIES)
    );

    public static final RegistryObject<LiquidBlock> ACID_BLOCK = BLOCKS.register("acid",
            () -> new QualityWater(
                    ACID,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_BLUE)
                            .replaceable()
                            .noCollission()
                            .strength(100.0F)
                            .pushReaction(PushReaction.DESTROY)
                            .noLootTable()
                            .liquid()
                            .sound(SoundType.EMPTY)
            )
    );

    public static final RegistryObject<BlockEntityType<QualityWaterEntity>> QUALITYWATERENTITY = BLOCKENTITIYS.register(
            "qualitywaterentity", () -> BlockEntityType.Builder.of(QualityWaterEntity::new, PsiEXRegistry.MULTIPAGEPROGRAMMER.get())
                    .build(null));)

}
