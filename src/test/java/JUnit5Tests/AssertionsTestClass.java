package JUnit5Tests;

import Listeners.Listener;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(Listener.class)
public class AssertionsTestClass {

    @Test
    void assertEqualsTest() {
        Assertions.assertEquals("firstString","secondString", "The String values were not equal");
        // Assertions.assertNotEquals("firstString","secondString", "The String values were not equal");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("first","second","third");
        List<String> actualValues = Arrays.asList("first","second","third");

        Assertions.assertEquals(expectedValues, actualValues);
    }

    @Test
    void assertArrayEqualsTest() {
        int[] expectedValues = {1,2,3};
        int[] actualValues = {1,2,3};

        Assertions.assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    void assertTrueTest() {
        // Assertions.assertFalse(false);
        Assertions.assertTrue(false, "This boolean condition isn't true");
    }

    @Test
    void assertThrowsTest() {
        Assertions.assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("firstString","secondString", "The String values were not equal"),
                () -> Assertions.assertThrows(NullPointerException.class, null),
                () -> Assertions.assertTrue(false, "This boolean condition isn't true")
        );
    }

    @Test
    void assertForMapTest() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);

        assertThat(theMap, Matchers.hasValue(2));
        assertThat(theMap, Matchers.hasKey("secondKey"));
    }

    @Test
    void assertForList() {
        List<String> theList = Arrays.asList("first","second","third");

        assertThat(theList, Matchers.hasItem("third"));
    }

    @Test
    void assertForAnyOf() {
        List<String> theList = Arrays.asList("first","second","third");

        assertThat(theList, Matchers.anyOf(Matchers.hasItem("third"),
                Matchers.hasItem("noString")));
        // assertThat(theList, Matchers.allOf(Matchers.hasItem("third"),
        //                Matchers.hasItem("noString")));
    }

    @Test
    void assertForContainsAnyOrder() {
        List<String> theList = Arrays.asList("first","second","third");

        assertThat(theList, Matchers.containsInAnyOrder("third","second","first"));
    }
}
