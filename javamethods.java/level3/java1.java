class java1 {
    public static int[] generateHeights() {
        int[] heights = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = (int)(Math.random() * 101) + 150; // 150–250 cm
        }
        return heights;
    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;
        return sum;
    }

    public static double meanHeight(int[] arr) {
        return (double)sumArray(arr) / arr.length;
    }

    public static int minHeight(int[] arr) {
        int min = arr[0];
        for (int val : arr) if (val < min) min = val;
        return min;
    }

    public static int maxHeight(int[] arr) {
        int max = arr[0];
        for (int val : arr) if (val > max) max = val;
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights();
        System.out.print("Heights: ");
        for (int h : heights) System.out.print(h + " ");
        System.out.println("\nMean = " + meanHeight(heights));
        System.out.println("Shortest = " + minHeight(heights));
        System.out.println("Tallest = " + maxHeight(heights));
    }
}
