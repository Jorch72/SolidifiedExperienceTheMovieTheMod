package de.ellpeck.solidxp.util;

import de.ellpeck.solidxp.solidifier.ContainerXPSolidifier;
import de.ellpeck.solidxp.solidifier.GuiXPSolidifier;
import de.ellpeck.solidxp.solidifier.TileEntityXPSolidifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler{

    @Nullable
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
        if(id == 0){
            TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
            if(tile instanceof TileEntityXPSolidifier){
                return new ContainerXPSolidifier(player, (TileEntityXPSolidifier)tile);
            }
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
        if(id == 0){
            TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
            if(tile instanceof TileEntityXPSolidifier){
                return new GuiXPSolidifier(player, (TileEntityXPSolidifier)tile);
            }
        }
        return null;
    }
}
