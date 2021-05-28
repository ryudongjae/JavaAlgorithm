package datastructure.queue;

public interface QueueInterface<E>{

    boolean offer(E e);

    E poll();

    E peek();

}
