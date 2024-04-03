package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.StringListImpl;

import static org.junit.jupiter.api.Assertions.*;

public class StringListTest {

    private StringListImpl stringList;

    @BeforeEach
    public void setUp() {
        stringList = new StringListImpl(5);
    }

    @Test
    public void testAdd() {
        stringList.add("Item1");
        stringList.add("Item2");
        stringList.add("Item3");

        assertEquals(3, stringList.size());
        assertTrue(stringList.contains("Item1"));
        assertTrue(stringList.contains("Item2"));
        assertTrue(stringList.contains("Item3"));
    }

    @Test
    public void testAddAtIndex() {
        stringList.add("Item1");
        stringList.add("Item3");
        stringList.add(1, "Item2");

        assertEquals(3, stringList.size());
        assertEquals("Item1", stringList.get(0));
        assertEquals("Item2", stringList.get(1));
        assertEquals("Item3", stringList.get(2));
    }

    @Test
    public void testSet() {
        stringList.add("Item1");
        stringList.add("Item2");

        stringList.set(1, "Item3");

        assertEquals("Item3", stringList.get(1));
    }

    @Test
    public void testRemove() {
        stringList.add("Item1");
        stringList.add("Item2");
        stringList.add("Item3");

        stringList.remove("Item2");

        assertEquals(2, stringList.size());
        assertFalse(stringList.contains("Item2"));
    }

    @Test
    public void testRemoveAtIndex() {
        stringList.add("Item1");
        stringList.add("Item2");
        stringList.add("Item3");

        stringList.remove(1);

        assertEquals(2, stringList.size());
        assertFalse(stringList.contains("Item2"));
    }

    @Test
    public void testContains() {
        stringList.add("Item1");
        stringList.add("Item2");

        assertTrue(stringList.contains("Item1"));
        assertFalse(stringList.contains("Item3"));
    }

    @Test
    public void testIndexOf() {
        stringList.add("Item1");
        stringList.add("Item2");

        assertEquals(1, stringList.indexOf("Item2"));
    }

    @Test
    public void testLastIndexOf() {
        stringList.add("Item1");
        stringList.add("Item2");
        stringList.add("Item1");

        assertEquals(2, stringList.lastIndexOf("Item1"));
    }

    @Test
    public void testGet() {
        stringList.add("Item1");
        stringList.add("Item2");

        assertEquals("Item2", stringList.get(1));
    }

    @Test
    public void testSize() {
        stringList.add("Item1");
        stringList.add("Item2");

        assertEquals(2, stringList.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stringList.isEmpty());

        stringList.add("Item1");

        assertFalse(stringList.isEmpty());
    }

    @Test
    public void testClear() {
        stringList.add("Item1");
        stringList.add("Item2");

        stringList.clear();

        assertTrue(stringList.isEmpty());
    }

    @Test
    public void testToArray() {
        stringList.add("Item1");
        stringList.add("Item2");

        String[] array = stringList.toArray();

        assertArrayEquals(new String[]{"Item1", "Item2"}, array);
    }
}