package cn.originmc.plugins.adaptivecolor;

import cn.originmc.plugins.origincore.util.register.CommandRegister;
import cn.originmc.plugins.origincore.util.text.Sender;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdaptiveColor extends JavaPlugin {
    private static JavaPlugin instance;
    private static Sender sender;

    public static JavaPlugin getInstance() {
        return instance;
    }

    public static Sender getSender() {
        return sender;
    }

    public static void setSender(Sender sender) {
        AdaptiveColor.sender = sender;
    }

    @Override
    public void onEnable() {
        instance=this;
        setSender(new Sender(this));
        Data.load();
        CommandRegister.register(this,new AdaptiveColorCommand(),"AdaptiveColor");
        saveResource("adaptiveColor/example.yml",false);
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new Papi().register();
        }
        getSender().sendOnEnableMsgToLogger("AdaptiveColor","Yeqi","1.0.0","Public");
    }

    @Override
    public void onDisable() {
        getSender().sendOnDisableMsgToLogger("AdaptiveColor","Yeqi","1.0.0","Public");
    }
}
