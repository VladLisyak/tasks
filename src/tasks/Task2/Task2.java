package tasks.Task2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Task2{
	public static final Scanner scr = new Scanner(System.in);
	
    class Data {
    	//the cities list
        private List<Node> citiesList = new ArrayList<Node>();
        //the list of neighbors of cities
        private List<Edge> edgesList = new ArrayList<Edge>();
        //the number of routes to find
        private HashMap<Integer, Edge> routesList = new HashMap<Integer, Edge>();
    }
    //graphs by the number of tests
    List<Data> graphs = new ArrayList<Data>();

    public void createGraph() throws Exception {
        //inner class for reading data from console
    	class GraphReader {
            final Data data = new Data();

            public Data read() throws Exception {
                readCity();
                readRoutes();
                return data;
            }
            
            //Method for initialization of cities 
            private void readCity() throws Exception {
                int numberOfCity = 0; // the number of cities
                if (scr.hasNextInt()) {
                    numberOfCity = scr.nextInt();
                } else {
                    throw new Exception("The format of input is wrong, integer expected.");
                }
                // initialization of the cities as Node-objects in citiesList in Data-object, the first city corresponds to object of Node (0)
                for (int city = 0; city < numberOfCity; city++) {
                    data.citiesList.add(new Node(city));
                }
                //reading of all citie's names and neighbors sequentially  
                for (int city = 0; city < numberOfCity; city++) {
                    if (scr.hasNextLine()) {
                    	String name = scr.next();
                    	if (name.length()>10){
                    		throw new IllegalStateException("The name of city is to long.");
                    	}
                        data.citiesList.get(city).setName(name);//adding a name to existing city
                    } else {
                        throw new Exception("The format of input is wrong, integer expected.");
                    }
                    //reading of cities edges to neighbors
                    readEdges(city);
                }
            }
             
            //Method for initialization of connections(Edges) between cities
            private void readEdges(int fromCity) throws Exception {
                int p = 0;                          // the number of neighbors of city
                if (scr.hasNextInt()) {
                    p = scr.nextInt();
                } else {
                    throw new Exception("The format of input is wrong, integer expected.");
                }

                for (int i = 0; i < p; i++) {
                    int toCity = 0;  //the neighbor-city identifier
                    if (scr.hasNextInt()) {
                        toCity = scr.nextInt();
                    } else {
                        throw new Exception("The format of input is wrong, integer expected.");
                    }
                    int cost = 0;//weight of edge (cost of path)
                    if (scr.hasNextInt()) {
                        cost = scr.nextInt();
                    } else {
                        throw new Exception("The format of input is wrong, integer expected.");
                    }

                    Edge edge = new Edge(data.citiesList.get(fromCity), data.citiesList.get(toCity - 1), cost);//initialization of new edge
                    data.edgesList.add(edge);//adding an edge to list of edges of the graph
                }
            }
 
            //Method for initialization of edges that are represents the shortest paths. 
            private void readRoutes() throws Exception {
                int r = 0;// the number of routes to find 
                if (scr.hasNextInt()) {
                    r = scr.nextInt();
                } else {
                    throw new Exception("The format of input is wrong, integer expected.");
                }
                for (int i = 0; i < r; i++) {

                    String strFrom = null;//from which city
                    if (scr.hasNext()) {
                        strFrom = scr.next();
                    } else {
                        throw new Exception("The format of input is wrong, integer expected.");
                    }

                    String strTo = null;//to which city
                    if (scr.hasNext()) {
                        strTo = scr.next();
                    } else {
                        throw new Exception("The format of input is wrong, integer expected.");
                    }

                    Node cityFrom = null;
                    Node cityTo = null;

                    for (int j = 0; j < data.citiesList.size(); j++) {
                        if ((cityFrom == null) && (data.citiesList.get(j).getName().
                                equals(strFrom))) {
                            cityFrom = data.citiesList.get(j);
                        }
                        if ((cityTo == null) && (data.citiesList.get(j).getName().
                                equals(strTo))) {
                            cityTo = data.citiesList.get(j);
                        }
                    }
                    Edge edge = new Edge(cityFrom, cityTo, -1);
                    data.routesList.put(i, edge);
                }
            }
        } //end of createGraph class
        
        
        int s = 0;//number of tests

        if (scr.hasNextInt()) {
            s = scr.nextInt();
        }
        for (int i = 0; i < s; i++) {
            GraphReader record = new GraphReader();
            graphs.add(record.read());

            if (scr.hasNextLine()) {
                scr.nextLine();
            }
        }
        scr.close();
    }

    public void solution() {

        for (Data data : graphs) {  // for each graph to calculate the route
            //applying the algorithm for each set of data
            FloydWarshall floydeWarshall = new FloydWarshall(data.citiesList, data.edgesList);
            //assignment of weights to edges that are represents the shortest paths. 
            for (int i = 0; i < data.routesList.size(); i++) {
                floydeWarshall.getShortestDistance(data.routesList.get(i));
            }
        }
    }

    //Printing the result - the shortest way between mentioned cities
    public void printResult() {
            for (Data data : graphs) {
                for (int i = 0; i < data.routesList.size(); i++) {
                    System.out.println(data.routesList.get(i).getWeight());
                }
            }
    }

    public static void main(String[] args) throws Exception {
            Task2 task2 = new Task2();
    	    task2.createGraph();
            task2.solution();
            task2.printResult();
        
    }
}