import java.util.*;

// Interface for different meal plan types
interface MealPlan {
    String getPlanType();
    List<String> getAllowedIngredients();
    List<String> getRestrictedIngredients();
    int getCaloriesPerMeal();
}

// Vegetarian meal plan implementation
class VegetarianMeal implements MealPlan {
    @Override
    public String getPlanType() {
        return "Vegetarian";
    }
    
    @Override
    public List<String> getAllowedIngredients() {
        return Arrays.asList("vegetables", "fruits", "dairy", "grains", "legumes", "nuts");
    }
    
    @Override
    public List<String> getRestrictedIngredients() {
        return Arrays.asList("meat", "fish", "poultry");
    }
    
    @Override
    public int getCaloriesPerMeal() {
        return 400;
    }
}

// Vegan meal plan implementation
class VeganMeal implements MealPlan {
    @Override
    public String getPlanType() {
        return "Vegan";
    }
    
    @Override
    public List<String> getAllowedIngredients() {
        return Arrays.asList("vegetables", "fruits", "grains", "legumes", "nuts", "seeds");
    }
    
    @Override
    public List<String> getRestrictedIngredients() {
        return Arrays.asList("meat", "fish", "poultry", "dairy", "eggs", "honey");
    }
    
    @Override
    public int getCaloriesPerMeal() {
        return 350;
    }
}

// Keto meal plan implementation
class KetoMeal implements MealPlan {
    @Override
    public String getPlanType() {
        return "Keto";
    }
    
    @Override
    public List<String> getAllowedIngredients() {
        return Arrays.asList("meat", "fish", "eggs", "dairy", "low-carb vegetables", "healthy fats");
    }
    
    @Override
    public List<String> getRestrictedIngredients() {
        return Arrays.asList("grains", "sugar", "high-carb fruits", "legumes", "starchy vegetables");
    }
    
    @Override
    public int getCaloriesPerMeal() {
        return 500;
    }
}

// High-protein meal plan implementation
class HighProteinMeal implements MealPlan {
    @Override
    public String getPlanType() {
        return "High-Protein";
    }
    
    @Override
    public List<String> getAllowedIngredients() {
        return Arrays.asList("lean meat", "fish", "eggs", "dairy", "legumes", "protein powder", "quinoa");
    }
    
    @Override
    public List<String> getRestrictedIngredients() {
        return Arrays.asList("processed foods", "high-sugar items");
    }
    
    @Override
    public int getCaloriesPerMeal() {
        return 450;
    }
}

// Generic meal class with bounded type parameter
class Meal<T extends MealPlan> {
    private String mealName;
    private T mealPlan;
    private List<String> ingredients;
    private String mealTime; // breakfast, lunch, dinner
    private boolean isValid;
    
    public Meal(String mealName, T mealPlan, List<String> ingredients, String mealTime) {
        this.mealName = mealName;
        this.mealPlan = mealPlan;
        this.ingredients = new ArrayList<>(ingredients);
        this.mealTime = mealTime;
        this.isValid = validateMeal();
    }
    
    // Validate meal based on meal plan restrictions
    private boolean validateMeal() {
        List<String> restrictedIngredients = mealPlan.getRestrictedIngredients();
        for (String ingredient : ingredients) {
            for (String restricted : restrictedIngredients) {
                if (ingredient.toLowerCase().contains(restricted.toLowerCase())) {
                    return false;
                }
            }
        }
        return true;
    }
    
    // Getters
    public String getMealName() { return mealName; }
    public T getMealPlan() { return mealPlan; }
    public List<String> getIngredients() { return new ArrayList<>(ingredients); }
    public String getMealTime() { return mealTime; }
    public boolean isValid() { return isValid; }
    
    @Override
    public String toString() {
        return mealTime.toUpperCase() + ": " + mealName + " (" + mealPlan.getPlanType() + ")\n" +
               "  Ingredients: " + ingredients + "\n" +
               "  Calories: " + mealPlan.getCaloriesPerMeal() + "\n" +
               "  Valid: " + (isValid ? "✓" : "✗");
    }
}

