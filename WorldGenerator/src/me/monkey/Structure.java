package me.monkey;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Structure {
	public class noise {
		public static void generateSpruceChunk(Location loc) {
	    	
	    	//Player player = event.getPlayer();
			Material trackingMat = Material.DIAMOND_BLOCK; //Remove in production
			
	    	Location unroundedLoc = loc;
	    	
	    	double Scale = 60.0; //Compile in morning
	    	double yScale = 64; // "I'm not like other girls"
	    	double height = 60.0;
	    	
	    	double xR = Math.round(unroundedLoc.getBlock().getX() / 16) * 16 ;
	    	double yR = 0.0; // Height and y should be the same, there not, I would change it, but it would prob break my I heart perlin variable
	    	double zR = Math.round(unroundedLoc.getBlock().getZ() / 16) * 16 ; //R means rounded
	    	World world = unroundedLoc.getBlock().getWorld();
	    	
	    	Block newBlock = new Location(world, Math.floor(xR), Math.floor(yR), Math.floor(zR)).getBlock();
	    	
	    	if (newBlock.getType() != trackingMat) {
	        	
	        	for (int iX = 0; iX < 16; iX++) {
	        		for (int iZ = 0; iZ < 16; iZ++) {
	        			for (int iY = 0; iY < 120; iY++) {
	        				//Future me, Your stupid, Your really really really stupid, 60 - iY will return the distance from 0. Trust me dipshit.
	        				Location blockLocationPerlin = new Location(world, Math.floor(xR + iX ), Math.floor( height - iY), Math.floor(zR + iZ));
	        				Location blockLocationPerlinShifted = new Location(world, Math.floor(xR + iX ), Math.floor( height - iY) +  1, Math.floor(zR + iZ));
	        				int bpY = blockLocationPerlin.getBlockY();
	        		    	double x = blockLocationPerlin.getBlock().getX();
	        		    	double y = 20.0; 
	        		    	double z = blockLocationPerlin.getBlock().getZ();
	        				double iHeartKenPerlin = Noise.noise((xR+iX)/Scale, ( height - iY)/yScale, (zR+iZ)/Scale); 
	        				//If it gives a error shutdown pc and proceed with PLAN-35B, If that doesn't work your only hope is a Demonic Summoning
	        			    //I tried both, it no no worky, Where do I get the candles for the Demonic summoning?
	        				//Explaing code above, x + iX is just returing the x location on the grid, we divide it by scale so we can scale down our perlin
	        				double newPerlinNoise;
	        				if (bpY < 30) {
	        					double eq1 = 30 - bpY;
	        					double eq2 = eq1 / 60;
	        					newPerlinNoise = iHeartKenPerlin + eq2; //NON AIR
	        				} else {
	        					double eq1 = bpY - 30;
	        					double eq2 = eq1 / 20;
	        					newPerlinNoise = iHeartKenPerlin - eq2; // AIR
	        				}
	        				
	        				if (newPerlinNoise > 0.35) {
	        					ArrayList<Material> stones = new ArrayList<Material>();
	        					stones.add(Material.STONE);
	        					stones.add(Material.STONE);
	        					stones.add(Material.STONE);
	        					stones.add(Material.ANDESITE);
	        					stones.add(Material.ANDESITE);
	        					stones.add(Material.COBBLESTONE);
	        					blockLocationPerlin.getBlock().setType(Random.getRandomMaterial(stones));
	        					
	        					if (blockLocationPerlinShifted.getBlock().getType().equals(Material.AIR) && blockLocationPerlin.getBlockY() >= 0) {
	        						blockLocationPerlin.getBlock().setType(Material.MOSS_BLOCK);
	        					} else if (blockLocationPerlinShifted.getBlock().getType().equals(Material.AIR)||blockLocationPerlinShifted.getBlock().getType().equals(Material.WATER)) {
	        						double perlinNoise2d = Noise.noise(x/20, y/20, z/20);
	        						if (perlinNoise2d > 0.3) {
	        							blockLocationPerlin.getBlock().setType(Material.CLAY);
	        						} else {
	        							blockLocationPerlin.getBlock().setType(Material.SAND);
	        						}
                                    blockLocationPerlin.getBlock().getState().update();
	        					}
	        					if (blockLocationPerlinShifted.getBlock().getType() == Material.MOSS_BLOCK) {
	        						ArrayList<Material> dirts = new ArrayList<Material>();
	        						dirts.add(Material.DIRT);
	        						dirts.add(Material.COARSE_DIRT);
	        						dirts.add(Material.ROOTED_DIRT);
	        						dirts.add(Material.MOSS_BLOCK);
	        						dirts.add(Material.MOSS_BLOCK);
	        						blockLocationPerlin.getBlock().setType(Random.getRandomMaterial(dirts));
	        					}
	        				} else {
	        					if (bpY > 0) {
	        						blockLocationPerlin.getBlock().setType(Material.AIR);
	        					} else if (bpY <= 0) {
	        						blockLocationPerlin.getBlock().setType(Material.WATER);
	        					}
	        				}
	        				
	        			}
	        		}
	    	}
	    	newBlock.setType(trackingMat);
	    }
	}

	}
	@SuppressWarnings("unused")
	public static void ScanRegionAndReturnResult(Location loc1, Location loc2) {
		int x1 = loc1.getBlockX();
		int y1 = loc1.getBlockY();
		int z1 = loc1.getBlockZ();
		
		int x2 = loc2.getBlockX();
		int y2 = loc2.getBlockY();
		int z2 = loc2.getBlockZ();
		
		boolean xR = false;
		boolean yR = false;
		boolean zR = false;
	}
	public class Tree {
		public static void getTrees() {
			
		}
	}
	public class Helper {
		public static boolean returnBooleanFromDoubTypeSub(Double doub1, Double doub2) {
			if ((doub1 - doub2) >= 0) { return true; }
			return false;
		}
	}
}
