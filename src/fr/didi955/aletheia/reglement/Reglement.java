package fr.didi955.aletheia.reglement;

import fr.didi955.aletheia.Aletheia;
import fr.didi955.aletheia.jda.JDAManager;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;

public class Reglement {

    public static void MessageReglement(){

        TextChannel channel = JDAManager.getShardManager().getTextChannelById(Aletheia.CONFIGURATION.getString("channelReglementID", "id"));

        if (channel != null) {
            MessageHistory history = channel.getHistory();
            if(history.isEmpty()){
                channel.sendMessage(Aletheia.MESSAGE_RESSOURCES.getString("messageReglement", "Voici le reglement de notre serveur")).queue();
            }
        }

    }
}
