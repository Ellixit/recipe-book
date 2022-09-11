import java.util.ArrayList;

public class CookingRecipe {

	private String name = "";
	
	ArrayList<RecipeIngredient> ingredientList = new ArrayList<RecipeIngredient>();
	
	public CookingRecipe(String name) {
		this.name = name;
	}
	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	public ArrayList<RecipeIngredient> getIngredientList() {
		return ingredientList;
	}
	
	public void addOrUpdateRecipeIngredient(Ingredient ingredient, float quantity) {
		boolean notInRecipe = true;
		RecipeIngredient currentIngredient = new RecipeIngredient(ingredient.getName(), ingredient.getMeasuringUnit(), ingredient.getCaloriesPerUnit(), quantity);
		
		for (int i = 0; i < ingredientList.size(); i++) {
			if (ingredient.getName().equals(ingredientList.get(i).getName())) {
				ingredientList.set(i, currentIngredient);
				notInRecipe = false;
				break;
			}
		}
		
		if (notInRecipe) {
			ingredientList.add(currentIngredient);
		}
	}
	
	public RecipeIngredient getRecipeIngredient(Ingredient ingredient) {
		int ingredientIndex = 0;
		
		for (int i = 0; i < ingredientList.size(); i++) {
			if (ingredient.getName().equals(ingredientList.get(i).getName())) {
				ingredientIndex = i;
				return ingredientList.get(ingredientIndex);
			}
		}
		
		return null;
	}
	
	public RecipeIngredient getRecipeIngredient(String ingredientName) {
		int ingredientIndex = 0;
		
		for (int i = 0; i < ingredientList.size(); i++) {
			if (ingredientName.equals(ingredientList.get(i).getName())) {
				ingredientIndex = i;
				return ingredientList.get(ingredientIndex);
			}
		}

		return null;
	}
	
	public RecipeIngredient removeRecipeIngredient(Ingredient ingredient) {	
		RecipeIngredient removedIngredient = new RecipeIngredient("", "", 0, 0);
		
		for (int i = 0; i < ingredientList.size(); i++) {
			if (ingredient.getName().equals(ingredientList.get(i).getName())) {
				removedIngredient = ingredientList.get(i);
				ingredientList.remove(i);
				return removedIngredient;
			}
		}
		
			return null;
	}
	
	public RecipeIngredient removeRecipeIngredient(String ingredientName) {
		RecipeIngredient removedIngredient = new RecipeIngredient("", "", 0, 0);
		
		for (int i = 0; i < ingredientList.size(); i++) {
			if (ingredientName.equals(ingredientList.get(i).getName())) {
				removedIngredient = ingredientList.get(i);
				ingredientList.remove(i);
				return removedIngredient;
			}
		}

		return null;
	}
	
	public float calculateCalories() {
		float totalCalories = 0;
		
		for (int i = 0; i < ingredientList.size(); i++) {
			totalCalories += (ingredientList.get(i).getCaloriesPerUnit()) * (ingredientList.get(i).getQuantity());
		}
		
		return totalCalories;
	}
	
	public int getNumberOfIngredient() {
		return ingredientList.size();
	}
	
	public String toString() {
		String ingredients = "";
	
		for (int i = 0; i < ingredientList.size(); i++) {
			ingredients += ingredientList.get(i) + "; ";
		}
		
		return (this.name + ": " + ingredients);
	}
	
}