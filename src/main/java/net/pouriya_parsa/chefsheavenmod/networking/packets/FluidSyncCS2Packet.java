package net.pouriya_parsa.chefsheavenmod.networking.packets;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.network.NetworkEvent;
import net.pouriya_parsa.chefsheavenmod.block.entity.OilCreatorBlockEntity;
import net.pouriya_parsa.chefsheavenmod.screen.screens.OilCreatorMenu;

import java.util.function.Supplier;

public class FluidSyncCS2Packet {
    private final FluidStack fluidStack;
    private final BlockPos pos;

    public FluidSyncCS2Packet(FluidStack fluidStack, BlockPos pos) {
        this.fluidStack = fluidStack;
        this.pos = pos;
    }

    public FluidSyncCS2Packet(FriendlyByteBuf buf) {
        this.fluidStack = buf.readFluidStack();
        this.pos = buf.readBlockPos();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeFluidStack(fluidStack);
        buf.writeBlockPos(pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            if(Minecraft.getInstance().level.getBlockEntity(pos) instanceof OilCreatorBlockEntity blockEntity) {
                blockEntity.SetFluid(this.fluidStack);

                if(Minecraft.getInstance().player.containerMenu instanceof OilCreatorMenu menu &&
                        menu.getBlockEntity().getBlockPos().equals(pos)) {
                    menu.setFluid(this.fluidStack);
                }
            }
        });
        return true;
    }
}
