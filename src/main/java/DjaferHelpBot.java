import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Collection;
import java.util.List;

public class DjaferHelpBot extends TelegramLongPollingBot {

    String API_TOKEN_KEY = "5388076376:AAHd9FQ0kDZfwiUPKcrqUxEdjstAkn5rPM8";
    String BOT_USER_NAME = "DjaferHelpBot";

    @Override
    public String getBotUsername() {
        return BOT_USER_NAME;
    }

    @Override
    public String getBotToken() {
        return API_TOKEN_KEY;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            String messageUserName = update.getMessage().getFrom().getUserName();

            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            String textMessage = update.getMessage().getText();

            if (textMessage.equalsIgnoreCase("/start"))
                message.setText("Привет, " + messageUserName);
            else message.setText("Мне не понятно");

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

}
