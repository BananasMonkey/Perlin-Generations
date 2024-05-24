package me.monkey;

import java.util.ArrayList;

import org.bukkit.Material;

public class Random {
	public static Material getRandomMaterial(ArrayList<Material> list) {
		return list.get((int) Math.floor(Math.random() * (list.size()-1)));
	}
}
