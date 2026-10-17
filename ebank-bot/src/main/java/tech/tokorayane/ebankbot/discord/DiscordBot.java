package tech.tokorayane.ebankbot.discord;

import com.zgamelogic.discord.annotations.DiscordController;
import com.zgamelogic.discord.annotations.DiscordMapping;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import tech.tokorayane.ebankbot.agents.EBankAIAgent;

@DiscordController
public class DiscordBot {
    private final EBankAIAgent eBankAIAgent;

    public DiscordBot(EBankAIAgent eBankAIAgent) {
        this.eBankAIAgent = eBankAIAgent;
    }

    @DiscordMapping
    private void perform(MessageReceivedEvent event){
        if (event.getAuthor().isBot()) return;
        String query = event.getMessage().getContentRaw();
        String response = this.eBankAIAgent.chat("0", query);
        event.getChannel().sendMessage(response).queue();
    }
}
