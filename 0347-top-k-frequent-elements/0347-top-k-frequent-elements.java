class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        int c=0;

        Map<Integer,Integer> mp=new HashMap();
        for(int ele:nums){
            mp.put(ele, mp.getOrDefault(ele,0)+1);
        }

        List<Integer>[] buckets=new List[nums.length+1];
        for(int key : mp.keySet()){
            int frequency=mp.get(key);
            if(buckets[frequency]== null){
                buckets[frequency]=new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        for(int i=buckets.length-1;i>=0 && c < k; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    res[c++]=num;
                    if(c==k){
                        break;
                    }
                }
            }
        }
        return res;
    }
}