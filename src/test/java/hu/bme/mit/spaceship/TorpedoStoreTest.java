package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

  @Test
  void fire_Success(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);

    // Act
    boolean result = store.fire(1);

    // Assert
    assertEquals(true, result);
  }

    @Test
    void fire_Fail(){
    TorpedoStore store = new TorpedoStore(1,1);
    boolean result = store.fire(1);
    assertEquals(false, result);
    }

    @Test
    void isEmpty_Success(){
    TorpedoStore store = new TorpedoStore(1);

    store.fire(1);

    assertEquals(true, store.isEmpty());

    }

    @Test
    void torpCount(){
    TorpedoStore store = new TorpedoStore(5);
    store.fire(3);
    store.fire(1);
    assertEquals(1, store.getTorpedoCount());
    }

    @Test
  void fire_Fail_Exception(){
    TorpedoStore store = new TorpedoStore(5);

    Exception e = assertThrowsExactly(IllegalArgumentException.class,()-> store.fire(6));

    assertEquals("numberOfTorpedos", e.getMessage());
  }

   @Test
    void notFail(){
    TorpedoStore store = new TorpedoStore(5);

    boolean suc = store.fire(5);

    assertEquals(true, suc);
  }

}
