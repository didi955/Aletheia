package fr.didi955.aletheia;

import fr.didi955.aletheia.commands.CommandMap;
import fr.didi955.aletheia.jda.JDAManager;
import fr.didi955.aletheia.listeners.Listener;
import fr.didi955.aletheia.reglement.Reglement;
import fr.didi955.aletheia.utils.Configuration;

import java.io.IOException;
import java.util.Scanner;

public class Aletheia implements Runnable {

    public static final Configuration CONFIGURATION;
    public static final Configuration MESSAGE_RESSOURCES;
    private boolean running;
    private final Scanner scanner = new Scanner(System.in);
    private final CommandMap commandMap = new CommandMap(this);

    public Aletheia() {
        if(MESSAGE_RESSOURCES == null){
            System.out.println("Le fichier de configuration des mesages n'a pas été chargé !");
            return;
        }
        if(CONFIGURATION == null){
            System.out.println("Le fichier de configuration n'a pas été chargé !");
            return;
        }

        if(JDAManager.getShardManager() == null){
            System.out.println("Le bot n'a pas pu se connecter !");
            CONFIGURATION.save();
            MESSAGE_RESSOURCES.save();
            return;
        }

        JDAManager.getShardManager().addEventListener(new Listener(new CommandMap(this)));

    }

    static {
        Configuration configuration = null;
        Configuration configuration_msg = null;

        try {
            configuration = new Configuration("config.json");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        CONFIGURATION = configuration;

        try {
            configuration_msg = new Configuration("messages.json");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        MESSAGE_RESSOURCES = configuration_msg;
    }

    public static void main(String... args){

        Aletheia aletheia = new Aletheia();
        new Thread(aletheia, "aletheia").start();

    }

    @Override
    public void run() {
        running = true;

        while (running){
            if(scanner.hasNextLine()){
                commandMap.commandConsole(scanner.nextLine());
            }
        }
        scanner.close();
        JDAManager.getShardManager().shutdown();
        System.out.println("Bot stopped");
        System.exit(0);
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
