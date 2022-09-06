package net.pouriya_parsa.chefsheavenmod.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.pouriya_parsa.chefsheavenmod.ChefsHeavenMod;
import net.pouriya_parsa.chefsheavenmod.networking.packets.FluidSyncCS2Packet;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }
    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(ChefsHeavenMod.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(FluidSyncCS2Packet.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(FluidSyncCS2Packet::new)
                .encoder(FluidSyncCS2Packet::toBytes)
                .consumerMainThread(FluidSyncCS2Packet::handle)
                .add();

        System.out.println("Registered the mod messages class");
    }
    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
        System.out.println("send messages to server now");
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
        System.out.println("send messages to player now");
    }

    public static <MSG> void sendToClients(MSG message) {
        INSTANCE.send(PacketDistributor.ALL.noArg(), message);
        System.out.println("send messages to client now");
    }
}
