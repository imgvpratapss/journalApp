package net.engineeringdigest.journalApp.custom;

import net.engineeringdigest.journalApp.entity.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;


import java.util.stream.Stream;

public class UserArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context)  {
        return Stream.of(
                Arguments.of(User.builder().userName("ram11").password("ram").build()),
                Arguments.of(User.builder().userName("shiva101").password("abc").build()),
                Arguments.of(User.builder().userName("vijay101").password("").build())

        );
    }
}
