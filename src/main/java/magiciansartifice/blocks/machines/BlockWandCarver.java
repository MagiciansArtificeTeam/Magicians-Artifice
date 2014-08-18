package magiciansartifice.blocks.machines;

import java.util.Random;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.core.libs.ModInfo;
import magiciansartifice.tileentities.machines.TileEntityWandCarver;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWandCarver extends BlockContainer
{
    private final Random random = new Random();
    public BlockWandCarver()
    {
        super(Material.wood);
        this.setBlockName("wandCarver");
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setBlockBounds(0F, 0F, 0F, 1F, 0.7F, 1F);
        BlockRegistry.blocks.add(this);
    }
    
    @Override
    public int getRenderType()
    {
        return -1;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(World var1, int var2)
    {
        return new TileEntityWandCarver();
    }
    
    @Override
    public void registerBlockIcons(IIconRegister ir)
    {
        blockIcon = ir.registerIcon(ModInfo.MODID + ":machines/wandCarverIcon");
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
        if (player.isSneaking()) return false;
        else
        {
            if (!world.isRemote)
            {
                player.openGui(MagiciansArtifice.instance, 1, world, x, y, z);
            }
            return true;
        }
    }
    
    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        TileEntityWandCarver wandCarver = (TileEntityWandCarver) world.getTileEntity(x, y, z);
        
        if (wandCarver != null)
        {
            for (int i1 = 0; i1 < wandCarver.getSizeInventory(); ++i1)
            {
                ItemStack itemstack = wandCarver.getStackInSlot(i1);
                
                if (itemstack != null)
                {
                    float f = this.random.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;
                    
                    for (float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
                    {
                        int j1 = this.random.nextInt(21) + 10;
                        
                        if (j1 > itemstack.stackSize)
                        {
                            j1 = itemstack.stackSize;
                        }
                        
                        itemstack.stackSize -= j1;
                        entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
                        entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
                        
                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
                        }
                    }
                }
            }
            
            world.func_147453_f(x, y, z, block);
        }
        
        super.breakBlock(world, x, y, z, block, meta);
    }
}