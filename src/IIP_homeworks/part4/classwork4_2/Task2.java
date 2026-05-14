package IIP_homeworks.part4.classwork4_2;

public class Task2 {
    static class Account {
        public int id;
        public int balance;

        public Account(int id, int balance) {
            this.id = id;
            this.balance = balance;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public int getId() {
            return id;
        }

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {
            balance -= amount;
        }

        public void deposit(int amount) {
            balance += amount;
        }
    }

    static void transferDeadlock(Account from, Account to, int amount) {
        synchronized (from) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }

            synchronized (to) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    static void transferSafe(Account from, Account to, int amount) {
        Account first = from.id < to.id ? from : to;
        Account second = from.id < to.id ? to : from;

        synchronized (first) {
            synchronized (second) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account A = new Account(1, 500);
        Account B = new Account(2, 500);

        Thread t1 = new Thread(() -> transferDeadlock(A, B, 100));
        Thread t2 = new Thread(() -> transferDeadlock(B, A, 200));
        t1.start();
        t2.start();
        //t1.join();
        //t2.join();
        Thread.sleep(2000);
        System.out.println("Deadlock: A=" + A.balance + " B=" + B.balance);

        Account C = new Account(1, 500);
        Account D = new Account(2, 500);

        Thread t3 = new Thread(() -> transferSafe(C, D, 100));
        Thread t4 = new Thread(() -> transferSafe(D, C, 200));

        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println(C.balance + " " + D.balance);

    }
}
