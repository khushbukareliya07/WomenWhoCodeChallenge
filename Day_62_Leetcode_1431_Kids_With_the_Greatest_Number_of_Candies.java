//Brute-Force approach with 
//TC: O(n) - 2 pass
//SC: O(n) - Map
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        int[] temp = candies.clone();
        Arrays.sort(temp);

        int maxCandies = temp[candies.length - 1] + extraCandies;
        int max = temp[candies.length - 1];

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max)
                result.add(true);
            else
                result.add(false);
        }

        return result;
    }
}

// Optimized approach on space

// TC: O(n) - 2 pass
// sc:O(1)

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        int maxCandies = 0;
        // we find the kid with the max candies
        for (int candy : candies) {
            maxCandies = Math.max(candy, maxCandies);
        }
        // we go through array again and add extracandies and see if it goes equal or
        // above the kid holding the max candies without adding extra!.
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }
}