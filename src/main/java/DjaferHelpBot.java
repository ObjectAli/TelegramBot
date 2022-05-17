import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


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

            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());

            String textAnswer = generateAnswerByMessage(update.getMessage());

            message.setText(textAnswer);

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String generateAnswerByMessage(Message message){
        String textAnswer;

        Commands getCommand = Commands.fromValue(message.getText());

        switch (getCommand) {
            case START:
                textAnswer = "Привет, " + message.getFrom().getUserName() + ", я бот, умеющий реагировать на зарегистрированные команды!"; break;
            case COMMANDS_LIST:
                textAnswer = "Список команд: " + Commands.print(); break;
            default:
                textAnswer = "Эта команда мне не знакома"; break;
        }
        return textAnswer;
    }

}
