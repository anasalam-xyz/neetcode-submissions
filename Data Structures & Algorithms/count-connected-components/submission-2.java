class Solution {
    private int[] parent, rank;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int count = 0; 
        for(int[] edge: edges) {
            count += union(edge[0], edge[1]);
        }

        return n - count;
    }

    private int union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if(parentX == parentY) return 0;

        if(rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        }
        else if(rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        }
        else {
            parent[parentY] = parentX;
            rank[parentX]++;
        }

        return 1;
    }

    private int find(int x) {
        if(parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
} 
