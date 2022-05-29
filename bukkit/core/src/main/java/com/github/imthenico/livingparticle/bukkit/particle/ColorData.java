package com.github.imthenico.livingparticle.bukkit.particle;

import org.bukkit.Color;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@SerializableAs("ParticleColorData")
public class ColorData implements ConfigurationSerializable {

    private final Color color;
    private final float extra, size;

    public ColorData(Color color, float extra, float size) {
        this.color = color;
        this.extra = extra;
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public float getSize() {
        return size;
    }

    public float getExtra() {
        return extra;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        Map<String, Object> objectMap = new HashMap<>();

        objectMap.put("color", color);
        objectMap.put("extra", extra);
        objectMap.put("size", size);

        return objectMap;
    }

    public static ColorData deserialize(Map<String, Object> objectMap) {
        return new ColorData(
                (Color) objectMap.get("color"),
                (float) objectMap.get("extra"),
                (float) objectMap.get("size")
        );
    }
}