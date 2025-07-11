//Level Order Traversal
class Solution
{
    public:
    //Function to return the level order traversal of a tree.
    vector<int> levelOrder(Node* root)
    {
      //Your code here
      queue<Node *>q;
      q.push(root);
      vector<int>ans;
      Node *temp;
      while(!q.empty()){
          temp = q.front();
          q.pop();
          ans.push_back(temp->data);
          
          if(temp->left){
              q.push(temp->left);
          }
          if(temp->right){
              q.push(temp->right);
          }
      }
      return ans;
    }
};


//SUm of Binary Tree
//2nd method

long int sumBT(Node* root)
{
    if(!root){
        return 0 ;
    }
    return (root->key + sumBT(root->left) + sumBT(root->right));
}


//Count leaf in Binary tree
//!st method
void countleaf(Node* root,int &count){
    if(root == NULL){
        return ;
    }
    if(!root->left && !root->right){
        count++;
        return ;
    }
    countleaf(root->left,count);
    countleaf(root->right,count);
}
int countLeaves(Node* root)
{
    int count=0;
    countleaf(root, count);
    return count;
  // Your code here
}

//2nd Method
int countLeaves(Node* root)
{
    if(root== NULL){
        return 0;
    }
    if(!root->left && !root->right){
        return 1;
    }
    return (countLeaves(root->left)+countLeaves(root->right));
  // Your code here
}


//Two Trees are Identical or not
class Solution
{
    public:
    //Function to check if two trees are identical.
    bool isIdentical(Node *r1, Node *r2)
    {
        if(!r1 && !r2){
            return 1;
        }
        if((!r1&&r2) || (r1 && !r2)){
            return 0;
        }
        if(r1->data!= r2->data){
            return 0;
        }
        
        return isIdentical(r1->left,r2->left)&&isIdentical(r1->right,r2->right);
        //Your Code here
    }
};


//Mirror Tree
class Solution {
  public:
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node* root) {
        // code here
        if(!root){
            return;
        }
        
        Node *temp = root->right;
        root->right= root->left;
        root->left = temp;
        
        mirror(root->left);
        mirror(root->right);
    }
};

//Check For Balanaced Tree
//{ Driver Code Starts
//Initial Template for C++


#include <bits/stdc++.h>
using namespace std;


// Tree Node
struct Node {
    int data;
    Node* left;
    Node* right;
};

// Utility function to create a new Tree Node
Node* newNode(int val) {
    Node* temp = new Node;
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;

    return temp;
}


