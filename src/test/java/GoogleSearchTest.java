import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchTest {
    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-GB");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        open("https://www.google.com");
    }

    static void findLibertex(){
        $x("//textarea[@name='q']").setValue("libertex").pressEnter();
    }

    @Test
    public void testSearchByName() {
        findLibertex();
        $x("//a[contains(@href, 'libertex.com/')]").should(Condition.exist);
    }

    @Test
    public void testHover() {
        $x("//textarea[@name='q']").hover();
        $x("//textarea[@title='Search']").should(Condition.visible);
    }

    @Test
    public void testLogoClick() {
        findLibertex();
        $x("//a[@title='Go to Google Home']").click();
        assert !$x("//div[@id='search']").exists();

    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
