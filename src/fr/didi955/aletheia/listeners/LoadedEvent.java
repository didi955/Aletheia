package fr.didi955.aletheia.listeners;

import fr.didi955.aletheia.reglement.Reglement;
import net.dv8tion.jda.api.events.ReadyEvent;

public class LoadedEvent {

    public static void onReady(ReadyEvent event){
        Reglement.MessageReglement();
    }
}
