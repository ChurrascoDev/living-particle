package com.github.imthenico.livingparticle;

public class ParticleModel<T> {

    private final T particle;
    private final float offSetX, offSetY, offSetZ, extra;
    private final int count;
    private final Object data;

    public ParticleModel(T particle, float offSetX, float offSetY, float offSetZ, float extra, int count, Object data) {
        this.particle = particle;
        this.offSetX = offSetX;
        this.offSetY = offSetY;
        this.offSetZ = offSetZ;
        this.extra = extra;
        this.count = count;
        this.data = data;
    }

    public T getParticle() {
        return particle;
    }

    public float getOffSetX() {
        return offSetX;
    }

    public float getOffSetY() {
        return offSetY;
    }

    public float getOffSetZ() {
        return offSetZ;
    }

    public float getExtra() {
        return extra;
    }

    public int getCount() {
        return count;
    }

    public Object getData() {
        return data;
    }
}