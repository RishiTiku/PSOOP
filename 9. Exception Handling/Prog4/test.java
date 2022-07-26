import java.util.Scanner;

class UserEmptyStackException extends Throwable{}
class FullStackException extends Throwable{}

class Stack{
    int A[];
    int size;
    int top;
    Stack(int s){
        size = s;
        A = new int[s];
        top = -1;
    }
    void push() throws FullStackException
    {
        Scanner sc = new Scanner(System.in);
        if(top+1 == size)
        {
            throw new FullStackException();
        }
        top +=1;
        do{
            System.out.println("Enter A Number to be pushed into the stack.");
            try{
                A[top] = sc.nextInt();
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Value Entered. Try Again.");
            }
            sc.nextLine();
        }while(true);
    }
    void pop() throws UserEmptyStackException
    {
        if(top == -1)
            throw new UserEmptyStackException();
        top-=1;
    }
    void display() throws UserEmptyStackException
    {
        if(top==-1)
        {
            throw new UserEmptyStackException();
        }
        System.out.println("Stack: ");
        System.out.println("Top");
        for(int i = top; i>=0; i--)
        {
            System.out.println(A[i]);
        }
        System.out.println("Bottom");
    }
}

public class test {
    public static int menu(Stack st)
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("What Operation to be done?");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            try{
                choice = sc.nextInt();
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Value Entered.");
            }
            sc.nextLine();
        }while(true);
        if(choice < 1|| choice>4)
            return 0;
        else 
            return choice;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int size;
        do{
            System.out.println("Enter Size of Stack");
            try{
                size = sc.nextInt();
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Value Entered. Try Again.");
            }
            sc.nextLine();
        }while(true);
        Stack st = new Stack(size);
        do{
            int choice = menu(st);
            if(choice == 1)
            {
                try{
                    st.push();
                }
                catch(FullStackException e)
                {
                    System.out.println("Stack is Full");
                }
            }
            if(choice == 2)
            {
                try{
                    st.pop();
                }
                catch(UserEmptyStackException e)
                {
                    System.out.println("Stack is Empty.");
                }
            }
            if(choice == 3)
            {
                try{
                    st.display();
                }
                catch(UserEmptyStackException e)
                {
                    System.out.println("Stack is Empty.");
                }   
            }
            if(choice == 4)
            {
                break;
            }
            if(choice == 0)
            {
                System.out.println("Wrong Choice Entered. ");
                continue;
            }
        }while(true);
    }    
}
