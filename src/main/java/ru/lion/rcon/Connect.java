package ru.lion.rcon;

import ru.lion.color.Color;
import ru.lion.config.ConfigManipulateValues;
import ru.lion.connect.Rcon;
import ru.lion.connect.ex.AuthenticationException;

import java.io.IOException;

public class Connect {


    String ip;
    int port;
    String password;

    Rcon connect;

    public void main(String[] args) throws IOException, AuthenticationException {
        setConnect();
    }

    public void setConnect() throws IOException {
        ConfigManipulateValues configManipulate = new ConfigManipulateValues();
        ip = configManipulate.getIp();
        port = configManipulate.getPort();
        password = configManipulate.getPassword();
        try {
            connect = new Rcon(ip, port, password.getBytes());
        } catch (Exception e) {
            System.err.println("Setting config! :D");
        }

    }

    public void sendCommand(String command) throws IOException {
        try {
           connect.command(command);

        } catch (NullPointerException e) {
            System.out.println(Color.YELLOW + "don't connect to server :D" + "\n" + Color.CYAN + "------------------------------------------------------------------------" + "\n");
        }
    }

    public void reload() throws IOException, AuthenticationException {
        try {
            connect.disconnect();
        } catch (IOException e) {
            connect.connect(ip, port, password.getBytes());
            System.out.println(Color.YELLOW + "reload...");
        }
    }
}
