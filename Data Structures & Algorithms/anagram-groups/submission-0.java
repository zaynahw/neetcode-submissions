class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> sort = new HashMap<>();
        for (String str: strs) {
            HashMap<Character, Integer> charm = new HashMap<>();
            for (int i=0; i<str.length(); i++) {
                charm.put(str.charAt(i), charm.getOrDefault(str.charAt(i),0)+1);
            }

            ArrayList<String> list = sort.getOrDefault(charm, new ArrayList<>());

            list.add(str);

            sort.put(charm, list);
        }

        List<List<String>> result = new ArrayList<>();

        for (HashMap<Character, Integer> x: sort.keySet()) {
            ArrayList<String> words = sort.get(x);
            result.add(words);
        }
        
        return result;

    }
}
