class Solution {
    class Pair{
        int node;
        long cost;
        Pair(int n, long c){
            node = n;
            cost = c;
        }
    }

    public int[] minCost(int n, int[] prices, int[][] roads) {
        List<Pair>[] emptyGraph = new ArrayList[n];
        List<Pair>[] carryGraph = new ArrayList[n];

        for(int i=0;i<n;i++){
            emptyGraph[i] = new ArrayList<>();
            carryGraph[i] = new ArrayList<>();
        }

        for(int[] r:roads){
            int u = r[0];
            int v = r[1];
            int cost = r[2];
            int tax = r[3];

            emptyGraph[u].add(new Pair(v, cost));
            emptyGraph[v].add(new Pair(u, cost));

            long carry = 1L*cost*tax;
            carryGraph[u].add(new Pair(v, carry));
            carryGraph[v].add(new Pair(u, carry));
        }

        int[] ans = new int[n];

        for(int src=0;src<n;src++){
            long[] distEmpty = dijkstra(src, emptyGraph, n);
            long[] distCarry = dijkstra(src, carryGraph, n);

            long best = prices[src];

            for(int j=0;j<n;j++){
                best = Math.min(best, distEmpty[j] + prices[j] + distCarry[j]);
            }
            ans[src] = (int)best;
        }
        return ans;
    }


    private long[] dijkstra(int src, List<Pair>[] graph, int n) {

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));

        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (cur.cost > dist[cur.node])
                continue;

            for (Pair nei : graph[cur.node]) {
                long nd = cur.cost + nei.cost;

                if (nd < dist[nei.node]) {
                    dist[nei.node] = nd;
                    pq.offer(new Pair(nei.node, nd));
                }
            }
        }

        return dist;
    }
}
