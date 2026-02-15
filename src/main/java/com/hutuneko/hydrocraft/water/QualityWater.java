package com.hutuneko.hydrocraft.water;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class QualityWater extends LiquidBlock implements EntityBlock {
    public QualityWater(Supplier<? extends FlowingFluid> fluid, Properties properties) {
        super(fluid, properties);
    }
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new QualityWaterEntity(pos, state);
    }
    /**
     * 液体が更新された時（流れた時）に呼ばれる
     */
    @Override
    public void onPlace(@NotNull BlockState newState, @NotNull Level level, @NotNull BlockPos newPos,
                        @NotNull BlockState oldState, boolean isMoving) {
        super.onPlace(newState, level, newPos, oldState, isMoving);

        if (!level.isClientSide) {
        }
    }
}
