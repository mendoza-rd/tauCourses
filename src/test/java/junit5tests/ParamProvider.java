package junit5tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class ParamProvider {

    static Stream<Arguments> sourceStream_StringDouble() {
        //processing
        return Stream.of(Arguments.arguments("apple", 2.0), Arguments.arguments("pear", 2.5),
                Arguments.arguments("cabbage", 7.8));
    }
}
