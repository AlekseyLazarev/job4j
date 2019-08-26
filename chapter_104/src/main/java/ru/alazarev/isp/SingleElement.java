package ru.alazarev.isp;


import java.util.ArrayList;
import java.util.List;

/**
 * Class SingleElement решение задачи части 004. 4.1 Создать меню. [#4748].
 *
 * @author Aleksey Lazarev
 * @since 30.06.2019
 */
public class SingleElement implements IElement {
    private static final String itemName = "Задача";
    private final String name;
    private List<IElement> child = new ArrayList<>();
    private String divider = "----";

    /**
     * Constructor.
     *
     * @param name Element name.
     */
    public SingleElement(String name) {
        this.name = name;
    }

    /**
     * Action method.
     */
    @Override
    public void action() {
        System.out.println("TODO action");
    }

    /**
     * Print method.
     */
    @Override
    public void printElement() {
        System.out.println(divider + itemName + " " + this.name);
        if (!this.child.isEmpty()) {
            for (IElement e : this.child) {
                e.printElement();
            }
        }
    }

    /**
     * Method return child of elements.
     *
     * @return Elements list.
     */
    @Override
    public List<IElement> getChild() {
        return this.child;
    }

    /**
     * Method return current element name.
     *
     * @return current element name.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Return divider.
     *
     * @return divider.
     */
    @Override
    public String getDivider() {
        return divider;
    }

    /**
     * Set divider.
     *
     * @param divider divider.
     */
    @Override
    public void setDivider(String divider) {
        this.divider = divider;
    }
}
