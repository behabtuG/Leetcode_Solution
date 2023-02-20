package leetcode.com.Medium.InsertDeleteGetRandomO;

import java.util.*;

class RandomizedSet {

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified
     * element.
     */
    /**
     * public boolean insert(int val) {
     * if (valToIndex.containsKey(val))
     * return false;
     * <p>
     * valToIndex.put(val, vals.size());
     * vals.add(val);
     * return true;
     * }
     * <p>
     * //
     * // *Removes a value from the set. Returns true if the set contained the specified element.
     * //
     * public boolean remove(int val) {
     * if (!valToIndex.containsKey(val))
     * return false;
     * <p>
     * final int index = valToIndex.get(val);
     * // Following two lines order are important when vals.size() == 1
     * valToIndex.put(last(vals), index);
     * valToIndex.remove(val);
     * vals.set(index, last(vals));
     * vals.remove(vals.size() - 1);
     * return true;
     * }
     * <p>
     * //
     * //  Get a random element from the set.
     * //
     * public int getRandom() {
     * final int index = rand.nextInt(vals.size());
     * return vals.get(index);
     * }
     * <p>
     * private Map<Integer, Integer> valToIndex = new HashMap<>(); // {val: index in vals}
     * private List<Integer> vals = new ArrayList<>();
     * private Random rand = new Random();
     * <p>
     * private int last(List<Integer> vals) {
     * return vals.get(vals.size() - 1);
     * }
     * <p>
     * public static void main() {
     * String[] Input = {"RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"};
     * //[[], [1], [2], [2], [], [1], [2], []]
     * //Output [null, true, false, true, 2, true, false, 2]
     * System.out.println();
     * }
     * /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    HashMap<Integer, Integer> valueMap;
    HashMap<Integer, Integer> idxMap;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        valueMap = new HashMap<>();
        idxMap = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valueMap.containsKey(val)) {
            return false;
        }
        valueMap.put(val, valueMap.size());
        idxMap.put(idxMap.size(), val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (valueMap.containsKey(val)) {
            int idx = valueMap.get(val);
            valueMap.remove(val);
            idxMap.remove(idx);
            Integer tailElem = idxMap.get(idxMap.size());
            if (tailElem != null) {
                idxMap.put(idx, tailElem);
                valueMap.put(tailElem, idx);
            }
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (valueMap.size() == 0) {
            return -1;
        }
        if (valueMap.size() == 1) {
            return idxMap.get(0);
        }
        Random r = new Random();
        int idx = r.nextInt(valueMap.size());
        return idxMap.get(idx);
    }
}
