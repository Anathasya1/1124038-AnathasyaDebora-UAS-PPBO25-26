package uas.models;

public class Device {
    private String namaPemilik;
    private OperatingSystem operatingSystem;
    public Device(String namaPemilik, OperatingSystem operatingSystem){
        this.namaPemilik = namaPemilik;
        this.operatingSystem = operatingSystem;
    }

    public String getNamaPemilik(){
        return this.namaPemilik;
    }

    public String getDetails(){
        return namaPemilik + " booted: Booting " + operatingSystem.getBootInfo();
    }

    public int compareTo(Device b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
