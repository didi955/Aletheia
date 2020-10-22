package fr.didi955.aletheia.listeners;

import fr.didi955.aletheia.Aletheia;
import fr.didi955.aletheia.jda.JDAManager;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;

import java.util.List;

public class QuitEvent {

    public static void onQuit(GuildMemberRemoveEvent event){

        TextChannel channel = JDAManager.getShardManager().getTextChannelById(Aletheia.CONFIGURATION.getString("channelReglementID", "id"));
        if (channel != null) {
            MessageHistory history = channel.getHistory();
            List<Message> msgs = history.getRetrievedHistory();
            for (Message msg : msgs){
                msg.removeReaction("✅", event.getUser()).queue();
            }
        }

    }
}
