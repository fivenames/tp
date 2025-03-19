package seedu.duke.main;

import seedu.duke.ui.UiMain;
import seedu.duke.logic.commands.Command;
import seedu.duke.logic.parser.ApplicationParser;
import seedu.duke.logic.parser.exceptions.ParseException;
import seedu.duke.storage.StorageManager;
import seedu.duke.model.ApplicationManager;

public class Duke {

    private static Boolean isRunning = true;

    public static void main(String[] args) {
        //StorageManager storage = new StorageManager();
        ApplicationManager applicationManager = new ApplicationManager();
        UiMain.introMessage();
        while (isRunning) {
            try {
                String input = UiMain.readInput();
                UiMain.showLineBreak();
                Command c = ApplicationParser.parseCommand(input);
                isRunning = c.isRunning();
                c.execute(applicationManager);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        UiMain.exitMessage();
    }
}
