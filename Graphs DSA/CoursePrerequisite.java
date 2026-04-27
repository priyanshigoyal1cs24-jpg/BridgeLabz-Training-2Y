import java.util.*;

public class CoursePrerequisite {
    
    // Returns a valid topological order or an empty list if a cycle exists
    public static List<String> getValidOrder(List<String> courses, String[][] prerequisites) {
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        
        for (String c : courses) {
            adjList.put(c, new ArrayList<>());
            inDegree.put(c, 0);
        }
        
        // Build graph
        for (String[] pre : prerequisites) {
            String u = pre[0];
            String v = pre[1];
            adjList.get(u).add(v);
            inDegree.put(v, inDegree.get(v) + 1);
        }
        
        Queue<String> queue = new LinkedList<>();
        for (String c : courses) {
            if (inDegree.get(c) == 0) {
                queue.add(c);
            }
        }
        
        List<String> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            order.add(curr);
            
            for (String neighbor : adjList.get(curr)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        if (order.size() == courses.size()) {
            return order;
        } else {
            return new ArrayList<>(); // Cycle detected
        }
    }

    public static void main(String[] args) {
        List<String> courses = Arrays.asList("CS101", "CS102", "CS201", "CS202", "MATH101");
        String[][] prereqs = {
            {"CS101", "CS102"},
            {"CS101", "CS201"},
            {"CS102", "CS202"},
            {"MATH101", "CS201"}
        };
        
        List<String> order = getValidOrder(courses, prereqs);
        if (order.isEmpty()) {
            System.out.println("Circular dependency detected!");
        } else {
            System.out.println("Valid course sequence: " + order);
        }
    }
}
