package ex4;

import ex1.HashTable;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        // 1. Añadimos un valor para comprobar que no aumenta el tamaño real.
        ht.put("1", "Pedro");
        assertEquals(16, ht.realSize());
        // 1. Borramos un valor para comprobar que no disminuye el tamaño real.
        ht.drop("1");
        assertEquals(16, ht.realSize());
        // 1. Hacemos colisionar un valor para comprobar que no aumenta el tamaño real.
        ht.put("1","oscar");
        ht.put("1","oscar2");
        assertEquals(16,ht.realSize());
        // 1. cogemos un valor para comprobar que no aumenta el tamaño real.
        ht.get("1");
        assertEquals("16",ht.realSize());
    }

    @org.junit.jupiter.api.Test
    void put() {
        HashTable ht = new HashTable();
        // Probamos a  introducir un valor para ver si se guarda en la hashtable
        ht.put("1", "Pedro");
        assertEquals(1, ht.size());
        //Probamos de forzar una colision para ver si la linkedlist funciona correctamente
        ht.put("25","Hola");
        ht.put("25","Adios");
        assertEquals("Adios",ht.get("25"));
        //insertamos un valor en mitad de la tabla
        ht.put("6","Prueba");
        assertEquals("Prueba", ht.get("6"));
    }


    @org.junit.jupiter.api.Test
    void get() {
        HashTable ht = new HashTable();
        // Pedimos un elemento que no exista en la LinkedList
        assertNull(ht.get("58"));

        // Pedimos un elemento existente
        ht.put("5","Edgar");
        assertEquals("Edgar", ht.get("5"));

        // Probamos de sacar un valor que no existe
        assertEquals("",ht.get("0"));

        // probamos de sacar un valor  que sabemos que colisiona
        ht.put("1","Oscar3");
        assertEquals("Oscar3", ht.get("1"));
    }

    @org.junit.jupiter.api.Test
    void drop() {
        HashTable ht = new HashTable();

        // Borramos un valor que no existe
        ht.put("1","Hola");
        ht.put("2","Adios");
        ht.drop("3");
        assertEquals(2, ht.size());


        // Borramos un elemento la tabla
        ht.drop("2");
        assertEquals(1, ht.size());


        //Borramos un valor colisionado
        ht.put("34","DomiArmer");
        ht.put("1","Que");
        ht.put("1","Tal");

        ht.drop("1");
        assertNull(ht.get("1"));

        //Borramos el primer valor que existe en una linked list
        ht.put("4","Comer");

        ht.drop("4");

    }
}