// Generic meal plan generator
class MealPlanGenerator<T extends MealPlan> {
    private T mealPlan;
    private List<Meal<T>> generatedMeals;
    
    public MealPlanGenerator(T mealPlan) {
        this.mealPlan = mealPlan;
        this.generatedMeals = new ArrayList<>();
    }
    
    // Generate meal with validation
    public Meal<T> generateMeal(String mealName, List<String> ingredients, String mealTime) {
        Meal<T> meal = new Meal<>(mealName, mealPlan, ingredients, mealTime);
        generatedMeals.add(meal);
        
        if (meal.isValid()) {
            System.out.println("✓ Generated valid " + mealPlan.getPlanType() + " meal: " + mealName);
        } else {
            System.out.println("✗ Invalid meal generated: " + mealName + " (contains restricted ingredients)");
        }
        
        return meal;
    }
    
    // Get all generated meals
    public List<Meal<T>> getGeneratedMeals() {
        return new ArrayList<>(generatedMeals);
    }
    
    // Get valid meals only
    public List<Meal<T>> getValidMeals() {
        List<Meal<T>> validMeals = new ArrayList<>();
        for (Meal<T> meal : generatedMeals) {
            if (meal.isValid()) {
                validMeals.add(meal);
            }
        }
        return validMeals;
    }
}

// Personalized Meal Plan Generator System
public class PersonalizedMealPlanGenerator {
    
    // Generic method to validate and generate personalized meal plan
    public static <T extends MealPlan> List<Meal<T>> generatePersonalizedPlan(
            MealPlanGenerator<T> generator, Map<String, List<String>> mealData) {
        
        System.out.println("Generating " + generator.mealPlan.getPlanType() + " meal plan...");
        
        for (Map.Entry<String, List<String>> entry : mealData.entrySet()) {
            String[] mealInfo = entry.getKey().split("_");
            String mealTime = mealInfo[0];
            String mealName = mealInfo[1];
            
            generator.generateMeal(mealName, entry.getValue(), mealTime);
        }
        
        return generator.getValidMeals();
    }
    
    // Method to display meal plans using wildcards
    public static void displayMealPlan(List<? extends Meal<? extends MealPlan>> meals, String planName) {
        System.out.println("\n=== " + planName + " ===");
        if (meals.isEmpty()) {
            System.out.println("No valid meals in this plan");
            return;
        }
        
        int totalCalories = 0;
        for (Meal<? extends MealPlan> meal : meals) {
            System.out.println(meal);
            System.out.println();
            if (meal.isValid()) {
                totalCalories += meal.getMealPlan().getCaloriesPerMeal();
            }
        }
        
        System.out.println("Total Daily Calories: " + totalCalories);
        System.out.println("Valid Meals: " + meals.stream().mapToInt(m -> m.isValid() ? 1 : 0).sum() + "/" + meals.size());
    }
    
    // Generic method to calculate nutrition summary
    public static <T extends MealPlan> void displayNutritionSummary(List<Meal<T>> meals) {
        System.out.println("=== Nutrition Summary ===");
        
        if (meals.isEmpty()) {
            System.out.println("No meals to analyze");
            return;
        }
        
        String planType = meals.get(0).getMealPlan().getPlanType();
        int totalCalories = 0;
        int validMeals = 0;
        
        for (Meal<T> meal : meals) {
            if (meal.isValid()) {
                totalCalories += meal.getMealPlan().getCaloriesPerMeal();
                validMeals++;
            }
        }
        
        System.out.println("Plan Type: " + planType);
        System.out.println("Valid Meals: " + validMeals);
        System.out.println("Total Calories: " + totalCalories);
        System.out.println("Average Calories per Meal: " + (validMeals > 0 ? totalCalories / validMeals : 0));
        System.out.println();
    }
    
