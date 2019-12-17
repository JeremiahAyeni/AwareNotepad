/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aware;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.datatransfer.Clipboard;
import java.awt.event.TextEvent;
import java.awt.print.PrinterException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author Ayeni jeremiah
 */
public class AwareFirstInterface extends javax.swing.JFrame {
    UndoManager undo = new UndoManager();//to implement undo
      
   

    public static int count;
    int xmouse, ymouse;
    Music mc = new Music();

    //code for notepad
    String programName = "Notepad";
    String filename = "";
    String holdText;
    String fn;
    String dir;
    boolean textchanged = false;
    String fileName;
    Clipboard clip = getToolkit().getSystemClipboard();
    //end of code for notepad

    
    
    /**
     * Creates new form AwareFirstInterface
     */
    public AwareFirstInterface() {
        initComponents();
    textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    public void undoableEditHappened(UndoableEditEvent e) {
                        undo.addEdit(e.getEdit());
                }
});
    
    }

    public void checkfile() throws IOException {
        BufferedReader read;
        StringBuffer sb = new StringBuffer();
        try {
            read = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = read.readLine()) != null) {
                sb.append(line).append("\n");
            }
            textArea.setText(sb.toString());
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not Found");
        } catch (IOException ioe) {
        }
    }

    class Music {

        FileInputStream FIS;
        BufferedInputStream BIS;

        public Player Player;

        public long PauseLocation;
        public long SongTotalLenght;

        public String FileLocation;

        public void Stop() {
            if (Player != null) {
                Player.close();
                PauseLocation = 0;
                SongTotalLenght = 0;
                Display.setText("");
            }
        }

        public void Pause() {
            if (Player != null) {
                try {
                    PauseLocation = FIS.available();
                    Player.close();
                } catch (IOException ex) {
                    Logger.getLogger(AwareFirstInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        public void Resume() {
            try {

                FIS = new FileInputStream(FileLocation);
                BIS = new BufferedInputStream(FIS);

                Player = new Player(BIS);

                FIS.skip(SongTotalLenght - PauseLocation);

            } catch (FileNotFoundException | JavaLayerException ex) {
                System.out.println("bayub");
            } catch (IOException ex) {
                Logger.getLogger(AwareFirstInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            new Thread() {

                @Override
                public void run() {

                    try {
                        Player.play();
                    } catch (JavaLayerException ex) {
                        Logger.getLogger(AwareFirstInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }.start();
        }

        public void play(String path) {
            try {
                FIS = new FileInputStream(path);
                BIS = new BufferedInputStream(FIS);
                Player = new Player(BIS);

                SongTotalLenght = FIS.available();
                FileLocation = path + "";
            } catch (FileNotFoundException | JavaLayerException ex) {
            } catch (IOException ex) {
                Logger.getLogger(AwareFirstInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            new Thread() {
                @Override
                public void run() {
                    try {
                        Player.play();
                        if (Player.isComplete() && count == 1) {
                            play(FileLocation);
                        }
                        if (Player.isComplete()) {
                            Display.setText("");
                        }
                    } catch (JavaLayerException ex) {
                    }
                }

            }.start();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Undo = new javax.swing.JMenuItem();
        Redo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        SelectAll = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Cut = new javax.swing.JMenuItem();
        Copy = new javax.swing.JMenuItem();
        Paste = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        SaveP = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        Format = new javax.swing.JMenu();
        Fonts = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        ColorP = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        Import = new javax.swing.JMenu();
        ImagesImp = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        Date = new javax.swing.JMenuItem();
        jDialog1 = new javax.swing.JDialog();
        ColorChooser = new javax.swing.JColorChooser();
        font = new javax.swing.JButton();
        ColourPalette = new javax.swing.JButton();
        Find = new javax.swing.JButton();
        Print = new javax.swing.JButton();
        SaveAs = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        LoopCaution = new javax.swing.JTextField();
        Display = new javax.swing.JTextField();
        choose = new javax.swing.JLabel();
        pause = new javax.swing.JLabel();
        stop = new javax.swing.JLabel();
        repeat = new javax.swing.JLabel();
        Play = new javax.swing.JLabel();
        recent = new javax.swing.JLabel();
        open = new javax.swing.JLabel();
        New = new javax.swing.JLabel();
        facebook = new javax.swing.JLabel();
        twitter = new javax.swing.JLabel();
        wordpress = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        minimise = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        movable = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        Undo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        Undo.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 12)); // NOI18N
        Undo.setForeground(new java.awt.Color(51, 0, 153));
        Undo.setText("Undo");
        Undo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Undo);

        Redo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        Redo.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 12)); // NOI18N
        Redo.setForeground(new java.awt.Color(51, 0, 153));
        Redo.setText("Redo");
        Redo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedoActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Redo);
        jPopupMenu1.add(jSeparator1);

        SelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        SelectAll.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 12)); // NOI18N
        SelectAll.setForeground(new java.awt.Color(51, 0, 153));
        SelectAll.setText("Select All");
        SelectAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectAllActionPerformed(evt);
            }
        });
        jPopupMenu1.add(SelectAll);
        jPopupMenu1.add(jSeparator2);

        Cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        Cut.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 12)); // NOI18N
        Cut.setForeground(new java.awt.Color(51, 0, 153));
        Cut.setText("Cut");
        Cut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Cut);

        Copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Copy.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 12)); // NOI18N
        Copy.setForeground(new java.awt.Color(51, 0, 153));
        Copy.setText("Copy");
        Copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Copy);

        Paste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        Paste.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 12)); // NOI18N
        Paste.setForeground(new java.awt.Color(51, 0, 153));
        Paste.setText("Paste");
        Paste.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Paste);
        jPopupMenu1.add(jSeparator3);

        SaveP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SaveP.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 12)); // NOI18N
        SaveP.setForeground(new java.awt.Color(51, 0, 153));
        SaveP.setText("Save");
        SaveP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SaveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavePActionPerformed(evt);
            }
        });
        jPopupMenu1.add(SaveP);
        jPopupMenu1.add(jSeparator4);

        Format.setForeground(new java.awt.Color(51, 0, 153));
        Format.setText("Format");
        Format.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 12)); // NOI18N

        Fonts.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK));
        Fonts.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 12)); // NOI18N
        Fonts.setForeground(new java.awt.Color(51, 0, 153));
        Fonts.setText("Fonts");
        Fonts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Fonts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FontsActionPerformed(evt);
            }
        });
        Format.add(Fonts);
        Format.add(jSeparator7);

        ColorP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        ColorP.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 12)); // NOI18N
        ColorP.setForeground(new java.awt.Color(51, 0, 153));
        ColorP.setText("Colour");
        ColorP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ColorP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorPActionPerformed(evt);
            }
        });
        Format.add(ColorP);

        jPopupMenu1.add(Format);
        jPopupMenu1.add(jSeparator6);

        Import.setForeground(new java.awt.Color(51, 0, 153));
        Import.setText("Import");
        Import.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 12)); // NOI18N

        ImagesImp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        ImagesImp.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 12)); // NOI18N
        ImagesImp.setForeground(new java.awt.Color(51, 0, 153));
        ImagesImp.setText("Picture");
        ImagesImp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ImagesImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImagesImpActionPerformed(evt);
            }
        });
        Import.add(ImagesImp);
        Import.add(jSeparator5);

        Date.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        Date.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 12)); // NOI18N
        Date.setForeground(new java.awt.Color(51, 0, 153));
        Date.setText("Date");
        Date.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateActionPerformed(evt);
            }
        });
        Import.add(Date);

        jPopupMenu1.add(Import);

        jDialog1.getContentPane().setLayout(null);
        jDialog1.getContentPane().add(ColorChooser);
        ColorChooser.setBounds(0, 0, 420, 300);
        ColorChooser.setBounds(160, 150, 420, 300);

        jDialog1.setLocationByPlatform(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A-Ware Notepad");
        setBackground(new java.awt.Color(51, 51, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setForeground(new java.awt.Color(102, 102, 255));
        setMinimumSize(new java.awt.Dimension(719, 469));
        setUndecorated(true);
        getContentPane().setLayout(null);

        font.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 11)); // NOI18N
        font.setForeground(new java.awt.Color(51, 0, 153));
        font.setText("Font");
        font.setBorder(null);
        font.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontActionPerformed(evt);
            }
        });
        getContentPane().add(font);
        font.setBounds(800, 570, 70, 20);

        ColourPalette.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 11)); // NOI18N
        ColourPalette.setForeground(new java.awt.Color(51, 0, 153));
        ColourPalette.setText("Colour Palette");
        ColourPalette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColourPaletteActionPerformed(evt);
            }
        });
        getContentPane().add(ColourPalette);
        ColourPalette.setBounds(670, 570, 120, 20);

        Find.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 11)); // NOI18N
        Find.setForeground(new java.awt.Color(51, 0, 153));
        Find.setText("Find");
        Find.setBorder(null);
        Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindActionPerformed(evt);
            }
        });
        getContentPane().add(Find);
        Find.setBounds(330, 570, 70, 20);

        Print.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 11)); // NOI18N
        Print.setForeground(new java.awt.Color(51, 0, 153));
        Print.setText("Print");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });
        getContentPane().add(Print);
        Print.setBounds(410, 570, 70, 20);

        SaveAs.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 11)); // NOI18N
        SaveAs.setForeground(new java.awt.Color(51, 0, 153));
        SaveAs.setText("Save As..");
        SaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAsActionPerformed(evt);
            }
        });
        getContentPane().add(SaveAs);
        SaveAs.setBounds(570, 570, 90, 20);

        Save.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 11)); // NOI18N
        Save.setForeground(new java.awt.Color(51, 0, 153));
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        getContentPane().add(Save);
        Save.setBounds(490, 570, 70, 20);

        LoopCaution.setEditable(false);
        LoopCaution.setBackground(new java.awt.Color(0, 0, 0));
        LoopCaution.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        LoopCaution.setForeground(new java.awt.Color(153, 0, 0));
        LoopCaution.setBorder(null);
        LoopCaution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoopCautionActionPerformed(evt);
            }
        });
        getContentPane().add(LoopCaution);
        LoopCaution.setBounds(0, 550, 50, 20);
        LoopCaution.setVisible(false);

        Display.setEditable(false);
        Display.setBackground(new java.awt.Color(0, 0, 0));
        Display.setFont(new java.awt.Font("Kravitz Extra Thermal", 0, 11)); // NOI18N
        Display.setForeground(new java.awt.Color(153, 0, 0));
        Display.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Display.setBorder(null);
        Display.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplayActionPerformed(evt);
            }
        });
        getContentPane().add(Display);
        Display.setBounds(10, 400, 190, 20);

        choose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseMouseClicked(evt);
            }
        });
        getContentPane().add(choose);
        choose.setBounds(134, 510, 30, 40);

        pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pauseMouseClicked(evt);
            }
        });
        getContentPane().add(pause);
        pause.setBounds(104, 510, 30, 40);

        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopMouseClicked(evt);
            }
        });
        getContentPane().add(stop);
        stop.setBounds(74, 510, 30, 40);

        repeat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repeatMouseClicked(evt);
            }
        });
        getContentPane().add(repeat);
        repeat.setBounds(50, 510, 20, 40);

        Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayMouseClicked(evt);
            }
        });
        getContentPane().add(Play);
        Play.setBounds(80, 434, 50, 60);
        getContentPane().add(recent);
        recent.setBounds(20, 290, 120, 40);

        open.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openMouseClicked(evt);
            }
        });
        getContentPane().add(open);
        open.setBounds(20, 240, 100, 40);

        New.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewMouseClicked(evt);
            }
        });
        getContentPane().add(New);
        New.setBounds(20, 200, 100, 30);

        facebook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(facebook);
        facebook.setBounds(760, 4, 20, 20);

        twitter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(twitter);
        twitter.setBounds(780, 4, 20, 20);

        wordpress.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(wordpress);
        wordpress.setBounds(804, 4, 20, 20);

        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(home);
        home.setBounds(830, 10, 20, 20);

        minimise.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimiseMouseClicked(evt);
            }
        });
        getContentPane().add(minimise);
        minimise.setBounds(860, 0, 10, 30);

        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(874, 4, 20, 20);

        movable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        movable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                movableMouseDragged(evt);
            }
        });
        movable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                movableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                movableMouseReleased(evt);
            }
        });
        getContentPane().add(movable);
        movable.setBounds(0, 0, 910, 30);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setBorder(null);
        textArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textAreaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                textAreaMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textAreaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                textAreaMouseReleased(evt);
            }
        });
        textArea.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                textAreaPropertyChange(evt);
            }
        });
        textArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textAreaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textAreaKeyTyped(evt);
            }
        });
        textArea.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                textAreaVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(textArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(210, 60, 690, 490);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aware/pics/graphic-white-grid-wallppaer-for-graphic - Copy.jpg"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 560, 700, 30);

        background.setBackground(new java.awt.Color(0, 0, 0));
        background.setForeground(new java.awt.Color(153, 0, 0));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aware/pics/new aware interface.png"))); // NOI18N
        background.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(background);
        background.setBounds(0, 0, 906, 594);

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(908, 594));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void movableMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movableMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xmouse, y - ymouse);
    }//GEN-LAST:event_movableMouseDragged

    private void movableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movableMouseReleased

    }//GEN-LAST:event_movableMouseReleased

    private void movableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movableMousePressed
        xmouse = evt.getX();
        ymouse = evt.getY();
    }//GEN-LAST:event_movableMousePressed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        if ("".equals(textArea.getText())) {
            System.exit(0);
        } else if (!textchanged) {
            System.exit(0);
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Do you want to quit without saving?", "Save?", JOptionPane.YES_NO_CANCEL_OPTION);
            if (confirm == JOptionPane.NO_OPTION) {
                if (filename.equals("")) {
                    saveAs();
                } else {
                    save(filename);
                }
            }
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }//GEN-LAST:event_exitMouseClicked
    public void Newfile() {
   
    if(textArea.getText().length() < 1)
        {
            setTitle("Untitled-"+ programName);
            textArea.setText("");
            textchanged = false;
            
        }else if (!textchanged){
             setTitle("Untitled-"+ programName);
             textArea.setText("");
             textchanged = false;
         }else{
             int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to close without saving?", "Save?", JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirm == JOptionPane.NO_OPTION)
                {
                    if("".equals(filename)){
                        saveAs();
                    }else {save(filename);
                    }
                    setTitle(programName);
                    filename = ""; 
                    textArea.setText("");
                    textchanged = false; 
                } else if (confirm == JOptionPane.YES_OPTION){
                    setTitle(programName);
                textArea.setText("");
                textchanged = false;
                 }        
             }
        }        
  
    

    public void save(String filename) {
//To change body of generated methods, choose Tools | Templates.
        setTitle(programName + " " + filename);
        try {
            try (FileWriter out = new FileWriter(fn)) {
                out.write(textArea.getText());
            }

        } catch (Exception err) {
            System.err.println("Error: " + err);

        }
        textchanged = false;
        Save.setEnabled(false);

    }

    public void saveAs() {
        FileDialog fd;
        fd = new FileDialog(AwareFirstInterface.this, "Save", FileDialog.SAVE);
        fd.show();
        if (fd.getFile() != null) {

            fn = fd.getFile();
            dir = fd.getDirectory();
            filename = dir + fn + " .txt";

            setTitle(filename);
            try {
                DataOutputStream d;
                d = new DataOutputStream(new FileOutputStream(filename));
                holdText = textArea.getText();
                BufferedReader br = new BufferedReader(new StringReader(holdText));
                while ((holdText = br.readLine()) != null) {
                    d.writeBytes(holdText + "\r\n");
                    d.close();
                }

            } catch (Exception e) {
                System.out.println("Error!! File not found");

            }
            textArea.requestFocus();

        }

    }
    private void minimiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimiseMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimiseMouseClicked

    private void LoopCautionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoopCautionActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_LoopCautionActionPerformed

    private void PlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayMouseClicked
        mc.Resume();
    }//GEN-LAST:event_PlayMouseClicked

    private void chooseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseMouseClicked
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");

        JFileChooser chooser = new JFileChooser("C:\\Users\\Ayeni jeremiah\\Music\\");
        chooser.addChoosableFileFilter(filter);

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            mc.Stop();

            File myfile = chooser.getSelectedFile();
            String song = myfile + "";

            String name = chooser.getSelectedFile().getName();
            Display.setText(name);

            mc.play(song);

        }
    }//GEN-LAST:event_chooseMouseClicked

    private void repeatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repeatMouseClicked
        switch (count) {
            case 0:
                count = 1;
                LoopCaution.setVisible(true);
                LoopCaution.setText("Repeat On");
                break;

            case 1:
                count = 0;
                LoopCaution.setVisible(false);

                break;
        }
    }//GEN-LAST:event_repeatMouseClicked

    private void DisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DisplayActionPerformed

    private void stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseClicked
        mc.Stop();
    }//GEN-LAST:event_stopMouseClicked

    private void pauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseMouseClicked
        mc.Pause();
    }//GEN-LAST:event_pauseMouseClicked

    private void openMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openMouseClicked
        if (textArea.getText().length() < 1) {
            FileDialog fd = new FileDialog(this, "choose file", FileDialog.LOAD);
            fd.show();
            if (fd.getFile() != null) {
                fileName = fd.getDirectory() + fd.getFile();
                setTitle(fileName);
                try {
                    checkfile();
                } catch (IOException ex) {
                    Logger.getLogger(AwareFirstInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            textArea.requestFocusInWindow();
        } else if (!textchanged) {
            FileDialog fd = new FileDialog(this, "Choose File", FileDialog.LOAD);
            fd.show();
            if (fd.getFile() != null) {
                fileName = fd.getDirectory() + fd.getFile();
                setTitle(fileName);
                try {
                    checkfile();
                } catch (IOException ex) {
                    Logger.getLogger(AwareFirstInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            textArea.requestFocus();
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to save changes to this?", "Save Changes", JOptionPane.YES_NO_CANCEL_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if ("".equals(filename)) {
                    saveAs();
                } else {
                    save(filename);
                }
                FileDialog fd = new FileDialog(this, "Choose File", FileDialog.LOAD);
                fd.show();

            }

        }
    }//GEN-LAST:event_openMouseClicked

    private void NewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewMouseClicked
        Newfile();
    }//GEN-LAST:event_NewMouseClicked

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        if (filename.equals(""))
            saveAs();
        else 
            save(filename); 
    }//GEN-LAST:event_SaveActionPerformed

    private void SaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveAsActionPerformed
        saveAs();
    }//GEN-LAST:event_SaveAsActionPerformed

    private void FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FindActionPerformed

    private void textAreaVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_textAreaVetoableChange
        if (TextEvent.TEXT_VALUE_CHANGED !=0)
        {
            if (!textchanged)
                setTitle("*  " + getTitle()); 
            textchanged = true; 
            Save.setEnabled(true);
        
        }
    }//GEN-LAST:event_textAreaVetoableChange

    private void textAreaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textAreaPropertyChange
       if (TextEvent.TEXT_VALUE_CHANGED !=0)
        {
            if (!textchanged)
                setTitle("*  " + getTitle()); 
            textchanged = true; 
            Save.setEnabled(true);
        
        }
    }//GEN-LAST:event_textAreaPropertyChange

    private void ColourPaletteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColourPaletteActionPerformed
        Color c = ColorChooser.showDialog(open, dir, Color.getColor(fn));
        textArea.setForeground(c);
    }//GEN-LAST:event_ColourPaletteActionPerformed

    private void textAreaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textAreaMouseReleased
      //  jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        
    }//GEN-LAST:event_textAreaMouseReleased

    private void textAreaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textAreaMousePressed
       jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_textAreaMousePressed

    private void textAreaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textAreaMouseEntered
      //  jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_textAreaMouseEntered

    private void textAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textAreaMouseClicked
   //  jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_textAreaMouseClicked

    private void CopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyActionPerformed
        textArea.copy();
    }//GEN-LAST:event_CopyActionPerformed

    private void fontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontActionPerformed
        final JFrame f = new JFrame("FontChooser Startup");
    final FontChooser2 fc = new FontChooser2(f);
    final Container cp = f.getContentPane();
    cp.setLayout(new GridLayout(0, 1)); // one vertical column

    JButton theButton = new JButton("Change font");
    cp.add(theButton);

    final JLabel theLabel = new JLabel("Java is great!", JLabel.CENTER);
    cp.add(theLabel);

    // Now that theButton and theLabel are ready, make the action listener
    theButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setVisible(true);
        Font myNewFont = fc.getSelectedFont();
        System.out.println("You chose " + myNewFont);
        theLabel.setFont(myNewFont);
        f.pack(); // adjust for new size
        fc.dispose();
      }
    });

    f.setSize(150, 100);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
 
    }//GEN-LAST:event_fontActionPerformed

    private void SavePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavePActionPerformed
         if (filename.equals(""))
            saveAs();
        else 
            save(filename); 
    }//GEN-LAST:event_SavePActionPerformed

    private void ColorPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorPActionPerformed
        Color c = ColorChooser.showDialog(open, dir, Color.getColor(fn));
        textArea.setForeground(c);
    }//GEN-LAST:event_ColorPActionPerformed

    private void ImagesImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImagesImpActionPerformed
       JLabel jlab = new JLabel(); 
       //create file chooser
            JFileChooser jf = new JFileChooser(); 
        //show open dialog 
            if (jf.showOpenDialog(ImagesImp) == JFileChooser.APPROVE_OPTION)
                {
        //file selection 
            java.io.File f = jf.getSelectedFile();
        //set icon for image 
            jlab.setIcon(new ImageIcon(f.toString()));
        //jlab.setBounds(0, 0, 160, 170);
            jlab.setHorizontalAlignment(JLabel.CENTER);           
           // jScrollPane1.getViewport().add(jlab);
           // jScrollPane1.setVisible(true); 
 //          textAre
          // jScrollPane1.setSize(xmouse, ymouse);
           //jScrollPane1.getViewport().add(jlab);
              }
    }//GEN-LAST:event_ImagesImpActionPerformed

    private void DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateActionPerformed
       
    }//GEN-LAST:event_DateActionPerformed

    private void PasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteActionPerformed
       textArea.paste();
    }//GEN-LAST:event_PasteActionPerformed

    private void UndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoActionPerformed
        
        try {
            undo.undo();
        } catch (CannotRedoException cre) {
        }
          
    }//GEN-LAST:event_UndoActionPerformed

    private void CutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutActionPerformed
        textArea.cut();
    }//GEN-LAST:event_CutActionPerformed

   
    
    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        try { 
            textArea.print();
        } catch (PrinterException ex) {
            Logger.getLogger(AwareFirstInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PrintActionPerformed

    private void RedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedoActionPerformed

        try {
            undo.redo();
        } catch (CannotRedoException cre) {
        }
 
    }//GEN-LAST:event_RedoActionPerformed

    private void SelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectAllActionPerformed
        textArea.selectAll();
    }//GEN-LAST:event_SelectAllActionPerformed

    private void textAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyTyped
     
    }//GEN-LAST:event_textAreaKeyTyped

    private void textAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_Z)
       {  try {
            undo.undo();
        } catch (CannotRedoException cre) {
        }} 
        else if (evt.getKeyCode() == KeyEvent.VK_Y)
        {
            try {
            undo.redo();
        } catch (CannotRedoException cre) {
        }
        
        }
       // if (evt.getKeyCode() == KeyEvent.VK_C)
       
    }//GEN-LAST:event_textAreaKeyPressed

    private void FontsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FontsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FontsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AwareFirstInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AwareFirstInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AwareFirstInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AwareFirstInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AwareFirstInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                new AwareFirstInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JColorChooser ColorChooser;
    private javax.swing.JMenuItem ColorP;
    private javax.swing.JButton ColourPalette;
    private javax.swing.JMenuItem Copy;
    private javax.swing.JMenuItem Cut;
    private javax.swing.JMenuItem Date;
    private javax.swing.JTextField Display;
    private javax.swing.JButton Find;
    private javax.swing.JMenuItem Fonts;
    private javax.swing.JMenu Format;
    private javax.swing.JMenuItem ImagesImp;
    private javax.swing.JMenu Import;
    private javax.swing.JTextField LoopCaution;
    private javax.swing.JLabel New;
    private javax.swing.JMenuItem Paste;
    private javax.swing.JLabel Play;
    private javax.swing.JButton Print;
    private javax.swing.JMenuItem Redo;
    private javax.swing.JButton Save;
    private javax.swing.JButton SaveAs;
    private javax.swing.JMenuItem SaveP;
    private javax.swing.JMenuItem SelectAll;
    private javax.swing.JMenuItem Undo;
    private javax.swing.JLabel background;
    private javax.swing.JLabel choose;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel facebook;
    private javax.swing.JButton font;
    private javax.swing.JLabel home;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JLabel minimise;
    private javax.swing.JLabel movable;
    private javax.swing.JLabel open;
    private javax.swing.JLabel pause;
    private javax.swing.JLabel recent;
    private javax.swing.JLabel repeat;
    private javax.swing.JLabel stop;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel twitter;
    private javax.swing.JLabel wordpress;
    // End of variables declaration//GEN-END:variables


    class FontChooser2 extends JDialog {

  // Results:

  /** The font the user has chosen */
  protected Font resultFont;

  /** The resulting font name */
  protected String resultName;

  /** The resulting font size */
  protected int resultSize;

  /** The resulting boldness */
  protected boolean isBold;

  /** The resulting italicness */
  protected boolean isItalic;

  // Working fields

  /** Display text */
  protected String displayText = "Qwerty Yuiop";

  /** The list of Fonts */
  protected String fontList[];

  /** The font name chooser */
  protected List fontNameChoice;

  /** The font size chooser */
  protected List fontSizeChoice;

  /** The bold and italic choosers */
  Checkbox bold, italic;

  /** The list of font sizes */
  protected String fontSizes[] = { "8", "10", "11", "12", "14", "16", "18",
      "20", "24", "30", "36", "40", "48", "60", "72" };

  /** The index of the default size (e.g., 14 point == 4) */
  protected static final int DEFAULT_SIZE = 4;

  /**
   * The display area. Use a JLabel as the AWT label doesn't always honor
   * setFont() in a timely fashion :-)
   */
  protected JLabel previewArea;

  /**
   * Construct a FontChooser -- Sets title and gets array of fonts on the
   * system. Builds a GUI to let the user choose one font at one size.
   */
  public FontChooser2(Frame f) {
    super(f, "Font Chooser", true);

    Container cp = getContentPane();

    Panel top = new Panel();
    top.setLayout(new FlowLayout());

    fontNameChoice = new List(8);
    top.add(fontNameChoice);

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    // For JDK 1.1: returns about 10 names (Serif, SansSerif, etc.)
    // fontList = toolkit.getFontList();
    // For JDK 1.2: a much longer list; most of the names that come
    // with your OS (e.g., Arial), plus the Sun/Java ones (Lucida,
    // Lucida Bright, Lucida Sans...)
    fontList = GraphicsEnvironment.getLocalGraphicsEnvironment()
        .getAvailableFontFamilyNames();

    for (int i = 0; i < fontList.length; i++)
      fontNameChoice.add(fontList[i]);
    fontNameChoice.select(0);

    fontSizeChoice = new List(8);
    top.add(fontSizeChoice);

    for (int i = 0; i < fontSizes.length; i++)
      fontSizeChoice.add(fontSizes[i]);
    fontSizeChoice.select(DEFAULT_SIZE);

    cp.add(top, BorderLayout.NORTH);

    Panel attrs = new Panel();
    top.add(attrs);
    attrs.setLayout(new GridLayout(0, 1));
    attrs.add(bold = new Checkbox("Bold", false));
    attrs.add(italic = new Checkbox("Italic", false));

    previewArea = new JLabel(displayText, JLabel.CENTER);
    previewArea.setSize(200, 50);
    cp.add(previewArea, BorderLayout.CENTER);

    Panel bot = new Panel();

    JButton okButton = new JButton("Apply");
    bot.add(okButton);
    okButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        previewFont();
        dispose();
        setVisible(false);
      }
    });

    JButton pvButton = new JButton("Preview");
    bot.add(pvButton);
    pvButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        previewFont();
      }
    });

    JButton canButton = new JButton("Cancel");
    bot.add(canButton);
    canButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Set all values to null. Better: restore previous.
        resultFont = null;
        resultName = null;
        resultSize = 0;
        isBold = false;
        isItalic = false;

        dispose();
        setVisible(false);
      }
    });

    cp.add(bot, BorderLayout.SOUTH);

    previewFont(); // ensure view is up to date!

    pack();
    setLocation(100, 100);
  }

  /**
   * Called from the action handlers to get the font info, build a font, and
   * set it.
   */
  protected void previewFont() {
    resultName = fontNameChoice.getSelectedItem();
    String resultSizeName = fontSizeChoice.getSelectedItem();
    int resultSize = Integer.parseInt(resultSizeName);
    isBold = bold.getState();
    isItalic = italic.getState();
    int attrs = Font.PLAIN;
    if (isBold)
      attrs = Font.BOLD;
    if (isItalic)
      attrs |= Font.ITALIC;
    resultFont = new Font(resultName, attrs, resultSize);
    // System.out.println("resultName = " + resultName + "; " +
    //     "resultFont = " + resultFont);
    previewArea.setFont(resultFont);
    pack(); // ensure Dialog is big enough.
  }

  /** Retrieve the selected font name. */
  public String getSelectedName() {
    return resultName;
  }

  /** Retrieve the selected size */
  public int getSelectedSize() {
    return resultSize;
  }

  /** Retrieve the selected font, or null */
  public Font getSelectedFont() {
    return resultFont;
  }

  /** Simple main program to start it running */
  public void jud () {
    final JFrame f = new JFrame("FontChooser Startup");
    final FontChooser2 fc = new FontChooser2(f);
    final Container cp = f.getContentPane();
    cp.setLayout(new GridLayout(0, 1)); // one vertical column

    JButton theButton = new JButton("Change font");
    cp.add(theButton);

    final JLabel theLabel = new JLabel("Java is great!", JLabel.CENTER);
    cp.add(theLabel);

    // Now that theButton and theLabel are ready, make the action listener
    theButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setVisible(true);
        Font myNewFont = fc.getSelectedFont();
        System.out.println("You chose " + myNewFont);
        theLabel.setFont(myNewFont);
        f.pack(); // adjust for new size
        fc.dispose();
      }
    });

    f.setSize(150, 100);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}

}

