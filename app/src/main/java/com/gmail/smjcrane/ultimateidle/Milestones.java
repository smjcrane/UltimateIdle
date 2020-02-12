package com.gmail.smjcrane.ultimateidle;

public class Milestones {

    public static Fact[] milestones = new Fact[]{
            new Fact(new int[] {0}, ""),
            new Fact(new int[] {7}, "continents in the world"),
            new Fact(new int[] {2,6}, "letters in the English alphabet"),
            new Fact(new int[] {1,9,5}, "countries in the world"),
            new Fact(new int[] {5,6,2}, "people who have been into space"),
            new Fact(new int[] {1,5,0,0}, "volcanoes in the world"),
            new Fact(new int[] {4,2,0,0}, "religions in the world"),
            new Fact(new int[] {6,6,0,0}, "languages in the world"),
            new Fact(new int[] {2,0,0,0,0}, "episodes of the TV programme Unser Sandmännchen"),
            new Fact(new int[] {4,0,0,0,0}, "gold courses in the world"),
            new Fact(new int[] {1,5,0,0,0,0}, "hairs on the average person's head"),
            new Fact(new int[] {2,5,5,1,6,8}, "possible games of tic tac toe" ),
            new Fact(new int[] {8,7,0,0,0,0,0}, "species in the world"),
            new Fact(new int[] {2,4,8,6,2,0,4,8}, "digits in the largest known prime"),
            new Fact(new int[] {3,1,5,3,6,0,0,0}, "seconds in a year"),
            new Fact(new int[] {6,3,8,7,3,1,5,6}, "km of road in the world"),
            new Fact(new int[] {1,4,5,0,0,0,0,0,0}, "books ever written"),
            new Fact(new int[] {6,0,0,0,0,0,0,0,0}, "cats in the world"),
            new Fact(new int[] {1,5,0,0,0,0,0,0,0,0}, "websites on the internet"),
            new Fact(new int[] {3,5,0,0,0,0,0,0,0,0}, "fish in the world"),
            new Fact(new int[] {4,5,4,3,0,0,0,0,0,0}, "years the world has existed for"),
            new Fact(new int[] {7,8,0,0,0,0,0,0,0,0}, "people in the world"),
            new Fact(new int[] {1,3,8,2,0,0,0,0,0,0,0}, "years the universe has existed for"),
            new Fact(new int[] {3,0,0,0,0,0,0,0,0,0,0,0}, "emails sent worldwide in a day"),
            new Fact(new int[] {4,0,0,0,0,0,0,0,0,0,0,0}, "birds in the world"),
            new Fact(new int[] {3,0,4,1,0,0,0,0,0,0,0,0,0}, "trees in the world"),
            new Fact(new int[] {3,7,2,0,0,0,0,0,0,0,0,0,0,0}, "cells in a human body"),
            new Fact(new int[] {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, "ants in the world"),
            new Fact(new int[] {9,2,2,3,3,7,2,0,3,6,8,5,4,7,7,5,8,0,8}, "positive values a java long can take"),
            new Fact(new int[] {4,3,2,5,2,0,0,3,2,7,4,4,8,9,8,5,6,0,0,0}, "ways to rearrange a Rubik's cube"),
            new Fact(new int[] {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, "stars in the universe"),
            new Fact(new int[] {4,3,3,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, "molecules of water in the world's oceans"),
            new Fact(new int[] {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, "atoms in the universe")
    };

    public static class Fact{
        int[] digits;
        String description;

        public Fact(int[] digits, String description){
            this.digits = digits;
            this.description = description;
        }
    }
}
