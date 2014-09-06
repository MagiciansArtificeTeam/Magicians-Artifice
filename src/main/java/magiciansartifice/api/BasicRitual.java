package magiciansartifice.api;

import java.util.Random;

import magiciansartifice.api.events.BeginRitualEvent;
import magiciansartifice.api.events.FinishRitualEvent;
import magiciansartifice.api.events.RitualEffectEvent;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.blocks.magicblocks.BlockRitualCornerstone;
import magiciansartifice.main.tileentities.magic.TileEntityContainmentCornerstone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public abstract class BasicRitual {

    private String unlocalizedName;
    private boolean summonAlterLightning = false;
    private int ritualLength = 0;
    private String ritualParticle;
    public int barrierRadius = 8;
    private boolean useBarrier = true;

    public BasicRitual() {
        this.unlocalizedName = "";
    }

    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }

    public BasicRitual setUnlocalizedName(String name) {
        this.unlocalizedName = name;
        return this;
    }

    public BasicRitual setRitualParticle(String particleName) {
        this.ritualParticle = particleName;
        return this;
    }

    public String getRitualParticle() {
        return this.ritualParticle;
    }

    public boolean canSummonLightning() {
        return this.summonAlterLightning;
    }

    public int getRitualLength() {
        return this.ritualLength;
    }

    public boolean isBarrierRitual() { return this.useBarrier; }

    public BasicRitual doesNotUseBarrier() {
        this.useBarrier = false;
        return this;
    }

    /*
        Makes the ritual summon lightning in the corners
    */
    public BasicRitual lightningRitual() {
        this.summonAlterLightning = true;
        return this;
    }

    /*
        Sets the length of the ritual (Length to end linear)
    */
    public BasicRitual setRitualLength(int ritualLength) {
        this.ritualLength = ritualLength;
        return this;
    }

    public String getLocalizedName() {
        return StatCollector.translateToLocal(this.unlocalizedName);
    }

    public void startRitual(int x, int y, int z, World world, EntityPlayer player) {
        TileEntityContainmentCornerstone te = (TileEntityContainmentCornerstone)world.getTileEntity(x, y + 8, z);
    	MinecraftForge.EVENT_BUS.post(new BeginRitualEvent(this,x,y,z,world,player,areAllBlocksCorrect(x,y,z,world,player)));
        player.swingItem();
        System.out.println(x + ", " + (y + 8) + ", " + z);
        if (te != null) {
	        if (this.areAllBlocksCorrect(x,y,z,world,player)){
	            if (this.useBarrier && te.fieldActive) {
	                if (this.containmentReady(x, y, z, world, player)) {
	                    this.initEffect(x, y, z, world, player);
	                    if (this.canSummonLightning()) {
	                        BlockRitualCornerstone.distance = this.barrierRadius;
	                        world.scheduleBlockUpdate(x, y, z, BlockRegistry.ritualCornerStone, 20);
	                    }
	                }
	            } else {
	                this.initEffect(x, y, z, world, player);
	                if (this.canSummonLightning()) {
	                    BlockRitualCornerstone.distance = this.getRitualLength();
	                    world.scheduleBlockUpdate(x, y, z, BlockRegistry.ritualCornerStone, 20);
	                }
	            }
	        }
        }
    }
    
    private boolean containmentReady(int x, int y, int z, World world, EntityPlayer player) {
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

    public void endRitual(int x, int y, int z, World world, EntityPlayer player) {
        MinecraftForge.EVENT_BUS.post(new FinishRitualEvent(this, x, y, z, world, player));
    }

    public void initEffect(int x, int y, int z, World world, EntityPlayer player) {
        MinecraftForge.EVENT_BUS.post(new RitualEffectEvent(this, x,y,z,world,player));
        this.endRitual(x, y, z, world, player);
    }

    public boolean areAllBlocksCorrect(int x, int y, int z, World world, EntityPlayer player) {
        return false;
    }

    public void spawnParticles(World world, int x, int y, int z, Random random, boolean spawnCornerParticles) {
        for (int j1 = 0; j1 < 32; ++j1) {
            double d0 = (double)((float)x + (5.0F + random.nextFloat() * 6.0F) / 16.0F);
            double d1 = (double)((float)y + 0.8125F);
            double d2 = (double)((float)z + (5.0F + random.nextFloat() * 6.0F) / 16.0F);
            double d3 = 1.0D;
            double d4 = 1.0D;
            double d5 = 1.0D;
            world.spawnParticle(this.getRitualParticle(), d0, d1, d2, d3, d4, d5);

            if (spawnCornerParticles) {
                world.spawnParticle(this.getRitualParticle(), d0 - this.getRitualLength(), d1, d2 - this.getRitualLength(), d3, d4, d5);
                world.spawnParticle(this.getRitualParticle(), d0 + this.getRitualLength(), d1, d2 + this.getRitualLength(), d3, d4, d5);
                world.spawnParticle(this.getRitualParticle(), d0 + this.getRitualLength(), d1, d2 - this.getRitualLength(), d3, d4, d5);
                world.spawnParticle(this.getRitualParticle(), d0 - this.getRitualLength(), d1, d2 + this.getRitualLength(), d3, d4, d5);
            }
        }
    }
}
