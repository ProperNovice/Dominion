package utils;

public interface Node {

	public void relocate(double x, double y);
	
	public void relocate(NumbersPair numbersPair);

	public double getLayoutX();

	public double getLayoutY();

	public void toFront();

}
