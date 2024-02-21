fun task1() {
    println("Entering task 1: ${Thread.currentThread()}");
    println("Exiting task 1: ${Thread.currentThread()}");
}

fun task2() {
    println("Entering task 2: ${Thread.currentThread()}");
    println("Exiting task 2: ${Thread.currentThread()}");
}

run {
    task1();
    task2();

    println("called the tasks ${Thread.currentThread()}");
}