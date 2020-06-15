package co.grandcircus.FinalProject.WorkoutsApi;

public class Workout {

	private ExerciseInfo excerciseInfo;

	public ExerciseInfo getExcerciseInfo() {
		return excerciseInfo;
	}

	public void setExcerciseInfo(ExerciseInfo excerciseInfo) {
		this.excerciseInfo = excerciseInfo;
	}


	@Override
	public String toString() {
		return "Workout [excerciseInfo=" + excerciseInfo + "]";
	}
	
	
	
	
	
}
