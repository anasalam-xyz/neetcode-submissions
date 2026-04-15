class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean a = false, b = false, c = false;
        for(int[] triplet: triplets) {
            if( triplet[0] <= target[0] &&
                triplet[1] <= target[1] &&
                triplet[2] <= target[2] 
            ) {
                if(triplet[0] == target[0]) a = true;        
                if(triplet[1] == target[1]) b = true;        
                if(triplet[2] == target[2]) c = true;        
            }
        }
        return a && b && c;
    }
}
