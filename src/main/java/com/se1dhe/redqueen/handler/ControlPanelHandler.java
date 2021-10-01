package com.se1dhe.redqueen.handler;

import com.se1dhe.redqueen.CoreApi.*;
import com.se1dhe.redqueen.CoreApi.events.InlineCallbackEvent;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ControlPanelHandler extends AbstractInlineHandler
{
    @Override
    public String getUsage()
    {
        return "/menu";
    }

    @Override
    public String getDescription()
    {
        return "Renders static menu";
    }

    @Override
    public String getCommand()
    {
        return "/menu";
    }

    @Override
    public int getRequiredAccessLevel()
    {
        return 1;
    }

    @Override
    public void registerMenu(InlineContext ctx, InlineMenuBuilder builder) {
        builder
                .name("adminMenuName"/*, telegramBotConfig.getBotLanguage()*/)
                .button(new InlineButtonBuilder(ctx)
                        .name("adminAddButton"/*, telegramBotConfig.getBotLanguage()*/)
                        .row(0)
                        .onQueryCallback(this::handleButtonClick)
                        .build())
                .button(new InlineButtonBuilder(ctx)
                        .name("adminAddButton"/*, telegramBotConfig.getBotLanguage()*/)
                        .row(0)
                        .onQueryCallback(this::handleButtonClick)
                        .build())
                .button(new InlineButtonBuilder(ctx)
                .name("sub menu")
                        .menu(new InlineMenuBuilder(ctx)
                                .button(new InlineButtonBuilder(ctx)
                                .name("Sub Button 1")
                                .onQueryCallback(this::handleButtonClick)
                                .build())
                                .button(defaultBack(ctx))
                                .build())
                        .build())
                .button(defaultClose(ctx));
    }

    private boolean handleButtonClick(InlineCallbackEvent event) throws TelegramApiException
    {
        final InlineUserData userData = event.getContext().getUserData(event.getQuery().getFrom().getId());
        final AnswerCallbackQuery answer = new AnswerCallbackQuery();
        answer.setCallbackQueryId(event.getQuery().getId());
        answer.setShowAlert(true);
        answer.setText("You've clicked at " + userData.getActiveButton().getName());
        event.getBot().execute(answer);
        return true;
    }
}

