import java.util.ArrayList;

/**
 * Created by Utkarsh on 8/30/18.
 * Revised by George Adams on 09/02/18.
 * Revised by Shivaram Gopal on 09/02/18.
 */

 
public class Stack<T>
{
    
    private int stackSize;
    private T[] stackArr;
    private int top;
    
    @SuppressWarnings("unchecked")
    public Stack(int capacity)
    {
        this.stackSize = capacity;
        this.stackArr = (T[]) new Object[stackSize];
        this.top = -1;
        
    }

    public boolean IsEmpty(){
        return (top == -1);             
    }

    public boolean push(T val){
        if(this.IsStackFull()){
            return false;
        } else {
        this.stackArr[++top] = val;
        
        return true;
        }
    }

    public T pop() throws IndexOutOfBoundsException{
        //Write your code here
        // Method should return the top element of the stack
        // This removes the element from the stack
        // Incase the stack is empty, it should throw an error,
        // with the message "Empty Stack"
        if(this.IsEmpty()){
            throw new IndexOutOfBoundsException("Empty Stack");
        }
        T entry = this.stackArr[top--];
        
       
        return entry; 
    }

    public int size()
    {
        

        return this.top-1;               
    }
    public boolean IsStackFull(){
        
            return (top == stackSize -1);
            
    }
    public T peek(){
        return stackArr[top];
        }
}
