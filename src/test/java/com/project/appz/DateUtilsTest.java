package com.project.appz;
import com.project.appz.utils.DateUtils;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void getCurrentDate_ShouldReturnCurrentDate() {
        // Act
        LocalDate currentDate = DateUtils.getCurrentDate();

        // Assert
        assertNotNull(currentDate);
        LocalDate expectedDate = LocalDate.now();
        assertEquals(expectedDate, currentDate);
    }

    @Test
    void formatToString_ShouldReturnFormattedString() {
        // Arrange
        LocalDate date = LocalDate.of(2023, 4, 10); // Example date

        // Act
        String formattedDate = DateUtils.formatToString(date);

        // Assert
        assertEquals("2023-04-10", formattedDate);
    }
}
