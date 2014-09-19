package magiciansartifice.main.tileentities.magic;

import magiciansartifice.main.blocks.BlockRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityContainmentCornerstone extends TileEntity {
	private boolean fieldActive;
    private int barrierRadius = 8;

    public TileEntityContainmentCornerstone() {
        fieldActive = false;
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        if (nbt == null) {
            nbt = new NBTTagCompound();
            nbt.setBoolean("fieldActive",this.fieldActive);
            System.err.println(nbt.getBoolean("fieldActive"));
        } else {
            nbt.setBoolean("fieldActive",this.fieldActive);
            System.err.println(nbt.getBoolean("fieldActive"));
        }
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt != null) {
            if (nbt.hasKey("fieldActive")) {
                System.err.println(nbt.getBoolean("fieldActive"));
                fieldActive = nbt.getBoolean("fieldActive");
            } else {
                fieldActive = false;
            }
        }
    }

    public boolean getFieldActive() {
        return this.fieldActive;
    }
	
	public void createField(World world, EntityPlayer player, int x, int y, int z) {
		int x1 = x;
		int z1 = z;
		if (!fieldActive) {
    		fieldActive = true;
    		for (int y2 = y-7; y2 < y + 1; y2++) {
	            for (int i = x - 8; i < x + 8; i++) {
	                if (world.getBlock(i, y2, z - 8) == Blocks.air) {
	                    world.setBlock(i, y2, z - 8, BlockRegistry.containmentBarrier);
	                }
	                if (world.getBlock(i, y2, z + 8) == Blocks.air) {
	                    world.setBlock(i, y2, z + 8, BlockRegistry.containmentBarrier);
	                }
	            }
	            for (int ii = z - 8; ii < z + 9; ii++) {
	                if (world.getBlock(x - 8, y2, ii) == Blocks.air) {
	                    world.setBlock(x - 8, y2, ii, BlockRegistry.containmentBarrier);
	                }
	                if (world.getBlock(x + 8, y2, ii) == Blocks.air) {
	                    world.setBlock(x + 8, y2, ii, BlockRegistry.containmentBarrier);
	                }
	            }
	        }
    		x1 += 7;
    		z1 += 7;
    		for (int i = 0; i < 8; i++) {
    			for (int ii = 0; ii < 15; ii++) {
    				if (world.getBlock(x1 - ii, y, z1 - i) == Blocks.air) {
    					world.setBlock(x1 - ii, y, z1 - i, BlockRegistry.containmentBarrier);
    				}
    			}
    		}
    		z1 -= 8;
    		for (int i = 0; i < 8; i++) {
    			for (int ii = 0; ii < 15; ii++) {
    				if (world.getBlock(x1 - ii, y, z1 - i) == Blocks.air) {
    					world.setBlock(x1 - ii, y, z1 - i, BlockRegistry.containmentBarrier);
    				}
    			}
    		}
            world.playSoundAtEntity(player,"mob.enderdragon.hit",1.0F,1.0F);
    	} else {
    		fieldActive = false;
	    	for (int y2 = y-7; y2 < y + 1; y2++) {
	            for (int i = x - 8; i < x + 8; i++) {
	                if (world.getBlock(i, y2, z - 8) == BlockRegistry.containmentBarrier) {
	                    world.setBlockToAir(i, y2, z - 8);
	                }
	                if (world.getBlock(i, y2, z + 8) == BlockRegistry.containmentBarrier) {
	                    world.setBlockToAir(i, y2, z + 8);
	                }
	            }
	            for (int ii = z - 8; ii < z + 9; ii++) {
	                if (world.getBlock(x - 8, y2, ii) == BlockRegistry.containmentBarrier) {
	                    world.setBlockToAir(x - 8, y2, ii);
	                }
	                if (world.getBlock(x + 8, y2, ii) == BlockRegistry.containmentBarrier) {
	                    world.setBlockToAir(x + 8, y2, ii);
	                }
	            }
	        }
	    	x1 += 7;
    		z1 += 7;
    		for (int i = 0; i < 8; i++) {
    			for (int ii = 0; ii < 15; ii++) {
    				if (world.getBlock(x1 - ii, y, z1 - i) == BlockRegistry.containmentBarrier) {
    					world.setBlockToAir(x1 - ii, y, z1 - i);
    				}
    			}
    		}
    		z1 -= 7;
    		for (int i = 0; i < 8; i++) {
    			for (int ii = 0; ii < 15; ii++) {
    				if (world.getBlock(x1 - ii, y, z1 - i) == BlockRegistry.containmentBarrier) {
    					world.setBlockToAir(x1 - ii, y, z1 - i);
    				}
    			}
    		}
            world.playSoundAtEntity(player,"random.fizz",1.0F,1.0F);
        }
	}

    public boolean containmentReady(int x, int y, int z, World world, EntityPlayer player) {
        int x1 = x;
        int y1 = y;
        int z1 = z;
        {
            x1 += barrierRadius;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1, y1 + i, z1) != BlockRegistry.containmentPillar) {
                    return false;
                }
            }
            if (world.getBlock(x1, y1 + 7, z1) != BlockRegistry.containmentTop) {
                return false;
            }
        }
        x1 = x;
        {
            z1 += barrierRadius;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1, y1 + i, z1) != BlockRegistry.containmentPillar) {
                    return false;
                }
            }
            if (world.getBlock(x1, y1 + 7, z1) != BlockRegistry.containmentTop) {
                return false;
            }
        }
        z1 = z;
        {
            x1 -= barrierRadius;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1, y1 + i, z1) != BlockRegistry.containmentPillar) {
                    return false;
                }
            }
            if (world.getBlock(x1, y1 + 7, z1) != BlockRegistry.containmentTop) {
                return false;
            }
        }
        x1 = x;
        {
            z1 -= barrierRadius;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1, y1 + i, z1) != BlockRegistry.containmentPillar) {
                    return false;
                }
            }
            if (world.getBlock(x1, y1 + 7, z1) != BlockRegistry.containmentTop) {
                return false;
            }
        }
        z1 = z;
        {
            x1 += barrierRadius;
            z1 += 1;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1, y1, z1 + i) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
            if (world.getBlock(x1, y1, z1 + 7) != BlockRegistry.containmentTop) {
                return false;
            }
            for (int i = 1; i <= 6; i++) {
                if (world.getBlock(x1 - i, y1, z1 + 7) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
        }
        x1 = x;
        z1 = z;
        {
            z1 += barrierRadius;
            x1 += 1;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1 + i, y1, z1) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
            if (world.getBlock(x1 + 7, y1, z1) != BlockRegistry.containmentTop) {
                return false;
            }
            for (int i = 1; i <= 6; i++) {
                if (world.getBlock(x1 + 7, y1, z1 - i) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
        }
        x1 = x;
        z1 = z;
        {
            x1 -= barrierRadius;
            z1 -= 1;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1, y1, z1 - i) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
            if (world.getBlock(x1, y1, z1 - 7) != BlockRegistry.containmentTop) {
                return false;
            }
            for (int i = 1; i <= 6; i++) {
                if (world.getBlock(x1 + i, y1, z1 - 7) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
        }
        x1 = x;
        z1 = z;
        {
            z1 -= barrierRadius;
            x1 -= 1;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1 - i, y1, z1) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
            if (world.getBlock(x1 - 7, y1, z1) != BlockRegistry.containmentTop) {
                return false;
            }
            for (int i = 1; i <= 6; i++) {
                if (world.getBlock(x1 - 7, y1, z1 + i) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
        }
        if (world.getBlock(x, y + 8, z) != BlockRegistry.containmentCornerstone) {
            return false;
        }
        return true;
    }

}
