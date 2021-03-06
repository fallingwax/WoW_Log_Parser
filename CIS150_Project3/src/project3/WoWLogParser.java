/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JFileChooser;
import javax.swing.DefaultListModel;


import javax.swing.JOptionPane;
public class WoWLogParser extends JFrame {

    private WoWPlayer[] playerList;
    private long biggestDamage = 0;
    private long biggestHeal = 0;
    private String[] fileNames;
    private int numFiles;
    private int totalRaiders;
    private DefaultListModel logModel;
    
    private BufferedImage bID;
    private BufferedImage bIH;
    
    Graphics gcD;
    Graphics gcH;
    
    @SuppressWarnings("unchecked")
    public WoWLogParser() {
        initComponents();
        
        try{
            loadPlayerList();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "loadPlayuerList() call failed in initialize()", JOptionPane.ERROR_MESSAGE);
        }
        
        // Give some memory to our fileNames array
        fileNames = new String[20];
        
        // Initialize the log list's model
        logModel = new DefaultListModel<String>();
        lvLogList.setModel(logModel);

        bID = new BufferedImage(823, 626, BufferedImage.TYPE_INT_RGB);
        bIH = new BufferedImage(823, 626, BufferedImage.TYPE_INT_RGB);
        
        gcD = bID.getGraphics();
        gcH = bIH.getGraphics();
        
        // Blank them out
        gcD.setColor(Color.BLACK);
        gcH.setColor(Color.BLACK);

        gcD.fillRect(0, 0, 823, 626);
        gcH.fillRect(0, 0, 823, 626);
        