    // Main method to demonstrate the system
    public static void main(String[] args) {
        System.out.println("=== Personalized Meal Plan Generator ===\n");
        
        // Create meal plan generators for different types
        MealPlanGenerator<VegetarianMeal> vegetarianGenerator = new MealPlanGenerator<>(new VegetarianMeal());
        MealPlanGenerator<VeganMeal> veganGenerator = new MealPlanGenerator<>(new VeganMeal());
        MealPlanGenerator<KetoMeal> ketoGenerator = new MealPlanGenerator<>(new KetoMeal());
        MealPlanGenerator<HighProteinMeal> proteinGenerator = new MealPlanGenerator<>(new HighProteinMeal());
        
        // Sample meal data for vegetarian plan
        Map<String, List<String>> vegetarianMeals = new HashMap<>();
        vegetarianMeals.put("breakfast_Veggie Omelet", Arrays.asList("eggs", "vegetables", "cheese"));
        vegetarianMeals.put("lunch_Quinoa Salad", Arrays.asList("quinoa", "vegetables", "nuts"));
        vegetarianMeals.put("dinner_Pasta Primavera", Arrays.asList("pasta", "vegetables", "dairy"));
        
        // Sample meal data for vegan plan
        Map<String, List<String>> veganMeals = new HashMap<>();
        veganMeals.put("breakfast_Oatmeal Bowl", Arrays.asList("oats", "fruits", "nuts"));
        veganMeals.put("lunch_Buddha Bowl", Arrays.asList("grains", "vegetables", "legumes"));
        veganMeals.put("dinner_Lentil Curry", Arrays.asList("lentils", "vegetables", "spices"));
        
        // Sample meal data for keto plan
        Map<String, List<String>> ketoMeals = new HashMap<>();
        ketoMeals.put("breakfast_Keto Scramble", Arrays.asList("eggs", "bacon", "low-carb vegetables"));
        ketoMeals.put("lunch_Salmon Salad", Arrays.asList("salmon", "leafy greens", "healthy fats"));
        ketoMeals.put("dinner_Steak Dinner", Arrays.asList("steak", "broccoli", "butter"));
        
        // Sample meal data for high-protein plan (with some invalid meals)
        Map<String, List<String>> proteinMeals = new HashMap<>();
        proteinMeals.put("breakfast_Protein Pancakes", Arrays.asList("protein powder", "eggs", "oats"));
        proteinMeals.put("lunch_Chicken Salad", Arrays.asList("chicken breast", "vegetables", "quinoa"));
        proteinMeals.put("dinner_Fish and Chips", Arrays.asList("fish", "processed potatoes", "high-sugar sauce")); // Invalid
        
        // Generate meal plans
        System.out.println("=== Generating Meal Plans ===");
        List<Meal<VegetarianMeal>> vegetarianPlan = generatePersonalizedPlan(vegetarianGenerator, vegetarianMeals);
        System.out.println();
        
        List<Meal<VeganMeal>> veganPlan = generatePersonalizedPlan(veganGenerator, veganMeals);
        System.out.println();
        
        List<Meal<KetoMeal>> ketoPlan = generatePersonalizedPlan(ketoGenerator, ketoMeals);
        System.out.println();
        
        List<Meal<HighProteinMeal>> proteinPlan = generatePersonalizedPlan(proteinGenerator, proteinMeals);
        System.out.println();
        
        // Display meal plans
        displayMealPlan(vegetarianPlan, "Vegetarian Meal Plan");
        displayMealPlan(veganPlan, "Vegan Meal Plan");
        displayMealPlan(ketoPlan, "Keto Meal Plan");
        displayMealPlan(proteinPlan, "High-Protein Meal Plan");
        
        // Display nutrition summaries
        System.out.println("\n=== Nutrition Analysis ===");
        displayNutritionSummary(vegetarianPlan);
        displayNutritionSummary(veganPlan);
        displayNutritionSummary(ketoPlan);
        displayNutritionSummary(proteinPlan);
    }
}