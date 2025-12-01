package uas.views;

import uas.controllers.DeviceControllers;
import uas.exception.EmptyListException;
import uas.exception.InvalidMenuException;
import uas.models.Device;
import uas.models.Fedora;
import uas.models.OperatingSystem;
import uas.models.Ubuntu;
import uas.models.Windows;
import uas.util.CLIUtils;

public class DeviceView {
    private DeviceControllers deviceControllers;

    public DeviceView() {
        this.deviceControllers = new DeviceControllers();
    }

    private void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Device");
        System.out.println("2. Tampilkan semua device");
        System.out.println("3. Tampilkan semua device terurut berdasarkan OS");
        System.out.println("0. Keluar");

    }

    public void render() {
        int menu = -1;

        while (menu != 0) {
            this.printMenu();
            System.out.print("Input menu Utama: ");
            menu = CLIUtils.getInt();
            try {
                if (menu < 0 && menu > 3) {
                    throw new InvalidMenuException("Salah menu: " + menu);
                }

                switch (menu) {
                    case 1:
                        handleTambahDevice();
                        break;
                    case 2:
                        handlePrintDevice();
                        break;
                    case 3:
                        handleSortDevice();
                        break;

                    default:
                        break;
                }
            } catch (InvalidMenuException e) {
                System.out.println("Gagal: " + e.getMessage());
            } catch (EmptyListException e){
                System.out.println("List is empty");
            }

        }
    }

    public void handleTambahDevice() {
        CLIUtils.getString();
        System.out.print("Masukkan nama pengguna: ");
        String inputNamaPengguna = CLIUtils.getString();

        System.out.print("Pilih OS: 1. Windows, 2.Ubuntu, 3. Fedora \nInput OS: ");
        int tipe = CLIUtils.getInt();
        CLIUtils.getString();

        try {
            Device deviceBaru = null;
            if (tipe < 1 && tipe > 3) {
                throw new InvalidMenuException("Salah pilih operating system: " + tipe);
            }

            switch (tipe) {
                case 1:
                    System.out.print("Masukkan Version: ");
                    String inputVersion = CLIUtils.getString();
                    deviceBaru = new Device(inputNamaPengguna, new Windows(inputVersion));
                    break;
                case 2:
                    System.out.print("Apakah ingin memasukkan nama desktop environtment (y/n): ");
                    String inputNameDesktop = CLIUtils.getString();
                    
                    if (inputNameDesktop.equalsIgnoreCase("y")) {
                        System.out.print("Masukan nama desktop: ");
                        String nameDesktopEnvironment = CLIUtils.getString();
                        System.out.print("Masukkan Version: ");
                        inputVersion = CLIUtils.getString();
                        deviceBaru = new Device(inputNamaPengguna, new Ubuntu(inputVersion, nameDesktopEnvironment));
                    } else {
                        System.out.print("Masukkan Version: ");
                        inputVersion = CLIUtils.getString();
                        deviceBaru = new Device(inputNamaPengguna, new Ubuntu(inputVersion));
                    }
                    break;
                case 3:
                    System.out.print("Apakah ingin memasukkan nama desktop environtment (y/n): ");
                    inputNameDesktop = CLIUtils.getString();
                    if (inputNameDesktop.equalsIgnoreCase("y")) {
                        System.out.print("Masukan nama desktop: ");
                        String nameDesktopEnvironment = CLIUtils.getString();
                        System.out.print("Masukkan Version: ");
                        inputVersion = CLIUtils.getString();
                        deviceBaru = new Device(inputNamaPengguna, new Fedora(inputVersion, nameDesktopEnvironment));
                    } else {
                        System.out.print("Masukkan Version: ");
                        inputVersion = CLIUtils.getString();
                        deviceBaru = new Device(inputNamaPengguna, new Fedora(inputVersion));
                    }
                    break;
                default:
                    break;
            }
            if (deviceBaru != null) {
                this.deviceControllers.addDevice(deviceBaru);
            }
        } catch (InvalidMenuException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }

    private void handlePrintDevice() throws EmptyListException{
        var objects = this.deviceControllers.getAllDevice();
        for (Device device : objects) {
            System.out.println(device.getDetails());
        }
    }

    private void handleSortDevice() throws EmptyListException{
        this.deviceControllers.sortByOS();
        System.out.println("Kendaraan telah di urutkan");
        handlePrintDevice();
    }
}
