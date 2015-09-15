/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafr.chaosgame.controller;

import com.cafr.chaosgame.model.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author User
 */
public class Controller extends Observable{
        
    private LinkedList<Point> points ;
    private Point origen;
    private Point[] triangle = new Point[3];
    private int iterations;

    public Controller() {        
        origen = new Point(-1, -1, Color.GREEN);
        points = new LinkedList<>();              
        iterations = 0;
        triangle[0] = new Point(100, 10, Color.yellow);
        triangle[1] = new Point(300, 10, Color.blue);
        triangle[2] = new Point(200, 250 , Color.red);        
    }
    
    public void setOrigen(int x, int y){
        origen = new Point(x, y, Color.GREEN);
        setChanged();
        notifyObservers(origen);
        System.out.println(origen.getX()+" "+origen.getY()+" "+origen.getColor());
    }
    
    public void setPoint(Point p){
        points.add(p);
        setChanged();
        notifyObservers(p);
    }
    
    public void addObservers(Observer o){
        this.addObserver(o);
    }

    public void setIterations(String num){
        iterations = Integer.parseInt(num);
    }

    public LinkedList<Point> getPoints() {
        return points;
    }

    public Point getOrigen() {
        return origen;
    }

    public Point[] getTriangle() {
        return triangle;
    }
    
    public void playGame(){
        //System.out.println("Play Game");
        clearGame();
        HashMap<Integer,Integer>hash = new HashMap<>();
        hash.put(0, 0);hash.put(1, 0);
        hash.put(2, 1);hash.put(3, 1);
        hash.put(4, 2);hash.put(5, 2);
        points.add(origen);
        for(int i=0;i<iterations;i++){
            int dice = (int)(Math.random()*100)%6;
            dice = hash.get(dice);
            Point initSeg = points.getLast();
            Point endSeg = triangle[dice];
            Point midSeg = new Point((initSeg.getX()+endSeg.getX())/2, 
                    (initSeg.getY()+endSeg.getY())/2, Color.BLACK);            
            points.addLast(midSeg);
            setChanged();
            notifyObservers(midSeg);
            System.out.println(i+" "+dice);
        }
        //System.out.println("end");
        
    }
    
    public void clearGame(){
        for(Point p : points){
            p.setColor(Color.WHITE);
            setChanged();
            notifyObservers(p);
        }
        points = new LinkedList<>();      
        //iterations = 0;        
        for(Point p: triangle){
            setChanged();
            notifyObservers(p);
        }
        setChanged();
        notifyObservers(origen);
    }

    public void paintTriangle(Graphics graphics) {
        for(Point p:triangle){
            p.paint(graphics);
            //System.out.println(p.getColor());
        }
    }
    
}
