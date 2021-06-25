package junit5tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaggedTestClass {

    @BeforeAll
    void beforeAll() {
        System.out.println("--This is the before all method--");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("----This is the before each method----");
    }

    @AfterAll
    void afterAll() {
        System.out.println("--This is the after all method--");
    }

    @AfterEach
    void afterEach() {
        System.out.println("----This is the after each method----");
    }

    @Test
    @Tag("sanity")
    void firstMethod(){
        System.out.println("This is the first test method");
    }

    @Test
    @Tag("sanity")
    @Tag("acceptance")
    @DisplayName("US1234 - TC12 - this method is the second one")
    void secondMethod() {
        System.out.println("This is the second test method");
    }

    @Test
    @Tag("acceptance")
    void thirdMethod() {
        System.out.println("This is the third method");
    }

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @Tag("acceptance")
    @ValueSource(ints = {1,5,6})
    void intValues(int theParam) {
        System.out.println("theParam = " + theParam);
    }

}
