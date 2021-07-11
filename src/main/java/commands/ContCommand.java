package commands;

import contSender.GetCont;
import lombok.SneakyThrows;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.io.IOException;

public class ContCommand extends BotCommand {
    public ContCommand(String identifier, String description) {
        super(identifier, description);
    }

    @SneakyThrows
    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        GetCont getCont = new GetCont();

        SendMessage msgExplanation = new SendMessage();
        msgExplanation.enableMarkdown(true);
        msgExplanation.setChatId(chat.getId().toString());
        msgExplanation.setText(getCont.getExplanation());

        SendMessage oneMoment = new SendMessage();
        oneMoment.enableMarkdown(true);
        oneMoment.setChatId(chat.getId().toString());
        oneMoment.setText("Загружаю для тебя контент\uD83D\uDC68\u200D\uD83D\uDCBB" +
                    "\nОдин момент!");
        absSender.execute(oneMoment);
        if(getCont.getMediaType().equals("image")){
            absSender.execute(createPhoto(chat.getId(), getCont.getHdUrl()));
        } else {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(getCont.getUrl());
            absSender.execute(sendMessage);
        }
        absSender.execute(msgExplanation);
    }

    private SendPhoto createPhoto(Long chatId, String url) {
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId.toString());
        photo.setPhoto(new InputFile(url));
        return photo;
    }
}
