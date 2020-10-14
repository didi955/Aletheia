package fr.didi955.aletheia.listeners;

import fr.didi955.aletheia.commands.CommandMap;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

public class Listener implements EventListener {

    private final CommandMap commandMap;


    public Listener(CommandMap commandMap) {
        this.commandMap = commandMap;
    }

    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if(event instanceof MessageReceivedEvent) new MessageListener(commandMap).onMessage((MessageReceivedEvent) event);
        if(event instanceof GuildMemberJoinEvent) new JoinEvent(commandMap).onJoin((GuildMemberJoinEvent) event);
        if(event instanceof GuildMemberRemoveEvent) new QuitEvent(commandMap).onQuit((GuildMemberRemoveEvent) event);

    }

}
