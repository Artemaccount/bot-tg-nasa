package commands;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HelpCommand extends BotCommand {

    public HelpCommand(String identifier, String description) {
        super(identifier, description);
    }
    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage message = new SendMessage();
        message.enableMarkdown(true);
        message.setChatId(chat.getId().toString());
        message.setText("Я умею отправлять фото или видео и описание к нему с сайта NASA\uD83C\uDF0C" +
                "\n Контент обновляется раз в день" +
                "\n /cont - получить контент и описание\uD83D\uDE42" +
                "\n описание на английском, " +
                "потому что я пока не умею переводить текст\uD83E\uDD37\u200D♂️");
        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
