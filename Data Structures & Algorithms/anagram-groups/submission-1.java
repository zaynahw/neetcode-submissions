class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] x = s.toCharArray();
            Arrays.sort(x);

            String key = new String(x);
            res.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList(res.values());
    }
}
