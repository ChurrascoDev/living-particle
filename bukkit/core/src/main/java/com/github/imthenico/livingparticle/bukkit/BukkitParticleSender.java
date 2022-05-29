package com.github.imthenico.livingparticle.bukkit;

import com.github.imthenico.livingparticle.bukkit.particle.BParticle;
import com.github.imthenico.livingparticle.bukkit.particle.ColorData;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class BukkitParticleSender extends AbstractBukkitParticleSender {

    private final static Map<BParticle, Particle> particleMap;
    private final static Particle.DustOptions DEFAULT_DUST_OPTIONS = new Particle.DustOptions(Color.RED, 1);

    static {
        particleMap = new HashMap<>();

        for (Particle value : Particle.values()) {
            particleMap.put(BParticle.valueOf(value.name()), value);
        }
    }

    @Override
    public void spawnParticle(
            World world,
            BParticle lParticle,
            double x,
            double y,
            double z,
            int count,
            float offSetX,
            float offSetY,
            float offSetZ,
            float extra,
            Object data
    ) {
        Particle particle = particleMap.get(lParticle);

        if (data instanceof ColorData) extra = ((ColorData) data).getExtra();

        if (particle.getDataType().equals(Particle.DustOptions.class) && data == null)
            data = DEFAULT_DUST_OPTIONS;

        world.spawnParticle(particle, x, y, z, count, offSetX, offSetY, offSetZ, extra, interceptData(data));
    }

    @Override
    public void sendParticle(
            Player sender,
            BParticle lParticle,
            double x,
            double y,
            double z,
            int count,
            float offSetX,
            float offSetY,
            float offSetZ,
            float extra,
            Object data
    ) {
        Particle particle = particleMap.get(lParticle);

        if (data instanceof ColorData) extra = ((ColorData) data).getExtra();

        if (particle.getDataType().equals(Particle.DustOptions.class) && data == null)
            data = DEFAULT_DUST_OPTIONS;

        sender.spawnParticle(particle, x, y, z, count, offSetX, offSetY, offSetZ, extra, interceptData(data));
    }

    private Object interceptData(Object data) {
        if (data instanceof ColorData) {
            ColorData colorData = (ColorData) data;

            data = new Particle.DustOptions(colorData.getColor(), colorData.getSize());
        } else if (data instanceof Color) {
            data = new Particle.DustOptions((Color) data, 1);
        }

        return data;
    }
}