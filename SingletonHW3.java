import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SingletonHW3 {
   private static Random rand = new Random();
   
      /* MAKE THIS A SINGLETON */
      private static class NewFrame extends JFrame implements ActionListener {
    	  private static NewFrame singleton = null;
    	  public NewFrame()
    	  {
                this.setPreferredSize(new Dimension (200,200));
                this.setLocation(500+rand.nextInt(524), 500+rand.nextInt(168));
                JLabel jl = new JLabel ("Make this pop-up a singleton.");
                JButton open = new JButton("Close");
                open.addActionListener(this);        
                add (jl);
                add(open);
                this.pack();
                setVisible(true);
    	  }
        
        /* HINT: ADD A STATIC METHOD IF YOU NEED ONE */

	public void actionPerformed(ActionEvent event)
	{
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

                
	}
   }
      private static class AppFrame extends JFrame implements ActionListener {
	public AppFrame()
	{
                this.setPreferredSize(new Dimension (400,400));
                
                JPanel jp = new JPanel();
                JLabel jl = new JLabel ("This button should create an instance if, and only if, there isn't already one.");
		JButton jb = new JButton("New Window");
	        jb.addActionListener(this);	
          
                jp.add(jl);
                jp.add(jb);
                
                this.add(jp);
                this.pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event)
	{
            /* HINT: YOU LIKELY WANT TO MODIFY THIS */
		if(NewFrame.singleton == null){
            NewFrame.singleton = new NewFrame();             
		}
	}
   }
   
    public static void main(String[] args) {

        
        AppFrame af = new AppFrame(); 
  

    }

}