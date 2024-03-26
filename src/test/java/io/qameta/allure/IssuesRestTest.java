package io.qameta.allure;

import io.qameta.allure.model.Parameter;
import io.qameta.allure.Param;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Date;
import java.util.stream.Stream;

@Layer("rest")
@Owner("baev")
@Feature("TestParameters")
public class IssuesRestTest {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private final RestSteps steps = new RestSteps();

    @Story("Dynamic parameter")
    @Microservice("Report")
    @Tags({@Tag("parameter"), @Tag("dynamic"), @Tag("usecase")})
    @ParameterizedTest(name = "Should generate in progress results each rerun of a pipeline ")
    @MethodSource("epochTimestamps")
    public void shouldDeleteUserNote(@Param(value = "HashOrSomething") long epochTimestamp) {
        Date date = new Date(epochTimestamp);
        String note = date.toString();
        steps.createIssueWithTitle(OWNER, REPO, note);
        steps.closeIssueWithTitle(OWNER, REPO, note);
    }
    static Stream<Long> epochTimestamps() {
        long epochOne = System.currentTimeMillis();
        long epochTwo = System.currentTimeMillis() + 1000012;
        return Stream.of(epochOne, epochTwo);
    }

}
