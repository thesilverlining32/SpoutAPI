/*
 * This file is part of SpoutAPI.
 *
 * Copyright (c) 2011-2012, Spout LLC <http://www.spout.org/>
 * SpoutAPI is licensed under the Spout License Version 1.
 *
 * SpoutAPI is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * SpoutAPI is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://spout.in/licensev1> for the full license, including
 * the MIT license.
 */
package org.spout.api.event.player;

import org.spout.api.chat.ChatArguments;
import org.spout.api.entity.Player;
import org.spout.api.event.HandlerList;
import org.spout.api.util.access.BanType;

/**
 * Called when a player is kicked for being banned
 */
public class PlayerBanKickEvent extends PlayerEvent {
	private static HandlerList handlers = new HandlerList();
	private BanType type;
	private ChatArguments message;

	public PlayerBanKickEvent(Player player, BanType type, Object... message) {
		super(player);
		this.type = type;
		this.message = new ChatArguments(message);
	}

	/**
	 * Gets the type of ban that changed
	 * @return bantype
	 */
	public BanType getBanType() {
		return type;
	}

	/**
	 * Gets the ban's kick message
	 * @return the kick message
	 */
	public ChatArguments getMessage() {
		return message;
	}

	/**
	 * Sets the ban's kick message
	 * @return the kick message
	 */
	public void setMessage(Object... message) {
		this.message = new ChatArguments(message);
	}

	@Override
	public void setCancelled(boolean cancelled) {
		super.setCancelled(cancelled);
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
