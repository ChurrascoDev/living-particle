package com.github.imthenico.livingparticle.bukkit.nms;

import com.github.imthenico.livingparticle.bukkit.AbstractBukkitParticleSender;
import com.github.imthenico.livingparticle.bukkit.particle.BParticle;
import com.github.imthenico.livingparticle.bukkit.particle.ColorData;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Color;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class v1_8_R3ParticleSender extends AbstractBukkitParticleSender {

    private static final Map<BParticle, EnumParticle> particleMap = new HashMap<>();

    static {
        for (EnumParticle value : EnumParticle.values()) {
            particleMap.put(BParticle.byName(value.name()), value);
        }
    }

    @Override
    public void spawnParticle(World world, BParticle lParticle, double x, double y, double z, int count, float offSetX, float offSetY, float offSetZ, float extra, Object data) {
        if (data instanceof ColorData) {
            ColorData colorData = (ColorData) data;

            spawnParticle(world, lParticle, x, y, z, count, offSetX, offSetY, offSetZ, colorData.getExtra(), colorData.getColor());
            return;
        } else if (data instanceof Color) {
            Color color = (Color) data;
            offSetX = color.getRed() / 255.0f;
            offSetY = color.getGreen() / 255.0f;
            offSetZ = color.getBlue() / 255.0f;
        }

        Packet<?> packet = packet(
                particleMap.get(lParticle),
                (float) x,
                (float) y,
                (float) z,
                count,
                offSetX,
                offSetY,
                offSetZ,
                extra
        );

        for (Player player : world.getPlayers()) {
            sendPacket(player, packet);
        }
    }

    @Override
    public void sendParticle(Player sender, BParticle lParticle, double x, double y, double z, int count, float offSetX, float offSetY, float offSetZ, float extra, Object data) {
        if (data instanceof ColorData) {
            ColorData colorData = (ColorData) data;

            sendParticle(sender, lParticle, x, y, z, count, offSetX, offSetY, offSetZ, colorData.getExtra(), colorData.getColor());
            return;
        } else if (data instanceof Color) {
            Color color = (Color) data;
            offSetX = color.getRed() / 255.0f;
            offSetY = color.getGreen() / 255.0f;
            offSetZ = color.getBlue() / 255.0f;
        }

        sendPacket(sender, packet(
                particleMap.get(lParticle),
                (float) x,
                (float) y,
                (float) z,
                count,
                offSetX,
                offSetY,
                offSetZ,
                extra
        ));
   }

    private Packet<?> packet(
            EnumParticle enumParticle,
            double x,
            double y,
            double z,
            int count,
            float offSetX,
            float offSetY,
            float offSetZ,
            float extra
    ) {
        return new PacketPlayOutWorldParticles(
                enumParticle,
                true,
                (float) x,
                (float) y,
                (float) z,
                offSetX,
                offSetY,
                offSetZ,
                extra,
                count
        );
    }

    private void sendPacket(Player player, Packet<?> packet) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}
