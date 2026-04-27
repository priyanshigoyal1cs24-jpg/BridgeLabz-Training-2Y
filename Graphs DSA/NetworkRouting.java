import java.util.*;

public class NetworkRouting {
    private Map<String, List<String>> network = new HashMap<>();

    public void addConnection(String r1, String r2) {
        network.putIfAbsent(r1, new ArrayList<>());
        network.putIfAbsent(r2, new ArrayList<>());
        network.get(r1).add(r2);
        network.get(r2).add(r1);
    }

    // Check if network is fully connected
    public boolean isConnected(List<String> allRouters) {
        if (allRouters.isEmpty()) return true;
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        String start = allRouters.get(0);
        queue.add(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (String neighbor : network.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        return visited.size() == allRouters.size();
    }

    // Minimum hops BFS
    public int getMinimumHops(String start, String target) {
        if (start.equals(target)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> hops = new HashMap<>();
        
        queue.add(start);
        hops.put(start, 0);
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            int currentHops = hops.get(curr);
            
            for (String neighbor : network.getOrDefault(curr, new ArrayList<>())) {
                if (!hops.containsKey(neighbor)) {
                    if (neighbor.equals(target)) return currentHops + 1;
                    hops.put(neighbor, currentHops + 1);
                    queue.add(neighbor);
                }
            }
        }
        return -1; // Unreachable
    }

    public static void main(String[] args) {
        NetworkRouting routing = new NetworkRouting();
        List<String> routers = Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6");
        
        routing.addConnection("R1", "R2");
        routing.addConnection("R1", "R3");
        routing.addConnection("R2", "R4");
        routing.addConnection("R3", "R4");
        routing.addConnection("R4", "R5");
        routing.addConnection("R5", "R6");
        
        System.out.println("Is network fully connected? " + routing.isConnected(routers));
        System.out.println("Min hops from R1 to R6: " + routing.getMinimumHops("R1", "R6"));
    }
}
