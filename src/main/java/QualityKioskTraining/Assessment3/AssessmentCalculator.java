package QualityKioskTraining.Assessment3;

public class AssessmentCalculator {

		public double add(double firstNumber, double secondNumber) {
			double value = firstNumber + secondNumber;
			return Math.floor(value * 100) / 100; 
		}

		public double multiply(double firstNumber, double secondNumber) {
			return firstNumber * secondNumber;
		}

		public double subtract(double firstNumber, double secondNumber) {
			return firstNumber - secondNumber;
		}

		public double divide(double firstNumber, double secondNumber) {
			return firstNumber / secondNumber;
		}

	}


