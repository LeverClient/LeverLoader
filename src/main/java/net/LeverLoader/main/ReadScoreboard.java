package net.LeverLoader.main;

import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import java.util.Collection;
import java.util.Iterator;

public class ReadScoreboard
{
    public static ScorePlayerTeam readFromSlot(Scoreboard board, int slot)
    {
        Collection<ScorePlayerTeam> teams = board.getTeams();
        for (ScorePlayerTeam score : teams)
        {
            if (score.getRegisteredName().equals("team_" + slot))
            {
                return score;
            }
        }
        throw new RuntimeException(String.format("could not find slot %s on scoreboard",slot));
    }
}
