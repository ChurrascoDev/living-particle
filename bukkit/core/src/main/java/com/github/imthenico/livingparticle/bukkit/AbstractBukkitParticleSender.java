package com.github.imthenico.livingparticle.bukkit;

import com.github.imthenico.livingparticle.bukkit.particle.BParticle;
import com.github.imthenico.livingparticle.ParticleModel;
import com.github.imthenico.livingparticle.ParticleSender;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public abstract class AbstractBukkitParticleSender implements ParticleSender<World, Player, BParticle, Location> {
    @Override
    public void spawnParticle(World world, Location location, ParticleModel<BParticle> particleModel) {
        spawnParticle(
                world,
                location.getX(),
                location.getY(),
                location.getZ(),
                particleModel
        );
    }

    @Override
    public void sendParticle(Player player, Location location, ParticleModel<BParticle> particleModel) {
        sendParticle(
                player,
                location.getX(),
                location.getY(),
                location.getZ(),
                particleModel
        );
    }

    @Override
    public void spawnParticle(World world, BParticle particle, Location location) {
        spawnParticle(world, particle, location, null);
    }

    @Override
    public void sendParticle(Player player, BParticle particle, Location location) {
        sendParticle(player, particle, location, null);
    }

    @Override
    public void spawnParticle(World world, BParticle particle, Location location, Object data) {
        spawnParticle(world, particle, location, 1, null);
    }

    @Override
    public void sendParticle(Player player, BParticle particle, Location location, Object data) {
        sendParticle(player, particle, location, 1, null);
    }

    @Override
    public void spawnParticle(World world, BParticle particle, Location location, int count, Object data) {
        spawnParticle(world, particle, location.getX(), location.getY(), location.getZ(), count, data);
    }

    @Override
    public void sendParticle(Player player, BParticle particle, Location location, int count, Object data) {
        sendParticle(player, particle, location.getX(), location.getY(), location.getZ(), count, data);
    }

    @Override
    public void spawnParticle(World world, double x, double y, double z, ParticleModel<BParticle> particleModel) {
        spawnParticle(
                world,
                particleModel.getParticle(),
                x,
                y,
                z,
                particleModel.getCount(),
                particleModel.getOffSetX(),
                particleModel.getOffSetY(),
                particleModel.getOffSetZ(),
                particleModel.getExtra(),
                particleModel.getData()
        );
    }

    @Override
    public void sendParticle(
            Player player,
            double x,
            double y,
            double z,
            ParticleModel<BParticle> particleModel
    ) {
        sendParticle(
                player,
                particleModel.getParticle(),
                x,
                y,
                z,
                particleModel.getCount(),
                particleModel.getOffSetX(),
                particleModel.getOffSetY(),
                particleModel.getOffSetZ(),
                particleModel.getExtra(),
                particleModel.getData()
        );
    }

    @Override
    public void spawnParticle(World world, BParticle particle, double x, double y, double z, int count, Object data) {
        spawnParticle(world, particle, x, y, z, count, 0, 0, 0, 0, data);
    }

    @Override
    public void sendParticle(Player player, BParticle particle, double x, double y, double z, int count, Object data) {
        sendParticle(player, particle, x, y, z, count, 0, 0, 0, 0, data);
    }

    @Override
    public void spawnParticle(World world, BParticle particle, Location location, int count, float offSetX, float offSetY, float offSetZ, float extra) {
        spawnParticle(world, particle, location, count, offSetX, offSetY, offSetZ, extra, null);
    }

    @Override
    public void sendParticle(Player sender, BParticle particle, Location location, int count, float offSetX, float offSetY, float offSetZ, float extra) {
        sendParticle(sender, particle, location, count, offSetX, offSetY, offSetZ, extra, null);
    }

    @Override
    public void spawnParticle(World world, BParticle particle, Location location, int count, float offSetX, float offSetY, float offSetZ, float extra, Object data) {
        spawnParticle(world, particle, location.getX(), location.getY(), location.getZ(), count, offSetX, offSetY, offSetZ, extra, data);
    }

    @Override
    public void sendParticle(Player sender, BParticle particle, Location location, int count, float offSetX, float offSetY, float offSetZ, float extra, Object data) {
        sendParticle(sender, particle, location.getX(), location.getY(), location.getZ(), count, offSetX, offSetY, offSetZ, extra, data);
    }

    @Override
    public void spawnParticle(World world, BParticle particle, double x, double y, double z, int count, float offSetX, float offSetY, float offSetZ) {
        spawnParticle(world, particle, x, y, z, count, offSetX, offSetY, offSetZ, 0);
    }

    @Override
    public void sendParticle(Player sender, BParticle particle, double x, double y, double z, int count, float offSetX, float offSetY, float offSetZ) {
        sendParticle(sender, particle, x, y, z, count, offSetX, offSetZ, offSetZ, offSetZ, 0);
    }

    @Override
    public void spawnParticle(World world, BParticle particle, double x, double y, double z, int count, float offSetX, float offSetY, float offSetZ, float extra) {
        spawnParticle(world, particle, x, y, z, count, offSetX, offSetY, offSetZ, extra, null);
    }

    @Override
    public void sendParticle(Player sender, BParticle particle, double x, double y, double z, int count, float offSetX, float offSetY, float offSetZ, float extra) {
        sendParticle(sender, particle, x, y, z, count, offSetZ, offSetY, offSetZ, extra, null);
    }
}