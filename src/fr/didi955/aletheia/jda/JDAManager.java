package fr.didi955.aletheia.jda;

import fr.didi955.aletheia.Aletheia;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class JDAManager {

    private static final ShardManager shardManager = buildShard();

    public static ShardManager getShardManager() {
        return shardManager;
    }

    private static ShardManager buildShard(){

        EnumSet<GatewayIntent> intents = EnumSet.of(
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_EMOJIS,
                GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.GUILD_BANS,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.DIRECT_MESSAGE_TYPING,
                GatewayIntent.GUILD_MEMBERS
        );
        try {

            return DefaultShardManagerBuilder.create(intents).setToken(Aletheia.CONFIGURATION.getString("token", "Token")).setShardsTotal(Aletheia.CONFIGURATION.getInt("shardTotal", 1)).build();

        } catch (LoginException e) {
            e.printStackTrace();
        }
        return null;
    }
}
