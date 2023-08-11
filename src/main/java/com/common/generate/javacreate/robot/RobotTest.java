package com.common.generate.javacreate.robot;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * @author xialei
 * @date 2023/6/16 17:25
 */
public class RobotTest {

    //先定义Robot机器人类
    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws Exception {
        minimizeAllTheWindows();

        robot.mouseMove(951, 64);//此处的作用是移动鼠标到某一坐标点（移动到自己桌面QQ的位置）
        robot.delay(100);//延迟一秒
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);//单机鼠标右键
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);//松开右键

        robot.delay(2000);//延迟两秒
        robot.mouseMove(972, 70);//移动鼠标坐标到打开的位置
        robot.delay(100);//延迟1秒
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);//单机鼠标左键
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);//松开左键
        setClipboardString("今天天气好");
        paste();
    }


    public static void minimizeAllTheWindows() {
        robot.keyPress(KeyEvent.VK_WINDOWS);//这一步是用机器人类按下键盘WINDOW+M跳转到桌面
        robot.keyPress(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_WINDOWS);//松开键盘今天天气好WINDOW键
        robot.delay(1000);//此处延迟一秒给下一步缓冲的时间（括号里是以毫秒计算单位的）
    }

    /**
     * 把文本设置到剪贴板（复制）
     */
    public static void setClipboardString(String text) {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 封装文本内容
        Transferable trans = new StringSelection(text);
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);
    }

    /**
     * 从剪贴板中获取文本（粘贴）
     */
    public static String getClipboardString() {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 获取剪贴板中的内容
        Transferable trans = clipboard.getContents(null);
        if (trans != null) {
            // 判断剪贴板中的内容是否支持文本
            if (trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    // 获取剪贴板中的文本内容
                    String text = (String) trans.getTransferData(DataFlavor.stringFlavor);
                    return text;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void paste() {
        //按下control+v
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(500);
        //释放control+v
        robot.keyRelease(KeyEvent.VK_CONTROL);//下面输入自己的密码
        robot.keyRelease(KeyEvent.VK_V);//下面输入自己的密码
    }


    public static void testPress(Robot robot) {
        robot.delay(2000);//延迟两秒给QQ缓冲的时间
        robot.keyPress(KeyEvent.VK_F);//下面输入自己的密码
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_U);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_C);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_K);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_0);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_0);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_0);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_0);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);//按下回车键
        robot.keyRelease(KeyEvent.VK_ENTER);//松开回车键
    }
}
