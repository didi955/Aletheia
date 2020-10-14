package fr.didi955.aletheia.listeners;

import fr.didi955.aletheia.Aletheia;
import fr.didi955.aletheia.commands.CommandMap;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;

import java.awt.*;

public class JoinEvent {

    private CommandMap commandMap;

    public JoinEvent(CommandMap commandMap) {
        this.commandMap = commandMap;
    }

    public void onJoin(GuildMemberJoinEvent event){
        EmbedBuilder builder = new EmbedBuilder();
        User user = event.getUser();
        builder.setAuthor(user.getName(), null, user.getAvatarUrl());
        builder.setTitle("Bienvenue sur le discord de Rushcubeland");
        builder.addBlankField(true);
        builder.setDescription("Faites !help pour plus d'informations");
        builder.setColor(Color.GREEN);
        MessageChannel channel = event.getGuild().getTextChannelById(Aletheia.CONFIGURATION.getString("channelJoinID", "id"));
        if(channel != null){
            channel.sendMessage(builder.build()).queue();
        }

    }
}
