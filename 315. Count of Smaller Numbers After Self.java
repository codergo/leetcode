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


Method 2:
    //merge sort
    public List<Integer> countSmaller(int[] nums) {
        int[][] pairs = new int[nums.length][0];
        
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new int[]{nums[i], i};
        }
        int[] count = new int[nums.length];
        mergeSort(count, pairs, 0, nums.length - 1);
        
        List<Integer> ret = new ArrayList<Integer>();
        for (int num : count) {
            ret.add(num);
        }
        return ret;
    }
    
    private void mergeSort(int[] count, int[][] pairs, int s, int e) {
        if (s < e) {
            int mid = s + (e - s)/2;
            mergeSort(count, pairs, s, mid);
            mergeSort(count, pairs, mid + 1, e);
            merge(count, pairs, s, mid + 1, e);
        }
    }
    
    private void merge(int[] count, int[][] pairs, int l, int r, int re) {
        int le = r - 1;
        int[][] left = new int[le - l + 1][2];
        int[][] right = new int[re - r + 1][2];
        int k = l;
        for (int i = 0; i < left.length; i++) {
            left[i] = new int[]{pairs[l][0], pairs[l++][1]};
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = new int[]{pairs[r][0], pairs[r++][1]};
        }
        int i = 0,  j = 0;
        while (i < left.length && j < right.length) {
            if (left[i][0] <= right[j][0]) {
                count[left[i][1]] += j;
                pairs[k++] = new int[]{left[i][0],left[i++][1]};
            } else {
                pairs[k++] = new int[]{right[j][0],right[j++][1]};
            }
        }
        
         while (i < left.length) {
                count[left[i][1]] += j;
                pairs[k++] = new int[]{left[i][0],left[i++][1]};
        }
             
        while (j < right.length) {
            pairs[k++] = new int[]{right[j][0],right[j++][1]};
        }
    }
