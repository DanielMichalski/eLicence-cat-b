package test.main;

import ui.login.view.LoginFrame;

import javax.swing.*;

/**
 * Author: Daniel
 * Date: 25.11.13.
 */
public class LoginTest {
    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame(true);
        loginFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        loginFrame.setVisible(true);
    }
}
