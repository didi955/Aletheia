package fr.didi955.aletheia.commands;

import fr.didi955.aletheia.Aletheia;

public class StatsCommand {

    private Aletheia aletheia;

    public StatsCommand(Aletheia aletheia) {
        this.aletheia = aletheia;

    }

    @Command(name="stats", description="Voir mes statistiques de jeu", sender=Command.ExecutorType.USER)
    public void onStats(){

    }
}
