class Node:
    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right
 
class Tree:
    def __init__(self, root):
        self.root = root
 
    def preorder(self):
        print(self.root.data)
        if self.root.left!=None:
            tree2=Tree(self.root.left)
            tree2.preorder()
        if self.root.right!=None:
            tree3=Tree(self.root.right)
            tree3.preorder()
            

 
# Test code
root = Node(5, Node(2, Node(7, Node(4), Node(1)), Node(3)), Node(9, Node(6), Node(10)))
tree = Tree(root)
tree.preorder()