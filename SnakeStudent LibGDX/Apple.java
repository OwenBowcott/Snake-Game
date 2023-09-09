import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.*; 
import com.badlogic.gdx.utils.Array; 
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.*; 
/**
 * Created by mengebrits on 6/7/2017.
 */

public class Apple {
    //Apple object encapsulate a Rectangle for its position and size and a spawnApple
    //behavior for when the snake has eaten the apple, getters, and setters
    private Rectangle rectangle;
    private Music eat = Gdx.audio.newMusic(Gdx.files.internal("eat.WAV"));
    public boolean firstTime = true;

    public Apple()
    {
        rectangle = new Rectangle(0,0,Constants.SIZE, Constants.SIZE); 
        spawnApple();
    }
    
    public void first()
    {
        firstTime = true;
    }

    public void spawnApple()
    {
        //TODO: generate a random x and y that lands on a bottom left corner of the grid
        //and then assign rectangle.x and rectangle.y to those values
        if(firstTime == true)
        {
            firstTime = false;
        }
        else
        {
            eat.play();
        }
        int widthVal = Constants.WORLD_WIDTH / 20;
        int width = (int) (Math.random() * ((widthVal)));//maybe 20
        width *= 20;
        int heightVal = Constants.WORLD_HEIGHT / 20;
        int height = (int) (Math.random() * ((heightVal)));//maybe 20
        height *= 20;
        //DELETE the 2 lines below once you complete the above
        rectangle.x = width; 
        rectangle.y = height; 
        //you can modify this even more to have a parameter of type Array<SnakeBody> 
        //to make sure it does not spawn on the snake

    }

    public Rectangle getRectangle()
    { return rectangle; }

    public void setX(float x)
    { rectangle.x = x; }

    public void setY(float y)
    { rectangle.y = y; }
}
