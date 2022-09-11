import java.util.Arrays;

public class TestRecipeBook {
	
	public static void main(String[] args) {
		 
		RecipeBook desserts = new RecipeBook("Jeffrey's Dessert Book");
		
			desserts.addRecipe("Brownie", new RecipeIngredient[] {
				new RecipeIngredient("Butter", "Cups", 250, (float)0.5),
				new RecipeIngredient("White Sugar", "Cups", 200, 1),
				new RecipeIngredient("Eggs", "", 100, 2),
				new RecipeIngredient("Vanilla Extract", "Teaspoons", 50, 1),
				new RecipeIngredient("Cocoa Powder", "Cups", 200, (float)0.33),
				new RecipeIngredient("Flour", "Cups", 50, (float)0.5),
				new RecipeIngredient("Salt", "Teaspoons", 50, (float)0.25),
				new RecipeIngredient("Baking Powder", "Teaspoons", 25, (float)0.25)
			});
			
			desserts.addRecipe("Chocolate Chip Cookies", new RecipeIngredient[] {
				new RecipeIngredient("Butter", "Cups", 250, 1),
				new RecipeIngredient("White Sugar", "Cups", 200, 1),
				new RecipeIngredient("Eggs", "", 100, 2),
				new RecipeIngredient("Vanilla Extract", "Teaspoons", 50, 2),
				new RecipeIngredient("Flour", "Cups", 50, 3),
				new RecipeIngredient("Chocolate Chips", "Cups", 150, 2)
			});
			
			desserts.addRecipe("Salad", new RecipeIngredient[] {
				new RecipeIngredient("Lettuce", "Cups", 10, 5)
			});
			
			desserts.addRecipe("Water", new RecipeIngredient[] {
				new RecipeIngredient("Water", "Cups", 0, 1),
				new RecipeIngredient("Ice", "Cups", 0, (float)0.25)
			});
			
			System.out.println(desserts.toString());
			
			System.out.println(Arrays.deepToString(desserts.findRecipesLowCalories()));
				
			System.out.println(Arrays.deepToString(desserts.findRecipesWithFewIngredients(3)));
				
			
	}
	
}