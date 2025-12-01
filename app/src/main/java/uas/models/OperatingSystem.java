package uas.models;

public abstract class OperatingSystem{
    private String name;
    private String version;

    public OperatingSystem(String name, String version){
        this.name = name;
        this.version = version;
    }

    public String getName(){
        return this.name;
    }
    public String getVersion(){
        return this.version;
    }

    public abstract String getBootInfo();
}
