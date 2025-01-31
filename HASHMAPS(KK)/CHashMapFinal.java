//Implementation using Linked List --> good
import java.util.*;

public class CHashMapFinal<K, V> {
    ArrayList<LinkedList<Entity>> list;

    private class Entity {
        String key;
        String value;

        public Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size = 0;
    private float lf = 0.5f;

    public CHashMapFinal() {
        list = new ArrayList<>();
        for(int i=0; i<10; i++) {
            list.add(new LinkedList<>());
        }
    }

}
