package junit5tests;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass2 {

    @Test
    @Order(-3)
    void firstMethod(){
        System.out.println("This is the first test method");
    }

    @Test
    @Order(1)
    void secondMethod() {
        System.out.println("This is the second test method");
    }

    @Test
    @Order(-1)
    void thirdMethod() {
        System.out.println("this is the third test method");
    }
}
