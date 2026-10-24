package practical;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ObjectCountingTest {

    @Test
    public void countWebPageObjects() {

        // Configure Chromium for GitHub Codespaces
        ChromeOptions options = new ChromeOptions();

        // Use Chromium installed in the Codespace
        options.setBinary("/usr/bin/chromium");

        // Run browser in headless mode
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        // Use installed ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        WebDriver driver = new ChromeDriver(options);

        try {

            // Open the local HTML page
            File htmlFile = new File("students.html");
            driver.get(htmlFile.toURI().toString());
            System.out.println();
            System.out.println("Web Page Being Verified : " + htmlFile.getAbsolutePath());
            System.out.println("Page Title              : " + driver.getTitle());
            System.out.println();

            // Count links
            int linkCount = driver.findElements(By.tagName("a")).size();

            // Count images
            // TASK 1: Write the statement to count all images on the webpage.
            int imageCount = 0;

            // Count buttons
            // TASK 2: Write the statement to count all buttons on the webpage.
            int buttonCount = 0;

            // Count input elements
            // TASK 3: Write the statement to count all input fields on the webpage.
            int inputCount = 0;

            // Calculate total objects
            int totalObjects =
                    linkCount + imageCount + buttonCount + inputCount;

            // Display results
            System.out.println();
            System.out.println("========================================");
            System.out.println("     WEB PAGE OBJECT ANALYSIS");
            System.out.println("========================================");

            System.out.println("Total Links        : " + linkCount);
            System.out.println("Total Images       : " + imageCount);
            System.out.println("Total Buttons      : " + buttonCount);
            System.out.println("Total Input Fields : " + inputCount);

            System.out.println("----------------------------------------");
            System.out.println("Total Objects      : " + totalObjects);
            System.out.println("========================================");

        } finally {

            // Close the browser
            driver.quit();
        }
    }
}