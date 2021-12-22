import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

class Graph{

    private final int V;
    private ArrayList<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        adj = (ArrayList<Integer> []) new ArrayList[V];
        
        for (int v = 0; v < V; v++){
            adj[v] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public void removeEdge(int v, int w){
        adj[v].remove(w);
        adj[w].remove(v);
    }

    public Iterable<Integer> adj(int v){ 
        return adj[v]; 
    }
    
}


class friends{

    public static ArrayList<Integer> gang(Graph graph, ArrayList<int[]> relations, int total_rel, boolean[] visited){
        ArrayList<Integer> min_set = new ArrayList<>();
        // System.out.println(visited[0]+"KDKDBDJDBJDBDJD");
        int num_relations=total_rel;
        while(total_rel>0){
            int relation_num = (int)(Math.random() * (num_relations));
            // System.out.println(relation_num);
            int rel_v = relations.get(relation_num)[0];
            // System.out.println(rel_v);
            int rel_w = relations.get(relation_num)[1];
            // System.out.println(rel_w);
            // System.out.println("rel_HEllow");
            int set=0;
            if(visited[rel_v]==false){
                for(int nbr : graph.adj(rel_v)){
                    if(visited[nbr]==false){
                        set=1;
                        // System.out.println(nbr+"DDDD");
                        total_rel-=1;
                        // visited[nbr]=true;
                    }
                }
                if(set==1) min_set.add(rel_v);
                visited[rel_v] = true;
            }

            set=0;
            if(visited[rel_w]==false){
                for(int nbr : graph.adj(rel_w)){
                    if(visited[nbr]==false){
                        set=1;
                        total_rel-=1;
                        // visited[nbr]=true;
                    }
                }
            }
            if(set==1) min_set.add(rel_w);
            visited[rel_w] = true;

        }
        return min_set;
    }

    public static void main(String[]args){
        File file = new File("Users.txt");
        BufferedReader br = null;
        String s;

        ArrayList<int[]> relations = new ArrayList<>();
        int vertices=0;
        try {
            br = new BufferedReader(new FileReader(file));
            s = br.readLine();
            String words[] = s.split(" ");
            vertices = Integer.parseInt(words[0]);
            // System.out.println(vertices);
            ArrayList<String> names = new ArrayList<>();
            for(int i=0;i<vertices;i++){
                names.add(words[i+1]);
                // System.out.println(names.get(i));
            }
            // for(int i=0;i<names.length;i++){
            //     System.out.println(names[i]);
            // }


            while ((s = br.readLine()) != null){
                int[] temp = new int[2];
                words = s.split(" ");
                temp[0] = names.indexOf(words[0]);
                temp[1] = names.indexOf(words[1]);
                // System.out.print(temp[0]);
                // System.out.print(temp[1]);
                relations.add(temp);
                }
            }

            catch(Exception e){
                System.out.println(("HELLO"));
                System.out.println(e);
            }

            int total_rel = relations.size();

            Graph graph = new Graph(vertices);
            for(int[] k : relations){
                // System.out.print(k[0]);
                // System.out.print(k[1]);
                graph.addEdge(k[0], k[1]);
                // System.out.println();
            }
            boolean[] visited = new boolean[vertices];
            ArrayList<Integer> result;
            ArrayList<Integer> result_new;
            result=gang(graph,relations,total_rel,visited);
            // for(Integer h : result){
            //     System.out.print(h);
            // }


            for(int i=0;i<vertices;i++){
                graph = new Graph(vertices);
                for(int[] k : relations){
                    graph.addEdge(k[0], k[1]);
                }
                visited = new boolean[vertices];
                result_new=gang(graph,relations,total_rel,visited);
                // System.out.print(result_new.size());
                if(result_new.size()<result.size()){

                    result = result_new;
                    // System.out.println("YES");
                }
            }
            for(Integer l : result){
                System.out.println(l);
            }
            System.out.println(result.size()+"DJDBJDDJ");
        }



}
