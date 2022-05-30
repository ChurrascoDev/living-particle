package com.github.imthenico.livingparticle;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticleModel<?> that = (ParticleModel<?>) o;
        return Float.compare(that.offSetX, offSetX) == 0 && Float.compare(that.offSetY, offSetY) == 0 && Float.compare(that.offSetZ, offSetZ) == 0 && Float.compare(that.extra, extra) == 0 && count == that.count && particle.equals(that.particle) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(particle, offSetX, offSetY, offSetZ, extra, count, data);
    }
}