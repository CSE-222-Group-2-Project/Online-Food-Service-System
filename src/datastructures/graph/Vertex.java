package src.datastructures.graph;

/**
 * Vertex class to hold information vertixes
 * @author Aziz Can Akkaya
 *
 */
public class Vertex {
	/**
	 * Id of the vertex
	 */
	private int id;
	
	/**
	 * Label value which can be modified by anything
	 * a.k.a. key
	 */
	private String label;
	
	/**
	 * Weight of the vertex
	 * a.k.a. value
	 */
	private double weight;
	
	/**
	 * constructor
	 * @param id to be set
	 * @param label to be set
	 * @param weight to be set
	 */
	public Vertex(int id, String label, double weight) {
		this.id = id;
		this.label = label;
		this.weight = weight;
	}
	
	/**
	 * Getter for id
	 * @return returns id
	 */
	int getID() {
		return id;
	}
	
	/**
	 * Getter for label
	 * @return returns label
	 */
	String getLabel() {
		return label;
	}
	
	/**
	 * Getter for weight
	 * @return returns weight
	 */
	double getWeight() {
		return weight;
	}
}
