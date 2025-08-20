//Using Brute Force Approach Taking an array of 10^6 size

class MyHashMap {
    int [] ans ;

    public MyHashMap() {
        ans = new int[1000001];
        Arrays.fill(ans,-1);
    }
    
    public void put(int key, int value) {
     ans[key] = value;
        
    }
    
    public int get(int key) {
       return ans[key];
    }
    
    public void remove(int key) {
        ans[key] = -1;
    }
}


//Approach2. Using Separate Chaining
class MyHashMap {
    int size = 10000;
    List<Pair>[] buck;

    static class Pair {
        int key;
        int val;

        Pair(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    public MyHashMap() {
        buck = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            buck[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int bucketno = key % size;

        List<Pair> chain = buck[bucketno];

        for (Pair p : chain) {
            if (p.key == key) {
                p.val = value;
                return;
            }
        }
        chain.add(new Pair(key, value));

    }

    public int get(int key) {
        int bucketno = key % size;

        List<Pair> chain = buck[bucketno];

        for (Pair p : chain) {
            if (p.key == key) {
                return p.val;
            }
        }
        return -1;

    }

    public void remove(int key) {
        int bucketno = key % size;

        List<Pair> chain = buck[bucketno];

        for (Pair p : chain) {
            if (p.key == key) {
                chain.remove(p);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
