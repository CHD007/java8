package com.chernyshov777.java8inaction.optionaltest;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        Usb usb = new Usb("3.0");
        Soundcard soundcard = new Soundcard(usb);
        Computer computer = new Computer(soundcard);

        Optional<Computer> computer1 = Optional.of(computer);
        String usbVersion = computer1.map(Computer::getSoundcard)
                .map(Soundcard::getUsb)
                .map(Usb::getVersion)
                .orElse("UNKNOWN");
        System.out.println(" usb version is " + usbVersion);
    }
}
