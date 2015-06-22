package tasks.Task2;
//I've took that class from the Internet.
public class Node {//Class for representing each city as the part of graph

    /**
     * This field is number of the graph vertex (city).
     */
    final int id;
    /**
     * This field is string name of the graph vertex (city).
     */
    private String name;

    /**
     * Constructs a Node object with the specified initial identifier
     * <code>id</code> and <code>name</code> of the graph vertex.
     *
     * @param id number of the graph vertex
     * @param name the string name of the graph vertices
     * @throws IllegalArgumentException if the id less than 0
     */
    public Node(final int id, final String name) {
        if (id<0){ 
        	throw new IllegalArgumentException("id cant't be less than 0");
        }
        this.id = id;
        this.name = name;
    }

    /**
     * Constructs a HashMap object with the specified initial identifier id.
     *
     * @param id identifier of graph vertex
     */
    public Node(final int id) {
        this(id, null);
    }

    /**
     * Returns a string representation of this object. The string representation
     * consists of a list of the object's fields. In other words, this method
     * returns a string equal to the value of:
     * <code>  String.format("[id=%d, name=%s]", id, name) </code>
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        return String.format("[id=%d, name=%s]", id, name);
    }

    /**
     * Returns the value of the field Name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the field Name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}