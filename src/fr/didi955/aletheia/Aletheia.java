package fr.didi955.aletheia;

import fr.didi955.aletheia.jda.JDAManager;
import fr.didi955.aletheia.listeners.MessageListener;
import fr.didi955.aletheia.utils.Configuration;

import java.io.IOException;

public class Aletheia {

    public static final Configuration CONFIGURATION;

    static {
        Configuration configuration = null;

        try {
            configuration = new Configuration("config.json");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        CONFIGURATION = configuration;
    }

    public static void main(String... args){

        if(CONFIGURATION == null){
            System.out.println("Le fichier de configuration n'a pas été chargé !");
            return;
        }

        if(JDAManager.getShardManager() == null){
            System.out.println("Le bot n'a pas pu se connecter !");
            CONFIGURATION.save();
            return;
        }

        JDAManager.getShardManager().addEventListener(new MessageListener());

    }
}
