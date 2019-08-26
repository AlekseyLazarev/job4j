package ru.alazarev.isp;

import java.util.*;

/**
 * Class Menu решение задачи части 004. 4.1 Создать меню. [#4748].
 *
 * @author Aleksey Lazarev
 * @since 29.06.2019
 */
public class Menu implements IMenu {
    List<IElement> elements = new ArrayList<>();

    /**
     * Method adding element into menu.
     *
     * @param element Adding element.
     * @param parent  Parent element.
     */
    @Override
    public void addElement(IElement element, IElement parent) {
        Queue<IElement> queue = new LinkedList<>();
        if (parent == null) {
            this.elements.add(element);
        } else {
            queue.addAll(this.elements);
            while (queue.size() != 0) {
                IElement current = queue.peek();
                if (current == parent) {
                    element.setDivider(element.getDivider() + current.getDivider());
                    current.getChild().add(element);
                    break;
                } else {
                    queue.addAll(queue.poll().getChild());
                }
            }
        }
    }

    /**
     * Method print element.
     */
    @Override
    public void printElements() {
        for (IElement el : this.elements) {
            el.printElement();
        }
    }

    /**
     * Method return find element.
     *
     * @param number Element number.
     * @return IElement.
     */
    @Override
    public IElement finder(String number) {
        Queue<IElement> queue = new LinkedList<>();
        queue.addAll(this.elements);
        IElement res = null;
        while (queue.size() != 0) {
            if (queue.peek().getName() == number) {
                res = queue.poll();
                break;
            } else {
                queue.addAll(queue.poll().getChild());
            }
        }
        return res;
    }
}
