package oop.graphics.Elements;

import oop.graphics.ButtonListeners.*;
import oop.graphics.Buttons.*;
import oop.petriNet.PetriNet;


import java.awt.*;
import java.awt.event.*;

public class ApplicationFrame extends Frame {

    private ApplicationCanvas canvas;
    private PetriNet net = new PetriNet();


    public ApplicationFrame(){
        setLayout(new BorderLayout());
        addWindowListener(
                new WindowAdapter(){
                    public void windowClosing (WindowEvent e){
                        dispose(); System.exit(0);
                    }
                }
        );
        setSize(700,400);

        canvas = new ApplicationCanvas();

        Panel buttonPanel = new Panel();

        ImportBtn importBtn = new ImportBtn("Import");
        AddPlaceBtn addPlaceBtn = new AddPlaceBtn("Add Place");
        AddTransitionBtn addTransitionBtn = new AddTransitionBtn("Add Transition");
        AddEdgeBtn addEdgeBtn = new AddEdgeBtn("Add edge");
        TokenBtn tokenBtn = new TokenBtn("Tokens");
        DeleteButton deleteButton = new DeleteButton("Delete");
        RunBtn runBtn = new RunBtn("Run");


        importBtn.addActionListener(new ImportListener(canvas,net));
        addPlaceBtn.addActionListener(new AddPlaceListener(canvas,net));
        addTransitionBtn.addActionListener(new AddTransitionListener(canvas,net));
        addEdgeBtn.addActionListener(new AddEdgeListener(canvas,net));
        tokenBtn.addActionListener(new ChangeTokenListener(canvas,net));
        deleteButton.addActionListener(new DeleteListener(canvas,net));
        runBtn.addActionListener(new RunListener(canvas,net));

        buttonPanel.add(importBtn);
        buttonPanel.add(addPlaceBtn);
        buttonPanel.add(addTransitionBtn);
        buttonPanel.add(addEdgeBtn);
        buttonPanel.add(tokenBtn);
        buttonPanel.add(deleteButton);
        buttonPanel.add(runBtn);



        setBackground(new Color(255, 255, 255));
        setLayout(new BorderLayout());
        add(canvas,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.NORTH);
        setVisible(true);

    }

}