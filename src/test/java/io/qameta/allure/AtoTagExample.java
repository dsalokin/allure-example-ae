package io.qameta.allure;

import org.junit.jupiter.api.Test;


@Layer("rest")
@Owner("baev")

public class AtoTagExample {

    @Test
    @AtoTags({@AtoTag("pew"), @AtoTag("pew-pew")})
    public void thisTestDoesNothing(String title) {
        System.out.println("pew");
    }



}
