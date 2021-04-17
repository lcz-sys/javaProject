package com.t05;

public class Teacher {

    public void checkScore(int score) throws ScoreException {
        if(score<0 || score>100){
            throw new ScoreException("输入的分数有误，分数应该在0到100之间");
        }else {
            System.out.println("分数正常");
        }
    }

}
