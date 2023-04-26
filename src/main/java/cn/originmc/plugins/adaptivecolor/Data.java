package cn.originmc.plugins.adaptivecolor;

import cn.originmc.plugins.origincore.util.data.yaml.YamlManager;
import cn.originmc.plugins.origincore.util.text.TextProcessing;

public class Data {
    public static YamlManager yamlManager;
    public static void load(){
        yamlManager=new YamlManager(AdaptiveColor.getInstance(),"adaptiveColor",true);
    }
    public static String getColor(double num,String id){
        String result="";
        boolean isNormal=true;
        for (String adapt : yamlManager.getKeyList(id, "adapt", false)) {
            if (adapt.equalsIgnoreCase("normal")){
                continue;
            }
            if (TextProcessing.inSection(adapt,num)){
                result= (String) yamlManager.get(id,"adapt."+adapt);
                isNormal=false;
                break;
            }
        }
        if (isNormal){
            return (String) yamlManager.get(id,"adapt.normal","§r");
        }else {
            return result;
        }
    }
}
