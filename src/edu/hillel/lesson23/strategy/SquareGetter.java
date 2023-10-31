package edu.hillel.lesson23.strategy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SquareGetter {
    private SquareStrategy squareStrategy;

    public double getSquare(int a){
        if(squareStrategy==null){
            throw new RuntimeException("Square strategy hasn't set");
        }
        return squareStrategy.getSquare(a);
    }
}
