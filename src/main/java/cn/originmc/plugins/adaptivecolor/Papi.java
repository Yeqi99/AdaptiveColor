package cn.originmc.plugins.adaptivecolor;

import cn.originmc.plugins.origincore.hook.PlaceholderAPIHook;
import cn.originmc.plugins.origincore.util.text.FormatText;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Papi extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "adapt";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Yeqi";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }
    @Override
    public @Nullable String onRequest(OfflinePlayer player, @NotNull String params) {
        FormatText formatText=new FormatText(params);
        String v=formatText.getValue("value");
        double value;
        if (v.contains("!")){
            v=v.replace("!","");
            value= Double.parseDouble(PlaceholderAPIHook.getPlaceholder(player.getPlayer(),v));
        }else {
            value=Double.parseDouble(v);
        }
        String id=formatText.getValue("id");
        return Data.getColor(value,id);
    }
}
