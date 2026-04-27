import java.util.*;

public class SocialNetwork {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void addFriendship(String u, String v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public List<String> getFriends(String user) {
        return adjList.getOrDefault(user, new ArrayList<>());
    }

    public boolean directlyConnected(String u, String v) {
        return adjList.containsKey(u) && adjList.get(u).contains(v);
    }

    public int getDegreeOfSeparation(String start, String target) {
        if (!adjList.containsKey(start) || !adjList.containsKey(target)) return -1;
        if (start.equals(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distances = new HashMap<>();

        queue.add(start);
        distances.put(start, 0);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            int currentDist = distances.get(curr);

            for (String neighbor : adjList.getOrDefault(curr, new ArrayList<>())) {
                if (!distances.containsKey(neighbor)) {
                    if (neighbor.equals(target)) return currentDist + 1;
                    distances.put(neighbor, currentDist + 1);
                    queue.add(neighbor);
                }
            }
        }
        return -1; // Unreachable
    }

    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork();
        sn.addFriendship("Alice", "Bob");
        sn.addFriendship("Alice", "Charlie");
        sn.addFriendship("Bob", "David");
        sn.addFriendship("Charlie", "Eve");
        sn.addFriendship("David", "Eve");

        System.out.println("Alice's friends: " + sn.getFriends("Alice"));
        System.out.println("Are Bob and Eve directly connected? " + sn.directlyConnected("Bob", "Eve"));
        System.out.println("Degree of separation (Alice to Eve): " + sn.getDegreeOfSeparation("Alice", "Eve"));
    }
}
