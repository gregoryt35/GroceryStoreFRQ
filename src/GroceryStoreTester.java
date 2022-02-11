import java.util.ArrayList;
import java.util.Arrays;

public class GroceryStoreTester
{
    public static int passedTests = 0;
    public static int failedTests = 0;
    public static Product[] initialList;

    public static void main(String[] args)
    {
        // setup test Product array
        setupProductArray();
        GroceryStore store = new GroceryStore(initialList);

        System.out.println("--------- TEST getReorderList (part a) ---------");
        ArrayList<Integer> toReorder = store.getReorderList(5);
        testReorder(toReorder, new int[]{0, 2, 3, 4, 6, 7}, 1);
        ArrayList<Integer> toReorder2 = store.getReorderList(2);
        testReorder(toReorder2, new int[]{2, 4, 6}, 2);

        System.out.println("--------- TEST checkAvailability (part b) ---------");
        ArrayList<String> shoppingList1 = new ArrayList<String>(Arrays.asList("cereal", "bread", "apples", "spaghetti"));
        boolean allItemsAvailable = store.checkAvailability(shoppingList1);
        testAvailable(allItemsAvailable, true, 3);
        ArrayList<String> shoppingList2 = new ArrayList<String>(Arrays.asList("cereal", "milk", "muffins", "apples"));
        boolean allItemsAvailable2 = store.checkAvailability(shoppingList2);
        testAvailable(allItemsAvailable2, false, 4);
        ArrayList<String> shoppingList3 = new ArrayList<String>(Arrays.asList("ice cream", "frozen pizza", "muffins", "bread"));
        boolean allItemsAvailable3 = store.checkAvailability(shoppingList3);
        testAvailable(allItemsAvailable3, false, 5);
        System.out.println("--------------------------------------------------");
        System.out.println("TOTAL PASSED TESTS: " + passedTests + " out of 5");
        System.out.println("TOTAL FAILED TESTS: " + failedTests + " out of 5");
    
  // UNCOMMENT THIS PART AFTER YOU FINISH PARTS C & D
    System.out.println("--------- TEST oversized (part d) ---------");
    ArrayList<Product> oversized = store.oversized(2.0);
    int size = oversized.size();
    if (size != 3)
    {
      System.out.println("** FAIL! ** There should be 3 Product objects in the ArrayList returned; your method returns " + size);
    }
    else
    {
      System.out.println("PASS! The returned ArrayList has 3 elements in it, as expected");
    }
    if (oversized.indexOf(initialList[1]) == -1 || oversized.indexOf(initialList[4]) == -1 || oversized.indexOf(initialList[7]) == -1)
    {
      System.out.println("** FAIL! ** The returned ArrayList should contain the Products representing milk, ice cream, and apples");
    }
    else
    {
      System.out.println("PASS! The returned ArrayList has 3 Products in it, representing milk, ice cream, and apples, as expected");
    }

    }

    public static void setupProductArray()
    {
        Product p0 = new Product("cereal", 5, 1.75);
        Product p1 = new Product("milk", 10, 2.3);
        Product p2 = new Product("bread", 1, 0.75);
        Product p3 = new Product("frozen pizza", 4, 1.3);
        Product p4 = new Product("ice cream", 0, 2.1);
        Product p5 = new Product("spaghetti", 6, 0.3);
        Product p6 = new Product("muffins", 0, 0.25);
        Product p7 = new Product("apples", 3, 3.75);

        initialList = new Product[]{p0, p1, p2, p3, p4, p5, p6, p7};
    }

    public static void testReorder(ArrayList<Integer> actual, int[] expected, int testNo)
    {
        ArrayList<Integer> expectedList = new ArrayList<Integer>();
        for (int num : expected)
        {
            expectedList.add(num);
        }

        System.out.print("TEST #" + testNo + " -- ");
        if (actual.equals(expectedList))
        {
            System.out.println("PASS");
            passedTests++;
        }
        else
        {
            System.out.println("*****FAIL*****");
            failedTests++;
        }
        System.out.println(" Expected: " + expectedList);
        System.out.println("   Actual: " + actual);
    }

    public static void testAvailable(boolean actual, boolean expected, int testNo)
    {
        System.out.print("TEST #" + testNo + " -- ");
        if (actual == expected)
        {
            System.out.println("PASS");
            passedTests++;
        }
        else
        {
            System.out.println("*****FAIL*****");
            failedTests++;
        }
        System.out.println(" Expected: " + expected);
        System.out.println("   Actual: " + actual);
    }
}