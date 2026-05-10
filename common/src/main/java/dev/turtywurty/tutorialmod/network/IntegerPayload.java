package dev.turtywurty.tutorialmod.network;

import dev.turtywurty.tutorialmod.Constants;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jspecify.annotations.NonNull;

public record IntegerPayload(int integer) implements CustomPacketPayload {
    public static final Type<IntegerPayload> TYPE = new Type<>(Constants.id("integer_payload"));

    public static final StreamCodec<RegistryFriendlyByteBuf, IntegerPayload> STREAM_CODEC =
            StreamCodec.composite(ByteBufCodecs.INT, IntegerPayload::integer, IntegerPayload::new);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
