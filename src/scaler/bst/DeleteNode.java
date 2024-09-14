package scaler.bst;

public class DeleteNode {

    public Node delete(int data,Node root)
    {
        Node previous = null;
        Node current = root;

        while(current != null)
        {
            if(current.data == data)
            {
                // Node found
                if(current.left == null && current.right == null)
                {
                    if(previous == null)
                    {
                        return null;
                    }
                    else
                    {
                        if(previous.left == current)
                        {
                            previous.left = null;
                        }
                        else
                        {
                            previous.right = null;
                        }
                    }
                    return root;
                }
                else if(current.left == null || current.right == null)
                {
                    if(previous == null)
                    {
                        return (current.left != null)? current.left : current.right;
                    }
                    else
                    {
                        if(previous.left == current)
                        {
                            previous.left = (current.left != null)? current.left : current.right;
                        }
                        else
                        {
                            previous.right = (current.left != null)? current.left : current.right;
                        }
                        return root;
                    }
                }
                else
                {
                    Node maxInLST = current.left;
                    Node tempPrev = current;
                    while(maxInLST.right != null)
                    {
                        tempPrev = maxInLST;
                        maxInLST = maxInLST.right;
                    }
                   if(tempPrev.left == maxInLST)
                   {
                       tempPrev.left = (maxInLST.left != null)? maxInLST.left : null;
                   }
                   else
                   {
                       tempPrev.right = (maxInLST.left != null)? maxInLST.left : null;
                   }
                    maxInLST.left = current.left;
                    maxInLST.right = current.right;
                   if(previous != null)
                   {

                       if(previous.left == current)
                       {
                           previous.left = maxInLST;
                       }
                       else
                       {
                           previous.right = maxInLST;
                       }
                       return root;
                   }
                   else
                   {
                       return maxInLST;
                   }
                }
            }
            else
            {
                previous = current;
                current = (data > current.data)?current.right : current.left;
            }
        }
        return root;
    }


}
