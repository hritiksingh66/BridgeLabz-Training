public class TemperatureAnalyzer {
    
    public static class DayResult {
        int hottestDay;
        int coldestDay;
        double[] dailyAverages;
        
        public DayResult(int hottestDay, int coldestDay, double[] dailyAverages) {
            this.hottestDay = hottestDay;
            this.coldestDay = coldestDay;
            this.dailyAverages = dailyAverages;
        }
    }
    
    public static DayResult analyzeTemperature(float[][] temperatures) {
        double[] dailyAverages = new double[7];
        int hottestDay = 0, coldestDay = 0;
        double maxAvg = Double.MIN_VALUE, minAvg = Double.MAX_VALUE;
        
        for (int day = 0; day < 7; day++) {
            double sum = 0;
            for (int hour = 0; hour < 24; hour++) {
                sum += temperatures[day][hour];
            }
            dailyAverages[day] = sum / 24;
            
            if (dailyAverages[day] > maxAvg) {
                maxAvg = dailyAverages[day];
                hottestDay = day;
            }
            if (dailyAverages[day] < minAvg) {
                minAvg = dailyAverages[day];
                coldestDay = day;
            }
        }
        
        return new DayResult(hottestDay, coldestDay, dailyAverages);
    }
    
    public static void main(String[] args) {
        float[][] temperatures = {
            {20.5f, 21.0f, 22.5f, 24.0f, 26.5f, 28.0f, 30.5f, 32.0f, 33.5f, 35.0f, 36.5f, 37.0f, 36.0f, 34.5f, 32.0f, 30.0f, 28.5f, 26.0f, 24.5f, 23.0f, 22.0f, 21.5f, 21.0f, 20.5f},
            {18.0f, 19.5f, 21.0f, 23.5f, 25.0f, 27.5f, 29.0f, 31.5f, 33.0f, 34.5f, 35.0f, 35.5f, 34.0f, 32.5f, 30.0f, 28.5f, 26.0f, 24.5f, 22.0f, 20.5f, 19.0f, 18.5f, 18.0f, 17.5f},
            {22.0f, 23.5f, 25.0f, 27.5f, 29.0f, 31.5f, 33.0f, 35.5f, 37.0f, 38.5f, 39.0f, 39.5f, 38.0f, 36.5f, 34.0f, 32.5f, 30.0f, 28.5f, 26.0f, 24.5f, 23.0f, 22.5f, 22.0f, 21.5f},
            {15.0f, 16.5f, 18.0f, 20.5f, 22.0f, 24.5f, 26.0f, 28.5f, 30.0f, 31.5f, 32.0f, 32.5f, 31.0f, 29.5f, 27.0f, 25.5f, 23.0f, 21.5f, 19.0f, 17.5f, 16.0f, 15.5f, 15.0f, 14.5f},
            {25.0f, 26.5f, 28.0f, 30.5f, 32.0f, 34.5f, 36.0f, 38.5f, 40.0f, 41.5f, 42.0f, 42.5f, 41.0f, 39.5f, 37.0f, 35.5f, 33.0f, 31.5f, 29.0f, 27.5f, 26.0f, 25.5f, 25.0f, 24.5f},
            {19.0f, 20.5f, 22.0f, 24.5f, 26.0f, 28.5f, 30.0f, 32.5f, 34.0f, 35.5f, 36.0f, 36.5f, 35.0f, 33.5f, 31.0f, 29.5f, 27.0f, 25.5f, 23.0f, 21.5f, 20.0f, 19.5f, 19.0f, 18.5f},
            {21.0f, 22.5f, 24.0f, 26.5f, 28.0f, 30.5f, 32.0f, 34.5f, 36.0f, 37.5f, 38.0f, 38.5f, 37.0f, 35.5f, 33.0f, 31.5f, 29.0f, 27.5f, 25.0f, 23.5f, 22.0f, 21.5f, 21.0f, 20.5f}
        };
        
        DayResult result = analyzeTemperature(temperatures);
        
        System.out.println("Hottest day: Day " + (result.hottestDay + 1));
        System.out.println("Coldest day: Day " + (result.coldestDay + 1));
        System.out.println("\nDaily averages:");
        for (int i = 0; i < 7; i++) {
            System.out.printf("Day %d: %.2f°C%n", i + 1, result.dailyAverages[i]);
        }
    }
}
