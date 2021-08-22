/*
class Foo {
    // AtomicInteger Method
    private AtomicInteger firstDone = new AtomicInteger(0);
    private AtomicInteger secondDone = new AtomicInteger(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone.getAndIncrement();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(firstDone.get()!=1);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone.getAndIncrement();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(secondDone.get()!=1);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
*/

class Foo {
  // Synchronized Method
    private boolean oneDone;
    private boolean twoDone;
    
    public Foo() {
        oneDone = false;
        twoDone = false;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        oneDone = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (!oneDone) {
            wait();
        }
        printSecond.run();
        twoDone = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (!twoDone) {
            wait();
        }
        printThird.run();
    }
}
/*
class Foo {
  //Synchronized on Object:
    private Object lock;
    private boolean oneDone;
    private boolean twoDone;
    
    public Foo() {
        lock = new Object();
        oneDone = false;
        twoDone = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            printFirst.run();
            oneDone = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!oneDone) {
                lock.wait();
            }
            printSecond.run();
            twoDone = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!twoDone) {
                lock.wait();
            }
            printThird.run();
        }
    }
}
*/

/*
class Foo {
  //Synchronized on Two Objects (not needed for this question, just put it here in case someone wants to use one object to protect one variable):
    private Object lock1;
    private Object lock2;
    private boolean oneDone;
    private boolean twoDone;
    
    public Foo() {
        lock1 = new Object();
        lock2 = new Object();
        oneDone = false;
        twoDone = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock1) {
            printFirst.run();
            oneDone = true;
            lock1.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock1) {
            synchronized (lock2) {
                while (!oneDone) {
                    lock1.wait();
                }
                printSecond.run();
                twoDone = true;
                lock2.notifyAll();
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock2) {
            while (!twoDone) {
                lock2.wait();
            }
            printThird.run();
        }
    }
}
*/

/*
class Foo {
  //Semaphore:
    private Semaphore s2;
    private Semaphore s3;
    
    public Foo() {
        s2 = new Semaphore(0);
        s3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        printSecond.run();
        s3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire();
        printThird.run();
    }
}
*/

/*
class Foo {
  //Condition Variable:
    private Lock lock;
    private boolean oneDone;
    private boolean twoDone;
    private Condition one;
    private Condition two;
    
    public Foo() {
        lock = new ReentrantLock();
        one = lock.newCondition();
        two = lock.newCondition();
        oneDone = false;
        twoDone = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            printFirst.run();
            oneDone = true;
            one.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (!oneDone) {
                one.await();
            }
            printSecond.run();
            twoDone = true;
            two.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (!twoDone) {
                two.await();
            }
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}
*/
