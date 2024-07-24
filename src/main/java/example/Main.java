package example;

import example.namoz.App;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        MyTelegramBot bot = new MyTelegramBot();
        botsApi.registerBot(bot);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            try {
                bot.sendNamazTimes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 5, TimeUnit.HOURS);
    }
}

class MyTelegramBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
    }

    @Override
    public String getBotUsername() {
        return "https://t.me/salom_uz_salom_bot";
    }

    @Override
    public String getBotToken() {
        return "7110505468:AAG2B7FnnWA6m4ggsZJ6CKnVXGLb_YZkMX0";
    }

    public void sendNamazTimes() throws TelegramApiException, IOException, InterruptedException {
        // Baxtliy oilani ID si -1001151862908
        String chatID = "-1001151862908";
        String namazTimes = getNamzTimes();
        SendMessage message = new SendMessage();
        message.setChatId(chatID);
        message.setText(namazTimes);
        execute(message);

    }

    private String getNamzTimes() throws IOException, InterruptedException {
        App app = new App();
        return app.allInfo();
    }


}