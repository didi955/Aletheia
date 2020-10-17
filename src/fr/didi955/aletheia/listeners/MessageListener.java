package fr.didi955.aletheia.listeners;

import fr.didi955.aletheia.Aletheia;
import fr.didi955.aletheia.commands.CommandMap;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MessageListener {

    private CommandMap commandMap;

    public MessageListener(CommandMap commandMap) {
        this.commandMap = commandMap;
    }

    public void onMessage(MessageReceivedEvent event){
        if(event.getTextChannel().getId().equals(Aletheia.CONFIGURATION.getString("channelReglementID", "id"))){
            event.getTextChannel().addReactionById(event.getMessageId(), "✅").queue();
            return;
        }
        if(event.getAuthor().equals(event.getJDA().getSelfUser())) {
            return;
        }
        String message = event.getMessage().getContentRaw();
        if(message.startsWith(CommandMap.getTag())){
            if(event.getTextChannel() != null && !event.getTextChannel().getId().equals(Aletheia.CONFIGURATION.getString("channelCommandsID", "id"))) return;
            message = message.replaceFirst(CommandMap.getTag(), "");
            if(commandMap.commandUser(event.getAuthor(), message, event.getMessage())){
                if(event.getTextChannel() != null && event.getGuild().getSelfMember().hasPermission(Permission.MESSAGE_MANAGE)){
                    event.getMessage().delete().queue();
                }
            }
        }
    }
}
