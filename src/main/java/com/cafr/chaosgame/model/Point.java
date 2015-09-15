/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafr.chaosgame.model;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author User
 */
public class Point extends Canvas{
    
    private int x;
    private int y;
    private Color color;
    private static final int WIDTH = 4;
    private static final int HEIGHT = 4;
    
    public Point(int x,int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
            
    @Override
    public void paint(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        g2.setColor(color);
        g2.fillOval(x, y, WIDTH, WIDTH);
    }
    
}
