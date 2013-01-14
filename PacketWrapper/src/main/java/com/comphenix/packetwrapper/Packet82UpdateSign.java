/*
 *  PacketWrapper - Contains wrappers for each packet in Minecraft.
 *  Copyright (C) 2012 Kristian S. Stangeland
 *
 *  This program is free software; you can redistribute it and/or modify it under the terms of the 
 *  GNU Lesser General Public License as published by the Free Software Foundation; either version 2 of 
 *  the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with this program; 
 *  if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 
 *  02111-1307 USA
 */

package com.comphenix.packetwrapper;

import javax.annotation.Nonnull;

import com.comphenix.protocol.events.PacketContainer;

public class Packet82UpdateSign extends AbstractPacket {
    public static final int ID = 130;
    
    public Packet82UpdateSign() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet82UpdateSign(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve block X Coordinate.
     * @return The current X
    */
    public int getX() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set block X Coordinate.
     * @param value - new value.
    */
    public void setX(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve block Y Coordinate.
     * @return The current Y
    */
    public short getY() {
        return handle.getIntegers().read(1).shortValue();
    }
    
    /**
     * Set block Y Coordinate.
     * @param value - new value.
    */
    public void setY(short value) {
        handle.getIntegers().write(1, (int) value);
    }
    
    /**
     * Retrieve block Z Coordinate.
     * @return The current Z
    */
    public int getZ() {
        return handle.getIntegers().read(2);
    }
    
    /**
     * Set block Z Coordinate.
     * @param value - new value.
    */
    public void setZ(int value) {
        handle.getIntegers().write(2, value);
    }
    
    /**
     * Retrieve the lines of text represented by a four-element String array.
     * @return The current lines.
    */
    public String[] getLines() {
        return handle.getStringArrays().read(0);
    }
    
    /**
     * Set the lines of text represented by a four-element String array..
     * @param value - new value.
    */
    public void setLines(@Nonnull String[] lines) {
    	if (lines == null)
    		throw new IllegalArgumentException("Array cannot be NULL.");
    	if (lines.length != 4)
    		throw new IllegalArgumentException("The lines array must be four elements long.");
        handle.getStringArrays().write(0, lines);
    }
}
