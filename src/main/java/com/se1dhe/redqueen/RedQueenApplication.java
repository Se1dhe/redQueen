package com.se1dhe.redqueen;

import com.se1dhe.redqueen.CoreApi.telegrambot.bots.DefaultTelegramBot;
import com.se1dhe.redqueen.CoreApi.telegrambot.handlers.IAccessLevelValidator;
import com.se1dhe.redqueen.CoreApi.telegrambot.handlers.ITelegramHandler;
import com.se1dhe.redqueen.conf.Config;
import com.se1dhe.redqueen.handler.ControlPanelHandler;
import com.se1dhe.redqueen.handler.StartHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
@Log4j2
public class RedQueenApplication {

    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(RedQueenApplication.class, args);
        log.info("[:::::::::::::::::::::::::::::::::::::::::]" );
        log.info("[::         NIGHT - DEVELOPMENT         ::]" );
        log.info("[::    https://night-development.com    ::]" );
        log.info("[::    https://t.me/night_development   ::]" );
        log.info("[::         NIGHT - DEVELOPMENT         ::]" );
        log.info("[:::::::::::::::::::::::::::::::::::::::::]" );

        final TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        DefaultTelegramBot bot = new DefaultTelegramBot(Config.BOT_TOKEN, Config.BOT_NAME);
        telegramBotsApi.registerBot(bot);

        bot.setAccessLevelValidator(new AccessLevelValidator());

        bot.addHandler(new StartHandler());
        bot.addHandler(new ControlPanelHandler());
    }

}

class AccessLevelValidator implements IAccessLevelValidator
{
    @Override
    public boolean validate(ITelegramHandler handler, User user)
    {
        if (handler.getRequiredAccessLevel() == 0)
        {
            return true;
        }

        // Database validation
        // TODO: Database validation

        // In this example we gonna use required access level 1 to ensure user has set their UserName
        if (handler.getRequiredAccessLevel() == 1 && user.getUserName() != null && !user.getUserName().isEmpty())
        {
            return true;
        }

        // Refuse access
        return false;
    }
}
