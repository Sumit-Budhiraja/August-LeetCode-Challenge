class Solution {
    public int rectangleArea(int[][] rectangles) {
        // Set up a list of known good (non-intersecting) rectangles
        LinkedList<int[]> goodRects = new LinkedList<int[]>();
        
        // Queue the given rectangles
        Deque<int[]> rects = new LinkedList<int[]>();
        for (int i = 0; i < rectangles.length; i++) rects.offerLast(rectangles[i]);

        // If there is an intersection, split it into pieces that do not intersect,
        // and re-queue the pieces.
        // If not, add to the known good list, and add the area to our answer.
        long answer = 0;
        while (!rects.isEmpty()) {
            // Pull a rectangle from the queue
            int[] rect = rects.pollFirst();
            
            // Check for intersection with known good rectangles.
            boolean intersect = false;
            for (int[] good: goodRects) {
                if (((rect[0] <= good[0] && good[0] < rect[2]) || (good[0] <= rect[0] && rect[0] < good[2]))
                &&  ((rect[1] <= good[1] && good[1] < rect[3]) || (good[1] <= rect[1] && rect[1] < good[3]))) {
                    intersect = true;
                    // Divide the non-intersecting areas of rect into rectangular pieces, and re-queue.
                    // Note, we could add some zero width or height rects this way.
                    // Those will not cause intersections, and they will not be added to the good list.
                    if (rect[0] < good[0]) // left
                        rects.offerLast(new int[] { rect[0], Math.max(rect[1], good[1]), 
                                                    good[0], Math.min(rect[3], good[3]) });
                    if (good[2] < rect[2]) // right
                        rects.offerLast(new int[] { good[2], Math.max(rect[1], good[1]),
                                                    rect[2], Math.min(rect[3], good[3]) });
                    if (rect[1] < good[1]) // top
                        rects.offerLast(new int[] { rect[0], rect[1], rect[2], good[1] });
                    if (good[3] < rect[3]) // bottom
                        rects.offerLast(new int[] { rect[0], good[3], rect[2], rect[3] });
                    break;
                }
            }
            
            if (!intersect) {
                // No intersection.  If this rectangle has positive area, add to the answer
                // and add rect to the known good list.
                if (rect[2] > rect[0] && rect[3] > rect[1]) {
                    answer += (long) (rect[3] - rect[1]) * (long) (rect[2] - rect[0]);
                    goodRects.add(rect);
                }
            }
        }
        return (int) (answer % 1000000007L);
    }
}