package xyz.skynetcloud.cyberx.blocks.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xyz.skynetcloud.cyberx.Main;
import xyz.skynetcloud.cyberx.init.BlockInit;
import xyz.skynetcloud.cyberx.init.ItemInit;
import xyz.skynetcloud.cyberx.init.TypeInit;
import xyz.skynetcloud.cyberx.titles.TileEntityChestInit;

public class BlockCyberChest extends BlockContainer
{

	public static final PropertyEnum<TypeInit> VARIANT_PROP = PropertyEnum.create("variant", TypeInit.class);

    protected static final AxisAlignedBB Chest_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.875D, 0.9375D);

    
    public BlockCyberChest(String name, Material materialIn, CreativeTabs tab) {
		super(materialIn);
		   
		        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT_PROP, TypeInit.VIBRANIUM));
		        this.setHardness(3.0F);
		     
				setUnlocalizedName(name);
				setRegistryName(name);
				setCreativeTab(tab);
		   
		        
				BlockInit.BLOCKS.add(this);
				ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName("chest")); 
		        
		        
	}


    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return Chest_AABB;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }

    @Nullable
    public ILockableContainer getLockableContainer(World worldIn, BlockPos pos)
    {
        return this.getContainer(worldIn, pos, false);
    }

    @Nullable
    public ILockableContainer getContainer(World worldIn, BlockPos pos, boolean allowBlocking)
    {
        return null;
    }

    @Override
    //@formatter:off
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY)
    //@formatter:on
    {
        TileEntity te = worldIn.getTileEntity(pos);

        if (te == null || !(te instanceof TileEntityChestInit))
        {
            return true;
        }

        if (worldIn.isSideSolid(pos.add(0, 1, 0), EnumFacing.DOWN))
        {
            return true;
        }

        if (worldIn.isRemote)
        {
            return true;
        }

        playerIn.openGui(Main.instance, ((TileEntityChestInit) te).getType().ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());

        return true;
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return state.getValue(VARIANT_PROP).makeEntity();
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT_PROP, TypeInit.VALUES[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState blockState)
    {
        return blockState.getValue(VARIANT_PROP).ordinal();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, VARIANT_PROP);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(world, pos, state);
        world.notifyBlockUpdate(pos, state, state, 3);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        TileEntity te = worldIn.getTileEntity(pos);

        if (te != null && te instanceof TileEntityChestInit)
        {
        	TileEntityChestInit teic = (TileEntityChestInit) te;

            teic.wasPlaced(placer, stack);
            teic.setFacing(placer.getHorizontalFacing().getOpposite());

            worldIn.notifyBlockUpdate(pos, state, state, 3);
        }
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(VARIANT_PROP).ordinal();
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
    	TileEntityChestInit tileentity = (TileEntityChestInit) worldIn.getTileEntity(pos);

        if (tileentity != null)
        {
            tileentity.removeAdornments();

            InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
            worldIn.updateComparatorOutputLevel(pos, this);

            worldIn.removeTileEntity(pos);
        }

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion)
    {
        TileEntity te = world.getTileEntity(pos);

        if (te instanceof TileEntityChestInit)
        {
        	TileEntityChestInit teic = (TileEntityChestInit) te;
        }

        return super.getExplosionResistance(world, pos, exploder, explosion);
    }

    @Override
    public boolean hasComparatorInputOverride(IBlockState state)
    {
        return true;
    }

    @Override
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }

    private static final EnumFacing[] validRotationAxes = new EnumFacing[] { EnumFacing.UP, EnumFacing.DOWN };

    @Override
    public EnumFacing[] getValidRotations(World worldObj, BlockPos pos)
    {
        return validRotationAxes;
    }

    @Override
    public boolean rotateBlock(World worldObj, BlockPos pos, EnumFacing axis)
    {
        if (worldObj.isRemote)
        {
            return false;
        }

        if (axis == EnumFacing.UP || axis == EnumFacing.DOWN)
        {
            TileEntity tileEntity = worldObj.getTileEntity(pos);

            if (tileEntity instanceof TileEntityChestInit)
            {
            	TileEntityChestInit icte = (TileEntityChestInit) tileEntity;

                icte.rotateAround();
            }

            return true;
        }
        return false;
    }

    @Override
    @Deprecated
    public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int id, int param)
    {
        super.eventReceived(state, worldIn, pos, id, param);

        TileEntity tileentity = worldIn.getTileEntity(pos);

        return tileentity != null && tileentity.receiveClientEvent(id, param);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        Random rand = world instanceof World ? ((World) world).rand : RANDOM;

        int count = quantityDropped(state, fortune, rand);
        for (int i = 0; i < count; i++)
        {
            Item item = this.getItemDropped(state, rand, fortune);
            if (item != Items.AIR)
            {
                ItemStack stack = new ItemStack(item, 1, this.damageDropped(state));
                drops.add(stack);
            }
        }
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return null;
	}
}