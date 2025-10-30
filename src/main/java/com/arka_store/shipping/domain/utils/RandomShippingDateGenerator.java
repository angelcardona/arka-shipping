package com.arka_store.shipping.domain.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class RandomShippingDateGenerator {

    private static final int DIAS_MIN = 1;
    private static final int DIAS_MAX = 21;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    public static String generateAleatoryDate() {

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int aleatoryDays = random.nextInt(DIAS_MIN, DIAS_MAX + 1);

        LocalDate estimateArrivedDate = LocalDate.now().plusDays(aleatoryDays);
        return estimateArrivedDate.format(DATE_FORMATTER);
    }
}
