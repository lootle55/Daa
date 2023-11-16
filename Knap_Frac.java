package DAA_Lab;
import java.util.Arrays;
import java.util.Comparator;
public class Knap_Frac{

    static class Item {
        int weight;
        int value;
        double ratio; // Value-to-weight ratio

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }
    }

    // Function to solve the fractional knapsack problem
    static double fractionalKnapsack(int capacity, Item[] items) {
        // Sort items based on value-to-weight ratio in descending order
        Arrays.sort(items, Comparator.comparingDouble((Item item) -> item.ratio).reversed());

        double maxValue = 0.0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                // Include the whole item in the knapsack
                currentWeight += item.weight;
                maxValue += item.value;
            } else {
                // Include a fraction of the item in the knapsack
                int remainingCapacity = capacity - currentWeight;
                maxValue += (item.ratio * remainingCapacity);
                break;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int capacity = 50;
        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };

        double result = fractionalKnapsack(capacity, items);
        System.out.println("Maximum value in Knapsack = " + result);
    }
}

