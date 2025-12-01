package uas.models;

public class Windows extends OperatingSystem {
    public Windows(String version){
        super("Windows", version);
    }

    @Override
    public String getBootInfo(){
        return super.getName() + ", " + super.getVersion();
    }
}
