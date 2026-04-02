package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.parameter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestParameters {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(-1, 1, 0),
                Arguments.of(0, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testSum1(int x, int y, int sum) {
        Allure.parameter("x", x);
        Allure.parameter("y", y);
        Allure.parameter("sum", sum);

        assertEquals(x + y, sum);
    }

    @ParameterizedTest(name = "hey-hey look")
    @MethodSource("dataProvider")
    public void testSum2(int x, int y, int sum) {
        Allure.parameter("x", x);
        Allure.parameter("y", y);
        Allure.parameter("sum", sum);

        assertEquals(x + y, sum);
    }

    @ParameterizedTest(name = "Something here")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldCreateUserNote(String title) {
        parameter("owner", OWNER);
        parameter("repo", REPO);
        parameter("title", title);

        assertNotEquals("aaa", title);
    }

    @ParameterizedTest(name = "Here is the user with parameter {0}")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldCreateUserNote2(String title) {
        parameter("owner", OWNER);
        parameter("repo", REPO);
        parameter("title", title);

        assertNotEquals("aaa", title);
    }
}