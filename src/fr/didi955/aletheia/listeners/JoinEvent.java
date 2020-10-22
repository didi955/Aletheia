package fr.didi955.aletheia.listeners;

import fr.didi955.aletheia.Aletheia;
import fr.didi955.aletheia.commands.CommandMap;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;

import java.awt.*;

public class JoinEvent {

    public static void onJoin(GuildMemberJoinEvent event){
        EmbedBuilder builder = new EmbedBuilder();
        User user = event.getUser();
        builder.setTitle(Aletheia.MESSAGE_RESSOURCES.getString("titleWelcome", "Bienvenue !"));
        builder.setDescription(Aletheia.MESSAGE_RESSOURCES.getString("messageWelcome", "message").replace("%user%", user.getAsMention()));
        builder.setColor(Color.GREEN);
        MessageChannel channel = event.getGuild().getTextChannelById(Aletheia.CONFIGURATION.getString("channelJoinID", "id"));
        if(channel != null){
            channel.sendMessage(builder.build()).queue();
        }

    }
}
