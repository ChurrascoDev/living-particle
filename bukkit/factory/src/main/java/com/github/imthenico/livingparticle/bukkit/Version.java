package com.github.imthenico.livingparticle.bukkit;

import org.bukkit.Bukkit;

public class Version {

    public static final int MINOR_NUMBER;
    public static final String PACKAGE_NAME;

    static {
        String packageName = Bukkit.getServer().getClass().getPackage().getName();
        String serverVersion = packageName.substring(
                packageName.lastIndexOf("v") + 1, packageName.lastIndexOf("_"));

        PACKAGE_NAME = packageName.substring(packageName.lastIndexOf(".") + 1);
        MINOR_NUMBER = Integer.parseInt(serverVersion.split("_")[1]);
    }
}