package com.techswitch.ispy.models.request.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class DateValidatorTest {
    private DateValidator validator = new DateValidator();

    @Test
    public void dateValidatorReturnsTrueForValidDate() {
        String validDate = "18-07-1992";
        boolean isValid = validator.isValid(validDate, null);
        assertThat(isValid).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "18/07/1992", "12022019", "1579190045", "" })
    public void dateValidatorReturnsFalseForInvalidDate(String invalidInput) {
        boolean isValid = validator.isValid(invalidInput, null);
        assertThat(isValid).isFalse();
    }
}