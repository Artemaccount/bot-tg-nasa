package commands;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StartCommand extends BotCommand {

    public StartCommand(String identifier, String description) {
        super(identifier, description);
    }
    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage message = new SendMessage();
        message.enableMarkdown(true);
        message.setChatId(chat.getId().toString());
        message.setText("Привет!\uD83D\uDE4B\u200D♂️ Вот список команд:" +
                "\n /help - расскажу что я умею" +
                "\n /cont - пришлю контент");
        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
