import org.example.AgeChecker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class AgeCheckerTest {
    @DataProvider(name = "getDates")
    public Object[][] provideDates() {
        return new Object[][]{
                {LocalDate.now().minusYears(19), true},// 19 y.o
                {LocalDate.now().minusYears(18), true},// 18 y.o
                {LocalDate.now().minusYears(18).plusDays(1), false}, // 17.99 y.o
                {LocalDate.now().minusYears(17), false},// 17 y.o
        };
    }

    @Test(dataProvider = "getDates")
    public void testIs18YearsOld(LocalDate dateOfBirth, boolean expectedResult) {
        boolean result = AgeChecker.is18YearsOld(dateOfBirth);
        Assert.assertEquals(result, expectedResult);
    }
}
