package org.example;

import java.time.LocalDate;
import java.time.Period;

public class AgeChecker {
    public static boolean is18YearsOld(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dateOfBirth, today);
        return period.getYears() >= 18;
    }
}
