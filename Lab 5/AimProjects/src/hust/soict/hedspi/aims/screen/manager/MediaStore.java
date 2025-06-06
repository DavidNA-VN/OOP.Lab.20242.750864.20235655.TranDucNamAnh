package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;

  
import javax.swing.border.Border;  
import javax.swing.BorderFactory;  
import java.awt.*;  

import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Media;

public class MediaStore extends JPanel {  
    private Media media;  

    public MediaStore(Media media) {  
        this.media = media;  
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  

        JLabel title = new JLabel(media.getTitle());  
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));  
        title.setAlignmentX(CENTER_ALIGNMENT);  

        JLabel cost = new JLabel("" + media.getCost() + " $");  
        cost.setAlignmentX(CENTER_ALIGNMENT);  

        JPanel container = new JPanel();  
        container.setLayout(new FlowLayout(FlowLayout.CENTER));  

        if (media instanceof Playable) {  
            JButton playButton = new JButton("Play");  
            container.add(playButton);  
        }  

        this.add(Box.createVerticalGlue());  
        this.add(title);  
        this.add(cost);  
        this.add(Box.createVerticalGlue());  
        this.add(container);  

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));  
    }  
}  