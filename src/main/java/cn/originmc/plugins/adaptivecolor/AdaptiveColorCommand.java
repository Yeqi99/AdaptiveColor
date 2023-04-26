package cn.originmc.plugins.adaptivecolor;

import cn.originmc.plugins.origincore.util.command.CommandUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class AdaptiveColorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        CommandUtil cu=new CommandUtil(sender,command,label,args);
        if (!cu.hasPerm("adaptColor.admin")){
            if (!cu.isAdmin()){
                return true;
            }
        }
        if (cu.is(0,"reload")){
            Data.load();
        }
        return true;
    }
}
