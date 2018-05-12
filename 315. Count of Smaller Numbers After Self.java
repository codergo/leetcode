Method 1. 
    // Binary Search
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        List<Integer> tmp = new ArrayList<Integer>();
        
        for (int i = nums.length - 1; i>= 0; i--) {
            int pos = insertPos(tmp, nums[i]);
            tmp.add(pos, nums[i]);
            ret.add(0, pos);
        }
        return ret;
    }
    
    private int insertPos(List<Integer> tmp, int num) {
        if (tmp.size() == 0) return 0;

        int s= 0, e = tmp.size() - 1;
        
        while (s + 1 < e) {
            int mid = s + (e - s)/2;
            if (num > tmp.get(mid)) {
                s = mid;
            } else {
                e = mid;
            }
        }
        
        if (tmp.get(s) >= num) {
            return s;
        } else if (tmp.get(e) >= num) {
            return e;
        } else {
            return e+1;
        }
    }
