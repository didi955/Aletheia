package fr.didi955.aletheia.listeners;

import fr.didi955.aletheia.commands.CommandMap;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;

public class QuitEvent {

    private CommandMap commandMap;

    public QuitEvent(CommandMap commandMap) {
        this.commandMap = commandMap;
    }

    public void onQuit(GuildMemberRemoveEvent event){

    }
}
