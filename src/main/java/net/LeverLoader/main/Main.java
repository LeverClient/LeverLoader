package net.LeverLoader.main;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import java.io.File;


@Mod(modid = Main.MOD_ID, name = Main.MOD_NAME, version = Main.VERSION)
public class Main // getMinecraft().thePlayer.addChatMessage(new ChatComponentText(""))
{
    public File configFile;
    public static final String MOD_ID = "lc";
    public static final String MOD_NAME = "LeverClient";
    public static final String VERSION = "0.1";
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new LuckyBlockTimer());
        ClientCommandHandler.instance.registerCommand(new Commands());
    }
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //lc_config configClass = new lc_config();
        configFile = event.getSuggestedConfigurationFile();
        Config.LoadConfigSettings(configFile);
    }
}
