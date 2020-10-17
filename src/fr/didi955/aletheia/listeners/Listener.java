package fr.didi955.aletheia.listeners;

import fr.didi955.aletheia.commands.CommandMap;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
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
        if(event instanceof GuildMemberJoinEvent) JoinEvent.onJoin((GuildMemberJoinEvent) event);
        if(event instanceof GuildMemberRemoveEvent) QuitEvent.onQuit((GuildMemberRemoveEvent) event);
        if(event instanceof GuildMessageReactionAddEvent) AddReactionEvent.addReaction((GuildMessageReactionAddEvent) event);
        if(event instanceof GuildMessageReactionRemoveEvent) RemoveReactionEvent.removeReaction((GuildMessageReactionRemoveEvent) event);
        if(event instanceof ReadyEvent) LoadedEvent.onReady((ReadyEvent) event);

    }

}
