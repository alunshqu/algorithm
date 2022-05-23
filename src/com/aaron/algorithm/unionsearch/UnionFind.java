package com.aaron.algorithm.unionsearch;

public class UnionFind {
    int[] parent;
    int[] rank;
    int cnt;

    public UnionFind(int n) {
        this.cnt = n;
    }

    int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    int findV2(int p) {
        if(p != parent[p]) {
            parent[p] = findV2(parent[p]);
        }
        return parent[p];
    }

    void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) {
            return;
        }
        if(rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else if(rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else {
            parent[rootQ] = rootP;
            rank[rootP] ++;
        }
        cnt --;

    }

}
