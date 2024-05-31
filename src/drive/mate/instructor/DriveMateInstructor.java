/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package drive.mate.instructor;

/**
 *
 * @author smbha_t
 */
public class DriveMateInstructor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SplashScreen pb = new SplashScreen();
        pb.setVisible(true);
        try{
            for(int x=0;x<=100;x++){
                Thread.sleep(15);
                pb.lbl.setText(Integer.toString(x)+"%");
                pb.jProgressBar.setValue(x);
            }
            LoginScreen frame = new LoginScreen();
            frame.setVisible(true);
            pb.setVisible(false);
        }catch(InterruptedException ex){
            
        }
        
    }
    
}
