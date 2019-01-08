package ru.alazarev.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int modCount = 0;
    int treeSize = 0;

    public Tree(E root) {
        if (root != null) {
            this.root = new Node<>(root);
        }

    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (child != null && parent != null) {
            Optional<Node<E>> findParent = findBy(parent);
            if (findParent != null) {
                result = true;
                findParent.get().add(new Node<>(child));
                this.modCount++;
                this.treeSize++;
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public Queue<Node<E>> queue = new LinkedList<>();
            int position = 0;
            Node<E> currentRoot;


            @Override
            public boolean hasNext() {
                boolean result = false;
                if (position <= treeSize) {
                    result = true;
                }
                return result;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (position == 0) {
                    queue.add(root);
                }
                currentRoot = queue.poll();
                position++;
                if (!currentRoot.leaves().isEmpty()) {
                    for (int index = 0; index < currentRoot.leaves().size(); index++) {
                        queue.add(currentRoot.leaves().get(index));
                    }
                }

                return currentRoot.getValue();
            }
        };
    }

    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> queue = new LinkedList<>();
        Node<E> currentRoot = root;
        for (int indexTree = 0; indexTree < treeSize; indexTree++) {
            queue.add(currentRoot);
            currentRoot = queue.poll();
            if (!currentRoot.leaves().isEmpty()) {
                for (int index = 0; index < currentRoot.leaves().size(); index++) {
                    queue.add(currentRoot.leaves().get(index));
                }
            }
            if (currentRoot.leaves().size() > 2) {
                result = false;
                break;
            }
        }
        return result;
    }
}
