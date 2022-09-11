import java.util.ArrayList;

public class RecipeBook {

	private String bookName = "";
	
	ArrayList<CookingRecipe> cookingRecipes = new ArrayList<CookingRecipe>();
	
	public RecipeBook(String bookName) {
		this.bookName = bookName;
	}
	
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
	
	public CookingRecipe addRecipe(String name, RecipeIngredient[] ingredients) {
		CookingRecipe inputRecipe = new CookingRecipe(name);
		
		for (int i = 0; i < cookingRecipes.size(); i++) {
			if (cookingRecipes.get(i).getName().equals(inputRecipe.getName())) {
				return null;
			}
		}
		
		for (int i = 0; i < ingredients.length; i++) {
			float ingredientQuantity = ingredients[i].getQuantity();
			inputRecipe.addOrUpdateRecipeIngredient(ingredients[i], ingredientQuantity);
		}
		
		cookingRecipes.add(inputRecipe);
		return inputRecipe;
	}
	
	public CookingRecipe removeRecipe(String name) {
		CookingRecipe removedRecipe = new CookingRecipe("");
		
		for (int i = 0; i < cookingRecipes.size(); i++) {
			if (name.equals(cookingRecipes.get(i).getName())) {
				removedRecipe = cookingRecipes.get(i);
				cookingRecipes.remove(i);
				return removedRecipe;
			}
		}
		
		return null;
	}
	
	public CookingRecipe[] findRecipes(RecipeIngredient[] ingredients) {
		ArrayList<CookingRecipe> containsIngredients = new ArrayList<CookingRecipe>();
		
		for (int i = 0; i < cookingRecipes.size(); i++) {
			CookingRecipe recipe = cookingRecipes.get(i);
			boolean goodRecipe = true;
			for (int j = 0; j < ingredients.length; j++) {
				RecipeIngredient ingredient = ingredients[j];
				if (!recipe.getIngredientList().contains(ingredient)) {
					goodRecipe = false;
				}
			}
			
			if (goodRecipe) {
				containsIngredients.add(recipe);
			}
		}
		
		CookingRecipe[] finalArray = new CookingRecipe[containsIngredients.size()];
		
		for (int i = 0; i < containsIngredients.size(); i++) {
			finalArray[i] = containsIngredients.get(i);
		}
		
		return finalArray;
	}
	
	public CookingRecipe[] findRecipesWithFewIngredients(int numberOfIngredients) {
		ArrayList<CookingRecipe> containsIngredients = new ArrayList<CookingRecipe>();
		
		for (int i = 0; i < cookingRecipes.size(); i++) {
			if (cookingRecipes.get(i).getNumberOfIngredient() <= numberOfIngredients) {
				containsIngredients.add(cookingRecipes.get(i));
			}
		}
		
		CookingRecipe[] finalArray = new CookingRecipe[containsIngredients.size()];
		
		for (int i = 0; i < containsIngredients.size(); i++) {
			finalArray[i] = containsIngredients.get(i);
		}
		
		return finalArray;
	}
	
	public CookingRecipe[] findRecipesLowCalories() {
		ArrayList<CookingRecipe> lowCalories = new ArrayList<CookingRecipe>();
		float lowestCalories = cookingRecipes.get(0).calculateCalories();
		
		for (int i = 0; i < cookingRecipes.size(); i++) {
			if (cookingRecipes.get(i).calculateCalories() <= lowestCalories) {
				lowestCalories = cookingRecipes.get(i).calculateCalories();
			}
		}
		
		for (int i = 0; i < cookingRecipes.size(); i++) {
			if (cookingRecipes.get(i).calculateCalories() == lowestCalories) {
				lowCalories.add(cookingRecipes.get(i));
			}
		}
		
		CookingRecipe[] finalArray = new CookingRecipe[lowCalories.size()];
		
		for (int i = 0; i < lowCalories.size(); i++) {
			finalArray[i] = lowCalories.get(i);
		}
		
		return finalArray;
	}
	
	public String toString() {
		String recipes = "Recipe Book: " + bookName + "\n";
		for (CookingRecipe current: cookingRecipes) {
			recipes += " " + current.toString() + "\n";
		}
		return (recipes);
	}
	
}