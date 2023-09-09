
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by mengebrits on 6/7/2017.
 */

public class SnakePart {
    //A SnakePart encapsulates a Rectangle for its position and size, and behaviors for 
    //the getters and setters
    private Rectangle rectangle;
    
    public SnakePart(float x, float y)
    {
        rectangle = new Rectangle(x, y, Constants.SIZE, Constants.SIZE);
    }

    public Rectangle getRectangle()
    { return rectangle; }

    public float getX()
    { return rectangle.x; }

    public float getY()
    { return rectangle.y; }

    public void setX(float x)
    { rectangle.x = x;  }

    public void setY(float y)
    { rectangle.y = y; }

}