        // Draw a message that says no log files are loaded just yet
        gcD.setFont(new Font("Arial", Font.BOLD, 30));
        gcH.setFont(new Font("Arial", Font.BOLD, 30));
        // Give the font a color
        gcD.setColor(Color.WHITE);
        gcH.setColor(Color.WHITE);
        // Draw the name and damage amount text
        gcD.drawString("No Log Files Loaded!", 250, 300);
        gcH.drawString("No Log Files Loaded!", 250, 300);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLoadLog = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pDamage = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if(bID != null){
                    g.drawImage(bID, 0 , 0, null);
                }
            }
        };
        pHealing = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if(bIH != null){
                    g.drawImage(bIH, 0 , 0, null);
                }
            }

        };
        jScrollPane1 = new javax.swing.JScrollPane();
        lvLogList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLoadLog.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLoadLog.setText("Add Log File");
        btnLoadLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoadLogMouseClicked(evt);
            }
        });

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(823, 626));

        javax.swing.GroupLayout pDamageLayout = new javax.swing.GroupLayout(pDamage);
        pDamage.setLayout(pDamageLayout);
        pDamageLayout.setHorizontalGroup(
            pDamageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 837, Short.MAX_VALUE)
        );
        pDamageLayout.setVerticalGroup(
            pDamageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Damage", pDamage);

        pHealing.setPreferredSize(new java.awt.Dimension(823, 626));

        javax.swing.GroupLayout pHealingLayout = new javax.swing.GroupLayout(pHealing);
        pHealing.setLayout(pHealingLayout);
        pHealingLayout.setHorizontalGroup(
            pHealingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 837, Short.MAX_VALUE)
        );
        pHealingLayout.setVerticalGroup(
            pHealingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Healing", pHealing);

        lvLogList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lvLogListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lvLogList);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project3/cis150p32.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(btnLoadLog, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLoadLog, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void btnLoadLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadLogMouseClicked
        
        // Grab the file path from a FileChooser
        JFileChooser fc = new JFileChooser(".");
        if(fc.showOpenDialog(null) == 0){
        
            // SEE this for log parsing locations
            //https://docs.google.com/spreadsheets/d/1GDUUYzNIbTP484fHzjkvgChuFPnSYYXz8Z_JTV6Mp1o/edit?usp=sharing


            // Scan the ENCOUNTER_START line to see what encounter name we should add to the listview
            // Declare our readers and set them to null
            FileReader fr = null;
            BufferedReader br = null;

            try {

                // Give some memory to our readers.  A BufferedReader will take the FileReader as an input
                fr = new FileReader(fc.getSelectedFile().getAbsolutePath());
                br = new BufferedReader(fr);

                // Create a variable to hold each line
                String logLine;
                // Create a variable to hold our line split up by a delimeter (like a comma or space)
                String[] token;

                // Read each line
                while ((logLine = br.readLine()) != null) {

                    // Split out the line using a comma as a delimiter
                    token = logLine.split(",");

                    // Check to see if our line contains ENCOUNTER_START
                    if (token[0].contains("ENCOUNTER_START")) {

                        // If so, add it to the listview's list using
                        // lvLogList.getItems().add( <STRING> ); Where STRING is replaced by the encounter/boss name
                        logModel.addElement(token[2].replaceAll("\"", ""));

                        // Also add it to our fileNames array and increase our 
                        fileNames[numFiles] = fc.getSelectedFile().getAbsolutePath();
                        numFiles++;
                    }
                }
            } 
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "File error!", "File Error", JOptionPane.ERROR_MESSAGE);
            }
            finally {
                try{
                    br.close();
                    fr.close();
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error closing the files!", "File Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
    }//GEN-LAST:event_btnLoadLogMouseClicked

    private void lvLogListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lvLogListMouseClicked
        resetPlayers();
        
        JList list = (JList)evt.getSource();
        
        try {
            parseLog(fileNames[list.locationToIndex(evt.getPoint())]);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error loading the log file", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lvLogListMouseClicked

    
    public void parseLog(String fileName) throws IOException {

        ////////////////////////////////////
        // NOTE
        // USE 
        // https://docs.google.com/spreadsheets/d/1GDUUYzNIbTP484fHzjkvgChuFPnSYYXz8Z_JTV6Mp1o/edit#gid=0
        // 
        // As a guide for the types of events we are looking for and the value we want to grab from them
        
        // Declare our readers and set them to null
        FileReader fr = null;
        BufferedReader br = null;

        try {
            
            // Give some memory to our readers.  A BufferedReader will take the FileReader as an input
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            

            // We'll need to parse our string twice using different delimiters.   This is because our log is really split into 2 sections: 
            // The timestamp + Action with a space between them
            // The Action (what we care about) is comma delimited and some of the stuff can have valid spaces in it's names so we don't want to token them out
            
            // Variable to hold the line read in
            String logLine;
            
            // Variables to hold our 2 tokenized (split) strings
            String[] token;
            
            // Read every line of the log file until we get a null (meaning the end of the file)
            while((logLine = br.readLine()) != null) {
                
                // Split the line up by commas first and store it in an array
                token = logLine.split(",");

                // Next use the first split string from above to parse out the event name
                // The first string from above should have included the timestamp and even
                String[] eventToken;
                String eventName;
                // Split the line again and see if it's a damage or healing type we want
                eventToken = token[0].split("  ");
                eventName = eventToken[1];
                int eventType = WoWUtilities.getEventType(eventName);
                // Now that we have the event type, put it through our utility function to 
                // see if it's something we can about
                if (eventType == 1 || eventType == 2) {
                    // If so loop through all of our raider names to see who to attribute it to (if anyone)
                    // We will ignore names that aren't in our playerlist
                    
                    String playerName;
                    // All events except the SPELL_ABSORBED event use the same location for names
                    // Because of this we should look at both cases
                    if (eventName.equals("SPELL_ABSORBED") && token.length <= 17) {
                        playerName = token[10].replace("\"", "");
                    } else if (eventName.equals("SPELL_ABSORBED") && token.length > 17) {
                        playerName = token[13].replace("\"", "");
                    } else {
                        playerName = token[2].replace("\"", "");
                    }
                    for (WoWPlayer player : playerList) {
                        // First, remove the backslashes from our names (HINT - use the replace function)
                        // Next, check to see if either of those names match their location in our split up line
                        if (playerName.equals(player.getName())) {
                            // Determine if this is a damage or healing event
                            if (eventType == 1) {
                                // WE FOUND A DAMAGE EVENT
                                // Looking at the output example spreadsheet you can see SWING_DAMAGE_LANDED is special with
                                // regards to the amount position of the other damage types
                                
                                //This is a SWING_DAMAGE_LANDED event, add it's value to our damage count for this player
                                if (eventName.equals("SWING_DAMAGE_LANDED")) {
                                    player.increaseDamageCount(Long.parseLong(token[22]));
                                } else {
                                //This is a damage that isn't SWING_DAMAGE_LANDED, add it's value to our damage count for this player    
                                    player.increaseDamageCount(Long.parseLong(token[25]));
                                }
                                    
                            } else {
                                // WE FOUND A HEALING EVENT
                                // Figure out what number we need to add to the heal count

                                // For SPELL_ABSORBED, we just add the number
                                // This is a SPELL_ABSORBED event, add it's value to our healing count for this player
                                if (eventName.equals("SPELL_ABSORBED") && token.length <= 17) {
                                    player.increaseHealCount(Long.parseLong(token[16]));
                                } else if (eventName.equals("SPELL_ABSORBED") && token.length > 17) {
                                     player.increaseHealCount(Long.parseLong(token[19]));
                                } else {
                                    // FOR SPELL_HEAL and SPELL_PERIODIC_HEAL
                                    // Subtract overhealing from healing to get number
                                    player.increaseHealCount(Long.parseLong(token[25]) - Long.parseLong(token[26]));
                                    
                                }
                                
                            }
                                    
                        }
                                    
                   }
               }              
            }                   
                                
                          
                        
        

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            br.close();
            fr.close();
        }
        
        
        // figure out the largest damage
        // and update the respective attributes so we have number to compare to when drawing the bars
        WoWUtilities.sortWowPlayers("damage", playerList);
       
        for (int i = 0; i < totalRaiders; i++) {
            if (playerList[i].getDamageCount() > biggestDamage) {
                biggestDamage = playerList[i].getDamageCount();
            }
            if (playerList[i].getHealCount() > biggestHeal) {
                biggestHeal = playerList[i].getHealCount();
            }
        } 
           
        // Finally, draw our output
        displayDamageAndHealing();

    }

    // This will reset all of our control variables to their initial state
    // This should be called whenever a new log file is opened
    public void resetPlayers() {

        // Reset the largest damage and heal count
        biggestDamage = 0;
        biggestHeal = 0;

        // Reset the heal and damage counts for all raiders in our playerlist
        for (int i = 0; i < totalRaiders; i++) {
            playerList[i].setDamageCount(0);
            playerList[i].setHealCount(0);
        }

    }

    // This loads the list of player names we will parse
    public void loadPlayerList() throws IOException {

        // The name of the file that has the names we want to parse
        String fileName = "WoWPlayers.txt";
        totalRaiders = 23;

        // Give some memory to our WoWPlayer array so it can hold all of our raiders
        playerList = new WoWPlayer[totalRaiders];
        
        // File reading
        // Read in the file line by line
        FileReader fr = null;
        BufferedReader br = null;

        // Best to put this in a try / catch since we're dealing with files
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String raiderLine;

            // We can either loop through all the lines or since we know the number of players 
            // we can cheat and just read that number of lines
            for (int i = 0; i < totalRaiders; i++) {
                // Read in the line
                raiderLine = br.readLine();
                
                // Create a new WoWPlayer instance within our WoWPlayer Array
                playerList[i] = new WoWPlayer();
                // Set the name of the WoWplayer using the name in the logfile
                playerList[i].setName(raiderLine);
            }
        } catch (Exception ex) {
            // Showing a JOptionPane with an error message
            JOptionPane.showMessageDialog(null, "Error - Player list text file could not be read", "File Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close the Readers
            br.close();
            fr.close();
        }
    }

    
    
        public void displayDamageAndHealing() {

        // Drawing our output on the two tabs
        // For this particular assignment we'll have to do the same task twice since the Healing/Damage canvas controls were not created dynamically
        // Long story short, do the same thing twice, replacing canvas names and function call names only
        // For reference, the damage canvas name is called gcD and the healing canvas name is called gcH
        
        
        ///////////////////////////////
        // DAMAGE
        ///////////////////////////////
        
        // Clear the background with a black rectangle
        // Set the fill color
        gcD.setColor(Color.BLACK);
        // Draw the rectangle
        gcD.fillRect(0, 0, 823, 626);
       
        // Create the 3 Separator lines (blue in my example)
        // Set the stroke color
        gcD.setColor(Color.BLUE);
        // Draw the 3 lines
        gcD.drawLine(180, 0, 180, 626);
        gcD.drawLine(270, 50, 270, 626);
        gcD.drawLine(0, 50, 823, 50);
        
        // Column headers - Name, Damage Amount
        // If you want to get fancy, set the font
        gcD.setFont(new Font("Arial", Font.BOLD, 30));
        // Give the font a color
        gcD.setColor(Color.WHITE);
        // Draw the name and damage amount text
        gcD.drawString("NAME", 5, 40);
        gcD.drawString("DAMAGE AMOUNT", 300, 40);
        
        
        // Now we need to draw the output for each raider we have
        // First, sort the list from Highest Damage -> Lowest Damage
        // I provide a static utility function to do this
        WoWUtilities.sortWowPlayers("damage", playerList);
        
        // Set the font again if you need to resize or change it
        gcD.setFont(new Font("Arial", Font.BOLD, 12));
        
        int i = 1;
        int y = 80;
        // COMPLETE THIS!!!!
        // Loop through all of our raiders
        for (WoWPlayer player : playerList) {
            // Draw the names
            // I added a raider number before the name and I drew it in white
            gcD.setColor(Color.WHITE);
            gcD.drawString(Integer.toString(i) + "." , 5, y);
            
            // Next you get the color of the raider name you are drawing (utility function provided to retrieve color)
            gcD.setColor(WoWUtilities.getRaiderColor(player.getName()));
            
            // And write out the name
            gcD.drawString(player.getName(), 25, y);
            
            // Next print the damage values using the same color
            gcD.drawString(Long.toString(player.getDamageCount()), 190, y);
       
            // Finally draw the bar
            // As a hint, you should figure out how wide a bar you want to make for the top person and then make
            // everyone elses bar a percentage of that max width based on their output ratio
            
            
            long maxWidth = 500;

            long width = ((maxWidth * player.getDamageCount()) / biggestDamage);
            gcD.fillRect(300, y - 15, Math.toIntExact(width) , 20);
                    
            i++;
            y += 23;
        }    

        
        

        ///////////////////////////////
        // HEALING
        ///////////////////////////////
        // This should be identical to the damage output, only on a different tab
        
        // Clear the background with a black rectangle
        // Set the fill color
        gcH.setColor(Color.BLACK);
        // Draw the rectangle
        gcH.fillRect(0, 0, 823, 626);
       
        // Create the 3 Separator lines (blue in my example)
        // Set the stroke color
        gcH.setColor(Color.BLUE);
        // Draw the 3 lines
        gcH.drawLine(180, 0, 180, 626);
        gcH.drawLine(270, 50, 270, 626);
        gcH.drawLine(0, 50, 823, 50);
        
        // Column headers - Name, Damage Amount
        // If you want to get fancy, set the font
        gcH.setFont(new Font("Arial", Font.BOLD, 30));
        // Give the font a color
        gcH.setColor(Color.WHITE);
        // Draw the name and damage amount text
        gcH.drawString("NAME", 5, 40);
        gcH.drawString("HEALING AMOUNT", 300, 40);
        
        
        // Now we need to draw the output for each raider we have
        // First, sort the list from Highest Damage -> Lowest Damage
        // I provide a static utility function to do this
        WoWUtilities.sortWowPlayers("healing", playerList);
        
        // Set the font again if you need to resize or change it
        gcH.setFont(new Font("Arial", Font.BOLD, 12));
        
        i = 1;
        y = 80;
        // COMPLETE THIS!!!!
        // Loop through all of our raiders
        for (WoWPlayer player : playerList) {
            
            // Draw the names
            // I added a raider number before the name and I drew it in white
            gcH.setColor(Color.WHITE);
            gcH.drawString(Integer.toString(i) + "." , 5, y);
            
            // Next you get the color of the raider name you are drawing (utility function provided to retrieve color)
            gcH.setColor(WoWUtilities.getRaiderColor(player.getName()));
            // And write out the name
            gcH.drawString(player.getName(), 25, y);
            
            // Next print the healing values using the same color
            gcH.drawString(Long.toString(player.getHealCount()), 190, y);
       
            // Finally draw the bar
            // As a hint, you should figure out how wide a bar you want to make for the top person and then make
            // everyone elses bar a percentage of that max width based on their output ratio
            long maxWidth = 500;

            long width = ((maxWidth * player.getHealCount()) / biggestHeal);
            gcH.fillRect(300, y - 15, Math.toIntExact(width) , 20);
                    
            i++;
            y += 23;

        }
        
        //for a repaint
        pDamage.repaint();
        pHealing.repaint();
           
    } 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadLog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> lvLogList;
    private javax.swing.JPanel pDamage;
    private javax.swing.JPanel pHealing;
    // End of variables declaration//GEN-END:variables
}
