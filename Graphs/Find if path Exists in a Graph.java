import java.util.Scanner;
import java.util.*;
// Other imports go here
// Do NOT change the class name
class Main{
    
    public static boolean solve(List<List<Integer>> adj, int s, int d, boolean[] vis){
        if(s == d ) return true;
        vis[s] = true;
        
        for(int ngh: adj.get(s)){
            if(!vis[ngh]){
                if(solve(adj,ngh,d,vis)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<E;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            
            adj.get(u).add(v);
        }
        
        int source = sc.nextInt();
        int destination = sc.nextInt();
        
        boolean []vis =new boolean[V];
        boolean pathExis = solve(adj,source,destination,vis);
        
        if(pathExis){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        
        
    }
}
