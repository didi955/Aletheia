package fr.didi955.aletheia.listeners;

import fr.didi955.aletheia.Aletheia;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;

import java.util.ArrayList;
import java.util.List;

public class RemoveReactionEvent {

    public static void removeReaction(GuildMessageReactionRemoveEvent event){

        Role role = event.getGuild().getRoleById("603870153494495233");

        MessageChannel channel = event.getChannel();
        MessageReaction messageReaction = event.getReaction();

        if(channel.getId().equals(Aletheia.CONFIGURATION.getString("channelReglementID", "id"))){
            Member member = event.getMember();
            if(member != null){
                if(!member.getUser().equals(event.getJDA().getSelfUser())){
                    if(messageReaction.getReactionEmote().getName().equals("✅")){
                        List<Role> roles = new ArrayList<>(member.getRoles());
                        roles.remove(role);
                        event.getGuild().modifyMemberRoles(member, roles).queue();
                    }
                }
            }
        }
    }
}
