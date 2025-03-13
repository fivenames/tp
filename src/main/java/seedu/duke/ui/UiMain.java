package seedu.duke.ui;

import java.sql.SQLOutput;
import java.util.Scanner;

import seedu.duke.logic.parser.ApplicationParser;
import seedu.duke.main.Constants;

public class UiMain {
    private static Scanner scan = new Scanner(System.in);

    public static void IntroMessage() {
        System.out.println(Constants.LOGO);
        System.out.println(Constants.INTRO_MESSAGE);
    }

    public static void readInput() {
        try {
        String input = scan.nextLine();
        ApplicationParser.parseCommand(input);
        } catch (seedu.duke.logic.parser.exceptions.ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void ExitMessage() {
        System.out.println("Goodbye!");
        scan.close();
    }
}
