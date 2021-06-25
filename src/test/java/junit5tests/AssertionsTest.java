package junit5tests;

import junit5Listeners.Listener;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(Listener.class)
public class AssertionsTest {

    @Test
    void assertEqualsTest() {
        assertEquals("firststring", "secondstring", "The String values were not equal");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("first", "second", "third");
        List<String> actualValues = Arrays.asList("first", "second");
        assertEquals(expectedValues, actualValues);
        assertNotEquals(expectedValues, actualValues);
    }

    @Test
    void assertArraysEqualsTest() {
        int[] expectedValues = {1,3};
        int[] actualValues = {1,2,3};
        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    void assertTrueTest() {
        assertFalse(false);
        assertTrue(false, "this boolean condition did not evaluate to true");
    }

    @Test
    void assertThrowsTest() {
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest() {
        assertAll(
                () -> assertEquals("firststring", "secondstring", "The String values were not equal"),
                () -> assertThrows(NullPointerException.class, null),
                () -> assertTrue(false, "this boolean condition did not evaluate to true")
        );
    }

    @Test
    void assertForMapTest() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstkey", 1);
        theMap.put("secondkey", 2);
        theMap.put("thirdkey", 3);

        assertThat(theMap, Matchers.hasValue(2));
        assertThat(theMap, Matchers.hasKey("secondkey1"));
    }

    @Test
    void assertForList() {
        List<String> theList = Arrays.asList("first", "second", "third");

        assertThat(theList, Matchers.hasItem("third"));
    }

    @Test
    void assertForAnyOf() {
        List<String> theList = Arrays.asList("first", "second", "third");

        assertThat(theList, Matchers.anyOf(Matchers.hasItem("third"), Matchers.hasItem("noString")));
    }

    @Test
    void assertForContainsAnyOrder() {
        List<String> theList = Arrays.asList("first", "second", "third");

        assertThat(theList, Matchers.containsInAnyOrder("first", "third", "second"));
    }
}
