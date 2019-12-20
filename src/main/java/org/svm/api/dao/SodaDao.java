package org.svm.api.dao;

import org.springframework.stereotype.Service;
import org.svm.api.model.Soda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SodaDao {
    HashMap<Integer, Soda> sodaInventory;

    public SodaDao() {
        sodaInventory = new HashMap<>();
        sodaInventory.put(1, new Soda(1, "Lemon Soda", 1.50f, 20));
        sodaInventory.put(2, new Soda(2, "Ginger Soda", 2.00f, 20));
        sodaInventory.put(3, new Soda(3, "Soda Water", 1.00f, 20));
        sodaInventory.put(4, new Soda(4, "Root Beer", 1.75f, 20));
        sodaInventory.put(5, new Soda(5, "Cococola", 2.25f, 20));
    }

    public Soda getSodaById(int id) {
        Soda soda = null;
        try {
            soda = sodaInventory.get(id);
        } catch(Exception e) {
            return null;
        }
        return soda;
    }

    public List<Soda> getAllSoda() {
        return new ArrayList<>(sodaInventory.values());
    }
}
