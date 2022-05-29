package com.github.imthenico.livingparticle.bukkit;

import com.github.imthenico.livingparticle.bukkit.nms.v1_8_R3ParticleSender;
import com.github.imthenico.livingparticle.bukkit.particle.BParticle;
import com.github.imthenico.livingparticle.bukkit.particle.ColorData;
import org.bukkit.Color;

import java.util.Objects;

public final class BukkitParticleModule {

    public BukkitParticleModule () {
        throw new UnsupportedOperationException("Cannot instantiate this class");
    }

    public static final boolean OLD_VERSION = Version.MINOR_NUMBER <= 8;

    public static AbstractBukkitParticleSender getSender() {
        if (OLD_VERSION) {
            return new v1_8_R3ParticleSender();
        }

        return new BukkitParticleSender();
    }

    public static BSerializableParticleModel of(BParticle particle, float offSetX, float offSetY, float offSetZ, float extra, int count, Object data) {
        return new BSerializableParticleModel(particle, offSetX, offSetY, offSetZ, extra, count, data);
    }

    public static ColorData color(Color color, float extra, float size) {
        return new ColorData(Objects.requireNonNull(color), extra, size);
    }

    public static ColorData color(Color color, float extra) {
        return color(color, extra, 1);
    }

    public static ColorData color(int r, int g, int b, float extra, float size) {
        return new ColorData(Color.fromRGB(r <= 0 ? 1 : r, g, b), extra, size);
    }

    public static ColorData color(int r, int g, int b, float extra) {
        return new ColorData(Color.fromRGB(r <= 0 ? 1 : r, g, b), extra, 1);
    }
}