package com.pittacode.anagrams.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER;
import static org.junit.jupiter.params.ParameterizedTest.DISPLAY_NAME_PLACEHOLDER;

public class StringSorterTest {

    private StringSorter underTest;

    @BeforeEach
    void setUp() {
        underTest = new StringSorter();
    }

    @ParameterizedTest(name = ARGUMENTS_WITH_NAMES_PLACEHOLDER + " -> " + DISPLAY_NAME_PLACEHOLDER)
    @ValueSource(strings = {"a", "%", "1", "D"})
    void shouldReturnInputWhenItIsSingleCharacter(String input) {
        var result = underTest.sort(input);
        assertThat(result).isEqualTo(input);
    }

    @ParameterizedTest(name = ARGUMENTS_WITH_NAMES_PLACEHOLDER + " -> " + DISPLAY_NAME_PLACEHOLDER)
    @ValueSource(strings = {"", "    ", " "})
    void shouldReturnEmptyStringWhenItIsBlank(String input) {
        var result = underTest.sort(input);
        assertThat(result).isEqualTo("");
    }
}
