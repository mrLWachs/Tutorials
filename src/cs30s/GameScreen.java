
/** Required package class namespace */
package cs30s;

/** Required imports */
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * GameScreen.java - Another designer built "form" or "frame". This form is 
 * for the user to play the game. Follow the document instructions to build the
 * design in the designer and name all objects before adding this code.
 *
 * @author Mr. Wachs
 * @since December 2020
 */
public class GameScreen extends javax.swing.JFrame 
{
    
    /** 
     * Default constructor, set class properties, creates new form GameScreen 
     */
    public GameScreen() {
        initComponents();
        start();                    // call a method to continue starting up
    }

    /** 
     * This method is called from within the constructor to initialize the
     * form.
     * 
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        damageRemainingLabel = new javax.swing.JLabel();
        carsPassedLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        topWall = new javax.swing.JLabel();
        driverCar = new javax.swing.JLabel();
        opponentCar = new javax.swing.JLabel();
        rightCurb = new javax.swing.JLabel();
        leftCurb = new javax.swing.JLabel();
        bottomWall = new javax.swing.JLabel();
        centerStripe1 = new javax.swing.JLabel();
        centerStripe2 = new javax.swing.JLabel();
        centerStripe3 = new javax.swing.JLabel();
        centerStripe4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        damageRemainingLabel.setText("Damage Remaiing:");
        getContentPane().add(damageRemainingLabel);
        damageRemainingLabel.setBounds(10, 110, 540, 14);

        carsPassedLabel.setText("Cars Passed:");
        getContentPane().add(carsPassedLabel);
        carsPassedLabel.setBounds(10, 80, 540, 14);

        nameLabel.setText("Name:");
        getContentPane().add(nameLabel);
        nameLabel.setBounds(10, 20, 540, 14);

        timeLabel.setText("Time:");
        getContentPane().add(timeLabel);
        timeLabel.setBounds(10, 50, 540, 14);

        topWall.setBackground(new java.awt.Color(255, 255, 0));
        topWall.setOpaque(true);
        getContentPane().add(topWall);
        topWall.setBounds(0, 0, 560, 150);

        driverCar.setBackground(new java.awt.Color(0, 0, 0));
        driverCar.setOpaque(true);
        getContentPane().add(driverCar);
        driverCar.setBounds(320, 508, 200, 200);

        opponentCar.setBackground(new java.awt.Color(0, 0, 0));
        opponentCar.setOpaque(true);
        getContentPane().add(opponentCar);
        opponentCar.setBounds(60, 250, 150, 150);

        rightCurb.setBackground(new java.awt.Color(255, 255, 0));
        rightCurb.setOpaque(true);
        getContentPane().add(rightCurb);
        rightCurb.setBounds(530, 130, 31, 620);

        leftCurb.setBackground(new java.awt.Color(255, 255, 0));
        leftCurb.setOpaque(true);
        getContentPane().add(leftCurb);
        leftCurb.setBounds(0, 130, 31, 630);

        bottomWall.setBackground(new java.awt.Color(255, 255, 0));
        bottomWall.setOpaque(true);
        getContentPane().add(bottomWall);
        bottomWall.setBounds(0, 730, 560, 30);

        centerStripe1.setBackground(new java.awt.Color(255, 255, 0));
        centerStripe1.setOpaque(true);
        getContentPane().add(centerStripe1);
        centerStripe1.setBounds(260, 10, 36, 130);

        centerStripe2.setBackground(new java.awt.Color(255, 255, 0));
        centerStripe2.setOpaque(true);
        getContentPane().add(centerStripe2);
        centerStripe2.setBounds(260, 200, 36, 130);

        centerStripe3.setBackground(new java.awt.Color(255, 255, 0));
        centerStripe3.setOpaque(true);
        getContentPane().add(centerStripe3);
        centerStripe3.setBounds(260, 390, 36, 130);

        centerStripe4.setBackground(new java.awt.Color(255, 255, 0));
        centerStripe4.setOpaque(true);
        getContentPane().add(centerStripe4);
        centerStripe4.setBounds(260, 580, 36, 130);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        /**********************************************************************
         * NOTE... The code below is accessed by "right clicking" the "form"
         * or "frame" in the designer, then selecting "Events" then "Key", 
         * then selecting "keyPressed [formKeyPressed]"
         *********************************************************************/ 
        
