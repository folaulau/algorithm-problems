package com.folatech.greedyprogramming.classphotos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassPhotosMain {

    /**
     * Greedy Algorithm
     */

    /**
     * Difficulty level: easy
     */
    
    /**
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {

        List<Integer> redShirtHeights = Arrays.asList(5, 8, 1, 3, 4);
        List<Integer> blueShirtHeights = Arrays.asList(6, 9, 2, 4, 5);

        canTakeClassPhotos(redShirtHeights, blueShirtHeights);// true

        redShirtHeights = Arrays.asList(6, 9, 2, 4, 5);
        blueShirtHeights = Arrays.asList(5, 8, 1, 3, 4);

        canTakeClassPhotos(redShirtHeights, blueShirtHeights);// true

        redShirtHeights = Arrays.asList(6, 9, 2, 4, 5, 1);
        blueShirtHeights = Arrays.asList(5, 8, 1, 3, 4, 9);

        canTakeClassPhotos(redShirtHeights, blueShirtHeights);// false

        redShirtHeights = Arrays.asList(6);
        blueShirtHeights = Arrays.asList(6);

        canTakeClassPhotos(redShirtHeights, blueShirtHeights);// false

    }

    static boolean canTakeClassPhotos(List<Integer> redShirtHeights, List<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeights, Collections.reverseOrder());

        System.out.println("redShirtHeights: " + redShirtHeights);
        System.out.println("blueShirtHeights: " + blueShirtHeights);

        boolean canTakePhoto = true;

        String frontRowColor = (redShirtHeights.get(0) < blueShirtHeights.get(0)) ? "RED" : "BLUE";

        System.out.println("frontRowColor: " + frontRowColor);

        for (int i = 0; i < redShirtHeights.size(); i++) {
            int redShirtHeight = redShirtHeights.get(i);// front row
            int blueShirtHeight = blueShirtHeights.get(i);// back row

            if (frontRowColor.equals("RED")) {

                if (redShirtHeight >= blueShirtHeight) {
                    canTakePhoto = false;
                    break;
                }

            } else if (frontRowColor.equals("BLUE")) {
                if (redShirtHeight <= blueShirtHeight) {
                    canTakePhoto = false;
                    break;
                }
            }
        }

        System.out.println("canTakePhoto: " + canTakePhoto + "\n\n");

        return canTakePhoto;
    }
}
