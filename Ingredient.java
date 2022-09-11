public class Ingredient {

	private String name = "";
	private String measuringUnit = "";
	private int caloriesPerUnit = 0;
	
	public Ingredient(String name, String measuringUnit, int caloriesPerUnit) {
		this.name = name;
		this.measuringUnit = measuringUnit;
		this.caloriesPerUnit = caloriesPerUnit;
	}
	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getMeasuringUnit() {
			return measuringUnit;
		}
		public void setMeasuringUnit(String measuringUnit) {
			this.measuringUnit = measuringUnit;
		}
		
		public int getCaloriesPerUnit() {
			return caloriesPerUnit;
		}
		public void setMeasuringUnit(int caloriesPerUnit) {
			this.caloriesPerUnit = caloriesPerUnit;
		}
	
	public String toString() {
		return name;
	}
	
}