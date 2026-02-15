package com.hutuneko.hydrocraft.water;

import com.hutuneko.hydrocraft.ModRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class QualityWaterEntity extends BlockEntity {
    private CompoundTag fluidData = new CompoundTag();

    public QualityWaterEntity(BlockPos pos, BlockState state) {
        super(ModRegister.QUALITYWATERENTITY.get(), pos, state);
    }

    public void setFluidData(CompoundTag data) {
        this.fluidData = data.copy();
        setChanged();
    }

    public CompoundTag getFluidData() {
        return fluidData.copy();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("FluidData", fluidData);
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        this.fluidData = tag.getCompound("FluidData");
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
