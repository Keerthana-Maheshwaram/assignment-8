import java.util.*;
import java.io.*;

public class Friends {
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void main(String... args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("Users.txt"));
		int n = s.nextInt();
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < n; i++) names.add(s.next());
		ArrayList<int[]> allEdges = new ArrayList<int[]>();
		while (s.hasNext()) 
			allEdges.add(new int[]{names.indexOf(s.next()), names.indexOf(s.next())});
		ArrayList<Integer> bestVertices = new ArrayList<Integer>();
		Random r = new Random();
		for (int k = 0; k < n; k++) {
			ArrayList<int[]> edges = (ArrayList<int[]>) allEdges.clone();
			ArrayList<Integer> vertices = new ArrayList<Integer>();
			while (edges.size() != 0) {
				int index = r.nextInt(edges.size());
				int[] e = edges.remove(index);
				vertices.add(e[0]);
				vertices.add(e[1]);
				for (int i = edges.size() - 1; i >= 0; i--) {
					int [] e_ = edges.get(i);
					if (
						e_[0] == e[0] || e_[1] == e[0] ||
						e_[0] == e[1] || e_[1] == e[1]
					) 	edges.remove(i);
				}
			}
			if (bestVertices.size() == 0 || bestVertices.size() > vertices.size())
				bestVertices = vertices;
		}
		System.out.println("Users needed: " + bestVertices.size());
		Collections.sort(bestVertices);
		for (int i : bestVertices) System.out.println(names.get(i));
	}
}