package ex1;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @org.junit.jupiter.api.Test
    void size() {
        HashTable ht = new HashTable();
        assertEquals("", ht.toString());
        assertEquals(0, ht.size());

        ht.put("1", "Pedro");
        assertEquals("\n" +
                " bucket[0] = [1, Pedro]", ht.toString());
        assertEquals(1, ht.size());

        ht.drop("1");
        assertEquals("", ht.toString());
        assertEquals(0, ht.size());

        ht.drop ("23");
        assertEquals("", ht.toString());
        assertEquals("0", ht.size());

    }

    @org.junit.jupiter.api.Test
    void realSize() {
        HashTable ht = new HashTable();
        assertEquals(16, ht.realSize());

        ht.put("1", "Pedro");
        assertEquals(16, ht.realSize());

        ht.drop("1");
        assertEquals(16, ht.realSize());
    }

    @org.junit.jupiter.api.Test
    void put() {
        0
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void drop() {
    }
}