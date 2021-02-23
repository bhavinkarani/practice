package nl.ing.api.cash.order.temp.jv.adn;

import java.util.Stack;

public class Solution {

    public static void main(String args[]){
        Solution sol1=new Solution();
        sol1.push(5);
        sol1.push(2);                    // stack: [5,2]
        assert sol1.top() == 2;
        sol1.pop();                      // stack: [5]
        assert sol1.top() == 5;

        Solution sol2 = new Solution();
        assert sol2.top() == 0;         // top of an empty stack is 0
        sol2.pop();


        Solution sol = new Solution();
        /*sol.push(4);
        sol.begin();                    // start transaction 1
        sol.push(7);                    // stack: [4,7]
        sol.begin();                    // start transaction 2
        sol.push(2);                    // stack: [4,7,2]
        assert sol.rollback() == true;  // rollback transaction 2
        assert sol.top() == 7;          // stack: [4,7]
        sol.begin();                    // start transaction 3
        sol.push(10);                   // stack: [4,7,10]
        assert sol.commit() == true;    // transaction 3 is committed
        assert sol.top() == 10;
        assert sol.rollback() == true;  // rollback transaction 1
        assert sol.top() == 4;          // stack: [4]
        assert sol.commit() == false;   // there is no open transaction*/

        sol.push(4);
        sol.begin();                    // start transaction 1
        sol.push(7);
        sol.push(3);
        sol.begin();
        sol.push(4);
        sol.pop();
        sol.pop();
        sol.pop();
        System.out.println(sol.top());




    }
    Stack<Integer> s;
    Stack<Solution> transactions;
    Solution(){
        s = new Stack();

        transactions = new Stack<Solution>();
        transactions.push(this);
    }

    public void pop() {
        Solution transaction = transactions.peek();
        if(transaction.s.size()>0) transaction.s.pop();
        else transaction.pop();
    }
    public int top() {
        Solution transaction = transactions.peek();
        return transaction.s.empty() ? 0 : transaction.s.peek();
    }
    public void push(int value) {
        Solution transaction = transactions.peek();
        transaction.s.push(value);
    }

    public void begin() {
        Solution newTransaction = new Solution();
        //newTransaction.s = (Stack<Integer>) s.clone();
        newTransaction.s.addAll(s);
        transactions.add(newTransaction);
    }

    public boolean rollback() {
        Solution lastTransaction = transactions.peek();
        if (lastTransaction != this) {
            transactions.pop();
            return true;
        }
        return false;
    }

    public boolean commit() {
        Solution lastTransaction = transactions.peek();
        if (lastTransaction != this) {
            lastTransaction = transactions.pop();
            Solution secondLastTransaction = transactions.peek();
            secondLastTransaction.s = lastTransaction.s;
            return true;
        }
        return false;
    }
}
