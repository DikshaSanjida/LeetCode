class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp=new HashMap();
        List<List<String>> res= new ArrayList<>();
        for(String ele : strs){
            char[] freq=new char[26];
            for(char val : ele.toCharArray()){
                freq[val - 'a']++;
            }
            String value = new String(freq);

            if(!mp.containsKey(value)){
                mp.put(value, new ArrayList<>());
            }
            mp.get(value).add(ele);
        }

        res.addAll(mp.values());

        return res;


        
    }
}