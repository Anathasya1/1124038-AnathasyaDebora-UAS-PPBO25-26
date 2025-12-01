package uas.models;

public abstract class Linux extends OperatingSystem{
    private String desktopEnvironmentName;

    public Linux(String name, String version, String desktopEnvironmentName){
        super(desktopEnvironmentName, version);
        this.desktopEnvironmentName = desktopEnvironmentName;
    }

    public String getDesktopEnvironmentName(){
        return this.desktopEnvironmentName;
    }

    @Override
    public String getBootInfo(){
        return super.getName() + ", " + super.getVersion() + ", desktop name: " + desktopEnvironmentName;
    }

    public abstract String getDefaultDesktopEnvironment();
}
