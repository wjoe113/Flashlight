package flashlight;

import sofia.graphics.RectangleShape;
import sofia.graphics.OvalShape;
import android.view.MotionEvent;
import sofia.graphics.Color;
import sofia.app.ShapeScreen;

// -------------------------------------------------------------------------
/**
 * This is a rave application. Makes for an awsome party.
 *
 * @author Joe
 * @version 2012.10.05
 */

public class FlashlightScreen
    extends ShapeScreen
{
    private OvalShape oval;


    /**
     * This function is called at the start of the application. This sets up the
     * 4 color options.
     */
    public void initialize()
    {
        this.setBackgroundColor(Color.black);

        // White box
        RectangleShape whiteBox = new RectangleShape(0, 0, 25, 25);
        whiteBox.setFilled(true);
        whiteBox.setColor(Color.white);
        this.add(whiteBox);

        // Red box
        RectangleShape redBox =
            new RectangleShape(this.getWidth() - 25, 0, this.getWidth(), 25);
        redBox.setFilled(true);
        redBox.setColor(Color.red);
        this.add(redBox);

        // Green Box
        RectangleShape greenBox =
            new RectangleShape(0, this.getHeight() - 25, 25, this.getHeight());
        greenBox.setFilled(true);
        greenBox.setColor(Color.green);
        this.add(greenBox);

        // Blue box
        RectangleShape blueBox =
            new RectangleShape(
                this.getWidth() - 25,
                this.getHeight() - 25,
                this.getWidth(),
                this.getHeight());
        blueBox.setFilled(true);
        blueBox.setColor(Color.blue);
        this.add(blueBox);

    }


    /**
     * When the oval comes into contact with a color option.
     *
     * @param oval1
     *            The oval that is moving on the screen.
     * @param rectangle
     *            The color option.
     */
    public void onCollisionBetween(OvalShape oval1, RectangleShape rectangle)
    {
        this.oval.animate(500).color(rectangle.getColor()).play();
    }


    /**
     * When the user presses and moves up.
     *
     * @param e
     *            the Mouse event.
     */
    public void onTouchUp(MotionEvent e)
    {
        this.oval.animate(500).alpha(0).removeWhenComplete().play();

    }


    /**
     * When the user presses and moves down.
     *
     * @param e
     *            the Mouse event.
     */
    public void onTouchDown(MotionEvent e)
    {
        this.oval = new OvalShape(e.getX(), e.getY(), 50);
        this.oval.setFilled(true);
        this.oval.setColor(Color.white);
        this.add(oval);
    }


    /**
     * When the user presses.
     *
     * @param e
     *            the Mouse event.
     */
    public void onTouchMove(MotionEvent e)
    {
        this.oval.setPosition(e.getX() - 50, e.getY() - 50);

    }

}
