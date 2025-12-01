package uas.models;

public class Ubuntu extends Linux{
    public Ubuntu(String version){
        super("Ubuntu", version, "Gnome");
    }

    public Ubuntu(String version, String desktopEnvironmentName){
        super("Ubuntu", version, desktopEnvironmentName);
    }

    @Override
    public String getDefaultDesktopEnvironment(){
        return "Default: Gnome";
    }

}
