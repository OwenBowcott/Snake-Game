import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.*; 
import com.badlogic.gdx.utils.Array; 
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.*; 
/**
 * Created by mengebrits on 6/6/2017.
 */
public class SnakeHead   {
    //A SnakeHead encapsulates a direction it is going, a rectangle for its position and size, 
    // a time which tells it when to move and behaviors to get input, move, getters and setters
    private Direction direction;
    private Rectangle rectangle;
    private long time;
    private Music eat = Gdx.audio.newMusic(Gdx.files.internal("eat.WAV"));
    public SnakeHead()
    {
        direction = Direction.RIGHT;//Direction is an enum, it works kind of similarly to constants
        rectangle = new Rectangle(0, 0, Constants.SIZE, Constants.SIZE);
        time = TimeUtils.nanoTime();
    }

    public void update()
    {
        //depending on which key is pressed and the direction the snake is facing update 
        //the attribute of 'direction'
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && direction != Direction.RIGHT)
        {
            direction = Direction.LEFT;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && direction != Direction.LEFT)
        {
            direction = Direction.RIGHT;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP) && direction != Direction.DOWN)
        {
            direction = Direction.UP;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && direction != Direction.UP)
        {
            direction = Direction.DOWN;
        }

    }

    //This method updates the state of the Rectangle Objects
    //then when we render it will be rendered in the updated position of the Rectanlge object
    //NOTE: the Rectangle object is not visible, we render based on the Rectangle's attributes
    public void move(Array<SnakePart> snakeBody)
    {
        //an Array is similar to our ArrayList class. Google Array libgdx to see the API
        //and all the available methods
        
        //calculate how much time has passed since last movement
        float elapsedSec = MathUtils.nanoToSec * (TimeUtils.nanoTime() - time);
        if(elapsedSec > Constants.SPEED)//if enough time  has passed, move the snake
        {
            //reset time
            time = TimeUtils.nanoTime();//reset the time to the current time
            //hold the current position of the snake head

            //hold the old position of the snake head, before it moves forward
            //You will use these values below
            float tempX = this.rectangle.x;
            float tempY = this.rectangle.y;

            //check how the current position of the head needs to move
            if (direction == Direction.DOWN) {
                rectangle.y -= Constants.SIZE;
            } else if (direction == Direction.UP) {
                rectangle.y += Constants.SIZE;
            } else if (direction == Direction.LEFT) {
                rectangle.x -= Constants.SIZE;
            } else if (direction == Direction.RIGHT) {
                rectangle.x += Constants.SIZE;
            }

            //if there are snake parts
            if(snakeBody.size != 0)
            {
                //TODO: right shift all the elements in snakeBody Array
                // Get the SnakePart object and then call the setX and setY 
                //methods of the SnakePart class to set the x and y values to the 
                //previous SnakePart object's x and y: snakeBody.get(i).setX(.....)
                
                // ex. the snake part at position 2 gets the value of position 1
                // the snake part at position 1 get the value of position 0
                // last, the snake part at position 0 gets the value of the snakeHead
                // before it moved, I already saved these coordinates above in tempX and tempY
                
                //this is similar to how we did a right shift for an array of ints
                //now we are dealing with objects
                //eat.play();
                if(snakeBody.size <= 1)
                {
                    snakeBody.get(0).setX(tempX);
                    snakeBody.get(0).setY(tempY);
                }
                else
                {
                    for(int i = snakeBody.size - 1; i >= 0; i--)
                  {
                    if(i == 0)
                    {
                        snakeBody.get(i).setX(tempX);
                        snakeBody.get(i).setY(tempY);
                    }
                    else
                    {
                        snakeBody.get(i).setX(snakeBody.get(i-1).getX());
                        snakeBody.get(i).setY(snakeBody.get(i-1).getY());
                    }
                  }
                }
            }
        }
    }

    public Direction getDirection()
    { return direction; }

    public Rectangle getRectangle()
    { return rectangle; }

    public float getX()
    { return rectangle.x; }

    public float getY()
    { return rectangle.y; }

    public void setX(float x)
    { rectangle.x = x; }

    public void setY(float y)
    {  rectangle.y = y; }

    public void setDirection(Direction d)
    { direction = d; }
}
