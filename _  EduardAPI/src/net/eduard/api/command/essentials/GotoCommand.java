package net.eduard.api.command.essentials;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.api.API;
import net.eduard.api.manager.CommandManager;
import net.eduard.api.setup.Mine;

public class GotoCommand extends CommandManager {
	public GotoCommand() {
		super("goto");
	}
	public String message = "�6Voce foi teleportado para o Mundo �e$world";

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (args.length == 0)
			return false;

		if (API.onlyPlayer(sender)) {
			Player p = (Player) sender;
			if (API.existsWorld(sender, args[0])) {
				World world = Bukkit.getWorld(args[0]);
				Mine.teleport(p, world.getSpawnLocation());
				API.SOUND_TELEPORT.create(p);
				API.chat(p,message.replace("$world", world.getName()));
			}
		}

		return true;
	}
}
