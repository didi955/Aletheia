package fr.didi955.aletheia.listeners;

import fr.didi955.aletheia.Aletheia;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;

import java.awt.*;

public class JoinEvent {

    public static void onJoin(GuildMemberJoinEvent event){
        EmbedBuilder builder = new EmbedBuilder();
        User user = event.getUser();
        builder.setAuthor(user.getName(), null, user.getAvatarUrl()+"?size=256");
        builder.setTitle("Bienvenue " + user.getAsMention() + " !");
        builder.setDescription("sur le discord de Rushcubeland\n Fais !help pour plus d'informations");
        builder.setColor(Color.ORANGE);
        MessageChannel channel = event.getGuild().getTextChannelById(Aletheia.CONFIGURATION.getString("channelJoinID", "id"));
        if(channel !=null){
            channel.sendMessage(builder.build()).queue();
        }

    }
}
