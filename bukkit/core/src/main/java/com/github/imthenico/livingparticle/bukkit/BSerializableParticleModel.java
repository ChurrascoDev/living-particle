package com.github.imthenico.livingparticle.bukkit;

import com.github.imthenico.livingparticle.ParticleModel;
import com.github.imthenico.livingparticle.bukkit.particle.BParticle;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@SerializableAs("BParticleModel")
public class BSerializableParticleModel extends ParticleModel<BParticle> implements ConfigurationSerializable {

    private final Object data;

    public BSerializableParticleModel(com.github.imthenico.livingparticle.bukkit.particle.BParticle particle, float offSetX, float offSetY, float offSetZ, float extra, int count, Object data) {
        super(particle, offSetX, offSetY, offSetZ, extra, count, data);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        Map<String, Object> objectMap = new HashMap<>();

        objectMap.put("particleName", getParticle().name());
        objectMap.put("offSetX", getOffSetX());
        objectMap.put("offSetY", getOffSetY());
        objectMap.put("offSetZ", getOffSetZ());
        objectMap.put("count", getCount());

        if (data instanceof ConfigurationSerializable) {
            objectMap.put("data", data);
        }

        return objectMap;
    }

    public static BSerializableParticleModel deserialize(Map<String, Object> objectMap) {
        return new BSerializableParticleModel(
                BParticle.byName((String) objectMap.get("particleName")),
                (float) objectMap.get("offSetX"),
                (float) objectMap.get("offSetY"),
                (float) objectMap.get("offSetZ"),
                (float) objectMap.get("extra"),
                (int) objectMap.get("count"),
                objectMap.get("data")
        );
    }
}