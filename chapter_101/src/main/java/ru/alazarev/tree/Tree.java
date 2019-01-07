package ru.alazarev.tree;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int modCount = 0;

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

    private Iterator<Node<E>> nodeIterator() {
        return new Iterator<Node<E>>() {
            final Queue<Iterator<Node<E>>> poolIter = new LinkedList<>();
            final long fixedModCount = modCount;
            Iterator<Node<E>> iter = Arrays.asList(root).iterator();

            @Override
            public boolean hasNext() {
                checkMod();
                boolean result = true;
                while (!iter.hasNext()) {
                    if (poolIter.isEmpty()) {
                        result = false;
                        break;
                    }
                    iter = poolIter.poll();
                }
                return result;
            }

            @Override
            public Node<E> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> result = iter.next();
                if (!result.leaves().isEmpty()) {
                    poolIter.add(result.leaves().iterator());
                }
                return result;
            }

            private void checkMod() {
                if (fixedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    /**
     * Метод возвращает итератор значений дерева.
     *
     * @return итератор значений.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Iterator<Node<E>> iter = nodeIterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public E next() {
                return iter.next().getValue();
            }
        };
    }
}
