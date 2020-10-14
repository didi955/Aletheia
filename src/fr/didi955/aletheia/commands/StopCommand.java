package fr.didi955.aletheia.commands;

import fr.didi955.aletheia.Aletheia;

public class StopCommand {

    private Aletheia aletheia;

    public StopCommand(Aletheia aletheia) {
        this.aletheia = aletheia;
    }

    @Command(name="stop", description="Stopper le bot", sender=Command.ExecutorType.CONSOLE)
    public void onStop(){
        aletheia.setRunning(false);
    }
}
