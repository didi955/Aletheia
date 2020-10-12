package fr.didi955.aletheia.listeners;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

public class Listener implements EventListener {

    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if(event instanceof MessageReceivedEvent) MessageListener.onMessage((MessageReceivedEvent) event);
        if(event instanceof GuildMemberJoinEvent) JoinEvent.onJoin((GuildMemberJoinEvent) event);
        if(event instanceof GuildMemberRemoveEvent) QuitEvent.onQuit((GuildMemberRemoveEvent) event);

    }

}
