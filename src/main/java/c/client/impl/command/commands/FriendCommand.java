package c.client.impl.command.commands;

import c.client.api.command.AbstractCommand;
import c.client.api.command.utils.EntitySuggestor;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;

import static com.mojang.brigadier.arguments.StringArgumentType.*;

import static com.mojang.brigadier.builder.LiteralArgumentBuilder.literal;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;

/**
 * @author cookiedragon234 07/Dec/2019
 */
public class FriendCommand extends AbstractCommand
{
	@Override
	public void init(CommandDispatcher dispatcher)
	{
		register(
			dispatcher,
			literal("add")
				.then(
					argument("player", string())
						.suggests(new EntitySuggestor())
						.executes(c -> addFriend(getString(c, "player")))
				),
			literal("remove")
				.then(
					argument("player", string())
						.suggests(new EntitySuggestor())
						.executes(c -> removeFriend(getString(c, "player")))
				)
		);
	}
	
	private static int removeFriend(String name)
	{
		System.out.println("removed friend  " + name);
		return 1;
	}
	
	private static int addFriend(String name)
	{
		System.out.println("Added friend  " + name);
		return 1;
	}
}
