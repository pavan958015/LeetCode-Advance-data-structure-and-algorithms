// not Done by me for time limit I will be solved after some time 
import java.util.*;

class Solution {

    static class Event {
        double y;
        int type; // +1 = add, -1 = remove
        double x1, x2;
        Event(double y, int type, double x1, double x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            double x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, +1, x, x + l));
            events.add(new Event(y + l, -1, x, x + l));
        }

        events.sort(Comparator.comparingDouble(e -> e.y));

        TreeMap<Double, Integer> active = new TreeMap<>();
        double totalArea = 0;
        double prevY = events.get(0).y;

        // First pass → compute total UNION area
        for (Event e : events) {
            double curY = e.y;
            double height = curY - prevY;
            if (height > 0) {
                totalArea += unionWidth(active) * height;
            }
            update(active, e);
            prevY = curY;
        }

        double half = totalArea / 2.0;

        // Second pass → find minimum Y
        active.clear();
        prevY = events.get(0).y;
        double area = 0;

        for (Event e : events) {
            double curY = e.y;
            double height = curY - prevY;
            if (height > 0) {
                double width = unionWidth(active);
                double add = width * height;
                if (area + add >= half) {
                    return prevY + (half - area) / width;
                }
                area += add;
            }
            update(active, e);
            prevY = curY;
        }

        return prevY;
    }

    private void update(TreeMap<Double, Integer> map, Event e) {
        map.put(e.x1, map.getOrDefault(e.x1, 0) + e.type);
        map.put(e.x2, map.getOrDefault(e.x2, 0) - e.type);
        if (map.get(e.x1) == 0) map.remove(e.x1);
        if (map.get(e.x2) == 0) map.remove(e.x2);
    }

    private double unionWidth(TreeMap<Double, Integer> map) {
        double width = 0;
        int count = 0;
        Double prev = null;

        for (var entry : map.entrySet()) {
            if (count > 0) {
                width += entry.getKey() - prev;
            }
            count += entry.getValue();
            prev = entry.getKey();
        }
        return width;
    }
}
