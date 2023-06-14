package net.LeverLoader.main;

import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Timer;
import java.util.TimerTask;
import static net.minecraft.client.Minecraft.getMinecraft;

public class LuckyBlockTimer
{
    public static int luckyblockgamemode;
    @SubscribeEvent
    public void inLuckyBlock (ClientChatReceivedEvent event)
    {
        if(event.message.getFormattedText().contains("§r§r§r    §r§e§lCollect Lucky Blocks from resource generators§r"))
        {
            System.out.println("Player has entered bedwars game");
            isLuckyBlockGM();
            if(luckyblockgamemode == 4)
            {

            }
            else if(luckyblockgamemode == 2)
            {

            }
        }
    }
    public void isLuckyBlockGM()
    {
        //drawRect(250, 250, 500, 500, 0xFFAABBCC);
        Timer timer = new Timer();
        final int slot = 5;
        TimerTask task = new TimerTask()
        {
            public void run()
            {
                getMinecraft().thePlayer.addChatMessage(new ChatComponentText("before ig"));
                Scoreboard board = getMinecraft().theWorld.getScoreboard();
                ScorePlayerTeam score = ReadScoreboard.readFromSlot(board, slot);
                getMinecraft().thePlayer.addChatMessage(new ChatComponentText(score.getColorPrefix() + score.getColorSuffix()));
                if((score.getColorPrefix() + score.getColorSuffix()).contains("§fKills: §a0"))
                {
                    luckyblockgamemode = 4;
                }
                else if((score.getColorPrefix() + score.getColorSuffix()).contains("§fW §fWhite§f:"))
                {
                    luckyblockgamemode = 2;
                }
                else
                {
                    getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§l§n§cAn error has occurred in attempt to detect lucky blocks gamemode"));
                    luckyblockgamemode = -1;
                }
            }
        };
        timer.schedule(task, 500);
    }
}
