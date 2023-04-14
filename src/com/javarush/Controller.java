package com.javarush;

import com.javarush.model.Model;

public class Controller {
    private Model model = new Model();

    public void init(){
        while(true) {
            int command = View.printConsoleAndReadCommand();
            if (command==3) return;

            switch (command) {
                case 1:
                    model.addTask(View.selectOperationType(), View.enterNums());
                    break;
                case 2:
                    model.execute();
                default:
                    View.printWrongCommand();
            }
        }
    }
}
