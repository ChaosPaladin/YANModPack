/*
 * This file is part of YANModPack: https://github.com/HorridoJoho/YANModPack
 * Copyright (C) 2015  Christian Buck
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package YANModPack.YANBuffer.src.model.entity;

import javax.xml.bind.annotation.XmlAttribute;

import YANModPack.YANBuffer.src.YANBufferVoicedCommandHandler;

import com.l2jserver.gameserver.datatables.ItemTable;
import com.l2jserver.gameserver.model.items.L2Item;

/**
 * @author HorridoJoho
 */
public final class VoicedBuffer extends AbstractBuffer
{
	@XmlAttribute(name = "enabled", required = true)
	public final boolean enabled;
	@XmlAttribute(name = "required_item_id")
	public final int requiredItemId;
	
	public VoicedBuffer()
	{
		super("voice ." + YANBufferVoicedCommandHandler.VOICED_COMMAND);
		enabled = false;
		requiredItemId = 0;
	}
	
	public L2Item getRequiredItem()
	{
		return ItemTable.getInstance().getTemplate(requiredItemId);
	}
	
	@Override
	protected String getName()
	{
		return "Voiced Command Teleporter";
	}
}
