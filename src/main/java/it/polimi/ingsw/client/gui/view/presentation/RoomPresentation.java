package it.polimi.ingsw.client.gui.view.presentation;

import it.polimi.ingsw.client.gui.GuiAssets;
import it.polimi.ingsw.client.gui.GuiConstants;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * The room gui presentation
 */
public class RoomPresentation extends AbstractPreGamePresentation {

    /**
     * Class constructor, set the assets
     * @param assets The assets
     */
    public RoomPresentation(GuiAssets assets) {
        super(assets);
    }

    /**
     * Generate a presentation of the room view
     * @param width The width
     * @param height The height
     * @param room The room name
     * @param count The room number of people
     * @param start The start text
     * @return The generated pane
     */
    public Pane generatePresentation(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height, Text room, Text count, Text start) {
        styleTitle(room);
        styleTitle(count);
        styleTitle(start);

        StackPane center = new StackPane();
        StackPane bottom = new StackPane();

        VBox statusContainer = new VBox();
        statusContainer.getChildren().add(room);
        statusContainer.getChildren().add(count);
        statusContainer.getChildren().add(start);
        statusContainer.setSpacing(GuiConstants.DEFAULT_SPACING);
        statusContainer.setPadding(new Insets(GuiConstants.DEFAULT_SPACING));
        statusContainer.setFillWidth(true);
        statusContainer.setAlignment(Pos.CENTER);
        center.getChildren().add(statusContainer);

        return super.generatePresentation(width, height, center, bottom);
    }

}
