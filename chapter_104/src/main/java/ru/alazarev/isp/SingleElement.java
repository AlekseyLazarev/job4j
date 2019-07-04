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
    private final String name;
    private List<IElement> elements = new ArrayList<>();
    private final int lvl;
    private static final String DEVIDER = "----";
    private int currentId = 0;
    private static int id = 0;

    /**
     * Constructor.
     *
     * @param name Element name.
     * @param lvl  The location of the element in the structure
     */
    public SingleElement(String name, int lvl) {
        this.name = name;
        this.lvl = lvl;
    }

    /**
     * Method set current id.
     *
     * @param currentId Current id value.
     */
    @Override
    public void setCurrentId(int currentId) {
        this.currentId = currentId;
    }

    /**
     * Method add element into list.
     *
     * @param element Element object.
     */
    @Override
    public void addElement(IElement element) {
        if (element.getLvl() == this.lvl + 1) {
            element.setCurrentId(++id);
            this.elements.add(element);
        } else if (!this.elements.isEmpty()) {
            for (IElement e : this.elements) {
                e.addElement(element);
            }
        }
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
        String forPrint = "";
        for (int i = 0; i < this.lvl; i++) {
            forPrint += DEVIDER;
        }
        System.out.println(forPrint + this.name);
        if (!this.elements.isEmpty()) {
            for (IElement e : this.elements) {
                e.printElement();
            }
        }
    }

    /**
     * Method get current lvl.
     *
     * @return current lvl.
     */
    @Override
    public int getLvl() {
        return this.lvl;
    }

    /**
     * Method find element by id.
     *
     * @param id Digital id.
     * @return IElement object.
     */
    @Override
    public IElement finder(int id) {
        IElement result = null;
        if (this.currentId == id) {
            result = this;
        } else {
            if (!this.elements.isEmpty()) {
                int i = 0;
                while (result == null && i < this.elements.size()) {
                    result = this.elements.get(i).finder(id);
                    i++;
                }
            }
        }
        return result;
    }
}