        pressKey(evt);              // Passes the logic to our own method
    }//GEN-LAST:event_formKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bottomWall;
    private javax.swing.JLabel carsPassedLabel;
    private javax.swing.JLabel centerStripe1;
    private javax.swing.JLabel centerStripe2;
    private javax.swing.JLabel centerStripe3;
    private javax.swing.JLabel centerStripe4;
    private javax.swing.JLabel damageRemainingLabel;
    private javax.swing.JLabel driverCar;
    private javax.swing.JLabel leftCurb;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel opponentCar;
    private javax.swing.JLabel rightCurb;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel topWall;
    // End of variables declaration//GEN-END:variables
    
    /**************************************************************************
     * NOTE... For the global variables below, some of them require you to 
     * click on the "light bulb" and "import" those things into your project
     *************************************************************************/
    
    private final int LEFT  = 0;    // Constants representing directions
    private final int RIGHT = 1;        
    
    private int driverDirection;    // Stores the driver's current direction
    
    private int seconds    = 0;     // Stores how many seconds have passed
    private int carsPassed = 0;     // Stores how many cars you have passed
        
    private Timer timer ;           // Timer object (in code) is used to run
    private Timer driverTimer;      // code repetatively (like a loop) but
    private Timer opponentTimer;    // using time (in milliseconds)
    private Timer linesTimer;
    
    private JLabel[] centerLines;   // an array of all center road lines
    
    
    /**
     * Set up some visual elements of the form (frame) when this form first 
     * starts up (appears) - like the "Form_Load" code of Visual Studio
     */
    private void start() {        
        // Call a method for all the timer objects (finish this method code 
        // first, then write that method)
        setTimers();
        
        // Get the position of this object on the form (the x,y and the width
        // and height) from the JLabel object's built in  methods
        int x = driverCar.getX();
        int y = driverCar.getY();
        int w = Globals.vehicle.size;     // This is read from the Globals class
        int h = driverCar.getHeight();
        
        // Now position the car (and size it) on the form
        driverCar.setBounds(x, y, w, h);
        
        // Change the label's color to match what the user had selected and is
        // stored in the Globals class
        driverCar.setBackground(Globals.vehicle.color);
        
        // Add text into the labels based on what is stored in the
        // Globals class
        nameLabel.setText("Name: " + Globals.vehicle.getDriver());
        damageRemainingLabel.setText("Damage Remaining: " + 
                                     Globals.vehicle.damage);
                
        // Build the array to the right size
        centerLines = new JLabel[4];
        
        // Now put the 4 labels from the designer into the array
        centerLines[0] = centerStripe1;
        centerLines[1] = centerStripe2;
        centerLines[2] = centerStripe3;
        centerLines[3] = centerStripe4; 
        
        // Code to setup the frame for display
        this.setSize(575,790);                      // Set frame height/width 
        this.setTitle(Globals.APPLICATION_TITLE);   // Set the form title
        this.setResizable(false);                   // Form not sizable
        this.setLocationRelativeTo(null);           // Center form on screen
        this.setVisible(true);                      // Make form appear to user
        this.setVisible(true);
    }
    
    /**
     * Sets up all the timer objects so they all have the correct delay values
     * (measured in milliseconds) and they all start. For each of these, it
     * is much easier to use IntelliSense (auto-complete, CTRL+SPACE) to help
     * you write it (sometimes you have to hit enter twice to complete the code)
     */
    private void setTimers() {        
        // The timer that counts time in your game in seconds, it uses the
        // constant stored in the Globals class as a "delay" value which means
        // the timer "waits" that number of milliseconds (1000 milliseconds in
        // 1 second of real time) before calling the methos below.
        timer = new Timer(Globals.TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                /**************************************************************
                 * NOTE... The method call below will have to be written by
                 * you WITHOUT using the "light bulb" as it will not do it
                 * correctly - write these after finishing this code first
                 *************************************************************/
                
                tick();
            }
        });
          
        // The timer for our driver's car to move back a forth, it uses
        // the speed stored in the Globals class that was selected in the 
        // vehicle selection screen
        driverTimer = new Timer(Globals.vehicle.speed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driverTick();
            }
        });
        
        // The timer that moves your opponent cars towards you 
        opponentTimer = new Timer(Globals.OPPONENT_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opponentTick();
            }
        });
             
        // The timer that moves the center lines to create a feeling of 
        // movement
        linesTimer = new Timer(Globals.ROAD_LINES_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                linesTick();
            }
        });
          
        // Now start all the timers running
        driverTimer.start();
        linesTimer.start();
        opponentTimer.start();
        timer.start();
    }

    /**
     * This timer's code running on the delay (like a loop), it updates a label
     * and increases the seconds that have passed
     */
    private void tick() {
        seconds++;                                  // increase global variable
        timeLabel.setText("Time: " + seconds);      // update label
    }
    
    /**
     * This timer's code running on the delay (like a loop), it mover the 
     * driver's vehicle back and forth
     */
    private void driverTick() {
        // Pull out the coordinates (x, y, width and height) from the label 
        // using the label's built-in methods
        int x = driverCar.getX();
        int y = driverCar.getY();
        int w = driverCar.getWidth();
        int h = driverCar.getHeight();
        
        // Check which direction the global variable says we should be 
        // moving and adjust the x coordinate to move across the x axis 
        // (horizontally back and forth) by adding or subtracting to that
        // x value
        if      (driverDirection == LEFT)  x = x - Globals.DRIVER_AMOUNT;
        else if (driverDirection == RIGHT) x = x + Globals.DRIVER_AMOUNT;
        
        // Call a method to check for any collisions
        checkCollisions();
        
        // Use a built-in method to now position the label at its new
        // coordinates
        driverCar.setBounds(x, y, w, h);
    }
    
    /**
     * This timer's code running on the delay (like a loop), it moves the 
     * opponent car towards you
     */
    private void opponentTick() {
        // Get all opponent coordinates (x, y, width and height)
        int x = opponentCar.getX();
        int y = opponentCar.getY();
        int w = opponentCar.getWidth();
        int h = opponentCar.getHeight();
        
        // Move the y coordinate and the car "down"
        y = y + Globals.OPPONENT_AMOUNT; 
        
        // Check if the opponent is past the bottom wall
        if (y > bottomWall.getY()) {
            
            // Put the y coordinate back to the top
            y = topWall.getY() - h;
            
            // Pick a random horizontal location
            x = randomX();
            
            // Increase car passed and update label
            carsPassed++;
            carsPassedLabel.setText("Cars Passed: " + carsPassed);
        }
        
        // Now position the opponent car label
        opponentCar.setBounds(x, y, w, h);
    }
      
    /**
     * This timer's code running on the delay (like a loop), it moves the center 
     * lines to create a feeling of movement
     */
    private void linesTick() {        
        // Loop through the entire array
        for (int i = 0; i < centerLines.length; i++) {
            
            // Get a JLabel out of the array for this line
            JLabel line = centerLines[i];
            
            // Now pull out the coordinates (x, y, width and height) from 
            // that label using it's built-in methods
            int x = line.getX();
            int y = line.getY();
            int w = line.getWidth();
            int h = line.getHeight();
            
            // Adjust the y coordinate (to move it "down") by adding a value
            // from the Globals class
            y = y + Globals.ROAD_LINES_AMOUNT; 
            
            // Check if the label has moved off the screen
            if (y > bottomWall.getY()) {
                
                // Put it back at the top
                y = topWall.getY();
            }
            
            // Use a built-in method to now position the label at its new
            // coordinates
            line.setBounds(x, y, w, h);
        }
    }
    
    /**
     * Generates a random x coordinate value for the opponent car label
     * horizontally between the two curbs
     * 
     * @return a random x value
     */
    private int randomX() {
        double seed = Math.random();
        double low  = (double)(leftCurb.getX() + leftCurb.getWidth() + 1);
        double high = (double)(rightCurb.getX() - opponentCar.getWidth() - 1);
        double x = (high - low + 1d) * seed + low;
        return (int)x;
    }
    
    /**
     * When the user presses a key on the keyboard
     * 
     * @param event the keyboard event for the specific key
     */
    private void pressKey(KeyEvent event) {
        // Check which key was preseed
        if (event.getKeyCode() == KeyEvent.VK_LEFT)  {
            driverDirection = LEFT;                 // Set to move left
        }
        else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            driverDirection = RIGHT;                // Set to move right
        }
    }
    
    /**
     * Checks the driver's car for any collisions and reacts to those
     */
    private void checkCollisions() {
        /**********************************************************************
         * NOTE... The "Rectangle" object will have to be imported with the
         * "light bulb" and a method "getHitbox()" we will write. The 
         * rectangle acts as a "hit box" to surround the labels (invisible)
         * and has a built-in method to see if it is colliding (intersecting)
         * with another rectangle
         *********************************************************************/
        Rectangle driverHitbox    = getHitbox(driverCar);
        Rectangle leftCurbHitbox  = getHitbox(leftCurb);
        Rectangle rightCurbHitbox = getHitbox(rightCurb);
        Rectangle opponentHitbox  = getHitbox(opponentCar);
        
        // Check the left and right curbs to see if they are colliding and if
        // they are, change direction
        if (driverHitbox.intersects(leftCurbHitbox)) {
            driverDirection = RIGHT;
        }
        else if (driverHitbox.intersects(rightCurbHitbox)) {
            driverDirection = LEFT;
        }
        
        // check if the driver has hit the opponent
        if (driverHitbox.intersects(opponentHitbox)) {            
            // Take a damage point and update the label
            Globals.vehicle.damage--;
            damageRemainingLabel.setText("Damage Remaining: " + 
                    Globals.vehicle.damage);
            
            // Check if damage has caused the game to end
            if (Globals.vehicle.damage < 0) {
                // Stop all the timers
                driverTimer.stop();
                linesTimer.stop();
                opponentTimer.stop();
                timer.stop();
                // Message the user
                JOptionPane.showMessageDialog(this, "Game over!", 
                        "", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                // Get the opponent coordinates with a random x value and
                // the y coordinate at the top wall and set it into position
                int w = opponentHitbox.width;
                int h = opponentHitbox.height;
                int x = randomX();
                int y = topWall.getY() - h;
                opponentCar.setBounds(x, y, w, h);
            }
        }
    }

    /**
     * Gets a rectangle object from the passed label object to be used for
     * collision detection
     * 
     * @param label the label object to use
     * @return a rectangle object
     */
    private Rectangle getHitbox(JLabel label) {
        int x = label.getX();           // Use built-in label methods
        int y = label.getY();
        int w = label.getWidth();
        int h = label.getHeight();
        Rectangle hitbox = new Rectangle(x,y,w,h);  // create rectangle
        return hitbox;
    }

}
