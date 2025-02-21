package tests;

import entity.User;

public class Preconditions extends BaseTest {

    protected final User userWithEmptyUsername = User.builder()
            .username("")
            .password(PASSWORD)
            .build();

    protected final User userSuccess = User.builder()
            .username(USERNAME)
            .password(PASSWORD)
            .build();

    protected final User userWithEmptyPassword = User.builder()
            .username(USERNAME)
            .password("")
            .build();

    protected final User userEmptyFields = User.builder()
            .username("")
            .password("")
            .build();

    protected final User userIncorrectFields = User.builder()
            .username("refjebfle")
            .password("efewfefw")
            .build();
}
