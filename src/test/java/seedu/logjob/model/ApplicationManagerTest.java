package seedu.logjob.model;

import org.junit.jupiter.api.Test;
import seedu.logjob.ui.UiMain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

class ApplicationManagerTest {

    // Dummy implementation of ApplicationManager with a list to store added applications.
    private class DummyApplicationManager extends ApplicationManager {

        private final ArrayList<InternshipApplication> applications = new ArrayList<>();

        public DummyApplicationManager() {
            super(new ArrayList<InternshipApplication>());
        }

        @Override
        public void addApplication(InternshipApplication application) {
            applications.add(application);
        }

        // Helper method to retrieve stored applications for testing.
        public ArrayList<InternshipApplication> getApplications() {
            return applications;
        }
    }

    @Test
    void testAddApplication() {
        DummyApplicationManager manager = new DummyApplicationManager();
        String expectedCompany = "ExampleCorp";
        String expectedJobTitle = "Developer";
        InternshipApplication application = new InternshipApplication(
                expectedCompany, expectedJobTitle, LocalDate.now(), ApplicationStatus.APPLIED);

        UiMain uiMain = UiMain.getInstance();
        manager.addApplication(application);
        assertEquals(1, manager.getApplications().size(), "One application should be added.");
        InternshipApplication stored = manager.getApplications().get(0);

        assertEquals(expectedCompany, stored.getCompanyName(), "Company name should match.");
        assertEquals(expectedJobTitle, stored.getJobTitle(), "Job title should match.");
        assertEquals(ApplicationStatus.APPLIED, stored.getStatus(), "Application status should match as APPLIED.");
    }
}
