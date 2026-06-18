class Solution {
    public double angleClock(int hour, int minutes) {
        hour %= 12;

        double minuteAngle = minutes * 6.0;

        double hourAngle = hour * 30.0 + minutes * 0.5;

        double diff = Math.abs(hourAngle - minuteAngle);

        return Math.min(diff, 360.0 - diff);
    }
}
/*
Approach
First, calculate the angle of the minute hand.

A full circle is 360°.
The minute hand completes one full circle in 60 minutes.
So each minute represents 6°.
minuteAngle = minutes × 6
Next, calculate the angle of the hour hand.

A full circle is 360°.
There are 12 hours.
So each hour represents 30°.
The hour hand also moves 0.5° every minute.
hourAngle = hour × 30 + minutes × 0.5
Since 12 and 0 represent the same position on a clock:

hour = hour % 12
Now find the absolute difference:

diff = |hourAngle - minuteAngle|
There are always two angles between the hands.

One is diff
The other is 360 - diff
Return the smaller one:

answer = min(diff, 360 - diff)
*/