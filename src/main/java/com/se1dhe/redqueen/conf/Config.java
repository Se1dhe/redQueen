package com.se1dhe.redqueen.conf;

import com.se1dhe.redqueen.utils.PropertiesParser;
import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


/**
 * project: bot
 * developed by: s1LenT
 * date: 11.03.2021 0:30
 */


@Log4j2
public class Config {
    private static final Config INSTANCE = new Config();

    public static final String CONFIGURATION_BOT_FILE = "config/bot.properties";
    public static final String CONFIGURATION_DB_FILE = "config/database.properties";

    public static  long CREATOR_ID;
    public static String BOT_NAME;
    public static String BOT_TOKEN;
    public static String BOT_LANGUAGE;



    public static String DB_URL;
    public static String DB_USER;
    public static String DB_PWD;



    private Config() {
        load();
    }

    public static void load() {
        final PropertiesParser botSettings = new PropertiesParser(CONFIGURATION_BOT_FILE);
        BOT_NAME = botSettings.getString("bot.name", "RedQueen");
        BOT_TOKEN = botSettings.getString("bot.token", "1590228823:AAE5CS0GZXyOEFj_wreUV48vGclDmSIcdjA");
        BOT_LANGUAGE = botSettings.getString("bot.language", "ru");
        CREATOR_ID = botSettings.getLong("bot.creatorId", 1259547081);


        final PropertiesParser dbSettings = new PropertiesParser(CONFIGURATION_DB_FILE);
        DB_URL = dbSettings.getString("bot.url", "jdbc:mysql://127.0.0.1:3306/raffle?useUnicode=true&character_set_server=utf8mb4&autoReconnect=true&interactiveClient=true&serverTimezone=Europe/Kiev&useSSL=false");
        DB_USER = dbSettings.getString("bot.username", "root");
        DB_PWD = dbSettings.getString("bot.password", "1234");


    }


}
