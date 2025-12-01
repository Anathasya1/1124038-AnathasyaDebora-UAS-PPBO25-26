package uas.models;

public class Fedora extends Linux{
    public Fedora(String version){
        super("Fedora", version, "KDE Plasma");
    }

    public Fedora(String version, String desktopEnvironmentName){
        super("Fedora", version, desktopEnvironmentName);
    }

    @Override
    public String getDefaultDesktopEnvironment(){
        return "Default: KDE Plasma";
    }
}
