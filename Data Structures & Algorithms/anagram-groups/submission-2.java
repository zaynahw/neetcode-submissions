class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> track = new HashMap<>();
        for (String s : strs) {
            HashMap<Character, Integer> freq = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                int count = freq.getOrDefault(s.charAt(i), 0);
                freq.put(s.charAt(i), count + 1);
            }
           List<String> g = track.getOrDefault(freq, new ArrayList<String>());
           g.add(s);
           track.put(freq, g);
        }

        return new ArrayList<>(track.values());
    }
}
