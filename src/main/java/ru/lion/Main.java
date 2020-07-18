package ru.lion;

import ru.lion.color.Color;
import ru.lion.connect.ex.AuthenticationException;
import ru.lion.rcon.Connect;

import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Color color = new Color();
        System.out.println(Charset.defaultCharset());
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in, Charset.defaultCharset()))) {
            Connect connect = new Connect();
            connect.setConnect();
            Scanner in = new Scanner(reader);
            System.out.println(Color.GREEN + "Config is here: " + System.getProperty("user.home") + " !" + Color.RESET + "\n");
            System.out.println(Color.CYAN + "------------------------------------------------------------------------");
            while (true) {
                System.out.println(Color.BLUE + "Input Command: ");
                String command = Color.BLUE + in.nextLine();
                if (command.isEmpty() || command.equalsIgnoreCase(" ") || command.equalsIgnoreCase("")) {
                    System.out.println("");
                } else {
                    System.out.println(Color.CYAN + "------------------------------------------------------------------------" + "\n");
                    System.out.println(Color.RESET + "Command: " + command + "\n");
                    System.out.println(Color.CYAN + "------------------------------------------------------------------------");
                    if (command.equalsIgnoreCase("exit")) {
                        System.out.println("Good Luck!");
                        break;
                    }
                    if (command.equalsIgnoreCase("reconnect")) {
                        connect.reload();
                        System.out.println(Color.YELLOW_BOLD +"Reload complete!");
                    }
                    connect.sendCommand(command);
                }

            }

        } catch (IOException | AuthenticationException ex) {
            System.err.println(ex);
        }
    }

}
