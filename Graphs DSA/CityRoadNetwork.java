import java.util.*;

public class CityRoadNetwork {
    private Map<String, List<Edge>> adjList = new HashMap<>();

    static class Edge {
        String target;
        int distance;
        Edge(String t, int d) { this.target = t; this.distance = d; }
    }

    public void addRoad(String source, String target, int dist, boolean isTwoWay) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.get(source).add(new Edge(target, dist));
        
        if (isTwoWay) {
            adjList.putIfAbsent(target, new ArrayList<>());
            adjList.get(target).add(new Edge(source, dist));
        }
    }

    // BFS to find shortest path (by turns/hops, not distance)
    public int findFewestTurns(String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> turns = new HashMap<>();

        queue.add(start);
        turns.put(start, 0);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            int currentTurns = turns.get(curr);

            if (!adjList.containsKey(curr)) continue;

            for (Edge e : adjList.get(curr)) {
                if (!turns.containsKey(e.target)) {
                    if (e.target.equals(end)) return currentTurns + 1;
                    turns.put(e.target, currentTurns + 1);
                    queue.add(e.target);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: City Road Network ===");
        
        CityRoadNetwork city = new CityRoadNetwork();
        city.addRoad("A", "B", 5, false);
        city.addRoad("B", "C", 3, true);
        city.addRoad("A", "D", 7, true);
        city.addRoad("D", "E", 2, false);
        city.addRoad("C", "E", 4, false);

        System.out.println("Representation: Directed & Weighted Adjacency List chosen because roads have distances and one-way constraints.");
        System.out.println("BFS ensures level traversal, finding the fewest number of sequential roads (turns) from A to E.");
        System.out.println("Fewest turns from A to E: " + city.findFewestTurns("A", "E")); 
        
        System.out.println("Why DFS fails: DFS violently pursues branch depth. It could latch onto a 100-road recursive trap path ignoring nearby shorter nodes.");
    }
}
