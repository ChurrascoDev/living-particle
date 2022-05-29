package com.github.imthenico.livingparticle;

public interface ParticleSender<W, S, P, L> {

    void spawnParticle(W world, L location, ParticleModel<P> particleModel);

    void sendParticle(S player, L location, ParticleModel<P> particleModel);

    void spawnParticle(W world, double x, double y, double z, ParticleModel<P> particleModel);

    void sendParticle(S player, double x, double y, double z, ParticleModel<P> particleModel);

    void spawnParticle(W world, P particle, L location);

    void sendParticle(S player, P particle, L location);

    void spawnParticle(W world, P particle, L location, Object data);

    void sendParticle(S player, P particle, L location, Object data);

    void spawnParticle(W world, P particle, L location, int count, Object data);

    void sendParticle(S player, P particle, L location, int count, Object data);

    void spawnParticle(W world, P particle, double x, double y, double z, int count, Object data);

    void sendParticle(S player, P particle, double x, double y, double z, int count, Object data);

    void spawnParticle(W world, P particle, L location, int count, float offSetX, float offSetY, float offSetZ, float extra);

    void sendParticle(S sender, P particle, L location, int count, float offSetX, float offSetY, float offSetZ, float extra);

    void spawnParticle(W world, P particle, L location, int count, float offSetX, float offSetY, float offSetZ, float extra, Object data);

    void sendParticle(S sender, P particle, L location, int count, float offSetX, float offSetY, float offSetZ, float extra, Object data);

    void spawnParticle(W world, P particle, double x, double y, double z, int count, float offSetX, float offSetY, float offSetZ);

    void sendParticle(S sender, P particle, double x, double y, double z, int count, float offSetX, float offSetY, float offSetZ);

    void spawnParticle(W world, P particle, double x, double y, double z, int count, float offSetX, float offSetY, float offSetZ, float extra);

    void sendParticle(S sender, P particle, double x, double y, double z, int count, float offSetX, float offSetY, float offSetZ, float extra);

    void spawnParticle(W world, P particle, double x, double y, double z, int count, float offSetX, float offSetY, float offSetZ, float extra, Object data);

    void sendParticle(S sender, P particle, double x, double y, double z, int count, float offSetX, float offSetY, float offSetZ, float extra, Object data);
}