package ru.alazarev.tictactoe;

import com.google.common.collect.BiMap;
import ru.alazarev.tictactoe.interfaces.IGraphicElement;
import ru.alazarev.tictactoe.interfaces.IOutputPseudographics;
import ru.alazarev.tictactoe.interfaces.ITicTacToe;

/**
 * Class OutputPseudographics решение задачи части 004. 7. Крестики-нолики ООД [#793]
 *
 * @author Aleksey Lazarev
 * @since 26.08.2019
 */
public class OutputPseudographics implements IOutputPseudographics {
    private BiMap<Integer, IGraphicElement> graphicMap;
    private String line = "";

    /**
     * Method print pole square.
     *
     * @param game Current game.
     */
    @Override
    public void printSquare(ITicTacToe game) {
        for (int i = 0; i < game.getPole().length; i++) {
            String forPrint;
            IGraphicElement current = this.graphicMap.get(game.getPole()[i]);
            if (current != null) {
                forPrint = current.elementName();
            } else {
                forPrint = String.valueOf(game.getPole()[i]);
            }
            System.out.print(String.format("%3s | ", forPrint));
            if (i != 0 && (i + 1) % game.getPoleSize() == 0) {
                System.out.println();
                System.out.println(this.line);
            }
        }
        System.out.println();
    }

    /**
     * Method init.
     *
     * @param graphicMap pseudographic objects.
     * @return this object.
     */
    @Override
    public IOutputPseudographics init(BiMap<Integer, IGraphicElement> graphicMap) {
        this.graphicMap = graphicMap;
        XGraphicElement x = new XGraphicElement();
        OGraphicElement o = new OGraphicElement();
        this.graphicMap.put(x.poleSymbol(), x);
        this.graphicMap.put(o.poleSymbol(), o);
        return this;
    }

    /**
     * Method get pseudographic objects.
     *
     * @return graphic map.
     */
    @Override
    public BiMap<Integer, IGraphicElement> getGraphicMap() {
        return this.graphicMap;
    }

    /**
     * Method set divider line.
     *
     * @param line Divider line.
     */
    @Override
    public void setLine(String line) {
        this.line = line;
    }

}