// Function to Build Tree
Node* buildTree(string str) {
    // Corner Case
    if (str.length() == 0 || str[0] == 'N') return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;) ip.push_back(str);

    // Create the root of the tree
    Node* root = newNode(stoi(ip[0]));

    // Push the root to the queue
    queue<Node*> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while (!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node* currNode = queue.front();
        queue.pop();

        // Get the current node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N") {

            // Create the left child for the current node
            currNode->left = newNode(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if (i >= ip.size()) break;
        currVal = ip[i];

        // If the right child is not null
        if (currVal != "N") {

            // Create the right child for the current node
            currNode->right = newNode(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


// } Driver Code Ends
/* A binary tree node structure

struct Node
{
    int data;
    struct Node* left;
    struct Node* right;
    
    Node(int x){
        data = x;
        left = right = NULL;
    }
};
 */

class Solution{
    public:
    //Function to check whether a binary tree is balanced or not.
    int height(Node *root, bool &valid){
    if(!root){
        return 0;
    }
    int l = height(root->left,valid);
    if(valid){
        int r = height(root->right,valid);
        
        if(abs(l-r)>1)
        valid=0;
        return 1+max(l,r);
    }
    
    return -1;
    }
    bool isBalanced(Node *root)
    {
        //  Your Code here
        bool valid=1;
        height(root,valid);
        return valid;
    }
};


//{ Driver Code Starts.

/* Driver program to test size function*/

  

int main() {

   
    int t;
    scanf("%d ", &t);
    while (t--) {
        string s, ch;
        getline(cin, s);
        
        Node* root = buildTree(s);
        Solution ob;
        cout << ob.isBalanced(root) << endl;
    }
    return 0;
}

// } Driver Code Ends


//Level Order Spiral Transversal
//{ Driver Code Starts
//Initial Template for C++


#include <bits/stdc++.h>
using namespace std;


// Tree Node
struct Node {
    int data;
    Node* left;
    Node* right;
};

// Utility function to create a new Tree Node
Node* newNode(int val) {
    Node* temp = new Node;
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;

    return temp;
}


// Function to Build Tree
vector<int> findSpiral(Node *root)
{
    //Your code here
    stack<Node*>s1;
    stack<Node*>s2;
    s1.push(root);
    vector<int>ans;
    while(!s1.empty() || !s2.empty()){
        if(!s1.empty()){
            while(!s1.empty()){
                Node *temp = s1.top();
                s1.pop();
                
                ans.push_back(temp->data);
                
                //right
                if(temp->right){
                    s2.push(temp->right);
                }
                //left
                if(temp->left)
                s2.push(temp->left);
            }
        }
        else{ //left to right
            while(!s2.empty()){
                Node *temp = s2.top();
                s2.pop();
                
                ans.push_back(temp->data);
                //left
                if(temp->left)
                s1.push(temp->left);
                //right
                if(temp->right)
                s1.push(temp->right);
                
            }
        }
    }
    return ans;
}


//TOP view of bnary tree
vector<int> topView(Node *root)
    {
        map<int,int> topnode;
        queue<pair<Node * , int> > q;
        vector<int> ans;
        if(root == NULL){
            return ans;
        }
        
        q.push(make_pair(root,0));
        
        while(!q.empty()){
            pair<Node * , int> temp = q.front();
            q.pop();
            Node *frontnode = temp.first;
            int hd = temp.second;
            
            if(topnode.find(hd) == topnode.end()){
                topnode[hd] = frontnode->data;
            }
            
            if(frontnode->left){
                q.push(make_pair(frontnode->left,hd-1));
            }
             if(frontnode->right){
                q.push(make_pair(frontnode->right,hd+1));
            }
        }
        
        for(auto i : topnode){
            ans.push_back(i.second);
        }
        
        return ans;
        //Your code here
    }


//BOTTOM VIEW OF BINARY TREE
 vector <int> bottomView(Node *root) {
        // Your Code Here
        map<int,int> topnode;
        queue<pair<Node * , int> > q;
        vector<int> ans;
        if(root == NULL){
            return ans;
        }
        
        q.push(make_pair(root,0));
        
        while(!q.empty()){
            pair<Node * , int> temp = q.front();
            q.pop();
            Node *frontnode = temp.first;
            int hd = temp.second;
            
            
                topnode[hd] = frontnode->data;
            
            if(frontnode->left){
                q.push(make_pair(frontnode->left,hd-1));
            }
             if(frontnode->right){
                q.push(make_pair(frontnode->right,hd+1));
            }
        }
        
        for(auto i : topnode){
            ans.push_back(i.second);
        }
        
        return ans;
    }


//Left view / right view of binary tree
void solve(Node *root, vector<int> &ans , int level){
    if(root == NULL){
        return ;
    }
    
    if(level == ans.size()){
        ans.push_back(root->data);
    }
    solve(root->left,ans,level+1);
    solve(root->right,ans,level+1);
}
//Function to return a list containing elements of left view of the binary tree.
vector<int> leftView(Node *root)

{
    vector<int> ans;
    solve(root,ans,0);
    return ans;
   // Your code here
}


//diameter of binary tree
class Solution {
  public:
    // Function to return the diameter of a Binary Tree.
   pair<int,int>solve(Node *root){
       if(root == NULL){
           return make_pair(0,0);
       }
       pair<int,int>left = solve(root->left);
       pair<int,int>right = solve(root->right);
       
       int op1 = left.first;
       int op2 = right.first ;
       int op3 = left.second + right.second + 1;
       
       pair<int,int>ans;
       
       ans.first = max(op1 , max(op2, op3));
       ans.second = max(left.second , right.second)+1 ; 
       return ans;
   }
   
   int diameter (Node *root){
       return  solve(root).first ; 
       
   }
};


//Vertical Order Traversal
//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// Tree Node
struct Node
{
    int data;
    Node* left;
    Node* right;
};
// Utility function to create a new Tree Node
Node* newNode(int val)
{
    Node* temp = new Node;
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;
    
    return temp;
}

// Function to Build Tree
Node* buildTree(string str)
{   
    // Corner Case
    if(str.length() == 0 || str[0] == 'N')
            return NULL;
    
    // Creating vector of strings from input 
    // string after spliting by space
    vector<string> ip;
    
    istringstream iss(str);
    for(string str; iss >> str; )
        ip.push_back(str);
        
    // Create the root of the tree
    Node* root = newNode(stoi(ip[0]));
          
    // Push the root to the queue
    queue<Node*> queue;
    queue.push(root);
        
    // Starting from the second element
    int i = 1;
    while(!queue.empty() && i < ip.size()) {
            
        // Get and remove the front of the queue
        Node* currNode = queue.front();
        queue.pop();
            
        // Get the current node's value from the string
        string currVal = ip[i];
            
        // If the left child is not null
        if(currVal != "N") {
                
            // Create the left child for the current node
            currNode->left = newNode(stoi(currVal));
                
            // Push it to the queue
            queue.push(currNode->left);
        }
            
        // For the right child
        i++;
        if(i >= ip.size())
            break;
        currVal = ip[i];
            
        // If the right child is not null
        if(currVal != "N") {
                
            // Create the right child for the current node
            currNode->right = newNode(stoi(currVal));
                
            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }
    
    return root;
}

// Function for Inorder Traversal
void printInorder(Node* root)
{
    if(!root)
        return;
        
    printInorder(root->left);
    cout<<root->data<<" ";
    printInorder(root->right);
}


// } Driver Code Ends
class Solution
{
    public:
    //Function to find the vertical order traversal of Binary Tree.
    vector<int> verticalOrder(Node *root)
    {
        map<int,map<int,vector<int> > >nodes;
        queue< pair<Node* ,pair<int,int> > >q;
        vector <int> ans;
        
        if(root == NULL){
            return ans;
        }
        q.push(make_pair(root, make_pair(0,0)));
        while(!q.empty()){
            pair<Node* ,pair<int,int> > temp = q.front();
            q.pop();
            Node * frontnode = temp.first;
            int hd = temp.second.first;
            int lv = temp.second.second;
            
            nodes[hd][lv].push_back(frontnode->data);
            
            
            if(frontnode->left){
                q.push(make_pair(frontnode->left,make_pair((hd-1),(lv+1))));
            }
            if(frontnode->right){
                q.push(make_pair(frontnode->right,make_pair((hd+1),(lv+1))));
            }
            
        }
        
        for(auto i : nodes){
            for(auto j : i.second){
                for(auto k : j.second){
                    ans.push_back(k);
                }
            }
        }
        
        return ans;
        //Your code here
    }
};



//{ Driver Code Starts.
int main() {
    int t;
    string  tc;
    getline(cin,tc);
    t=stoi(tc);
    while(t--)
    {
        string s;
        getline(cin,s);
        // string c;
        // getline(cin,c);
        Solution obj;
    	Node* root = buildTree(s);
    	
    	vector <int> res = obj.verticalOrder(root);
    	for (int i : res) cout << i << " ";
        cout << endl;
    }
	return 0;
}



// } Driver Code Ends

//Sum of nodes on longest path from root node to leaf node
class Solution
{
public:
void solve(Node *root , int sum , int &maxsum , int len , int &maxlen){
    if(root == NULL){
        if(len > maxlen){
            maxlen = len;
            maxsum = sum;
        }
        else if(len == maxlen){
            maxsum = max(sum,maxsum);
        }
        return ;
    }
    
    sum = sum+ root->data;
    
    solve(root->left,sum ,maxsum,len+1,maxlen);
    solve(root->right,sum,maxsum,len+1,maxlen);
}


    
    int sumOfLongRootToLeafPath(Node *root)
    {
        int len = 0;
        int maxlen = 0;
        int sum = 0;
        int maxsum = INT_MIN;
        
        solve(root , sum , maxsum , len , maxlen);
        
        return maxsum;
    }
};

//Lowest Common Ancestor
Node* lca(Node* root ,int n1 ,int n2 )
    {
        if(root == NULL){
            return NULL;
        }
        
        if(root ->data == n1 || root->data == n2){
            return root;
        }
        
        Node *leftans = lca(root->left,n1,n2);
        Node *rightans = lca(root->right,n1,n2);
        
        if(leftans!=NULL && rightans!=NULL){
            return root;
        }
        else if(leftans!=NULL && rightans == NULL){
            return leftans;
        }
        else if(leftans==NULL && rightans != NULL){
            return rightans;
        }
        else{
            return NULL;
        }
       //Your code here 
    }

//Sum of K paths
class Solution {
  public:
  void findksumpath(Node *root , int k , int &count, vector<int>&path){
      if(root==NULL){
          return ;
      }
      path.push_back(root->data);
      
      findksumpath(root->left,k,count,path);
      findksumpath(root->right,k,count,path);
      
      int sum=0;
      for(int i=path.size()-1;i>=0;i--){
          sum+= path[i];
          if(sum == k){
              count++;
          }
      }
      
      path.pop_back();
  }
    int sumK(Node *root, int k) {
        int count = 0;
        vector<int>path;
        findksumpath(root,k,count,path);
        
        return count;
        // code here
    }
};
