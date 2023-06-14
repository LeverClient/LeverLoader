package net.LeverLoader.main;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.Property;
import static net.minecraft.client.Minecraft.getMinecraft;
public class Commands extends CommandBase
{
    public String[] mainTheme = new String[4];
    /*
    Ocean(Dark Blue, Blue, Dark Aqua, Aqua)
    Magic(Dark Purple, Light Purple)
    Volcano(Dark Red, Red, Gold, Yellow)
    Space(Black, Dark Gray, Gray, White)
    Default(White)
    Solid Color(mainColor)
    */
    public static String mainColor = "§f";

    public static void saveConfig(net.minecraftforge.common.config.Configuration config, String Category)
    {
        Property color = config.get(Category, "mainColor", mainColor);
        color.comment = "Main color for LeverClient, default color is white (f).";
        color.set(mainColor);
    }
    public static void loadConfig(net.minecraftforge.common.config.Configuration config, String Category)
    {
        mainColor = config.get(Category,"mainColor", mainColor).getString();
    }
    @Override
    public String getCommandName()
    {
        return "lc";
    }
    @Override
    public String getCommandUsage(ICommandSender sender)
    {
        return  "§a§lCommands for " + mainColor + "§lLeverClient: \n" +
                mainTheme[0] + "§ltest1\n" +
                mainTheme[1] + "§ltest2\n" +
                mainTheme[2] + "§ltest3\n" +
                mainTheme[3] + "§ltest4\n" +
                mainTheme[0] + "§ltest5\n" +
                mainTheme[1] + "§ltest6\n" +
                mainTheme[2] + "§ltest7\n" +
                mainTheme[3] + "§ltest8\n";
    }
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }
    @Override
    public void processCommand(ICommandSender sender, String[] args)
    {
        if(args.length == 0)
        {
            unknownCommand();
            return;
        }
        if(args[0].equalsIgnoreCase("") || args[0].equalsIgnoreCase(" "))
        {
            unknownCommand();
        }
        switch(args[0].toLowerCase())
        {
            case "help":
            {
                    if(args.length == 1)
                    {
                        sender.addChatMessage(new ChatComponentText(getCommandUsage(sender)));
                    }
                    else
                    {
                        switch(args[1].toLowerCase())
                        {
                            case "maincolor":
                            {
                                sender.addChatMessage(new ChatComponentText("§a§lChanges the " + mainColor + "§lmain color §a§lfor LeverClient"));
                                sender.addChatMessage(new ChatComponentText("§a§lUsage: " + mainColor + "§lmainColor {color symbol}\n" + "§a§lex: " + mainColor + "§l/lc mainColor f"));
                                break;
                            }
                            case "color":
                            case "colorchart":
                            {
                                sender.addChatMessage(new ChatComponentText("§a§lDisplays " + mainColor +"§lcolor list §a§lfor mainColor"));
                                sender.addChatMessage(new ChatComponentText("§a§lUsage: " + mainColor + "colorChart\n" + "§a§lex: " + mainColor + "/lc colorChart"));
                                break;
                            }
                            default:
                            {
                                sender.addChatMessage(new ChatComponentText(getCommandUsage(sender)));
                            }
                        }
                    }
                    break;
            }
            case "color":
            case "colorchart":
            {
                sender.addChatMessage(new ChatComponentText(("§l0 = §0Black         §r§l1 = §1Dark Blue\n" +
                                                             "§l2 = §2Dark Green    §r§l3 = §3Dark Aqua\n" +
                                                             "§l4 = §4Dark Red      §r§l5 = §5Dark Purple\n" +
                                                             "§l6 = §6Gold          §r§l7 = §7Gray\n" +
                                                             "§l8 = §8Dark Gray     §r§l9 = §9Blue\n" +
                                                             "§la = §aGreen         §r§lb = §bAqua\n" +
                                                             "§lc = §cRed           §r§ld = §dLight Purple\n" +
                                                             "§le = §eYellow        §r§lf = §fWhite")));
                break;
            }
            case "maincolor":
            {
                if(args.length == 1)
                {
                    getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§c§lInvalid statement. Try using " + mainColor + " §l/lc help mainColor §c§lfor help on using the " + mainColor + "§lmainColor §c§lfeature"));
                }
                else
                {
                    switch(args[1].toLowerCase())
                    {
                        case "0":
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                        case "7":
                        case "8":
                        case "9":
                        case "a":
                        case "b":
                        case "c":
                        case "d":
                        case "e":
                        case "f":
                        {
                            mainColor = "§" + args[1].toLowerCase();
                            getMinecraft().thePlayer.addChatMessage(new ChatComponentText(mainColor + "§lMain Color §a§lchanged."));
                            Config.SaveConfigSettings();
                            break;
                        }
                        default:
                        {
                            getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§c§lInvalid argument. Try using a value between 0-9 or a-f"));
                        }

                    }
                }
                break;
            }
            case "stats":
            case "sc":
            case "statscheck":
            {

            }
            default:
            {
                unknownCommand();
            }
        }
    }
    public void unknownCommand()
    {
        getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§c§lUnknown command. Try using " + mainColor + "§l/lc help§c§l for a list of commands."));
    }
}
